/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.api.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductActivity;
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductConfig;
import com.thinkgem.jeesite.modules.zm.service.ZmkjProductActivityService;
import com.thinkgem.jeesite.modules.zm.service.ZmkjProductConfigService;


/**
 * 测试Controller
 * @author zm
 * @version 2017-5-2
 */
//
@Controller
@RequestMapping(value = "${frontPath}/zm/api")
public class ApiController extends BaseController {
	
	@Autowired
	private ZmkjProductActivityService zmkjProductActivityService;
	
	@Autowired
	private ZmkjProductConfigService zmkjProductConfigService;

	@RequestMapping(value = "getData", method=RequestMethod.GET)
	@ResponseBody
	public String getData() {
		return "truetest";
	}
	
	//"text/plain;charset=UTF-8"
	@RequestMapping(value = "userEvent", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public Object userEvent(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "clientId") String clientId,
			@RequestParam(value = "productName") String productName,
			@RequestParam(value = "technologyPlatform") String technologyPlatform,
			@RequestParam(value = "os") String os,
			@RequestParam(value = "version") String version,
			@RequestParam(value = "eventName") String eventName) {
		 Map<String,Object> resMap=new HashMap<String, Object>();
         resMap.put("code",1);
		if(eventName == "start-up"){
			ZmkjProductActivity zmkjProductActivity = new ZmkjProductActivity();
			zmkjProductActivity.setUserid(userId);
			zmkjProductActivity.setClientid(clientId);
			zmkjProductActivity.setName(productName);
			zmkjProductActivity.setTechnologyPlatform(technologyPlatform);
			zmkjProductActivity.setOs(os);
			zmkjProductActivity.setVersion(version);
			zmkjProductActivity.setEventName(eventName);
			zmkjProductActivityService.save(zmkjProductActivity);
		} 
		else //check-for-updates
		{
			ZmkjProductConfig zmkjProductConfig = new ZmkjProductConfig(); 
			zmkjProductConfig.setName(productName);
			zmkjProductConfig.setTechnologyPlatform(technologyPlatform);
			zmkjProductConfig.setVersion(version);
			List<ZmkjProductConfig> zmkjProductConfigList =  zmkjProductConfigService.findList(zmkjProductConfig);
			if(zmkjProductConfigList.size() > 0){
				resMap.put("insPackageAddress","地址："+zmkjProductConfigList.get(0).getDownAddress());
			} else {
				resMap.put("insPackageAddress","已是最新版本!");
			}
			
		}
		
		//MAC IP HOSTNAME OTHERINFO
		
         
		return resMap;
	}
}
