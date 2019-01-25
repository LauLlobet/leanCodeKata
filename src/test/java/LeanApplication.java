import java.util.HashSet;
import java.util.Scanner;

public class LeanApplication {
    private int subtotal = 0;
    private int numberOfCherries = 0;
    private int numberOfBannanas = 0;
    private HashSet apples = new HashSet() {{
        add("meles");
        add("pommes");
        add("apples");
    }};

    public int process(String fruitName) {
        return calculateSubtotal(fruitName) - calculateDiscounts();
    }

    private int calculateSubtotal(String fruitName) {
        if (fruitName.equals("cherries")) {
            subtotal += 75;
            numberOfCherries++;
        }

        if (isApple(fruitName)) {
            subtotal += 100;
        }

        if (fruitName.equals("bananas")) {
            subtotal += 150;
            numberOfBannanas++;
        }
        return subtotal;
    }

    private boolean isApple(String fruitName) {
        return apples.contains(fruitName);
    }

    private int calculateDiscounts() {
        return (int)(
                (Math.floor(numberOfCherries / 2)) * 20 +
                (Math.floor(numberOfBannanas / 2)) * 150
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LeanApplication app = new LeanApplication();
        String input = "";
        while (!"exit".equals(input)) {
            input = scanner.next();
            System.out.println(input + " => " + app.process(input));
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
