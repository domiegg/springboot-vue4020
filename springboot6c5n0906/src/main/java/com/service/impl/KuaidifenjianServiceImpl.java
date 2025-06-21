package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KuaidifenjianDao;
import com.entity.KuaidifenjianEntity;
import com.service.KuaidifenjianService;
import com.entity.vo.KuaidifenjianVO;
import com.entity.view.KuaidifenjianView;

@Service("kuaidifenjianService")
public class KuaidifenjianServiceImpl extends ServiceImpl<KuaidifenjianDao, KuaidifenjianEntity> implements KuaidifenjianService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KuaidifenjianEntity> page = this.selectPage(
                new Query<KuaidifenjianEntity>(params).getPage(),
                new EntityWrapper<KuaidifenjianEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KuaidifenjianEntity> wrapper) {
		  Page<KuaidifenjianView> page =new Query<KuaidifenjianView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KuaidifenjianVO> selectListVO(Wrapper<KuaidifenjianEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KuaidifenjianVO selectVO(Wrapper<KuaidifenjianEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KuaidifenjianView> selectListView(Wrapper<KuaidifenjianEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KuaidifenjianView selectView(Wrapper<KuaidifenjianEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
