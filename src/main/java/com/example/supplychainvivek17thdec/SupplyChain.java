package com.example.supplychainvivek17thdec;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;



import java.io.IOException;


public class SupplyChain extends Application {
    public static final int width = 700, height = 600, headerBar = 50;
    Pane bodyPane = new Pane();
    Login login = new Login();

    ProductDetails productDetails = new ProductDetails();


    private GridPane headerBar(){
        TextField searchText = new TextField();
        Button searchButton = new Button("search");
        searchButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String productName = searchText.getText();

                //clear body and put this new pane
                bodyPane.getChildren().clear();
                bodyPane.getChildren().add(productDetails.getProductsByName(productName));
            }
        });

        GridPane gridPane = new GridPane();

        gridPane.add(searchText, 0,0);
       gridPane.add(searchButton, 1,0);
//        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(), headerBar-10);
        gridPane.setVgap(5);
        gridPane.setHgap(5);
     //   gridPane.setStyle("-fx-background-color: #FF9900");   gives range in the search box.
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;

    }
    private GridPane loginPage(){
        Label emailLabel = new Label("Email");
        Label passwordLabel = new Label("Password");
        Label messageLabel = new Label(" I am Message");


        TextField emailTextField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button loginButton = new Button("Login");
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String email = emailTextField.getText();
                String password = passwordField.getText();
         // messageLabel.setText(email +" ** "+ password);
               if(login.customerLogin(email, password)){
                   messageLabel.setText("Login Successful");
               }
               else {
                   messageLabel.setText("Login Failed");
               }
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(bodyPane.getMinWidth(), bodyPane.getMinHeight());
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.setStyle("-fx-background-color: #FF9900");


        gridPane.setAlignment(Pos.CENTER);
// first is x coordinate , second is y coordinate.
        gridPane.add(emailLabel,0,0);
        gridPane.add(emailTextField,1,0);
        gridPane.add(passwordLabel,0,1);
        gridPane.add(passwordField,1,1);
        gridPane.add(loginButton, 0,2);
        gridPane.add(messageLabel, 1,2);


        return gridPane;
    }
 private Pane createContent(){
     Pane root = new Pane();
     root.setPrefSize(width, height+headerBar);

     bodyPane.setMinSize(width, height);
     bodyPane.setTranslateY(headerBar);

      bodyPane.getChildren().addAll(productDetails.getAllProducts());

     root.getChildren().addAll(headerBar(), bodyPane);
     return root;
 }
    @Override
    public void start(Stage stage) throws IOException {
        Scene scene = new Scene(createContent());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}