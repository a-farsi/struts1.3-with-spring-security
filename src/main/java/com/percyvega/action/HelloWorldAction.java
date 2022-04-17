package com.percyvega.action;

import com.percyvega.dao.UserDao;
import com.percyvega.form.HelloWorldForm;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

public class HelloWorldAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response) throws Exception {

        HelloWorldForm helloWorldForm = (HelloWorldForm) form;
        UserDao user = new UserDao();
        user.insertData();
        int max = 50;
        int min = 0;
        int randomNum = new Random().nextInt((max - min) + 1) + min;
        if(randomNum > 25 ) {
            helloWorldForm.setGreeting("Hello World using Struts!");
            return mapping.findForward("success");
        }else {
            helloWorldForm.setGreeting("Struts 1.3 is an old fashion !");
            return mapping.findForward("failure");
        }
    }

}