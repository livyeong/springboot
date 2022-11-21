package com.mysite.sbb.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;			//유저 아이디
    
    @Column(unique = true)    
    private String username;  	//유저이름(유니크=중복불가)

    private String password;	//패스워드

    @Column(unique = true)
    private String email;		//이메일(중복X)
   	
}