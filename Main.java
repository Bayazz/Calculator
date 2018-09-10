package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.math.BigDecimal;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Super calculator");
        primaryStage.setScene(new Scene(root, 225, 275));
        primaryStage.setMaxWidth(240);
        primaryStage.setMaxHeight(300);
        primaryStage.setMinWidth(240);
        primaryStage.setMinHeight(315);
        primaryStage.show();

        double x = 25.124512;

        BigDecimal bigDecimal = new BigDecimal(x);
        bigDecimal = bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bigDecimal.doubleValue());


    }


    public static void main(String[] args) {
        launch(args);
    }
}
