package com.example.ex05;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;


@Component("fileUploadBean")
@Scope("request")
public class FileUploadBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private UploadedFile file;

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }


    public String upload(){
        if (file!=null) {
        	FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        	FacesContext.getCurrentInstance().addMessage(null, message);
        }
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning file was not uploaded", "Size of file is null. Is this ok? "));

        return null;
    }
}
