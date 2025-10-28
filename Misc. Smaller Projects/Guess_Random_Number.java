import java.util.Scanner; 
import java.util.Random;

public class May_Problem2
{
public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in); //Initialize Scanner
    Random rand = new Random(); //Initialize Random
    int userGuess;
    int comNum;
    int userAttempts = 0; //Keeps track of attempts
    
    System.out.println("Please guess a number between 1 and 1000"); //Prompt user to guess
    
    comNum = rand.nextInt(1000); //This generates a number between 1 and 1000
    
    while(true){ //I used this loop so the user can continuosly input their guess until they get the right answer
        userGuess = scnr.nextInt(); //Scanner input for user to enter their guess
            if (userGuess == comNum){
                userAttempts++; //This increases userAttempts by 1 everytime the 'if' statement conditions are met
                System.out.println("Correct! The number was " + comNum);
                System.out.println("It took you " + userAttempts + " attempts");
                break; //Once userGuess is equal to comNum this breaks the loop ending the program
            }
            if(userGuess < comNum){
                System.out.println("Too Low. Please try again");
                userAttempts++; //This increases userAttempts by 1 everytime the 'if' statement conditions are met
            }
            else if(userGuess > comNum){
                System.out.println("Too High. Please try again");
                userAttempts++; //This increases userAttempts by 1 everytime the 'if' statement conditions are met
            }
   }
}
}
