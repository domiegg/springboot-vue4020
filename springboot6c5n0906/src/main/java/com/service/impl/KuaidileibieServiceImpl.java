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


import com.dao.KuaidileibieDao;
import com.entity.KuaidileibieEntity;
import com.service.KuaidileibieService;
import com.entity.vo.KuaidileibieVO;
import com.entity.view.KuaidileibieView;

@Service("kuaidileibieService")
public class KuaidileibieServiceImpl extends ServiceImpl<KuaidileibieDao, KuaidileibieEntity> implements KuaidileibieService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KuaidileibieEntity> page = this.selectPage(
                new Query<KuaidileibieEntity>(params).getPage(),
                new EntityWrapper<KuaidileibieEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KuaidileibieEntity> wrapper) {
		  Page<KuaidileibieView> page =new Query<KuaidileibieView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KuaidileibieVO> selectListVO(Wrapper<KuaidileibieEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KuaidileibieVO selectVO(Wrapper<KuaidileibieEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KuaidileibieView> selectListView(Wrapper<KuaidileibieEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KuaidileibieView selectView(Wrapper<KuaidileibieEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
