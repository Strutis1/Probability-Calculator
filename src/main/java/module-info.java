module com.mif.crew.probabilitycalculator {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.mif.crew.probabilitycalculator to javafx.fxml;
    exports com.mif.crew.probabilitycalculator;
}