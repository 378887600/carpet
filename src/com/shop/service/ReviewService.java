package com.shop.service;

import java.util.List;

import com.shop.Filter;
import com.shop.Order;
import com.shop.Page;
import com.shop.Pageable;
import com.shop.entity.Member;
import com.shop.entity.Product;
import com.shop.entity.Review;
import com.shop.entity.Review.Type;

/**
 * Service - 评论
 * 
 * @author 
 * @version 1.0
 */
public interface ReviewService extends BaseService<Review, Long> {

	/**
	 * 查找评论
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param type
	 *            类型
	 * @param isShow
	 *            是否显示
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @return 评论
	 */
	List<Review> findList(Member member, Product product, Type type, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders);

	/**
	 * 查找评论(缓存)
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param type
	 *            类型
	 * @param isShow
	 *            是否显示
	 * @param count
	 *            数量
	 * @param filters
	 *            筛选
	 * @param orders
	 *            排序
	 * @param cacheRegion
	 *            缓存区域
	 * @return 评论(缓存)
	 */
	List<Review> findList(Member member, Product product, Type type, Boolean isShow, Integer count, List<Filter> filters, List<Order> orders, String cacheRegion);

	/**
	 * 查找评论分页
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param type
	 *            类型
	 * @param isShow
	 *            是否显示
	 * @param pageable
	 *            分页信息
	 * @return 评论分页
	 */
	Page<Review> findPage(Member member, Product product, Type type, Boolean isShow, Pageable pageable);

	/**
	 * 查找评论数量
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @param type
	 *            类型
	 * @param isShow
	 *            是否显示
	 * @return 评论数量
	 */
	Long count(Member member, Product product, Type type, Boolean isShow);

	/**
	 * 判断会员是否已评论该商品
	 * 
	 * @param member
	 *            会员
	 * @param product
	 *            商品
	 * @return 是否已评论该商品
	 */
	boolean isReviewed(Member member, Product product);

}