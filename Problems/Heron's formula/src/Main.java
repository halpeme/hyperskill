import java.util.Scanner;  // Import the Scanner class

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        String s1 = myObj.nextLine();  // Read user input
        String s2 = myObj.nextLine();  // Read user input
        String s3 = myObj.nextLine();  // Read user input

        int a = Integer.parseInt(s1);
        int b = Integer.parseInt(s2);
        int c = Integer.parseInt(s3);

        double p = (a + b + c)/2.0;
        double result = p*(p-a)*(p-b)*(p-c);

        result = Math.sqrt(result);

        System.out.println(result);  // Output user input
        
    }
}
