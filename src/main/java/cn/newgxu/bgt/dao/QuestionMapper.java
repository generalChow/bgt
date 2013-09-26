package cn.newgxu.bgt.dao;

import org.apache.ibatis.annotations.Param;

import cn.newgxu.bgt.model.Question;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public interface QuestionMapper {

	public void addQuestion(Question question);
	public void setQuestionGood(@Param("qId") int qId);
}
