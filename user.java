import java.util.ArrayList;

public class user {
    
    String username;
    String password;
    ArrayList<String> tasks = new ArrayList<>();

    user(String username,String password){
        this.username = username;
        this.password = password;
    }
}