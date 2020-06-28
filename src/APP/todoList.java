package APP;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.*;
import javafx.scene.*;
import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class todoList extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Todo：加载相关资源，初始化app
        try {
            Parent root = FXMLLoader.load(getClass().getResource("todoList.fxml"));
            Scene scene = new Scene(root, 300, 275);
            primaryStage.setTitle("To Do List");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
