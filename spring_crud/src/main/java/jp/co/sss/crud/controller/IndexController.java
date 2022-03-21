package jp.co.sss.crud.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.crud.entity.Employee;
import jp.co.sss.crud.form.LoginForm;
import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class IndexController {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    HttpSession session;

    // @RequestMapping(path = "/")
    // public String index() {
    // return "index";
    // }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }
    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout() {
        session.removeAttribute("user");
        return "index";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("form") @Valid LoginForm form, Model model) {
        System.out.println(form.getEmpId() + " " + form.getEmpPass());
        Employee emp = employeeRepository.findByEmpIdAndEmpPass(form.getEmpId(), form.getEmpPass());
        if (emp != null) {
            System.out.println("login!");
            session.setAttribute("user", emp);
            model.addAttribute("logout", "/list");
            return "redirect:/list";
        } else {
            model.addAttribute("errormessage", "社員ID、またはパスワードが間違っています。");
            System.out.println("failed!");
        }
        return "index";
    }
}
