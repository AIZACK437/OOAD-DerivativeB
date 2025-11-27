package bankingsystem.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

import bankingsystem.Customer;
import bankingsystem.Bank;

public class RegisterController {

    @FXML private TextField txtFirstName;
    @FXML private TextField txtLastName;
    @FXML private TextField txtAddress;
    @FXML private Label lblStatus;

    @FXML
    void onRegisterClicked(ActionEvent event) {
        String fn = txtFirstName.getText().trim();
        String ln = txtLastName.getText().trim();
        String addr = txtAddress.getText().trim();

        if (fn.isEmpty() || ln.isEmpty() || addr.isEmpty()) {
            lblStatus.setText("Please fill in all fields.");
            lblStatus.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        Customer c = Bank.getInstance().createCustomer(fn, ln, addr);
        lblStatus.setText("Customer registered: " + c.getFullName());
        lblStatus.setTextFill(javafx.scene.paint.Color.GREEN);

        txtFirstName.clear();
        txtLastName.clear();
        txtAddress.clear();
    }

    @FXML
    void onBackClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/bankingsystem/gui/MainView.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(AlertType.ERROR, "Failed to go back to main view: " + e.getMessage()).showAndWait();
        }
    }
}