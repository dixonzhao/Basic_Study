package week02_part01;

import java.awt.Color;

public class Bear extends Mammal 
{
	private int color;
	private boolean isPolar;

	public Bear(boolean polar) 
	{
		// implicitly calls the constructor of the super class
		this.isPolar = polar;
		
		setSpecies("Bear");
	}

	/**
	 * Accessor method which return he color of the bear.
	 * If it is a polar bear return white, otherwise return black.
	 */
	public Color getColor() 
	{
		if (this.isPolar) 
		{
			return Color.WHITE;
		} 
		else 
		{
			return Color.BLACK;
		}
	}

	public String toString() 
	{
		String info = "";
		info += super.toString();
		info += " " + getColor();
		return info;
	}
}
