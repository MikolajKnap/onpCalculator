import static com.mk.onp.Onp.*;

public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++){
            System.out.println("Infix " + args[i]);
            System.out.println("Postfix: " + infixToPostfix(args[i]));
            System.out.println("Result: " + calculateOnp(infixToPostfix(args[i])));
            System.out.println("PostfixToInfix: " + postfixToInfix(infixToPostfix(args[i])));
            System.out.println();
        }
    }
}