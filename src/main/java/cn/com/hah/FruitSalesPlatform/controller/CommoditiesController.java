package cn.com.hah.FruitSalesPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesMapper;
import cn.com.hah.FruitSalesPlatform.service.CommoditiesService;

@Controller
public class CommoditiesController extends BaseController{
	@Autowired
	CommoditiesService commoditiesService;
	
	@RequestMapping(value="/commodities/home",method=RequestMethod.GET)
	public String home() {
		return "/commodities/home";
	}

	@RequestMapping(value="/commodities/find",method=RequestMethod.POST)
	public ModelAndView find(CommoditiesMapper commoditiesMapper) {
		List<Commodities> list=commoditiesService.find(commoditiesMapper);
		ModelAndView mv=new ModelAndView("commodities/table");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping(value="/commodities/findAll",method=RequestMethod.GET)
	public String findAll(Model model) {
		List<Commodities> list=commoditiesService.findAll();
		model.addAttribute("list", list);
		return "commodities/table";
	}
	@RequestMapping(value="/commodities/editCommodities",method=RequestMethod.GET)
	@ResponseBody
	public Commodities editCommodities(String id) {
		return commoditiesService.get(id);
	}
	
	@RequestMapping(value="/commodities/deleteCommodities",method=RequestMethod.GET)
	@ResponseBody
	public int deleteCommodities(String id) {
		commoditiesService.deleteById(id);
		return 1;
	}
	
	@RequestMapping(value="/commodities/edit",method=RequestMethod.POST)
	@ResponseBody
	public int edit(Commodities commodities) {
		commoditiesService.update(commodities);
		return 1;
	}
	@RequestMapping(value="/commodities/addCommodities",method=RequestMethod.POST)
	@ResponseBody
	public int add(Commodities commodities) {
		commoditiesService.insert(commodities);
		return 1;
	}
}
