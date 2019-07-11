package com.yidu.bos.base.domain;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	//成功返回100，失败返回200
	private int code;
	//详细信息
	private String msg;
	//封装要返回的数据
	Map<String,Object> map=new HashMap<String,Object>();
	
	//成功调用的方法
	public static Msg success(){
		Msg msg=new Msg();
		msg.setCode(100);
		msg.setMsg("成功");
		return msg;
	}
	//成功调用的方法
		public static Msg fail(){
			Msg msg=new Msg();
			msg.setCode(200);
			msg.setMsg("失败");
			return msg;
		}
		
	   public Msg add(String key,Object value){
			this.getMap().put(key, value);
			return this;
		}
	public Msg(int code, String msg, Map<String, Object> map) {
		super();
		this.code = code;
		this.msg = msg;
		this.map = map;
	}
	public Msg() {
	
	
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
}
