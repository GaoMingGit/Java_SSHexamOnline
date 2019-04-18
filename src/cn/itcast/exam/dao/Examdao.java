package cn.itcast.exam.dao;

import java.util.ArrayList;
import java.util.Map;

import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;

public interface Examdao {

	// ��Ŀ�������Ŀ��ϰ
	ArrayList<QuestionBean> keMuLianXi(Integer number);

	//�õ����Դ���ļ���
	ArrayList<QuestionBean> getWrongList(Map<Integer, String> wrongMap);

	// Ϊ��ǰ�û������ʷ�ɼ�
	void addPastScore(PastScoreBean pastScoreBean);

	// �û�����Ҫ�Ĵ�����ӵ����⼯�ϵķ���
	int addWrong(User nowLoginUser, int qid);

	// �û��鿴���⼯�ϵķ���
	ArrayList<QuestionBean> lookWrongQuestion(User nowLoginUser);

}
