package com.synetech.jbpm.dblookup;

public class ErrorDetails implements java.io.Serializable {

    private int id;
    private String errorCode;
    private String errorType;
    private String errorDesc;
    private String processingStatus;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public void setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
    }
    
    @Override
    public String toString() {
        return "ErrorDetails{" +
                "id=" + id +
                ", errorCode='" + errorCode + '\'' +
                ", errorType='" + errorType + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", processingStatus='" + processingStatus + '\'' +
                '}';
    }
}
