package JavaCafe.gui.JavaCafe;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class App extends Application {
	 static Stage primaryStage;
	 static Scene mainScene, manageScene, searchScene;
    
	@Override
    public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		//Create Main Scene:
		SceneCreator MainSceneCreator = new MainSceneCreator(800, 650);
		mainScene = MainSceneCreator.createScene();
		primaryStage.setTitle("Java Cafe");
        primaryStage.setScene(mainScene);
        primaryStage.show();
        
        //Create Orders Management Window:
        SceneCreator ManageSceneCreator = new ManageSceneCreator(800, 650);
        manageScene = ManageSceneCreator.createScene();
        
        //Create Orders Searching Window:
        SceneCreator SearchSceneCreator = new SearchSceneCreator(800, 650);
        searchScene = SearchSceneCreator.createScene();
    }

    public static void main(String[] args) {
        launch();
    }
}