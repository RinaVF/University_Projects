module JavaCafe.gui.JavaCafe {
    requires javafx.controls;
	requires java.desktop;
	
    exports JavaCafe.gui.JavaCafe;
    opens Classes to javafx.base;
}
