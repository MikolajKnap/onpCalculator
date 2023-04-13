import static com.mk.onp.Onp.calculateOnp;
import static com.mk.onp.Onp.infixToPostfix;

public class Main {
    public static void main(String[] args) {
        String input = args[0];
        System.out.println(input);
        System.out.println(infixToPostfix(input));
        System.out.println(calculateOnp(infixToPostfix(input)));
    }
}