package cn.newgxu.bgt.service;

import java.util.List;

import cn.newgxu.bgt.model.Solution;
import cn.newgxu.bgt.model.entity.Solutioner;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public interface SolutionService {

	public void addSolution(Solution s);
	public List<Solutioner> getSolutionByQIdAndIndex(int qId, String index,int n);
}
