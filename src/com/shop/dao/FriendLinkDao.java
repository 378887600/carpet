package com.shop.dao;

import java.util.List;

import com.shop.entity.FriendLink;
import com.shop.entity.FriendLink.Type;

/**
 * Dao - 友情链接
 * 
 * @author 
 * @version 1.0
 */
public interface FriendLinkDao extends BaseDao<FriendLink, Long> {

	/**
	 * 查找友情链接
	 * 
	 * @param type
	 *            类型
	 * @return 友情链接
	 */
	List<FriendLink> findList(Type type);

}