package Encapsulation;

public class CodeBlock {
	   // ����CodeBlock�Ĺ����
	{
		System.out.println("CodeBlock�Ĺ����");
	}


	   //����CodeBlock�ľ�̬�����
		
		static {
			System.out.println("CodeBlock�ľ�̬�����");
		}

	   //����CodeBlock�Ĺ��췽��
		CodeBlock(){
			System.out.println("CodeBlock�Ĺ��췽��");
			Code co=new Code();
		}


	   public static void main(String[] args){
	      //��д���������������˳�����н���μ�Ч��ͼ
	      CodeBlock cb=new CodeBlock();
	         
	   }
}
