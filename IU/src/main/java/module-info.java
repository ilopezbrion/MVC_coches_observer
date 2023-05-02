module com.castelao.mvc.iu {
    requires javafx.controls;
    requires javafx.fxml;
            
    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
                        
    opens com.castelao.mvc.iu to javafx.fxml;
    exports com.castelao.mvc.iu;
}

