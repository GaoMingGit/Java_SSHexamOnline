package cn.itcast.exam.interceptor;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import cn.itcast.exam.domain.User;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class PriviledgeInterceptor extends MethodFilterInterceptor{

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		//�ж�session���Ƿ�����û�
		User user = (User)ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		if(user == null){
			//û�е�¼
			//������ʾ��Ϣ
			//��ת��¼ҳ��
			ActionSupport action = (ActionSupport) invocation.getAction();
			ServletActionContext.getRequest().getSession().setAttribute("message", "������˼������û��¼��û�з���Ȩ��!!!");
			action.addActionError("������˼������û��¼��û�з���Ȩ��!!!");
			return action.LOGIN;
		}else{
			return invocation.invoke();
		}
	}

}
