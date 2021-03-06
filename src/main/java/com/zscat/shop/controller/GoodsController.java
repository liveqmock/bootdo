package com.zscat.shop.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zscat.shop.domain.GoodsDO;
import com.zscat.shop.service.GoodsService;
import com.zscat.common.utils.PageUtils;
import com.zscat.common.utils.Query;
import com.zscat.common.utils.R;

/**
 * 
 * 
 * @author zscat
 * @email 951449465@qq.com
 * @date 2018-02-01 14:20:37
 */
 
@Controller
@RequestMapping("/shop/goods")
public class GoodsController {
	@Autowired
	private GoodsService goodsService;
	
	@GetMapping()
	@RequiresPermissions("shop:goods:goods")
	String Goods(){
	    return "shop/goods/goods";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("shop:goods:goods")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<GoodsDO> goodsList = goodsService.list(query);
		int total = goodsService.count(query);
		PageUtils pageUtils = new PageUtils(goodsList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("shop:goods:add")
	String add(){
	    return "shop/goods/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("shop:goods:edit")
	String edit(@PathVariable("id") Long id,Model model){
		GoodsDO goods = goodsService.get(id);
		model.addAttribute("goods", goods);
	    return "shop/goods/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("shop:goods:add")
	public R save( GoodsDO goods){
		if(goodsService.save(goods)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("shop:goods:edit")
	public R update( GoodsDO goods){
		goodsService.update(goods);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("shop:goods:remove")
	public R remove( Long id){
		if(goodsService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("shop:goods:batchRemove")
	public R remove(@RequestParam("ids[]") Long[] ids){
		goodsService.batchRemove(ids);
		return R.ok();
	}
	
}
