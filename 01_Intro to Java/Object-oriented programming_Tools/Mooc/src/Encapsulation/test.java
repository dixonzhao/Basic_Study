package Encapsulation;
/*
 * 
 */
public class test {
    // ���Է���
	public static void main(String[] args) {
     //ʵ�������󣬵�����ط���ʵ������Ч��
     User one=new User("Lucy","123456");
     User two=new User("Lucy","123456");
     UserManager um=new UserManager();
     System.out.println(um.checkUser(one, two));
    }

}
