import java.util.ArrayList;
import java.util.Scanner;

public class Auth {

    Scanner in = new Scanner(System.in);

    public String login(ArrayList<user> users){
        System.out.println("=================== Log in ===================");   

        System.out.print("Enter the username: ");
        var username = in.nextLine();

        System.out.print("Enter the password: ");
        var password = in.nextLine();

        var success = false;

        for (user user : users) {
            if (username.equals(user.username) && password.equals(user.password)) {
                System.out.println(username + " loged in successfully.");
                success = true;
            }
        }
        
        if (success) {
            return username;
        }else return null;
    
    }

    public void signup(ArrayList<user> users){     
        System.out.println("=================== Sign Up ===================");

        System.out.print("Enter the username: ");
        var username = in.nextLine();
        
        System.out.print("Enter the password: ");
        var password = in.nextLine();

        user user = new user(username,password);
        users.add(user);

        System.out.println(username + " account created successfully.");
    }

}