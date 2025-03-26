package com.mif.crew.probabilitycalculator;

import Utility.Calculation;
import Utility.CalculatorLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;

import javax.script.ScriptException;

public class CalcController {

    @FXML
    private Tab advancedMathTab;

    @FXML
    private Tab basicMathTab;

    @FXML
    private Button calcButton;

    @FXML
    private Tab calcTab;

    @FXML
    private Button clearButton;

    @FXML
    private Button divisionButton;

    @FXML
    private Button dotButton;

    @FXML
    private Button eightButton;

    @FXML
    private LineChart<?, ?> equationChart;

    @FXML
    private TableColumn<Calculation, String> equationColumn;

    @FXML
    private TextArea equationText;

    @FXML
    private Button fiveButton;

    @FXML
    private Button fourButton;

    @FXML
    private Tab graphTab;

    @FXML
    private Tab historyTab;

    @FXML
    private TableView<Calculation> historyTable;

    @FXML
    private Tab infoTab;

    @FXML
    private Button leftBracketButton;

    @FXML
    private Button multButton;

    @FXML
    private Button neinButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button plusButton;

    @FXML
    private Button raisePowerButton;

    @FXML
    private TableColumn<Calculation, String> resultColumn;

    @FXML
    private Button rightBracketButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button sqRootButton;

    @FXML
    private Button squareButton;

    @FXML
    private Button subButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button zeroButton;

    ObservableList<Calculation> equationList = FXCollections.observableArrayList();


    public void initialize(){
        historyTable.setItems(equationList);
        equationColumn.setCellValueFactory(cellData -> cellData.getValue().equationProperty());
        resultColumn.setCellValueFactory(cellData -> cellData.getValue().resultProperty());

        equationText.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER){
                handleCalculations();
                equationText.positionCaret(equationText.getText().length());
            }
        });

        zeroButton.setOnAction(event -> {
            equationText.appendText("0");
        });
        oneButton.setOnAction(event -> {
            equationText.appendText("1");
        });
        twoButton.setOnAction(event -> {
            equationText.appendText("2");
        });
        threeButton.setOnAction(event -> {
            equationText.appendText("3");
        });
        fourButton.setOnAction(event -> {
            equationText.appendText("4");
        });
        fiveButton.setOnAction(event -> {
            equationText.appendText("5");
        });
        sixButton.setOnAction(event -> {
            equationText.appendText("6");
        });
        sevenButton.setOnAction(event -> {
            equationText.appendText("7");
        });
        eightButton.setOnAction(event -> {
            equationText.appendText("8");
        });
        neinButton.setOnAction(event -> {
            equationText.appendText("9");
        });
        dotButton.setOnAction(event -> {
            equationText.appendText(".");
        });
        multButton.setOnAction(event -> {
            equationText.appendText("*");
        });
        plusButton.setOnAction(event -> {
            equationText.appendText("+");
        });
        subButton.setOnAction(event -> {
            equationText.appendText("-");
        });
        divisionButton.setOnAction(event -> {
            equationText.appendText("/");
        });
        leftBracketButton.setOnAction(event -> {
            equationText.appendText("(");
        });
        rightBracketButton.setOnAction(event -> {
            equationText.appendText(")");
        });
        squareButton.setOnAction(event -> {
            equationText.appendText("^2");
        });

        calcButton.setOnAction(event ->{handleCalculations();});

        clearButton.setOnAction(event-> equationText.clear());

    }

    private void handleCalculations(){
        if(CalculatorLogic.checkSyntax(equationText.getText())){
            Calculation newEquation = new Calculation(equationText.getText());
            try {
                equationText.setText(String.valueOf(CalculatorLogic.evaluate(equationText.getText())));
                newEquation.setResult(equationText.getText());
                equationList.add(newEquation);
            }catch(ScriptException e){
                equationList.add(newEquation);
            }
        }else{
            System.out.println("Invalid equation");
        }
    }
}
