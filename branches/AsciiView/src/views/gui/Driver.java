package views.gui;

/**
 * This class is what drives the program, it is responsible for getting the model and the view.
 * Code adapted from code supplied by Dave Cohen.
 *
 * @author Marcus Messer
 */
public class Driver {

  /**
   * The entry point for the application.
   * @param args The starting arguments supplied on start.
   */
  public static void main(String[] args) {
    Model model = new Model();
    GUIView guiView = views.gui.GUIView.getInstance();
    new Controller(model, guiView);
  }
}
