package com.yidu.bos.base.biz;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yidu.bos.base.domain.Subarea;

public interface SubareaBiz {
	/**
	 * 查询所有分区
	 * @return
	 */
	public List<Subarea> findAllSubarea();
	
	/**
	 * 根据id查询分区
	 * @return
	 */
	public Subarea findSubareaById(String subareaId);
	
	/**
	 * 添加分区
	 * @param subarea
	 * @return
	 */
	public boolean addSubarea(Subarea subarea);
	
	/**
	 * 通过Id逻辑删除分区
	 * @param subarea
	 * @return
	 */
	public boolean deleteSubarea(String subareaId);
	
	/**
	 * 通过Id逻辑批量删除分区
	 * @param subarea
	 * @return
	 */
	public boolean deleteSubareas(String[] subareaId);
	
	/**
	 * 修改分区
	 * @param subarea
	 * @return
	 */
	public boolean updateSubarea(Subarea subarea);
	
	/**
	 * 模糊查询
	 * @param subarea
	 * @return
	 */
	public List<Subarea> blurruSelSubarea(Map<String,String> map);
}
