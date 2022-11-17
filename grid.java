public class Grid {
    Tile[][] board;

    public Grid(int x, int y){
        board = new Tile[x][y];
    }
    
    public void generate(int difficulty){ 
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (difficulty > Math.random()){
                    board[i][j].safe = false;
                }
            }
        }
    }
    //generate the tiles in the grid
}
