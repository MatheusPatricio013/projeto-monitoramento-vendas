module com.example.projeto_alpha {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.projeto_alpha to javafx.fxml;
    exports com.example.projeto_alpha;
}