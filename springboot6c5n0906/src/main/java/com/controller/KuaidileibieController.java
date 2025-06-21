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

import com.entity.KuaidileibieEntity;
import com.entity.view.KuaidileibieView;

import com.service.KuaidileibieService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 快递类别
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/kuaidileibie")
public class KuaidileibieController {
    @Autowired
    private KuaidileibieService kuaidileibieService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KuaidileibieEntity kuaidileibie,
		HttpServletRequest request){
        EntityWrapper<KuaidileibieEntity> ew = new EntityWrapper<KuaidileibieEntity>();

		PageUtils page = kuaidileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidileibie), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KuaidileibieEntity kuaidileibie, 
		HttpServletRequest request){
        EntityWrapper<KuaidileibieEntity> ew = new EntityWrapper<KuaidileibieEntity>();

		PageUtils page = kuaidileibieService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidileibie), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KuaidileibieEntity kuaidileibie){
       	EntityWrapper<KuaidileibieEntity> ew = new EntityWrapper<KuaidileibieEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kuaidileibie, "kuaidileibie")); 
        return R.ok().put("data", kuaidileibieService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KuaidileibieEntity kuaidileibie){
        EntityWrapper< KuaidileibieEntity> ew = new EntityWrapper< KuaidileibieEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kuaidileibie, "kuaidileibie")); 
		KuaidileibieView kuaidileibieView =  kuaidileibieService.selectView(ew);
		return R.ok("查询快递类别成功").put("data", kuaidileibieView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KuaidileibieEntity kuaidileibie = kuaidileibieService.selectById(id);
        return R.ok().put("data", kuaidileibie);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KuaidileibieEntity kuaidileibie = kuaidileibieService.selectById(id);
        return R.ok().put("data", kuaidileibie);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidileibieEntity kuaidileibie, HttpServletRequest request){
        if(kuaidileibieService.selectCount(new EntityWrapper<KuaidileibieEntity>().eq("kuaidileibie", kuaidileibie.getKuaidileibie()))>0) {
            return R.error("快递类别已存在");
        }
    	//ValidatorUtils.validateEntity(kuaidileibie);
        kuaidileibieService.insert(kuaidileibie);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KuaidileibieEntity kuaidileibie, HttpServletRequest request){
        if(kuaidileibieService.selectCount(new EntityWrapper<KuaidileibieEntity>().eq("kuaidileibie", kuaidileibie.getKuaidileibie()))>0) {
            return R.error("快递类别已存在");
        }
    	//ValidatorUtils.validateEntity(kuaidileibie);
        kuaidileibieService.insert(kuaidileibie);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KuaidileibieEntity kuaidileibie, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kuaidileibie);
        if(kuaidileibieService.selectCount(new EntityWrapper<KuaidileibieEntity>().ne("id", kuaidileibie.getId()).eq("kuaidileibie", kuaidileibie.getKuaidileibie()))>0) {
            return R.error("快递类别已存在");
        }
        kuaidileibieService.updateById(kuaidileibie);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kuaidileibieService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
