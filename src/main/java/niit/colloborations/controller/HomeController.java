package niit.colloborations.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import niit.colloborations.dao.NewUserDAO;
import niit.colloborations.model.User;
import niit.colloborations.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userservice;

	@RequestMapping("/")
	public ModelAndView showWelcome() {
		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping("/home")
	public ModelAndView showHome() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView showLogin() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/SignUp")
	public ModelAndView showRegister() {
		ModelAndView mv = new ModelAndView("SignUp");
		return mv;
	}

	@RequestMapping("/chat")
	public ModelAndView showChat() {
		ModelAndView mv = new ModelAndView("chat");
		return mv;
	}

	

	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid @ModelAttribute("user") User user,BindingResult result)
	{
			userservice.insertUser(user);
		System.out.println("signin is called");
	  return new ModelAndView("/login");
	 

	}
	@RequestMapping("/logincheck")
	public ModelAndView logincheck(@RequestParam(value="username")String uname,@RequestParam(value="password")String pwd)
	{
		ModelAndView mv;
		if(uname.equals("sa")&&pwd.equals("sa"))
		{
			return new ModelAndView("home");
		}
		else
		{
			return new ModelAndView("login");
		}
		/*if(userservice.login(uname, pwd))
		{
			mv=new ModelAndView("home");
			return mv;
		}
		else
		{
			mv=new ModelAndView("login");
			return mv;
		}*/
	}

}







