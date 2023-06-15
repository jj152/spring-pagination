package com.example.demo;

import javax.persistence.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity(name = "user")
public class UserEntity {
	
	@Id
	String user;
    String username;
    String password;

}
