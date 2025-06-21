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


import com.dao.JijianxinxiDao;
import com.entity.JijianxinxiEntity;
import com.service.JijianxinxiService;
import com.entity.vo.JijianxinxiVO;
import com.entity.view.JijianxinxiView;

@Service("jijianxinxiService")
public class JijianxinxiServiceImpl extends ServiceImpl<JijianxinxiDao, JijianxinxiEntity> implements JijianxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JijianxinxiEntity> page = this.selectPage(
                new Query<JijianxinxiEntity>(params).getPage(),
                new EntityWrapper<JijianxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JijianxinxiEntity> wrapper) {
		  Page<JijianxinxiView> page =new Query<JijianxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<JijianxinxiVO> selectListVO(Wrapper<JijianxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JijianxinxiVO selectVO(Wrapper<JijianxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JijianxinxiView> selectListView(Wrapper<JijianxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JijianxinxiView selectView(Wrapper<JijianxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
