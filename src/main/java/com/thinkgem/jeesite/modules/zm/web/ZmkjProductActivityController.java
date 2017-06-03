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
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductActivity;
import com.thinkgem.jeesite.modules.zm.service.ZmkjProductActivityService;

/**
 * 活跃度统计Controller
 * @author firemail
 * @version 2017-06-03
 */
@Controller
@RequestMapping(value = "${adminPath}/zm/zmkjProductActivity")
public class ZmkjProductActivityController extends BaseController {

	@Autowired
	private ZmkjProductActivityService zmkjProductActivityService;
	
	@ModelAttribute
	public ZmkjProductActivity get(@RequestParam(required=false) String id) {
		ZmkjProductActivity entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = zmkjProductActivityService.get(id);
		}
		if (entity == null){
			entity = new ZmkjProductActivity();
		}
		return entity;
	}
	
	@RequiresPermissions("zm:zmkjProductActivity:view")
	@RequestMapping(value = {"list", ""})
	public String list(ZmkjProductActivity zmkjProductActivity, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<ZmkjProductActivity> page = zmkjProductActivityService.findPage(new Page<ZmkjProductActivity>(request, response), zmkjProductActivity); 
		model.addAttribute("page", page);
		return "modules/zm/zmkjProductActivityList";
	}

	@RequiresPermissions("zm:zmkjProductActivity:view")
	@RequestMapping(value = "form")
	public String form(ZmkjProductActivity zmkjProductActivity, Model model) {
		model.addAttribute("zmkjProductActivity", zmkjProductActivity);
		return "modules/zm/zmkjProductActivityForm";
	}

	@RequiresPermissions("zm:zmkjProductActivity:edit")
	@RequestMapping(value = "save")
	public String save(ZmkjProductActivity zmkjProductActivity, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, zmkjProductActivity)){
			return form(zmkjProductActivity, model);
		}
		zmkjProductActivityService.save(zmkjProductActivity);
		addMessage(redirectAttributes, "保存活跃度成功");
		return "redirect:"+Global.getAdminPath()+"/zm/zmkjProductActivity/?repage";
	}
	
	@RequiresPermissions("zm:zmkjProductActivity:edit")
	@RequestMapping(value = "delete")
	public String delete(ZmkjProductActivity zmkjProductActivity, RedirectAttributes redirectAttributes) {
		zmkjProductActivityService.delete(zmkjProductActivity);
		addMessage(redirectAttributes, "删除活跃度成功");
		return "redirect:"+Global.getAdminPath()+"/zm/zmkjProductActivity/?repage";
	}

}