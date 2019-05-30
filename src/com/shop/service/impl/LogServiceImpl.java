package com.shop.service.impl;

import javax.annotation.Resource;

import com.shop.dao.LogDao;
import com.shop.entity.Log;
import com.shop.service.LogService;

import org.springframework.stereotype.Service;

/**
 * Service - 日志
 * 
 * @author 
 * @version 1.0
 */
@Service("logServiceImpl")
public class LogServiceImpl extends BaseServiceImpl<Log, Long> implements LogService {

	@Resource(name = "logDaoImpl")
	private LogDao logDao;

	@Resource(name = "logDaoImpl")
	public void setBaseDao(LogDao logDao) {
		super.setBaseDao(logDao);
	}

	public void clear() {
		logDao.removeAll();
	}

}