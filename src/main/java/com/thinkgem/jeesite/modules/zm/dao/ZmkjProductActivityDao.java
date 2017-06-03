/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.zm.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.zm.entity.ZmkjProductActivity;

/**
 * 活跃度统计DAO接口
 * @author firemail
 * @version 2017-06-03
 */
@MyBatisDao
public interface ZmkjProductActivityDao extends CrudDao<ZmkjProductActivity> {
	
}