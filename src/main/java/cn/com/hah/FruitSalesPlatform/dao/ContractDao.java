package cn.com.hah.FruitSalesPlatform.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import cn.com.hah.FruitSalesPlatform.entity.Contract;
import cn.com.hah.FruitSalesPlatform.entity.ContractDetail;
import cn.com.hah.FruitSalesPlatform.entity.ContractVo;
import cn.com.hah.FruitSalesPlatform.entity.ContractVoMapper;
import cn.com.hah.FruitSalesPlatform.entity.MiddleTab;

@Mapper
public interface ContractDao {

	String getMaxBarCode();

	void insert(Contract c);

	void insertMiddleTab(MiddleTab m);

	List<ContractVo> find(ContractVoMapper contractVoMapper);

	ContractDetail get(String contractId);

	void deleteById(String contractId);

	void deleteMiddleTab(String contractId);

}
