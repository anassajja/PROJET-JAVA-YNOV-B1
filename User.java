package Project_java;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class User {
    protected String fullName;
    protected String password;
    protected Date createdAt;
    protected static String ID;
    protected String email;
    protected Date dateOfBirth;
    protected String address;
    protected String phoneNumber;
    protected static List<User> registerList = new ArrayList<>();
    protected boolean isLoggedIn;


    public static String getID() {
        return ID;
    }

    public void setID(String ID) {

        User.ID = ID;
    }
    public void setPassword(String password) {

        this.password = password;
    }
    public  String getPassword() {
        return password;

    }
    private void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setEmail(String email) {

        this.email = email;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setLoggedIn(boolean isLoggedIn) {
        this.isLoggedIn = isLoggedIn;
    }

    public static void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your ID : ");
        String ID = scanner.nextLine();

        System.out.print("Enter your password : ");
        String password = scanner.nextLine();

        // Vérifier si l'ID et le mot de passe correspondent à un utilisateur existant dans registerList
        for (User user : registerList) {
            if (getID().equals(ID) && user.getPassword().equals(password)) {
                // Connecter l'utilisateur en retournant l'objet User avec isLoggedIn à true
                user.setLoggedIn(true);
                System.out.println("Connected as " + getID());
                return;
            }
        }
        System.out.println("ID or password incorrect. please try again.");
    }

    public static void register() {
        Scanner scanner = new Scanner(System.in);
        User user = new User();
        System.out.print("Enter the ID : ");
        String ID = scanner.nextLine();
        user.setID(ID);

        System.out.print("Enter your Full Name: ");
        String fullName = scanner.nextLine();
        user.setFullName(fullName);

        System.out.print("Enter the user's email address : ");
        String email = scanner.nextLine();
        user.setEmail(email);

        System.out.print("Enter password : ");
        String password = scanner.nextLine();
        user.setPassword(password);

        System.out.print("Enter the user's date of birth (MM/DD/YYYY): ");
        Date dateOfBirth = new Date(scanner.nextLine());
        user.setDateOfBirth(dateOfBirth);

        System.out.print("Enter the user's address : ");
        String address = scanner.nextLine();
        user.setAddress(address);


        System.out.print("Enter the user's phone number : ");
        String phoneNumber = scanner.nextLine();
        user.setPhoneNumber(phoneNumber);

        System.out.print("Enter the date the user's account was created (MM/DD/YYYY) : ");
        Date createdAt = new Date(scanner.nextLine());
        user.setCreatedAt(createdAt);

        registerList.add(user);

        System.out.println( getID() + " created successfully.");
    }

    public static void logout() {
        User user = getLoggedInUser();
        if (user != null) {
            user.setLoggedIn(false);
            System.out.println("Logged out successfully.");
        } else {
            System.out.println("User is not currently logged in.");
        }
    }

    public static User getLoggedInUser() {
        for (User user : registerList) {
            if (user.isLoggedIn) {
                return user;
            }
        }
        return null;
    }



}






