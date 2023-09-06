import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.CREATE;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        ArrayList<Product> recs = new ArrayList<Product>();
        Product p;
        boolean done = false;
        do
        {
            String ID = SafeInput.getNonZeroLenString(in, "Enter the product's ID");
            String name = SafeInput.getNonZeroLenString(in, "Enter the name of your product");
            String description = SafeInput.getNonZeroLenString(in, "Enter a description of your product");
            double cost = SafeInput.getDouble(in, "Enter the price of the product");
            p = new Product(ID, name, description, cost);
            recs.add(p);
            done = SafeInput.getYNConfirm(in, "Do you want to keep entering information? ");
        }
        while(done);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\ProductTestData.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));
            String r;
            for(Product rec : recs)
            {
                r = rec.toCSVDataRecord();
                System.out.println("Record " + r);
                writer.write(r, 0, r.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("Data file written! ");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
