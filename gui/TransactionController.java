package bankingsystem.gui;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

import bankingsystem.Bank;
import bankingsystem.Account;

public class TransactionController {

    @FXML private TextField txtAccountNumber;
    @FXML private TextField txtAmount;
    @FXML private Label lblMessage;

    @FXML
    void onDepositClicked(ActionEvent event) {
        String accNum = txtAccountNumber.getText().trim();
        double amount;

        try {
            amount = Double.parseDouble(txtAmount.getText().trim());
            if (amount <= 0) throw new NumberFormatException("Amount must be positive");
        } catch (Exception e) {
            lblMessage.setText("Invalid amount entered.");
            lblMessage.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        Account acc = Bank.getInstance().findAccount(accNum);
        if (acc == null) {
            lblMessage.setText("Account not found: " + accNum);
            lblMessage.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        acc.deposit(amount);
        lblMessage.setText("Deposited BWP " + amount + " to account " + accNum + ". New balance: BWP " + acc.getBalance());
        lblMessage.setTextFill(javafx.scene.paint.Color.GREEN);
    }

    @FXML
    void onWithdrawClicked(ActionEvent event) {
        String accNum = txtAccountNumber.getText().trim();
        double amount;

        try {
            amount = Double.parseDouble(txtAmount.getText().trim());
            if (amount <= 0) throw new NumberFormatException("Amount must be positive");
        } catch (Exception e) {
            lblMessage.setText("Invalid amount entered.");
            lblMessage.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        Account acc = Bank.getInstance().findAccount(accNum);
        if (acc == null) {
            lblMessage.setText("Account not found: " + accNum);
            lblMessage.setTextFill(javafx.scene.paint.Color.RED);
            return;
        }

        // The concrete Account.withdraw may print or refuse (e.g., Savings prevents withdraw).
        acc.withdraw(amount);
        lblMessage.setText("Attempted withdrawal of BWP " + amount + " from account " + accNum + ". Current balance: BWP " + acc.getBalance());
        lblMessage.setTextFill(javafx.scene.paint.Color.BLUE);
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