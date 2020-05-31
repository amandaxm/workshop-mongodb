package com.workshop.course.resource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.course.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	//get para obter informações
	@RequestMapping(method =RequestMethod.GET)
	public ResponseEntity<List<User>> findAll(){
		
		User maria= new User(1, "mari", "maria@@");
		User maria2= new User(1, "mari2", "maria@@2");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria,maria2));
		return ResponseEntity.ok(list);//retornar com sucesso os itens da lista
	}
}
