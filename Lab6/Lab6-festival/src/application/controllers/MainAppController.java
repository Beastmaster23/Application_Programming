package application.controllers;

import application.viewModels.BorderPaneController;
import application.viewModels.Level;
import application.viewModels.SceneController;

public class MainAppController extends ViewController {

	private SceneController controller;
	
	public MainAppController() {
		controller=new BorderPaneController();
		Level level=new Level.Builder()
				.setName("StageSelection")
				.setPath("/application/views/StageSelection.fxml")
				.setController(new StageSelectionController())
				.build();
		
		controller.addLevel(level);
		level=new Level.Builder()
				.setName("ManageStage")
				.setPath("/application/views/ManageStage.fxml")
				.setController(new ManageStageController())
				.build();
		controller.addLevel(level);
	}

	@Override
	public void init(Object... args) {
		// TODO Auto-generated method stub
		controller.changeScene("StageSelection");
		
		controller.getCurrent().getController().init(controller);
	}

	public SceneController getController() {
		return controller;
	}

	public void setController(SceneController controller) {
		this.controller = controller;
	}

}
