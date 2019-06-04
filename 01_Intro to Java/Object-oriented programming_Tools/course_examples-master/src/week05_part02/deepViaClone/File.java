package week05_part02.deepViaClone;

public class File implements Cloneable
{
    private String name;

    private int permissions;

    public File(String name, int permissions)
    {
        this.name = name;
        this.permissions = permissions;

    }

    public int getPermissions()
    {   return permissions; }

    protected Object clone()
    {
        File newCopy = new File(name, permissions);
        return newCopy;
    }

    @Override
    public String toString()
    {   return name; }
}
