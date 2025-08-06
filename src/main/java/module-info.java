module matteomaspero.carrental {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;

	requires org.controlsfx.controls;
	requires com.dlsc.formsfx;
	requires net.synedra.validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires org.kordamp.bootstrapfx.core;
	requires eu.hansolo.tilesfx;

	opens matteomaspero.carrental to javafx.fxml;
	exports matteomaspero.carrental;
	exports matteomaspero.carrental.controller;
	opens matteomaspero.carrental.controller to javafx.fxml;
}