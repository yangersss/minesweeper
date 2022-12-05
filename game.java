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
        int d = grid.getRows() * grid.getColumns(); //counter
        for (int l = 0; l < grid.getRows(); l++){
            for (int k = 0; k < grid.getColumns(); k++){
                if (grid.getTile(l, k).flipped){
                    d--;
                }
            }
        }
        System.out.println("Safe tiles left: " + d);
    }

    public void play(){
        //take inputs flip, flag, debug, or throws e
        //check if win, lose
    }

    public void input(){ //recursion
        Scanner scanner = new Scanner(System.in);

        boolean valid = false;

        String badInput = "Sorry, that's not a valid input!\nType F and then the coordinates (separated by spaces) to flag\nType the coordinates (separated by spaces) to flip a tile\nType debug to reveal the grid";

        while (!valid){
            System.out.print("Make your move:");
            String input = scanner.nextLine();
            
            if (input.equals("debug")){
                debugGrid();
            }

            //TODO else: try, catch, finally
            else{ // used to be: else if the string isn't empty...
                char[] aInput = input.toCharArray();
                try{
                    if (Character.toString(aInput[0]).toLowerCase() == "f"){
                        // grid.flag(aInput[2], aInput[4]);
                        grid.flag(Integer.parseInt(Character.toString(aInput[2])), Integer.parseInt(Character.toString(aInput[4])));
                        valid = true;
                    }
                    else{
                        // grid.flip(aInput[0], aInput[2]);
                        grid.flip(Integer.parseInt(Character.toString(aInput[0])), Integer.parseInt(Character.toString(aInput[2])));
                        valid = true;
                    }
                    printGrid();

                }
                catch (Exception e){
                    System.out.println(badInput);
                }
            }
        }
    }
}