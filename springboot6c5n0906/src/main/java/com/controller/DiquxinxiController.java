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

import com.entity.DiquxinxiEntity;
import com.entity.view.DiquxinxiView;

import com.service.DiquxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 地区信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/diquxinxi")
public class DiquxinxiController {
    @Autowired
    private DiquxinxiService diquxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiquxinxiEntity diquxinxi,
		HttpServletRequest request){
        EntityWrapper<DiquxinxiEntity> ew = new EntityWrapper<DiquxinxiEntity>();

		PageUtils page = diquxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diquxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiquxinxiEntity diquxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiquxinxiEntity> ew = new EntityWrapper<DiquxinxiEntity>();

		PageUtils page = diquxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, diquxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiquxinxiEntity diquxinxi){
       	EntityWrapper<DiquxinxiEntity> ew = new EntityWrapper<DiquxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( diquxinxi, "diquxinxi")); 
        return R.ok().put("data", diquxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiquxinxiEntity diquxinxi){
        EntityWrapper< DiquxinxiEntity> ew = new EntityWrapper< DiquxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( diquxinxi, "diquxinxi")); 
		DiquxinxiView diquxinxiView =  diquxinxiService.selectView(ew);
		return R.ok("查询地区信息成功").put("data", diquxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiquxinxiEntity diquxinxi = diquxinxiService.selectById(id);
        return R.ok().put("data", diquxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiquxinxiEntity diquxinxi = diquxinxiService.selectById(id);
        return R.ok().put("data", diquxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiquxinxiEntity diquxinxi, HttpServletRequest request){
        if(diquxinxiService.selectCount(new EntityWrapper<DiquxinxiEntity>().eq("diqu", diquxinxi.getDiqu()))>0) {
            return R.error("地区已存在");
        }
    	//ValidatorUtils.validateEntity(diquxinxi);
        diquxinxiService.insert(diquxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiquxinxiEntity diquxinxi, HttpServletRequest request){
        if(diquxinxiService.selectCount(new EntityWrapper<DiquxinxiEntity>().eq("diqu", diquxinxi.getDiqu()))>0) {
            return R.error("地区已存在");
        }
    	//ValidatorUtils.validateEntity(diquxinxi);
        diquxinxiService.insert(diquxinxi);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DiquxinxiEntity diquxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(diquxinxi);
        if(diquxinxiService.selectCount(new EntityWrapper<DiquxinxiEntity>().ne("id", diquxinxi.getId()).eq("diqu", diquxinxi.getDiqu()))>0) {
            return R.error("地区已存在");
        }
        diquxinxiService.updateById(diquxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        diquxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
