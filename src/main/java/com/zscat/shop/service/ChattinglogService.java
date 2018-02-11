package com.zscat.shop.service; import com.zscat.common.utils.PageUtils;

import com.zscat.shop.domain.ChattinglogDO;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2018-02-01 14:20:35
 */
public interface ChattinglogService {
	
	ChattinglogDO get(Long id);
	
	List<ChattinglogDO> list(Map<String, Object> map);
	
	int count(Map<String, Object> map);
	
	int save(ChattinglogDO chattinglog);
	
	int update(ChattinglogDO chattinglog);
	
	int remove(Long id);
	
	int batchRemove(Long[] ids);

	ChattinglogDO selectOne(Map<String, Object> params);

    PageUtils listPage(Map<String, Object> map);
}
