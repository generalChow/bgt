package cn.newgxu.bgt.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newgxu.bgt.model.User;
import cn.newgxu.bgt.service.UserService;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
@Controller
public class UserController {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private UserService userService;

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
	@RequestMapping(value = "/reg")
	@ResponseBody
	public ModelAndView registe(User user,ModelAndView model){
		System.out.println("yonghuming:"+user.getUserName());
		userService.addUser(user);
		model.addObject("yes", user);
		return model;
	}
	
}
