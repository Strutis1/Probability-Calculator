package com.mif.crew.probabilitycalculator;

import Utility.Calculation;
import Utility.CalculatorLogic;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;

import javafx.scene.layout.VBox;

import javax.script.ScriptException;

public class CalcController {

    @FXML
    private Tab advancedMathTab;

    @FXML
    private Button binomialButton;

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
    private TextArea infoText;

    @FXML
    private TabPane innerCalcTabPane;

    @FXML
    private Button leftBracketButton;

    @FXML
    private TabPane mainTabPane;

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

    @FXML
    private VBox calcScreenBox;

    @FXML
    private Button combinationButton;

    @FXML
    private Button muavreButton;

    @FXML
    private Button permutationButton;

    @FXML
    private Button poissonButton;

    @FXML
    private Button moveLeft;

    @FXML
    private Button moveRight;

    @FXML
    private Button geometricProgressionButton;

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

        sqRootButton.setOnAction(event ->{

        });

        moveLeft.setOnAction(event -> {
            equationText.positionCaret(equationText.getCaretPosition() - 1);
            equationText.requestFocus();
        });
        moveRight.setOnAction(event -> {
            equationText.positionCaret(equationText.getCaretPosition() + 1);
            equationText.requestFocus();
        });

        zeroButton.setOnAction(event -> {
            insertAtCaret("0");
        });
        oneButton.setOnAction(event -> {
            insertAtCaret("1");
        });
        twoButton.setOnAction(event -> {
            insertAtCaret("2");
        });
        threeButton.setOnAction(event -> {
            insertAtCaret("3");
        });
        fourButton.setOnAction(event -> {
            insertAtCaret("4");
        });
        fiveButton.setOnAction(event -> {
            insertAtCaret("5");
        });
        sixButton.setOnAction(event -> {
            insertAtCaret("6");
        });
        sevenButton.setOnAction(event -> {
            insertAtCaret("7");
        });
        eightButton.setOnAction(event -> {
            insertAtCaret("8");
        });
        neinButton.setOnAction(event -> {
            insertAtCaret("9");
        });
        dotButton.setOnAction(event -> {
            insertAtCaret(".");
        });
        multButton.setOnAction(event -> {
            insertAtCaret("*");
        });
        plusButton.setOnAction(event -> {
            insertAtCaret("+");
        });
        subButton.setOnAction(event -> {
            insertAtCaret("-");
        });
        divisionButton.setOnAction(event -> {
            insertAtCaret("/");
        });
        leftBracketButton.setOnAction(event -> {
            insertAtCaret("(");
        });
        rightBracketButton.setOnAction(event -> {
            insertAtCaret(")");
        });
        squareButton.setOnAction(event -> {
            insertAtCaret("^2");
        });

        calcButton.setOnAction(event ->{handleCalculations();});

        clearButton.setOnAction(event-> equationText.clear());

        historyTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                equationText.clear();
                equationText.setText(newSelection.getEquation());
                mainTabPane.getSelectionModel().select(calcTab);
                historyTable.getSelectionModel().select(-1);
            }
        });

    }
    
    
    private void insertAtCaret(String text) {
        equationText.insertText(equationText.getCaretPosition(), text);
        equationText.requestFocus();
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
