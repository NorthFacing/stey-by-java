package com.adolphor.thenewboston.tutor12_ChoiceBox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  Stage window;
  Scene scene;
  Button button;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) throws Exception {

    window = primaryStage;
    window.setTitle("ChoiceBox example");

    ChoiceBox<String> choiceBox = new ChoiceBox<>();
    choiceBox.getItems().add("Apples");
    choiceBox.getItems().add("Bananas");
    choiceBox.getItems().addAll("Bacon", "Ham", "Meatballs");

    choiceBox.setValue("Apples"); // 默认值，默认值只有在添加的选项中存在的时候才会生效

    button = new Button("Click me");

    button.setOnAction(e -> getChoice(choiceBox));

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(20, 20, 20, 20));
    layout.getChildren().addAll(choiceBox, button);

    scene = new Scene(layout, 500, 300);
    window.setScene(scene);
    window.show();
  }

  private void getChoice(ChoiceBox<String> choiceBox) {
    String value = choiceBox.getValue();
    System.out.println(value);
  }

}
