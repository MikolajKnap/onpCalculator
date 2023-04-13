import static com.mk.onp.Onp.calculateOnp;
import static com.mk.onp.Onp.infixToPostfix;

public class Main {
    public static void main(String[] args) {
        String input = "4 / (3 - 1) ^ (2 * 3) =";
        System.out.println(infixToPostfix(input));
        System.out.println(calculateOnp(infixToPostfix(input)));
    }
}