package com.rcgonzalezf.sample;

import com.rcgonzalezf.adbviewer.TestDependency;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        TestDependency td = new TestDependency();
        td.foo();

//        Los Resources se estan yendo al lib
//                Si lo renombro ya queda?
//
//                jajajajaj
    }


    public static void main(String[] args) {
        launch(args);
    }
}
