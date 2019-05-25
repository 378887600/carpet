package com.shop.service.impl;

import javax.annotation.Resource;

import com.shop.dao.SnDao;
import com.shop.entity.Sn.Type;
import com.shop.service.SnService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service - 序列号
 * 
 * @author lihua
 * @version 1.0
 */
@Service("snServiceImpl")
public class SnServiceImpl implements SnService {

	@Resource(name = "snDaoImpl")
	private SnDao snDao;

	@Transactional
	public String generate(Type type) {
		return snDao.generate(type);
	}

}