package cn.itcast.exam.domain;

import java.util.HashSet;
import java.util.Set;

public class PastScoreBean {
	private Integer pid;//��ʷ�ɼ���id
	private Integer score;//һ�ο��Ե��ܷ���
	private Integer righttotal;//һ�ο���������Ŀ����Ŀ
	private Integer wrongtotal;//һ�ο���������Ŀ����Ŀ
	private String examtime;//����ʱ��
	
	//һ�Զ࣬�ڶ��һ������һ�Ķ���
	private User user;//���Գɼ��������û�����
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public Integer getRighttotal() {
		return righttotal;
	}
	public void setRighttotal(Integer righttotal) {
		this.righttotal = righttotal;
	}
	public Integer getWrongtotal() {
		return wrongtotal;
	}
	public void setWrongtotal(Integer wrongtotal) {
		this.wrongtotal = wrongtotal;
	}
	public String getExamtime() {
		return examtime;
	}
	public void setExamtime(String examtime) {
		this.examtime = examtime;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
