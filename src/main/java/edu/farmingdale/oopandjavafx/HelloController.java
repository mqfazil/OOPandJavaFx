package edu.farmingdale.oopandjavafx;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TableView<Person> tableView;
    @FXML private TableColumn<Person, String> firstNameCol;
    @FXML private TableColumn<Person, String> lastNameCol;
    @FXML private TableColumn<Person, Integer> ageCol;
    private final ObservableList<Person> data =
            FXCollections.observableArrayList(new Person("John", "Doe", 30),new Person("Jane", "Smith", 25));

    @FXML
    public void initialize() {
        firstNameCol.setCellValueFactory(cell ->
                cell.getValue().firstNameProperty());

        lastNameCol.setCellValueFactory(cell ->
                cell.getValue().lastNameProperty());

        ageCol.setCellValueFactory(cell ->
                cell.getValue().ageProperty().asObject());
        tableView.setItems(data);
    }

    @FXML
    private void handleNew() {
    }
    @FXML
    private void handleDelete() {
    }
    @FXML
    private void handleExit() {
    }
}