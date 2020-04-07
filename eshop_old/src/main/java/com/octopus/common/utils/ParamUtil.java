package com.octopus.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 为mybatis的生成的list方法实现查询参数的绑定
 * @author jason
 *
 */
public class ParamUtil {
	private ParamUtil(){
		
	}
	/**
	 * 为查询构建参数，参数列表依次为String的参数名，Object的参数值
	 * @param params
	 * @return 构建好的参数集合
	 */
	public static Map<String,Object> buildParams(Object ... params){
		Map<String, Object> paramRtv = new HashMap<>(params.length/2);
		for(int i=0;i<params.length;i+=2){
			paramRtv.put(params[i].toString(),params[i+1]);
		}
		return paramRtv;
	}
}
