package com.example.demo.services.imp;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception_handling.ResourceNotFoundException;
import com.example.demo.models.users;
import com.example.demo.payload.user_payload;
import com.example.demo.repository.user_repository;
import com.example.demo.services.user_services;
@Service
public class user_services_imp implements user_services {
	@Autowired
	user_repository repo;
	@Autowired
	ModelMapper modelMapper;
	@Override
	public user_payload addusers(user_payload up) {
		users us=this.dto_users(up);
		users saveusers =this.repo.save(us);
		return this.users_dto(saveusers);
	}
	@Override
	public user_payload upadateUser(user_payload up, int id) {
		users us = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
		us.setName(up.getName());
		us.setEmail(up.getEmail());
		us.setPassword(up.getPassword());
		users us1=this.repo.save(us);
		user_payload userpayload =this.users_dto(us1);
		return userpayload;
	} 
	@Override
	public void deleteusers(int id) {
		users us = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
         this.repo.delete(us);
	}
	@Override
	public List<user_payload> getalUsers() {
		List<users> us=(List<users>) this.repo.findAll();
		List<user_payload> users=us.stream().map(user ->this.users_dto(user)).collect(Collectors.toList());
		return users;
	}
	@Override
	public user_payload getusersbyid(int id) {
		users us = this.repo.findById(id).orElseThrow(()-> new ResourceNotFoundException("users","id",id));
        return this.users_dto(us);
		
	}	
	public users dto_users (user_payload userp) {
		users users = this.modelMapper.map(userp,users.class);
		return users;
				
	}
		
	public user_payload users_dto  (users usp) {
		user_payload userpayload = this.modelMapper.map(usp,user_payload.class);
		return userpayload;

}
}
