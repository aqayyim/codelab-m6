package com.main.modul6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Login");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 1);

        TextField usernameField = new TextField();
        grid.add(usernameField, 1, 1);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 2);

        PasswordField passwordField = new PasswordField();
        grid.add(passwordField, 1, 2);

        Button loginButton = new Button("Login");
        grid.add(loginButton, 1, 4);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        loginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();

            if (username.equals("koyim") && password.equals("koyim")) {
                showHomePage();
            } else {
                actionTarget.setFill(javafx.scene.paint.Color.FIREBRICK);
                actionTarget.setText("Username atau password salah!");
            }
        });

        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

    private void showHomePage() {
        VBox vbox = new VBox(20);
        vbox.setAlignment(Pos.CENTER);

        Label welcomeLabel = new Label("Selamat datang koyim!");
        Button logoutButton = new Button("Logout");
        logoutButton.setOnAction(e -> {
            primaryStage.close();
        });

        vbox.getChildren().addAll(welcomeLabel, logoutButton);

        Scene scene = new Scene(vbox, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}