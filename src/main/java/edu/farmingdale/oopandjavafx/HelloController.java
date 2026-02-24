package edu.farmingdale.oopandjavafx;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

public class HelloController {
    // Table
    @FXML
    private TableView<Person> tableView;
    @FXML
    private TableColumn<Person, Integer> idColumn;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;
    @FXML
    private TableColumn<Person, String> departmentColumn;
    @FXML
    private TableColumn<Person, String> majorColumn;
    @FXML
    private TableColumn<Person, String> emailColumn;

    // Text Field
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField departmentField;
    @FXML
    private TextField majorField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField imageUrlField;
    private ObservableList<Person> people = FXCollections.observableArrayList();
    private int currentId = 1;

    @FXML
    private ImageView profileImage;

    // Initialize
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<>("department"));
        majorColumn.setCellValueFactory(new PropertyValueFactory<>("major"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        tableView.setItems(people);

        // Load selected row into text fields
        tableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                firstNameField.setText(newSelection.getFirstName());
                lastNameField.setText(newSelection.getLastName());
                departmentField.setText(newSelection.getDepartment());
                majorField.setText(newSelection.getMajor());
                emailField.setText(newSelection.getEmail());
                imageUrlField.setText(newSelection.getImageUrl());
                // Update profile image
                try {
                    Image image = new Image(newSelection.getImageUrl(), true);
                    profileImage.setImage(image);
                } catch (Exception e) {
                    profileImage.setImage(null);
                }
            }});
    }

    // Exit
    @FXML
    private void handleExit() {
        Platform.exit();
    }

    // Add
    @FXML
    private void handleAdd() {
        Person person = new Person(currentId++, firstNameField.getText(), lastNameField.getText(), departmentField.getText(), majorField.getText(),
                emailField.getText(), imageUrlField.getText());
        people.add(person);
        clearFields();
    }

    // Delete
    @FXML
    private void handleDelete() {
        Person selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            people.remove(selected);
        }
    }

    // Clear
    @FXML
    private void handleClear() {
        clearFields();
        tableView.getSelectionModel().clearSelection();
    }

    // Edit
    @FXML
    private void handleEdit() {
        Person selected = tableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            selected.setFirstName(firstNameField.getText());
            selected.setLastName(lastNameField.getText());
            selected.setDepartment(departmentField.getText());
            selected.setMajor(majorField.getText());
            selected.setEmail(emailField.getText());
            selected.setImageUrl(imageUrlField.getText());
            tableView.refresh();
        }
    }

    // Helper
    private void clearFields() {
        firstNameField.clear();
        lastNameField.clear();
        departmentField.clear();
        majorField.clear();
        emailField.clear();
        imageUrlField.clear();
        profileImage.setImage(null); // reset image on clear
    }
}