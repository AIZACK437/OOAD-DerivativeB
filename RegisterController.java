package bankingsystem.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import bankingsystem.core.Customer;  // import your existing class

public class RegisterController {

    @FXML private TextField txtFirstName;
    @FXML private TextField txtLastName;
    @FXML private TextField txtAddress;
    @FXML private Label lblStatus;

    @FXML
    void onRegisterClicked(ActionEvent event) {
        String fn = txtFirstName.getText();
        String ln = txtLastName.getText();
        String addr = txtAddress.getText();

        if (fn.isEmpty() || ln.isEmpty() || addr.isEmpty()) {
            lblStatus.setText("Please fill in all fields.");
            lblStatus.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        Customer c = new Customer(fn, ln, addr);
        lblStatus.setText("Customer registered: " + c.getFullName());
        lblStatus.setTextFill(javafx.scene.paint.Color.GREEN);

        txtFirstName.clear(); txtLastName.clear(); txtAddress.clear();
    }

    @FXML
    void onBackClicked(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MainView.fxml"));
            Scene scene = new Scene(loader.load(), 600, 400);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
