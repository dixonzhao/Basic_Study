package Encapsulation;

public class User {
	//���������û���������
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
		System.out.println("�û���:"+userName);
		System.out.println("����:"+passWord);
	}
}
