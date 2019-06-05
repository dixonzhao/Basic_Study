package Encapsulation;

public class CodeBlock {
	   // 创建CodeBlock的构造块
	{
		System.out.println("CodeBlock的构造块");
	}


	   //创建CodeBlock的静态代码块
		
		static {
			System.out.println("CodeBlock的静态代码块");
		}

	   //创建CodeBlock的构造方法
		CodeBlock(){
			System.out.println("CodeBlock的构造方法");
			Code co=new Code();
		}


	   public static void main(String[] args){
	      //编写代码测试运行优先顺序，运行结果参见效果图
	      CodeBlock cb=new CodeBlock();
	         
	   }
}
