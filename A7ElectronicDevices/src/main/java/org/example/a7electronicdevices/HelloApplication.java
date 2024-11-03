package org.example.a7electronicdevices;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private ObservableList<Device> devices = FXCollections.observableArrayList();
    private ListView<Device> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) {
        TabPane tabPane = new TabPane();

        Tab smartphoneTab = createSmartphoneTab();
        Tab laptopTab = createLaptopTab();
        Tab tabletTab = createTabletTab();

        tabPane.getTabs().addAll(smartphoneTab, laptopTab, tabletTab);

        listView.setItems(devices);

        VBox layout = new VBox(10, tabPane, listView, createRemoveButton());
        Scene scene = new Scene(layout, 600, 400);

        primaryStage.setTitle("Device Manager");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Tab createSmartphoneTab() {
        VBox vbox = new VBox(10);
        TextField nameField = new TextField();
        TextField priceField = new TextField();
        TextField weightField = new TextField();

        vbox.getChildren().addAll(
                new Label("Smartphone Name:"), nameField,
                new Label("Price:"), priceField,
                new Label("Weight:"), weightField,
                createAddButton("Smartphone", nameField, priceField, weightField)
        );

        return new Tab("Smartphone", vbox);
    }

    private Tab createLaptopTab() {
        VBox vbox = new VBox(10);
        TextField nameField = new TextField();
        TextField priceField = new TextField();
        TextField weightField = new TextField();

        vbox.getChildren().addAll(
                new Label("Laptop Name:"), nameField,
                new Label("Price:"), priceField,
                new Label("Weight:"), weightField,
                createAddButton("Laptop", nameField, priceField, weightField)
        );

        return new Tab("Laptop", vbox);
    }

    private Tab createTabletTab() {
        VBox vbox = new VBox(10);
        TextField nameField = new TextField();
        TextField priceField = new TextField();
        TextField weightField = new TextField();

        vbox.getChildren().addAll(
                new Label("Tablet Name:"), nameField,
                new Label("Price:"), priceField,
                new Label("Weight:"), weightField,
                createAddButton("Tablet", nameField, priceField, weightField)
        );

        return new Tab("Tablet", vbox);
    }

    private Button createAddButton(String type, TextField nameField, TextField priceField, TextField weightField) {
        Button addButton = new Button("Add " + type);
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            double weight = Double.parseDouble(weightField.getText());

            Device device = new Device(DeviceType.valueOf(type.toUpperCase()), name, price, weight) {};
            devices.add(device);

            nameField.clear();
            priceField.clear();
            weightField.clear();
        });
        return addButton;
    }

    private Button createRemoveButton() {
        Button removeButton = new Button("Remove");
        removeButton.setOnAction(e -> {
            Device selectedDevice = listView.getSelectionModel().getSelectedItem();
            if (selectedDevice != null) {
                devices.remove(selectedDevice);
            }
        });
        return removeButton;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
