package cn.itcast.exam.domain;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer uid;//�û���id
	private String username;//�û����˺�
	private String password;//�û�����
	private String email;//�û�����
	private String school;//�û��ı�����У
	private String phone;//�û�����ϵ�绰
	private String registtime;//�û�ע���ʱ��
	private Integer state;//�û���״̬ ���� 0 �����˺�û���1�����˺ż���
	private String uuidcode;//�û��ļ�����
	private String imagepath;//�û���ͷ��·��
	private String emailcode;//�û��޸��˺�ʱ���������֤��
	//��ʾ���û��������еĴ��⼯  һ�Զ�Ĺ�ϵ����һ��һ�����ö��һ���ļ���
	private Set<PastScoreBean> pastScoreSet = new HashSet<PastScoreBean>();
	//��Զ�Ĺ�ϵ  һ���û������ж������� ��һ��������Ա�����û�ӵ��
	private Set<QuestionBean> questionBeanSet = new HashSet<QuestionBean>();
	
	public Set<QuestionBean> getQuestionBeanSet() {
		return questionBeanSet;
	}
	public void setQuestionBeanSet(Set<QuestionBean> questionBeanSet) {
		this.questionBeanSet = questionBeanSet;
	}
	public Set<PastScoreBean> getPastScoreSet() {
		return pastScoreSet;
	}
	public void setPastScoreSet(Set<PastScoreBean> pastScoreSet) {
		this.pastScoreSet = pastScoreSet;
	}
	
	
	public String getEmailcode() {
		return emailcode;
	}
	public void setEmailcode(String emailcode) {
		this.emailcode = emailcode;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getRegisttime() {
		return registtime;
	}
	public void setRegisttime(String registtime) {
		this.registtime = registtime;
	}
	
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	
	public String getUuidcode() {
		return uuidcode;
	}
	public void setUuidcode(String uuidcode) {
		this.uuidcode = uuidcode;
	}
	
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password="
				+ password + ", email=" + email + ", school=" + school
				+ ", registtime=" + registtime + "]";
	}
	
}
