import java.util.HashSet;
import java.util.Scanner;

public class LeanApplication {
    private int subtotal = 0;
    private int numberOfCherries = 0;
    private int numberOfBannanas = 0;
    private HashSet apples = new HashSet() {{
        add("mele");
        add("pommes");
        add("apples");
    }};
    private int numberOfPommes = 0;
    private int numberOfMeles = 0;

    public int process(String fruitName) {
        incrementPurchasesOf(fruitName);
        return calculateSubtotal(fruitName) - calculateDiscounts();
    }

    private int calculateSubtotal(String fruitName) {
        if (fruitName.equals("cherries")) {
            subtotal += 75;
        }
        if (isApple(fruitName)) {
            subtotal += 100;
        }
        if (fruitName.equals("bananas")) {
            subtotal += 150;
        }
        return subtotal;
    }

    private void incrementPurchasesOf(String fruitName) {
        if (fruitName.equals("cherries")) {
            numberOfCherries++;
        }
        if (fruitName.equals("pommes")) {
            numberOfPommes++;
        }
        if (fruitName.equals("mele")) {
            numberOfMeles++;
        }
        if (fruitName.equals("bananas")) {
            numberOfBannanas++;
        }
    }

    private boolean isApple(String fruitName) {
        return apples.contains(fruitName);
    }

    private int calculateDiscounts() {
        return (int) (
                (Math.floor(numberOfCherries / 2)) * 20 +
                        (Math.floor(numberOfMeles / 2)) * 100 +
                        (Math.floor(numberOfPommes / 3)) * 100 +
                        (Math.floor(numberOfBannanas / 2)) * 150
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeanApplication app = new LeanApplication();
        String input = "";
        while (!"exit".equals(input)) {
            input = scanner.next();
            System.out.println(input + " => " + app.processCSV(input));
        }
    }

    public int processCSV(String csv) {
        String[] fruits = csv.split(",");
        int restul = 0;
        for (String fruit : fruits) {
            restul = process(fruit);
        }
        return restul;
    }
}
