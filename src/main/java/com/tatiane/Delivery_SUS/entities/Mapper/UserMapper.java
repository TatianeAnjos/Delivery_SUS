package com.tatiane.Delivery_SUS.entities.Mapper;

import org.springframework.stereotype.Component;

import com.tatiane.Delivery_SUS.entities.User;
import com.tatiane.Delivery_SUS.entities.Dto.UserDto;

@Component
public class UserMapper {

	public User mapear(UserDto obj) {
		User user = new User();
		user.setEmail(obj.getEmail());
		user.setName(obj.getEmail());
		user.setPassword(obj.getPassword());
		user.setPhone(obj.getPhone());
		return user;
	}
	

}
