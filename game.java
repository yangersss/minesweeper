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
                    //TODO
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
        System.out.println("Make your move:");
        String input = scanner.nextLine();
        if (){

        }
        else{
            System.out.println("Sorry, that's not a valid input!\nType F and then the coordinates to flag\nType the coordinates to flip a tile\nType debug to reveal the grid");
        }
    }

}