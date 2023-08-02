package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception_handling.ApiResponse;
import com.example.demo.models.users;
import com.example.demo.payload.user_payload;
import com.example.demo.services.user_services;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/v1")
public class user_controller {
@Autowired
user_services service;
@PostMapping("/insert")
public ResponseEntity<user_payload>addusers(@Valid @RequestBody user_payload up){
user_payload users=this.service.addusers(up);
return new ResponseEntity<>(users,HttpStatus.CREATED);
}
@PutMapping("/update/{id}")
public ResponseEntity<user_payload>updateusers(@Valid @PathVariable int id,@RequestBody user_payload up ){
	user_payload users = this.service.upadateUser(up, id);
	return ResponseEntity.ok(users);
}
@DeleteMapping("/delete/{id}")
 public ResponseEntity<ApiResponse>deleteusers(@Valid @PathVariable int id ){
	  this.service.deleteusers(id);
	  return new ResponseEntity<ApiResponse>(new ApiResponse("id deleted was successfully",true),HttpStatus.OK);
  }
@GetMapping("/getalUsers")
public ResponseEntity<List<user_payload>>getalusers(){
	return ResponseEntity.ok(this.service.getalUsers());
}
@GetMapping("/getUsersbyid/{id}")
public ResponseEntity<user_payload> getusersbyid(@Valid @PathVariable  int id){
	return ResponseEntity.ok(this.service.getusersbyid(id));
}
}


