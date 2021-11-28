package com.tatiane.Delivery_SUS.services;

import java.text.DecimalFormat;
import java.time.Instant;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tatiane.Delivery_SUS.entities.Order;
import com.tatiane.Delivery_SUS.entities.OrderItem;
import com.tatiane.Delivery_SUS.entities.Dto.DadosBuscaEnderecoDto;
import com.tatiane.Delivery_SUS.entities.Dto.ResumoPedidoDto;
import com.tatiane.Delivery_SUS.entities.Mapper.OrderMapper;
import com.tatiane.Delivery_SUS.entities.enums.OrderStatus;
import com.tatiane.Delivery_SUS.repositories.OrderItemRepository;
import com.tatiane.Delivery_SUS.repositories.OrderRepository;
import com.tatiane.Delivery_SUS.repositories.UserRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private OrderMapper mapper;
	
	@Autowired
	private MapsService mapsService;
	
	@Autowired 
	private UserRepository userRepo;
	
	public List<ResumoPedidoDto> findAll(){
		List<ResumoPedidoDto> dto = mapper.mapear(repository.findAll());
		
		return dto;
	}
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
	@Transactional
	public Order insert(@Valid Order obj) {
		obj.setMoment(Instant.now());
		obj.setOrderStatus(OrderStatus.PAGAMENTO_PENDENTE);
		obj.setClient(userRepo.findById(obj.getClient().getId()).orElseThrow());
		repository.save(obj);
		for (OrderItem item : obj.getItems()) {
			item.setProduct(productService.findById(item.getProduct().getId()));
			item.setOrder(obj);
			item.setQuantidade(item.getQuantidade());
		}
		orderItemRepository.saveAll(obj.getItems());
		return obj;
	}
	
	public List<ResumoPedidoDto> findByStatus(Integer status) {
		List<ResumoPedidoDto> orders = mapper.mapear(repository.findByStatus(status));
		return orders;
	}
	
	public ResumoPedidoDto atualizarStatus(Integer status, Long id) {
		Order order = findById(id);
		order.setOrderStatus(OrderStatus.valueOf(status));		
		return mapper.mapear(repository.save(order));
	}
	
	public String  CalcularTaxaEntrega(Long id, String token) {
		DecimalFormat df = new DecimalFormat("#,###.00");

		double valorPorKm = 5.0;
		Order order = findById(id);
		Locale.setDefault(Locale.US);
		DadosBuscaEnderecoDto dados = mapsService.buscarDadosEndereco(order.getClient().getEnderecos().get(0).getLogradouro(),
				order.getClient().getEnderecos().get(0).getCidade(), 
				order.getClient().getEnderecos().get(0).getEstado(),
				token);
		Locale.setDefault(Locale.US);
		String x1 = dados.getResultadoBuscaEnderecoDto().get(0).getGeometry().getLocation().getLat();
		Locale.setDefault(Locale.US);
		String y1 = dados.getResultadoBuscaEnderecoDto().get(0).getGeometry().getLocation().getLng();
		Locale.setDefault(Locale.US);
		double x2 = -23.604132;
		Locale.setDefault(Locale.US);
		double y2 = -46.654295;
		
		//realizando calculo distancia	
		double distancia = mapsService.CalcularDistancia(Double.parseDouble(x1),Double.parseDouble(y1),x2, y2);

		return "R$ " + df.format(distancia * valorPorKm);
		
	}

}
