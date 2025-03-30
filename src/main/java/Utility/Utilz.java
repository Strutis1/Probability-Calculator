package Utility;

import com.mif.crew.probabilitycalculator.ProbabilityCalculator;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.function.Consumer;

public class Utilz {
    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static void openPopUp(String fxmlName, Consumer<DataHolder> afterClose) {
        try {
            FXMLLoader loader = new FXMLLoader(ProbabilityCalculator.class.getResource(fxmlName));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Popup");
            stage.setScene(new Scene(root));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.showAndWait();

            afterClose.accept(DataHolder.getInstance());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
