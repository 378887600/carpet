package com.shop.service;

import com.shop.entity.Cart;
import com.shop.entity.Member;

/**
 * Service - 购物车
 * 
 * @author lihua
 * @version 1.0
 */
public interface CartService extends BaseService<Cart, Long> {

	/**
	 * 获取当前购物车
	 * 
	 * @return 当前购物车,若不存在则返回null
	 */
	Cart getCurrent();

	/**
	 * 合并临时购物车至会员
	 * 
	 * @param member
	 *            会员
	 * @param cart
	 *            临时购物车
	 */
	void merge(Member member, Cart cart);

	/**
	 * 清除过期购物车
	 */
	void evictExpired();

}