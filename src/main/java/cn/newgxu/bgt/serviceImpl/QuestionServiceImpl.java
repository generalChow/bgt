package cn.newgxu.bgt.serviceImpl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.newgxu.bgt.dao.QuestionMapper;
import cn.newgxu.bgt.model.Question;
import cn.newgxu.bgt.service.QuestionService;
import cn.newgxu.bgt.util.TimeUitl;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService{

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private QuestionMapper questionMapper;
	/* (non-Javadoc)
	 * @see cn.newgxu.bgt.service.QuestionService#addQuestion(cn.newgxu.bgt.model.Question)
	 */
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		question.setSolution("no");
		question.setAddTime(String.valueOf(TimeUitl.getCurrentTime()));
		questionMapper.addQuestion(question);
	}

	public void setQuestionGood(int qId){
		questionMapper.setQuestionGood(qId);
	}
}
