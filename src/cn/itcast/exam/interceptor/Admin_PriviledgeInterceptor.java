package cn.itcast.exam.interceptor;

import org.apache.struts2.ServletActionContext;

import cn.itcast.exam.domain.AdminBean;
import cn.itcast.exam.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class Admin_PriviledgeInterceptor extends MethodFilterInterceptor {
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�session���Ƿ�����û�
		AdminBean admin = (AdminBean)ServletActionContext.getRequest().getSession().getAttribute("exitAdmin");
		if(admin == null){
			//û�е�¼
			//������ʾ��Ϣ
			//��ת��¼ҳ��
			ActionSupport action = (ActionSupport) invocation.getAction();
			ServletActionContext.getRequest().getSession().setAttribute("message1", "������˼������û��¼��û�з���Ȩ��!!!");
			//action.addActionMessage("������˼����û�з���Ȩ��!!!���ù���Ա�˺ŵ�¼!!!");
			return action.LOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
