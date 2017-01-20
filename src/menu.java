/**
 * Created by Nishant Sharma on 6/3/2016.
 */

import com.sun.xml.internal.ws.util.InjectionPlan;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.effect.Reflection;
import javafx.scene.input.ScrollEvent;
import javafx.scene.input.ZoomEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;


public class menu  {
    File file;
    File filearray[];
     File code ;
    ListView<String> selectedfiles;
    List<File> selectedfiles1;
    ArrayList<Button> arrayList=new ArrayList<>();
    ArrayList<Chart> chartArrayList=new ArrayList<>();
    int count;
    int count2;
    ScrollBar sc;

    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    LineChart<String,Number> lineChart=new LineChart<String, Number>(xAxis,yAxis);

    CategoryAxis xAxis1 = new CategoryAxis();
    NumberAxis yAxis1= new NumberAxis();
    BarChart<String,Number> bc =
            new BarChart<String,Number>(xAxis1,yAxis1);

    PieChart chart=new PieChart() ;


    BorderPane layout;
    VBox VBOX=new VBox(20);
    //FlowPane vbox=new FlowPane();
    //Button button[]=new Button[0];

    public  void  home() {

        File file;
        File filearray[];
        final File[] code = new File[1];
        ListView<String> selectedfiles;
         CategoryAxis xAxis = new CategoryAxis();
         NumberAxis yAxis = new NumberAxis();
        LineChart<String,Number> lineChart=new LineChart<String, Number>(xAxis,yAxis);

        Stage window=new Stage();
                                                                                                                 // creating menu File1
        Menu file1=new Menu("_File");
                                                                                                                  //Creating Menu items
        MenuItem fileitem1=new MenuItem("New...");
        fileitem1.setOnAction(e->filenew());

        MenuItem fileitem2=new MenuItem("Setting...");
        fileitem2.setOnAction(e->filesetting());

        Menu fileitem3=new Menu("Password");
        MenuItem pass1=new MenuItem("Change Password");
        pass1.setOnAction(e->changepassword());
        MenuItem pass2=new MenuItem("Remove Password");
        pass2.setOnAction(e->removepassword());
        fileitem3.getItems().addAll(pass1,pass2);
       /* MenuItem fileitem3=new MenuItem("Password");
        fileitem3.setOnAction(e->filepassword());*/

        MenuItem fileitem4=new MenuItem("ScreenShot");
        fileitem4.setDisable(true);
        fileitem4.setOnAction(e->fileScreenShot());

        MenuItem fileitem5=new MenuItem("Exit");
        fileitem5.setOnAction(e->fileexit());

        file1.getItems().add(fileitem1);
        file1.getItems().add(fileitem2);
        file1.getItems().add(new SeparatorMenuItem());
        file1.getItems().add(fileitem3);
        file1.getItems().add(new SeparatorMenuItem());
        file1.getItems().add(fileitem4);
        file1.getItems().add(fileitem5);

                                                                                                               // creating menu File2
        Menu file2=new Menu("_Tools");

                                                                                                               //Creating Menu items
        MenuItem toolitem1=new MenuItem("Find...");
        toolitem1.setOnAction(e->toolfind());

        MenuItem toolitem2=new MenuItem("Change Image...");
        toolitem2.setOnAction(e->toolchange());

        Menu toolitem3=new Menu("Graphs");
        ToggleGroup toggleGroup=new ToggleGroup();
        RadioMenuItem graph=new RadioMenuItem("Pie");
        graph.setOnAction(e->pie());
        RadioMenuItem graph1=new RadioMenuItem("Bar");
        graph1.setOnAction(e->bar());
        RadioMenuItem graph2=new RadioMenuItem("Line");
        graph2.setOnAction(e->line());
        graph.setSelected(true);
        graph.setToggleGroup(toggleGroup);
        graph1.setToggleGroup(toggleGroup);
        graph2.setToggleGroup(toggleGroup);
        toolitem3.getItems().addAll(graph,graph1,graph2);

        Menu toolitem4=new Menu("Fonts");
        ToggleGroup toggleGroup1=new ToggleGroup();
        RadioMenuItem font1=new RadioMenuItem("Times New Roman");
        font1.setOnAction(e->toolfonts1());
        RadioMenuItem font2=new RadioMenuItem("Calibri");
        font2.setOnAction(e->toolfonts2());
        RadioMenuItem font3=new RadioMenuItem("Arial");
        font3.setOnAction(e->toolfonts3());
        RadioMenuItem font4=new RadioMenuItem("Segoe");
        font4.setOnAction(e->toolfonts4());
        RadioMenuItem font5=new RadioMenuItem("Georgia");
        font5.setOnAction(e->toolfonts5());
        font1.setToggleGroup(toggleGroup1);
        font2.setToggleGroup(toggleGroup1);
        font3.setToggleGroup(toggleGroup1);
        font4.setToggleGroup(toggleGroup1);
        font5.setToggleGroup(toggleGroup1);
        toolitem4.getItems().addAll(font1,font2,font3,font4,font5);

        MenuItem toolitem5=new MenuItem("Enter Fullscreen");
        toolitem5.setOnAction(e->toolfull());

        file2.getItems().add(toolitem1);
        file2.getItems().add(toolitem2);
        file2.getItems().add(new SeparatorMenuItem());
        file2.getItems().add(toolitem3);
        file2.getItems().add(new SeparatorMenuItem());
        file2.getItems().add(toolitem4);
        file2.getItems().add(toolitem5);

                                                                                                                // creating menu File3
        Menu file3=new Menu("_Run");
                                                                                                               //Creating Menu items
        MenuItem runitem1=new MenuItem("Run");
        runitem1.setDisable(true);
        runitem1.setOnAction(e->runrun());

        MenuItem runitem2=new MenuItem("Reset");
        runitem2.setDisable(true);
        runitem2.setOnAction(e->runreset());

        MenuItem runitem3=new MenuItem("Backend");
        runitem3.setDisable(true);
        runitem3.setOnAction(e->runbackend());
        file3.getItems().add(runitem1);
        file3.getItems().add(runitem2);
        file3.getItems().add(runitem3);

                                                                                                                 // creating menu File4
        Menu file4=new Menu("_Help");
        file4.getItems().add(new MenuItem("About CC"));
        file4.getItems().add(new MenuItem("FAQ"));
        file4.getItems().add(new MenuItem("Terms and Services Policy"));
        file4.getItems().add(new MenuItem("Donation"));
        file4.getItems().add(new MenuItem("Support Centre"));

                                                                                                            // creating menu File3.5
        Menu file5=new Menu("_Algorithm");
        ToggleGroup algo=new ToggleGroup();
        RadioMenuItem doc=new RadioMenuItem("Doc distance");
        RadioMenuItem doc1=new RadioMenuItem("Algo 2");
          doc.setToggleGroup(algo);
        doc1.setToggleGroup(algo);
        doc.setSelected(true);
        doc.setOnAction(e-> algodoc());
        doc1.setOnAction(e-> algodoc1());
        file5.getItems().add(doc);
        file5.getItems().add(doc1);

                                                                                                                    //Creating menu bar
        MenuBar menu=new MenuBar();
        menu.getMenus().addAll(file1,file2,file3,file5,file4);

                                                                                                                             //layout
        layout =new BorderPane();


        VBox vBox=new VBox();
        HBox hBox=new HBox();
        Separator separator=new Separator();

                                                                                                                 // add imagebutton

        image.imagebutton(hBox);
        vBox.getChildren().addAll(menu,hBox,separator);


                                                                                                        // left side under construction

        Button chosefirstfile=new Button("Upload code");
        TextField textField=new TextField("");
        Button chosefiles=new Button("select files");
        Button compare=new Button("Compare");
        Label freespace=new Label("               ");
        Label freespace1=new Label("               ");
        Label freespace2=new Label("               ");
        Label freespace4=new Label("               ");
        Label freespace5=new Label("               ");


                                                                                                                    //filechosser
        FileChooser fileChooser=new FileChooser();
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("*.c","*.cpp","*.java","*.txt"));
        selectedfiles=new ListView<>();
       selectedfiles.getItems().addAll("                    Files");
        HBox hBox1=new HBox();
        hBox1.getChildren().addAll(freespace,chosefirstfile);
        HBox hBox2=new HBox();
        hBox2.getChildren().addAll(freespace1,chosefiles);
        HBox hBox3=new HBox();
        hBox3.getChildren().addAll(freespace2,compare);
        VBox vBox1=new VBox(20);
        vBox1.setPadding(new Insets(70,20,20,20));
        vBox1.getChildren().addAll(textField,hBox1,selectedfiles,hBox2,freespace4,freespace5,hBox3);
        layout.setLeft(vBox1);


