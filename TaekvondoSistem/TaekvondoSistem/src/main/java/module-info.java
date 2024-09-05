module com.example.taekvondosistem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.taekvondosistem to javafx.fxml;
    exports com.example.taekvondosistem;
}