package Utility;

import net.objecthunter.exp4j.operator.Operator;

public class Factorial {
    public static Operator get() {
        return new Operator("!", 1, true, Operator.PRECEDENCE_POWER + 1) {
            @Override
            public double apply(double... args) {
                int n = (int) args[0];
                if (n < 0) {
                    throw new IllegalArgumentException("Factorial only defined for non-negative integers");
                }
                double result = 1;
                for (int i = 2; i <= n; i++) {
                    result *= i;
                }
                return result;
            }
        };
    }
}
