package application.viewModels;

import java.io.IOException;

import application.controllers.StageController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class BorderPaneController extends SceneController {

	public BorderPaneController() {
	}

	@Override
	public void changeScene(String name) {
		// TODO Auto-generated method stub
		FXMLLoader loader=new FXMLLoader();
		loader.setController(getScenes().get(name).getController());
		loader.setLocation(getClass().getResource(getScenes().get(name).getPath()));
		setCurrent(getScenes().get(name));
		try {
			((BorderPane)StageController.getInstance().getScene().getRoot()).setCenter(loader.load());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
