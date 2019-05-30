package com.shop.controller.shop.member;

import javax.annotation.Resource;

import com.shop.Pageable;
import com.shop.controller.shop.BaseController;
import com.shop.entity.Member;
import com.shop.service.ConsultationService;
import com.shop.service.MemberService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller - 会员中心 - 咨询
 * 
 * @author 
 * @version 1.0
 */
@Controller("shopMemberConsultationController")
@RequestMapping("/member/consultation")
public class ConsultationController extends BaseController {

	/** 每页记录数 */
	private static final int PAGE_SIZE = 10;

	@Resource(name = "memberServiceImpl")
	private MemberService memberService;
	@Resource(name = "consultationServiceImpl")
	private ConsultationService consultationService;

	/**
	 * 列表
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Integer pageNumber, ModelMap model) {
		Member member = memberService.getCurrent();
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("page", consultationService.findPage(member, null, null, pageable));
		return "shop/member/consultation/list";
	}

}