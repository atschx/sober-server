package com.atschx.adnetwork.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OfferController extends AbstractController {

	// 分页获取Offer
	@RequestMapping(value = "/offers", method = { RequestMethod.GET })
	String offers() {
		return "offers";
	}

}
