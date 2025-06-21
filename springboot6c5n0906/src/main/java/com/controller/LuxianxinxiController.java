package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.LuxianxinxiEntity;
import com.entity.view.LuxianxinxiView;

import com.service.LuxianxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 路线信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/luxianxinxi")
public class LuxianxinxiController {
    @Autowired
    private LuxianxinxiService luxianxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LuxianxinxiEntity luxianxinxi,
		HttpServletRequest request){
        EntityWrapper<LuxianxinxiEntity> ew = new EntityWrapper<LuxianxinxiEntity>();

		PageUtils page = luxianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LuxianxinxiEntity luxianxinxi, 
		HttpServletRequest request){
        EntityWrapper<LuxianxinxiEntity> ew = new EntityWrapper<LuxianxinxiEntity>();

		PageUtils page = luxianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, luxianxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LuxianxinxiEntity luxianxinxi){
       	EntityWrapper<LuxianxinxiEntity> ew = new EntityWrapper<LuxianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( luxianxinxi, "luxianxinxi")); 
        return R.ok().put("data", luxianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LuxianxinxiEntity luxianxinxi){
        EntityWrapper< LuxianxinxiEntity> ew = new EntityWrapper< LuxianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( luxianxinxi, "luxianxinxi")); 
		LuxianxinxiView luxianxinxiView =  luxianxinxiService.selectView(ew);
		return R.ok("查询路线信息成功").put("data", luxianxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LuxianxinxiEntity luxianxinxi = luxianxinxiService.selectById(id);
        return R.ok().put("data", luxianxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LuxianxinxiEntity luxianxinxi = luxianxinxiService.selectById(id);
        return R.ok().put("data", luxianxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LuxianxinxiEntity luxianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(luxianxinxi);
        luxianxinxiService.insert(luxianxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @IgnoreAuth
    @RequestMapping("/add")
    public R add(@RequestBody LuxianxinxiEntity luxianxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(luxianxinxi);
        luxianxinxiService.insert(luxianxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LuxianxinxiEntity luxianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(luxianxinxi);
        luxianxinxiService.updateById(luxianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        luxianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
