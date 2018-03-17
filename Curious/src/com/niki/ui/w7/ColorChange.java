package com.niki.ui.w7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.scene.layout.Pane;

public class ColorChange extends Application{

	@Override
	public void start(Stage stage) throws Exception {
//write a program that displays the background color of a panel as black when the mouse is pressed
		//and as white the mouse is released
		
		Pane pane = new Pane();
		Circle circle = new Circle(125,100,50);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.ALICEBLUE);
		pane.getChildren().add(circle);
		circle.setOnMousePressed(e -> circle.setFill(Color.BLACK));
		circle.setOnMouseReleased(e -> circle.setFill(Color.WHITE));
		stage.setTitle("HandleEvent");
		Scene scene = new Scene(pane,250,200);
		stage.setScene(scene);
		stage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
