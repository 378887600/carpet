package com.shop.dao;

import com.shop.entity.Cart;

/**
 * Dao - 购物车
 * 
 * @author 
 * @version 1.0
 */
public interface CartDao extends BaseDao<Cart, Long> {

	/**
	 * 清除过期购物车
	 */
	void evictExpired();

}