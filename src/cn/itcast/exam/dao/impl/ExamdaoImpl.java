package cn.itcast.exam.dao.impl;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.exam.dao.Examdao;
import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.utils.HibernateUtils;

public class ExamdaoImpl extends HibernateDaoSupport implements Examdao {

	// ��Ŀ�������Ŀ��ϰ
	@Override
	public ArrayList<QuestionBean> keMuLianXi(Integer number) {
		// �����ȡ��Ŀ
		Session session = HibernateUtils.openSession();// ��ȡsession
		Transaction transaction = session.beginTransaction();// ��������

		String sql = null;
		// �������
		if (number == 1) {
			int i = 1;
			// ��Ŀһ����Ŀ������:��ѡ����ж���
			sql = "select * from questions where cid = '1' or cid = '2' order by rand() limit 20";
			// addEntity(QuestionBean.class);�����ǽ�����ֵ����ָ��ΪQuestionBean��������
			Query query = session.createSQLQuery(sql).addEntity(
					QuestionBean.class);
			ArrayList<QuestionBean> list = (ArrayList<QuestionBean>) query.list();
			transaction.commit();// �ύ����
			session.close();// �ر�session
			return list;
		} else {
			// ��Ŀ�ĵ���Ŀ������:��ѡ�⡢�ж���Ͷ�ѡ��
			sql = "select * from questions order by rand() limit 20";
			Query query = session.createSQLQuery(sql).addEntity(
					QuestionBean.class);
			ArrayList<QuestionBean> list = (ArrayList<QuestionBean>) query.list();
			transaction.commit();// �ύ����
			session.close();// �ر�session
			return list;
		}
	}

	//�õ����Դ���ļ���
	@Override
	public ArrayList<QuestionBean> getWrongList(Map<Integer, String> wrongMap) {
		ArrayList<QuestionBean> wrongList = new ArrayList<QuestionBean>();
		int number = 1;
		for (Integer qid : wrongMap.keySet()) {
			QuestionBean questionBean = this.getHibernateTemplate().get(QuestionBean.class, qid);
			// ����Ŀ����˳�����
			questionBean.setNumber(String.valueOf(number));
			// ����������û�����Ĵ�
			questionBean.setUserWrongAnswer(wrongMap.get(qid));
			wrongList.add(questionBean);
			number++;
		}
		return wrongList;
	}

	// Ϊ��ǰ�û������ʷ�ɼ�
	@Override
	public void addPastScore(PastScoreBean pastScoreBean) {
		Session session = HibernateUtils.openSession();// ��ȡsession
		Transaction transaction = session.beginTransaction();// ��������

		String sql = "insert into pastscore values(null,?,?,?,?,?)";

		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, pastScoreBean.getUser().getUid());
		sqlQuery.setParameter(1, pastScoreBean.getScore());
		sqlQuery.setParameter(2, pastScoreBean.getRighttotal());
		sqlQuery.setParameter(3, pastScoreBean.getWrongtotal());
		sqlQuery.setParameter(4, pastScoreBean.getExamtime());
		sqlQuery.executeUpdate();

		transaction.commit();// �ύ����
		session.close();// �ر�session
	}

	// �û�����Ҫ�Ĵ�����ӵ����⼯�ϵķ���
	@Override
	public int addWrong(User nowLoginUser, int qid) {
		Session session = HibernateUtils.openSession();// ��ȡsession
		Transaction transaction = session.beginTransaction();// ��������

		String sql = "insert into wrongquestion values(null,?,?)";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, nowLoginUser.getUid());
		sqlQuery.setParameter(1, qid);
		// �ɹ����µĽ����1
		int result = sqlQuery.executeUpdate();
		transaction.commit();// �ύ����
		session.close();// �ر�session
		return result;
	}

	// �û��鿴���⼯�ϵķ���
	@Override
	public ArrayList<QuestionBean> lookWrongQuestion(User nowLoginUser) {
		Session session = HibernateUtils.openSession();// ��ȡsession
		Transaction transaction = session.beginTransaction();// ��������

		User user = session.get(User.class, nowLoginUser.getUid());
		Set<QuestionBean> questionBeanSet = user.getQuestionBeanSet();
		ArrayList<QuestionBean> list = new ArrayList<QuestionBean>();
		if (questionBeanSet != null) {
			for (QuestionBean questionBean : questionBeanSet) {
				list.add(questionBean);
			}
			transaction.commit();// �ύ����
			session.close();// �ر�session
			return list;
		} else {
			transaction.commit();// �ύ����
			session.close();// �ر�session
			return null;
		}
	}
}
