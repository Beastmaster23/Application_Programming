package application.viewModels;

import application.models.SlideShow;
import javafx.beans.property.SimpleStringProperty;
import javafx.concurrent.Task;
import javafx.scene.image.ImageView;

public class SwitchViewTask extends Task{
	private int delay;
	private SlideShow show;
	private ImageView view;
	public SwitchViewTask(SlideShow show, int delay, ImageView view) {
		this.show=show;
		this.delay=delay;
		this.view=view;
		view.setImage(show.getCurrent().getImg());
	}
	
	public void next() {
		show.next();
		view.setImage(show.getCurrent().getImg());
	}
	
	public void previous() {
		show.previous();
		view.setImage(show.getCurrent().getImg());
	}
	
	@Override
	protected Object call() throws Exception {
		// TODO Auto-generated method stub
		while(!isCancelled()) {
			view.setImage(show.getCurrent().getImg());
			updateMessage(show.getCurrent().getName());
			Thread.sleep(delay*1000);
			if(isCancelled())break;
			show.next();
		}
		
		return null;
	}

}
