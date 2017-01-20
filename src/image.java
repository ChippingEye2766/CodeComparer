import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Stack;

public class image  {


    public static void imagebutton(HBox hbox) {

        Image image=new Image("back.png");
        ImageView imageView=new ImageView(image);
        Image image1=new Image("Edit-64.png");
        ImageView imageView1=new ImageView(image1);
        Image image2=new Image("File-64.png");
        ImageView imageView2=new ImageView(image2);
        Image image3=new Image("Home-64.png");
        ImageView imageView3=new ImageView(image3);
        Image image4=new Image("Search-64.png");
        ImageView imageView4=new ImageView(image4);
        Image image5=new Image("Settings-64.png");
        ImageView imageView5=new ImageView(image5);
        Image image6=new Image("Restart-64.png");
        ImageView imageView6=new ImageView(image6);
        Image image7=new Image("Contacts-64.png");
        ImageView imageView7=new ImageView(image7);
        Image image8=new Image("Lock-64.png");
        ImageView imageView8=new ImageView(image8);
        Image image9=new Image("Info-64.png");
        ImageView imageView9=new ImageView(image9);



        imageView.setFitWidth(30);
        imageView.setFitHeight(30);
        Button button=new Button();
        button.setGraphic(imageView);

        imageView1.setFitWidth(30);
        imageView1.setFitHeight(30);
        Button button1=new Button();
        button1.setGraphic(imageView1);

        imageView2.setFitWidth(30);
        imageView2.setFitHeight(30);
        Button button2=new Button();
        button2.setGraphic(imageView2);

        imageView3.setFitWidth(30);
        imageView3.setFitHeight(30);
        Button button3=new Button();
        button3.setGraphic(imageView3);

        imageView4.setFitWidth(30);
        imageView4.setFitHeight(30);
        Button button4=new Button();
        button4.setGraphic(imageView4);

        imageView5.setFitWidth(30);
        imageView5.setFitHeight(30);
        Button button5=new Button();
        button5.setGraphic(imageView5);

        imageView6.setFitWidth(30);
        imageView6.setFitHeight(30);
        Button button6=new Button();
        button6.setGraphic(imageView6);

        imageView7.setFitWidth(30);
        imageView7.setFitHeight(30);
        Button button7=new Button();
        button7.setGraphic(imageView7);




        imageView8.setFitWidth(30);
        imageView8.setFitHeight(30);
        Button button8=new Button();
        button8.setGraphic(imageView8);


        imageView9.setFitWidth(30);
        imageView9.setFitHeight(30);
        Button button9=new Button();
        button9.setGraphic(imageView9);


        button.getStyleClass().addAll("button-image");
        button1.getStyleClass().addAll("button-image");
        button3.getStyleClass().addAll("button-image");
        button2.getStyleClass().addAll("button-image");
        button4.getStyleClass().addAll("button-image");
        button5.getStyleClass().addAll("button-image");
        button6.getStyleClass().addAll("button-image");
        button7.getStyleClass().addAll("button-image");
        button8.getStyleClass().addAll("button-image");
        button9.getStyleClass().addAll("button-image");
        button.getStyleClass().addAll("button-image:hover");

        hbox.getChildren().addAll(button,button1,button2,button3,button4,button5,button6,button7,button8,button9);


    }
}
