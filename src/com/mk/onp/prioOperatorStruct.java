package com.mk.onp;
public class prioOperatorStruct {
    String equation;
    int priorityOp;
    prioOperatorStruct(String input){
        this.equation = input;
        this.priorityOp = 0;
    }
    prioOperatorStruct(String input, char operator){
        this.equation = input;
        this.priorityOp = priorityOperator(operator);
    }
    private int priorityOperator(char operator){
        switch (operator){
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

    public String getEquation() {
        return equation;
    }


    public int getPriorityOp() {
        return priorityOp;
    }
}
