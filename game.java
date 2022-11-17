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


        if (t.surroundingMines == 0){
            return "\u001B[0m";
        }
    }
}