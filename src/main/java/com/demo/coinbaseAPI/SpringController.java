package com.demo.coinbaseAPI;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringController {
	
	@RequestMapping(value = "/submit", method = RequestMethod.GET)
    public String cryptoForm(Model model) {
        model.addAttribute("submissionForm", new SubmissionForm());
        return "submissionForm";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(
      @ModelAttribute("subForm") SubmissionForm subForm,
      BindingResult result, Model submissionForm) throws IOException, ParseException {
        if (result.hasErrors()) {
            return "submissionForm";
        }
        
        String currency = subForm.getCurrency();
        String crypto = subForm.getCrypto();
        String price = PriceFetcher.processJSON(crypto,currency);
        
        System.out.println(currency);
        System.out.println(crypto);
        System.out.println(price);
        
        submissionForm.addAttribute("crypto", crypto);
        submissionForm.addAttribute("currency", currency);
        submissionForm.addAttribute("price", price);
        
        System.out.println(submissionForm);
        return "Result";
    }

}