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

public class ProgressionPopupController {

    @FXML
    private TextField aValue;

    @FXML
    private TextField nValue;

    @FXML
    private Button nthTermButton;

    @FXML
    private TextField rValue;

    @FXML
    private Button sumButton;


    public void initialize(){
        nthTermButton.setOnAction(this::handleConfirmation);
        sumButton.setOnAction(this::handleConfirmation);
        aValue.setOnAction(event -> {
            nthTermButton.setDisable(aValue.getText().equals("-"));
        });
    }

    private void handleConfirmation(ActionEvent actionEvent) {
        try{
            CalculatorLogic.evaluate(rValue.getText());
            CalculatorLogic.evaluate(aValue.getText());

            if(!nValue.getText().isEmpty() && !rValue.getText().isEmpty() && !aValue.getText().isEmpty()){
                nValue.setStyle("-fx-border-color: gray");
                rValue.setStyle("-fx-border-color: gray");
                aValue.setStyle("-fx-border-color: gray");
                sendData(actionEvent);

                Stage stage = (Stage) sumButton.getScene().getWindow();
                stage.close();
            }else{
                nValue.setStyle("-fx-border-color: red");
                rValue.setStyle("-fx-border-color: red");
                aValue.setStyle("-fx-border-color: red");
            }
        }catch(Exception e){
            e.printStackTrace();
            nValue.setStyle("-fx-border-color: red");
            rValue.setStyle("-fx-border-color: red");
            aValue.setStyle("-fx-border-color: red");
        }
    }
    private void sendData(ActionEvent actionEvent) {
        int n = 0;
        double r = 0;
        double a = 0;
        try {
            r = CalculatorLogic.evaluate(rValue.getText());
            a = CalculatorLogic.evaluate(aValue.getText());
        }catch(Exception e){
            e.printStackTrace();
        }

        if(!nValue.getText().equals("-")){
            n = Integer.parseInt(nValue.getText());
        }
        String expression = "";


        if(actionEvent.getSource() == nthTermButton) {
            expression = Constants.PROGRESSIONTERMFORMULA
                    .replace("n", String.valueOf(n))
                    .replace("r", String.valueOf(r))
                    .replace("a",String.valueOf(a));
        }

        else if(actionEvent.getSource() == sumButton){
            if(nValue.getText().equals("-")) {
                if (r >= 1 || r <= 0) {
                    rValue.setStyle("-fx-border-color: red");
                    return;
                }else{
                    expression = Constants.PROGRESSIONINFINITESUMFORMULA
                            .replace("r", String.valueOf(r))
                            .replace("a", String.valueOf(a));
                }
            }else if(isNumeric((nValue.getText()))){
                expression = Constants.PROGRESSIONFINITESUMFORMULA
                        .replace("n", String.valueOf(n))
                        .replace("r", String.valueOf(r))
                        .replace("a", String.valueOf(a));
            }
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
