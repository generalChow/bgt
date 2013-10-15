package cn.newgxu.bgt.model;

/**
 * @author 周大帅
 * @email 463734522@qq.com
 * 2013年9月24日
 */
public class Attention {

	private int aId;
	private int uId;
	private int qId;
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getaId() {
		return aId;
	}
	public void setaId(int aId) {
		this.aId = aId;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public int getqId() {
		return qId;
	}
	public void setqId(int qId) {
		this.qId = qId;
	}
	
	/**
	 * 
	 */
	public Attention(int qId,int uId,String state) {
		// TODO Auto-generated constructor stub
		this.qId=qId;
		this.uId=uId;
		this.state=state;
	}
	
}
