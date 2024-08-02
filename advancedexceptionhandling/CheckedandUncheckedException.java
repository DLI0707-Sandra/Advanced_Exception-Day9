package advancedexceptionhandling;

public class CheckedandUncheckedException
{
    public static void handleOperation() throws ArrayIndexOutOfBoundsException,ClassNotFoundException
    {
        int[] array={1,2,3};
        try {
            System.out.println(array[4]);
        }catch (Exception e)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        try {
            Class.forName("Test");
        }catch (Exception e)
        {
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args)
    {
        try {
            handleOperation();
        }catch (ArrayIndexOutOfBoundsException | ClassNotFoundException e)
        {
            System.out.println(e);
        }
    }
}
