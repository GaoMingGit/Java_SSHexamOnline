package cn.itcast.exam.domain;

import java.util.HashSet;
import java.util.Set;

public class QuestionBean {
	private String number;//���Ի�����ϰ����Ŀ˳�����
	private Integer qid;//�����Ӧ���ݿ��id
	private String question;//������Ŀ
	private String select_a;//����ѡ��A����
	private String select_b;//����ѡ��B����
	private String select_c;//����ѡ��C����
	private String select_d;//����ѡ��D����
	private String imagepath;//�����ͼƬ·��
	private String answer;//�������ȷ��
	private String descc;//����𰸵Ĺٷ�����
	private String cid;//��������ͣ�����1������ѡ��2�����ж��⣬3�����Ƕ�ѡ��
	private String addTime;//������ӹ���Ա������⵽���ݿ��е�ʱ��
	private String userWrongAnswer;//�û��������Ĵ�
	
	//��Զ�Ĺ�ϵ һ���û������ж������� ��һ��������Ա�����û�ӵ��
	private Set<User> userSet = new HashSet<User>();

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}
	
	public QuestionBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getSelect_a() {
		return select_a;
	}
	public void setSelect_a(String select_a) {
		this.select_a = select_a;
	}
	public String getSelect_b() {
		return select_b;
	}
	public void setSelect_b(String select_b) {
		this.select_b = select_b;
	}
	public String getSelect_c() {
		return select_c;
	}
	public void setSelect_c(String select_c) {
		this.select_c = select_c;
	}
	public String getSelect_d() {
		return select_d;
	}
	public void setSelect_d(String select_d) {
		this.select_d = select_d;
	}
	public String getImagepath() {
		return imagepath;
	}
	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getDescc() {
		return descc;
	}
	public void setDescc(String descc) {
		this.descc = descc;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	public String getUserWrongAnswer() {
		return userWrongAnswer;
	}
	public void setUserWrongAnswer(String userWrongAnswer) {
		this.userWrongAnswer = userWrongAnswer;
	}
	
}
