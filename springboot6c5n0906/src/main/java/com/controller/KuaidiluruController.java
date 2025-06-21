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

import com.entity.KuaidiluruEntity;
import com.entity.view.KuaidiluruView;

import com.service.KuaidiluruService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 快递录入
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/kuaidiluru")
public class KuaidiluruController {
    @Autowired
    private KuaidiluruService kuaidiluruService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KuaidiluruEntity kuaidiluru,
		HttpServletRequest request){
        EntityWrapper<KuaidiluruEntity> ew = new EntityWrapper<KuaidiluruEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("jijianzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");
		PageUtils page = kuaidiluruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidiluru), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KuaidiluruEntity kuaidiluru, 
		HttpServletRequest request){
        EntityWrapper<KuaidiluruEntity> ew = new EntityWrapper<KuaidiluruEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("jijianzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("zhanghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");
		PageUtils page = kuaidiluruService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidiluru), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KuaidiluruEntity kuaidiluru){
       	EntityWrapper<KuaidiluruEntity> ew = new EntityWrapper<KuaidiluruEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kuaidiluru, "kuaidiluru")); 
        return R.ok().put("data", kuaidiluruService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KuaidiluruEntity kuaidiluru){
        EntityWrapper< KuaidiluruEntity> ew = new EntityWrapper< KuaidiluruEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kuaidiluru, "kuaidiluru")); 
		KuaidiluruView kuaidiluruView =  kuaidiluruService.selectView(ew);
		return R.ok("查询快递录入成功").put("data", kuaidiluruView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KuaidiluruEntity kuaidiluru = kuaidiluruService.selectById(id);
        return R.ok().put("data", kuaidiluru);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KuaidiluruEntity kuaidiluru = kuaidiluruService.selectById(id);
        return R.ok().put("data", kuaidiluru);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidiluruEntity kuaidiluru, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidiluru);
        kuaidiluruService.insert(kuaidiluru);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KuaidiluruEntity kuaidiluru, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidiluru);
    	kuaidiluru.setUserid((Long)request.getSession().getAttribute("userId"));
        kuaidiluruService.insert(kuaidiluru);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KuaidiluruEntity kuaidiluru, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kuaidiluru);
        kuaidiluruService.updateById(kuaidiluru);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kuaidiluruService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
