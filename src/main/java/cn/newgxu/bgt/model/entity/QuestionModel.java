package cn.newgxu.bgt.model.entity;

import cn.newgxu.bgt.model.Question;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public class QuestionModel extends Question {
	private String nick;
	private String userName;
	private String email;
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	

}
