package com.furkanisitan.moviecatalog.webmvc.exceptions.handlers;

import com.furkanisitan.moviecatalog.webmvc.exceptions.ResourceNotFoundException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException(ResourceNotFoundException e, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("message", e.getMessage());
        return "redirect:/error/resourceNotFound";
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException e, RedirectAttributes redirectAttributes) {
        return "error/accessDenied";
    }

}
