import java.util.Scanner;

class Main {
    public static void  main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        int[] elements = new int[arraySize];
        for (int i = 0; i < arraySize; i++){
            elements[i] = scanner.nextInt();

        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(checker(elements, n, m));


    }

    public static boolean checker(int[] elements, int n, int m){
        int check = 0;
        for(int number : elements){

            if(number == n || number == m){
                check++;
                if(check == 2){
                    return false;
                }

            }else{
                check = 0;
            }
        }
        return true;

    }


}