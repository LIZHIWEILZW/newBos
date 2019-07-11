package com.yidu.bos.base.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import com.yidu.bos.base.domain.Subarea;

@Component
public interface SubareaDao {
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
	//@Param("subarea") String subarea,@Param("province") String province,@Param("city") String city
	public List<Subarea> blurruSelSubarea(Map<String,String> map);
	
	/**
	 * 测试@Param注解的使用，可以不使用数组集合等的情况下，正常传多个参数
	 * @param subareaId
	 * @param subarea
	 * @return
	 */
	List<Subarea> selByIdName(@Param("subareaId") String subareaId,@Param("subarea") String subarea);
}
