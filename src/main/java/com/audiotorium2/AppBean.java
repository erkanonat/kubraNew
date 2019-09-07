package com.audiotorium2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.audiotorium2.core.*;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.audiotorium2.controller.AppController;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.DataTableColumn;
import com.audiotorium2.entity.Item;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;

@ManagedBean
@Component
@SessionScoped
public class AppBean {

	@Autowired
	AppController appController;

	public List<Criteria> myCrts;
	public List<Range> myRanges;
	public List<Product> myProducts;
	public List<DataTableColumn> productColumns;

	public String newIssueName;

	public Map<String,List<Range>> criteriaMap;
	
	@PostConstruct
	public void appBean() {

		myCrts = new ArrayList<Criteria>();
		myCrts.add(new Criteria("", 0,null));
		myRanges = new ArrayList<Range>();
		myRanges.add(new Range("", "", 0));
		myProducts = new ArrayList<Product>();
		myProducts.add(new Product("", 0, new HashMap<String, String>(), 0));
		criteriaMap = new HashMap<String, List<Range>>();
		
	}



	public String forwardStepOne() {
		return "cd-step1.xhtml";
	}

	public String forwardStepTwo() {
		return "cd-step2.xhtml";
	}

	public String forwardStepThree() {
		this.fillCriteriaRangeMap();
		return "cd-step3.xhtml";
	}

	public String forwardStepFour() {
		this.calculatePrice();
		return "cd-step4.xhtml";
	}

	public String saveIssue() {
		this.saveDecisionAnalysis();
		return "successPage.xhtml";
	}

	public void onAddNewProduct() {
		myProducts.add(new Product("", 0, new HashMap<String, String>(), 0));
		FacesMessage msg = new FacesMessage("New Product added", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onAddNewRange() {
		myRanges.add(new Range("", "", 0));
		FacesMessage msg = new FacesMessage("New Range added", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onAddNewCriteria() {
		myCrts.add(new Criteria("", 0,null));
		FacesMessage msg = new FacesMessage("New Criteria added", "");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onAddNew() {
	}

	public String deleteCriteria(Criteria crt) {
		myCrts.remove(crt);
		return null;
	}

	public String deleteRow(Item item) {
//		myItems.remove(item);
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

	public List<Range> getMyRanges() {
		return myRanges;
	}

	public void setMyRanges(List<Range> myRanges) {
		this.myRanges = myRanges;
	}

	public List<String> getCriterias() {
		List<String> crts = new ArrayList<String>();
		if (!myCrts.isEmpty()) {
			for (Criteria crt : myCrts) {
				crts.add(crt.getName());
			}
		}
		return crts;
	}
	
	public void fillCriteriaRangeMap(){
		this.criteriaMap.clear();
		for(int i=0;i<myCrts.size();i++) {
			List<Range> rangeList = new ArrayList<Range>();
			for(int j=0;j<myRanges.size();j++) {
				if(myRanges.get(j).getCriteriaName().equals(myCrts.get(i).getName())) {
					rangeList.add(myRanges.get(j));
				}
			}
			this.criteriaMap.put(myCrts.get(i).getName(), rangeList);
		}
	}

	public List<DataTableColumn> getProductColumns() {
		List<DataTableColumn> result = new ArrayList<DataTableColumn>();
		if (!myCrts.isEmpty()) {
			for (Criteria crt : myCrts) {
				DataTableColumn column = new DataTableColumn(crt.getName(), crt.getName());
				result.add(column);
			}
		}
		return result;
	}

	public void setProductColumns(List<DataTableColumn> dataTableColumns) {
		this.productColumns = dataTableColumns;
	}

	public List<Product> getMyProducts() {
		return myProducts;
	}

	public void setMyProducts(List<Product> myProducts) {
		this.myProducts = myProducts;
	}

	public Map<String, List<Range>> getCriteriaMap() {
		return criteriaMap;
	}

	public void setCriteriaMap(Map<String, List<Range>> criteriaMap) {
		this.criteriaMap = criteriaMap;
	}
	
	public void calculatePrice() {
		if(!myProducts.isEmpty()) {
			for(int i=0;i<myProducts.size();i++) {
				double grade = 0;
				
				for(Entry<String, String> entry : myProducts.get(i).getCriteriaRangeMap().entrySet()) {
					Criteria crt = findCriteria(entry.getKey());					
					Range rng = findRange(entry.getValue());
					grade += rng.getWeight() * Double.valueOf(crt.getValue());
				}
				myProducts.get(i).setGrade(grade);
			}
		}
	}
	public Range findRange(String rangeName) {
		for(int i=0;i<myRanges.size();i++) {
			if(rangeName.equals(myRanges.get(i).getRangeName())) {
				return myRanges.get(i);
			}
		}
		return null;
	}
	public Criteria findCriteria(String crtName) {
		for(int i=0;i<myCrts.size();i++) {
			if(crtName.equals(myCrts.get(i).getName())) {
				return myCrts.get(i);
			}
		}
		return null;
	}

	private int findRangeId(String rangeName, List<EntityRange> list) {
		for(int i=0;i<list.size();i++) {
			if(rangeName.equals(list.get(i).getRange_name())){
				return  list.get(i).getId();
			}
		}
		return 0;
	}

	private int findCriteriaId(String criteriaName, List<EntityCriteria> list) {
		for(int i=0;i<list.size();i++) {
			if(criteriaName.equals(list.get(i).getName())){
				return list.get(i).getId();
			}
		}
		return 0;
	}

	public String saveIssueTest() {

		// save issue
		EntityIssue issue = appController.saveIssue(newIssueName);

		// save criteria
		List<EntityCriteria> listcrt = new ArrayList<>();
		for(int i=0; i<myCrts.size(); i++ ) {
			EntityCriteria criteria = appController.saveCriteria(issue.getId(), myCrts.get(i).getName(), Double.valueOf(String.valueOf(myCrts.get(i).getValue())));
			listcrt.add(criteria);
		}

		// save range
		List<EntityRange>listrange = new ArrayList<>();
		for(int i =0;i<myRanges.size();i++) {
			int criteria_id = findCriteriaId(myRanges.get(i).getCriteriaName(), listcrt);
			EntityRange range  =appController.saveRange(criteria_id , myRanges.get(i).getRangeName(), myRanges.get(i).getWeight());
			listrange.add(range);
		}

		// save product
		List<EntityProduct> listprd=new ArrayList<>();
		for(int i=0; i<myProducts.size();i++) {

			EntityProduct product = appController.saveProduct(myProducts.get(i).getGrade(), myProducts.get(i).getName(),0,0, issue.getId() );
			listprd.add(product);
		}

		// save product Details
		for(int i=0;i<listprd.size();i++) {

			for(Entry<String,String> detail : myProducts.get(i).getCriteriaRangeMap().entrySet()){
				int crtid=findCriteriaId(detail.getKey(), listcrt);
				int rid = findRangeId(detail.getValue(), listrange);
				int pid = listprd.get(i).getId();
				double grade = listprd.get(i).getGrade();
				EntityProductDetails prdDetail = appController.saveProductDetails(crtid,rid,pid,grade);

			}

		}

		myProducts.clear();
		myCrts.clear();
		myRanges.clear();
		newIssueName="";
		criteriaMap.clear();
//		productColumns.clear();

		return  "successPage.xhtml";

	}



	public void saveDecisionAnalysis() {

		appController.saveDecisionAnalysis(myProducts, myCrts, myRanges);
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Issue successfully saved", "Saved");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}


}
