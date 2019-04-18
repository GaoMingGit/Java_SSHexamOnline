package cn.itcast.exam.service.impl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import cn.itcast.exam.dao.Examdao;
import cn.itcast.exam.dao.impl.ExamdaoImpl;
import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.ExamService;

@Transactional
public class ExamServiceImpl implements ExamService {

	//ע��Examdao
	private Examdao examDao = new ExamdaoImpl();

	public Examdao getExamDao() {
		return examDao;
	}

	public void setExamDao(Examdao examDao) {
		this.examDao = examDao;
	}
	
	//�����Ŀһ���߿�Ŀ�ĵ���ϰ��Ŀ�ĳ���Ŀ����
		@Override
		public ArrayList<QuestionBean> keMuLianXi(Integer number) {
			return (ArrayList<QuestionBean>) examDao.keMuLianXi(number);
		}

		//����idȥ���ݿ���Ҷ�Ӧ����Ŀ���Լ�����ʽ����
		@Override
		public ArrayList<QuestionBean> getWrongList(Map<Integer, String> wrongMap) {
			return examDao.getWrongList(wrongMap);
		}
		
		//Ϊ��ǰ�û������ʷ�ɼ�
		@Override
		public void addPastScore(PastScoreBean pastScoreBean) {
			examDao.addPastScore(pastScoreBean);
		}
		//�û�����Ҫ�Ĵ�����ӵ����⼯�ϵķ���
		@Override
		public int addWrong(User nowLoginUser, int qid) {
			return examDao.addWrong(nowLoginUser,qid);
			
		}

		//�û��鿴���⼯�ϵķ���
		@Override
		public ArrayList<QuestionBean> lookWrongQuestion(User nowLoginUser) {
			return examDao.lookWrongQuestion(nowLoginUser);
		}
}
