package com.adolphor.javafxchina.chapter01.form;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class JavaFxForm extends Application {

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX Welcome");

    GridPane grid = new GridPane();
    grid.setAlignment(Pos.CENTER);
    grid.setHgap(10);
    grid.setVgap(10);
    grid.setPadding(new Insets(25, 25, 25, 25));
    grid.getChildren().addAll();

    Text scenetitle = new Text("Welcome");
    scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
    grid.add(scenetitle, 0, 0, 2, 1);

    //创建Label对象，放到第0列，第1行
    Label userName = new Label("User Name:");
    grid.add(userName, 0, 1);

    //创建文本输入框，放到第1列，第1行
    TextField userTextField = new TextField();
    grid.add(userTextField, 1, 1);

    Label pw = new Label("Password:");
    grid.add(pw, 0, 2);

    PasswordField pwBox = new PasswordField();
    grid.add(pwBox, 1, 2);

    Button btn = new Button("Sign in");
    HBox hbBtn = new HBox(10);
    hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
    hbBtn.getChildren().add(btn);//将按钮控件作为子节点
    grid.add(hbBtn, 1, 4);//将HBox pane放到grid中的第1列，第4行

    final Text actiontarget = new Text();//增加用于显示信息的文本
    grid.add(actiontarget, 1, 6);

    btn.setOnAction(new EventHandler<ActionEvent>() {//注册事件handler
      @Override
      public void handle(ActionEvent e) {
        actiontarget.setFill(Color.FIREBRICK);//将文字颜色变成 firebrick red
        actiontarget.setText("Sign in button pressed");
      }
    });

    Scene scene = new Scene(grid, 300, 200);
    primaryStage.setScene(scene);

    primaryStage.show();

  }

}
