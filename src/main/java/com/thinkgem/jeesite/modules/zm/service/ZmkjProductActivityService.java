/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductActivity;
import com.thinkgem.jeesite.modules.zm.dao.ZmkjProductActivityDao;

/**
 * 活跃度统计Service
 * @author firemail
 * @version 2017-06-03
 */
@Service
@Transactional(readOnly = true)
public class ZmkjProductActivityService extends CrudService<ZmkjProductActivityDao, ZmkjProductActivity> {

	public ZmkjProductActivity get(String id) {
		return super.get(id);
	}
	
	public List<ZmkjProductActivity> findList(ZmkjProductActivity zmkjProductActivity) {
		return super.findList(zmkjProductActivity);
	}
	
	public Page<ZmkjProductActivity> findPage(Page<ZmkjProductActivity> page, ZmkjProductActivity zmkjProductActivity) {
		return super.findPage(page, zmkjProductActivity);
	}
	
	@Transactional(readOnly = false)
	public void save(ZmkjProductActivity zmkjProductActivity) {
		super.save(zmkjProductActivity);
	}
	
	@Transactional(readOnly = false)
	public void delete(ZmkjProductActivity zmkjProductActivity) {
		super.delete(zmkjProductActivity);
	}
	
}