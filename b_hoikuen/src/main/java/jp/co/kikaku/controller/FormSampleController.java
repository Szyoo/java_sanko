package jp.co.kikaku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.kikaku.entity.Users;
import jp.co.kikaku.form.SampleForm;
import jp.co.kikaku.repository.UserRepository;

@Controller
public class FormSampleController {
	@Autowired
	UserRepository uersRepository;

	@RequestMapping(path="/form/sample", method=RequestMethod.POST)
	public String formShow(SampleForm form, Model model) {
		String userName = form.getUserName();
		String password = form.getPassword();
		model.addAttribute("userName", userName);
		model.addAttribute("password", password);

		List<Users> usersList = uersRepository.findAll();
		model.addAttribute("users", usersList);

		return "show_info";
	}

}
