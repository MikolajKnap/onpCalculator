package com.mk.onp;

public class Onp {
    /**
     * Function to return priority of operators +,-,*,/,^,(
     * @param element (char) Operator that we want to get priority of
     * @return Based on given (char) operator returns int with appropriate value
     */
    public static int priority(char element){
        switch (element){
            case '(' -> {
                return 0;
            }
            case '+', '-' -> {
                return 1;
            }
            case '*', '/' -> {
                return 2;
            }
            case '^' -> {
                return 3;
            }
            default -> {
                return -1;
            }
        }
    }

    /**
     * Compares two values, from top of the stack and given element based on their priorities
     * and based on right-hand or left-hand communication
     * @param spValue String value from top of the stack
     * @param element Char given operator
     * @return True if value on the stack is > element when right-hand and >= when left-hand
     */
    public static boolean operatorHandler(String spValue, char element){
        if(priority(element) == 3 && priority(spValue.charAt(0)) > element)
            return true;
        else if (priority(spValue.charAt(0)) >= priority(element))
            return true;
        return false;
    }

    /**
     * Function that converts infix notation to postfix, returns String
     * @param input Infix equation as String
     * @return Returns string of postfix equation
     */
    public static String infixToPostfix(String input){
        StringBuilder output = new StringBuilder();
        String[] stack = new String[10];
        int sp = -1; // sp should start at -1 at the beginning

        for(int i = 0; i < input.length(); i++){
            char element = input.charAt(i);
            if(Character.isDigit(element)){
                output.append(element);
                // adding white-space when next character in input it not digit to handle multi-digit numbers
                if(i < input.length()-1 && !Character.isDigit(input.charAt(i+1))) output.append(" ");
            }
            else{
                switch(element){
                    case '+','-','*','/','^' -> {
                        while(sp >= 0 && operatorHandler(stack[sp],element)){
                            output.append(stack[sp]);
                            sp--;
                        }
                        sp++;
                        stack[sp] = String.valueOf(element);
                    }
                    case '(' -> {
                        sp++;
                        stack[sp] = String.valueOf(element);
                    }
                    case ')' -> {
                        while(sp >= 0 && !stack[sp].equals("(")){
                            output.append(stack[sp]);
                            sp--;
                        }
                        sp--;
                    }
                    case '=' -> {
                        while(sp >= 0){
                            output.append(stack[sp]);
                            sp--;
                        }
                        output.append(element);
                    }
                }
            }

        }
        return output.toString();
    }
}
