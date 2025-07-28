package matteomaspero.carrental;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CarRentalController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}