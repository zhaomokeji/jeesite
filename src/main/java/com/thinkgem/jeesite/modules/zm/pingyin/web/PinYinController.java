/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.pingyin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zm.pingyin.entity.Hanyu;
import com.thinkgem.jeesite.modules.zm.pingyin.entity.PinYin;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 测试Controller
 * @author zm
 * @version 2017-5-2
 */
@Controller
@RequestMapping(value = "${adminPath}/zm/pinyin")
public class PinYinController extends BaseController {

	
	@RequestMapping(value = "form")
	public String form(PinYin pinyin, Model model) {
		model.addAttribute("pinyin", pinyin);
		return "modules/zm/pinyinForm";
	}

	@RequestMapping(value = "trans")
	public String save(PinYin pinyin, Model model, RedirectAttributes redirectAttributes) {
		Hanyu hanyu = new Hanyu();
		String pinYinContent = hanyu.getStringPinYin(pinyin.getContent());
		pinyin.setContentResult(pinYinContent);
		return form(pinyin, model);
//		if (!beanValidator(model, pinyin)){
//			return form(pinyin, model);
//		}
//		testService.save(test);
		//addMessage(redirectAttributes, "保存测试'" + pinyin.getName() + "'成功");
		//return "redirect:" + adminPath + "/test/test/?repage";
	}
	
}
