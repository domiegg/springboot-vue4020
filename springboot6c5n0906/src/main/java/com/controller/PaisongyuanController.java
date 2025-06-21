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

import com.entity.PaisongyuanEntity;
import com.entity.view.PaisongyuanView;

import com.service.PaisongyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 派送员
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/paisongyuan")
public class PaisongyuanController {
    @Autowired
    private PaisongyuanService paisongyuanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaisongyuanEntity paisongyuan,
		HttpServletRequest request){
        EntityWrapper<PaisongyuanEntity> ew = new EntityWrapper<PaisongyuanEntity>();

		PageUtils page = paisongyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paisongyuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaisongyuanEntity paisongyuan, 
		HttpServletRequest request){
        EntityWrapper<PaisongyuanEntity> ew = new EntityWrapper<PaisongyuanEntity>();

		PageUtils page = paisongyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paisongyuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaisongyuanEntity paisongyuan){
       	EntityWrapper<PaisongyuanEntity> ew = new EntityWrapper<PaisongyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paisongyuan, "paisongyuan")); 
        return R.ok().put("data", paisongyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaisongyuanEntity paisongyuan){
        EntityWrapper< PaisongyuanEntity> ew = new EntityWrapper< PaisongyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paisongyuan, "paisongyuan")); 
		PaisongyuanView paisongyuanView =  paisongyuanService.selectView(ew);
		return R.ok("查询派送员成功").put("data", paisongyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaisongyuanEntity paisongyuan = paisongyuanService.selectById(id);
        return R.ok().put("data", paisongyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaisongyuanEntity paisongyuan = paisongyuanService.selectById(id);
        return R.ok().put("data", paisongyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaisongyuanEntity paisongyuan, HttpServletRequest request){
        if(paisongyuanService.selectCount(new EntityWrapper<PaisongyuanEntity>().eq("paisongyuanzhanghao", paisongyuan.getPaisongyuanzhanghao()))>0) {
            return R.error("派送员账号已存在");
        }
    	//ValidatorUtils.validateEntity(paisongyuan);
        paisongyuanService.insert(paisongyuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaisongyuanEntity paisongyuan, HttpServletRequest request){
        if(paisongyuanService.selectCount(new EntityWrapper<PaisongyuanEntity>().eq("paisongyuanzhanghao", paisongyuan.getPaisongyuanzhanghao()))>0) {
            return R.error("派送员账号已存在");
        }
    	//ValidatorUtils.validateEntity(paisongyuan);
        paisongyuanService.insert(paisongyuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaisongyuanEntity paisongyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paisongyuan);
        if(paisongyuanService.selectCount(new EntityWrapper<PaisongyuanEntity>().ne("id", paisongyuan.getId()).eq("paisongyuanzhanghao", paisongyuan.getPaisongyuanzhanghao()))>0) {
            return R.error("派送员账号已存在");
        }
        paisongyuanService.updateById(paisongyuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paisongyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