        chosefirstfile.setOnAction(e->
        {
            code[0] = fileChooser.showOpenDialog(null);
             //code=code1;
            if(code[0] !=null)
            {
                textField.setText(code[0].getName());
            }
            else                                                                                                      // write the code
            {

            }

        });

                                                                                                            //selecting mutliple files
        chosefiles.setOnAction(e -> {
             selectedfiles1= fileChooser.showOpenMultipleDialog(null);
            if(selectedfiles1!=null) {
                for(int i=0;i<selectedfiles1.size();i++)
                selectedfiles.getItems().add(selectedfiles1.get(i).getName());
            }
            else
            {
                System.out.print("Select a file");
            }
        });




                                                                                                // left side construction completed

                                                                                                            //center under construction

        Separator separator1=new Separator();
        separator1.setOrientation(Orientation.VERTICAL);
        HBox hBoxforseparator =new HBox();
        hBoxforseparator.getChildren().addAll(separator1);
        //emptylinechart(hBoxforseparator);
        emptybarchart(hBoxforseparator);
        FlowPane flowPane=new FlowPane();
        //hBoxforseparator.getChildren().addAll(flowPane);
        layout.setCenter(hBoxforseparator);

        compare.setOnAction(e->                                                                                      //execute
        {
            try {
                count=0;
                count2=0;
                hBoxforseparator.getChildren().removeAll(VBOX);
              hBoxforseparator.getChildren().addAll(calculatesimilar(selectedfiles1,code[0]));
             //  CALCULATESIMILAR(selectedfiles1,code[0]);
               createpiechart(selectedfiles1,code[0]);

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        });

        layout.setTop(vBox);
        menu.getStyleClass().addAll("menu-bar");

                                                                                                                //scene and window
        Scene scene=new Scene(layout,1000,1000);
        scene.getStylesheets().add("menu.css");
        window.setTitle("CodeChecker");
        window.setScene(scene);
        window.show();

                                                                                                    //refection effect on separator
        Reflection shadow=new Reflection();
        separator.setEffect(shadow);
        separator1.setEffect(shadow);


    }
                                                                                                 // handle menu item events of File
    private void filenew()
    {

    }
    private void filesetting()
    {

    }
    private void changepassword()
    {

    }
    private void removepassword()
    {

    }
    private void fileScreenShot()
    {

    }
    private void fileexit()
    {

    }
    // handling menu of tools
    private void toolfind()
    {

    }
    private void toolchange()
    {

    }
    private void bar()
    {

    }
    private void line()
    {

    }
    private void pie()
    {

    }
    private void toolfonts1()
    {

    }
    private void toolfonts2()
    {

    }
    private void toolfonts3()
    {

    }
    private void toolfonts4()
    {

    }
    private void toolfonts5()
    {

    }
    private void toolfull()
    {

    }
                                                                                                             // handling menu of run
    private void runrun()
    {

    }
    private void runreset()
    {

    }
    private void runbackend()
    {

    }
                                                                                                             // handling menu of run
    private void algodoc()
    {

    }
    private void algodoc1()
    {

    }

