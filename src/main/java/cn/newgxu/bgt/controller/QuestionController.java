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
}
