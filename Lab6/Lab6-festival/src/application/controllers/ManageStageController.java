package application.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Set;

import application.models.Band;
import application.models.Festival;
import application.models.FestivalStage;
import application.viewModels.BorderPaneController;
import application.viewModels.ListViewBandUpdater;
import application.viewModels.SceneController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ManageStageController extends ViewController {
	@FXML
    private CheckBox autoSaveId;
	@FXML
    private Label numBandsText;

    @FXML
    private ListView<String> bandsList;

    @FXML
    private Label stageNameText;

    @FXML
    private ChoiceBox<String> selectStages;

    @FXML
    void moveStageUp(ActionEvent event) {
    	int i= bandsList.getSelectionModel().getSelectedIndex();
    	if(bands.getViewData().size()!=1&&i-1<bands.getViewData().size())
    	bands.addItem(i, bands.removeItem(i));
    	//System.out.println(i);
    }

    @FXML
    void moveStageDown(ActionEvent event) {
    	int i= bandsList.getSelectionModel().getSelectedIndex();
    	if(i!=-1&&i+1<bands.getViewData().size())
    	bands.addItem(i+1, bands.removeItem(i));
    	//System.out.println(i+1);
    }

    @FXML
    void relocateSelectedStage(ActionEvent event) {
    	int i= bandsList.getSelectionModel().getSelectedIndex();
    	
    	FestivalStage stage=festival.getStage(selectStages.getSelectionModel().getSelectedItem());
    	if(stage.getBands().size()<limit) {
    		Band band=bands.removeItem(i);
    		stage.addBand(band);
    	}else {
    		Alert a=new Alert(AlertType.WARNING, "Cannot have more than "+limit+" in a Stage!");
    		a.show();
    	}
    }

    @FXML
    void goHome(ActionEvent event) {
    	controller.changeScene("StageSelection");
		controller.getCurrent().getController().init(controller);
    }
    
    @FXML
    void setSave(ActionEvent event) {
    	Festival.setAutoSave(autoSaveId.isSelected());
    	//System.out.println(autoSaveId.isSelected());
    }
	
    private ListViewBandUpdater bands;
    
	private Festival festival;
	private SceneController controller;
	private int limit=5;
	public ManageStageController() {
		
	}

	public Festival getFestival() {
		return festival;
	}

	public void setFestival(Festival festival) {
		this.festival = festival;
	}

	@Override
	public void init(Object... args) {
		// TODO Auto-generated method stub
		if(args[0]!=null) {
			controller=(SceneController) args[0];
		}
		
		if(args[1]!=null) {
			festival=(Festival) args[1];
		}
		
		if(args[2]!=null) {
			stageNameText.setText((String) args[2]);
		}
		
		bands=new ListViewBandUpdater(festival.getStage((String) args[2]).getBands());
		numBandsText.setText("Number of bands : "+festival.getStage((String) args[2]).getBands().size());
		bandsList.setItems(bands.getViewData());
		ObservableList<String> viewData=FXCollections.<String>observableArrayList(festival.getStageNames());
		selectStages.setItems(viewData);
		selectStages.setValue(viewData.get(0));
		
		
		//System.out.println(bands);
	}

}
