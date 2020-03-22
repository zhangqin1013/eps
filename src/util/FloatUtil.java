package util;

public class FloatUtil {
	public static boolean isEmpty(float num){
		String s = String.valueOf(num);
		if("".equals(s)||s==null){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotEmpty(float num){
		String s = String.valueOf(num);
		if(!"".equals(s)&&s!=null){
			return true;
		}else{
			return false;
		}
	}

}
