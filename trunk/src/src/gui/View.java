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

/**
 * This class is the view for the GUI, it is what starts and sets up the GUI.
 * This code has been adapted from code supplied by Dave Cohen.
 *
 * @author Marcus Messer
 */

public class View extends Application {

  /**
   * This field stores the instance of this class, as this class is a singleton.
   */
  private volatile static View instance = null;
  /**
   * This field is for the calculate button, which is derived from the FXML.
   */
  @FXML
  public Button btnCalc;
  /**
   * This field is for the answer label, which is derived from the FXML.
   */
  @FXML
  public Label lblAns;
  /**
   * This field is for the TextField the user inputs there expression.
   */
  @FXML
  public TextField txtExpr;

  /**
   * This method gets the instance for this class, if it is null it creates a new thread and starts
   * the GUI.
   * @return The instance of this class.
   */
  public synchronized static View getInstance() {
    if (instance == null) {
      // Lambda expression creates new thread and launches the GUI.
      new Thread(() -> Application.launch(View.class)).start();
    }

    // Loops until JavaFX initializes.
    while (instance == null) {
      System.out.println("Waiting to be initialized.");
    }
    return instance;
  }

  /**
   * The method initializes the instance to this class, once it's called by JavaFX.
   */
  @FXML
  void initialize() {
    instance = this;
  }

  /**
   * This method creates and shows the GUI.
   * @param primaryStage Is the top-level container for the JavaFX content.
   * @throws Exception Is thrown if an IO exception occurs in FXMLLoader.load.
   */
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("gui.fxml"));
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(new Scene(root, 300, 275));
    primaryStage.show();
  }

  /**
   * This setter sets the answer label to what the calculation returns.
   * @param ans Is the answer to the calculation entered by the user.
   */
  public void setAns(String ans) {
    lblAns.setText("Answer: " + ans);
  }

  /**
   * This method adds the calculate listener method to the button, so when the button is clicked the
   * answer will be calculated and updated.
   * @param eventHandler Is the listener method in <code>Controller</code>.
   */
  public void addCalcListener(EventHandler<ActionEvent> eventHandler) {
    btnCalc.setOnAction(eventHandler);
  }
}
