package application.controllers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import application.models.Festival;
import application.models.FestivalStage;
import application.viewModels.SceneController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StageSelectionController extends ViewController {
	@FXML
	private Button buttonFour;

	@FXML
	private Button buttonSix;

	@FXML
	private Button buttonOne;

	@FXML
	private Label festivalId;

	@FXML
	private ImageView festivalIcon;

	@FXML
	private Button buttonTwo;

	@FXML
	private Button buttonFive;

	@FXML
	private Button buttonThree;
	
	@FXML
    void goToStage(ActionEvent event) {
		controller.changeScene("ManageStage");
		controller.getCurrent().getController().init(controller, festival, ((Button)event.getSource()).getText());
    }
	private Festival festival;
	
	private SceneController controller;
	
	public StageSelectionController() {
		try {
			festival=Festival.loadFestival("resources/festival.csv");
			festival.loadFestivalStages("resources/stage_bands.csv");
			//System.out.println(festival);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void loadButtons() {
		FestivalStage[] arr=new FestivalStage[festival.getStages().size()];
		festival.getStages().toArray(arr);
		buttonOne.setText(arr[0].getName());
		
		buttonTwo.setText(arr[1].getName());
		
		buttonThree.setText(arr[2].getName());
		
		buttonFour.setText(arr[3].getName());
		
		buttonFive.setText(arr[4].getName());
		
		buttonSix.setText(arr[5].getName());
	}

	@Override
	public void init(Object... args) {
		// TODO Auto-generated method stub
		if(args[0]!=null) {
			controller=(SceneController) args[0];
		}
		FileInputStream fin;
		try {
			fin = new FileInputStream(new File("resources/E.png"));
			Image icon=new Image(fin, 200, 150, false, false);
			festivalIcon.setImage(icon);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		festivalId.setText(festival.getName());
		loadButtons();
	}
	
	
	
}
