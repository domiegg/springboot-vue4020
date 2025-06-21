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


import com.dao.KuaidipeisongDao;
import com.entity.KuaidipeisongEntity;
import com.service.KuaidipeisongService;
import com.entity.vo.KuaidipeisongVO;
import com.entity.view.KuaidipeisongView;

@Service("kuaidipeisongService")
public class KuaidipeisongServiceImpl extends ServiceImpl<KuaidipeisongDao, KuaidipeisongEntity> implements KuaidipeisongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KuaidipeisongEntity> page = this.selectPage(
                new Query<KuaidipeisongEntity>(params).getPage(),
                new EntityWrapper<KuaidipeisongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KuaidipeisongEntity> wrapper) {
		  Page<KuaidipeisongView> page =new Query<KuaidipeisongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KuaidipeisongVO> selectListVO(Wrapper<KuaidipeisongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KuaidipeisongVO selectVO(Wrapper<KuaidipeisongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KuaidipeisongView> selectListView(Wrapper<KuaidipeisongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KuaidipeisongView selectView(Wrapper<KuaidipeisongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
