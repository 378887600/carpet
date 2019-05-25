package com.shop.service.impl;

import javax.annotation.Resource;

import com.shop.dao.ReturnsDao;
import com.shop.entity.Returns;
import com.shop.service.ReturnsService;

import org.springframework.stereotype.Service;

/**
 * Service - 退货单
 * 
 * @author lihua
 * @version 1.0
 */
@Service("returnsServiceImpl")
public class ReturnsServiceImpl extends BaseServiceImpl<Returns, Long> implements ReturnsService {

	@Resource(name = "returnsDaoImpl")
	public void setBaseDao(ReturnsDao returnsDao) {
		super.setBaseDao(returnsDao);
	}

}