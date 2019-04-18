package cn.itcast.exam.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;

public interface Userdao {

	//�첽�������󣬼���û����Ƿ��Ѿ�����
	User checkUserName(String username);
	
	//�û�ע��ķ���
	void registUser(User user);

	//�û����м���ķ���
	User findActiveUser(String uuidCode);

	//���ļ������û���Ϣ
	void updateActiveUser(User active_user);

	//�û���¼����Ϣ
	User loginUser(User user);


	////��ѯ�û�����ʷ�ɼ�
	ArrayList<PastScoreBean> getAllPastScore(User user);


	//�޸��û�����Ϣ
	void updateUser(User user);

	//��ѯ�û�
	User findUser(Integer uid);

	//�޸��û�����
	int updateUserPwd(User nowLoginUser);

}
