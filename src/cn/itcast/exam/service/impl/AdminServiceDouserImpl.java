package cn.itcast.exam.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import cn.itcast.exam.dao.AdmindaoDouser;
import cn.itcast.exam.domain.PageBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.AdminServiceDouser;
@Transactional
public class AdminServiceDouserImpl implements AdminServiceDouser {
	private AdmindaoDouser adminDaoDouser;

	public AdmindaoDouser getAdminDaoDouser() {
		return adminDaoDouser;
	}

	public void setAdminDaoDouser(AdmindaoDouser adminDaoDouser) {
		this.adminDaoDouser = adminDaoDouser;
	}

	@Override
	public PageBean<User> findUser(DetachedCriteria dtc, Integer currentPage,
			Integer pageSize) {
		PageBean<User> pageBean = new PageBean<User>();
		//���õ�ǰҳ
		pageBean.setCurrentPage(currentPage);
		
		Integer totalCount = adminDaoDouser.getUserTotalCount(dtc);
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
		List<User> list = adminDaoDouser.findUserByPage(dtc, begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}
	
}
