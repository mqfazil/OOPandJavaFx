package edu.farmingdale.oopandjavafx;

import javafx.fxml.FXML;

public class HelloController {

    @FXML
    private void handleNew() {
        System.out.println("New clicked");
    }

    @FXML
    private void handleDelete() {
        System.out.println("Delete clicked");
    }

    @FXML
    private void handleExit() {
        System.exit(0);
    }
}