/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.entity;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 活跃度统计Entity
 * @author firemail
 * @version 2017-06-03
 */
public class ZmkjProductActivity extends DataEntity<ZmkjProductActivity> {
	
	private static final long serialVersionUID = 1L;
	private String userid;		// 用户标志
	private String clientid;		// 客户端标志
	private String name;		// 产品名称
	private String technologyPlatform;		// 技术平台
	private String os;		// 操作系统
	private String version;		// 版本号
	private String eventName;		// 活动事件名称
	private String ip;		// ip地址
	
	public ZmkjProductActivity() {
		super();
	}

	public ZmkjProductActivity(String id){
		super(id);
	}

	@Length(min=0, max=64, message="用户标志长度必须介于 0 和 64 之间")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=64, message="客户端标志长度必须介于 0 和 64 之间")
	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
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
	
	@Length(min=0, max=64, message="操作系统长度必须介于 0 和 64 之间")
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
	
	@Length(min=1, max=50, message="版本号长度必须介于 1 和 50 之间")
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	@Length(min=0, max=100, message="活动事件名称长度必须介于 0 和 100 之间")
	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
	@Length(min=0, max=100, message="ip地址长度必须介于 0 和 100 之间")
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
}