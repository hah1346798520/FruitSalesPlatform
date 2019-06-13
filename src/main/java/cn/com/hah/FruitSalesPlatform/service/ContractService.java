package cn.com.hah.FruitSalesPlatform.service;

import java.util.List;

import cn.com.hah.FruitSalesPlatform.entity.AddContractEntity;
import cn.com.hah.FruitSalesPlatform.entity.Commodities;
import cn.com.hah.FruitSalesPlatform.entity.CommoditiesVo;
import cn.com.hah.FruitSalesPlatform.entity.ContractDetail;
import cn.com.hah.FruitSalesPlatform.entity.ContractVo;
import cn.com.hah.FruitSalesPlatform.entity.ContractVoMapper;
import cn.com.hah.FruitSalesPlatform.entity.Retailer;

public interface ContractService {

	List<Retailer> findByRetailer(String name);

	List<Commodities> findByCommodities(String name);

	List<CommoditiesVo> getCommoditiesVo(String[] arrays);

	String add(AddContractEntity addContractEntity);

	List<ContractVo> find(ContractVoMapper contractVoMapper);

	ContractDetail get(String contractId);

	void deleteContract(String contractId);


}
