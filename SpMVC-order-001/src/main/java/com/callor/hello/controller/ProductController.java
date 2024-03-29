package com.callor.hello.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.callor.hello.models.CustomVO;
import com.callor.hello.models.OrderVO;
import com.callor.hello.models.ProductVO;
import com.callor.hello.persistance.OrderDao;
import com.callor.hello.persistance.ProductDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/product")
public class ProductController {
	
	private final ProductDao productDao;
	
	public ProductController(ProductDao productDao) {
		this.productDao = productDao;
	
	}
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model) {
		
		List<ProductVO> productList = productDao.selectAll();
		model.addAttribute("PRO_LIST",productList);
		return "product/list";

	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert() {
		return "product/input";
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(ProductVO productVO, Model model) {
		try {
			log.debug(productVO.toString());
			int result = productDao.insert(productVO);

			if (result > 0) {

				return "redirect:/product";

			} else {
				model.addAttribute("MSG", "INSERT ERROR");
				return "product/input";
			}

		} catch (Exception e) {
			model.addAttribute("MSG", "SQL ERROR");
			return "product/input";
		}

	}
	
	


}
