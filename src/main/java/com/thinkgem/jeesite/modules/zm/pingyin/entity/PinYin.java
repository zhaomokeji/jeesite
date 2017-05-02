/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.pingyin.entity;


import com.thinkgem.jeesite.common.persistence.DataEntity;

public class PinYin extends DataEntity<PinYin> {
	
	private static final long serialVersionUID = 1L;
	private String content;
	private String contentResult; 	

	public PinYin() {
		super();
	}

	public PinYin(String id){
		super(id);
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getContentResult() {
		return contentResult;
	}

	public void setContentResult(String contentResult) {
		this.contentResult = contentResult;
	}


}


