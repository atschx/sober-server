package com.atschx.adnetwork.domain;

public interface AdNetwork {

	/**
	 * 投放平台
	 */
	enum Platform {
		IOS, ANDROID
	}

	/**
	 * 结算周期
	 */
	enum ClearingCycle {
		DAY, WEEK, MONTH
	}

	/**
	 * 计费方式
	 */
	enum OfferPriceModel {

		CPS("Cost Per Sale"), CPA("Cost Per Action");

		private String description;

		private OfferPriceModel(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

	}

}
