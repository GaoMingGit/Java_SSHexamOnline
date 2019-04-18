package cn.itcast.exam.utils;

import java.util.Properties;
import java.util.UUID;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import cn.itcast.exam.domain.User;

public class SendMail{
private User user;
	
	public SendMail(User user) {
		super();
		this.user = user;
	}
	public void send(User user) throws MessagingException{
		Properties prop = new Properties();
		prop.setProperty("mail.smtp.host", "smtp.qq.com");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.auth", "true");// �Ƿ���Ȩ�޿���
		prop.setProperty("mail.transport", "smtp");// ���͵�Э���Ǽ򵥵��ʼ�����Э��
		prop.setProperty("mail.debug", "true");// true ��ӡ��Ϣ������̨
		prop.setProperty("mail.smtp.ssl.enable", "true");

		// ������֤��
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				// ���÷����˵��ʺź�����(��Ȩ����)
				// ע�ⷢ���ߵ�qq����ȥQQ���俪ͨȨ��
				return new PasswordAuthentication("1585168893@qq.com","zevjmjkqdthkhhch");
			}
		};
		Session session = Session.getInstance(prop,auth);
		Message message = createMail(session,user);
		//�����ʼ�
		Transport.send(message,message.getAllRecipients());
	}
	//�����ʼ�
	private Message createMail(Session session, User user) throws MessagingException {
		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress("1585168893@qq.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(user.getEmail()));
		message.setSubject("�����˺ŵļ�������");
//		//���弤����
//		String uuid = UUID.randomUUID().toString().replace("-", "");
		//���ü�������
		String url = "http://192.168.10.59:8080//examOnline/user_active.action?uuidcode="+user.getUuidcode();
		String content = "<h1>���ԡ�С�������Ŀ�����ģ�����ۿ�����վ���ļ����˺�����:���Ѿ��ɹ�ע���˺ţ������������<a href='"+url+"'>"+url+"</a>���м����˺�</h1>";
		System.out.println(content);
		message.setContent(content,"text/html;charset=UTF-8");
		message.saveChanges();
		return message;
	}
}
