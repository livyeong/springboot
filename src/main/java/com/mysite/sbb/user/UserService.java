package com.mysite.sbb.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mysite.sbb.DataNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder passEncoder; // 암호화 객체 주입

	// 새 유저를 생성
	public void create(String username, String email, String password) {
		SiteUser user = new SiteUser();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(passEncoder.encode(password)); // 패스워드 암호화해 저장
		this.userRepo.save(user); // 새 유저 저장
	}

	// 유저이름으로 유저정보를 검색(시큐리티의 principal에 유저이름이 저장됨)
	public SiteUser getUser(String username) {
		Optional<SiteUser> siteUser = this.userRepo.findByUsername(username);
		if (siteUser.isPresent()) {
			return siteUser.get();
		} else {
			throw new DataNotFoundException("siteuser not found");
		}
	}

}