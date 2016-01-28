package com.atschx.adnetwork.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.atschx.adnetwork.domain.model.Offer;
import com.atschx.adnetwork.protocol.Result;
import com.atschx.adnetwork.protocol.response.ApplyResult;
import com.atschx.adnetwork.service.OfferManagementService;

/**
 * offer管理接口
 */
@RestController
public class OfferMgntController {

	private final OfferManagementService offerManagementService;

	@Autowired
	public OfferMgntController(OfferManagementService offerManagementService) {
		this.offerManagementService = offerManagementService;
	}

	/**
	 * 广告主创建offer.
	 * 
	 * @param advertiserId
	 * @param offer
	 *            json结构
	 * @return
	 */
	@RequestMapping(value = "/offer", method = { RequestMethod.POST }, consumes = { "application/json; charset=UTF-8" })
	public Result createOffer(
			@RequestParam("advertiser") Long advertiserId, 
			@RequestBody Offer offer) {

		return offerManagementService.createOffer(advertiserId, offer);
	}

	/**
	 * 流量主申请offer
	 * 
	 * @param publisher 流量主Id
	 * @param offer offer的id
	 * @return
	 */
	@RequestMapping(value = "/apply-offer", method = { RequestMethod.POST })
	public ApplyResult applyOffer(
			@RequestParam("publisher") Long publisherId, 
			@RequestParam("offer") Long offerId) {

		return offerManagementService.applyOffer(publisherId, offerId);

	}

	/**
	 * 管理员通过申请
	 */
}
