package com.yidu.bos.base.biz.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.bos.base.biz.SubareaBiz;
import com.yidu.bos.base.dao.SubareaDao;
import com.yidu.bos.base.domain.Subarea;


@Service
public class SubareaBizImpl implements SubareaBiz{
	
	@Autowired
	SubareaDao subareaDao;
	
	public List<Subarea> findAllSubarea() {
		return subareaDao.findAllSubarea();
	}

	public Subarea findSubareaById(String subareaId) {
		// TODO Auto-generated method stub
		return subareaDao.findSubareaById(subareaId);
	}

	public boolean addSubarea(Subarea subarea) {
		// TODO Auto-generated method stub
		return subareaDao.addSubarea(subarea);
	}

	public boolean deleteSubarea(String subareaId) {
		
		return subareaDao.deleteSubarea(subareaId);
	}

	public boolean deleteSubareas(String[] subareaId) {
		return subareaDao.deleteSubareas(subareaId);
	}

	public boolean updateSubarea(Subarea subarea) {
		return subareaDao.updateSubarea(subarea);
	}

	public List<Subarea> blurruSelSubarea(Map<String,String> map) {
		return subareaDao.blurruSelSubarea(map);
	}


}


