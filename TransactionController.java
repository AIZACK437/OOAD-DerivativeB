package bankingsystem.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import bankingsystem.core.*; // import your Account classes

public class TransactionController {

    @FXML private TextField txtAccountNumber;
    @FXML private TextField txtAmount;
    @FXML private Label lblMessage;

    @FXML
    void onDepositClicked(ActionEvent event) {
        String accNum = txtAccountNumber.getText();
        double amount;

        try {
            amount = Double.parseDouble(txtAmount.getText());
        } catch (Exception e) {
            lblMessage.setText("Invalid amount entered.");
            lblMessage.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        lblMessage.setText("Deposited BWP " + amount + " to account " + accNum);
        lblMessage.setTextFill(javafx.scene.paint.Color.GREEN);
    }

    @FXML
    void onWithdrawClicked(ActionEvent event) {
        String accNum = txtAccountNumber.getText();
        double amount;

        try {
            amount = Double.parseDouble(txtAmount.getText());
        } catch (Exception e) {
            lblMessage.setText("Invalid amount entered.");
            lblMessage.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        lblMessage.setText("Withdrew BWP " + amount + " from account " + accNum);
        lblMessage.setTextFill(javafx.scene.paint.Color.BLUE);
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
