package cn.com.hah.FruitSalesPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.hah.FruitSalesPlatform.entity.Accessory;
import cn.com.hah.FruitSalesPlatform.service.AccessoryService;

@Controller
public class AccessoryController extends BaseController {
	@Autowired
	AccessoryService accessoryService;
	
	@RequestMapping(value="/accessory/list",method=RequestMethod.GET)
	public String list(String fruitId,Model model) {
		List<Accessory> list=accessoryService.findByFruitId(fruitId);
		model.addAttribute("list", list);
		return "accessory/home";
	}
	
	@RequestMapping(value="/accessory/addAccessory",method=RequestMethod.POST)
	@ResponseBody
	public int add(Accessory accessory) {
		accessoryService.insert(accessory);
		return 1;
	}
	
	@RequestMapping(value="/accessory/deleteList",method=RequestMethod.POST)
	@ResponseBody
	public int delete(String[] arrays) {
		accessoryService.delete(arrays);
		return 1;
	}
}
