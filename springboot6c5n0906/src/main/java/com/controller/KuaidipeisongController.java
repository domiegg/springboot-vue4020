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

import com.entity.KuaidipeisongEntity;
import com.entity.view.KuaidipeisongView;

import com.service.KuaidipeisongService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 快递配送
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-21 11:46:12
 */
@RestController
@RequestMapping("/kuaidipeisong")
public class KuaidipeisongController {
    @Autowired
    private KuaidipeisongService kuaidipeisongService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,KuaidipeisongEntity kuaidipeisong,
		HttpServletRequest request){
        EntityWrapper<KuaidipeisongEntity> ew = new EntityWrapper<KuaidipeisongEntity>();

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
		PageUtils page = kuaidipeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidipeisong), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,KuaidipeisongEntity kuaidipeisong, 
		HttpServletRequest request){
        EntityWrapper<KuaidipeisongEntity> ew = new EntityWrapper<KuaidipeisongEntity>();

		PageUtils page = kuaidipeisongService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, kuaidipeisong), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( KuaidipeisongEntity kuaidipeisong){
       	EntityWrapper<KuaidipeisongEntity> ew = new EntityWrapper<KuaidipeisongEntity>();
      	ew.allEq(MPUtil.allEQMapPre( kuaidipeisong, "kuaidipeisong")); 
        return R.ok().put("data", kuaidipeisongService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(KuaidipeisongEntity kuaidipeisong){
        EntityWrapper< KuaidipeisongEntity> ew = new EntityWrapper< KuaidipeisongEntity>();
 		ew.allEq(MPUtil.allEQMapPre( kuaidipeisong, "kuaidipeisong")); 
		KuaidipeisongView kuaidipeisongView =  kuaidipeisongService.selectView(ew);
		return R.ok("查询快递配送成功").put("data", kuaidipeisongView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        KuaidipeisongEntity kuaidipeisong = kuaidipeisongService.selectById(id);
        return R.ok().put("data", kuaidipeisong);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        KuaidipeisongEntity kuaidipeisong = kuaidipeisongService.selectById(id);
        return R.ok().put("data", kuaidipeisong);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody KuaidipeisongEntity kuaidipeisong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidipeisong);
        kuaidipeisongService.insert(kuaidipeisong);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody KuaidipeisongEntity kuaidipeisong, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(kuaidipeisong);
        kuaidipeisongService.insert(kuaidipeisong);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody KuaidipeisongEntity kuaidipeisong, HttpServletRequest request){
        //ValidatorUtils.validateEntity(kuaidipeisong);
        kuaidipeisongService.updateById(kuaidipeisong);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<KuaidipeisongEntity> list = new ArrayList<KuaidipeisongEntity>();
        for(Long id : ids) {
            KuaidipeisongEntity kuaidipeisong = kuaidipeisongService.selectById(id);
            kuaidipeisong.setSfsh(sfsh);
            kuaidipeisong.setShhf(shhf);
            list.add(kuaidipeisong);
        }
        kuaidipeisongService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        kuaidipeisongService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
