package com.cardability.application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ErrorController {
    private final ErrorAttributes errorAttributes;

    public CustomErrorController(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        Map<String, Object> errorDetails = errorAttributes.getErrorAttributes(request, false);
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", errorDetails);
        return modelAndView;
    }
}
