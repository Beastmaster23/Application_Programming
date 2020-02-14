package application.viewModels;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import application.models.Band;
import application.models.FestivalStage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListViewBandUpdater {
	private ObservableList<String> viewData;
	
	private ArrayList<Band> data;
	
	public ListViewBandUpdater(ArrayList<Band> data) {
		ArrayList<String> list=new ArrayList<String>();
		for(Band b:data) {			
			list.add(b.getName());
		}
		viewData=FXCollections.<String>observableArrayList(list);
		this.data= data;		
		
	}
	
	public void setItem(int i, Band b) {
		viewData.set(i, b.getName());
		data.set(i, b);
	}
	public void addItem(int i, Band b) {
		if(i<0||i>viewData.size())return;
		String prev=b.getName();
		for(int j=i;j<viewData.size();j++) {
			prev=viewData.set(j, prev);
		}
		viewData.add(prev);
		data.add(i, b);
	}
	
	public Band removeItem() {
		viewData.remove(0);
		return data.remove(0);
	}
	public Band removeItem(int i) {
		viewData.remove(i);
		return data.remove(i);
	}
	public String getItem(int i) {
		return viewData.get(i);
	}
	public void addItem(Band b) {
		viewData.add(b.getName());
		data.add(b);
	}

	@Override
	public String toString() {
		return "ListViewUpdater [viewData=" + viewData + ", data=" + data + "]";
	}

	public ObservableList<String> getViewData() {
		return viewData;
	}

	public void setViewData(ObservableList<String> viewData) {
		this.viewData = viewData;
	}

	public ArrayList<Band> getData() {
		return data;
	}

	public void setData(ArrayList<Band> data) {
		this.data = data;
	}
	
}
