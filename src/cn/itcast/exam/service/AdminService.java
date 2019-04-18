package cn.itcast.exam.service;

import org.hibernate.criterion.DetachedCriteria;

import cn.itcast.exam.domain.AdminBean;
import cn.itcast.exam.domain.PageBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;

public interface AdminService {

	//��������ķ���
	void save(QuestionBean questionBean);

	//����chaxun
	PageBean<QuestionBean> find(DetachedCriteria dtc, Integer begin,Integer pageSize);

	QuestionBean findByUUID(Integer qid);

	PageBean<QuestionBean> findByIma(Integer begin, Integer pageSize);

	PageBean<QuestionBean> getAll(Integer begin, Integer pageSize);

	void delete(QuestionBean questionBean);

	//����Ա��¼
	AdminBean adminLogin(AdminBean admin);

	//�첽�����жϹ���Ա�˺��Ƿ����
	AdminBean findAdminByname(String adminname);

	//PageBean<User> findUser(DetachedCriteria dtc, Integer currentPage,Integer pageSize);

}
