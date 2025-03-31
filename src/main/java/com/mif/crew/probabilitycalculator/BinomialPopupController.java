package com.mif.crew.probabilitycalculator;

import Utility.CalculatorLogic;
import Utility.Constants;
import Utility.DataHolder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.script.ScriptException;

import static Utility.Utilz.isDouble;
import static Utility.Utilz.isNumeric;

public class BinomialPopupController {

    @FXML
    private Button confirmButton;

    @FXML
    private TextField kValue;

    @FXML
    private TextField nValue;

    @FXML
    private TextField pValue;


    public void initialize(){
        confirmButton.setOnAction(this::handleConfirmation);
    }

    private void handleConfirmation(ActionEvent actionEvent) {
        try{
            CalculatorLogic.evaluate(pValue.getText());

            if(!nValue.getText().isEmpty() && !kValue.getText().isEmpty() && !pValue.getText().isEmpty()){
                if(isNumeric(nValue.getText()) && isNumeric(kValue.getText()) && isDouble(pValue.getText())) {
                    nValue.setStyle("-fx-border-color: gray");
                    pValue.setStyle("-fx-border-color: gray");
                    kValue.setStyle("-fx-border-color: gray");
                    sendData(actionEvent);

                    Stage stage = (Stage) confirmButton.getScene().getWindow();
                    stage.close();
                } else{
                nValue.setStyle("-fx-border-color: red");
                kValue.setStyle("-fx-border-color: red");
                pValue.setStyle("-fx-border-color: red");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            nValue.setStyle("-fx-border-color: red");
            pValue.setStyle("-fx-border-color: red");
            kValue.setStyle("-fx-border-color: red");
        }
    }
    private void sendData(ActionEvent actionEvent) {
        int n = 0;
        int k = 0;
        double p = 0;
        try {
            p = CalculatorLogic.evaluate(pValue.getText());
            n = Integer.parseInt(nValue.getText());
            k = Integer.parseInt(kValue.getText());

        }catch(Exception e){
            e.printStackTrace();
        }


        String expression = "";


        if (0 > k || k > n) {
            kValue.setStyle("-fx-border-color: red");
            return;
        }else{
            expression = Constants.BINOMIALFORMULA
                    .replace("n", String.valueOf(n))
                    .replace("k", String.valueOf(k))
                    .replace("p", String.valueOf(p));
        }

        double result;
        try {
            result = CalculatorLogic.evaluate(expression);
        } catch (ScriptException e) {
            e.printStackTrace();
            return;
        }

        DataHolder holder = DataHolder.getInstance();
        holder.setEquation(expression);
        holder.setResult(String.valueOf(result));
    }

}
