package advancedexceptionhandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileProcessor
{
    public static void processFiles(List<String> filePaths)
    {
        for (String file:filePaths)
        {
            try(FileReader fileReader=new FileReader(file);BufferedReader bufferedReader=new BufferedReader(fileReader); )
            {
                System.out.println("Content of file "+file);
                String data=bufferedReader.readLine();
                System.out.println(data);
            }catch (IOException e)
            {
                System.out.println("Unable to open file "+file);
            }
        }

    }

    public static void main(String[] args)
    {

        List<String >files=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the number of files:");
        int number=scanner.nextInt();
        System.out.println("Enter the file names:");
        for(int i=0;i<number;i++)
        {
            files.add(scanner.next());
        }
        processFiles(files);
    }
}
