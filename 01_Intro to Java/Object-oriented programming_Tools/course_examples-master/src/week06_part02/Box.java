package week06_part02;

public class Box<T> 
{
	private T data;
	
	public void setData(T obj)
	{   this.data = obj;  }
	
	public T getData()
	{   return this.data;  }
}
