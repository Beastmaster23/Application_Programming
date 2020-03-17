package application.viewModels;

import java.io.IOException;
import java.util.HashMap;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


/**
 * Controls the app by only one scene.
 * @author Interco
 *
 */
public abstract class SceneController {	
	private Level current;
	private HashMap<String, Level> scenes;
	public SceneController() {
		scenes=new HashMap<String, Level>();
	}
	
	public void addLevel(Level level){
		if(isValidKey(level.getName()))
		scenes.put(level.getName(), level);
	}
	
	public abstract void changeScene(String name) ;
	
	public boolean isValidKey(String name) {
		return !scenes.containsKey(name);
	}
	public Level getCurrent() {
		return current;
	}
	public void setCurrent(Level level) {
		current=level;
	}
	public HashMap<String, Level> getScenes() {
		return scenes;
	}
}
