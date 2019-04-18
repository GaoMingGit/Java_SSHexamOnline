package cn.itcast.exam.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.exam.dao.Userdao;
import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.UserService;
@Transactional
public class UserServiceImpl implements UserService {
	private Userdao userDao;

	public void setUserDao(Userdao userDao) {
		this.userDao = userDao;
	}
	
	public Userdao getUserDao() {
		return userDao;
	}


	//�첽�������󣬼���û����Ƿ��Ѿ�����
	@Override
	public User checkUserName(String username) {
		return userDao.checkUserName(username);
	}
	//�û�ע��ķ���
	@Override
	public void registUser(User user) {
		userDao.registUser(user);
		
	}

	//�û����м���ķ���
	@Override
	public User findActiveUser(String uuidCode) {
		return userDao.findActiveUser(uuidCode);
	}

	//���ļ������û���Ϣ
	@Override
	public void updateActiveUser(User active_user) {
		userDao.updateActiveUser(active_user);
	}

	//�û���¼�ķ���
	@Override
	public User loginUser(User user) {
		return userDao.loginUser(user);
	}


	//��ѯ�û�����ʷ�ɼ�
	@Override
	public ArrayList<PastScoreBean> getAllPastScore(User user) {
		return userDao.getAllPastScore(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public User findUser(Integer uid) {
		return userDao.findUser(uid);
	}

	//�޸��û�����
	@Override
	public int updateUserPwd(User nowLoginUser) {
		return userDao.updateUserPwd(nowLoginUser);
	}
}
