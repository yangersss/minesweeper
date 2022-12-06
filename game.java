import java.util.*;

public class Game {
    Grid grid;

    public Game(Grid g){
        grid = g;
    }

    public void debugGrid() { // DEBUG: prings the grid showing mines and numbers
        System.out.print("    ");
        for (int i = 0; i < grid.getColumns(); i++){ //prints out numbers at the top (0 1 2 3 ...)
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int j = 0; j < grid.getRows(); j++){ //prints out the grid
            System.out.print(j + "  ");
            for (int k = 0; k < grid.getColumns(); k++){
                if (!(grid.getTile(j, k).safe)){
                    System.out.print("\u001B[0m\u001B[41m[M]");
                }
                else{
                    System.out.print("\u001B[0m" + grid.getTile(j, k).color() + "[" + grid.getTile(j, k).surroundingMines + "]");
                }
            }
            System.out.println("\u001B[0m");
        }
    }

    public void printGrid(){
        System.out.print("    ");
        for (int i = 0; i < grid.getColumns(); i++){ //prints out numbers at the top (0 1 2 3 ...)
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int j = 0; j < grid.getRows(); j++){ //prints out the grid
            System.out.print(j + "  ");
            for (int k = 0; k < grid.getColumns(); k++){
                if (grid.getTile(j, k).flagged){
                    System.out.print("\u001B[0m\u001B[43m[F]");
                }
                else if (grid.getTile(j, k).flipped){
                    System.out.print("\u001B[0m" + grid.getTile(j, k).color() + "[" + grid.getTile(j, k).surroundingMines + "]");
                }
                else{
                    System.out.print("\u001B[0m[0]");
                }
            }
            System.out.println("\u001B[0m");
        }
        
        //print safe tiles left
        System.out.println("Safe tiles left: " + grid.safeTiles());
    }

    public void play(){
        /*PSEUDOCODE:
        Welcome statement
        Instructions
        
        Loop:
        Checkwin
        Grid
        Input
        Checklose
        Printgrid
        */

        System.out.println("welcome"); //TODO welcome statement
        System.out.println("instructions"); //TODO instructions


        boolean gameOn = true;
        while (gameOn){
            if (grid.checkWin()){
                System.out.println("u won"); //TODO win statement
            }
            printGrid();
            
            String badInput = "Sorry, that's not a valid input!\nType F and then the coordinates (separated by spaces) to flag\nType the coordinates (separated by spaces) to flip a tile\nType debug to reveal the grid";
            
            boolean valid = false;
            while (!valid){
                String input = input();
                if (input.toLowerCase().equals("debug")){ //TODO: debug input is buggy
                    debugGrid();
                    valid = true;
                }

                char[] aInput = input.toCharArray();
                try{
                    if (Character.toString(aInput[0]).toLowerCase().equals("f")){
                        // flag
                        int input1 = Integer.parseInt(Character.toString(aInput[2]));
                        int input2 = Integer.parseInt(Character.toString(aInput[4]));

                        grid.flag(input1, input2);
                        valid = true;
                    }
                    else{
                        // flip
                        int input1 = Integer.parseInt(Character.toString(aInput[0]));
                        int input2 = Integer.parseInt(Character.toString(aInput[2]));
                        if (grid.checkLose(input1, input2)){
                            System.out.println("\u001B[0m\u001B[31m\u001B[1mYOU LOSE!!!\n\u001B[0m\u001B[42mHere's what the grid looked like:\u001B[0m");
                            debugGrid();
                            gameOn = false;
                        }

                        if (grid.checkFlagged(input1, input2)){
                            System.out.println("\u001B[0mYou can't flip a flag!");
                        }
                        else{
                            grid.flip(input1, input2);
                            valid = true;
                        }
                        
                    }
                }
                catch (Exception e){
                    System.out.println(badInput);
                }
            }
        }
    }

    public String input(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Make your move:");
        String input = scanner.nextLine();
        return input;
    }
}