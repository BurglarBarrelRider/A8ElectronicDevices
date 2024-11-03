package org.example.a7electronicdevices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;

public class HelloController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField additionalField;
    @FXML
    private ComboBox<DeviceType> deviceTypeComboBox;
    @FXML
    private ListView<Device> listView;

    private ObservableList<Device> devices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(devices);
        deviceTypeComboBox.getItems().addAll(DeviceType.values());
    }

    @FXML
    protected void onAddButtonClicked() {
        String name = nameField.getText();
        double price;
        double weight;

        try {
            price = Double.parseDouble(priceField.getText());
            weight = Double.parseDouble(weightField.getText());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        DeviceType type = deviceTypeComboBox.getValue();
        if (type == null) {
            System.out.println("ErR0r+!*&|;  select a device type.");
            return;
        }

        switch (type) {
            case SMARTPHONE:
                double screenSize = Double.parseDouble(additionalField.getText());
                double cameraResolution = 12.0;
                devices.add(new Smartphone(name, price, weight, screenSize, cameraResolution));
                break;
            case LAPTOP:
                int ramSize = Integer.parseInt(additionalField.getText());
                String processorType = "Intel i5";
                devices.add(new Laptop(name, price, weight, ramSize, processorType));
                break;
            case TABLET:
                double batteryLife = Double.parseDouble(additionalField.getText());
                boolean hasStylus = true;
                devices.add(new Tablet(name, price, weight, batteryLife, hasStylus));
                break;
        }

        clearFields();
    }

    @FXML
    protected void onDeleteButtonClicked() {
        Device selectedDevice = listView.getSelectionModel().getSelectedItem();
        if (selectedDevice != null) {
            devices.remove(selectedDevice);
        } else {
            System.out.println("No device selected for deletion.");
        }
    }

    private void clearFields() {
        nameField.clear();
        priceField.clear();
        weightField.clear();
        additionalField.clear();
        deviceTypeComboBox.getSelectionModel().clearSelection();
    }
}
