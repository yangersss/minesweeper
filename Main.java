public class Main {
    public static void main (String[] args) {
        
        System.out.println("Welcome to Edward's minesweeper, a recreation of minesweeper in the command line as a project for AP CS A!");
        System.out.println("To flip a tile, type the coordinates separated by spaces. To flag a tile, type F, then a space, then the coordinates separated by spaces. A valid input would be: 3 9 or F 8 5");
        
        Game test = new Game();
        test.play();
        
    }
}