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

import com.entity.KuaidifenjianEntity;
import com.entity.view.KuaidifenjianView;

import com.service.KuaidifenjianService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 快递分拣
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/kuaidifenjian")
public class KuaidifenjianController {
    @Autowired
    private KuaidifenjianService kuaidifenjianService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KuaidifenjianEntity kuaidifenjian,
		HttpServletRequest request){
        EntityWrapper<KuaidifenjianEntity> ew = new EntityWrapper<KuaidifenjianEntity>();

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
		PageUtils page = kuaidifenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidifenjian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KuaidifenjianEntity kuaidifenjian, 
		HttpServletRequest request){
        EntityWrapper<KuaidifenjianEntity> ew = new EntityWrapper<KuaidifenjianEntity>();

		PageUtils page = kuaidifenjianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidifenjian), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KuaidifenjianEntity kuaidifenjian){
       	EntityWrapper<KuaidifenjianEntity> ew = new EntityWrapper<KuaidifenjianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kuaidifenjian, "kuaidifenjian")); 
        return R.ok().put("data", kuaidifenjianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KuaidifenjianEntity kuaidifenjian){
        EntityWrapper< KuaidifenjianEntity> ew = new EntityWrapper< KuaidifenjianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kuaidifenjian, "kuaidifenjian")); 
		KuaidifenjianView kuaidifenjianView =  kuaidifenjianService.selectView(ew);
		return R.ok("查询快递分拣成功").put("data", kuaidifenjianView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KuaidifenjianEntity kuaidifenjian = kuaidifenjianService.selectById(id);
        return R.ok().put("data", kuaidifenjian);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KuaidifenjianEntity kuaidifenjian = kuaidifenjianService.selectById(id);
        return R.ok().put("data", kuaidifenjian);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidifenjianEntity kuaidifenjian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidifenjian);
        kuaidifenjianService.insert(kuaidifenjian);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KuaidifenjianEntity kuaidifenjian, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidifenjian);
        kuaidifenjianService.insert(kuaidifenjian);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KuaidifenjianEntity kuaidifenjian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kuaidifenjian);
        kuaidifenjianService.updateById(kuaidifenjian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kuaidifenjianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
