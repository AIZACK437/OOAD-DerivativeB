package bankingsystem.gui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class MainController {

    @FXML private Button btnRegister;
    @FXML private Button btnOpenAccount;
    @FXML private Button btnDeposit;
    @FXML private Button btnWithdraw;
    @FXML private Button btnApplyInterest;

 
    @FXML
    void onApplyInterestClicked(ActionEvent event) {
        System.out.println("Apply Interest clicked");
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
           FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
           Scene scene = new Scene(loader.load(), 600, 400);
           Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
           stage.setScene(scene);
       } catch (Exception e) {
           e.printStackTrace();
       }
   }

}
