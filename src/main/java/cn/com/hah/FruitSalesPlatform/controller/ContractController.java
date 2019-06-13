package cn.com.hah.FruitSalesPlatform.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.hah.FruitSalesPlatform.entity.AddContractEntity;
import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesVo;
import cn.com.hah.FruitSalesPlatform.entity.ContractDetail;
import cn.com.hah.FruitSalesPlatform.entity.ContractVo;
import cn.com.hah.FruitSalesPlatform.entity.ContractVoMapper;
import cn.com.hah.FruitSalesPlatform.entity.MyResult;
import cn.com.hah.FruitSalesPlatform.entity.Retailer;
import cn.com.hah.FruitSalesPlatform.service.ContractService;

@Controller
public class ContractController extends BaseController {
	@Autowired
	ContractService contractService;
	@RequestMapping(value="/contract/home",method=RequestMethod.GET)
	public String home() {
		return "contract/home";
	}
	@RequestMapping(value="/contract/deleteContract",method=RequestMethod.GET)
	@ResponseBody
	public int deleteContract(String contractId) {
		contractService.deleteContract(contractId);
		return 1;
	}
	@RequestMapping(value="/contract/getContract",method=RequestMethod.GET)
	public String getContract(Model model,String contractId) {
		ContractDetail contractDetail=contractService.get(contractId);
		model.addAttribute("contractDetail", contractDetail);
		return "contract/contractDetail";
	}
	@RequestMapping(value="/contract/home",method=RequestMethod.POST)
	public String list(Model model,ContractVoMapper contractVoMapper) {
		List<ContractVo> list=contractService.find(contractVoMapper);
		model.addAttribute("list", list);
		return "contract/table";
	}
	
	@RequestMapping(value="/contract/addContract",method=RequestMethod.GET)
	public String toAddContract() {
		return "contract/addContract";
	}
	
	@RequestMapping(value="/contract/getAllRetailer",method=RequestMethod.POST)
	public String getAllRetailer(Model model,String name) {
		List<Retailer> list=contractService.findByRetailer(name);
		model.addAttribute("list", list);
		return "contract/retailerList";
	}
	
	@RequestMapping(value="/contract/getAllCommodities",method=RequestMethod.POST)
	public String getAllCommodities(Model model,String name) {
		List<Commodities> list=contractService.findByCommodities(name);
		model.addAttribute("list", list);
		return "contract/commoditiesList";
	}
	
	@RequestMapping(value="/contract/getCommoditiesAndAccessory",method=RequestMethod.POST)
	public String getCommoditiesAndAccessory(Model model,String[] arrays) {
		List<CommoditiesVo> list=contractService.getCommoditiesVo(arrays);
		model.addAttribute("list", list);
		return "contract/commoditiesAndAccessory";
	}
	@RequestMapping(value="/contract/add",method=RequestMethod.POST)
	@ResponseBody
	public MyResult<Object> add(@RequestBody AddContractEntity addContractEntity) {
		String barCode=contractService.add(addContractEntity);
		String s="添加成功！合同编号为"+barCode;
		MyResult<Object> r=new MyResult<Object>();
		r.setMsg(s);
		return r;
	}
}
