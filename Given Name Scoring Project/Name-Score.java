import java.io.*;
import java.util.*;

public class ProjectE_Problem22 implements Comparable<ProjectE_Problem22>{
    String name;

    public String getName(){
        return name;
    }
    public int compareTo(ProjectE_Problem22 other){
        return this.name.compareTo(other.getName());
    }
    public static int nameScore(String name, int index){
        int sum = 0;
        for(char c : name.toCharArray()){
            if(Character.isUpperCase(c)) {
                int charVal = c - 'A' + 1;
                sum += charVal;
            }
        }
        return sum * index;
    }
    public static long sumOfAllNames(String[] names){
        long sum = 0L;
        for(int i = 0; i < names.length; i++){
            sum += nameScore(names[i], i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        ArrayList<String> nameList = new ArrayList<>();
        BufferedReader buffRead;

        try{
            buffRead = new BufferedReader(new FileReader("NamesList.txt"));
            String Line;
            while((Line = buffRead.readLine()) != null){
                String[] names = Line.split(",");
                for(String name : names){
                    nameList.add(name.trim());
                }
            }
            String[] nameArray = nameList.toArray(new String[0]);
            Arrays.sort(nameArray);
            System.out.println(sumOfAllNames(nameArray));
        }
        catch(Exception e){
            System.out.println(e);
        }
        }
    }
