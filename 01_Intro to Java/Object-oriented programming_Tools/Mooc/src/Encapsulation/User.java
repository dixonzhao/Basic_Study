package Encapsulation;

public class User {
	//定义属性用户名、密码
	private String userName;
	private String passWord;
	public String getUserName() {
		return userName;
	}
	public String getPassWord() {
		return passWord;
	}
	
	User(String userName, String passWord){
		this.userName=userName;
		this.passWord=passWord;
		System.out.println("用户名:"+userName);
		System.out.println("密码:"+passWord);
	}
}
