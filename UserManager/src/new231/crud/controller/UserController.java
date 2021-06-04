package new231.crud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import new231.crud.model.User;
import new231.crud.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@RequestMapping("/")
	public ModelAndView home() {
		List<User> list = service.listAll();
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("listUser", list);
		return mav;
	}

	@RequestMapping("/new")
	public String newUserForm(Map<String, Object> model) {
		model.put("user", new User());
		return "new_user";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.save(user);
		return "redirect:/";
	}

	@RequestMapping("/edit")
	public ModelAndView editCustomerForm(@RequestParam Long id) {
		ModelAndView mav = new ModelAndView("edit_user");
		User user = service.get(id);
		mav.addObject("user", user);
		return mav;
	}

	@RequestMapping("/delete")
	public String delete(@RequestParam Long id) {
		service.delete(id);
		return "redirect:/";
	}

	@RequestMapping("/search")
	public ModelAndView search(@RequestParam String keyword) {
		ModelAndView mav = new ModelAndView("search"); 
		List<User> result = service.search(keyword);
		mav.addObject("result", result);
		return mav;
	}
}
