
package cn.newgxu.bgt.dao;

import org.apache.ibatis.annotations.Param;

import cn.newgxu.bgt.model.User;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public interface UserMapper {

	public void addUser(User user);
	public User getUserByUserName(@Param("userName")String userName);
}
