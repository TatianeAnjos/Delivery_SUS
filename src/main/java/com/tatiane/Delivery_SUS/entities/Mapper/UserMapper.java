package com.tatiane.Delivery_SUS.entities.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tatiane.Delivery_SUS.entities.User;
import com.tatiane.Delivery_SUS.entities.Dto.UserDto;
import com.tatiane.Delivery_SUS.entities.Dto.UserResumoDto;

@Component
public class UserMapper {

	public User mapear(UserDto obj) {
		User user = new User();
		user.setEmail(obj.getEmail());
		user.setName(obj.getName());
		user.setPassword(obj.getPassword());
		user.setPhone(obj.getPhone());
		return user;
	}
	
	public UserResumoDto mapear(User user) {
		UserResumoDto dto = new UserResumoDto();
		dto.setEmail(user.getEmail());
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setPhone(user.getPhone());
		dto.setOrders(user.getOrders());
		dto.setEnderecos(user.getEnderecos());
		
		return dto;
	}
	
	public List<UserResumoDto> mapear(List<User> users) {
		List<UserResumoDto> lsUsersResumo = new ArrayList<>();
		users.forEach(user ->{
			lsUsersResumo.add(mapear(user));
		});
		return lsUsersResumo;		
	}

}
