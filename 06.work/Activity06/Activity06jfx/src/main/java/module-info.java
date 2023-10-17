module br.ufc.activity.activity06 {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;

    opens br.ufc.activity.activity06 to javafx.fxml;
    exports br.ufc.activity.activity06;
}