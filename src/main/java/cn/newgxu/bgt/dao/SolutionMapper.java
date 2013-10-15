package cn.newgxu.bgt.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.newgxu.bgt.model.Solution;
import cn.newgxu.bgt.model.entity.Solutioner;

/**
 * @author 周大帅
 * @email 463734522@qq.com 2013年9月24日
 */
public interface SolutionMapper {

	public void addSolution(Solution s);

	/**
	 * 通过时间 拿出比这个添加时间小的solution list对象 n个
	 * 
	 * @param qId
	 * @param index
	 * @param n
	 * @return
	 */
	public List<Solutioner> getSolutionByQIdAndIndex(@Param("qId") int qId,
			@Param("time") String time, @Param("n") int n);
}
