/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.pingyin.web;

import java.io.FileNotFoundException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.modules.zm.pingyin.entity.Hanyu;
import com.thinkgem.jeesite.modules.zm.pingyin.entity.PinYin;


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
//		Hanyu hanyu = new Hanyu();
//		String pinYinContent = hanyu.getStringPinYin(pinyin.getContent());
//		pinyin.setContentResult(pinYinContent);
		
//		try {
//			PinyinHelper.addPinyinDict("user.dict");
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		
		String contentResult = "";
		    try {
		    	contentResult = PinyinHelper.convertToPinyinString(pinyin.getContent(), ",", PinyinFormat.WITH_TONE_MARK);
		    	
			} catch (PinyinException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    pinyin.setContentResult(contentResult);
		return form(pinyin, model);
	}
	
}
