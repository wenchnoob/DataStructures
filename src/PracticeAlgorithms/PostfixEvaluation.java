package PracticeAlgorithms;

import Linear.Stack;

public class PostfixEvaluation {

    public static void main(String[] args) {
        PostfixEvaluation pfe = new PostfixEvaluation();
        System.out.println(pfe.postFixAnalyze("3 4 * 5 +"));
        System.out.println(pfe.postFixAnalyze("1 2 +"));
        System.out.println(pfe.postFixAnalyze("5 4 2 / 3 * +"));
        System.out.println(pfe.postFixAnalyze("1 2 -"));
        System.out.println(pfe.postFixAnalyze("1 2 3 -"));

    }

    private double postFixAnalyze(String s) {
        Stack<Double> numbers = new Stack<>();

        for(int i = 0; i < s.length(); i+=2) {
            if (Character.isDigit(s.charAt(i))) {
                numbers.push(Integer.valueOf(String.valueOf(s.charAt(i))).doubleValue());
            } else {
                double arg2 = numbers.pop();
                double arg1 = numbers.pop();
                numbers.push(evaluate(arg1, arg2, s.charAt(i)));
            }
        }
        if(numbers.size() > 1) return Double.NaN;
        return numbers.pop();
    }

    private double evaluate(double num1, double num2, char operator) {
        if(operator == '+') {
            return num1 + num2;
        } else if (operator == '-') {
            return num1 - num2;
        } else if (operator == '*') {
            return num1 * num2;
        } else if (operator == '/') {
            return num1/num2;
        } else { throw new IllegalArgumentException("Your input has an invalid operator."); }
    }

}
