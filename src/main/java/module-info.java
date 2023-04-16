module com.example.pract1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.pract1 to javafx.fxml;
    exports com.example.pract1;
}