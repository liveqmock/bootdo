package com.zscat.shop.dao;

import com.zscat.shop.domain.AddressDO;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2018-02-01 14:20:35
 */
@Mapper
public interface AddressDao {

	AddressDO get(Long id);
	
	List<AddressDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(AddressDO address);
	
	int update(AddressDO address);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);
}
