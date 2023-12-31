package com.example.demo.payload;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class user_payload {
	private int id;
	@Column(name = "username",nullable =  false,length = 40)
	@NotEmpty
	private String name;
	@Email
	private String email;
	@Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	@Column(length = 15)
	@Size(min = 5,max = 15)
	private String password;
	
}