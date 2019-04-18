package cn.itcast.exam.action;


import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.exam.domain.PageBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.AdminServiceDouser;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction_doUser extends ActionSupport implements
		ModelDriven<User> {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// �ṩ��ǰҳ��ÿҳ��ʾ����������
	private Integer currentPage = 1;
	private Integer pageSize = 5;

	public void setCurrentPage(Integer currentPage) {
		if (currentPage == null) {
			currentPage = 1;
		}
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		if (pageSize == null) {
			pageSize = 5;
		}
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	// ע��AdminService
	private AdminServiceDouser adminServiceDouser;

	public AdminServiceDouser getAdminServiceDouser() {
		return adminServiceDouser;
	}

	public void setAdminServiceDouser(AdminServiceDouser adminServiceDouser) {
		this.adminServiceDouser = adminServiceDouser;
	}

	// �鿴�����û��б�
	public String findAllUser() {
		System.out.println("ִ�в�ѯ�����û��ķ���");
		DetachedCriteria dtc = DetachedCriteria.forClass(User.class);
		// �����ѯ�û���id�˺Ų�Ϊ��
		
		if (user.getUid() != null) {
			dtc.add(Restrictions.eq("uid", user.getUid()));
		}
		//�����ѯ�û����˺Ų�Ϊ��
		if(user.getUsername() != null){
			dtc.add(Restrictions.like("username", "%"+user.getUsername()+"%"));
		}
		//�����ѯ�û���״̬�����б�Ϊ��
		if(user.getState() != null){
			dtc.add(Restrictions.eq("state", user.getState()));
		}
		System.out.println("�û��˺�id��"+user.getUid()+" �˺�:"+user.getUsername()+"  �û��˺�״̬:"+user.getState());
		PageBean<User> pageBean = adminServiceDouser.findUser(dtc, currentPage,
				pageSize);
		ServletActionContext.getRequest().getSession()
				.setAttribute("pageBean", pageBean);
		return "toUserList";
	}

}
