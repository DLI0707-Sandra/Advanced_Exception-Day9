package advancedexceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ResourceCleanup
{
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the file to be read:");
        String filename=scanner.next();
        /*Using Try with resources*/
        try(FileReader fileReader=new FileReader(filename);BufferedReader bufferedReader=new BufferedReader(fileReader); )
        {
            System.out.println("Content of file "+filename);
            String data=bufferedReader.readLine();
            System.out.println(data);
        }catch (IOException e)
        {
            System.out.println("Unable to open file "+filename);
        }
        /* Clean up using finally
        BufferedReader bufferedReader=null;
        try {
            bufferedReader=new BufferedReader(new FileReader(filename));
            System.out.println(bufferedReader.readLine());
        }catch (IOException e)
        {
            System.out.println("File cannot be found!");
        }finally
        {
            if(bufferedReader!=null)
                bufferedReader.close();
        }
        */

    }
}
