package com.atschx.adnetwork.service;

import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atschx.adnetwork.domain.model.Token;
import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.TokenRepository;
import com.atschx.adnetwork.domain.repository.UserRepository;
import com.atschx.adnetwork.protocol.response.SignupResult;

@Service
public class AccountService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TokenRepository tokenRepository;

	@Autowired
	private MailService mailService;

	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	/**
	 * 用户注册成功之后，要求激活（通过邮箱中的用户token）
	 * 
	 * @param user
	 * @return
	 */
	@Transactional
	public SignupResult register(User user) {

		userRepository.save(user);

		final String token = UUID.fromString(user.getEmail()).toString().replace("-", "");
		tokenRepository.save(new Token(token, user.getId(), System.currentTimeMillis() + 1000 * 60 * 60 * 24));
		// 注册成功要求用户前往
		//// http://www.exoclick.com/signup-verify/?token=60025f12efde97c3afac2fdde5fb2af277608a5d
		mailService.sendMail(user.getEmail(), "schh0313@126.com", "注册成功，请激活登录",
				"您可以点击这里：http://localhost:8080/signup-verify/?token=" + token);

		return new SignupResult(user.getId());
	}
	
	public User active(String token){
		Token tokenObj = tokenRepository.getOne(token);
		User user = null;
		if(null!=tokenObj){
			user = userRepository.findOne(tokenObj.getUid());
			user.setStatus((byte)1);//设置用户状态为激活 active
			userRepository.saveAndFlush(user);
		}
		return user;
	}

}
