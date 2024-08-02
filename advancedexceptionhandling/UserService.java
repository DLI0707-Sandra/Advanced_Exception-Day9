package advancedexceptionhandling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserAlreadyExistsException extends Exception
{
    public UserAlreadyExistsException(String message)
    {
        super(message);
    }
}

class UserNotFoundException extends Exception
{
    public UserNotFoundException (String message)
    {
        super(message);
    }
}

class User
{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class UserService
{
    static List<User>users=new ArrayList<>();

    public static void registerUser(String name) throws UserAlreadyExistsException
    {
        boolean found=false;
        for(User user:users)
        {
            if(user.getName().equals(name))
            {
                found=true;
                throw new UserAlreadyExistsException("User with the same name exists!");
            }
        }
        if(!found)
        {
            User user=new User();
            user.setName(name);
            users.add(user);
        }

    }

    public static void checkUserExistence(String name) throws UserNotFoundException
    {
        boolean found=false;
        for(User user:users)
        {
            if(user.getName().equals(name))
            {
                found=true;
                System.out.println("Found user!");
                break;
            }
        }
        if(!found)
            throw new UserNotFoundException("User not found!");
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int choice;
        do {
            System.out.println("1.Add user\n2.Search user\n3.Exit");
            System.out.println("Enter the choice:");
            choice=scanner.nextInt();
            switch (choice)
            {
                case 1:
                    System.out.println("Enter the name of user to be added:");
                    try {
                        registerUser(scanner.next());
                    }catch (UserAlreadyExistsException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("Enter the name:");
                    try {
                    checkUserExistence(scanner.next());
                }catch (UserNotFoundException e)
                    {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exiting!");
                    break;
            }

        }while (choice!=3);

    }
}
