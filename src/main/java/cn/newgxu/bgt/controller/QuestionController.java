package cn.newgxu.bgt.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newgxu.bgt.model.Question;
import cn.newgxu.bgt.service.QuestionService;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
@Controller
public class QuestionController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private QuestionService questionService;
	
	
	@RequestMapping("/addQuestion")
	@ResponseBody
	public ModelAndView addQuestion(Question q,ModelAndView model){
		questionService.addQuestion(q);
		return model;
	}
	@RequestMapping("/setQuestionGood/{qId}")
	@ResponseBody
	public ModelAndView setQuestionGood(@PathVariable int qId,ModelAndView m){
		questionService.setQuestionGood(qId);
	    m.addObject("result", "yes");
		return m;
	}
	@RequestMapping("/getAQ/{n}/{m}")
	@ResponseBody
	public ModelAndView getAttentionQ(@PathVariable int n,@PathVariable int m,ModelAndView model){
		model.addObject("questions", questionService.getAttentionQ(n, m));
		return model;
	}
	
	@RequestMapping("/getLastQ/{solution}/{time}/{m}")
	@ResponseBody
	public ModelAndView getLastQ(@PathVariable String time,@PathVariable String solution,@PathVariable int m,ModelAndView model){
		model.addObject("questions", questionService.getLastQ(m, solution,time));
		return model;
	}
	
	@RequestMapping("/getQByQ/{qId}")
	@ResponseBody
	public ModelAndView getQByQId(@PathVariable int qId,ModelAndView model){
		model.addObject("question", questionService.getQByQId(qId));
		return model;
	}
	
	@RequestMapping("/updateA/{qId}/{attention}")
	@ResponseBody
	public ModelAndView updateA(@PathVariable int qId,@PathVariable int attention,ModelAndView model){
		model.addObject("result", questionService.updateA(qId, (attention+1)));
		return model;
	}
	
	@RequestMapping("/getMyQuestions/{n}/{time}")
	@ResponseBody
	public ModelAndView getMyQuestions(@PathVariable int n,@PathVariable String time,ModelAndView model){
		model.addObject("questions", questionService.getMyQuestions(time, n));
		return model;
	}
	
	@RequestMapping("/q/{qId}")
	public ModelAndView getQuestionByQId(@PathVariable int qId,ModelAndView model){
		model.setViewName("question");
		model.addObject("qId",qId);
		System.out.println("输出了");
		return model;
	}
	
	
}
