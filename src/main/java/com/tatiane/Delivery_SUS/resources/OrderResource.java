package com.tatiane.Delivery_SUS.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.tatiane.Delivery_SUS.entities.Order;
import com.tatiane.Delivery_SUS.entities.Dto.ResumoPedidoDto;
import com.tatiane.Delivery_SUS.services.OrderService;

@RestController
@RequestMapping(value ="/orders")
public class OrderResource {
	private final Logger log = LogManager.getLogger();

	@Autowired
	private OrderService service;
	
	@GetMapping
	public ResponseEntity<List<ResumoPedidoDto>> findAll(){
		
		List<ResumoPedidoDto> listOrders = service.findAll();
		return ResponseEntity.ok().body(listOrders);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Order>findById(@PathVariable Long id){
		log.info("|01| PEDIDOS: BUSCA POR ID {} ", id);
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
		
	@RequestMapping(method= RequestMethod.POST)
	public ResponseEntity <Void> insert (@Valid @RequestBody Order obj){
		log.info("|01| PEDIDOS: CRIAR PEDIDO {} ", obj);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping(value = "/buscar-por-status")
	public ResponseEntity<List<ResumoPedidoDto>> findByStatus(@RequestParam Integer status){
		log.info("|01| PEDIDOS: BUSCAR POR STATUS {} ", status);
		List<ResumoPedidoDto> obj = service.findByStatus(status);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping("/atualizar-status")
	public ResponseEntity<ResumoPedidoDto> atualizarStatus(@RequestParam Integer status,@RequestParam Long id){
		log.info("|01| PEDIDOS: ATUALIZAR PARA STATUS {} ", status);
		ResumoPedidoDto dto = service.atualizarStatus(status,id);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(method= RequestMethod.GET,value = "/calcular-taxa-entrega")
	public ResponseEntity <String> calcularTaxaEntrega(@RequestParam Long id,@RequestParam String token){
		log.info("|01| PEDIDOS: CALCULAR TAXA DE ENTREGA {} ", id);
		String valorTaxa = service.CalcularTaxaEntrega(id,token);
		return ResponseEntity.ok().body(valorTaxa);
	}

}