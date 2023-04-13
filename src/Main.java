import static com.mk.onp.Onp.infixToPostfix;

public class Main {
    public static void main(String[] args) {
        String input = "(15-3)^(3+2)*6/3=";
        System.out.println(infixToPostfix(input));
    }
}