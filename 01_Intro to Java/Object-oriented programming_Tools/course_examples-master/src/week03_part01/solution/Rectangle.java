package week03_part01.solution;

public class Rectangle implements Shape
{
	private double width;
	private double height;
	
	public Rectangle(int width, int height)
	{
		this.width = width;
		this.height = height;
	}
	
	
	@Override
	public double getArea() {
		double area = this.width * this.height;
		return area;
	}

	@Override
	public void draw() {
		System.out.println("Rectangle : drawing...");
		
	}
	
	
	public double getWidth()
	{	return width; }
	
	public double getHeight()
	{	return height; }

}
