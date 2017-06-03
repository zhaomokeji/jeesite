/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductConfig;
import com.thinkgem.jeesite.modules.zm.service.ZmkjProductConfigService;

/**
 * 产品配置Controller
 * @author firemail
 * @version 2017-06-03
 */
@Controller
@RequestMapping(value = "${adminPath}/zm/zmkjProductConfig")
public class ZmkjProductConfigController extends BaseController {

	@Autowired
	private ZmkjProductConfigService zmkjProductConfigService;
	
	@ModelAttribute
	public ZmkjProductConfig get(@RequestParam(required=false) String id) {
		ZmkjProductConfig entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zmkjProductConfigService.get(id);
		}
		if (entity == null){
			entity = new ZmkjProductConfig();
		}
		return entity;
	}
	
	@RequiresPermissions("zm:zmkjProductConfig:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZmkjProductConfig zmkjProductConfig, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZmkjProductConfig> page = zmkjProductConfigService.findPage(new Page<ZmkjProductConfig>(request, response), zmkjProductConfig); 
		model.addAttribute("page", page);
		return "modules/zm/zmkjProductConfigList";
	}

	@RequiresPermissions("zm:zmkjProductConfig:view")
	@RequestMapping(value = "form")
	public String form(ZmkjProductConfig zmkjProductConfig, Model model) {
		model.addAttribute("zmkjProductConfig", zmkjProductConfig);
		return "modules/zm/zmkjProductConfigForm";
	}

	@RequiresPermissions("zm:zmkjProductConfig:edit")
	@RequestMapping(value = "save")
	public String save(ZmkjProductConfig zmkjProductConfig, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zmkjProductConfig)){
			return form(zmkjProductConfig, model);
		}
		zmkjProductConfigService.save(zmkjProductConfig);
		addMessage(redirectAttributes, "保存产品配置成功");
		return "redirect:"+Global.getAdminPath()+"/zm/zmkjProductConfig/?repage";
	}
	
	@RequiresPermissions("zm:zmkjProductConfig:edit")
	@RequestMapping(value = "delete")
	public String delete(ZmkjProductConfig zmkjProductConfig, RedirectAttributes redirectAttributes) {
		zmkjProductConfigService.delete(zmkjProductConfig);
		addMessage(redirectAttributes, "删除产品配置成功");
		return "redirect:"+Global.getAdminPath()+"/zm/zmkjProductConfig/?repage";
	}

}