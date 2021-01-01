package orderSalady.common.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.springframework.stereotype.Component;

@Component
public class Util {
	/**
	 * 리다이렉트 주소
	*/
	public String redirectUrl(String url){
		return "redirect:/"+url;
	}
	
	/** 
	 * API 서버 주소
	*/
	public String getApiUrl(){
		return "http://localhost:8090";
	}
	
	/**
	 * 도메인 Map 으로 바꿔주는 메소드
	 * @param obj
	 * @param arrExceptList
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, Object> domainToMapExport(Object obj, String[] arrExceptList)throws Exception{
		HashMap<String, Object> result=new HashMap<String, Object>();
		BeanInfo info=Introspector.getBeanInfo(obj.getClass());
		for(PropertyDescriptor pd:info.getPropertyDescriptors()){
			Method reader=pd.getReadMethod();
			if(reader!=null){
				if(arrExceptList!=null && arrExceptList.length>0 && isContain(arrExceptList, pd.getName()))continue;
				result.put(pd.getName(), reader.invoke(obj));
			}
		}
		return result;
	}
	
	public static String domainToQueryStringExport(Object obj, String[] arrExceptList){
		String result="";
		try{
			BeanInfo info=Introspector.getBeanInfo(obj.getClass());
			Method reader=null;
			for(PropertyDescriptor pd:info.getPropertyDescriptors()){
				reader=pd.getReadMethod();
				if(arrExceptList!=null && arrExceptList.length>0 && isContain(arrExceptList, pd.getName()))continue;
				//result.put(pd.getName(), reader.invoke(obj));
				result+=pd.getName()+"="+reader.invoke(obj)+"&";
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public static Boolean isContain(String[] arrList, String name){
		for(String arr : arrList){
			if(arr.indexOf(name)>-1){
				return true;
			}
		}
		return false;
	}
}