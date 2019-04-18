package cn.itcast.exam.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;

public interface UserService {

	//�첽�������󣬼���û����Ƿ��Ѿ�����
	User checkUserName(String username);

	//�û�ע��ķ���
	void registUser(User user);
	
	//�û����м���ķ���
	User findActiveUser(String uuidCode);

	//���ļ������û���Ϣ
	void updateActiveUser(User active_user);

	//�û���¼����
	User loginUser(User user);

	//��ѯ�û�����ʷ�ɼ�
	ArrayList<PastScoreBean> getAllPastScore(User use);


	//�޸��û���Ϣ
	void updateUser(User user);

	//��ѯ�û�
	User findUser(Integer uid);

	//�޸��û�����
	int updateUserPwd(User nowLoginUser);

}
