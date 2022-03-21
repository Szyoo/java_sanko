package jp.co.sss.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.crud.repository.EmployeeRepository;

@Controller
public class ListController {
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("list")
    public String showEmpList(Model model) {
        if (employeeRepository.findAll().isEmpty()) {
            System.out.println("empty");
        } else {
            System.out.println("exist");
        }
        model.addAttribute("employees", employeeRepository.findAll());
        return "list/list";
    }
}
