module com.example.salonprojekt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.salonprojekt to javafx.fxml;
    exports com.example.salonprojekt;
}