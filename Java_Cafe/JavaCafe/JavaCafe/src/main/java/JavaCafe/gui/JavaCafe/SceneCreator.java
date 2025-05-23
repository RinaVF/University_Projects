package JavaCafe.gui.JavaCafe;

import javafx.scene.Scene;

public abstract class SceneCreator
{
	double width;
	double height;
	
	SceneCreator(double width, double height)
	{
		this.width = width;
		this.height = height;
	}
	
	abstract Scene createScene();
}
