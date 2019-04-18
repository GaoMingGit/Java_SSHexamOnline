package cn.itcast.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.exam.dao.Admindao;
import cn.itcast.exam.domain.AdminBean;
import cn.itcast.exam.domain.PageBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.AdminService;
@Transactional
public class AdminServiceImpl implements AdminService {
	//ע��adminDao
	private Admindao adminDao;
	
	public void setAdminDao(Admindao adminDao) {
		this.adminDao = adminDao;
	}

	//��������ķ���
	@Override
	public void save(QuestionBean questionBean) {
		System.out.println("service����ִ����");
		adminDao.save(questionBean);
	}

	//������ѯ
	@Override
	public PageBean<QuestionBean> find(DetachedCriteria dtc,Integer currentPage, Integer pageSize) {
		PageBean<QuestionBean> pageBean = new PageBean<QuestionBean>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//����ÿҳ��ʾ�Ĵ�С
		pageBean.setPageSize(pageSize);
		Integer totalCount = adminDao.getCount(dtc);
		//��������Ŀ
		pageBean.setTotalCount(totalCount);
		Double tc = totalCount.doubleValue();
		Double totalPage = Math.ceil(tc / pageSize);
		//������ҳ��
		pageBean.setTotalPage(totalPage.intValue());
		//���÷���������ѯ�ļ��϶���
		//��װÿһҳ������
		Integer begin = (currentPage - 1) * pageSize;
		List<QuestionBean> list = adminDao.findByPage(dtc,begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	//����qid������ϸ��ѯ
	@Override
	public QuestionBean findByUUID(Integer qid) {
		return adminDao.findUUID(qid);
	}

	@Override
	public PageBean<QuestionBean> findByIma(Integer currentPage,Integer pageSize) {
		PageBean<QuestionBean> pageBean = new PageBean<QuestionBean>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		//����ÿҳ��ʾ�Ĵ�С
		pageBean.setPageSize(pageSize);
		
		Integer totalCount = adminDao.getImaTotalCount();
		System.out.println("�鵽ͼƬ����Ŀ������:"+totalCount);
		//��������Ŀ
		pageBean.setTotalCount(totalCount);
		Double tc = totalCount.doubleValue();
		Double totalPage = Math.ceil(tc / pageSize);
		//������ҳ��
		pageBean.setTotalPage(totalPage.intValue());
		Integer begin = (currentPage - 1) * pageSize;
		//���÷���������ѯ�ļ��϶���
		List<QuestionBean> list = adminDao.findByIma(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public PageBean<QuestionBean> getAll(Integer currentPage, Integer pageSize) {
		PageBean<QuestionBean> pageBean = new PageBean<QuestionBean>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		
		Integer totalCount = adminDao.getTotalCount();
		System.out.println("�鵽��Ŀ��������:"+totalCount);
		//����ÿҳ��ʾ�Ĵ�С
		pageBean.setPageSize(pageSize);
		//��������Ŀ
		pageBean.setTotalCount(totalCount);
		Double tc = totalCount.doubleValue();
		Double totalPage = Math.ceil(tc / pageSize);
		//������ҳ��
		pageBean.setTotalPage(totalPage.intValue());
		//���÷���������ѯ�ļ��϶���
		Integer begin = (currentPage - 1) * pageSize;
		List<QuestionBean> list = adminDao.getAll(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Override
	public void delete(QuestionBean questionBean) {
		adminDao.delete(questionBean);
		
	}

	//����Ա��¼
	@Override
	public AdminBean adminLogin(AdminBean admin) {
		return adminDao.adminLogin(admin);
	}

	//�첽�����жϹ���Ա�˺��Ƿ����
	@Override
	public AdminBean findAdminByname(String adminname) {
		// TODO Auto-generated method stub
		return adminDao.findAdminByname(adminname);
	}

	/*@Override
	public PageBean<User> findUser(DetachedCriteria dtc, Integer currentPage,
			Integer pageSize) {
		PageBean<User> pageBean = new PageBean<User>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		
		Integer totalCount = adminDao.getUserTotalCount(dtc);
		System.out.println("�鵽��Ŀ��������:"+totalCount);
		//��������Ŀ
		pageBean.setTotalCount(totalCount);
		Double tc = totalCount.doubleValue();
		Double totalPage = Math.ceil(tc / pageSize);
		// ������ҳ��
		pageBean.setTotalPage(totalPage.intValue());
		// ���÷���������ѯ�ļ��϶���
		// ��װÿһҳ������
		Integer begin = (currentPage - 1) * pageSize;
		List<User> list = adminDao.findUserByPage(dtc, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}*/
}
