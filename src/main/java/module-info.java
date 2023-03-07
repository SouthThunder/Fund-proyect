module com.example.proyect {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.proyect to javafx.fxml;
    exports com.example.proyect;
}