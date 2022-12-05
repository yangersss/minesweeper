public class Main {
    public static void main (String[] args) {
        //char[] testA = "h e l l o".toCharArray();
        //System.out.println(testA[1]);

        Grid test1 = new Grid(10, 10);
        Game test = new Game(test1);
        test1.generate(0.2);
        test.printGrid();
        test.input();
    }
}
