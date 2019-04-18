package cn.itcast.exam.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.exam.domain.AdminBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;

public interface Admindao {

	//��������ķ���
	void save(QuestionBean questionBean);

	//�õ�����������������
	int getCount(DetachedCriteria dtc);

	//������ѯ�õ��Ľ��
	List<QuestionBean> findByPage(DetachedCriteria dtc, Integer begin,Integer pageSize);

	//ͨ��id������Ŀ
	QuestionBean findUUID(Integer qid);

	//�������еĴ���Ƭ����Ŀ
	List<QuestionBean> findByIma(Integer begin, Integer pageSize);

	//�õ����е���Ŀ
	List<QuestionBean> getAll(Integer begin, Integer pageSize);

	//�õ����е���Ŀ����
	Integer getTotalCount();

	//�õ���ͼƬ��������Ŀ������
	Integer getImaTotalCount();

	//ɾ����Ŀ
	void delete(QuestionBean questionBean);

	//����Ա��¼
	AdminBean adminLogin(AdminBean admin);

	//�첽�����жϹ���Ա�˺��Ƿ����
	AdminBean findAdminByname(String adminname);

	/*//��ѯ�����û�������
	Integer getUserTotalCount(DetachedCriteria dtc);

	//��������ѯ����ҳ�û��ķ���
	List<User> findUserByPage(DetachedCriteria dtc, Integer begin,
			Integer pageSize);*/

}
