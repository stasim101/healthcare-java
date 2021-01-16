package com.worktrim.healthcare.webservices.response;


import com.worktrim.healthcare.webservices.model.User;

public class SystemSettingsResponse extends  AbstractResponse{
      private String testName = "this is a test";
      private String anotherProperty ="Another test Property";
      private User currentUser;

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getAnotherProperty() {
        return anotherProperty;
    }

    public void setAnotherProperty(String anotherProperty) {
        this.anotherProperty = anotherProperty;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
