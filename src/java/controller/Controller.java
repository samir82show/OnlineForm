package controller;

import entity.SendEmail;
import entity.StorageForm;
import entity.StorageFormFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "controller")
@RequestScoped
public class Controller implements Serializable {

    @EJB
    private StorageFormFacade storageFormFacade;
    @Inject
    private StorageForm storageForm;
    @Inject
    private SendEmail sendEmail;

    private String result;

    private List columns;
    private ArrayList row1;
    private ArrayList row2;
    private ArrayList row3;

    private String testvar = "aaasdasdasda";
    
    @PostConstruct
    public void init() {
//        storageForm.setComments("my comments");
//        storageForm.setExpectedGrowth(3445);
//        storageForm.setRequestNo("RF123234");
//        storageForm.setOwnerEmail("sawad@sidra.org");
//        storageForm.setTeamEmail("aaaaa@sidra.org");
//        storageForm.setShareName("share name");
//        storageForm.setShareType("NFS");
//        storageForm.setSize(4433);
//        storageForm.setTargetHosts("1123...3434..345345");
        storageForm.setLastUpdatedDate(new Date());
        storageForm.setCreatedBy("admin");
        storageForm.setStatus("New");
        columns = new ArrayList();
        row1 = new ArrayList();
        row2 = new ArrayList();
        row3 = new ArrayList();
        row1.add("x");
        row1.add("VMAX-3");
        row1.add("Isilon");
        row1.add("Unity");
        row1.add("SMRC Unity");
        row1.add("XtremIO");
        row2.add("Total (GBs)");
        row2.add(90);
        row2.add(200);
        row2.add(160);
        row2.add(400);
        row2.add(10);
        row3.add("Used (GBs)");
        row3.add(30);
        row3.add(100);
        row3.add(140);
        row3.add(200);
        row3.add(6);
        columns.add(row1);
        columns.add(row2);
        columns.add(row3);
    }

    public List getColumns() {
        return columns;
    }

    public String getTestvar() {
        return testvar;
    }

    
    public StorageForm getStorageForm() {
        return storageForm;
    }

    public SendEmail getSendEmail() {
        return sendEmail;
    }

    public String getResult() {
        return result;
    }

    public void createStorageForm() {
        if (storageFormFacade.find(storageForm.getRequestNo()) == null) {
            storageFormFacade.create(storageForm);
            result = "Request form for " + storageForm.getShareName() + " submitted.";
            sendEmail.sendEmailHelper(storageForm);
            flushValues();

        } else {
            result = "Request " + storageForm.getRequestNo() + " already exists.";
        }
    }

//    public String findRequestNo() {
//        String str = "";
//        for (String s : storageFormFacade.findRequests()) {
//            str += s + ",";
//        }
//        return str.replaceAll(",$", "");
//    }
//
    public void fetchForm() {
        StorageForm tempForm = storageFormFacade.find(storageForm.getRequestNo());
        if (tempForm == null) {
//            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Request " + storageForm.getRequestNo() + " is not found."));
            result = "Request " + storageForm.getRequestNo() + " is not found.";
        } else {
            storageForm = tempForm;
        }
    }

    public void editForm() {
        storageFormFacade.edit(storageForm);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Request " + storageForm.getRequestNo() + " is edited."));

    }

    public List<StorageForm> listStorageForms() {
        return storageFormFacade.findAll();
    }

    public void flushValues() {
        storageForm.setComments(null);
        storageForm.setExpectedGrowth(null);
        storageForm.setRequestNo(null);
        storageForm.setOwnerEmail(null);
        storageForm.setTeamEmail(null);
        storageForm.setShareName(null);
        storageForm.setShareType(null);
        storageForm.setSize(null);
        storageForm.setLastUpdatedDate(null);
        storageForm.setStatus(null);
        storageForm.setCreatedBy(null);
    }
}
