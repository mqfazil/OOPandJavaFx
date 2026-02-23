module edu.farmingdale.oopandjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.farmingdale.oopandjavafx to javafx.fxml;
    exports edu.farmingdale.oopandjavafx;
}