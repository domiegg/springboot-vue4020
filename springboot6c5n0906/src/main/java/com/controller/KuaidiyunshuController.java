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

import com.entity.KuaidiyunshuEntity;
import com.entity.view.KuaidiyunshuView;

import com.service.KuaidiyunshuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 快递运输
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/kuaidiyunshu")
public class KuaidiyunshuController {
    @Autowired
    private KuaidiyunshuService kuaidiyunshuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KuaidiyunshuEntity kuaidiyunshu,
		HttpServletRequest request){
        EntityWrapper<KuaidiyunshuEntity> ew = new EntityWrapper<KuaidiyunshuEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("jijianzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("siji")) {
            ew.or();
            ew.eq("sijizhanghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");
		PageUtils page = kuaidiyunshuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidiyunshu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KuaidiyunshuEntity kuaidiyunshu, 
		HttpServletRequest request){
        EntityWrapper<KuaidiyunshuEntity> ew = new EntityWrapper<KuaidiyunshuEntity>();

		PageUtils page = kuaidiyunshuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidiyunshu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KuaidiyunshuEntity kuaidiyunshu){
       	EntityWrapper<KuaidiyunshuEntity> ew = new EntityWrapper<KuaidiyunshuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kuaidiyunshu, "kuaidiyunshu")); 
        return R.ok().put("data", kuaidiyunshuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KuaidiyunshuEntity kuaidiyunshu){
        EntityWrapper< KuaidiyunshuEntity> ew = new EntityWrapper< KuaidiyunshuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kuaidiyunshu, "kuaidiyunshu")); 
		KuaidiyunshuView kuaidiyunshuView =  kuaidiyunshuService.selectView(ew);
		return R.ok("查询快递运输成功").put("data", kuaidiyunshuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KuaidiyunshuEntity kuaidiyunshu = kuaidiyunshuService.selectById(id);
        return R.ok().put("data", kuaidiyunshu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KuaidiyunshuEntity kuaidiyunshu = kuaidiyunshuService.selectById(id);
        return R.ok().put("data", kuaidiyunshu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidiyunshuEntity kuaidiyunshu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidiyunshu);
        kuaidiyunshuService.insert(kuaidiyunshu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KuaidiyunshuEntity kuaidiyunshu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidiyunshu);
        kuaidiyunshuService.insert(kuaidiyunshu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KuaidiyunshuEntity kuaidiyunshu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kuaidiyunshu);
        kuaidiyunshuService.updateById(kuaidiyunshu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kuaidiyunshuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
