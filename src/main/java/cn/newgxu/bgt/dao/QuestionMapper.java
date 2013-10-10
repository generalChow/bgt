package cn.newgxu.bgt.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import cn.newgxu.bgt.model.Question;
import cn.newgxu.bgt.model.entity.QuestionModel;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public interface QuestionMapper {

	public void addQuestion(Question question);
	public void setQuestionGood(@Param("qId") int qId);
	/**
	 * 从后数的n个中选出m个关注度最高的曝光
	 * @param n
	 * @param m
	 * @return
	 */
	public List<QuestionModel> getAttenTionQuestion(Map<String, Object> params);
	public List<String> getQIdsDesc(@Param("m") int m);
}
