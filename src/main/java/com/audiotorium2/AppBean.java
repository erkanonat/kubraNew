package com.audiotorium2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.audiotorium2.controller.AppController;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Item;

@ManagedBean
@Component
@SessionScoped
public class AppBean {

	
	@Autowired
	AppController appController;

	

	public List<Criteria> myCrts;
	public List<Item> myItems;
	
	public String newIssueName;
	public String[] colors;

	public String[] brands;


	
	
	public List<Item> getMyItems() {
		return myItems;
	}

	public void setMyItems(List<Item> myItems) {
		this.myItems = myItems;
	}

	@PostConstruct
	public void appBean() {

		myItems = appController.getMyItems();
		colors = new String[10];
		colors[0] = "Black";
		colors[1] = "White";
		colors[2] = "Green";
		colors[3] = "Red";
		colors[4] = "Blue";
		colors[5] = "Orange";
		colors[6] = "Silver";
		colors[7] = "Yellow";
		colors[8] = "Brown";
		colors[9] = "Maroon";
		brands = new String[10];
		brands[0] = "BMW";
		brands[1] = "Mercedes";
		brands[2] = "Volvo";
		brands[3] = "Audi";
		brands[4] = "Renault";
		brands[5] = "Fiat";
		brands[6] = "Volkswagen";
		brands[7] = "Honda";
		brands[8] = "Jaguar";
		brands[9] = "Ford";
		
		
		myCrts = new ArrayList<Criteria>();
		myCrts.add(new Criteria("", 0));
		
		
	}
	public String[] getColors() {
		
		
		return colors;
	}

	public String[] getBrands() {
		return brands;
	}

	public void onDeleteRow() {
		myItems.remove(myItems.size()-1);
	}
	
	public String forwardStepTwo() {
		
		return "cd-step2.xhtml";
	}

	public void onAddNewCriteria() {
		
		myCrts .add(new Criteria("", 0));
		 FacesMessage msg = new FacesMessage("New Criteria added", "");
		 FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void onAddNew() {
		
		Item item = new Item("sf12", "brandd", 1999, "yellow", 10002, false);
		 myItems.add(item);
		 FacesMessage msg = new FacesMessage("New Car added", item.getId());
		 FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String deleteCriteria(Criteria crt) {
		myCrts.remove(crt);
		return null;
	}
	
	public String deleteRow(Item item) {
		myItems.remove(item);
		return null;
	}
	
	public void onRowEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Item Edited", ((Item) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onRowCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Edit Cancelled", ((Item) event.getObject()).getId());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCellEdit(CellEditEvent event) {
		Object oldValue = event.getOldValue();
		Object newValue = event.getNewValue();

		if (newValue != null && !newValue.equals(oldValue)) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed",
					"Old: " + oldValue + ", New:" + newValue);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}

	public List<Criteria> getMyCrts() {
		return myCrts;
	}

	public void setMyCrts(List<Criteria> myCrts) {
		this.myCrts = myCrts;
	}

	public String getNewIssueName() {
		return newIssueName;
	}

	public void setNewIssueName(String newIssueName) {
		this.newIssueName = newIssueName;
	}
	
	
}
