package cn.newgxu.bgt.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newgxu.bgt.common.Constant;
import cn.newgxu.bgt.dao.QuestionMapper;
import cn.newgxu.bgt.model.Attention;
import cn.newgxu.bgt.model.Question;
import cn.newgxu.bgt.model.User;
import cn.newgxu.bgt.model.entity.QuestionModel;
import cn.newgxu.bgt.service.QuestionService;
import cn.newgxu.bgt.util.SessionUtil;
import cn.newgxu.bgt.util.TimeUitl;

/**
 * @author 周大帅
 * @email 463734522@qq.com 2013年9月24日
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private QuestionMapper questionMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.newgxu.bgt.service.QuestionService#addQuestion(cn.newgxu.bgt.model
	 * .Question)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void addQuestion(Question question) {
		// TODO Auto-generated method stub
		question.setSolution("no");
		question.setAddTime(String.valueOf(TimeUitl.getCurrentTime()));
		question.setAttention(0);
		User user = (User) SessionUtil
				.getAttributeFromSessionByKey(Constant.SESSION_USER);
		question.setuId(user.getuId());
		questionMapper.addQuestion(question);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void setQuestionGood(int qId) {
		questionMapper.setQuestionGood(qId);
	}

	/**
	 * 从倒数n个question中选出关注度最高的m个
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<QuestionModel> getAttentionQ(int n, int m) {
		Map<String, Object> params = new HashMap<String, Object>();
		List<String> qIds = new ArrayList<String>();
		qIds = questionMapper.getQIdsDesc(n);
		// System.out.println("changdu:"+qIds.size());
		params.put("n", m);
		params.put("list", qIds);
		return questionMapper.getAttenTionQuestion(params);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<QuestionModel> getLastQ(int m, String solution, String time) {
		return questionMapper.getLastQ(m, solution, time);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public QuestionModel getQByQId(int qId) {
		return questionMapper.getQByQId(qId);
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public boolean updateA(int qId, int attention) {
		User user = (User) SessionUtil
				.getAttributeFromSessionByKey(Constant.SESSION_USER);
		System.out
				.println(questionMapper.getAIdByQIdAndUId(qId, user.getuId()));
		if (questionMapper.getAIdByQIdAndUId(qId, user.getuId()) != null) {
			return false;
		} else {
			Attention a = new Attention(qId, user.getuId(), "no");
			questionMapper.addAttention(a);
			questionMapper.updateAttention(qId, attention);
			return true;
		}
	}

	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<QuestionModel> getMyQuestions(String time, int n) {
		User user = (User) SessionUtil
				.getAttributeFromSessionByKey(Constant.SESSION_USER);
		return questionMapper.getMyQuestions(user.getuId(), time, n);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.newgxu.bgt.service.QuestionService#getMyQuestions(java.lang.String,
	 * int, int)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<QuestionModel> getMyQuestions(String time, int n, int uId) {
		// TODO Auto-generated method stub
		return questionMapper.getMyQuestions(uId, time, n);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.newgxu.bgt.service.QuestionService#updateQ(int, java.lang.String)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateQ(int qId, String newContext) {
		// TODO Auto-generated method stub
		Date d = new Date();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa"); 
		String context = questionMapper.getContextByQId(qId)
				+ "</br><=============更新==============></br>"
				+ newContext+"&nbsp;&nbsp;["+sdf.format(d)+"]";
		questionMapper.updateQByQId(qId, context);
		questionMapper.updateAttentionByQId(qId, "update");

	}

	/* (non-Javadoc)
	 * @see cn.newgxu.bgt.service.QuestionService#getQByStateAndUId(java.lang.String, int, java.lang.String)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public List<QuestionModel> getQByStateAndUId(String time, int n,
			String state) {
		// TODO Auto-generated method stub
	
		User user = (User) SessionUtil.getAttributeFromSessionByKey(Constant.SESSION_USER);
		return questionMapper.getMyAttentionQByUId(user.getuId(), time, state, n);
	}

	/* (non-Javadoc)
	 * @see cn.newgxu.bgt.service.QuestionService#updateAForState(int, java.lang.String)
	 */
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void updateAForState(int qId, String state) {
		// TODO Auto-generated method stub
		User user = (User) SessionUtil.getAttributeFromSessionByKey(Constant.SESSION_USER);
		questionMapper.updateAttentionByQId(qId, state);
	}

}
