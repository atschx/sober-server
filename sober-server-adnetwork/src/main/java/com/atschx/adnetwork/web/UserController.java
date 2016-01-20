package com.atschx.adnetwork.web;

import javax.servlet.ServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.UserRepository;

@RestController
public class UserController extends AdNetworkController {

	private final UserRepository soberUserRepository;

	@Autowired
	public UserController(UserRepository soberUserRepository) {
		this.soberUserRepository = soberUserRepository;
	}

	/**
	 * 查询广告主.
	 * 
	 * @param page
	 * @param size
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/advertisers", method = { RequestMethod.GET })
	public String advertisers(
			@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			ServletRequest request) {
		
		//获取请求中的参数信息
		

		// 统一处理查询条件
		//
		// * @param status
		// * @param manager
		// * @param name

		return "";
	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public Page<User> users(
			@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(value = "role", defaultValue = "") String role) {

		if ("".equals(role)) {
			return soberUserRepository.findAll(pageable);
		}

		return soberUserRepository.findByRoleCode(role, pageable);
	}

}
