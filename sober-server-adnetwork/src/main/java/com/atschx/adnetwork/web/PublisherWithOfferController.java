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

import com.atschx.adnetwork.domain.model.PublisherWithOffer;
import com.atschx.adnetwork.domain.repository.PublisherWithOfferRepository;

@RestController
public class PublisherWithOfferController {

	private final PublisherWithOfferRepository publisherWithOfferRepository;

	@Autowired
	public PublisherWithOfferController(PublisherWithOfferRepository publisherWithOfferRepository) {
		this.publisherWithOfferRepository = publisherWithOfferRepository;
	}

	/**
	 * 查看流量主申请的offer
	 * 
	 * @param pageable
	 * @param publisher
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/publisher-apply-offers", method = { RequestMethod.GET })
	Page<PublisherWithOffer> list(
			@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(value = "publisher",required=false) Long publisher,
			@RequestParam(value = "status",required=false) Byte status) {
		return publisherWithOfferRepository.findAll(pageable);
	}

}
