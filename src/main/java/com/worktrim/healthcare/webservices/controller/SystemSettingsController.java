package com.worktrim.healthcare.webservices.controller;



import com.worktrim.healthcare.webservices.model.User;
import com.worktrim.healthcare.webservices.response.SystemSettingsResponse;
import com.worktrim.healthcare.webservices.util.Constants;
import com.worktrim.healthcare.webservices.util.LoadMessageForLocale;
import com.worktrim.healthcare.webservices.util.SessionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemSettingsController {


    @Autowired
    private SessionHelper userInfo;
    @Autowired
    private LoadMessageForLocale localeMessage;

   // @PreAuthorize("hasAuthority('HEALTHCARE')")
    @GetMapping(value = {"/get-healthcare-settings"})
    public ResponseEntity<SystemSettingsResponse> findHealthcareSettings(){

        SystemSettingsResponse resp =  new SystemSettingsResponse();

        try {
            User user = userInfo.getcurrentUser();
            resp.setCurrentUser(user);
            resp.setMessageType(Constants.SUCCESS);
            resp.setStatusCode(HttpStatus.OK);

        }catch (Exception ex){
            ex.printStackTrace();
            resp.setMessage(localeMessage.getMessage("error.generic.system.error", null));
            resp.setStatusCode(HttpStatus.BAD_REQUEST);
            resp.setMessageType(Constants.ERROR);
        }

        return new ResponseEntity<SystemSettingsResponse> (resp, resp.getStatusCode());

    }





}
