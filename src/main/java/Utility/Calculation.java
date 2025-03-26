package Utility;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calculation {
    private StringProperty equation = new SimpleStringProperty();;
    private StringProperty result = new SimpleStringProperty("Unknown");;



    public Calculation(String equation, String result) {
        this.equation.set(equation);
        this.result.set(result);
    }

    public Calculation(String equation) {
        this.equation.set(equation);
    }

    public String getEquation() {
        return equation.get();
    }

    public StringProperty equationProperty() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation.set(equation);
    }

    public String getResult() {
        return result.get();
    }

    public StringProperty resultProperty() {
        return result;
    }

    public void setResult(String result) {
        this.result.set(result);
    }
}
