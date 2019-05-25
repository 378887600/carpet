package com.shop.service;

import com.shop.entity.DeliveryTemplate;

/**
 * Service - 快递单模板
 * 
 * @author lihua
 * @version 1.0
 */
public interface DeliveryTemplateService extends BaseService<DeliveryTemplate, Long> {

	/**
	 * 查找默认快递单模板
	 * 
	 * @return 默认快递单模板，若不存在则返回null
	 */
	DeliveryTemplate findDefault();

}