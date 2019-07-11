package com.yidu.bos.base.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yidu.bos.base.biz.SubareaBiz;
import com.yidu.bos.base.dao.SubareaDao;
import com.yidu.bos.base.domain.Msg;
import com.yidu.bos.base.domain.Subarea;
import com.yidu.bos.base.util.MybatisUtil;

import net.sf.json.JSONObject;

/*import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;*/

@Controller
public class SubareaController {
	@Autowired
	private  SubareaBiz subareaBizImpl;
	
	
	
/*	public Properties getEmpThead1(){
		Properties properties=new Properties();
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("thead.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(properties);
		return  properties;
	}*/
	/**
	 * 获取表格头部信息
	 * @return
	 */
	@RequestMapping("/thead")
	@ResponseBody
	public Map<String,Object> getSubareaThead(){
		Map<String,Object> map=new LinkedHashMap<String, Object>();
		map.put("subareaId", "分区ID");
		map.put("sortCode", "分拣码");
		map.put("subarea", "分区名");
		map.put("position", "具体位置");
		map.put("areaId", "所属区域Id");
		return map;
	}
	/**
	 * 根据id查询,修改时需要
	 * @param empid
	 * @return
	 */
	@RequestMapping(value="/subarea/{empid}",method=RequestMethod.GET)
	@ResponseBody
	public Msg getEmpById(@PathVariable("empid") String subareaId,HttpServletRequest request){
		Subarea subarea=subareaBizImpl.findSubareaById(subareaId);
		//request.setAttribute("subarea", subarea);
		//System.out.println("根据id查询"+subarea);
		return Msg.success().add("subarea", subarea);
	}
	
	
	/**
	 * 获取分页信息
	 * @param pn
	 * @return
	 */
	@RequestMapping("/emps")
	@ResponseBody
	public Msg getSubareas(@RequestParam(value="pn",defaultValue="1") Integer pn){
		
		//引入Mybatis PageHelper分页插件
		//查询之前调用，传入页码和大小
		PageHelper.startPage(pn, 4);
		List<Subarea> subareaList=null;
		//startPage 之后再查询
		subareaList=subareaBizImpl.findAllSubarea();
		
		//使用pageInfo封装查询后的结果，5是连续显示的页数
		PageInfo<Subarea> pageInfo=new PageInfo<Subarea>(subareaList);
		return Msg.success().add("pageInfo", pageInfo).add("headInfo", this.getSubareaThead());
	}
    
	
	/**
	 * 模糊复合查询并获取分页信息
	 * @param pn
	 * @return
	 */
	@RequestMapping("/bluQuery/{queryStrsMap}")
	@ResponseBody
	public Msg getSubareas(@RequestParam(value="pn",defaultValue="1") Integer pn,@PathVariable("queryStrsMap")String queryStrsMap){
		JSONObject jb = JSONObject.fromObject(queryStrsMap);
		Map<String,String> map = (Map)jb;
		//System.out.println(map.get);
		
		
		List<Subarea> subareas = subareaBizImpl.blurruSelSubarea(map);
		for (Subarea subarea : subareas) {
			System.out.println(subarea);
		}
		
		//引入Mybatis PageHelper分页插件
		//查询之前调用，传入页码和大小
		PageHelper.startPage(pn, 4);
		
		List<Subarea> subareaList=null;
		
		//startPage 之后再查询
		//subareaList=blurruSelSubarea;
		//使用pageInfo封装查询后的结果，5是连续显示的页数
		PageInfo<Subarea> pageInfo=new PageInfo<Subarea>(subareaList,5);
		return Msg.success().add("pageInfo", pageInfo).add("headInfo", this.getSubareaThead());
	}
	
	
	
	
	
	
	/**
	 * 新增一个员工
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/subarea",method=RequestMethod.POST)
	@ResponseBody
	public Msg addSubarea(Subarea subarea){
		//System.out.println(subarea);
		boolean result=subareaBizImpl.addSubarea(subarea);
		if(result){
			return Msg.success();
		}
		return Msg.fail();
	}
	/**
	 * 
	 * 删除单个员工和批量删除2和一
	 * @return
	 */
	@RequestMapping(value="/subarea/{subareaIds}",method=RequestMethod.DELETE)
	@ResponseBody
	public Msg delSubarea(@PathVariable("subareaIds") String subareaIds){
		//System.out.println(subareaIds);
		if(subareaIds.contains("-")){
			String[] subareaIdArray=subareaIds.split("-");
			//System.out.println(Arrays.toString(subareaIdArray));
			subareaBizImpl.deleteSubareas(subareaIdArray);
		}else{
			subareaBizImpl.deleteSubarea(subareaIds);
		}
		return Msg.success();
	}
	/**
	 * 更新员工信息
	 * @param emp
	 * @return
	 */
	@RequestMapping(value="/subarea/{subArea}",method=RequestMethod.PUT)
	@ResponseBody
	public Msg updateSubarea(Subarea subarea){
		System.out.println("更新员工信息"+subarea);
		subareaBizImpl.updateSubarea(subarea);
		return Msg.success();
	}
}
