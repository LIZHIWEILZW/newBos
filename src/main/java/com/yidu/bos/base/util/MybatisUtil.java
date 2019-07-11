package com.yidu.bos.base.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	private static SqlSessionFactory factory=null;
	
	private MybatisUtil() {
		
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return null;
	}
	
	public static synchronized SqlSession getSqlSession(){
		if(factory==null){
			String path="mybatis/TestApplicationContext.xml";
			InputStream inputStream=null;
			try {
				inputStream=Resources.getResourceAsStream(path);
				SqlSessionFactoryBuilder sqlSessionFB=new SqlSessionFactoryBuilder();
				factory=sqlSessionFB.build(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
				try {
					if(inputStream!=null){
						inputStream.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return factory.openSession(true);
	}
}
