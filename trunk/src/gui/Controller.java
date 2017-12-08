package gui;

/**
 * This class controls the UIs. It communicates between the model and the views.
 * This code is adapted from code suppplied by Dave Cohen.
 *
 * @author Marcus Messer
 */
public class Controller {

  /**
   * This field stores the model of the calculator.
   */
  private Model model;
  /**
   * This field stores the current view of the application, either ASCII or GUI.
   */
  private View view;

  /**
   * This constructor creates the listener for the button.
   *
   * @param model The current model of the system.
   * @param view The current view.
   */
  Controller(Model model, View view) {
    this.model = model;
    this.view = view;

    // This lambda function creates an ActionEvent to set the answer of the view to the answer from
    // the model.
    view.addCalcListener(actionEvent -> view.setAns(model.getAns()));
  }
}
