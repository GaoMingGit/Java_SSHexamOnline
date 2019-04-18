package cn.itcast.exam.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.itcast.exam.domain.PastScoreBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.UserService;
import cn.itcast.exam.utils.MD5Utils;
import cn.itcast.exam.utils.MyNumber;
import cn.itcast.exam.utils.SendMail;
import cn.itcast.exam.utils.SendMailCode;
import cn.itcast.exam.utils.UploadUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private UserService userService;
	//����һ�����ֱ�ʶ����jspҳ���д����������� 1 �����ǿ�Ŀһ��ϰ��4 ���� ��Ŀ����ϰ
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
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	public UserService getUserService() {
		return userService;
	}
	
	//�û��ϴ�ͷ�����õ�����
	private String uploadFileName;
	private File upload;
	private String uploadContentType;

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	
	
	//�첽�������󣬼���û����Ƿ��Ѿ�����
	public String checkName() throws IOException{
		user = userService.checkUserName(user.getUsername());
		HttpServletResponse response = ServletActionContext.getResponse();
		if(user != null){
			//������ص�user��Ϊ�գ�˵���û����Ѿ���ע��
			response.getWriter().print(2);
		}else{
			//������ص�userΪ�գ�˵���û���û�б�ע�ᣬ������
			response.getWriter().print(1);
		}
		return NONE;
	}

	//ǰ��ע��ҳ��
	public String toRegistUI(){
		return "toRegistUI";
	}
	//ǰ��ע��ҳ��
	public String toLoginUI(){
		return "login";	
	}
		
	//�û�ע��ķ���
	public String regist(){
		user.setState(0);//�����û����˺�״̬Ϊ0������û����״̬��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String registTime = sdf.format(new Date());
		user.setRegisttime(registTime);//�����û�ע���ʱ��
		//Ϊ�û����ü�����
		user.setUuidcode(UUID.randomUUID().toString().replace("-", ""));
		//Ϊ�û���������MD5����
		String md5 = MD5Utils.md5(user.getPassword());
		user.setPassword(md5);
		userService.registUser(user);
		this.addActionMessage("��ϲ����ע��ɹ����������һ�⼤���˺��ʼ��������������У�������ʼ�ǰȥ�����˺�");
//		ServletActionContext.getRequest().setAttribute("message", "��ϲ����ע��ɹ����������һ�⼤���˺��ʼ��������������У�������ʼ�ǰȥ�����˺�");
		//�������̸߳��û������䷢�ͼ�����
		SendMail sendMail = new SendMail(user);
		try {
			sendMail.send(user);
		} catch (MessagingException e) {
//			ServletActionContext.getRequest().getSession().setAttribute("message", "�ʼ�����ʧ�ܣ����������޷����ʼ��ķ�����");
			this.addActionMessage("�ʼ�����ʧ�ܣ����������޷����ʼ��ķ�����");
			e.printStackTrace();
		}finally{
			return "toEmail";
		}
	}
	
	//�ж��û�����������Ƿ����
	public String checkEmail() throws IOException{
		HttpServletResponse response = ServletActionContext.getResponse();
		//�õ��˺��������˺�,ȥ���ݿ�����û�
		User resetPwdUser = userService.checkUserName(ServletActionContext.getRequest().getParameter("username"));
		ServletActionContext.getRequest().getSession().setAttribute("resetPwdUser", resetPwdUser);
		//�õ���������������
		String email = ServletActionContext.getRequest().getParameter("email");
		if(email.equals(resetPwdUser.getEmail())){
			//���������ȣ�˵���������
			response.getWriter().print(1);
		}else{
			//������䲻��ȣ�˵�����䲻����
			response.getWriter().print(2);
		}
		return NONE;
	}
	
	//�����ʼ���֤����û��޸�����
	public String sendEmailCode() throws IOException{
		//���������֤��
		int emaliCode = (int) (Math.random() * 10000+1);
		//�õ��û����ڵ�email
		User user1 = (User) ServletActionContext.getRequest().getSession().getAttribute("resetPwdUser");
		//��ס������֤��
		
		user1.setEmailcode(String.valueOf(emaliCode));
		ServletActionContext.getRequest().getSession().setAttribute("emailCode", user1.getEmailcode());
		SendMailCode sendMail = new SendMailCode(user1);
		try {
			sendMail.send(user1);
			ServletActionContext.getResponse().getWriter().print(1);
		} catch (MessagingException e) {
			//ServletActionContext.getRequest().setAttribute("message", "�ʼ�����ʧ�ܣ����������޷����ʼ��ķ�����");
			ServletActionContext.getResponse().getWriter().print(2);
			e.printStackTrace();
		}
		return NONE;
	}
	
	//�����û�����
	public String resetUserPwd() throws IOException{
		User resetPwdUser = userService.checkUserName(user.getUsername());
		//�õ�������֤��
		String emaliCode = (String) ServletActionContext.getRequest().getSession().getAttribute("emailCode");
		//�õ��û����û������������֤��
		String formEmaliCode = user.getEmailcode();
		//�ٴ��ж��û���email�Ƿ�һ��
		if(!resetPwdUser.getEmail().equals(user.getEmail())){
			this.addActionMessage("�������䲻��ע���˺�Ԥ�������䣬����ʧ��");
			return "toEmail";
		}
		
		if(emaliCode.equals(formEmaliCode)){
			//�����ȣ������޸�����
			resetPwdUser.setPassword(MD5Utils.md5(user.getPassword()));
			userService.updateUserPwd(resetPwdUser);
			this.addActionMessage("�����û��˺�����ɹ��������Ե�¼�˺�������!!!");
			return "toEmail";
		}else{
			this.addActionMessage("������֤����������û�����ʧ�ܣ���ȥ����鿴������֤��");
			return "toEmail";
		}
	}
	
	//�û����м���ķ���
	public String active(){
		//�õ�����������ӵļ�����
		String uuidCode = user.getUuidcode();
		//���ݼ�����鵽��Ψһ���û�
		User active_user = userService.findActiveUser(uuidCode);
		if(active_user != null){
			//������ݼ������ҵ��û���Ϊ�գ�˵���û����Լ���
			active_user.setUuidcode(null);
			active_user.setState(1);
			userService.updateActiveUser(active_user);
			//this.addActionMessage("��ϲ�����˺ż���ɹ�����ǰȥ��½,��һ����˾����������");
//			//this.addActionError("��ϲ�����˺ż���ɹ�����ǰȥ��½,��һ����˾����������");
			ServletActionContext.getRequest().setAttribute("message", "��ϲ�����˺ż���ɹ�����ǰȥ��¼,��һ����˾����������");
			return "toEmail";
		}else{
			//������ݼ������ҵ��û�Ϊ�գ�˵���û��Ѿ������ˣ���ʱҪ��֪�û��˺��Ѿ�����
			ServletActionContext.getRequest().setAttribute("message", "�ף������˺���ǰ�Ѿ������ˣ����������ټ����ֱ�ӵ�¼�˺�");
			//this.addActionMessage("�ף������˺���ǰ�Ѿ������ˣ����������ټ����ֱ�ӵ�¼�˺�");
			return "toEmail";
		}
	}
	
	//�û���¼����
	public String login() throws IOException{
		//У���û���¼������
		user.setPassword(MD5Utils.md5(user.getPassword()));
		User exitUser = userService.loginUser(user);
		//����û���Ϊ�գ�˵���˺ź�������ȷ
		if(exitUser != null && exitUser.getState() == 1){
			ServletActionContext.getRequest().getSession().setAttribute("exitUser", exitUser);
			return "toUserMsg";
		}else if(exitUser != null && exitUser.getState() == 0){
			//����û���״̬Ϊ 0 ��˵���û����˺Ż�û����
			//this.addActionError("������˼�������˺Ż�û�����㱾����ǰȥ�������������Ӽ���");
			ServletActionContext.getRequest().getSession().setAttribute("jihou", "������˼�������˺Ż�û�����ǰȥ�������������Ӽ���");
			return "login";
		}else{
			//����û�Ϊ�գ�˵���˺Ż����������
			//this.addActionMessage("������˼�������˺Ż�����������!!!");
			ServletActionContext.getRequest().getSession().setAttribute("message", "������˼�������˺Ż�����������!!!");
			return "login";
		}
	}
	
	//�鿴�û�������ϢtoUserMessageUI
	public String getUserMessage(){
		//�鿴��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		ServletActionContext.getRequest().getSession().setAttribute("exitUser", nowLoginUser);
		return "toUserMsg";
	}
	
	//��ת�޸��û���Ϣҳ��
	public String toUserMessageUI(){
		//�鿴��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		ServletActionContext.getRequest().getSession().setAttribute("exitUser", nowLoginUser);
		return "toUpdateUserUI";
	}
	
	//�޸��û���Ϣ
	public String updateUser() throws IOException{
		//�޸��û�ԭ��,�Ȳ��ҳ���ǰ�û�,���޸�
		System.out.println("Ҫ�޸��û���id"+user.getUid());
		//�鿴��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		if(upload != null){
			// ����ϴ��ļ��Ϊ�գ�������·��
			// String path = "E://examOnline_img";
			String path = ServletActionContext.getServletContext().getRealPath(
					"/userHeader/");
			// �õ�Ψһ�ļ���
			String uuidFileName = UploadUtil.getUuid(uploadFileName);
			//String realPath = UploadUtil.getPath(uuidFileName);//ͨ�����÷���ȥ����Ŀ¼
//			String url = path + realPath;
//			String url = path;
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			File file2 = new File(path + "/" + uuidFileName);
			FileUtils.copyFile(upload, file2);
			nowLoginUser.setImagepath("userHeader" + "/" + uuidFileName);
		}
		nowLoginUser.setSchool(user.getSchool());
		nowLoginUser.setEmail(user.getEmail());
		nowLoginUser.setPhone(user.getPhone());
		userService.updateUser(nowLoginUser);
        
       ServletActionContext.getRequest().getSession().setAttribute("message", "�޸���Ϣ�ɹ��������µ�¼!!!�ɿ����޸�Ч��");
		//this.addActionMessage("�޸���Ϣ�ɹ��������µ�¼!!!�ɿ����޸�Ч��");
		return "login";
	}
	//�û��˳���¼
	public String logout(){
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().removeAttribute("exitUser");
		return "toIndex";
	}
	
	//ǰ���޸��û��������
	public String toUpdatePwdUI(){
		return "updateUserPwdUI";
	}
	
	//У���û���ԭʼ����
	public String checkPwd() throws IOException{
		//�鿴��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		//�õ��û������ԭʼ����
		String pastPwd = ServletActionContext.getRequest().getParameter("password");
		//��������MD5���ܺ�͵�ǰ�û����������
		String md5Pwd = MD5Utils.md5(pastPwd);
		if(md5Pwd.equals(nowLoginUser.getPassword())){
			ServletActionContext.getResponse().getWriter().print(1);
		}else{
			ServletActionContext.getResponse().getWriter().print(2);
		}
		return NONE;
	}
	//�޸��û�����
	public String updateUserPwd() throws IOException{
		//�鿴��ǰ��¼���û�
		User nowLoginUser = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		//�õ��û�������������ֵ
		String pwd = ServletActionContext.getRequest().getParameter("newpassword");
		//Ϊ�û������µ�����
		nowLoginUser.setPassword(MD5Utils.md5(pwd));
		int result = userService.updateUserPwd(nowLoginUser);
		if(result > 0 ){
			//��������1�����û������ԭʼ��������ȷ��
			ServletActionContext.getResponse().getWriter().print(1);
		}else{
			//��������2�����û������ԭʼ��������ȷ��
			ServletActionContext.getResponse().getWriter().print(2);
		}
		return NONE;
	}
	
	//�û���������Ҫ��������ķ���
	public String toResetPwd(){
		
		return "login";
	}
	// �û��鿴��ʷ�ɼ�
	public String lookPastScore() {
		// ��ѯ��ǰ��¼���û�
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("exitUser");
		ArrayList<PastScoreBean> pastScoreList = userService.getAllPastScore(user);
		ServletActionContext.getRequest().getSession().setAttribute("pastScoreList", pastScoreList);
		// ���û���һ�ε�¼ע����վʱ��û����ʷ�ɼ�����ʱҪ��֪�û�
		ServletActionContext.getRequest().getSession().setAttribute("size", pastScoreList.size());
		return "toPastScorePage";
	}
}
