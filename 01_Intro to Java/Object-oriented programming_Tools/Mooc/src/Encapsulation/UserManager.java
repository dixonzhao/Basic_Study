package Encapsulation;

public class UserManager {
    // 用户信息验证的方法
    public String checkUser(User one, User two) {
       // 判断用户名和密码是否为空，是否一致
    	System.out.println("==========================================");
    	String ret="用户名和密码不一致";
    	if(one.getUserName()!=null&&two.getPassWord()!=null&&one.getPassWord()!=null&&two.getPassWord()!=null){
    		if(one.getPassWord().equals(two.getPassWord())&&one.getUserName().equals(two.getUserName())){
    			ret="用户名和密码一致";
    		}
    	}else
    		ret="输入值有空值";
    	
    	return ret;
    }
}
