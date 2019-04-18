package cn.itcast.exam.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.exam.dao.Userdao;
import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.utils.HibernateUtils;

public class UserdaoImpl extends HibernateDaoSupport implements Userdao {

	//�첽�������󣬼���û����Ƿ��Ѿ�����
	@Override
	public User checkUserName(String username) {
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		String sql = "select * from user where username = ?";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, username);
		sqlQuery.addEntity(User.class);
		List<User> list = sqlQuery.list();
		
		transaction.commit();//�ύ����
		
		if(list.size() > 0){
			return list.get(0);
		}
		
		session.close();//�ر�session
		return null;
	}

	//�û�ע��ķ���
	@Override
	public void registUser(User user) {
		this.getHibernateTemplate().save(user);
	}

	//�û�����
	@Override
	public User findActiveUser(String uuidCode) {
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		String sql = "select * from user where uuidcode = ?";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, uuidCode);
		sqlQuery.addEntity(User.class);
		List<User> list = sqlQuery.list();

		transaction.commit();//�ύ����
		session.close();//�ر�session
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	//���ļ������û���Ϣ
	@Override
	public void updateActiveUser(User active_user) {
		this.getHibernateTemplate().update(active_user);
	}

	//�û���¼����Ϣ
	@Override
	public User loginUser(User user) {
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		String sql = "select * from user where username= ? and password = ?" ;
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, user.getUsername());
		sqlQuery.setParameter(1, user.getPassword());
		sqlQuery.addEntity(User.class);
		List<User> list = sqlQuery.list();
		
		transaction.commit();//�ύ����
		session.close();//�ر�session
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null;
		}
	}

	
	//��ѯ�û�����ʷ�ɼ�
	@Override
	public ArrayList<PastScoreBean> getAllPastScore(User user) {
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		User getPastScoreUser = session.get(User.class, user.getUid());
		//�����û��õ��û�����ʷ�ɼ���set����
		Set<PastScoreBean> pastScoreSet = getPastScoreUser.getPastScoreSet();
		//����һ���¼�������װ�û����10���Ŀ��Գɼ���¼
		ArrayList<PastScoreBean> newList = new ArrayList<PastScoreBean>();
		ArrayList<PastScoreBean> newList2 = new ArrayList<PastScoreBean>();
		for (PastScoreBean pastScoreBean : pastScoreSet) {
			System.out.println("pastScoreSet"+pastScoreBean.getExamtime());
			newList.add(pastScoreBean);
		}
		for(int index = newList.size();index > 0 ;index --){
			//������Ӹ�newList2��Ŀ�����ÿ���ʱ���ں�ɼ�������ǰ
			System.out.println("newList"+newList.get(index-1).getExamtime());
			newList2.add(newList.get(index-1));
		}
		for (PastScoreBean pastScoreBean : newList2) {
			System.out.println(pastScoreBean.getExamtime());
		}
		transaction.commit();//�ύ����
		session.close();//�ر�session
		return newList2;
	}

	//�޸��û�����Ϣ
	@Override
	public void updateUser(User user) {
		this.getHibernateTemplate().update(user);
	}

	@Override
	public User findUser(Integer uid) {
		
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		User user = session.get(User.class, uid);
		transaction.commit();//�ύ����
		session.close();//�ر�session
		return user;
	}

	//�޸��û�����
	@Override
	public int updateUserPwd(User nowLoginUser) {
		
		//this.getHibernateTemplate().update(nowLoginUser);
		
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		String sql = "update user set password = ? where uid = ?" ;
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, nowLoginUser.getPassword());
		sqlQuery.setParameter(1, nowLoginUser.getUid());
		int result = sqlQuery.executeUpdate();
		transaction.commit();//�ύ����
		session.close();//�ر�session
		return result;
	}
}
