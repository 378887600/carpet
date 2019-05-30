package com.shop.service;

import com.shop.entity.Log;

/**
 * Service - 日志
 * 
 * @author 
 * @version 1.0
 */
public interface LogService extends BaseService<Log, Long> {

	/**
	 * 清空日志
	 */
	void clear();

}