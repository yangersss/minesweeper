import javax.swing.plaf.basic.BasicTableHeaderUI;

public class Game {
    

    public Game(){

    }

    public void printGrid(Tile[][] grid) {
        System.out.print("    ");
        for (int i = 0; i < grid[0].length; i++){
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int j = 0; j < grid.length; j++){
            System.out.println(j + "  " + "[0][0][0]");
        }

        //print safe tiles left
    }

    public String colour(Tile t){
        switch (t.surroundingMines){
            case 1:
                return "\u001B[34m";
            case 2:
                return "\u001B[32m";
            case 3:
                return "\u001B[31m";
            case 4:
                return "\u001B[35m";
            case 5:
                return "\u001B[33m";
            default: 
                return "\u001B[0m";
        }
    }
}