import java.util.Scanner;

public class Game {
    Grid grid;

    public Game(){ //empty constructor
    }

    public void debugGrid() { // DEBUG: prings the grid showing mines and numbers
        System.out.print("    ");
        for (int i = 0; i < grid.getColumns(); i++){ //prints out numbers at the top (0 1 2 3 ...)
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int j = 0; j < grid.getRows(); j++){ //prints out the grid
            System.out.print(j + "  "); //prints out the row numbers for each row
            for (int k = 0; k < grid.getColumns(); k++){ //then, in each column, prints out the tiles
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

    public void printGrid(){ //non debug print grid, used to actually play the game instead of cheating :)
        System.out.print("    ");
        for (int i = 0; i < grid.getColumns(); i++){ //prints out numbers at the top (0 1 2 3 ...)
            System.out.print(i + "  ");
        }
        System.out.print("\n");
        for (int j = 0; j < grid.getRows(); j++){ //prints out the grid
            System.out.print(j + "  ");
            for (int k = 0; k < grid.getColumns(); k++){ //for every tile, if it's flagged, print it. Then check if it's flipped, and if it is, print it. Otherwise, print an "unknown" tile
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
        System.out.println("\u001B[0m\u001B[1m\u001B[32mSafe tiles left: " + grid.safeTiles() + "\u001B[0m"); // print the number of safe tiles left
    }

    public void play(){
        /*
        PSEUDOCODE:
        Welcome statement
        Instructions
        
        Loop:
        Checkwin
        Grid
        Input
        Checklose
        Printgrid
        */

        // you want to play? let's play
        
        boolean valid0 = false;
        while (!valid0){ // pester the user to input the width, height, and difficulty until they do it correctly
            Scanner scanner0 = new Scanner(System.in);
            System.out.print("\u001B[0m\u001B[3m\u001B[36mWhat is the grid width? \u001B[0m\u001B[4m\u001B[33m(Widths and heights over 10 will break the game)\u001B[0m ");
            String inputX = scanner0.nextLine();
            System.out.print("\u001B[0m\u001B[3m\u001B[36mWhat is the grid height? \u001B[0m\u001B[4m\u001B[33m(Widths and heights over 10 will break the game)\u001B[0m ");
            String inputY = scanner0.nextLine();
            System.out.print("\u001B[0m\u001B[3m\u001B[36mWhat is the difficulty? \u001B[0m\u001B[4m\u001B[33m(What proportion of the tiles are mines?)\u001B[0m ");
            String inputDifficulty = scanner0.nextLine();
            try{
                grid = new Grid(Integer.parseInt(inputX), Integer.parseInt(inputY));
                grid.generate(Double.parseDouble(inputDifficulty));
                valid0 = true;
            }
            catch (Exception e){
                System.out.println("\u001B[0m\u001B[1m\u001B[31mOne of those wasn't a valid input! Please make sure you are entering integers for the width and height, and a double (such as 0.15 or 0.32) for the difficulty(.15 and .32 will not work).\u001B[0m");
            }
        }

        boolean gameOn = true;
        while (gameOn){ //essentially, if we haven't won or lost yet
            if (grid.checkWin()){
                System.out.println("\u001B[0m\u001B[1m\u001B[32mYOU WON!!! PogU peepoHappy Here's what the grid looked like:\u001B[0m");
                debugGrid();
                gameOn = false;
                Scanner scanner = new Scanner(System.in);
                System.out.print("\u001B[0m\u001B[3m\u001B[36mWould you like to play again? Y/N:\u001B[0m "); //ask the uesr to play again and respond accordingly
                String playAgain = scanner.nextLine();
                if (playAgain.substring(0, 1).toLowerCase().equals("y")){
                    play();
                }
                else{
                    System.out.println("\u001B[0m\u001B[3m\u001B[36mOkay, bye!\u001B[0m");
                    System.exit(0);
                }
            }
            printGrid(); //CRUCIAL: each turn we print the grid
            
            String badInput = "\u001B[0m\u001B[1m\u001B[31mSorry, that's not a valid input!\nType F and then the coordinates (separated by spaces) to flag\nType the coordinates (separated by spaces) to flip a tile\nType debug to reveal the grid\u001B[0m";
            
            boolean valid = false;
            while (!valid){ //pester the user until they input a valid turn
                String input = input();
                if (input.toLowerCase().equals("debug")){ // an input of "debug" outputs the debug grid
                    System.out.println("\u001B[0m\u001B[7m\u001B[31m\u001B[40mɆ₦₮ɆⱤł₦₲ ĐɆ฿Ʉ₲ ₥ØĐɆ: (₵₳Ʉ₮łØ₦: Ʉ₦łⱤØ₦ł₵₳ⱠⱠɎ, ĐɆ฿Ʉ₲ ₥ØĐɆ ł₴ ฿Ʉ₲₲Ɏ)\u001B[0m");
                    debugGrid();
                    valid = true;
                }

                char[] aInput = input.toCharArray();
                try{
                    if (Character.toString(aInput[0]).toLowerCase().equals("f")){ //if the first char is "f", then try to flag that tile
                        int input1 = Integer.parseInt(Character.toString(aInput[2]));
                        int input2 = Integer.parseInt(Character.toString(aInput[4]));

                        grid.flag(input1, input2);
                        valid = true;
                    }
                    else{ //otherwise, flip the tile
                        int input1 = Integer.parseInt(Character.toString(aInput[0]));
                        int input2 = Integer.parseInt(Character.toString(aInput[2]));
                        if (grid.checkLose(input1, input2)){ // if the flipped tile was a mine, notify the user that they there is a "skill issue" as overwatch players like to say, then reveal the grid and ask them if they want to play again
                            System.out.println("\u001B[0m\u001B[31m\u001B[1mYOU LOSE!!!\n\u001B[0m\u001B[1m\u001B[32mHere's what the grid looked like:\u001B[0m");
                            debugGrid();
                            gameOn = false;
                            Scanner scanner = new Scanner(System.in);
                            System.out.print("\u001B[0m\u001B[3m\u001B[36mWould you like to play again? Y/N:\u001B[0m ");
                            String playAgain = scanner.nextLine();
                            if (playAgain.substring(0, 1).toLowerCase().equals("y")){
                                play();
                            }
                            else{
                                System.out.println("\u001B[0m\u001B[1m\u001B[32mOkay, bye!\u001B[0m");
                                System.exit(0);
                            }
                        }

                        if (grid.checkFlagged(input1, input2)){ // deny the user from flipping a flag
                            System.out.println("\u001B[0m\u001B[1m\u001B[31mYou can't flip a flag!\u001B[0m");
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

    public String input(){ //when called, asks the user to enter a move for a turn
        Scanner scanner = new Scanner(System.in);
        System.out.print("\u001B[0m\u001B[1m\u001B[32mMake your move:\u001B[0m");
        String input = scanner.nextLine();
        return input;
    }
}