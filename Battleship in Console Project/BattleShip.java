import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
/**
 * This is my attempt at making the board game BattleShip in Java.
 *
 * @author (Dakota M)
 * @version (Final Version 1.0)
 */
public class BattleShip {
    public static Scanner scnr = new Scanner(System.in);
    public static final int rowCount = 10;
    public static final int columnCount = 10;
    public static int userShips = 17;
    public static int comShips = 17;
    public static String [][] userBoard = new String[columnCount][rowCount];
    public static String [][] comBoard = new String [columnCount][rowCount];
    public static String[][] hiddenBoard = new String[columnCount][rowCount];
    public static class ShipType{
        private String shipClass;
        private int shipSize;

        public ShipType(String name, int size){
            shipClass = name;
            shipSize = size;
        }

        public String getShipClass(){
            return shipClass;
        }

        public int getShipSize(){
            return shipSize;
        }
    } 
    public static void main(String[] args) {
        System.out.println();
        System.out.println("WELCOME TO BATTLESHIP");
        System.out.println("Are you ready for battle Captain?");
        System.out.println();

        StartingUserBoard();
        StartingComBoard();
        setUserFleet();
        setComShips();

        while(userShips > 0 && comShips > 0){
            theBattle();
        }

    }

    public static void StartingUserBoard() {
        System.out.print("  ");
        for (int i = 0; i < columnCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int x = 0; x < userBoard.length; ++x) {
            for (int v = 0; v < userBoard[x].length; ++v) {
                userBoard[x][v] = "_ ";
                if (v == 0) {
                    System.out.print(x + " " + userBoard[x][v]);
                }
                else {
                    System.out.print(userBoard[x][v]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void StartingComBoard() {
        System.out.print("  ");
        for (int i = 0; i < columnCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int x = 0; x < comBoard.length; ++x) {
            for (int v = 0; v < comBoard[x].length; ++v) {
                comBoard[x][v] = "_ ";
                hiddenBoard[x][v] = "_ ";
                if (v == 0) {
                    System.out.print(x + " " + comBoard[x][v]);
                }
                else {
                    System.out.print(comBoard[x][v]);
                }
            }
            System.out.println();
        }
    }

    public static void updatedUserBoard() {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < columnCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int x = 0; x < userBoard.length; ++x) {
            for (int v = 0; v < userBoard[x].length; ++v) {
                if(v == 0){
                    System.out.print(x + " " + userBoard[x][v]);
                }
                else {
                    System.out.print(userBoard[x][v]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void updatedComBoard() {
        System.out.print("  ");
        for (int i = 0; i < columnCount; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int x = 0; x < comBoard.length; ++x) {
            for (int v = 0; v < comBoard[x].length; ++v) {
                if(v == 0){
                    System.out.print(x + " " + comBoard[x][v]);
                }
                else {
                    System.out.print(comBoard[x][v]);
                }
            }
            System.out.println();
        }
    }

    public static void setUserFleet() {
        System.out.println();
        System.out.println("At your command sir, set your fleet");
        ShipType[] fleet = {
                new ShipType("Destroyer", 5),
                new ShipType("Carrier", 4),
                new ShipType("Cruiser", 3),
                new ShipType("Patrol", 3),
                new ShipType("Submarine", 2),
            };        
        for (ShipType userShip : fleet){
            System.out.println("Place " + userShip.getShipClass() + "(size " + userShip.getShipSize() + ")" + "(X Y h/v)");
            boolean set = false;
            boolean openSpot;
            while(!set) {
                int x = scnr.nextInt();
                int y = scnr.nextInt();
                char direction = scnr.next().charAt(0);
                if(direction == 'h') {
                    openSpot = true;
                    for(int i = 0; i < userShip.getShipSize(); i++) {
                        if(x + i >= userBoard.length) {
                            System.out.println("Out of Range");
                            openSpot = false;
                            break;
                        }
                        if(userBoard[y][x+i] != "_ ") {
                            System.out.println("That spot is taken");
                            openSpot = false;
                            break;
                        }
                    }
                    if(!openSpot){
                        continue;
                    }
                    for(int i = 0; i < userShip.getShipSize(); i++) {
                        userBoard[y][x+i] = "$ ";
                    }
                    set = true;
                } else {
                    openSpot = true;
                    for(int i = 0; i < userShip.getShipSize(); i++) {
                        if(y + i >= userBoard.length){
                            System.out.println("Out of Range");
                            openSpot = false;
                            break;
                        }
                        if(userBoard[y+i][x] != "_ "){
                            System.out.println("That spot is taken");
                            openSpot = false;
                            break;
                        }
                    }
                    if(!openSpot){
                        continue;
                    }
                    for(int i = 0; i < userShip.getShipSize(); i++) {
                        userBoard[y+i][x] = "$ ";
                    }
                    set = true;
                }
                updatedUserBoard();
                updatedComBoard();
            }
        }
    }

    public static void setComShips(){
        ShipType[] comFleet = {
                new ShipType("Destroyer", 5),
                new ShipType("Carrier", 4),
                new ShipType("Cruiser", 3),
                new ShipType("Patrol", 3),
                new ShipType("Submarine", 2),
            };
        for(ShipType comShip : comFleet){
            boolean set = false;
            boolean openSpot;
            while(!set) {
                int x = (int)(Math.random() * 10);
                int y = (int)(Math.random() * 10);
                boolean direction = (int)(Math.random() * 10) % 2 == 1;
                if(direction) {
                    openSpot = true;
                    for(int i = 0; i < comShip.getShipSize(); i++) {
                        if(x + i >= comBoard.length) {
                            openSpot = false;
                            break;
                        }
                        if(hiddenBoard[y][x+i] != "_ ") {
                            openSpot = false;
                            break;
                        }
                    }
                    if(!openSpot){
                        continue;
                    }
                    for(int i = 0; i < comShip.getShipSize(); i++) {
                        hiddenBoard[x+i][y] = "# ";
                    }
                    set = true;
                } else {
                    openSpot = true;
                    for(int i = 0; i < comShip.getShipSize(); i++) {
                        if(y + i >= comBoard.length){
                            openSpot = false;
                            break;
                        }
                        if(hiddenBoard[y+i][x] != "_ "){
                            openSpot = false;
                            break;
                        }
                    }
                    if(!openSpot){
                        continue;
                    }
                    for(int i = 0; i < comShip.getShipSize(); i++) {
                        hiddenBoard[y + i][x] = "# ";
                    }
                    set = true;
                }
            }
        }
        updatedUserBoard();
        updatedComBoard();
    }

    public static void userTurn(){
        System.out.println("Fire when ready Captain");
        int x = -2;
        int y = -2;
        while((x < 0 || x >= columnCount) || (y < 0 || y >= rowCount)) {
            System.out.println("Set your attack coordinates(X Y):");
            x = scnr.nextInt();
            y = scnr.nextInt();
            if ((x >= 0 && x < columnCount) && (y >= 0 && y < rowCount)){
                if (hiddenBoard[y][x] == "# "){
                    System.out.println("Hit confirmed!");
                    comBoard[y][x] = "X ";
                    BattleShip.comShips--;
                }
                else if (comBoard[y][x] == "_ "){
                    System.out.println("Target Missed!");
                    comBoard[y][x] = "? ";
                }
                else if (comBoard[y][x] == "? "){
                    System.out.println("We've already shot there sir!");
                }
            }
            else if ((x > 0 || x > columnCount) || (y > 0 || y > rowCount)){
                System.out.println("Sir those coordinates are out of range");
            }
        }
    }

    public static void comTurn(){
        System.out.println("Computer Turn");
        int x = -2;
        int y = -2;
        while((x < 0 || x >= rowCount) || (y < 0 || y >= columnCount)) {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if ((x >= 0 && x < rowCount) && (y >= 0 && y < columnCount)){
                if (userBoard[x][y] == "$ "){
                    System.out.println("We've been hit!");
                    userBoard[x][y] = "X ";
                    BattleShip.userShips--;
                }
                else if (userBoard[x][y] == "_ "){
                    System.out.println("Computer Missed!");
                    userBoard[x][y] = "? ";
                }
            }
        }
    }

    public static void theBattle(){
        userTurn();
        comTurn();
        updatedUserBoard();
        updatedComBoard();

        if(userShips > 0 && comShips <= 0){
            System.out.println();
            System.out.println("Hoorah! You've won the battle!");
        }
        else if(userShips <= 0 && comShips > 0){
            System.out.println("Sorry sir, we've been bested..");
        }
    }
}
