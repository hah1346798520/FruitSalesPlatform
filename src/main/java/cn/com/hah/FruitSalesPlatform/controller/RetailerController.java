package cn.com.hah.FruitSalesPlatform.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.com.hah.FruitSalesPlatform.entity.Retailer;
import cn.com.hah.FruitSalesPlatform.entity.RetailerMapper;
import cn.com.hah.FruitSalesPlatform.service.RetailerService;
@Controller
public class RetailerController extends BaseController {
	@Autowired
	RetailerService retailerService;
	
	@RequestMapping("/retailer/toRetailerHome")
	public String toRetailerHome() {
		return "pages/retailerHome";
	}
	@RequestMapping("/retailer/find")
	public ModelAndView find(RetailerMapper retailer) {
		List<Retailer> list=retailerService.find(retailer);
		ModelAndView mv=new ModelAndView("pages/table");
		mv.addObject("list",list);
		return mv;
	}
	
	@RequestMapping(value="/retailer/findAll",method=RequestMethod.GET)
	public String findAll(Model model) {
		List<Retailer> list=retailerService.findAll();
		model.addAttribute("list", list);
		return "pages/table";
	}
	
	@RequestMapping(value="/retailer/editRetailer",method=RequestMethod.GET)
	@ResponseBody
	public Retailer editRetailer(String id) {
		return retailerService.get(id);
	}
	
	@RequestMapping(value="/retailer/deleteRetailer",method=RequestMethod.GET)
	@ResponseBody
	public int deleteRetailer(String id) {
		retailerService.deleteById(id);
		return 1;
	}
	
	@RequestMapping(value="/retailer/edit",method=RequestMethod.POST)
	@ResponseBody
	public int edit(Retailer retailer) {
		retailerService.update(retailer);
		return 1;
	}
	@RequestMapping(value="/retailer/addRetailer",method=RequestMethod.POST)
	@ResponseBody
	public int add(Retailer retailer) {
		retailerService.insert(retailer);
		return 1;
	}
}
