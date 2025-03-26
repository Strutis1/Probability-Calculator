package com.mif.crew.probabilitycalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import static javafx.scene.input.KeyCode.NUMPAD0;

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
    private TextArea equationText;

    @FXML
    private Button fiveButton;

    @FXML
    private Button fourButton;

    @FXML
    private Tab graphTab;

    @FXML
    private Tab infoTab;

    @FXML
    private Button multButton;

    @FXML
    private Button neinButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button plusbutton;

    @FXML
    private Button raisePowerButton;

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
    private Button leftBracketButton;

    @FXML
    private Button rightBracketButton;

    public void initialize(){
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
        plusbutton.setOnAction(event -> {
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

        clearButton.setOnAction(event-> equationText.clear());

    }
}
