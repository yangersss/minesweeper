public class Tile {
    boolean safe;
    boolean flipped;
    boolean flagged;
    int surroundingMines;

    public Tile(){ //by default a tile is unflipped, unflagged, and safe
        flipped = false;
        flagged = false;
        safe = true;
    }
    
    public String color(){ // make it nice and color coded. It takes in the number of surrounding mines and outputs the unicode character for the color
        switch (surroundingMines){
            case 0:
                return "\u001B[30m"; //black
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
            case 6:
                return "\u001B[31m"; //red
            case 7:
                return "\u001B[32m"; //green
            case 8:
                return "\u001B[36m"; //cyan
            default: 
                return "\u001B[0m"; //default
        }
    }
}