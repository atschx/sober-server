package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.Offer;
import com.atschx.adnetwork.domain.repository.OfferRepository;
import com.atschx.adnetwork.mapper.JsonMapper;
import com.atschx.adnetwork.protocol.Result;

@RestController
public class OfferController extends AdNetworkController {

	private final OfferRepository offerRepository;

	@Autowired
	public OfferController(OfferRepository offerRepository) {
		this.offerRepository = offerRepository;
	}

	/**
	 * 分页获取Offer
	 * @param pageable
	 * @param owner
	 * @param status
	 * @return
	 */
	@RequestMapping(value = "/offers", method = { RequestMethod.GET })
	Page<Offer> offers(@PageableDefault(value = 15, sort = { "id" }, direction = Sort.Direction.DESC) Pageable pageable,
			@RequestParam(value = "owner",required=false) Long owner,
			@RequestParam(value = "status",required=false) Byte status) {

		if (null != owner) {
			return offerRepository.findByCreatedBy(pageable,owner);
		}

		return offerRepository.findAll(pageable);
	}
	
	
	/**
	 * 获取offer详情
	 */
	@RequestMapping(value = "/offer", method = { RequestMethod.GET })
	public Offer offerDetail(
//			@RequestHeader String uid,
			@RequestParam Long offerId){
		
		return offerRepository.findOne(offerId);
	}
	
	
	/**
	 * 创建offer
	 */
	@RequestMapping(value = "/offer", method = { RequestMethod.PUT })
	public Result createOffer(
			@RequestHeader String uid,
			@RequestBody String json){
		
		//讲json转为Offer对象
		JsonMapper jsonMapper=JsonMapper.nonEmptyMapper();
		Offer offer = jsonMapper.fromJson(json, Offer.class);
		offerRepository.save(offer);
		
		return new Result();
	}
	
}
