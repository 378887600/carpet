package com.shop.dao;

import java.util.List;

import com.shop.entity.Tag;
import com.shop.entity.Tag.Type;

/**
 * Dao - 标签
 * 
 * @author lihua
 * @version 1.0
 */
public interface TagDao extends BaseDao<Tag, Long> {

	/**
	 * 查找标签
	 * 
	 * @param type
	 *            类型
	 * @return 标签
	 */
	List<Tag> findList(Type type);

}