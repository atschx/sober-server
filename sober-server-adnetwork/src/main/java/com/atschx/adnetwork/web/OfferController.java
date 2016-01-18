package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.Offer;
import com.atschx.adnetwork.domain.repository.OfferRepository;

@RestController
public class OfferController extends AdNetworkController {
	
	@Autowired
	OfferRepository offerRepository;

	// 分页获取Offer
	@RequestMapping(value = "/offers", method = { RequestMethod.GET })
	Page<Offer> offers(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(value = "name", defaultValue = "") String name) {
		
		return offerRepository.findAll(pageable);
	}

}
