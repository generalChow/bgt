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
	public List<QuestionModel> getLastQ(int m,String solution,String time);
	public QuestionModel getQByQId(int qId);
	public boolean updateA(int qId,int attention);
	public List<QuestionModel> getMyQuestions(String time,int n);
	public List<QuestionModel> getMyQuestions(String time,int n,int uId);
	public void updateQ(int qId,String newContext);
	public List<QuestionModel> getQByStateAndUId(String time,int n,String state);
	public void updateAForState(int qId,String state);
	public List<QuestionModel> searchQ(String context,int n,String time);
}
