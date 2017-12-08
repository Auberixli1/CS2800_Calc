package views.gui;

/**
 * This class controls the UIs. It communicates between the model and the views.
 * This code is adapted from code supplied by Dave Cohen.
 *
 * @author Marcus Messer
 */
public class Controller {

  /**
   * This field stores the model of the calculator.
   */
  private Model model;
  /**
   * This field stores the current GUIView of the application, either ASCII or GUI.
   */
  private GUIView GUIView;

  /**
   * This constructor creates the listener for the button.
   * @param model The current model of the system.
   * @param GUIView The current GUIView.
   */
  Controller(Model model, GUIView GUIView) {
    this.model = model;
    this.GUIView = GUIView;

    // This lambda function creates an ActionEvent to set the answer of the GUIView to the answer from
    // the model.
    GUIView.addCalcListener(actionEvent -> GUIView.setAnswer(model.getAns()));
  }
}
