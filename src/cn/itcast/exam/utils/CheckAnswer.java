package cn.itcast.exam.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import cn.itcast.exam.domain.QuestionBean;

public class CheckAnswer {
	
	private CheckAnswer(){}

	public static Double getScore(String[] user_answer,ArrayList<QuestionBean> list) {
		String userAnswer = "";//�������������ʾ��ǰĳһ����Ŀ���û���
		String sqlAnswer = "";//�������������ʾ��ǰ��ĳһ����Ŀ�����ݿ���ȷ�Ĵ�
		int index = 0;//���弯�ϵ�index
		Double score = (double) 0 ; //�����ֱܷ�������ʼ��Ϊ 0 ��
		Double i = Math.ceil(100 / list.size()); //����ÿһ����Ŀ�ķ�ֵ���ܷ�Ϊ100�֣����ֳܷ��Ե�ǰ��Ŀ���������ÿһ����Ŀ��ƽ����ֵ
		for (String string : user_answer) {
			userAnswer = string;
			sqlAnswer = list.get(index).getAnswer();
			if(userAnswer.equals(sqlAnswer)){
				//�����һ���ͼӷ���
				score = score + i;
			}
			userAnswer = "";
			index++;
		}
		return score;
	}

	public static Map<Integer, String> getWrongMap(String[] user_answer,ArrayList<QuestionBean> list) {
		Map<Integer,String> wrongMap = new HashMap<Integer,String>();
		String userAnswer = "";//�������������ʾ��ǰĳһ����Ŀ���û���
		String sqlAnswer = "";//�������������ʾ��ǰ��ĳһ����Ŀ�����ݿ���ȷ�Ĵ�
		int index = 0;//���弯�ϵ�index
		for (String string : user_answer) {
			userAnswer = string;
			sqlAnswer = list.get(index).getAnswer();
			if(userAnswer == null){
				//����û��Ĵ�Ϊ�գ�������û�û�д������Ŀ��ֱ�Ӱ������ӵ�Map������ ���� keyֵ����Ŀ��id �� value ֵ���û��Ĵ�
				wrongMap.put(list.get(index).getQid(), userAnswer);
				System.out.print("��������:"+list.get(index).getQid()+":  ");
				System.out.println("�û�����:"+userAnswer);
			}else if(!userAnswer.equals(sqlAnswer)){
				wrongMap.put(list.get(index).getQid(), userAnswer);
				System.out.print("��������:"+list.get(index).getQid()+":  ");
				System.out.println("�û�����:"+userAnswer);
			}
			
		}
		return wrongMap;
	};
}
