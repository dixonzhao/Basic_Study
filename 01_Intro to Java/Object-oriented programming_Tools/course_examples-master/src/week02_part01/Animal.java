package week02_part01;

public class Animal 
{
	// NOTE: Here, we are using a high level definition of species
	private String species;
	
	protected void setSpecies(String theSpecie)
	{
		this.species = theSpecie;
	}
	
	public String getSpecies()
	{	return species; }
	
	
	public String toString()
	{	return species; }
}
