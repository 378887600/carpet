package com.shop.dao;

import com.shop.entity.Sn.Type;

/**
 * Dao - 序列号
 * 
 * @author lihua
 * @version 1.0
 */
public interface SnDao {

	/**
	 * 生成序列号
	 * 
	 * @param type
	 *            类型
	 * @return 序列号
	 */
	String generate(Type type);

}