package advancedexceptionhandling;


import java.util.Scanner;


class RestrictedOperationException extends Exception
{
    RestrictedOperationException(String message)
    {
        super(message);
    }
}

public class RethrowingCustomException
{
    public static void calculate(int numerator,int denominator) throws RestrictedOperationException
    {
        try {
            performDivision(numerator,denominator);
        }
        catch (RestrictedOperationException e)
        {
            throw e;
        }

    }

    public static void performDivision(int numerator,int denominator) throws RestrictedOperationException {
        if(denominator==0)
            throw new RestrictedOperationException("Denominator cannot be 0!");
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
        }catch (RestrictedOperationException e)
        {
            System.out.println(e);
        }

    }
}
