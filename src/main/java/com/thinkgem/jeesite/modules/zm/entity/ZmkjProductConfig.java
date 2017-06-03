/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.entity;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotNull;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 产品配置Entity
 * @author firemail
 * @version 2017-06-03
 */
public class ZmkjProductConfig extends DataEntity<ZmkjProductConfig> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 产品名称
	private String technologyPlatform;		// 技术平台
	private String version;		// 版本号 1.2.3
	private Integer versionNum;		// 版本号NUM  1*10000 + 2*100 +3
	private String downAddress;		// 下载地址
	
	public ZmkjProductConfig() {
		super();
	}

	public ZmkjProductConfig(String id){
		super(id);
	}

	@Length(min=1, max=64, message="产品名称长度必须介于 1 和 64 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=1, max=64, message="技术平台长度必须介于 1 和 64 之间")
	public String getTechnologyPlatform() {
		return technologyPlatform;
	}

	public void setTechnologyPlatform(String technologyPlatform) {
		this.technologyPlatform = technologyPlatform;
	}
	
	@Length(min=1, max=64, message="长度必须介于 1 和 255 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@NotNull(message="版本号NUM  1*10000 + 2*100 +3不能为空")
	public Integer getVersionNum() {
		return versionNum;
	}

	public void setVersionNum(Integer versionNum) {
		this.versionNum = versionNum;
	}
	
	@Length(min=0, max=260, message="下载地址长度必须介于 0 和 260 之间")
	public String getDownAddress() {
		return downAddress;
	}

	public void setDownAddress(String downAddress) {
		this.downAddress = downAddress;
	}
	
}