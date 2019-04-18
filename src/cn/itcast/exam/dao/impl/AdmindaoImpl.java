package cn.itcast.exam.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import cn.itcast.exam.dao.Admindao;
import cn.itcast.exam.domain.AdminBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.utils.HibernateUtils;

public class AdmindaoImpl extends HibernateDaoSupport implements Admindao {

	//����Ա��¼
	@Override
	public AdminBean adminLogin(AdminBean admin) {
		String hql = "from AdminBean where adminname = ? and adminpassword = ?" ; 
		System.out.println(admin.getAdminname()+"  "+admin.getAdminpassword());
		List<AdminBean> list = (List<AdminBean>) this.getHibernateTemplate().find(hql, new String[]{admin.getAdminname(),admin.getAdminpassword()});
		if(list.size() > 0){
			return list.get(0);
		}else{
			return null ;
		}
	}
	
	
	//��������ķ���
	@Override
	public void save(QuestionBean questionBean) {
		this.getHibernateTemplate().save(questionBean);
	}

	//�õ�����
	@Override
	public int getCount(DetachedCriteria dtc) {
		dtc.setProjection(Projections.rowCount());
		List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(dtc);
		if(count.size() > 0){
			return count.get(0).intValue();
		}
		return 0;
	}

	//�õ�������ѯ�Ķ��󼯺�
	@Override
	public List<QuestionBean> findByPage(DetachedCriteria dtc,Integer begin, Integer pageSize) {
		dtc.setProjection(null);
		List<QuestionBean> list = (List<QuestionBean>) this.getHibernateTemplate().findByCriteria(dtc, begin, pageSize);
		
//		Session session = HibernateUtils.openSession();
//		Transaction tr = session.beginTransaction();
//		String hql = "from QuestionBean order by addTime desc";
//		Query query = session.createQuery(hql);
//		query.setFirstResult(currentPage);
//		query.setMaxResults(pageSize);
//		List<QuestionBean> list =query.list();
		
		
//		Criteria c = session.createCriteria(QuestionBean.class);
//		c.setProjection(null);
////		c.add((Criterion) dtc);
//		c.setFirstResult(currentPage);
//		c.setMaxResults(pageSize);
//		c.addOrder(Order.desc("addTime"));
//		List<QuestionBean> list = c.list();
//		tr.commit();
//		session.close();
		return list;
	}

	//����qid������ϸ��ѯ
	@Override
	public QuestionBean findUUID(Integer qid) {
		return this.getHibernateTemplate().get(QuestionBean.class, qid);
	}


	//ͳ�����д���ͼƬ����Ŀ���ܼ�¼��
	@Override
	public Integer getImaTotalCount() {
		String sql = "from QuestionBean where imagepath is not null";
		Session session = HibernateUtils.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(sql);
		List<QuestionBean> list =  query.list();
		tr.commit();
		session.close();
		return list.size();
	}
	
	//��ѯ���д�ͼƬ����Ŀ���Լ��Ϸ���
	@Override
	public List<QuestionBean> findByIma(Integer begin, Integer pageSize) {
		String sql = "from QuestionBean where imagepath is not null";
		Session session = HibernateUtils.openSession();
		Transaction tr = session.beginTransaction();
		Query query = session.createQuery(sql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<QuestionBean> list =  query.list();
		tr.commit();
		session.close();
		return list;
	}

	//�õ�����Ŀ���ʱ��������˳������ļ���
	@Override
	public List<QuestionBean> getAll(Integer begin, Integer pageSize) {
		Session session = HibernateUtils.openSession();
		Transaction tr = session.beginTransaction();
		String hql = "from QuestionBean order by addTime desc";
		Query query = session.createQuery(hql);
		query.setFirstResult(begin);
		query.setMaxResults(pageSize);
		List<QuestionBean> list =query.list();
		tr.commit();
		session.close();
		return list;
	}

	//�õ����е���Ŀ����
	@Override
	public Integer getTotalCount() {
		Session session = HibernateUtils.openSession();
		Transaction tr = session.beginTransaction();
		String hql = "from QuestionBean";
		Query query = session.createQuery(hql);
		List<QuestionBean> list =query.list();
		tr.commit();
		session.close();
		return list.size();
	}

	//ɾ������
	@Override
	public void delete(QuestionBean questionBean) {
		this.getHibernateTemplate().delete(questionBean);
		
	}


	//�첽�����жϹ���Ա�˺��Ƿ����
	@Override
	public AdminBean findAdminByname(String adminname) {
		Session session = HibernateUtils.openSession();//��ȡsession
		Transaction transaction = session.beginTransaction();//��������
		
		String sql = "select * from admintable where adminname = ?";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setParameter(0, adminname);
		sqlQuery.addEntity(AdminBean.class);
		List<AdminBean> list = sqlQuery.list();
		
		transaction.commit();//�ύ����
		
		if(list.size() > 0){
			return list.get(0);
		}
		
		session.close();//�ر�session
		return null;
	}

	/*//�õ������û����ܼ�¼��
	@Override
	public Integer getUserTotalCount(DetachedCriteria dtc) {
		dtc.setProjection(Projections.rowCount());
		List<Long> count = (List<Long>) this.getHibernateTemplate().findByCriteria(dtc);
		if(count.size() > 0){
			return count.get(0).intValue();
		}
		return 0;
	}

	//��������ѯ����ҳ�û��ķ���
	@Override
	public List<User> findUserByPage(DetachedCriteria dtc,
			Integer begin, Integer pageSize) {
		dtc.setProjection(null);
		List<User> list = (List<User>) this.getHibernateTemplate().findByCriteria(dtc, begin, pageSize);
		return list;
	}*/
}
