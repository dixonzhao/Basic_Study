package Encapsulation;

public class UserManager {
    // �û���Ϣ��֤�ķ���
    public String checkUser(User one, User two) {
       // �ж��û����������Ƿ�Ϊ�գ��Ƿ�һ��
    	System.out.println("==========================================");
    	String ret="�û��������벻һ��";
    	if(one.getUserName()!=null&&two.getPassWord()!=null&&one.getPassWord()!=null&&two.getPassWord()!=null){
    		if(one.getPassWord().equals(two.getPassWord())&&one.getUserName().equals(two.getUserName())){
    			ret="�û���������һ��";
    		}
    	}else
    		ret="����ֵ�п�ֵ";
    	
    	return ret;
    }
}
