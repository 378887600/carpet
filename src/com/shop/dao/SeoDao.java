package com.shop.dao;

import com.shop.entity.Seo;
import com.shop.entity.Seo.Type;

/**
 * Dao - SEO设置
 * 
 * @author 
 * @version 1.0
 */
public interface SeoDao extends BaseDao<Seo, Long> {

	/**
	 * 查找SEO设置
	 * 
	 * @param type
	 *            类型
	 * @return SEO设置
	 */
	Seo find(Type type);

}