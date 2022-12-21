module com.example.supplychainvivek17thdec {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.supplychainvivek17thdec to javafx.fxml;
    exports com.example.supplychainvivek17thdec;
}