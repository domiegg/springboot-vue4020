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


import com.dao.KuaidiluruDao;
import com.entity.KuaidiluruEntity;
import com.service.KuaidiluruService;
import com.entity.vo.KuaidiluruVO;
import com.entity.view.KuaidiluruView;

@Service("kuaidiluruService")
public class KuaidiluruServiceImpl extends ServiceImpl<KuaidiluruDao, KuaidiluruEntity> implements KuaidiluruService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KuaidiluruEntity> page = this.selectPage(
                new Query<KuaidiluruEntity>(params).getPage(),
                new EntityWrapper<KuaidiluruEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KuaidiluruEntity> wrapper) {
		  Page<KuaidiluruView> page =new Query<KuaidiluruView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<KuaidiluruVO> selectListVO(Wrapper<KuaidiluruEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KuaidiluruVO selectVO(Wrapper<KuaidiluruEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KuaidiluruView> selectListView(Wrapper<KuaidiluruEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KuaidiluruView selectView(Wrapper<KuaidiluruEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
