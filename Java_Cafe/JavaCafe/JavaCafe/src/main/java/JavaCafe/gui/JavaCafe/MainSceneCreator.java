package JavaCafe.gui.JavaCafe;

import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

import java.util.Set;

import javafx.event.EventHandler;

public class MainSceneCreator extends SceneCreator implements EventHandler<MouseEvent>
{
	//FlowPane:
	FlowPane rootFlowPane;
	//Buttons:
	Button ManageWindBtn, SearchWindBtn;
	
	public MainSceneCreator(double width, double height)
	{
		super(width, height);
		
		//Create and set buttons:
		rootFlowPane = new FlowPane();
		ManageWindBtn = new Button("Διαχείριση Παραγγελιών");
		SearchWindBtn = new Button("Αναζήτηση Παραγγελιών");
			//Assign event Handler to buttons:
		ManageWindBtn.setOnMouseClicked(this);
		SearchWindBtn.setOnMouseClicked(this);
			//Position flowpane and add buttons:
		rootFlowPane.setHgap(10);
		rootFlowPane.setAlignment(Pos.CENTER);
		rootFlowPane.getChildren().addAll(ManageWindBtn, SearchWindBtn);
	}
	
	@Override
	public void handle(MouseEvent event) 
	{
		if (event.getSource() == ManageWindBtn)
		{
			//Set orders Management Window:
			App.primaryStage.setTitle("Διαχείριση Παραγγελιών");
			App.primaryStage.setScene(App.manageScene);
			
		} else if (event.getSource() == SearchWindBtn)
		{
			//Set orders Searching Window:
			App.primaryStage.setTitle("Αμαζήτηση Παραγγελιών");
			App.primaryStage.setScene(App.searchScene);
		}
	}
	
	@Override
	Scene createScene() { return new Scene(rootFlowPane, 800, 650);}
}
