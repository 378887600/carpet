package com.shop.dao.impl;

import com.shop.dao.ShippingMethodDao;
import com.shop.entity.ShippingMethod;

import org.springframework.stereotype.Repository;

/**
 * Dao - 配送方式
 * 
 * @author 
 * @version 1.0
 */
@Repository("shippingMethodDaoImpl")
public class ShippingMethodDaoImpl extends BaseDaoImpl<ShippingMethod, Long> implements ShippingMethodDao {

}