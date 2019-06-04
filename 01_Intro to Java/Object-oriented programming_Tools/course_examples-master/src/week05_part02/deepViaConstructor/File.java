package week05_part02.deepViaConstructor;

public class File
{
    private String name;

    private int permissions;

    public File(String name, int permissions)
    {
        this.name = name;
        this.permissions = permissions;

    }

    public File(File other)
    {
        this.name = other.name;
        this.permissions = other.permissions;
    }

    public int getPermissions()
    {   return permissions; }

    @Override
    public String toString()
    {   return name; }
}
