package com.mysite.sbb.user;

import lombok.Getter;

//이넘은 상수들의 모음
@Getter
public enum UserRole {
	ADMIN("ROLE_ADMIN"), USER("ROLE_USER");

	private String value;

	UserRole(String value) {
		this.value = value;
	}

}