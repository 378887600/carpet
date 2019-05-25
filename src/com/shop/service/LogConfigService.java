package com.shop.service;

import java.util.List;

import com.shop.LogConfig;

/**
 * Service - 日志配置
 * 
 * @author lihua
 * @version 1.0
 */
public interface LogConfigService {

	/**
	 * 获取所有日志配置
	 * 
	 * @return 所有日志配置
	 */
	List<LogConfig> getAll();

}