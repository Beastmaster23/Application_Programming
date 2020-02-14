package application;
	
import application.controller.SongsSearchController;
import application.model.RecordLabel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader=new FXMLLoader();
			String bandsPath=getClass().getResource("/resources/data/members.csv").getPath(), recordsPath=getClass().getResource("/resources/data/records.csv").getPath();
			RecordLabel label=RecordLabel.createRecordLabel("Interco Records", bandsPath, recordsPath);	
			SongsSearchController controller=new SongsSearchController(label);
			
			loader.setController(controller);
			loader.setLocation(getClass().getResource("/application/view/SearchSongsView.fxml"));			
			BorderPane root = loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle(label.getName()+" Manager");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
