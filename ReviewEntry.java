import java.util.*;
import java.io.*;

public class ReviewEntry {
    int phraseID;
    double totalScore;
    int numOfPhrases;

    public ReviewEntry(int phraseID) {
        this.phraseID = phraseID;
        this.totalScore = 0;
        this.numOfPhrases = 0;
    }
    public int getSentenceID(){
        return phraseID;
    }
    public void incrementWordCount(){
        this.numOfPhrases++;
    }
    public void addUpTotal(double score){
        this.totalScore += score;
    }
    public double getAverage(){
        if(this.numOfPhrases <= 0){
            return 0;
        }
        else{
            return totalScore/numOfPhrases;
        }
    }
    public String getSentimentScore(){
        double average = getAverage();
        if(average < 2){
            return "negative";
        }
        else if(average < 3){
            return "neutral";
        }
        else {
            return "positive";
        }
    }
    public static void main(String[] args) {
        ArrayList <ReviewEntry> EntryList = new ArrayList<>();
        Scanner scnr = new Scanner(System.in);
        BufferedReader buffReader;
        boolean foundID, stop = false;

        try {
            System.out.println("Please wait a moment.");
            buffReader = new BufferedReader(new FileReader("movieReviews.tsv"));
            buffReader.readLine();
            String sentence;
            while ((sentence = buffReader.readLine()) != null) {
                String[] sentFrags = sentence.split("\t");
                int SentenceID = Integer.parseInt(sentFrags[1]);
                double givenScore = Double.parseDouble(sentFrags[3]);
                foundID = false;
                for (ReviewEntry review : EntryList) {
                    if (review.getSentenceID() == SentenceID) {
                        review.incrementWordCount();
                        review.addUpTotal(givenScore);
                        foundID = true;
                        break;
                    }
                }
                if (!foundID) {
                    ReviewEntry newAdd = new ReviewEntry(SentenceID);
                    newAdd.addUpTotal(givenScore);
                    newAdd.incrementWordCount();
                    EntryList.add(newAdd);
                }
            }
        }
        catch(IOException e){
            System.out.println(e);
        }
        while (!stop){
            System.out.println("Please enter ID you would like to search for: ");
            int userInput = scnr.nextInt();
            if(userInput >= 1 && userInput <= 8544){
                for(ReviewEntry review : EntryList){
                    if(review.getSentenceID() == userInput){
                        double average = review.getAverage();
                        String sentimentScore = review.getSentimentScore();
                        int phraseCount = review.numOfPhrases;
                        System.out.print("Sentence ID " + userInput + " has " + phraseCount + " phrases with an average rating of ");
                        System.out.printf("%.2f", average);
                        System.out.println();
                        System.out.println("The overall sentiment is " + sentimentScore + ".");
                        break;
                    }
                }
            }
            else if(userInput >= 8545){
                System.out.println("Sentence ID not found.");
            }
            else if (userInput <= 0){
                stop = true;
            }
        }
    }
}