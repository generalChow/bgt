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
import cn.newgxu.bgt.util.HttpUtil;

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
		//注册之前 先发生http请求论坛查看用户名和密码是否匹配，就可以同步论坛的资料
		try {
			HttpUtil http = new HttpUtil();
			http.setUrlStr("http://bbs.newgxu.cn/checkAccout.yws");
			http.send_url("123", "34567");
			System.out.println(http.getResponse_content());
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			model.addObject("result", "no");
			return model;
		}
	
	
	//	userService.addUser(user);
		//model.addObject("result", "yes");
		return model;
	}
	@RequestMapping(value = "/login")
	@ResponseBody
	public ModelAndView login(User user,ModelAndView model){
		model.addObject("result", userService.login(user));
		return model;
	}
	
}
