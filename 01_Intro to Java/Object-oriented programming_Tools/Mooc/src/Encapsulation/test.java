package Encapsulation;
/*
 * 
 */
public class test {
    // 测试方法
	public static void main(String[] args) {
     //实例化对象，调用相关方法实现运行效果
     User one=new User("Lucy","123456");
     User two=new User("Lucy","123456");
     UserManager um=new UserManager();
     System.out.println(um.checkUser(one, two));
    }

}
