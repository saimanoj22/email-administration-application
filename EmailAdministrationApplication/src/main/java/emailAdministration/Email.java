package emailAdministration;

import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailBoxCapacity = 500;
    private int defaultPasswordLength = 8;
    private String alternateEmail;
    private String companySuffix = "anycompany.com";
    
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = setDepartment();
        System.out.println("Department:" + this.department);
        
        this.password = randomPassword(this.defaultPasswordLength);
        System.out.println("Password: " + this.password);
        
        this.email = this.firstName.toLowerCase() + "." + this.lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
        System.out.println("Your email is : " + email);
    }
    
    private String setDepartment(){
        System.out.println("New User: " + this.firstName);
        System.out.println("---Department Codes---");
        System.out.println("1. for Sales");
        System.out.println("2. for Development");
        System.out.println("3. for Accounting");
        System.out.println("0. for None");
        System.out.println("----------------------");
        System.out.println("Enter Department Code: ");
        Scanner scan = new Scanner(System.in);
        int choice = Integer.valueOf(scan.nextLine());
        if(choice == 1) return "sales";
        else if(choice == 2) return "dev";
        else if(choice == 3) return "acc";
        else return "";
    }
    
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for(int i = 0; i < length; i++){
            int rand = (int)(Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    public void setMailBoxCapacity(int capacity){
        this.mailBoxCapacity = capacity;
    }
    
    public void setAltEmail(String email){
        this.alternateEmail = email;
    }
    
    public void changePassword(String password){
        this.password = password;
    }
    
    public int getMailBoxCapacity(){
        return this.mailBoxCapacity;
    }
    
    public String getAltEmail(){
        return this.alternateEmail;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public String showInfo(){
        return  "=========INFO=========" + 
                "\nDISPLAY NAME: " + this.firstName + " " + this.lastName + 
                "\nCOMPANY EMAIL: " + this.email + 
                "\nMAILBOX CAPACITY: " + this.mailBoxCapacity + "mb" +
                "\n======================";
    }
}

