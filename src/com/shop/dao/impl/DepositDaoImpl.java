package com.shop.dao.impl;

import java.util.Collections;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.shop.Page;
import com.shop.Pageable;
import com.shop.dao.DepositDao;
import com.shop.entity.Deposit;
import com.shop.entity.Member;

import org.springframework.stereotype.Repository;

/**
 * Dao - 预存款
 * 
 * @author 
 * @version 1.0
 */
@Repository("depositDaoImpl")
public class DepositDaoImpl extends BaseDaoImpl<Deposit, Long> implements DepositDao {

	public Page<Deposit> findPage(Member member, Pageable pageable) {
		if (member == null) {
			return new Page<Deposit>(Collections.<Deposit> emptyList(), 0, pageable);
		}
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Deposit> criteriaQuery = criteriaBuilder.createQuery(Deposit.class);
		Root<Deposit> root = criteriaQuery.from(Deposit.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("member"), member));
		return super.findPage(criteriaQuery, pageable);
	}

}