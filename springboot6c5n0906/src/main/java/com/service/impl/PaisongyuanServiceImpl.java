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


import com.dao.PaisongyuanDao;
import com.entity.PaisongyuanEntity;
import com.service.PaisongyuanService;
import com.entity.vo.PaisongyuanVO;
import com.entity.view.PaisongyuanView;

@Service("paisongyuanService")
public class PaisongyuanServiceImpl extends ServiceImpl<PaisongyuanDao, PaisongyuanEntity> implements PaisongyuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaisongyuanEntity> page = this.selectPage(
                new Query<PaisongyuanEntity>(params).getPage(),
                new EntityWrapper<PaisongyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaisongyuanEntity> wrapper) {
		  Page<PaisongyuanView> page =new Query<PaisongyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PaisongyuanVO> selectListVO(Wrapper<PaisongyuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PaisongyuanVO selectVO(Wrapper<PaisongyuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PaisongyuanView> selectListView(Wrapper<PaisongyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaisongyuanView selectView(Wrapper<PaisongyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
