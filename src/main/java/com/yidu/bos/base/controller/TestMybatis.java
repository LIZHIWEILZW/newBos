package com.yidu.bos.base.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yidu.bos.base.biz.SubareaBiz;
import com.yidu.bos.base.biz.impl.SubareaBizImpl;
import com.yidu.bos.base.dao.SubareaDao;
import com.yidu.bos.base.domain.Subarea;
import com.yidu.bos.base.util.MybatisUtil;




public class TestMybatis {
	
	private  SubareaBizImpl subareaBizImpl;
	

	public static void main(String[] args) {
		ApplicationContext acc=new ClassPathXmlApplicationContext("spring/spring.xml");
		
		
		TestMybatis t=new TestMybatis();
		//testFindAllSubarea();
		//testDeleteSubarea();
		//testFindSubareaById();
		//testAddSubarea();
		//testDeleteSubarea();
		//testUpdateSubarea();
		//testDeleteSubareas();
		//testFindAllSubarea();
		t.testBlurruSelSubarea();
		for(String string:acc.getBeanDefinitionNames()){
			System.out.println(string);
		}
		//testSelByIdName();
	}
	
	
	
	public void testBlurruSelSubarea(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		
		//List<Subarea> subareas = subareaBizImpl.blurruSelSubarea("3",null,null);
		
		//List<Subarea> subareas = SubareaDao.blurruSelSubarea("3",null,null);
		Map<String,String> map=new HashMap<String,String>();
		map.put("subarea", "3");
		List<Subarea> subareas = SubareaDao.blurruSelSubarea(map);
		for (Subarea subarea : subareas) {
			System.out.println(subarea);
		}
	}
	
	
	
	public static void testFindAllSubarea(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		List<Subarea> SubareaList=SubareaDao.findAllSubarea();
		for(Subarea Subarea:SubareaList){
			System.out.println(Subarea);
		}
	}
	
	/*public static void testDeleteSubarea(){
		String[] ids={"divi001","divi002"};
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		if(SubareaDao.deleteSubarea(ids)){
			System.out.println("�ɹ�");
		}
	}*/
	
	public static void testFindSubareaById(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		Subarea subarea=SubareaDao.findSubareaById("divi001");
		System.out.println(subarea);
	}
	
	
	public static void testAddSubarea(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		Subarea subarea=new Subarea("divi003","003","3����","������","A003","������","������","������","sa003","����3","auto","003","050","dan","a","y","�����з���");
		if(SubareaDao.addSubarea(subarea)){
			System.out.println("�ɹ�");
		}
	}
	
	public static void testDeleteSubarea(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		if(SubareaDao.deleteSubarea("divi003")){
			System.out.println("�ɹ�");
		}
	}
	
	public static void testDeleteSubareas(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		String[] subareas={"divi003","divi002"};
		if(SubareaDao.deleteSubareas(subareas)){
			System.out.println("�ɹ�");
		}
	}
	
	public static void testUpdateSubarea(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		Subarea subarea=new Subarea("divi003","3����a","����a");
		if(SubareaDao.updateSubarea(subarea)){
			System.out.println("�ɹ�");
		}
	}
	
	public static void testSelByIdName(){
		SqlSession sqlSession=MybatisUtil.getSqlSession();
		SubareaDao SubareaDao=sqlSession.getMapper(SubareaDao.class);
		List<Subarea> subareas = SubareaDao.selByIdName("divi003", "1����");
		for (Subarea subarea : subareas) {
			System.out.println(subarea);
		}
	}
	
	
	
}




























