package com.mk.onp;

public class Onp {
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
    public static boolean operatorHandler(String spValue, char element){
        if(priority(element) == 3 && priority(spValue.charAt(0)) > element)
            return true;
        else if (priority(spValue.charAt(0)) >= priority(element))
            return true;
        return false;
    }
    public static String infixToPostfix(String input){
        StringBuilder output = new StringBuilder();
        String[] stack = new String[10];
        int sp = -1;

        for(int i = 0; i < input.length(); i++){
            char element = input.charAt(i);
            if(Character.isDigit(element)){
                output.append(element);
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
