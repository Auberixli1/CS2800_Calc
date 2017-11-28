package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Controller {
    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.addCalcLisener(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                view.setAns(model.getAns());
            }
        });
    }
}
