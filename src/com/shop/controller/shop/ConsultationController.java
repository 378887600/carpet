package com.shop.controller.shop;

import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.shop.Message;
import com.shop.Pageable;
import com.shop.ResourceNotFoundException;
import com.shop.Setting;
import com.shop.Setting.CaptchaType;
import com.shop.Setting.ConsultationAuthority;
import com.shop.entity.Consultation;
import com.shop.entity.Member;
import com.shop.entity.Product;
import com.shop.service.CaptchaService;
import com.shop.service.ConsultationService;
import com.shop.service.MemberService;
import com.shop.service.ProductService;
import com.shop.util.SettingUtils;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller - 咨询
 * 
 * @author 
 * @version 1.0
 */
@Controller("shopConsultationController")
@RequestMapping("/consultation")
public class ConsultationController extends BaseController {

	/** 每页记录数 */
	private static final int PAGE_SIZE = 10;

	@Resource(name = "consultationServiceImpl")
	private ConsultationService consultationService;
	@Resource(name = "productServiceImpl")
	private ProductService productService;
	@Resource(name = "memberServiceImpl")
	private MemberService memberService;
	@Resource(name = "captchaServiceImpl")
	private CaptchaService captchaService;

	/**
	 * 发表
	 */
	@RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
	public String add(@PathVariable Long id, ModelMap model) {
		Setting setting = SettingUtils.get();
		if (!setting.getIsConsultationEnabled()) {
			throw new ResourceNotFoundException();
		}
		Product product = productService.find(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		model.addAttribute("product", product);
		model.addAttribute("captchaId", UUID.randomUUID().toString());
		return "/shop/consultation/add";
	}

	/**
	 * 内容
	 */
	@RequestMapping(value = "/content/{id}", method = RequestMethod.GET)
	public String content(@PathVariable Long id, Integer pageNumber, ModelMap model) {
		Setting setting = SettingUtils.get();
		if (!setting.getIsConsultationEnabled()) {
			throw new ResourceNotFoundException();
		}
		Product product = productService.find(id);
		if (product == null) {
			throw new ResourceNotFoundException();
		}
		Pageable pageable = new Pageable(pageNumber, PAGE_SIZE);
		model.addAttribute("product", product);
		model.addAttribute("page", consultationService.findPage(null, product, true, pageable));
		return "/shop/consultation/content";
	}

	/**
	 * 保存
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody
	Message save(String captchaId, String captcha, Long id, String content, HttpServletRequest request) {
		if (!captchaService.isValid(CaptchaType.consultation, captchaId, captcha)) {
			return Message.error("shop.captcha.invalid");
		}
		Setting setting = SettingUtils.get();
		if (!setting.getIsConsultationEnabled()) {
			return Message.error("shop.consultation.disabled");
		}
		if (!isValid(Consultation.class, "content", content)) {
			return ERROR_MESSAGE;
		}
		Member member = memberService.getCurrent();
		if (setting.getConsultationAuthority() != ConsultationAuthority.anyone && member == null) {
			return Message.error("shop.consultation.accessDenied");
		}
		Product product = productService.find(id);
		if (product == null) {
			return ERROR_MESSAGE;
		}
		Consultation consultation = new Consultation();
		consultation.setContent(content);
		consultation.setIp(request.getRemoteAddr());
		consultation.setMember(member);
		consultation.setProduct(product);
		if (setting.getIsConsultationCheck()) {
			consultation.setIsShow(false);
			consultationService.save(consultation);
			return Message.success("shop.consultation.check");
		} else {
			consultation.setIsShow(true);
			consultationService.save(consultation);
			return Message.success("shop.consultation.success");
		}
	}

}