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


import com.dao.LuxianxinxiDao;
import com.entity.LuxianxinxiEntity;
import com.service.LuxianxinxiService;
import com.entity.vo.LuxianxinxiVO;
import com.entity.view.LuxianxinxiView;

@Service("luxianxinxiService")
public class LuxianxinxiServiceImpl extends ServiceImpl<LuxianxinxiDao, LuxianxinxiEntity> implements LuxianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<LuxianxinxiEntity> page = this.selectPage(
                new Query<LuxianxinxiEntity>(params).getPage(),
                new EntityWrapper<LuxianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<LuxianxinxiEntity> wrapper) {
		  Page<LuxianxinxiView> page =new Query<LuxianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<LuxianxinxiVO> selectListVO(Wrapper<LuxianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public LuxianxinxiVO selectVO(Wrapper<LuxianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<LuxianxinxiView> selectListView(Wrapper<LuxianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public LuxianxinxiView selectView(Wrapper<LuxianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
