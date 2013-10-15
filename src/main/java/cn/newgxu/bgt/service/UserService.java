
package cn.newgxu.bgt.service;

import cn.newgxu.bgt.model.User;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public interface UserService {

	public void addUser(User user);
	public boolean login(User user);
	public User getUserByUserName(String userName);
}
