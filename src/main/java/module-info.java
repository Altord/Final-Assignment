module com.example.finalassignmentadvanceddb {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.swing;
    requires java.sql;
    requires com.oracle.database.jdbc;
    requires java.sql.rowset;

    opens com.example.finalassignmentadvanceddb to javafx.fxml;
    exports com.example.finalassignmentadvanceddb;
}