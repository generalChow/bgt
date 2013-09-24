package cn.newgxu.bgt.serviceImpl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import cn.newgxu.bgt.common.Constant;
import cn.newgxu.bgt.dao.SolutionMapper;
import cn.newgxu.bgt.model.Solution;
import cn.newgxu.bgt.model.User;
import cn.newgxu.bgt.service.SolutionService;
import cn.newgxu.bgt.util.SessionUtil;
import cn.newgxu.bgt.util.TimeUitl;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
@Service("solutionService")
public class SolutionServiceImpl implements SolutionService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private SolutionMapper solutionMapper;

	/* (non-Javadoc)
	 * @see cn.newgxu.bgt.service.SolutionService#addSolution(cn.newgxu.bgt.model.Solution)
	 */
	public void addSolution(Solution s) {
		// TODO Auto-generated method stub
		User user = (User) SessionUtil.getAttributeFromSessionByKey(Constant.SESSION_USER);
		s.setuId(user.getuId());
		s.setAddTime(String.valueOf(TimeUitl.getCurrentTime()));
		solutionMapper.addSolution(s);
	}

}
