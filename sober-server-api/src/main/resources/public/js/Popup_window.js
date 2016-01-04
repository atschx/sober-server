// JavaScript Document

 $(function(){
//添加微信钱包
	$(".add_weixin_wallet").click(function(){
		$(".msg_weixin_bandding").css("display","block");
	});
	$(".msg_Shut").click(function(){
		$(".msg_weixin_bandding").css("display","none");	
		});
	$(".weixin_process_img").click(function(){
		$(".msg_weixin_process_con").css("display","block");	
		var mySwiper = new Swiper('.swiper-container',{
		slidesPerView: "auto",
		//Enable Scrollbar
		scrollbar: {
		  container: '.swiper-scrollbar',
		  hide: false,
		  draggable: true,
		  snapOnRelease: true  
		}
		})

			$(".msg_weixin_bandding").css("display","none");
		});
		$(".msg_Shut_process_img").click(function(){
			$(".msg_weixin_process_con").css("display","none");	
			$(".msg_weixin_bandding").css("display","block");
			});
//添加支付宝
	$(".add_zfb_bandding").click(function(){
		$(".msg_zfb_bandding").css("display","block");
	});
	$(".msg_Shut").click(function(){
		$(".msg_zfb_bandding").css("display","none");	
		});
//支付宝确定提交提示
	$(".msg_zfb_submit").click(function(){
		$(".msg_zfb_add_ok").css("display","block");
		$(".msg_zfb_bandding").css("display","none");
		$(".msg_weixin_bandding").css("display","none");	
		});	
	$(".msg_Shut_know").click(function(){
		$(".msg_zfb_add_ok").css("display","none");	
		});
//支付宝实名认证	
	$(".certification").click(function(){
		$(".msg_zfb_certification").css("display","block");
		$(".msg_zfb_bandding").css("display","none");
	});	
	$(".msg_Shut_certification").click(function(){
		$(".msg_zfb_certification").css("display","none");
		$(".msg_zfb_bandding").css("display","block");
	});	
	
//缴纳个税
	$(".certification_gs").click(function(){
		$(".msg_gs_certification").css("display","block");
		$(".msg_sf_authentication,.msg_zfb_bandding").css("display","none");
	});	
	$("#msg_gs .msg_Shut_certification").click(function(){
		$(".msg_gs_certification,.msg_zfb_bandding").css("display","none");
		$(".msg_sf_authentication").css("display","block");
	});
	
//修改帐户
	$(".add_Modify_bandding").click(function(){
			$(".Modify_account_ok").css("display","block");
		});	
	$(".Shut_Modify_bandding").click(function(){
		$(".Modify_account_ok").css("display","none");
	});	

//加密码
	$(".msg_Add_encryption").click(function(){
		$(".msg_encryption").css("display","block");
		$(".msg_unencrypted").css("display","none");
	});	
	$(".msg_encryption_submit").click(function(){
		$(".msg_encryption_ok").css("display","block");
		$(".msg_encryption").css("display","none");
		});
	$(".msg_Shut_encryption").click(function(){
		$(".msg_encryption").css("display","none");
	});
	$(".msg_encryption_know").click(function(){
		$(".msg_encryption_ok").css("display","none");
	});
//删除密码
	$(".msg_Remove_password").click(function(){
			$(".msg_Remove_password_fc").css("display","block");
			$(".msg_forget_con").css("display","none");
		});
	$(".msg_Shut_Remove").click(function(){
			$(".msg_Remove_password_fc").css("display","none");
			$(".countdown_info").css("display","block");
		});
		
		//
		/*****提现*****/
		//
		
		//弹出输入密码
	$(".T_withdrawals_determine").click(function(){
			$(".msg_forget_con").css("display","block");
		});
		$(".msg_Shut_cancel").click(function(){
			$(".msg_Remove_password_fc").css("display","none");
		});
//删除密码
	$(".msg_Remove_password").click(function(){
			$(".msg_Remove_password_fc").css("display","block");
			$(".msg_forget_con").css("display","none");
		});
	$(".msg_Shut_Remove").click(function(){
			$(".msg_Remove_password_fc").css("display","none");
			$(".countdown_info").css("display","block");
		});
//还没加加密
	$(".msg_unencrypted_fc").click(function(){
			$(".msg_unencrypted").css("display","block");
		});
		$(".msg_Shut_cancel").click(function(){
			$(".msg_unencrypted").css("display","none");
		});
		
//

/******收入查询**********/
//
//提现提示不满10元
	$(".msg_conditions_ts").click(function(){
			$(".msg_problem_C").css("display","block");
		});
		$(".problem_Shut_know").click(function(){
			$(".msg_problem_C").css("display","none");
		});
//申请提现 下拉层
	$(".apply_withdrawals").click(function(){
			$(".drop_down_window").addClass('drop_down_window_open');
			$(".drop_down_window_h").css("display","block");
		});
	$(".tixian_WeChat,.tixian_zfb,.drop_down_cancel").click(function(){
			$(".drop_down_window").removeClass('drop_down_window_open');
			$(".drop_down_window_h").css("display","none");
		});
//绑定手机号发送验证码
	$(".send").click(function(){
			$(this).addClass('remaining');
	  });
});	
