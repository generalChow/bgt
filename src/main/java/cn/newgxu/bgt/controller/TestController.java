
package cn.newgxu.bgt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
@Controller
public class TestController {

	@RequestMapping("/test")
	@ResponseBody
	public ModelAndView test(ModelAndView model){
		return model;
	}
}
