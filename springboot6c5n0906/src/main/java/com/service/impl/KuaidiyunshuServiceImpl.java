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


import com.dao.KuaidiyunshuDao;
import com.entity.KuaidiyunshuEntity;
import com.service.KuaidiyunshuService;
import com.entity.vo.KuaidiyunshuVO;
import com.entity.view.KuaidiyunshuView;

@Service("kuaidiyunshuService")
public class KuaidiyunshuServiceImpl extends ServiceImpl<KuaidiyunshuDao, KuaidiyunshuEntity> implements KuaidiyunshuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KuaidiyunshuEntity> page = this.selectPage(
                new Query<KuaidiyunshuEntity>(params).getPage(),
                new EntityWrapper<KuaidiyunshuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KuaidiyunshuEntity> wrapper) {
		  Page<KuaidiyunshuView> page =new Query<KuaidiyunshuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KuaidiyunshuVO> selectListVO(Wrapper<KuaidiyunshuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KuaidiyunshuVO selectVO(Wrapper<KuaidiyunshuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KuaidiyunshuView> selectListView(Wrapper<KuaidiyunshuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KuaidiyunshuView selectView(Wrapper<KuaidiyunshuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
