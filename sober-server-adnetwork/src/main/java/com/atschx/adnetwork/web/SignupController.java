package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.protocol.response.SignupResult;
import com.atschx.adnetwork.service.SignupService;

@RestController
public class SignupController {

	@Autowired
	SignupService signupService;
	
	
	//检查email是否唯一：
//	  /**
//	   * Ajax请求校验loginName是否唯一。
//	   */
//	  @RequestMapping(value = "checkEmail")
//	  @ResponseBody
//	  public String checkEmail(@RequestParam("email") String email) {
//	    logger.debug("前端传入登录名称:" + loginName);
//	    if (accountService.findUserByLoginName(loginName) == null) {
//	      return "true";
//	    } else {
//	      return "false";
//	    }
//	  }

	//http://www.exoclick.com/signup-verify/?token=60025f12efde97c3afac2fdde5fb2af277608a5d
	//https://www.exoclick.com/signup-verify/?token=60025f12efde97c3afac2fdde5fb2af277608a5d
	@RequestMapping(value = "signup", method = { RequestMethod.POST })
	SignupResult signup(User user) {
		
		//注册用户：
		//user.
		
		
		

		return signupService.signup(user);
		
		
		

	}

}
