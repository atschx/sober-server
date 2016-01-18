package com.atschx.adnetwork.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.atschx.adnetwork.async.AsyncSendEmailTask;

/**
 * 统一邮件发送服务
 */
@Component
public class MailService {

	private static final ExecutorService MAIL_SERVICE_POOL = Executors.newFixedThreadPool(10);

	private final JavaMailSender mailSender;

	@Autowired
	public MailService(JavaMailSender mailSender) {
		super();
		this.mailSender = mailSender;
	}

	/**
	 * 简单类邮件公共方法。
	 * 
	 * @param to
	 * @param from
	 * @param subject
	 * @param content
	 */
	public void sendMail(String to, String from, String subject, String content) {

		final SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(content);
		mailSender.send(mailMessage);

		MAIL_SERVICE_POOL.submit(new AsyncSendEmailTask(mailSender, mailMessage));
	}
}
