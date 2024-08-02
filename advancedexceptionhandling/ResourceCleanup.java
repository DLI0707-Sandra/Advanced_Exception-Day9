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


    }
}
