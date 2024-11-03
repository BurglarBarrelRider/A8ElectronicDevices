module org.example.a7electronicdevices {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.a7electronicdevices to javafx.fxml;
    exports org.example.a7electronicdevices;
}