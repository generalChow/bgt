package cn.newgxu.bgt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.newgxu.bgt.model.Attention;
import cn.newgxu.bgt.model.Question;
import cn.newgxu.bgt.model.entity.QuestionModel;

/**
 * @author 周大帅
 * @email 463734522@qq.com 2013年9月24日
 */
public interface QuestionMapper {

	public void addQuestion(Question question);

	public void setQuestionGood(@Param("qId") int qId);

	/**
	 * 从后数的n个中选出m个关注度最高的曝光
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public List<QuestionModel> getAttenTionQuestion(Map<String, Object> params);

	public List<String> getQIdsDesc(@Param("m") int m);

	public List<QuestionModel> getLastQ(@Param("m") int m,
			@Param("solution") String solution, @Param("time") String time);

	public QuestionModel getQByQId(@Param("qId") int qId);

	public void updateAttention(@Param("qId") int qId,
			@Param("attention") int attention);

	public void addAttention(Attention a);

	public String getAIdByQIdAndUId(@Param("qId") int qId, @Param("uId") int uId);

	public List<QuestionModel> getMyQuestions(@Param("uId") int uId,
			@Param("time") String time, @Param("n") int n);

	public void updateQByQId(@Param("qId") int qId,
			@Param("context") String context);

	public String getContextByQId(@Param("qId") int qId);

	public void updateAttentionByQId(@Param("qId") int qId,
			@Param("state") String state);

	public List<QuestionModel> getMyAttentionQByUId(@Param("uId") int uId,
			@Param("time") String time, @Param("state") String state,@Param("n") int n);

}
