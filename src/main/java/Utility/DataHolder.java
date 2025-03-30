package Utility;

public class DataHolder {

    private static final DataHolder INSTANCE = new DataHolder();
    private String equation;
    private String result;


    private DataHolder() {}

    public static DataHolder getInstance() {
        return INSTANCE;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getEquation() {
        return equation;
    }

    public String getResult() {
        return result;
    }

    public void clear(){
        this.equation = null;
        this.result = null;
    }

}
