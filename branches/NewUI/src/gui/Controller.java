package gui;

public class Controller {

  private Model model;
  private View view;

  Controller(Model model, View view) {
    this.model = model;
    this.view = view;

    view.addCalcListener(actionEvent -> view.setAns(model.getAns()));
  }
}
