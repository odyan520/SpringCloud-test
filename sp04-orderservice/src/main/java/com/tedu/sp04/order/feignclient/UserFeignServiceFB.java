package com.tedu.sp04.order.feignclient;

import org.springframework.stereotype.Component;

import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;
@Component
public class UserFeignServiceFB implements UserFeignService {

	@Override
	public JsonResult<User> getUser(Integer userId) {
		if(Math.random()<0.4) {
			return JsonResult.ok(new User(userId, "缓存name"+userId, "缓存pwd"+userId));
		}
		return JsonResult.err("获取用户信息失败");
	}

	@Override
	public JsonResult addScore(Integer userId, Integer score) {
		return JsonResult.err("增加用户积分失败");
	}

}
