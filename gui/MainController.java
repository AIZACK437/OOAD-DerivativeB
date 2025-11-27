package bankingsystem.gui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class MainController {

    @FXML private Button btnRegister;
    @FXML private Button btnOpenAccount;
    @FXML private Button btnDeposit;
    @FXML private Button btnWithdraw;
    @FXML private Button btnApplyInterest;

    @FXML
    void onOpenAccountClicked(ActionEvent event) {
        System.out.println("Open Account clicked");
        switchScene(event, "OpenAccountView.fxml");
    }

    @FXML
    void onApplyInterestClicked(ActionEvent event) {
        System.out.println("Apply Interest clicked");
        // Consider calling Bank.getInstance().applyInterestToAllAccounts() here
    }

    @FXML
    void onRegisterCustomerClicked(ActionEvent event) {
        switchScene(event, "RegisterView.fxml");
    }

    @FXML
    void onDepositClicked(ActionEvent event) {
        switchScene(event, "TransactionView.fxml");
    }

    @FXML
    void onWithdrawClicked(ActionEvent event) {
        switchScene(event, "TransactionView.fxml");
    }

    private void switchScene(ActionEvent event, String fxml) {
        try {
            // use absolute resource path to avoid classpath-relative inconsistencies
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/bankingsystem/gui/" + fxml));
            Parent root = loader.load();

            Scene scene = new Scene(root, 600, 400);
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}