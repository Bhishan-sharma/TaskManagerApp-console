import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class querries {
    Scanner in = new Scanner(System.in);
    boolean run = true;
    String username;
    ArrayList<user> users;
    querries(String username,ArrayList<user> users){
        this.username = username;
        this.users = users;
    }
    public void takeinput(){
        while (run) {
            System.out.printf("%s> ",username);
            var input = in.nextLine();
            processIn(input);
        }
    }
    private void processIn(String input) {
        if (input.equals("exit")) {
            run = false;
            return;
        }
        Pattern Opattern = Pattern.compile("add");
        Matcher Omatcher = Opattern.matcher(input);
        if (Omatcher.find()) {
            if (Omatcher.group(0).equals("add")) {
                System.out.print("=> ");
                Pattern inpattern = Pattern.compile("add ([a-zA-Z0-9 ]*)");
                Matcher inmatcher = inpattern.matcher(input);
                String task = null;
                if (inmatcher.find()) {
                    task = inmatcher.group(1);
                    System.out.println("Task: " + task);
                }
                for (user user : users) {
                    if (user.username.equals(username) && !task.equals(null)) {
                        LocalTime currentTime = LocalTime.now();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        String formattedTime = currentTime.format(formatter);
                        user.tasks.add(task + "    " + formattedTime);
                    }
                }
            }
        }
        Main main = new Main();
        main.users = this.users;

        if (input.equals("list")) {
            var index = 0;
            for (user user : main.users) {
                if (user.username.equals(username)) {
                    for (String task : user.tasks) {
                        System.out.println(index + ". " + task);
                        index++;
                    }
                }
            }
        }
        
        Opattern = Pattern.compile("del");
        Omatcher = Opattern.matcher(input);
        if (Omatcher.find()) {
            if (Omatcher.group(0).equals("del")) {
                Pattern inpattern = Pattern.compile("del ([0-9]*)");
                Matcher inmatcher = inpattern.matcher(input);
                int task = 0;
                if (inmatcher.find()) {
                    task = Integer.parseInt(inmatcher.group(1));
                }
                for (user user : users) {
                    if (user.username.equals(username)) {
                        user.tasks.remove(task);
                    }
                }
            }
        }
        main.users = this.users;

        Opattern = Pattern.compile("update");
        Omatcher = Opattern.matcher(input);
        if (Omatcher.find()) {
            if (Omatcher.group(0).equals("update")) {
                Pattern inpattern = Pattern.compile("update ([0-9]*) ([a-zA-Z0-9 ]*)");
                Matcher inmatcher = inpattern.matcher(input);
                if (inmatcher.find()) {
                    int number = Integer.parseInt(inmatcher.group(1));
                    String text = inmatcher.group(2);
                    for (user user : users) {
                        if (user.username.equals(username)) {
                            LocalTime currentTime = LocalTime.now();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            String formattedTime = currentTime.format(formatter);
                            user.tasks.remove(number);
                            user.tasks.add(number, text + "    " + formattedTime);
                        }
                    }
                }
            }
        }
        main.users = this.users;
    }
}
