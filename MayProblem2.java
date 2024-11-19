import java.util.*;

public class MayProblem2{
    public static void main(String[] args){
        int num1 = 1;
        int num2 = 0;
        int num3 = 0;
        int evenSum = 0;
        
        while(evenSum < 4000000){
            num3 = num1 + num2;
            num1 = num2;
            num2 = num3;
            if(num3 % 2 == 0){
                evenSum += num3;
            }
        }
        System.out.println(evenSum);
    }
}