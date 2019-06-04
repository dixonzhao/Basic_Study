package week02_part01;

public class Dog extends Mammal
{ 
    private String name;

    public Dog(int newAge, String newName)
    { 
      super(newAge);
      setName(newName);
    }

    public void Bark(int count)
    { 
    	for (int i=0; i < count; i++)
    		System.out.print ( "woof "); 
    	System.out.println();
    }
    
    private String getName() 
    {   return name; }

    private void setName ( String newName ) 
    {   name = newName; }

    public void printDog()
    {   System.out.println ( getName() + " is a dog"); }

    public String toString()
    {   return getName() + " is a dog"; }
}
