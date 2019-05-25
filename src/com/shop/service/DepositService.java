package com.shop.service;

import com.shop.Page;
import com.shop.Pageable;
import com.shop.entity.Deposit;
import com.shop.entity.Member;

/**
 * Service - 预存款
 * 
 * @author lihua
 * @version 1.0
 */
public interface DepositService extends BaseService<Deposit, Long> {

	/**
	 * 查找预存款分页
	 * 
	 * @param member
	 *            会员
	 * @param pageable
	 *            分页信息
	 * @return 预存款分页
	 */
	Page<Deposit> findPage(Member member, Pageable pageable);

}