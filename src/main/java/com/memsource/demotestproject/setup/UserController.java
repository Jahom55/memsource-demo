package com.memsource.demotestproject.setup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user-setup")
    public String formUserSetup(@ModelAttribute UserSetupDTO userSetup, Model model) {
        model.addAttribute("userSetup", userService.getFirstUserSetup());
        model.addAttribute("message", model.getAttribute("message"));
        return "setup";
    }

    @PostMapping("/user-setup")
    public String formUserSetupSubmit(@ModelAttribute UserSetupDTO userSetup) {
        userService.save(userSetup);
        return "redirect:/user-setup";
    }


    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getMessage());
        return "redirect:/user-setup";
    }
}
