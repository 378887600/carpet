package com.shop.dao.impl;

import com.shop.dao.ReturnsDao;
import com.shop.entity.Returns;

import org.springframework.stereotype.Repository;

/**
 * Dao - 退货单
 * 
 * @author lihua
 * @version 1.0
 */
@Repository("returnsDaoImpl")
public class ReturnsDaoImpl extends BaseDaoImpl<Returns, Long> implements ReturnsDao {

}