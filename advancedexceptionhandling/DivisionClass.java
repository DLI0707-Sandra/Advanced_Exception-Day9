package advancedexceptionhandling;

import java.util.Scanner;

public class DivisionClass
{

    public static void calculate(int numerator,int denominator) throws ArithmeticException
    {
        try {
            performDivision(numerator,denominator);
        }
        catch (ArithmeticException e)
        {
            throw new ArithmeticException("Denominator cannot be zero!");
        }

    }

    public static void performDivision(int numerator,int denominator) throws ArithmeticException
    {
        if(denominator==0)
            throw new ArithmeticException("Denominator is 0!");
        else
        {
            System.out.println("Result:"+numerator/denominator);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the numerator:");
        int numerator=scanner.nextInt();
        System.out.println("Enter the denominator:");
        int denominator=scanner.nextInt();
        try {
            calculate(numerator,denominator);
        }catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
