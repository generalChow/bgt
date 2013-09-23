package cn.newgxu.bgt.serviceImpl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.newgxu.bgt.dao.UserMapper;
import cn.newgxu.bgt.model.User;
import cn.newgxu.bgt.service.UserService;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Inject
	private UserMapper userMapper;
	
	

	public Logger getLogger() {
		return logger;
	}



	public void setLogger(Logger logger) {
		this.logger = logger;
	}



	/* (non-Javadoc)
	 * @see cn.newgxu.bgt.service.UserService#addUser(cn.newgxu.bgt.model.User)
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void addUser(User user) {
		// TODO Auto-generated method stub
		System.out.println("输出到这里了");
		userMapper.addUser(user);
	}
}
