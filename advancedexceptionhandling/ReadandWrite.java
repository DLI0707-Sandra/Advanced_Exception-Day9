package advancedexceptionhandling;

import java.io.*;
import java.util.Scanner;

public class ReadandWrite
{
    public static void main(String[] args) throws IOException {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter first file:");
        String file1=scanner.next();
        System.out.println("Enter second file:");
        String file2=scanner.next();

        try(BufferedReader bufferedReader1=new BufferedReader(new FileReader(file1));BufferedReader bufferedReader2=new BufferedReader(new FileReader(file2)); FileWriter fileWriter=new FileWriter("src/advancedexceptionhandling/result.txt");BufferedWriter bufferedWriter =new BufferedWriter(fileWriter);) {
            String line;
            PrintWriter printWriter = new PrintWriter(bufferedWriter);
            while ((line=bufferedReader1.readLine())!=null)
            {
                printWriter.println(line);
            }

            while ((line=bufferedReader2.readLine())!=null)
            {
                printWriter.println(line);
            }

        }catch (IOException e)
        {
            System.out.println("Couldn't complete!");
        }

        BufferedReader bufferedReader=new BufferedReader(new FileReader("src/advancedexceptionhandling/result.txt"));
        System.out.println("Contents in result file:");
        String line;
        while ((line=bufferedReader.readLine())!=null)
        {
            System.out.println(line);
        }

    }
}
