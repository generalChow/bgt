package cn.newgxu.bgt.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.newgxu.bgt.model.Solution;
import cn.newgxu.bgt.model.entity.Solutioner;
import cn.newgxu.bgt.service.SolutionService;

/**
 * @author 周大帅
 * @email 463734522@qq.com 2013年9月24日
 */
@Controller
public class SolutionController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private SolutionService solutionService;

	@RequestMapping("/addSolution")
	@ResponseBody
	public ModelAndView addSolution(Solution s, ModelAndView m) {
		solutionService.addSolution(s);
		m.addObject("result", "yes");
		return m;
	}

	@RequestMapping("/getSolutions/{qId}/{n}/{time}")
	@ResponseBody
	public ModelAndView getSolutionByQIN(@PathVariable int qId,
			@PathVariable int n, @PathVariable String time, ModelAndView m) {
		List<Solutioner> solutionList =	solutionService.getSolutionByQIdAndIndex(qId, time, n);
		m.addObject("sulotionList", solutionList);
		return m;
	}
}
