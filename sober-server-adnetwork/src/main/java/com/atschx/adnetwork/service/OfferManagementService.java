package com.atschx.adnetwork.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atschx.adnetwork.domain.model.Offer;
import com.atschx.adnetwork.domain.model.PublisherWithOffer;
import com.atschx.adnetwork.domain.model.User;
import com.atschx.adnetwork.domain.repository.OfferRepository;
import com.atschx.adnetwork.domain.repository.PublisherWithOfferRepository;
import com.atschx.adnetwork.domain.repository.UserRepository;
import com.atschx.adnetwork.protocol.Result;
import com.atschx.adnetwork.protocol.response.ApplyResult;

@Service
public class OfferManagementService {

	private final UserRepository userRepository;
	private final OfferRepository offerRepository;
	private final PublisherWithOfferRepository publisherWithOfferRepository;

	@Autowired
	public OfferManagementService(UserRepository userRepository, OfferRepository offerRepository,
			PublisherWithOfferRepository publisherWithOfferRepository) {
		this.userRepository = userRepository;
		this.offerRepository = offerRepository;
		this.publisherWithOfferRepository = publisherWithOfferRepository;
	}
	//~~ 广告主相关
	//1.创建广告 pending
	public Result createOffer(Long advertiserId,Offer offer){
		User advertiser = userRepository.findOne(advertiserId);
		
		offer.setCreatedBy(advertiser);
		offer.setLastModifiedBy(advertiser);
		offer.setLastModifiedDate(new Date());
		offer.setCreatedDate(new Date());
		
		offerRepository.save(offer);
		return new Result();
	}
	
	//2.

	//~~ 流量主相关
	
	/**
	 * 流量主申请offer
	 * 
	 * @param publisherId
	 * @param offerId
	 */
	@Transactional
	public ApplyResult applyOffer(Long publisherId, Long offerId) {
		
		ApplyResult applyResult = new ApplyResult();
		
		User publisher = userRepository.findOne(publisherId);
		Offer offer = offerRepository.findOne(offerId);

		if (offer.getStatus() == (byte) 1) {
			PublisherWithOffer publisherWithOffer = new PublisherWithOffer();
			publisherWithOffer.setOffer(offer);
			publisherWithOffer.setPublisher(publisher);
			publisherWithOffer.setLastModifiedBy(publisher);
			publisherWithOffer.setLastModifiedDate(new Date());
			publisherWithOfferRepository.save(publisherWithOffer);
			applyResult.setAid(publisherWithOffer.getId());
		}else{
			applyResult.setRet("1");
		}
		
		return applyResult;

	}
	
	//~~ 3.管理员相关
	//通过流量主审核
	//驳回流量主审核
	//停用流量主审核的某个offer
	
	//通过广告主创建的offer
	//驳回广告主创建的offer
	//下架广告主创建的offer
	
	

}
