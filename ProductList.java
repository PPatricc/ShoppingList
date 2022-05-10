import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProductList
{
    private final List<Product> list = new ArrayList<>();
    private final File listFile;
    private final Scanner myScanner;

    public ProductList(String filename) throws FileNotFoundException
    {
        this.listFile = new File(filename);
        this.myScanner = new Scanner(this.listFile);
        this.loadFromFile();
    }


    public String toString()
    {
        if(this.list.isEmpty())
        {
            return "Empty\n";
        }
        int numer = 1;
        StringBuilder myStringBuilder = new StringBuilder();
        for(Product product : this.list)
        {
            myStringBuilder.append(String.format("%d - %s\n", numer, product));
            numer++;
        }
        return myStringBuilder.toString();
    }

    private void loadFromFile()
    {

        while(this.myScanner.hasNextLine())
        {
            String line = this.myScanner.nextLine();
            List<String> _product = Arrays.asList(line.split("\t"));
            this.addProduct
            (
                    new Product
                    (
                       _product.get(0),
                       _product.get(1)
                    )
            );
        }
        System.out.println("File loaded");
    }

    public void saveToFile() throws FileNotFoundException
    {
        PrintWriter out = new PrintWriter(this.listFile);
        for(Product product : this.list)
        {
            out.println(product);
        }
        out.close();
    }

    public void addProduct(Product product)
    {
        this.list.add(product);
    }

    public void removeProduct(int id) throws IndexOutOfBoundsException
    {
        this.list.remove(id - 1);
    }

    public void clearList()
    {
        this.list.clear();
    }
}
