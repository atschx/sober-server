package com.atschx.adnetwork.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferApplyController extends AdNetworkController {
	
	/**
	 * 显示流量主申请的offer列表。
	 * @return
	 */
	@RequestMapping("/offer-apply-list")
	ResponseEntity<String> list(){
		
		return null;
	}
	
	

}
