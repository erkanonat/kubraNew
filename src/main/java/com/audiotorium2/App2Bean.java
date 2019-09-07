package com.audiotorium2;

import com.audiotorium2.controller.AppController;
import com.audiotorium2.core.EntityIssue;
import com.audiotorium2.core.EntityProduct;
import com.audiotorium2.core.ProductView;
import com.audiotorium2.entity.Criteria;
import com.audiotorium2.entity.Product;
import com.audiotorium2.entity.Range;
import com.audiotorium2.utility.SessionUtils;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@ManagedBean
@Component
@SessionScoped
public class App2Bean {

    @Autowired
    AppController appController;

    @Getter
    public List<ProductView> myProducts;
    @Getter
    public String issueName;
    @Getter
    public List<EntityIssue> myIssues= new ArrayList<EntityIssue>();
    @Getter
    public int selectedIssueId;

    public String listUserIssues() {
        HttpSession session = SessionUtils.getSession();
        int userId = (Integer) session.getAttribute("id");

        myIssues = appController.listMyIssues(userId);

        return "listUserIssues.xhtml";
    }


    public void listMyIssues() {

        HttpSession session = SessionUtils.getSession();
        int userId = (Integer) session.getAttribute("id");

        myIssues = appController.listMyIssues(userId);
    }

    public void listProductsOfIssue() {

        HttpSession session = SessionUtils.getSession();
        int userId = (Integer) session.getAttribute("id");

        myProducts = appController.listProductsOfIssues( selectedIssueId);

    }

    public void saveIssuePrices() {

    }

    public String openIssue(int issue_id) {
          for(int i=0;i<myIssues.size();i++) {
              if(myIssues.get(i).getId()==issue_id){
                  issueName = myIssues.get(i).getIssue_name();
              }
          }
          myProducts =  appController.listProductsOfIssues(issue_id);
          return "productDetails.xhtml";
    }

    public AppController getAppController() {
        return appController;
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }

    public List<ProductView> getMyProducts() {
        return myProducts;
    }

    public void setMyProducts(List<ProductView> myProducts) {
        this.myProducts = myProducts;
    }

    public String getIssueName() {
        return issueName;
    }

    public void setIssueName(String issueName) {
        this.issueName = issueName;
    }

    public List<EntityIssue> getMyIssues() {
        return myIssues;
    }

    public void setMyIssues(List<EntityIssue> myIssues) {
        this.myIssues = myIssues;
    }

    public int getSelectedIssueId() {
        return selectedIssueId;
    }

    public void setSelectedIssueId(int selectedIssueId) {
        this.selectedIssueId = selectedIssueId;
    }

    public String forwardShowIssues() {
        return listUserIssues();
    }

    public String saveProductPrices() {
        for(int i=0;i<myProducts.size(); i++) {

            appController.updateProduct(myProducts.get(i).getProduct_id(), myProducts.get(i).getGrade(), myProducts.get(i).getName(),
                    myProducts.get(i).getPrice(), myProducts.get(i).getSelected());
        }
        return "successPage.xhtml";
    }
}
