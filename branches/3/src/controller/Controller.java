package controller;

import calc.CalcModel;
import views.OperationType;
import views.gui.GuiView;

/**
 * This class controls the UIs. It communicates between the model and the views.
 * This code is adapted from code supplied by Dave Cohen.
 *
 * @author Marcus Messer
 */
public class Controller {

  private OperationType opType = null;
  /**
   * This field stores the model of the calculator.
   */
  private CalcModel model;
  /**
   * This field stores the current guiView of the application, either ASCII or GUI.
   */
  private GuiView guiView;

  /**
   * This constructor creates the listener for the button.
   *
   * @param model The current model of the system.
   * @param guiView The current guiView.
   */
  Controller(CalcModel model, GuiView guiView) {
    this.model = model;
    this.guiView = guiView;

    // This lambda function creates an ActionEvent to set the answer of the guiView to the answer
    // from the model.
    guiView.addCalcListener(actionEvent -> guiView.setAnswer(calculate()));
    guiView.addTypeObserver(actionEvent -> guiView.setType());
  }

  /**
   * Communicates between the model and the views.
   *
   * @return The answer.
   */
  private String calculate() {
    float answer;

    opType = guiView.getType();
    if (opType == OperationType.INFIX) {
      answer = model.evaluate(guiView.getExpression(), true);
    } else {
      answer = model.evaluate(guiView.getExpression(), false);
    }
    return String.valueOf(answer);
  }
}
