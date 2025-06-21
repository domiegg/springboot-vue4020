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

import com.entity.SijiEntity;
import com.entity.view.SijiView;

import com.service.SijiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 司机
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/siji")
public class SijiController {
    @Autowired
    private SijiService sijiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,SijiEntity siji,
		HttpServletRequest request){
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();

		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,SijiEntity siji, 
		HttpServletRequest request){
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();

		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( SijiEntity siji){
       	EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( siji, "siji")); 
        return R.ok().put("data", sijiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(SijiEntity siji){
        EntityWrapper< SijiEntity> ew = new EntityWrapper< SijiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( siji, "siji")); 
		SijiView sijiView =  sijiService.selectView(ew);
		return R.ok("查询司机成功").put("data", sijiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.selectById(id);
		siji.setClicktime(new Date());
		sijiService.updateById(siji);
        siji = sijiService.selectView(new EntityWrapper<SijiEntity>().eq("id", id));
        return R.ok().put("data", siji);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        SijiEntity siji = sijiService.selectById(id);
		siji.setClicktime(new Date());
		sijiService.updateById(siji);
        siji = sijiService.selectView(new EntityWrapper<SijiEntity>().eq("id", id));
        return R.ok().put("data", siji);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SijiEntity siji, HttpServletRequest request){
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
    	//ValidatorUtils.validateEntity(siji);
        sijiService.insert(siji);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody SijiEntity siji, HttpServletRequest request){
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
    	//ValidatorUtils.validateEntity(siji);
        sijiService.insert(siji);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody SijiEntity siji, HttpServletRequest request){
        //ValidatorUtils.validateEntity(siji);
        if(sijiService.selectCount(new EntityWrapper<SijiEntity>().ne("id", siji.getId()).eq("sijizhanghao", siji.getSijizhanghao()))>0) {
            return R.error("司机账号已存在");
        }
        sijiService.updateById(siji);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        sijiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,SijiEntity siji, HttpServletRequest request,String pre){
        EntityWrapper<SijiEntity> ew = new EntityWrapper<SijiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = sijiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, siji), params), params));
        return R.ok().put("data", page);
    }










}
