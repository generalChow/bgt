package cn.newgxu.bgt.service;


import java.util.List;

import cn.newgxu.bgt.model.Question;
import cn.newgxu.bgt.model.entity.QuestionModel;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public interface QuestionService {
	public void addQuestion(Question question);
	public void setQuestionGood(int qId);
	public List<QuestionModel> getAttentionQ(int n,int m);
}
