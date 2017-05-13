/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.api.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.web.BaseController;


/**
 * 测试Controller
 * @author zm
 * @version 2017-5-2
 */
//
@Controller
@RequestMapping(value = "${frontPath}/zm/api")
public class ApiController extends BaseController {

	@RequestMapping(value = "getData", method=RequestMethod.GET)
	@ResponseBody
	public String getData() {
		return "truetest";
	}
	
	//"text/plain;charset=UTF-8"
	@RequestMapping(value = "userEvent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object userEvent(@RequestParam(value = "userName") String username,
			@RequestParam(value = "productName") String productName,
			@RequestParam(value = "technicalScheme") String technicalScheme,
			@RequestParam(value = "eventName") String eventName) {
		//check-for-updates  "start-up"
		String ueventName = eventName;
		//MAC IP HOSTNAME OTHERINFO
		 Map<String,Object> resMap=new HashMap<String, Object>();
         resMap.put("code",1);
         resMap.put("insPackageAddress","地址："+username);
		return resMap;
	}
}
