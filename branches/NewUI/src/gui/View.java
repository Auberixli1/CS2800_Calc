package gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class View extends Application {

    @FXML
    public Button btnCalc;
    @FXML
    public Label lblAns;
    @FXML
    public TextField txtExpr;

    private volatile static View instance = null;

    @FXML
    void initialize(){
        instance = this;
    }

    public synchronized static View getInstance(){
        if (instance == null){
            new Thread(() -> Application.launch(View.class)).start();
        }

        while (instance == null){}
        return instance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }

    public void setAns(String ans) {
        lblAns.setText("Answer: " + ans);
    }

    public void addCalcLisener(EventHandler<ActionEvent> eventHandler) {
        btnCalc.setOnAction(eventHandler);
    }
}
