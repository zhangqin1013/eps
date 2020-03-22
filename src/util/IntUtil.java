package util;

public class IntUtil{
	public static boolean isEmpty(int interger){
		String s = String.valueOf(interger);
		if("".equals(s)||s==null){
			return true;
		}else{
			return false;
		}
	}
	public static boolean isNotEmpty(int interger){
		String s = String.valueOf(interger);
		if(!"".equals(s)&&s!=null){
			return true;
		}else{
			return false;
		}
	}
}