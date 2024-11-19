import java.util.*;
import java.util.Scanner;

public class May_Problem5
{
public static void main(String args[]){
    Scanner scnr = new Scanner(System.in); //Initialize Scanner
    
    int numberN;
    
    System.out.println("Please enter a number"); //Prompt user to enter number
    
    while(true){
    numberN = scnr.nextInt(); //Scanner input
    
    if(numberN < 2){
        //0 and 1 are not composite numbers so it would return false
        System.out.println("That is not a composite number");
        return;
    }

    for(int i = 2; i <= Math.sqrt(numberN); i++){
    //I used a for loop instead of a while loop because there are a limited amount of numbers between 2 and the square root of the input
        if(numberN % i == 0){
            //If the number has a factor other than itself and 1 then the conditions are true and it's output
            System.out.println("That is a composite number");
            break;
        }
        else{
            //Otherwise this is output because the conditons are false
            System.out.println("That is not a composite number");
            break;
        }
    }
}
}
}