package cn.itcast.exam.utils;

import java.util.ArrayList;
import java.util.List;

import cn.itcast.exam.domain.QuestionBean;

public class MysubString {
	public static List<QuestionBean> subStringWord(List<QuestionBean> list) {
		List<QuestionBean> subList = new ArrayList<QuestionBean>();
		for (QuestionBean questionBean : list) {
			// �������Ŀ��ѡ��A,B,C,D,����,������͵���Ŀ�������Ե��ַ������ȳ���10�ͽ�ȡ�ַ�
			if (questionBean.getQuestion().length() >= 10) {
				questionBean.setQuestion(questionBean.getQuestion().substring(0, 10)+"...");
			}

			if (questionBean.getSelect_a().length() >= 10) {
				questionBean.setSelect_a(questionBean.getSelect_a().substring(0, 10)+"...");
			}

			if (questionBean.getSelect_b().length() >= 10) {
				questionBean.setSelect_b(questionBean.getSelect_b().substring(0, 10)+"...");
			}

			if (questionBean.getSelect_c().length() >= 10) {
				questionBean.setSelect_c(questionBean.getSelect_c().substring(0, 10)+"...");
			}

			if (questionBean.getSelect_d().length() >= 10) {
				questionBean.setSelect_d(questionBean.getSelect_d().substring(0, 10)+"...");
			}

			if (questionBean.getDescc().length() >= 10) {
				questionBean.setDescc(questionBean.getDescc().substring(0, 10));
			}
			subList.add(questionBean);
		}
		return subList;

	}
}
