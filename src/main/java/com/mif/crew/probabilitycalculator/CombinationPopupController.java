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

import static Utility.Utilz.isNumeric;

public class CombinationPopupController {


    @FXML
    private Button confirmButton;

    @FXML
    private TextField nValue;

    @FXML
    private TextField rValue;



    public void initialize(){
        confirmButton.setOnAction(this::handleConfirmation);
    }

    private void handleConfirmation(ActionEvent actionEvent) {
        try{
            if(nValue.getText().isEmpty() || rValue.getText().isEmpty()){
                nValue.setStyle("-fx-border-color: red");
                rValue.setStyle("-fx-border-color: red");
            }
            else if(isNumeric(nValue.getText()) && isNumeric(rValue.getText())){
                nValue.setStyle("-fx-border-color: gray");
                rValue.setStyle("-fx-border-color: gray");
                sendData();

                Stage stage = (Stage) confirmButton.getScene().getWindow();
                stage.close();
            }else{
                nValue.setStyle("-fx-border-color: red");
                rValue.setStyle("-fx-border-color: red");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void sendData() {
        int n = Integer.parseInt(nValue.getText());
        int r = Integer.parseInt(rValue.getText());

        if (r > n) {
            nValue.setStyle("-fx-border-color: red");
            rValue.setStyle("-fx-border-color: red");
            return;
        }

        String expression = Constants.COMBINATIONFORMULA
                .replace("n", String.valueOf(n))
                .replace("r", String.valueOf(r));

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
