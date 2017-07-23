/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductConfig;
import com.thinkgem.jeesite.modules.zm.dao.ZmkjProductConfigDao;
import com.thinkgem.jeesite.modules.zm.dao.ZmkjProductConfigExDao;

/**
 * 产品配置Service
 * @author firemail
 * @version 2017-06-03
 */
@Service
@Transactional(readOnly = true)
public class ZmkjProductConfigService extends CrudService<ZmkjProductConfigDao, ZmkjProductConfig> {

	@Autowired
	ZmkjProductConfigDao zmkjProductConfigDao;
	
	@Autowired
	ZmkjProductConfigExDao zmkjProductConfigExDao;
	
	public ZmkjProductConfig get(String id) {
		return super.get(id);
	}
	
	public List<ZmkjProductConfig> findList(ZmkjProductConfig zmkjProductConfig) {
		return super.findList(zmkjProductConfig);
	}
	
	public Page<ZmkjProductConfig> findPage(Page<ZmkjProductConfig> page, ZmkjProductConfig zmkjProductConfig) {
		return super.findPage(page, zmkjProductConfig);
	}
	
	public ZmkjProductConfig getNewVersion(String productName, String technologyPlatform, Integer versionNum){
		ZmkjProductConfig zmkjProductConfig = new ZmkjProductConfig();
		zmkjProductConfig.setName(productName);
		zmkjProductConfig.setTechnologyPlatform(technologyPlatform);
		zmkjProductConfig.setVersionNum(versionNum);
		return zmkjProductConfigExDao.getNewVersion(zmkjProductConfig);
	}
	
	@Transactional(readOnly = false)
	public void save(ZmkjProductConfig zmkjProductConfig) {
		super.save(zmkjProductConfig);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZmkjProductConfig zmkjProductConfig) {
		super.delete(zmkjProductConfig);
	}
	
}