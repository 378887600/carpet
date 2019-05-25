package com.shop.dao;

import java.util.List;

import com.shop.entity.Navigation;
import com.shop.entity.Navigation.Position;

/**
 * Dao - 导航
 * 
 * @author lihua
 * @version 1.0
 */
public interface NavigationDao extends BaseDao<Navigation, Long> {

	/**
	 * 查找导航
	 * 
	 * @param position
	 *            位置
	 * @return 导航
	 */
	List<Navigation> findList(Position position);

}