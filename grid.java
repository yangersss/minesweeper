public class Grid {
    Tile[][] board;

    public Grid(int x, int y){
        board = new Tile[x][y];
    }
    
    public void generate(double difficulty){ //randomly set each tile based on difficulty AND set each tile's number of surroundingMines
        for (int l = 0; l < board.length; l++){
            for (int m = 0; m < board[l].length; m++){
                board[l][m] = new Tile();
            }
        }    

        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (difficulty > Math.random()){
                    board[i][j].safe = false;
                }
            }
        }
        for (int k = 0; k < board.length; k++){
            for (int l = 0; l < board.length; l++){
                int c = 0;
                if ((k-1) != -1 && l-1 != -1 && (k-1) < board[0].length && (l-1) < board.length && !(board[k-1][l-1].safe)){ //upper left, -1 -1
                    c++;
                }
                if (k-1 != -1 && l != -1 && (k-1) < board[0].length && (l) < board.length && !(board[k-1][l].safe)){ //upper middle, -1 0
                    c++;
                }
                if (k-1 != -1 && l+1 != -1 && (k-1) < board[0].length && (l+1) < board.length && !(board[k-1][l+1].safe)){ //upper right, -1 1
                    c++;
                }
                if (k != -1 && l-1 != -1 && (k) < board[0].length && (l-1) < board.length && !(board[k][l-1].safe)){ //middle left, 0 -1
                    c++;
                }
                if (k != -1 && l+1 != -1 && (k) < board[0].length && (l+1) < board.length && !(board[k][l+1].safe)){ //middle right, 0 1
                    c++;
                }
                if (k+1 != -1 && l-1 != -1 && (k+1) < board[0].length && (l-1) < board.length && !(board[k+1][l-1].safe)){ //lower left, 1 -1
                    c++;
                }
                if (k+1 != -1 && l != -1 && (k+1) < board[0].length && (l) < board.length && !(board[k+1][l].safe)){ //lower middle, 1 0
                    c++;
                }
                if (k+1 != -1 && l+1 != -1 && (k+1) < board[0].length && (l+1) < board.length && !(board[k+1][l+1].safe)){ //lower right, 1 1
                    c++;
                }
                board[k][l].surroundingMines = c;
            }
        }
    }

    public int getColumns(){
        return board[0].length;
    }

    public int getRows(){
        return board.length;
    }

    public Tile getTile(int x, int y){
        return board[x][y];
    }
    //generate the tiles in the grid
}
