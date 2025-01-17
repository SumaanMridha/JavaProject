module com.example.javaprojectfxml {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens com.example.javaprojectfxml to javafx.fxml;
    exports com.example.javaprojectfxml;
}