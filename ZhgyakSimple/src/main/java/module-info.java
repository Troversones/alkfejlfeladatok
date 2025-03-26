module hu.alkfejl {
    requires javafx.controls;

    opens hu.alkfejl.model to javafx.base;

    exports hu.alkfejl;
}
