package application.controllers;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import application.models.Band;
import application.models.BandMember;
import application.models.SlideShow;
import application.viewModels.SwitchViewTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SlideshowController {
	@FXML
	private Label memberName;
	@FXML
	private Label bandName;
	@FXML
	private ImageView slideshow;
	@FXML
	private Button playButton;
	@FXML
	void previousMember(ActionEvent event) {

		task.previous();
		task.cancel();
		startTask();
	}

	@FXML
	void togglePlay(ActionEvent event) {
		
		if (task != null && task.isRunning()) {
			
			task.cancel();
		}
		show.setCurrentIndex(0);
		startTask();
		
			playButton.setText("Start over");
		
	}

	@FXML
	void nextMember(ActionEvent event) {

		task.next();
		task.cancel();
		startTask();
	}

	@FXML
	void nextBand(ActionEvent event) {
		index += 1;
		if (index >= bands.size())
			index = 0;
		task.cancel();
		show = new SlideShow(bands.get(index));
		bandName.setText(bands.get(index).getName());
		startTask();
	}
	@FXML
	void previousBand(ActionEvent event) {
		index -= 1;
		if (index <0)
			index = bands.size()-1;
		task.cancel();
		show = new SlideShow(bands.get(index));
		bandName.setText(bands.get(index).getName());
		startTask();
	}
	public void startTask() {

		task = new SwitchViewTask(show, 3, slideshow);
		memberSwitcher = new Thread(task);

		memberName.textProperty().bind(task.messageProperty());
		memberSwitcher.setDaemon(true);
		memberSwitcher.start();

	}

	private boolean playing;
	private SwitchViewTask task;
	private Thread memberSwitcher = null;
	private SlideShow show = null;
	private Band band = null;
	private ArrayList<Band> bands;
	private int index;

	@FXML
	void initialize() {
		playing = false;
		bands = new ArrayList<Band>();
		try {
			bands.add(Band.loadBand("resources/queen/names.csv"));
			bands.add(Band.loadBand("resources/daft_punk/names.csv"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		index = 0;
		show = new SlideShow(bands.get(index));
		bandName.setText(bands.get(index).getName());
		task = new SwitchViewTask(show, 3, slideshow);
		memberName.setText(bands.get(index).getMember(0).getName());
		
	}
}
