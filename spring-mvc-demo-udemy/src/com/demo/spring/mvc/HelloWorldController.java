package com.demo.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

    //    Controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //    Controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    //    Controller method to read from the HTML form and add data to the model
    @RequestMapping("/processFormVersionTwo")
    public String letsShour(HttpServletRequest request, Model model) {

//        Read the request parameter from the HTML form
        String theName = request.getParameter("studentName");

//        Convert the to all caps
        theName = theName.toUpperCase();

//        Create message
        String result = "Hey " + theName;

//        Add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }

//    Controller method to read from the HTML form and add data to the model
    @RequestMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName") String theName,
            Model model) {

//        Convert the to all caps
        theName = theName.toUpperCase();

//        Create message
        String result = "Hey from v3! " + theName;

//        Add message to the model
        model.addAttribute("message", result);

        return "helloworld";
    }
}
