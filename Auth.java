import java.util.ArrayList;
import java.util.Scanner;

public class Auth {

    Scanner in = new Scanner(System.in);

    String red = "\u001B[31m";
    String yellow = "\u001B[33m";
    String green = "\u001B[32m";
    String reset = "\u001B[0m";

    public String login(ArrayList<user> users){
        System.out.println(yellow+"=================== Log in ==================="+reset);   

        System.out.print("Enter the username: ");
        var username = in.nextLine();

        System.out.print("Enter the password: ");
        var password = in.nextLine();

        var success = false;

        for (user user : users) {
            if (username.equals(user.username) && password.equals(user.password)) {
                System.out.println(green+username + " loged in successfully."+reset);
                success = true;
            }
        }
        
        if (success) {
            return username;
        }else return null;
    
    }

    public void signup(ArrayList<user> users){     
        System.out.println(yellow+"=================== Sign Up ==================="+reset);

        System.out.print("Enter the username: ");
        var username = in.nextLine();
        
        System.out.print("Enter the password: ");
        var password = in.nextLine();

        user user = new user(username,password);
        users.add(user);

        System.out.println(green+username + " account created successfully."+reset);
    }

}