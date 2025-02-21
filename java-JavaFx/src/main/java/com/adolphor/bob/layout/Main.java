package com.adolphor.bob.layout;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    BorderPane root = new BorderPane();

    root.setBackground(Background.EMPTY);

    Scene scene = new Scene(root, 600, 450);
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
