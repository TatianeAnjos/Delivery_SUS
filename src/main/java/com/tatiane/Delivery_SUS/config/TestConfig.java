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
@Profile("test")
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
		
		Product p1 = new Product(null, "Loratamed", "10 comprimidos", ""); 
		Product p2 = new Product(null, "Edroxizina", "30 comprimidos", ""); 
		Product p3 = new Product(null, "Nimesulida", "12 comprimidos", ""); 
		Product p4 = new Product(null, "Ibuprofeno", "20 comprimidos", ""); 
		Product p5 = new Product(null, "Cimegripe", "20 cápsulas", ""); 
		Product p6 = new Product(null, "Paracetamol", "20 comprimidos", "");
		Product p7 = new Product(null, "Dorflex", "50 comprimidos", "");
		Product p8 = new Product(null, "Advil", "3 cápsulas", "");
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID,u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT,u1);
		
		Endereco e1 = new Endereco(null, "Rua flores", "300", "São Paulo", "Jardim", u1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105","São Paulo", "Flores", u2);


		u1.getEnderecos().add(e1);
		u2.getEnderecos().add(e2);
		
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
		
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8));

		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1,o2,o3));
		
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2); 
		OrderItem oi2 = new OrderItem(o1, p3, 1); 
		OrderItem oi3 = new OrderItem(o2, p3, 2); 
		OrderItem oi4 = new OrderItem(o3, p5, 2); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1,oi2,oi3,oi4));
				
		orderRepository.save(o1);
		
		Entregador en1 = new Entregador(null, "Bruno Alves", "bruno@gmail.com", "987989865", "123456");

		entregadorRepository.save(en1);
		
	}
}	