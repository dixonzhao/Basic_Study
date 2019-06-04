package week05_part01.shallow;

public class File
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

    @Override
    public String toString()
    {   return name; }
}
