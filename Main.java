public class Main {
    public static void main (String[] args) {
        
        // first time running the program, print a short lil' welcome message
        System.out.println("\u001B[0m\u001B[1m\u001B[32mWelcome to Edward's minesweeper, a recreation of minesweeper in the command line as a project for AP CS A!\u001B[0m");
        System.out.println("\u001B[0m\u001B[1m\u001B[32mTo flip a tile, type the coordinates separated by spaces. To flag a tile, type F, then a space, then the coordinates separated by spaces. A valid input would be: 3 9 or F 8 5\u001B[0m");
        
        Game test = new Game();
        test.play();
    }
}