public class Game {
    

    public Game(){

    }

    public void printGrid(Grid grid) {
        System.out.print("    ");
        for (int i = 0; i < grid.getColumns(); i++){ //prints out numbers at the top (0 1 2 3 ...)
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int j = 0; j < grid.getRows(); j++){ //prints out the grid
            System.out.println(j + "  " + "[0][0][0]");
        }

        //print safe tiles left
    }

    public String colour(Tile t){
        switch (t.surroundingMines){
            case 1:
                return "\u001B[34m"; //blue
            case 2:
                return "\u001B[32m"; //green
            case 3:
                return "\u001B[31m"; //red
            case 4:
                return "\u001B[35m"; //purple
            case 5:
                return "\u001B[33m"; //yellow
            default: 
                return "\u001B[0m"; //default
        }
    }
}