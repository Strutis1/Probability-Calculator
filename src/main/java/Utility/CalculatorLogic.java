package Utility;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


//TODO own engine for math

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class CalculatorLogic {

    public static boolean checkSyntax(String expression) {
        try {
            new ExpressionBuilder(expression).build();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static double evaluate(String expression) throws ScriptException {
        Expression exp = new ExpressionBuilder(expression).build();
        return exp.evaluate();
    }
}
