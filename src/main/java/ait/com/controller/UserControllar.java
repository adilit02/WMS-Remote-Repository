
package ait.com.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ait.com.ExcelSheet.ExcelExport;
import ait.com.entity.User;
import ait.com.service.UserService;

@Controller
public class UserControllar {

	@Autowired
	private UserService userService;

	@GetMapping("/ait")
	public String save(Model model) {

		User user = new User();

		model.addAttribute("usr", user);

		return "master";
	}

	@GetMapping("/reg")
	public String regsterPageLoad(Model model) // registration Page Load
	{
		User user = new User();
		List<User> list = userService.getAllUser();

		model.addAttribute("usr", user);
		model.addAttribute("rollData", list);
		return "User";
	}

	@PostMapping("/createuser")
	public String createUser(@ModelAttribute("usr") User user, Model model) {

		User u = userService.createdUser(user);

		String msg = (u != null) ? "User Sucsess....." : "User Not Sucsess....";

		model.addAttribute("msg", msg);

		return "User";
	}

	@GetMapping("/view")
	public String getAllUser(Model model) {
		List<User> list = userService.getAllUser();

		model.addAttribute("UserList", list);
		return "UserView";
	}

	@GetMapping("/userupdate")
	public String UserUpadte(@RequestParam("id") Integer Id, Model model) {

		// System.out.println("---------->" + Id);

		Optional<User> user = userService.getUserById(Id);

		model.addAttribute("usr", user);
		return "UserUpdate";
	}

	@GetMapping("/userdelete/{id}")
	public String deleteUser(@PathVariable("id") Integer Id, Model model) {
		userService.deleteUser(Id);

		model.addAttribute("UserList", userService.getAllUser());
		// return "redirect:view";
		return "UserView";
	}

	// ____________________________________________________________________

	@GetMapping("/excel")
	public ModelAndView getExcelSheet(){
		
		List<User> list = userService.getAllUser();
		ModelAndView model = new ModelAndView();
		
		model.addObject("UserList", list);
		model.setView(new ExcelExport());

		      return model;
	}
}
