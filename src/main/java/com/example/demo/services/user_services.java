package com.example.demo.services;

import java.util.List;

import com.example.demo.payload.user_payload;

public interface user_services {
 user_payload addusers(user_payload up);
 user_payload upadateUser(user_payload up,int id);
		 void deleteusers(int id);
 List<user_payload>getalUsers();
 user_payload getusersbyid(int id);
 
 
}