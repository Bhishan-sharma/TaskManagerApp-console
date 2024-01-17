import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    ArrayList<user> users;
    public static void main(String[] args) {
        Main main = new Main();
        main.users  = new ArrayList<>();

        Scanner in = new Scanner(System.in);

        System.out.print("Do you already have an account: ");
        String yOn = in.nextLine();
        
        Auth auth = new Auth();
        String username = null;
        if (yOn.equals("y")) {
            username = auth.login(main.users);
        }else if (yOn.equals("n")) {
            auth.signup(main.users);
            username = auth.login(main.users);
        }
        
        if (!username.equals(null)) {    
            querries querries = new querries(username,main.users);
            querries.takeinput();
        }

        in.close();
    }
}