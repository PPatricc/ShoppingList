import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        ProductList productList = null;
        Scanner myScanner = new Scanner(System.in);
        myScanner.useDelimiter("\n");
        int pom = 0;
        try
        {
            productList = new ProductList("src/list");
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        assert productList != null;
        do
        {
            System.out.println("0 - Save and quit");
            System.out.println("1 - Print list");
            System.out.println("2 - Add product");
            System.out.println("3 - Delete product");
            System.out.println("4 - Clear list");
            try
            {
                pom = myScanner.nextInt();
            }
            catch (Exception e)
            {
                myScanner.next();
                System.out.println("Unknown format");
                continue;
            }
            switch (pom)
            {
                case 0:
                    continue;
                case 1:
                    System.out.println("\nYOUR LIST\n");
                    System.out.println(productList);
                    break;
                case 2:
                    Product product = new Product();
                    System.out.println("Name");
                    String Nazwa =myScanner.next();
                    System.out.println("Category");
                    String Kategoria = myScanner.next();
                    boolean flag1=false, flag2=false;


                    Scanner txtscan1 = new Scanner(new File("src/products.txt"));
                    while(txtscan1.hasNextLine()){
                        String str = txtscan1.nextLine();
                        if(str.contains(Nazwa)){
                            flag1=true;
                            break;
                        }
                    }

                    Scanner txtscan2 = new Scanner(new File("src/products.txt"));
                    while(txtscan2.hasNextLine()){
                        String str = txtscan2.nextLine();
                        if(str.contains(Kategoria)){
                            flag2=true;
                            break;
                        }
                    }
                    if(flag1&&flag2){
                        product.setName(Nazwa);
                        product.setCategory(Kategoria);
                        productList.addProduct(product);
                        System.out.println("\n"+product.getName() + " added to your shopping list\n");
                    }
                    else System.out.println("\nNo available products\n");

                    break;

                case 3:
                    System.out.println(productList);
                    System.out.println("Product ID");
                    int numer = 0;
                    try
                    {
                        numer = myScanner.nextInt();
                    }
                    catch (InputMismatchException e)
                    {
                        myScanner.next();
                        System.out.println("Unknown format");
                        continue;
                    }
                    try
                    {
                        productList.removeProduct(numer);
                    }
                    catch(IndexOutOfBoundsException e)
                    {
                        System.out.println("Product not found");
                    }
                    break;
                case 4:
                    productList.clearList();
                    System.out.println("List cleared");
                    break;
                default:
                    System.out.println("Unknown operation");
                    break;
            }
        }while(pom != 0);
        try
        {
            productList.saveToFile();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
