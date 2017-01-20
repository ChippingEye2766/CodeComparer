/**
 * Created by Nishant on 09-06-2016.
 */

import javafx.animation.FillTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class signup  {

    public static void sign(Stage window1)
    {
        // Declaring varibles
        Label label=new Label();
        Label label1=new Label();
      Stage window=new Stage();
        window.setTitle("Sign Up Window");
        Button button=new Button("Sign up");
        Button backsignup=new Button("");
        Image image=new Image("back.png");
        ImageView imageView=new ImageView(image);
        imageView.setFitHeight(30);
        imageView.setFitWidth(30);
        backsignup.setGraphic(imageView);
        backsignup.getStyleClass().addAll("button-back");
        backsignup.setOnAction(e->
        {
           // if(firstname)
            window.close();
            window1.show();

        });
        TextField firstname=new TextField();
        TextField secondname=new TextField();
        TextField username=new TextField("");
        PasswordField passwordField=new PasswordField();
        passwordField.setPromptText("password");
        Tooltip toolkit=new Tooltip("Password must be 8 characters in length");
        passwordField.setTooltip(toolkit);
        PasswordField passwordField1=new PasswordField();
        passwordField1.setPromptText(" Confirm password");
        Label user=new Label("Username  :");
        Label password=new Label("Password  :");
        Label password2=new Label("Password  :");
        Label firstname1=new Label("First Name :");
        Label secondname1=new Label("Last Name :");
        GridPane pane=new GridPane();
        // Button action
        backsignup.setOnAction(e->
        {

            window.close();
            window1.show();

        });

        // sign up button
        button.setOnAction(e->
        {
            pane.getChildren().removeAll(label,label1);
            if(firstname.getText().isEmpty())
            {
                label.setText("Empty Field");
                GridPane.setConstraints(label,2,0);
                pane.getChildren().add(label);

            }
           else if(secondname.getText().isEmpty())
            {

                label1.setText("Empty Field");
                GridPane.setConstraints(label1,2,1);
                pane.getChildren().add(label1);

            }
            else if(username.getText().isEmpty())
            {

                label1.setText("Empty Field");
                GridPane.setConstraints(label1,2,2);
                pane.getChildren().add(label1);

            }
            else if(passwordField.getText().isEmpty())
            {

                label1.setText("Enter Password");
                GridPane.setConstraints(label1,2,3);
                pane.getChildren().add(label1);

            }
            else if(!((passwordField.getText()).equals(passwordField1.getText())))
            {
                label1.setText("Pswd didnt match");
                label.setWrapText(true);
                GridPane.setConstraints(label1,2,4);
                pane.getChildren().add(label1);

            }
            else
            {
                // signing up

                pane.getChildren().removeAll(label,label1);
                String fullname=firstname.getText()+secondname.getText();
                String Usernameforstoring=username.getText();
                String passwordforstoring=passwordField.getText();
                try
                {
                    Class.forName("java.sql.DriverManager");
                    Connection con = (Connection)
                            DriverManager.getConnection
                                    ("jdbc:mysql://localhost:3306/codechecker",
                                            "root", "angleeye");
                    Statement stmt = (Statement) con.createStatement();
                    String query="INSERT INTO login VALUES ('"+fullname+"','"+Usernameforstoring+"','"+passwordforstoring+"');";
                    stmt.executeUpdate(query);
                } catch (ClassNotFoundException e1) {
                    e1.printStackTrace();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

        });



        DropShadow shadow=new DropShadow();
        Shadow effect=new Shadow();
       button.getStyleClass().add("button-sign");
//Adding the shadow when the mouse cursor is on
        button.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(shadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        button.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        button.setEffect(null);
                    }
                });
        //Adding the shadow when the mouse cursor is on
        backsignup.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        backsignup.setEffect(shadow);
                    }
                });
//Removing the shadow when the mouse cursor is off

        backsignup.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        backsignup.setEffect(null);
                    }
                });
        pane.setVgap(25);
        pane.setHgap(20);
        GridPane.setConstraints(firstname1,0,0);
        GridPane.setConstraints(secondname1,0,1);
        GridPane.setConstraints(user,0,2);
        GridPane.setConstraints(password,0,3);
        GridPane.setConstraints(password2,0,4);
        GridPane.setConstraints(firstname,1,0);
        GridPane.setConstraints(secondname,1,1);
        GridPane.setConstraints(username,1,2);
        GridPane.setConstraints(passwordField,1,3);
        GridPane.setConstraints(passwordField1,1,4);
        GridPane.setConstraints(button,1,5);
        GridPane.setConstraints(backsignup,0,5);

        Rectangle rectangle=new Rectangle(0,0,4000,4000);

        FillTransition fillTransition=new FillTransition(Duration.millis(5000),rectangle, Color.RED,Color.BLUE);
        FillTransition fillTransition1=new FillTransition(Duration.millis(5000),rectangle, Color.BLUE,Color.MEDIUMSEAGREEN);
        FillTransition fillTransition2=new FillTransition(Duration.millis(5000),rectangle, Color.MEDIUMSEAGREEN,Color.YELLOWGREEN);
        FillTransition fillTransition3=new FillTransition(Duration.millis(5000),rectangle, Color.YELLOWGREEN,Color.DIMGRAY);
        SequentialTransition sequentialTransition=new SequentialTransition();
        sequentialTransition.getChildren().addAll(fillTransition,fillTransition1,fillTransition2,fillTransition3);
        sequentialTransition.setCycleCount(Timeline.INDEFINITE);
        sequentialTransition.setAutoReverse(true);
        sequentialTransition.play();

        pane.setPadding(new Insets(50,50,50,50));
        pane.getChildren().addAll(firstname1,secondname1,user,password,password2,firstname,secondname,username,passwordField,passwordField1,button,backsignup);
        Group root=new Group();
        root.getChildren().addAll(rectangle,pane);
        Scene scene=new Scene(root,550,500);

        scene.getStylesheets().addAll("darkula.css");
        window.setScene(scene);
        window.setResizable(false);
        window.show();
    }

}