                                                                                                             // creating empty chart
    private void emptylinechart(HBox hbox)
    {

        xAxis.setLabel("Words");


        lineChart.setTitle("Similarity Graph");

        XYChart.Series series = new XYChart.Series();
        series.setName("");
        lineChart.getData().addAll(series);
        lineChart.setAnimated(true);
        lineChart.setMaxHeight(700);
        lineChart.setMinWidth(700);
       // lineChart.setMaxSize(400,400);
       // lineChart.getStyleClass().addAll("linechart");
        hbox.getChildren().addAll(lineChart);

    }
    private void emptybarchart(HBox hBox)
    {
        bc.setTitle("Similarity");
        //xAxis1.setLabel("Files");
        yAxis.setLabel(" similarity Percentage ");
        XYChart.Series series1 = new XYChart.Series();
        //series1.setName("Files");
        bc.getData().addAll(series1);
        hBox.getChildren().addAll(bc);
        bc.setAnimated(true);
        bc.setMaxHeight(700);
        bc.setMinWidth(700);
       // bc.setLegendSide(Side.RIGHT);


    }

    private VBox calculatesimilar(List<File> list_of_file, File code) throws IOException {
        bc.getData().clear();
        //VBox VBOX=new VBox(20);
        VBOX.getChildren().removeAll(arrayList);
        arrayList=new ArrayList<>();
        VBOX.setPadding(new Insets(40,40,40,40));
        for ( int i = 0; i < list_of_file.size(); i++) {
             file = list_of_file.get(i);

            Button button = new Button(list_of_file.get(i).getName());
            button.setMinSize(10, 10);
            button.setOnAction(e -> {
                try {
                    CALCULATESIMILAR(file, code);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            });
            button.setMinSize(200, 15);
            arrayList.add(button);
            // VBOX.getChildren().addAll(button);
            //
            //
            //
            //new code
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    System.out.print("a");
                  File file1 = list_of_file.get(count++);
                    LinkedHashMap<String, Integer> ht = new LinkedHashMap<String, Integer>();
                    LinkedHashMap<String, Integer> ht1 = new LinkedHashMap<String, Integer>();
                    FileInputStream fin1 = null;

                    try {
                        fin1 = new FileInputStream(file1);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    FileInputStream fin2 = null;
                    try {
                        fin2 = new FileInputStream(code);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                    BufferedInputStream bin1 = new BufferedInputStream(fin1);
                    BufferedInputStream bin2 = new BufferedInputStream(fin2);
                    String a = "";
                    String b = "";
                    int ch;
                    try {
                        while ((ch = bin1.read()) != -1) {
                            a = a + (char) ch;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        while ((ch = bin2.read()) != -1) {
                            b = b + (char) ch;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        bin1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    try {
                        bin2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    StringTokenizer st = new StringTokenizer(a, " ");
                    StringTokenizer st1 = new StringTokenizer(b, " ");

                    str obj = new str();
                    obj.create_hash(ht, ht1, st, a);
                    obj.create_hash(ht1, ht, st1, b);
                    for (String key : ht.keySet()) {
                        Integer value = ht.get(key);
                      //  System.out.println("Key = " + key + ", Value = " + value);
                    }
                    System.out.println();
                    for (String key : ht1.keySet()) {
                        Integer value = ht1.get(key);
                      //  System.out.println("Key = " + key + ", Value = " + value);
                    }
                  ///  System.out.println();
                   /// System.out.println();
                    float l1 = 0;
                    float l2 = 0;
//
//
                    for (String key : ht.keySet()) {
                        float value = (float) ht.get(key);
                        l1 += value * value;
                    }
                    l1 = (float) Math.sqrt(l1);
                    ///System.out.println(l1);
//
//
//
                    for (String key : ht.keySet()) {
                        float value = (float) ht1.get(key);
                        l2 += value * value;
                    }
                    l2 = (float) Math.sqrt(l2);
                    ///System.out.println(l2);
//
//
//
                    float p = obj.check_per(ht, ht1, l1, l2);
                    int angle = (int) Math.toDegrees((Math.acos(p)));
                    //System.out.println("documents are at" + angle + " angle to each other");
                    //System.out.println("documents are at" + p * 100 + " similar to each other");
                    XYChart.Series series1 = new XYChart.Series();
                    series1.getData().addAll(new XYChart.Data("Files", (int) (p * 100)));
                   /// System.out.print((int) (p * 100));
                    series1.setName(file1.getName());
                    bc.getData().addAll(series1);
                    bc.setBarGap(3);
                }
            });
          /*  File file1 = list_of_file.get(i);
            LinkedHashMap<String, Integer> ht = new LinkedHashMap<String, Integer>();
            LinkedHashMap<String, Integer> ht1 = new LinkedHashMap<String, Integer>();
            String s;
            FileInputStream fin1 = null;

            try {
                fin1 = new FileInputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileInputStream fin2 = null;
            try {
                fin2 = new FileInputStream(code);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            BufferedInputStream bin1 = new BufferedInputStream(fin1);
            BufferedInputStream bin2 = new BufferedInputStream(fin2);
            String a = "";
            String b = "";
            int ch;
            while ((ch = bin1.read()) != -1) {
                a = a + (char) ch;
            }
            while ((ch = bin2.read()) != -1) {
                b = b + (char) ch;
            }
            bin1.close();
            bin2.close();
            StringTokenizer st = new StringTokenizer(a, " ");
            StringTokenizer st1 = new StringTokenizer(b, " ");

            str obj = new str();
            obj.create_hash(ht, ht1, st, a);
            obj.create_hash(ht1, ht, st1, b);
            for (String key : ht.keySet()) {
                Integer value = ht.get(key);
                System.out.println("Key = " + key + ", Value = " + value);
            }
            System.out.println();
            for (String key : ht1.keySet()) {
                Integer value = ht1.get(key);
                System.out.println("Key = " + key + ", Value = " + value);
            }
            System.out.println();
            System.out.println();
            float l1 = 0;
            float l2 = 0;
//
//
            for (String key : ht.keySet()) {
                float value = (float) ht.get(key);
                l1 += value * value;
            }
            l1 = (float) Math.sqrt(l1);
            System.out.println(l1);
//
//
//
            for (String key : ht.keySet()) {
                float value = (float) ht1.get(key);
                l2 += value * value;
            }
            l2 = (float) Math.sqrt(l2);
            System.out.println(l2);
//
//
//
            float p = obj.check_per(ht, ht1, l1, l2);
            int angle = (int) Math.toDegrees((Math.acos(p)));
            System.out.println("documents are at" + angle + " angle to each other");
            System.out.println("documents are at" + p * 100 + " similar to each other");
            XYChart.Series series1 = new XYChart.Series();
            series1.getData().addAll(new XYChart.Data("Files", (int) (p * 100)));
            System.out.print((int) (p * 100));
            series1.setName(list_of_file.get(i).getName());
            bc.getData().addAll(series1);
            bc.setBarGap(3);
            //setonAction for button

        }*/


        }
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                VBOX.getChildren().addAll(arrayList);
            }
        });

        return VBOX;
    }
        private void CALCULATESIMILAR(File file1,File code) throws IOException {
            lineChart.getData().clear();
            Stage windowforline = new Stage();
            StackPane stackPane = new StackPane();
            Scene scene = new Scene(stackPane, 1920, 1080);
            scene.getStylesheets().addAll("linechart.css");
            windowforline.setScene(scene);
            windowforline.show();
            stackPane.getChildren().addAll(lineChart);

            lineChart.getData().clear();
            XYChart.Series series1 = new XYChart.Series();
            XYChart.Series series2 = new XYChart.Series();
            //series1.getData().addAll(new XYChart.Data("Files", (int) (p * 100)));

            // bc.getStyleClass().addAll("barChart .label");
                series1.setName(code.getName());
            series2.setName(file1.getName());
               // File file1 = list_of_file.get(i);
                LinkedHashMap<String, Integer> ht = new LinkedHashMap<String, Integer>();
                LinkedHashMap<String, Integer> ht1 = new LinkedHashMap<String, Integer>();
                String s;
                FileInputStream fin1 = null;

                try {
                    fin1 = new FileInputStream(file1);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                FileInputStream fin2 = null;
                try {
                    fin2 = new FileInputStream(code);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

                BufferedInputStream bin1 = new BufferedInputStream(fin1);
                BufferedInputStream bin2 = new BufferedInputStream(fin2);
                String a = "";
                String b = "";
                int ch;
                while ((ch = bin1.read()) != -1) {
                    a = a + (char) ch;
                }
                while ((ch = bin2.read()) != -1) {
                    b = b + (char) ch;
                }
                bin1.close();
                bin2.close();
                StringTokenizer st = new StringTokenizer(a, " ");
                StringTokenizer st1 = new StringTokenizer(b, " ");

                str obj = new str();
                obj.create_hash(ht, ht1, st, a);
                obj.create_hash(ht1, ht, st1, b);
                for (String key : ht.keySet()) {
                    Integer value = ht.get(key);
                    series1.getData().addAll(new XYChart.Data(key, value));
                    // System.out.println("Key = " + key + ", Value = " + value);
                }
                System.out.println();
                for (String key : ht1.keySet()) {
                    Integer value = ht1.get(key);
                    series2.getData().addAll(new XYChart.Data(key, value));
                    // System.out.println("Key = " + key + ", Value = " + value);
                }
                System.out.println();
                System.out.println();
                float l1 = 0;
                float l2 = 0;
//
//
                for (String key : ht.keySet()) {
                    float value = (float) ht.get(key);
                    l1 += value * value;
                }
                l1 = (float) Math.sqrt(l1);
                System.out.println(l1);
//
//
//
                for (String key : ht.keySet()) {
                    float value = (float) ht1.get(key);
                    l2 += value * value;
                }
                l2 = (float) Math.sqrt(l2);
                System.out.println(l2);
//
//
//
                float p = obj.check_per(ht, ht1, l1, l2);
                int angle = (int) Math.toDegrees((Math.acos(p)));
                System.out.println("documents are at" + angle + " angle to each other");
                System.out.println("documents are at" + p * 100 + " similar to each other");
                lineChart.getData().addAll(series1, series2);
            lineChart.setOnZoom(new EventHandler<ZoomEvent>() {
                @Override public void handle(ZoomEvent event) {
                    lineChart.setScaleX(lineChart.getScaleX() * event.getZoomFactor());
                    lineChart.setScaleY(lineChart.getScaleY() * event.getZoomFactor());
                    event.consume();
                }
            });



            }
            private void createpiechart(List<File> list_of_file,File code) throws IOException {


                HBox hbox=new HBox();
                VBox layout1=new VBox(20);
                 arrayList.clear();
                layout1.getChildren().removeAll(chartArrayList);

               /* sc.valueProperty().addListener(new ChangeListener<Number>() {
                    public void changed(ObservableValue<? extends Number> ov,
                                        Number old_val, Number new_val) {
                      // layout1.setLayoutY(-new_val.doubleValue());
                        layout1.setPadding(new Insets(-new_val.doubleValue(),0,0,0));
                    }
                });*/
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < list_of_file.size(); i++) {
                            //layout1.getChildren().remove(sc);
                            chart.getData().clear();
                            File file1 = list_of_file.get(count2++);
                            LinkedHashMap<String, Integer> ht = new LinkedHashMap<String, Integer>();
                            LinkedHashMap<String, Integer> ht1 = new LinkedHashMap<String, Integer>();
                            String s;
                            FileInputStream fin1 = null;

                            try {
                                fin1 = new FileInputStream(file1);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            FileInputStream fin2 = null;
                            try {
                                fin2 = new FileInputStream(code);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }

                            BufferedInputStream bin1 = new BufferedInputStream(fin1);
                            BufferedInputStream bin2 = new BufferedInputStream(fin2);
                            String a = "";
                            String b = "";
                            int ch;
                            try {
                                while ((ch = bin1.read()) != -1) {
                                    a = a + (char) ch;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                while ((ch = bin2.read()) != -1) {
                                    b = b + (char) ch;
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            try {
                                bin1.close();
                                bin2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            StringTokenizer st = new StringTokenizer(a, " ");
                            StringTokenizer st1 = new StringTokenizer(b, " ");

                            str obj = new str();
                            obj.create_hash(ht, ht1, st, a);
                            obj.create_hash(ht1, ht, st1, b);
                            for (String key : ht.keySet()) {
                                Integer value = ht.get(key);
                                //series1.getData().addAll(new XYChart.Data(key, value));
                                // System.out.println("Key = " + key + ", Value = " + value);
                            }
                            System.out.println();
                            for (String key : ht1.keySet()) {
                                Integer value = ht1.get(key);
                                // series2.getData().addAll(new XYChart.Data(key, value));
                                // System.out.println("Key = " + key + ", Value = " + value);
                            }
                          //  System.out.println();
                           // System.out.println();
                            float l1 = 0;
                            float l2 = 0;
//
//
                            for (String key : ht.keySet()) {
                                float value = (float) ht.get(key);
                                l1 += value * value;
                            }
                            l1 = (float) Math.sqrt(l1);
                            //System.out.println(l1);
//
//
//
                            for (String key : ht.keySet()) {
                                float value = (float) ht1.get(key);
                                l2 += value * value;
                            }
                            l2 = (float) Math.sqrt(l2);
                          //  System.out.println(l2);
//
//
//
                            float p = obj.check_per(ht, ht1, l1, l2);
                            int angle = (int) Math.toDegrees((Math.acos(p)));
                            ObservableList<PieChart.Data> pieChartData =
                                    FXCollections.observableArrayList(
                                            new PieChart.Data("Similar", (int) (p * 100)),
                                            new PieChart.Data("Different", 100 - (int) (p * 100)));
                            PieChart chart = new PieChart(pieChartData);
                            chart.setTitle(file1.getName());
                            chart.setMinSize(300, 300);
                            chart.setMaxSize(350, 350);
                            chartArrayList.add(chart);
                           // layout1.getChildren().addAll(chart);
                        }

                    }
                });
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        layout1.getChildren().addAll(chartArrayList);
                        hbox.getChildren().addAll(layout1);
                        System.out.println("a");
                     //   layout.setRight(hbox);

                    }
                });

   /*//     for (int i = 0; i < list_of_file.size(); i++) {
            //layout1.getChildren().remove(sc);
            chart.getData().clear();
            File file1 = list_of_file.get(i);
            LinkedHashMap<String, Integer> ht = new LinkedHashMap<String, Integer>();
            LinkedHashMap<String, Integer> ht1 = new LinkedHashMap<String, Integer>();
            String s;
            FileInputStream fin1 = null;

            try {
                fin1 = new FileInputStream(file1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            FileInputStream fin2 = null;
            try {
                fin2 = new FileInputStream(code);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            BufferedInputStream bin1 = new BufferedInputStream(fin1);
            BufferedInputStream bin2 = new BufferedInputStream(fin2);
            String a = "";
            String b = "";
            int ch;
            while ((ch = bin1.read()) != -1) {
                a = a + (char) ch;
            }
            while ((ch = bin2.read()) != -1) {
                b = b + (char) ch;
            }
            bin1.close();
            bin2.close();
            StringTokenizer st = new StringTokenizer(a, " ");
            StringTokenizer st1 = new StringTokenizer(b, " ");

            str obj = new str();
            obj.create_hash(ht, ht1, st, a);
            obj.create_hash(ht1, ht, st1, b);
            for (String key : ht.keySet()) {
                Integer value = ht.get(key);
                //series1.getData().addAll(new XYChart.Data(key, value));
                // System.out.println("Key = " + key + ", Value = " + value);
            }
            System.out.println();
            for (String key : ht1.keySet()) {
                Integer value = ht1.get(key);
               // series2.getData().addAll(new XYChart.Data(key, value));
                // System.out.println("Key = " + key + ", Value = " + value);
            }
            System.out.println();
            System.out.println();
            float l1 = 0;
            float l2 = 0;
//
//
            for (String key : ht.keySet()) {
                float value = (float) ht.get(key);
                l1 += value * value;
            }
            l1 = (float) Math.sqrt(l1);
            System.out.println(l1);
//
//
//
            for (String key : ht.keySet()) {
                float value = (float) ht1.get(key);
                l2 += value * value;
            }
            l2 = (float) Math.sqrt(l2);
            System.out.println(l2);
//
//
//
            float p = obj.check_per(ht, ht1, l1, l2);
            int angle = (int) Math.toDegrees((Math.acos(p)));
            ObservableList<PieChart.Data> pieChartData =
                    FXCollections.observableArrayList(
                            new PieChart.Data("Similar", (int)(p*100)),
                            new PieChart.Data("Different",100-(int)(p*100) ));
            PieChart chart = new PieChart(pieChartData);
            chart.setTitle(selectedfiles1.get(i).getName());
           chart.setMinSize(300,300);
            chart.setMaxSize(350,350);
            layout1.getChildren().addAll(chart);

        }*/
                layout1.setOnScroll(new EventHandler<ScrollEvent>() {
                    @Override public void handle(ScrollEvent event) {
                        if (!event.isInertia()) {
                            layout1.setTranslateX(layout1.getTranslateX() + event.getDeltaX());
                            layout1.setTranslateY(layout1.getTranslateY() + event.getDeltaY());
                        }
                        event.consume();
                    }
                });
    }
    }





