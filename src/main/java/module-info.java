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

	exports com.github.matteomaspero.carrental;
	exports com.github.matteomaspero.carrental.controller;
	exports com.github.matteomaspero.carrental.model;

	opens com.github.matteomaspero.carrental to javafx.fxml;
	opens com.github.matteomaspero.carrental.controller to javafx.fxml;
	opens com.github.matteomaspero.carrental.model to javafx.fxml;
}