package com.tatiane.Delivery_SUS.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tatiane.Delivery_SUS.entities.Category;
import com.tatiane.Delivery_SUS.entities.Endereco;
import com.tatiane.Delivery_SUS.entities.Entregador;
import com.tatiane.Delivery_SUS.entities.Order;
import com.tatiane.Delivery_SUS.entities.OrderItem;
import com.tatiane.Delivery_SUS.entities.Product;
import com.tatiane.Delivery_SUS.entities.User;
import com.tatiane.Delivery_SUS.entities.enums.OrderStatus;
import com.tatiane.Delivery_SUS.repositories.CategoryRepository;
import com.tatiane.Delivery_SUS.repositories.EnderecoRepository;
import com.tatiane.Delivery_SUS.repositories.EntregadorRepository;
import com.tatiane.Delivery_SUS.repositories.OrderItemRepository;
import com.tatiane.Delivery_SUS.repositories.OrderRepository;
import com.tatiane.Delivery_SUS.repositories.ProductRepository;
import com.tatiane.Delivery_SUS.repositories.UserRepository;

@Configuration
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private EntregadorRepository entregadorRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Alergia e infecções");
		Category cat2 = new Category(null, "Anti-inflamatórios");
		Category cat3 = new Category(null, "Gripe e Resfriado");
		Category cat4 = new Category(null, "Dor e Febre");
		
		Product p1 = new Product(null, "Loratamed", "10 comprimidos - indicado ao alívio dos sintomas da rinite alérgica, como coceira nasal, coriza, espirros, ardor e coceira nos olhos", "https://img.drogaraia.com.br/catalog/product/l/o/loratamed_10mg_12_comprimidos_cimed.jpg?width=520&height=520&quality=50&type=resize"); 
		Product p2 = new Product(null, "Edroxizina", "30 comprimidos - indicado para alivio do prurido causado por condições alérgicas da pele", "https://static.tuasaude.com/media/article/db/da/hidroxizina_22277_l.jpg"); 
		Product p3 = new Product(null, "Nimesulida", "12 comprimidos - para controlar dores leves a moderadas, combater inflamação e baixar a febre", "https://static.tuasaude.com/media/article/rb/lu/nimesulida_16204_l.jpg"); 
		Product p4 = new Product(null, "Ibuprofeno", "20 comprimidos - age contra inflamações não tão intensas, sendo comumente indicado contra febre e dores diversas", "https://www.drogariaminasbrasil.com.br/media/catalog/product/9/9/99098.jpg"); 
		Product p5 = new Product(null, "Cimegripe", "20 cápsulas - indicado no tratamento dos sintomas de gripes e resfriados", "https://www.drogariaminasbrasil.com.br/media/product/aba/cimegripe-com-20-capsulas-01b.jpg"); 
		Product p6 = new Product(null, "Paracetamol", "20 comprimidos - tratar dores leves ou moderadas, febre e pode ser associado a outros medicamentos com efeito analgésico, antitérmico, antialérgico ou estimulante", "https://drogariasp.vteximg.com.br/arquivos/ids/452272-1000-1000/12327---paracetamol-750mg-generico-4-comprimidos.jpg?v=637559207486030000");
		Product p7 = new Product(null, "Dorflex", "50 comprimidos - age na dor e relaxa a tensão muscular", "https://www.drogariaminasbrasil.com.br/media/product/6ae/analgesico-dorflex-36-comprimidos-cbb.jpg");
		Product p8 = new Product(null, "Advil", "3 cápsulas - indicado no alívio temporário da febre e de dores de leve a moderada intensidade", "https://www.farmadelivery.com.br/media/catalog/product/cache/1/image/720x/9df78eab33525d08d6e5fb8d27136e95/a/d/advil-mulher-400mg-c-10-capsulas-liquidas-2.jpg");
		Product p9 = new Product(null, "Loratamed", "10 comprimidos - indicado ao alívio dos sintomas da rinite alérgica, como coceira nasal, coriza, espirros, ardor e coceira nos olhos", "https://img.drogaraia.com.br/catalog/product/l/o/loratamed_10mg_12_comprimidos_cimed.jpg?width=520&height=520&quality=50&type=resize"); 
		Product p10 = new Product(null, "Edroxizina", "30 comprimidos - indicado para alivio do prurido causado por condições alérgicas da pele", "https://static.tuasaude.com/media/article/db/da/hidroxizina_22277_l.jpg"); 
		Product p11 = new Product(null, "Nimesulida", "12 comprimidos - para controlar dores leves a moderadas, combater inflamação e baixar a febre", "https://static.tuasaude.com/media/article/rb/lu/nimesulida_16204_l.jpg"); 
		Product p12 = new Product(null, "Ibuprofeno", "20 comprimidos - age contra inflamações não tão intensas, sendo comumente indicado contra febre e dores diversas", "https://www.drogariaminasbrasil.com.br/media/catalog/product/9/9/99098.jpg"); 
		Product p13 = new Product(null, "Cimegripe", "20 cápsulas - indicado no tratamento dos sintomas de gripes e resfriados", "https://www.drogariaminasbrasil.com.br/media/product/aba/cimegripe-com-20-capsulas-01b.jpg"); 
		Product p14 = new Product(null, "Paracetamol", "20 comprimidos - tratar dores leves ou moderadas, febre e pode ser associado a outros medicamentos com efeito analgésico, antitérmico, antialérgico ou estimulante", "https://drogariasp.vteximg.com.br/arquivos/ids/452272-1000-1000/12327---paracetamol-750mg-generico-4-comprimidos.jpg?v=637559207486030000");
		Product p15 = new Product(null, "Dorflex", "50 comprimidos - age na dor e relaxa a tensão muscular", "https://www.drogariaminasbrasil.com.br/media/product/6ae/analgesico-dorflex-36-comprimidos-cbb.jpg");
		Product p16 = new Product(null, "Advil", "3 cápsulas - indicado no alívio temporário da febre e de dores de leve a moderada intensidade", "https://www.farmadelivery.com.br/media/catalog/product/cache/1/image/720x/9df78eab33525d08d6e5fb8d27136e95/a/d/advil-mulher-400mg-c-10-capsulas-liquidas-2.jpg");
		Product p17 = new Product(null, "Loratamed", "10 comprimidos - indicado ao alívio dos sintomas da rinite alérgica, como coceira nasal, coriza, espirros, ardor e coceira nos olhos", "https://img.drogaraia.com.br/catalog/product/l/o/loratamed_10mg_12_comprimidos_cimed.jpg?width=520&height=520&quality=50&type=resize"); 
		Product p18 = new Product(null, "Edroxizina", "30 comprimidos - indicado para alivio do prurido causado por condições alérgicas da pele", "https://static.tuasaude.com/media/article/db/da/hidroxizina_22277_l.jpg"); 
		Product p19 = new Product(null, "Nimesulida", "12 comprimidos - para controlar dores leves a moderadas, combater inflamação e baixar a febre", "https://static.tuasaude.com/media/article/rb/lu/nimesulida_16204_l.jpg"); 
		Product p20 = new Product(null, "Ibuprofeno", "20 comprimidos - age contra inflamações não tão intensas, sendo comumente indicado contra febre e dores diversas", "https://www.drogariaminasbrasil.com.br/media/catalog/product/9/9/99098.jpg"); 
		Product p21 = new Product(null, "Cimegripe", "20 cápsulas - indicado no tratamento dos sintomas de gripes e resfriados", "https://www.drogariaminasbrasil.com.br/media/product/aba/cimegripe-com-20-capsulas-01b.jpg"); 
		Product p22 = new Product(null, "Paracetamol", "20 comprimidos - tratar dores leves ou moderadas, febre e pode ser associado a outros medicamentos com efeito analgésico, antitérmico, antialérgico ou estimulante", "https://drogariasp.vteximg.com.br/arquivos/ids/452272-1000-1000/12327---paracetamol-750mg-generico-4-comprimidos.jpg?v=637559207486030000");
		Product p23 = new Product(null, "Dorflex", "50 comprimidos - age na dor e relaxa a tensão muscular", "https://www.drogariaminasbrasil.com.br/media/product/6ae/analgesico-dorflex-36-comprimidos-cbb.jpg");
		Product p24 = new Product(null, "Advil", "3 cápsulas - indicado no alívio temporário da febre e de dores de leve a moderada intensidade", "https://www.farmadelivery.com.br/media/catalog/product/cache/1/image/720x/9df78eab33525d08d6e5fb8d27136e95/a/d/advil-mulher-400mg-c-10-capsulas-liquidas-2.jpg");
		Product p25 = new Product(null, "Loratamed", "10 comprimidos - indicado ao alívio dos sintomas da rinite alérgica, como coceira nasal, coriza, espirros, ardor e coceira nos olhos", "https://img.drogaraia.com.br/catalog/product/l/o/loratamed_10mg_12_comprimidos_cimed.jpg?width=520&height=520&quality=50&type=resize"); 
		Product p26 = new Product(null, "Loratamed", "10 comprimidos - indicado ao alívio dos sintomas da rinite alérgica, como coceira nasal, coriza, espirros, ardor e coceira nos olhos", "https://img.drogaraia.com.br/catalog/product/l/o/loratamed_10mg_12_comprimidos_cimed.jpg?width=520&height=520&quality=50&type=resize"); 

		User u1 = new User(null, "Maria da Silva", "maria@gmail.com", "11997524168", "123456");
		User u2 = new User(null, "Alex Goncalves", "alex@gmail.com", "11995802356", "123456");
		User u3 = new User(null, "Ana Pereira", "ana@gmail.com", "11997524168", "123456");
		User u4 = new User(null, "Amanda Nascimento", "amanda@gmail.com", "11995802356", "123456");
		User u5 = new User(null, "Maria das Dores", "maria1@gmail.com", "11997524168", "123456");
		User u6 = new User(null, "Conceição silva", "conceicao@gmail.com", "11995802356", "123456");
		User u7 = new User(null, "Reinaldo Abreu", "rei@gmail.com", "11997524168", "123456");
		User u8 = new User(null, "Lucas Do Nascimento", "lu@gmail.com", "11995802356", "123456");
		
		Order o1 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"),OrderStatus.PAGO,u1); 
		Order o2 = new Order(null, Instant.parse("2021-07-21T03:42:10Z"),OrderStatus.PAGO, u2); 
		Order o3 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"),OrderStatus.PAGO,u3);
		Order o4 = new Order(null, Instant.parse("2021-06-25T19:53:07Z"),OrderStatus.PAGO,u5); 

		Order o5 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"),OrderStatus.PAGO,u1); 
		Order o6 = new Order(null, Instant.parse("2021-07-21T03:42:10Z"),OrderStatus.PAGO, u4); 
		Order o7 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"),OrderStatus.PAGO,u8);
		Order o8 = new Order(null, Instant.parse("2021-06-25T19:53:07Z"),OrderStatus.PAGO,u7); 
		

		Order o9 = new Order(null, Instant.parse("2021-06-20T19:53:07Z"),OrderStatus.PAGO,u1); 
		Order o10 = new Order(null, Instant.parse("2021-07-21T03:42:10Z"),OrderStatus.PAGO, u6); 
		Order o11 = new Order(null, Instant.parse("2021-07-22T15:21:22Z"),OrderStatus.PAGO,u8);
		Order o12 = new Order(null, Instant.parse("2021-06-25T19:53:07Z"),OrderStatus.PAGO,u3); 
		
		
		Endereco e1 = new Endereco(null, "Rua Pirituba", "300", "São Paulo", "SP", "Vila da Saude", u1);
		Endereco e2 = new Endereco(null, "Rua Estrada Antiga do Mar", "105","São Paulo", "SP","Americanopolis", u2);

		Endereco e3 = new Endereco(null, "Rua Tagipuru", "50", "São Paulo", "SP", "Barra Funda", u3);
		Endereco e4 = new Endereco(null, "Rua Alexandre Dumas", "105","São Paulo", "SP","Santo Amaro", u4);

		Endereco e5 = new Endereco(null, "Rua Américo Brasiliense", "300", "São Paulo", "SP", "Chacara Santo Antonio", u5);
		Endereco e6 = new Endereco(null, "Rua Jose de Camargo", "105","São Paulo", "SP","Chacara Inglesa", u6);

		Endereco e7 = new Endereco(null, "Rua Pirituba", "300", "São Paulo", "SP", "Vila da Saude", u7);
		Endereco e8 = new Endereco(null, "Rua Jose de Camargo", "105","São Paulo", "SP","Chacara Inglesa", u8);


		u1.getEnderecos().add(e1);
		u2.getEnderecos().add(e2);
		u3.getEnderecos().add(e3);
		u4.getEnderecos().add(e4);
		u5.getEnderecos().add(e5);
		u6.getEnderecos().add(e6);
		u7.getEnderecos().add(e7);
		u8.getEnderecos().add(e8);
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2,cat3,cat4));
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));
		
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat2);
		p4.getCategories().add(cat2);
		p5.getCategories().add(cat3);
		p6.getCategories().add(cat3);
		p7.getCategories().add(cat4);
		p8.getCategories().add(cat4);
		p9.getCategories().add(cat1);
		p10.getCategories().add(cat1);
		p11.getCategories().add(cat2);
		p12.getCategories().add(cat2);
		p13.getCategories().add(cat3);
		p14.getCategories().add(cat3);
		p15.getCategories().add(cat4);
		p16.getCategories().add(cat4);
		p17.getCategories().add(cat1);
		p18.getCategories().add(cat1);
		p19.getCategories().add(cat2);
		p20.getCategories().add(cat2);
		p21.getCategories().add(cat3);
		p22.getCategories().add(cat3);
		p23.getCategories().add(cat4);
		p24.getCategories().add(cat4);
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26));

		userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6,u7,u8));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o11,o12));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3,e4,e5,e6,e7,e8));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2); 
		OrderItem oi2 = new OrderItem(o1, p3, 1); 
		OrderItem oi3 = new OrderItem(o2, p3, 2); 
		OrderItem oi4 = new OrderItem(o3, p5, 2); 

		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
				
		orderRepository.saveAll(Arrays.asList(o1,o2,o3,o4,o5,o6,o7,o8,o9,o10,o11,o12));
		
		Entregador en1 = new Entregador(null, "Bruno Alves", "bruno@gmail.com", "987989865", "123456");

		entregadorRepository.save(en1);
		
	}
}	