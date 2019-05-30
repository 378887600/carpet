package com.shop.dao;

import com.shop.entity.Log;

/**
 * Dao - 日志
 * 
 * @author 
 * @version 1.0
 */
public interface LogDao extends BaseDao<Log, Long> {

	/**
	 * 删除所有日志
	 */
	void removeAll();

}