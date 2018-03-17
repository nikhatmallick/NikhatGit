package com.niki.ui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javafx.application.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;

public class Try1 extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage pStage) throws Exception {
		pStage.setTitle("Homework Week 6 JavaFx");
		FlowPane rootNode = new FlowPane();
		
		rootNode.setAlignment(Pos.TOP_CENTER);
		Scene myScene = new Scene(rootNode, 400, 100);
		pStage.setScene(myScene);
		Random r = new Random();
		int rn = 0;
		String imageName;
		ArrayList<String> iList = new ArrayList<String>();		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
        for (int i=1; i<6; i++) {
            list.add(new Integer(i));
        }
        Collections.shuffle(list);
        for (int i=0; i<3; i++) {
            System.out.println(list.get(i));
            rn = list.get(i);
            imageName = "cimage" + rn + ".png";
			iList.add(imageName);
        }
		System.out.println("com/niki/ui/" + iList.get(0));
		System.out.println("com/niki/ui/" + iList.get(1));
		System.out.println("com/niki/ui/" + iList.get(2));
	
		ImageView cardImageIV1 = new ImageView(new Image("com/niki/ui/" + iList.get(0)));
		ImageView cardImageIV2 = new ImageView(new Image("com/niki/ui/" + iList.get(1)));
		ImageView cardImageIV3 = new ImageView(new Image("com/niki/ui/" + iList.get(2)));
		cardImageIV1.setFitHeight(100);
		cardImageIV1.setFitWidth(100);
		cardImageIV2.setFitHeight(100);
		cardImageIV2.setFitWidth(100);
		cardImageIV3.setFitHeight(100);
		cardImageIV3.setFitWidth(100);
		

		rootNode.getChildren().addAll(cardImageIV1,cardImageIV2,cardImageIV3);
		pStage.show();

	}

}
