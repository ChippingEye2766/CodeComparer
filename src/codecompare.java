/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

import javafx.animation.FillTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 *
 * @author Nishant Sharma
 */
public class codecompare extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button login=new Button("Log In ");
        Button signup1=new Button("Sign up");
        Label label12=new Label();

        signup1.setOnAction(e->
        {
            System.out.print("true");
            signup.sign(primaryStage);
            primaryStage.close();
        });


        TextField username=new TextField("");
        username.setText("Akki");
        PasswordField passwordField=new PasswordField();
        passwordField.setPromptText("password");
       // passwordField.impl_showMnemonicsProperty();
        Tooltip toolkit=new Tooltip("Password must be 8 characters in length");
        passwordField.setTooltip(toolkit);
        Label user=new Label("Username :");
        Label password=new Label("Password :");
        login.getStyleClass().addAll("button-sign");
        user.setLayoutX(50);
        user.setLayoutY(100);
        password.setLayoutX(50);
        password.setLayoutY(150);
        passwordField.setLayoutX(140);
        passwordField.setLayoutY(150);
        username.setLayoutX(140);
        username.setLayoutY(100);
        login.setLayoutX(150);
        login.setLayoutY(200);
        signup1.setLayoutX(230);
        signup1.setLayoutY(200);
        AnchorPane layout=new AnchorPane();
        DropShadow shadow = new DropShadow();
//Adding the shadow when the mouse cursor is on
        login.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        login.setEffect(shadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        login.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        login.setEffect(null);
                    }
                });
       signup1.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        signup1.setEffect(shadow);
                    }
                });
//Removing the shadow when the mouse cursor is off
        signup1.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override public void handle(MouseEvent e) {
                        signup1.setEffect(null);
                    }
                });
        // imageView.s







        login.setOnAction(e->
                {
                   // label12=new Label();
                  //  label12.setText(" ");
                    layout.getChildren().removeAll(label12);
                    String a=username.getText();
                    String b=passwordField.getText();
                    String usernamemql =" ";
                    try
                    {
                        Class.forName("java.sql.DriverManager");
                        Connection con = (Connection)
                                DriverManager.getConnection
                                        ("jdbc:mysql://localhost:3306/codechecker",
                                                "root", "angleeye");
                        Statement stmt = (Statement) con.createStatement();
                        String query="SELECT password from login where Username = '"+a+"';";
                        ResultSet rs=stmt.executeQuery(query);
                       if(rs.wasNull())
                        {
                            label12.setText("Username or password is incorrect");
                            label12.setLayoutX(50);
                            label12.setLayoutY(50);
                        }
                        if (rs.next())
                        {

                            usernamemql=rs.getString("password");
                        }
                    }
                    catch (ClassNotFoundException e1) {

                    } catch (SQLException e1) {

                    }

                    if(!(b.equals(usernamemql)))
                    { label12.setLayoutX(50);layout.getChildren().addAll(label12);
                        label12.setLayoutY(50);
                        System.out.print("a");
                        label12.setText("Username or password is incorrect");
                    }
                    else
                    {
                        menu obj=new menu();
                        obj.home();
                        primaryStage.close();
                    }
                });

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
        layout.getChildren().addAll(rectangle,user,password,username,passwordField,login,signup1);




        Scene scene=new Scene(layout,436,346);

        scene.getStylesheets().add("drakula.css");
        primaryStage.setTitle("CodeChecker");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
