package application;

import java.io.IOException;

import application.controllers.MainAppController;
import application.controllers.ManageStageController;
import application.controllers.StageController;
import application.controllers.StageSelectionController;
import application.models.Festival;
import application.viewModels.BorderPaneController;
import application.viewModels.Level;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			StageController controller = StageController.getInstance(primaryStage);
			Level level = new Level.Builder().setName("Main").setPath("/application/views/MainApp.fxml")
					.setController(new MainAppController()).build();
			controller.addLevel("Main", level);

			controller.changeScene("Main");

			controller.getCurrent().getController().init();

			controller.getScene().getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(controller.getScene());
			primaryStage.setTitle("Festival manager");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void stop() {
		if(!Festival.getAutoSave())return;
		BorderPaneController bpc=(BorderPaneController) ((MainAppController) StageController.getInstance().getScenes().get("Main").getController()).getController();
		ManageStageController msc=(ManageStageController)bpc.getScenes().get("ManageStage").getController();
		System.out.println(msc.getFestival());
		try {
			msc.getFestival().saveBands("resources/stage_bands.csv");
			msc.getFestival().saveStages("resources/festival.csv");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return;
		}
		
		
	}
}
