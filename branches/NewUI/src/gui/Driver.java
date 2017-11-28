package gui;

public class Driver {

  public static void main(String[] args) {
    Model model = new Model();
    View view = View.getInstance();
    new Controller(model, view);
  }
}
