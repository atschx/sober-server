package com.atschx.adnetwork.domain;

public interface AdNetwork {

	/**
	 * 投放平台
	 */
	enum Platform {
		IOS, ANDROID
		
		//pc端 wap站 安卓 ios 安卓平板 ios平板
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
	enum PriceModel {

		CPS("Cost Per Sale"), CPA("Cost Per Action");

		private String description;

		private PriceModel(String description) {
			this.description = description;
		}

		public String getDescription() {
			return description;
		}

	}

}
