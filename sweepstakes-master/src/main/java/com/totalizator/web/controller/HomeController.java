package com.totalizator.web.controller;

import com.totalizator.dao.entities.User;
import com.totalizator.services.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by home
 */
@Controller
@RequestMapping(value = "/")
public class HomeController {

    @Autowired
    IDataService dataService;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        return "redirect:/";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(@AuthenticationPrincipal User user) {
        if (user == null)
            return "redirect:/login";

            return "home";
    }

    /**
     * Страница логина
     *
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", params = {"auth=fail"}, method = RequestMethod.GET)
    public String login(ModelMap model) {
        model.put("loginFailed", true);
        return "login";
    }


    /**
     * Страница ошибки 403
     *
     * @return
     */
    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView error403() {
        ModelAndView model = new ModelAndView("error");
        model.addObject("error", "У вас недостаточно прав для выполнения данного действия.");
        return model;
    }
}
