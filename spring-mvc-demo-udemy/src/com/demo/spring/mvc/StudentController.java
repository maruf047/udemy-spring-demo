package com.demo.spring.mvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Value("#{countryOptions}")
    private Map<String, String> countryOptions;

    @Value("#{favouriteLanguage}")
    private Map<String, String> favouriteLanguages;

    @RequestMapping("/showForm")
    public String showForm(Model theModel) {

//        Create a student object
        Student theStudent = new Student();

//        Add student object to the model
        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("theCountryOptions", countryOptions);
        theModel.addAttribute("theFavouriteLanguageOptions", favouriteLanguages);

        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student theStudent) {

//        Log the input data
        System.out.println("The student: " + theStudent.getFirstName() + " " + theStudent.getLastName());
        return "student-confirmation";
    }

}
