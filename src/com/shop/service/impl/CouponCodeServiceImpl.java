package com.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.LockModeType;

import com.shop.Page;
import com.shop.Pageable;
import com.shop.dao.CouponCodeDao;
import com.shop.dao.MemberDao;
import com.shop.entity.Coupon;
import com.shop.entity.CouponCode;
import com.shop.entity.Member;
import com.shop.service.CouponCodeService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * Service - 优惠码
 * 
 * @author 
 * @version 1.0
 */
@Service("couponCodeServiceImpl")
public class CouponCodeServiceImpl extends BaseServiceImpl<CouponCode, Long> implements CouponCodeService {

	@Resource(name = "couponCodeDaoImpl")
	private CouponCodeDao couponCodeDao;
	@Resource(name = "memberDaoImpl")
	private MemberDao memberDao;

	@Resource(name = "couponCodeDaoImpl")
	public void setBaseDao(CouponCodeDao couponCodeDao) {
		super.setBaseDao(couponCodeDao);
	}

	@Transactional(readOnly = true)
	public boolean codeExists(String code) {
		return couponCodeDao.codeExists(code);
	}

	@Transactional(readOnly = true)
	public CouponCode findByCode(String code) {
		return couponCodeDao.findByCode(code);
	}

	public CouponCode build(Coupon coupon, Member member) {
		return couponCodeDao.build(coupon, member);
	}

	public List<CouponCode> build(Coupon coupon, Member member, Integer count) {
		return couponCodeDao.build(coupon, member, count);
	}

	public CouponCode exchange(Coupon coupon, Member member) {
		Assert.notNull(coupon);
		Assert.notNull(member);

		memberDao.lock(member, LockModeType.PESSIMISTIC_WRITE);
		member.setPoint(member.getPoint() - coupon.getPoint());
		memberDao.merge(member);

		return couponCodeDao.build(coupon, member);
	}

	@Transactional(readOnly = true)
	public Page<CouponCode> findPage(Member member, Pageable pageable) {
		return couponCodeDao.findPage(member, pageable);
	}

	@Transactional(readOnly = true)
	public Long count(Coupon coupon, Member member, Boolean hasBegun, Boolean hasExpired, Boolean isUsed) {
		return couponCodeDao.count(coupon, member, hasBegun, hasExpired, isUsed);
	}

}