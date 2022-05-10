public class Product
{
    private String name;
    private String category;

    public Product() {}

    public Product(String name, String category)
    {
        this.name = name;
        this.category = category;
    }

    public String toString()
    {
        return this.name + "\t" + this.category;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
