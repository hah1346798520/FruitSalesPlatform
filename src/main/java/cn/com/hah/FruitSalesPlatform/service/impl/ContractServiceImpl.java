package cn.com.hah.FruitSalesPlatform.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import cn.com.hah.FruitSalesPlatform.dao.AccessoryDao;
import cn.com.hah.FruitSalesPlatform.dao.CommoditiesDao;
import cn.com.hah.FruitSalesPlatform.dao.ContractDao;
import cn.com.hah.FruitSalesPlatform.dao.RetailerDao;
import cn.com.hah.FruitSalesPlatform.entity.Accessory;
import cn.com.hah.FruitSalesPlatform.entity.AddContractEntity;
import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesMapper;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesVo;
import cn.com.hah.FruitSalesPlatform.entity.Contract;
import cn.com.hah.FruitSalesPlatform.entity.ContractDetail;
import cn.com.hah.FruitSalesPlatform.entity.ContractVo;
import cn.com.hah.FruitSalesPlatform.entity.ContractVoMapper;
import cn.com.hah.FruitSalesPlatform.entity.MiddleTab;
import cn.com.hah.FruitSalesPlatform.entity.Retailer;
import cn.com.hah.FruitSalesPlatform.entity.RetailerMapper;
import cn.com.hah.FruitSalesPlatform.service.ContractService;
@Service
public class ContractServiceImpl implements ContractService {
	@Autowired
	ContractDao contractDao;
	@Autowired
	RetailerDao retailerDao;
	@Autowired
	CommoditiesDao commoditiesDao;
	@Autowired
	AccessoryDao accessoryDao;
	@Override
	public List<Retailer> findByRetailer(String name) {
		RetailerMapper retailerMapper=new RetailerMapper();
		retailerMapper.setStatus(1);
		retailerMapper.setName(name);
		return retailerDao.find(retailerMapper);
	}
	@Override
	public List<Commodities> findByCommodities(String name) {
		CommoditiesMapper commoditiesMapper=new CommoditiesMapper();
		commoditiesMapper.setFruitName(name);
		return commoditiesDao.find(commoditiesMapper);
	}
	@Override
	public List<CommoditiesVo> getCommoditiesVo(String[] arrays) {
		List<CommoditiesVo> list=new ArrayList<>();
		for (String s : arrays) {
			CommoditiesVo cV=new CommoditiesVo();
			Commodities c=commoditiesDao.get(s);
			cV.setFruitId(c.getFruitId());
			cV.setFruitName(c.getFruitName());
			cV.setPrice(c.getPrice());
			cV.setLocality(c.getLocality());
			List<Accessory> l=accessoryDao.findByFruitId(s);
			cV.setAccessoryList(l);
			list.add(cV);
		}
		return list;
	}
	@Override
	@Transactional
	public String add(AddContractEntity addContractEntity) {
		Contract c=new Contract();
		c.setType(addContractEntity.getType());
		c.setRetailerId(addContractEntity.getRetailerId());
		String barCode=getCode();
		c.setBarCode(barCode);
		c.setContractId(UUID.randomUUID().toString().replace("-", ""));
		c.setCreateTime(new Date());
		contractDao.insert(c);
		String[] commoditiesIdArrays=addContractEntity.getCommoditiesIdArrays();
		String[] priceArrays=addContractEntity.getPriceArrays();
		for (int i = 0; i < commoditiesIdArrays.length; i++) {
			MiddleTab m=new MiddleTab();
			m.setMiddleId(UUID.randomUUID().toString().replace("-", ""));
			m.setContractId(c.getContractId());
			m.setFruitId(commoditiesIdArrays[i]);
			int number=Integer.parseInt(priceArrays[i].equals("")?"0":priceArrays[i]);
			m.setNumber(number);
			this.insertMiddleTab(m);
		}
		
		return barCode;
		
	}
	@Transactional
	public void insertMiddleTab(MiddleTab m) {
		contractDao.insertMiddleTab(m);
	}
	private String getCode() {
		String codeHead=new SimpleDateFormat("yyyyMMdd").format(new Date());
		String barCode="";
		String maxBarCode=contractDao.getMaxBarCode();
		if(!StringUtils.isEmpty(maxBarCode)) {
			if(maxBarCode.substring(0, 8).equals(codeHead)) {
				maxBarCode=maxBarCode.substring(8);
			}else {
				maxBarCode="0";
			}
		}else {
			maxBarCode="0";
		}
		int number=Integer.parseInt(maxBarCode)+1;
		if(number<=9) {
			barCode=codeHead+"000"+number;
		}else if (number>=10&&number<=99) {
			barCode=codeHead+"00"+number;
		}else if (number>=100&&number<=999) {
			barCode=codeHead+"0"+number;
		}else{
			barCode=codeHead+number;
		}
		return barCode;
	}
	@Override
	public List<ContractVo> find(ContractVoMapper contractVoMapper) {
		return contractDao.find(contractVoMapper);
	}
	@Override
	public ContractDetail get(String contractId) {
		return contractDao.get(contractId);
	}
	@Override
	@Transactional
	public void deleteContract(String contractId) {
		contractDao.deleteById(contractId);
		contractDao.deleteMiddleTab(contractId);
	}

}
