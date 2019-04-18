package cn.itcast.exam.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.ExamService;
import cn.itcast.exam.service.impl.ExamServiceImpl;
import cn.itcast.exam.utils.MyNumber;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ExamAction extends ActionSupport {

	// ע��ExamService
	private ExamService examService = new ExamServiceImpl();

	public ExamService getExamService() {
		return examService;
	}

	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	// �����Ŀһ���߿�Ŀ�ĵ���ϰ��Ŀ�ĳ���Ŀ����
	public String keMuLianXi() {
		System.out.println("ExamAction keMuLianXi����ִ��");
		String num = ServletActionContext.getRequest().getParameter("lei");
		Integer leiCode = Integer.parseInt(num);
		ArrayList<QuestionBean> list = (ArrayList<QuestionBean>) examService.keMuLianXi(leiCode);
		// ����Ŀ������������
		ArrayList<QuestionBean> questionList = MyNumber.toNumber(list);
		// //�����ݴ��浽ָջ��
		// ActionContext.getContext().getValueStack().push(questionList);
		ServletActionContext.getRequest().getSession()
				.setAttribute("questionList", questionList);
		// �������ֵ��ҳ����ʾ����Ŀ�Ŀ��ϰ����
		ServletActionContext.getRequest().getSession().setAttribute("num", num);
		return "toExercise";
	}

	// ����ǰ���û���Ϣȷ��
	public String toExamPageUI() {
		//�õ�request����
		HttpServletRequest request = ServletActionContext.getRequest();
		// �鿴��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		//�������������
		String userNmber = UUID.randomUUID().toString().replace("-", "");
		//�õ����Կ�Ŀ������־
		request.getSession().setAttribute("lei", request.getParameter("lei"));
		
		request.getSession().setAttribute("userNmber", userNmber);
		request.getSession().setAttribute("exitUser", nowLoginUser);
		request.getSession().setAttribute("message", "������˼������û��¼�˺ţ�û��Ȩ��");
		return "toExamPageUI";

	}
	
	// �����Ŀһ���߿�Ŀ�ĵĿ��Է���
	public String keMuExam() {
		System.out.println("ExamAction keMuExam����ִ��");
		String num = ServletActionContext.getRequest().getParameter("lei");
		Integer leiCode = Integer.parseInt(num);
		ArrayList<QuestionBean> list = (ArrayList<QuestionBean>) examService.keMuLianXi(leiCode);
		// ����Ŀ������������
		ArrayList<QuestionBean> questionList = MyNumber.toNumber(list);
		for (int i = 0; i < questionList.size(); i++) {
			System.out.println("���:" + questionList.get(i).getQid());
		}

		// //�����ݴ��浽ָջ��
		ActionContext.getContext().getValueStack().push(questionList);
		ServletActionContext.getRequest().getSession()
				.setAttribute("questionList", questionList);
		// �������ֵ��ҳ����ʾ����Ŀ�Ŀ���Եı���
		ServletActionContext.getRequest().getSession().setAttribute("num", num);

		return "toExam";
	}

	// У�Դ�
	public String checkAnswer() {
		System.out.println("ExamAction checkAnswer����ִ��");
		// �õ�������Ŀ�Ĵ�
		PastScoreBean pastScoreBean = new PastScoreBean();
		ArrayList<QuestionBean> list = (ArrayList<QuestionBean>) ServletActionContext.getRequest().getSession().getAttribute("questionList");
		// ��ȡ�û��Ĵ�
		// (���ڱ�ϵͳ���õ�ÿ�ο�����Ŀ��������20���⣬���Զ���ѭ���������ִ��20�Σ��Ϳɷֱ��õ��û��Ĵ�)
		/* for(int i = 1 ; i <= 20 ; i++){} */
		// ������list���ϴ�ŵ��Ǳ��ο��Ե��������ݣ����������������Ĵ𰸣�����˵�ж��ٵ�����ж�Ӧ�ж��ٸ���,
		// Ϊ�˷�����ڴ���Ľ�ά�������ü��ϵĴ�Сȥ����ѭ������
		String userAnswer = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		int index = 0;// ���弯�ϵ�index
		Double score = (double) 0; // �����ֱܷ�������ʼ��Ϊ 0 ��
		Double i = Math.ceil(100 / list.size()); // 5��һ��
													// ����ÿһ����Ŀ�ķ�ֵ���ܷ�Ϊ100�֣����ֳܷ��Ե�ǰ��Ŀ���������ÿһ����Ŀ��ƽ����ֵ
		// ����һ�����ϣ����û�������źʹ���ӵ�������
		Map<Integer, String> wrongMap = new HashMap<Integer, String>();
		for (QuestionBean bean : list) {
			// ѭ���õ�ÿһ����Ŀ���û��𰸣���ÿ���õ�һ���𰸾�У��һ�δ�
			String[] answer = request.getParameterValues(String.valueOf(list
					.get(index).getQid()));
			// �û��Ĵ𰸲�Ϊ�գ��ͽ��д�У��
			if (answer != null) {
				for (String string : answer) {
					// ����ѡ��Ĵ�ƴ�ӳ�������ĸ���ַ���=======���ABC�����ĸ�ʽ
					userAnswer = userAnswer + string;
				}
				if (userAnswer.equals(bean.getAnswer())) {
					score = score + i;
					System.out.println("�û���Ե����:" + list.get(index).getQid()
							+ "  �û��Ĵ𰸣�" + userAnswer);
				} else {
					// �û�������źʹ���ӵ�������
					wrongMap.put(list.get(index).getQid(), userAnswer);
				}
			} else {
				// �û�û������,�ͽ���żӵ���������ȥ
				wrongMap.put(list.get(index).getQid(), null);
			}
			userAnswer = "";
			if (index < list.size()) {
				index++;
			}
		}

		// ͳ���û������߲����������
		int wrongNumber = wrongMap.size();

		// ͳ���û���Ե�����
		int rightNumber = list.size() - wrongMap.size();

		// �û������߲�����������
		ServletActionContext.getRequest().getSession().setAttribute("wrongMap", wrongMap);
		System.out.println(score + "    " + wrongNumber + "  " + rightNumber);
		// �õ���ǰ���Ե��û�
		User user = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("exitUser");
		pastScoreBean.setWrongtotal(wrongNumber);
		pastScoreBean.setScore(score.intValue());
		pastScoreBean.setRighttotal(rightNumber);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		pastScoreBean.setExamtime(sdf.format(new Date()));
		pastScoreBean.setUser(user);
		ServletActionContext.getRequest().getSession()
				.setAttribute("pastScoreBean", pastScoreBean);
		// ��һ���̣߳��洢�û�����ʷ�ɼ�
		examService.addPastScore(pastScoreBean);
		return "toshow";
	}

	// �û��鿴����ķ���
	public String lookWrong() {
		System.out.println("ExamAction lookWrong����ִ��");
		// �õ��û��Ĵ��⼯��
		// ���ϵ�key�������ݿ��Ӧ����Ŀid��value��������û�����Ĵ�
		Map<Integer, String> wrongMap = (Map<Integer, String>) ServletActionContext.getRequest().getSession().getAttribute("wrongMap");
		// ����idȥ����ԭ��������
		ArrayList<QuestionBean> wrongList = examService.getWrongList(wrongMap);
		// ����һ�����ϴ���û���
		ArrayList<String> userWrongAnswer = new ArrayList<String>();
		ServletActionContext.getRequest().getSession()
				.setAttribute("wrongList", wrongList);
		return "toHistory";
	}

	// �û�����Ҫ�Ĵ�����ӵ����⼯�ϵķ���
	public String addWrong() throws IOException {
		System.out.println("ExamAction addWrong����ִ��");
		// ��ѯ��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest()
				.getSession().getAttribute("exitUser");
		// ��ȡ�û�ѡ�������Ŀ��id
		HttpServletRequest request = ServletActionContext.getRequest();
		int qid = Integer.parseInt(request.getParameter("id"));
		int result = examService.addWrong(nowLoginUser, qid);
		if (result == 1) {
			// �������1˵����ӳɹ�
			ServletActionContext.getResponse().getWriter().print(1);
		} else {
			// ������ز���1˵����Ӵ��ⲻ�ɹ�
			ServletActionContext.getResponse().getWriter().print(2);
		}
		return NONE;
	}

	// �û��鿴���⼯�ϵķ���
	public String lookWrongQuestion() {
		System.out.println("ExamAction lookWrongQuestion����ִ��");
		// ��ѯ��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest()
				.getSession().getAttribute("exitUser");
		ArrayList<QuestionBean> wrongQuestionBeanList = examService.lookWrongQuestion(nowLoginUser);
		for (QuestionBean questionBean : wrongQuestionBeanList) {
			System.out.println(nowLoginUser.getUsername() + "  �Ĵ��⼯��:"
					+ questionBean.getQid());
		}
		ServletActionContext.getRequest().getSession()
				.setAttribute("wrongQuestionBeanList", wrongQuestionBeanList);
		// ���û���һ�ε�¼ע����վʱ��û�д��⼯����ʱҪ��֪�û�
		ServletActionContext.getRequest().getSession()
				.setAttribute("size", wrongQuestionBeanList.size());
		return "toLookWrongQuestion";
	}
}
