package cn.itcast.exam.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.core.util.UuidUtil;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import cn.itcast.exam.domain.AdminBean;
import cn.itcast.exam.domain.PageBean;
import cn.itcast.exam.domain.QuestionBean;
import cn.itcast.exam.domain.User;
import cn.itcast.exam.service.AdminService;
import cn.itcast.exam.utils.MysubString;
import cn.itcast.exam.utils.UploadUtil;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<QuestionBean> {
	private QuestionBean questionBean = new QuestionBean();
	
	public void setQuestionBean(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}

	@Override
	public QuestionBean getModel() {
		// TODO Auto-generated method stub
		return questionBean;
	}
	
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

	//�ṩ��ǰҳ��ÿҳ��ʾ����������
	private Integer currentPage = 1;
	private Integer pageSize = 5;
	
	public void setCurrentPage(Integer currentPage) {
		if(currentPage == null){
			currentPage = 1 ;
		}
		this.currentPage = currentPage;
	}

	public void setPageSize(Integer pageSize) {
		if(pageSize == null){
			pageSize = 5 ;
		}
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	//ע��AdminService
	private AdminService adminService;
	
	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	//ǰ����̨�����¼��ҳ��
	public String toAdminLoginUI(){
		return "toAdminLoginUI";
	}
	
	//�첽�����жϹ���Ա�˺��Ƿ����
	public String checkName() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String adminname = request.getParameter("adminname");
		AdminBean admin = adminService.findAdminByname(adminname);
		if(admin != null){
			//˵������Ա�˺Ŵ���
			ServletActionContext.getResponse().getWriter().print(1);
		}else{
			ServletActionContext.getResponse().getWriter().print(2);
		}
		return NONE;
	}
	//����Ա��¼�ķ���
	public String adminLogin() throws IOException{
		HttpServletRequest request = ServletActionContext.getRequest();
		String adminname = request.getParameter("adminname");
		String adminpassword = request.getParameter("adminpassword");
		AdminBean admin = new AdminBean(adminname,adminpassword);
		AdminBean loginAdmin = adminService.adminLogin(admin);
		if(loginAdmin != null){
			//��½�ɹ�
			ServletActionContext.getResponse().getWriter().print(1);
		}else{
			ServletActionContext.getResponse().getWriter().print(2);
		}
		ServletActionContext.getRequest().getSession().setAttribute("exitAdmin", loginAdmin);
		return NONE;
	}
	//�û��˳���¼
	public String logout(){
		ServletActionContext.getRequest().getSession().removeAttribute("exitAdmin");
		return "toIndexUI";
	}
	//����Ա��¼�ɹ���ת��̨����ҳ�����ҳ
	public String toIndexUI(){
		return "toIndexUI";
	}
	//��ת�������Ľ���
	public String toAddQuestionUI(){
		return "toAddQuestionUI";
	}
	//�������ķ���
	public String save() throws IOException{
		if(upload != null){
			//����ϴ��ļ��Ϊ�գ�������·��
//			String path = "E://examOnline_img";
			String path = ServletActionContext.getServletContext().getRealPath("/examOnline_img/");
			//�õ�Ψһ�ļ���
			String uuidFileName = UploadUtil.getUuid(uploadFileName);
			String realPath = UploadUtil.getPath(uuidFileName);
			String url = path+realPath;
			File file = new File(url);
			if(!file.exists()){
				file.mkdirs();
			}
			File file2 = new File(url+"/"+uuidFileName);
			FileUtils.copyFile(upload, file2);
			questionBean.setImagepath("examOnline_img"+realPath+"/"+uuidFileName);
			System.out.println("�ϴ��ɹ�");
		}
		System.out.println("ͼƬ�ϴ���·����:"+questionBean.getImagepath());
		String daAn = questionBean.getAnswer().toString().replace(", ", "");//���𰸸�Ϊ�ַ���
		questionBean.setAnswer(daAn);
		//���������Ŀ��ʱ��
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		questionBean.setAddTime(sdf.format(new Date()));
		adminService.save(questionBean);
		return "toFindAll";
	}
	
	//������ѯ
	public String findByPage(){
		
		DetachedCriteria dtc = DetachedCriteria.forClass(QuestionBean.class);
		
		//�鿴���е�ѡ������ж�����߶�ѡ��
		if(questionBean.getCid() != null ){
			if(!questionBean.getCid().equals("")){
				dtc.add(Restrictions.eq("cid", questionBean.getCid()));
				ServletActionContext.getRequest().getSession().setAttribute("cid", questionBean.getCid());
			}
		}
		
		PageBean<QuestionBean> pageBean = adminService.find(dtc,currentPage,pageSize);
		List<QuestionBean> list2 = pageBean.getList();
		
		//��ȡ�ַ���,����Ŀ�������ݳ��ȹ����������...����ʽչ��
		List<QuestionBean> list = MysubString.subStringWord(pageBean.getList());
		
		pageBean.setList(list);
		//��pageBean����ֵջ��
		//ActionContext.getContext().getValueStack().push(pageBean);
		
		ServletActionContext.getRequest().getSession().setAttribute("pageBean", pageBean);
		return "findAll";
	}
	//��ϸ��ѯ
	public String findByUUID(){
		questionBean = adminService.findByUUID(questionBean.getQid());
		ServletActionContext.getRequest().getSession().setAttribute("questionBean", questionBean);
		return "findByUUID";
	}
	
	//�鿴����ͼƬ
	public String findByIma(){
		PageBean<QuestionBean> pageBean = adminService.findByIma(currentPage,pageSize);
		//��ȡ�ַ���,����Ŀ�������ݳ��ȹ����������...����ʽչ��
		List<QuestionBean> list = MysubString.subStringWord(pageBean.getList());
				
		pageBean.setList(list);
		ServletActionContext.getRequest().getSession().setAttribute("pageBean", pageBean);
		return "findAll";
		
	}
	
	//�鿴����ͼƬ
		public String getAll(){
			System.out.println("getAll����ִ����");
			PageBean<QuestionBean> pageBean = adminService.getAll(currentPage,pageSize);
			//��ȡ�ַ���,����Ŀ�������ݳ��ȹ����������...����ʽչ��
			List<QuestionBean> list = MysubString.subStringWord(pageBean.getList());
			
			pageBean.setList(list);
			ServletActionContext.getRequest().getSession().setAttribute("pageBean", pageBean);
			return "theAll";
			
		}
	//ɾ����Ŀ
	public String delete(){
		questionBean = adminService.findByUUID(questionBean.getQid());
		adminService.delete(questionBean);
		return "toFindAll";
	}
	
	/*//�޸���Ŀ
	public String toEdictPage(){
		System.out.println("�޸ĵ�id��:"+questionBean.getQid());
		questionBean = adminService.findByUUID(questionBean.getQid());
		String[] s = questionBean.getAnswer().split("");
		List<String> list = new ArrayList<String>();
		for (String string : s) {
			string = "\""+string+"\"";
			list.add(string);
		}
		String[] strings = list.toArray(questionBean.getS());
		questionBean.setS(strings);
		System.out.println(questionBean);
		ServletActionContext.getRequest().getSession().setAttribute("questionBean", questionBean);
		return "edictPage";
	}*/
	
	/*//�鿴�����û��б�
	public String findAllUser(){
		System.out.println("ִ�в�ѯ�����û��ķ���");
		HttpServletRequest request = ServletActionContext.getRequest();
		DetachedCriteria dtc = DetachedCriteria.forClass(User.class);
		String uid = request.getParameter("uid");
		String username = request.getParameter("username");
		//�����ѯ�û���id�˺Ų�Ϊ��
		if(uid != null){
			
		}
		PageBean<User> pageBean = adminService.findUser(dtc,currentPage,pageSize);
		ServletActionContext.getRequest().getSession().setAttribute("pageBean", pageBean);
		return "toUserList";
	}*/
}
