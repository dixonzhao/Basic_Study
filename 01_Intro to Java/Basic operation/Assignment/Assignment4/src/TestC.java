import java.util.Arrays;
public class TestC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] arra2=new int[6][];
		arra2[0]= new int[6];
		arra2[1] = new int[5];
		arra2[2] = new int[4];
		arra2[3] = new int[3];
		arra2[4] = new int[2];
		arra2[5] = new int[1];
		 for(int i=0;i<arra2.length;i++){
			   for(int j=0;j<arra2[i].length;j++){
			    System.out.print(arra2[i][j]);    
			   }
			   System.out.println();
			  }
	}

}


class Duowei  
{  
    public void Duowei(int[][] arra2)  
    {  
        int arr[][]=arra2;  
        //数组中未赋值部分默认为0  

        for(int i=0;i<4;i++)  
        {  
            for(int j=0;j<6;j++)  
            {  
                System.out.print(arr[i][j]+" ");  
            }  
            System.out.println("\n");  
        }  
    }  
}  