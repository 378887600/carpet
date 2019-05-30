package com.shop.dao.impl;

import com.shop.dao.RefundsDao;
import com.shop.entity.Refunds;

import org.springframework.stereotype.Repository;

/**
 * Dao - 退款单
 * 
 * @author 
 * @version 1.0
 */
@Repository("refundsDaoImpl")
public class RefundsDaoImpl extends BaseDaoImpl<Refunds, Long> implements RefundsDao {

}