package com.atschx.adnetwork.async;

import java.util.concurrent.Callable;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class AsyncSendEmailTask implements Callable<Void> {
	
	private final JavaMailSender mailSender;
	private final SimpleMailMessage mailMessage;

	public AsyncSendEmailTask(JavaMailSender mailSender, SimpleMailMessage mailMessage) {
		this.mailSender = mailSender;
		this.mailMessage = mailMessage;
	}

	@Override
	public Void call() throws Exception {
		
		try {
			mailSender.send(mailMessage);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

}
