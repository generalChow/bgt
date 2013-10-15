package cn.newgxu.bgt.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newgxu.bgt.common.Constant;
import cn.newgxu.bgt.model.User;
import cn.newgxu.bgt.service.UserService;
import cn.newgxu.bgt.util.HttpUtil;
import cn.newgxu.bgt.util.SessionUtil;

/**
 * @author 周大帅
 * @email 463734522@qq.com 2013年9月24日
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
	public ModelAndView registe(User user, ModelAndView model) {
		// 注册之前 先发生http请求论坛查看用户名和密码是否匹配，就可以同步论坛的资料
		try {
			HttpUtil http = new HttpUtil();
			String url = "http://bbs.newgxu.cn/checkAccout.yws?username="
					+ user.getUserName() + "&passWord=" + user.getPassWord();
			http.setUrlStr(url);
			http.send_url();
			logger.info(url);
			logger.info(http.getResponse_content());
			if (http.getResponse_content().equals("esult\":\"false\"}")) {
				model.addObject("result", "no");
				return model;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
			model.addObject("result", "no");
			return model;
		}

		userService.addUser(user);
		model.addObject("result", "yes");
		return model;
	}

	@RequestMapping(value = "/login")
	@ResponseBody
	public ModelAndView login(User user, ModelAndView model) {
		model.addObject("result", userService.login(user));
		model.addObject("user",
				SessionUtil.getAttributeFromSessionByKey(Constant.SESSION_USER));
		return model;
	}

	@RequestMapping(value = "/getUserByS")
	@ResponseBody
	public ModelAndView getUserInfoBySession(ModelAndView model) {
		User user = (User) SessionUtil
				.getAttributeFromSessionByKey(Constant.SESSION_USER);
		if (user != null) {
			model.addObject("result", true);
			model.addObject("user", user);
		}else{
			model.addObject("result", false);
		}

		return model;
	}
	@RequestMapping(value = "/getUserByU/{userName}")
	@ResponseBody
	public ModelAndView getUSerByUserName(@PathVariable String userName,ModelAndView m){
		m.addObject("user", userService.getUserByUserName(userName));
		return m;
	}

}
