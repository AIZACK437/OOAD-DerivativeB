package bankingsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BankingApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML from the gui folder
        FXMLLoader loader = new FXMLLoader(getClass().getResource("gui/MainView.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Banking System");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
