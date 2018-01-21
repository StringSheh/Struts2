package com.itheima.test;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

/**
 * 演示JavaMail发送邮件
 * 
 * @author lenovo
 *
 */
public class MailDemo {

	// 发送基本的邮件
	@Test
	public void test1() throws Exception, MessagingException {

		// 1.连接邮箱发送的服务端（登录邮箱）
		/**
		 * 参数一: 邮箱服务器的参数 参数二：提供加密后的账户和密码
		 */
		Properties props = new Properties();
		// 设置服务器地址
		props.setProperty("mail.smtp.host", "smtp.sina.com");
		// 设置服务器是否需要验证登录（base64加密）
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {

			// 返回加密后的账户和密码
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ericxu_12345@sina.com", "eric12345");
			}

		});

		// 打开调式,看到发件过程的日志
		session.setDebug(true);

		// 2.创建一封邮件
		MimeMessage mail = new MimeMessage(session);
		// 2.1 设置发件人（和登录账户一致的）
		mail.setFrom(new InternetAddress("ericxu_12345@sina.com"));
		// 2.2 设置收件人
		/**
		 * 参数一：收件类型（TO: 收件人， CC：抄送人， BCC：密送人）
		 * 
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("42912810@qq.com"));
		// 2.3 设置邮件的标题
		mail.setSubject("这是一封测试邮件");
		// 2.4 设置邮件正文
		mail.setContent("正文<br/><a href='http://gz.itheima.com'>网站</a>", "text/html;charset=utf-8");

		// 3.发送邮件
		Transport.send(mail);

	}

	// 发送带附件的邮件
	@Test
	public void test2() throws Exception, MessagingException {

		// 1.连接邮箱发送的服务端（登录邮箱）
		/**
		 * 参数一: 邮箱服务器的参数 参数二：提供加密后的账户和密码
		 */
		Properties props = new Properties();
		// 设置服务器地址
		props.setProperty("mail.smtp.host", "smtp.sina.com");
		// 设置服务器是否需要验证登录（base64加密）
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {

			// 返回加密后的账户和密码
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ericxu_12345@sina.com", "eric12345");
			}

		});

		// 打开调式,看到发件过程的日志
		session.setDebug(true);

		// 2.创建一封邮件
		MimeMessage mail = new MimeMessage(session);
		// 2.1 设置发件人（和登录账户一致的）
		mail.setFrom(new InternetAddress("ericxu_12345@sina.com"));
		// 2.2 设置收件人
		/**
		 * 参数一：收件类型（TO: 收件人， CC：抄送人， BCC：密送人）
		 * 
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("42912810@qq.com"));
		// 2.3 设置邮件的标题
		mail.setSubject("这是一封带附件测试邮件");

		// 带附件
		// 1.创建MimeBodypart
		MimeBodyPart part1 = new MimeBodyPart();
		part1.attachFile(new File("F:\\图片\\2.jpg"));

		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("F:\\图片\\3.jpg"));

		// 2.创建MimeMultipart
		MimeMultipart mmp = new MimeMultipart();
		mmp.addBodyPart(part1);
		mmp.addBodyPart(part2);

		// 3.把MimeMultipart放入到MimeMessge中
		mail.setContent(mmp);

		// 3.发送邮件
		Transport.send(mail);

	}

	// 发送带附件+正文的邮件
	@Test
	public void test3() throws Exception, MessagingException {

		// 1.连接邮箱发送的服务端（登录邮箱）
		/**
		 * 参数一: 邮箱服务器的参数 参数二：提供加密后的账户和密码
		 */
		Properties props = new Properties();
		// 设置服务器地址
		props.setProperty("mail.smtp.host", "smtp.sina.com");
		// 设置服务器是否需要验证登录（base64加密）
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {

			// 返回加密后的账户和密码
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ericxu_12345@sina.com", "eric12345");
			}

		});

		// 打开调式,看到发件过程的日志
		session.setDebug(true);

		// 2.创建一封邮件
		MimeMessage mail = new MimeMessage(session);
		// 2.1 设置发件人（和登录账户一致的）
		mail.setFrom(new InternetAddress("ericxu_12345@sina.com"));
		// 2.2 设置收件人
		/**
		 * 参数一：收件类型（TO: 收件人， CC：抄送人， BCC：密送人）
		 * 
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("42912810@qq.com"));
		// 2.3 设置邮件的标题
		mail.setSubject("这是一封带附件+正文测试邮件");

		// 带附件
		// 1.创建MimeBodypart
		MimeBodyPart part1 = new MimeBodyPart();
		part1.attachFile(new File("F:\\图片\\2.jpg"));

		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("F:\\图片\\3.jpg"));

		// 2.创建MimeMultipart
		MimeMultipart mmp = new MimeMultipart();
		mmp.addBodyPart(part1);
		mmp.addBodyPart(part2);

		// 3.创建正文的MimeBodypart
		MimeBodyPart part3 = new MimeBodyPart();
		part3.setContent("这时带附件的正文内容", "text/html;charset=utf-8");
		mmp.addBodyPart(part3);

		// 3.把MimeMultipart放入到MimeMessge中
		mail.setContent(mmp);

		// 3.发送邮件
		Transport.send(mail);

	}

	// 发送带附件的邮件（文件名乱码）
	@Test
	public void test4() throws Exception, MessagingException {

		// 1.连接邮箱发送的服务端（登录邮箱）
		/**
		 * 参数一: 邮箱服务器的参数 参数二：提供加密后的账户和密码
		 */
		Properties props = new Properties();
		// 设置服务器地址
		props.setProperty("mail.smtp.host", "smtp.sina.com");
		// 设置服务器是否需要验证登录（base64加密）
		props.setProperty("mail.smtp.auth", "true");
		Session session = Session.getInstance(props, new Authenticator() {

			// 返回加密后的账户和密码
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("ericxu_12345@sina.com", "eric12345");
			}

		});

		// 打开调式,看到发件过程的日志
		session.setDebug(true);

		// 2.创建一封邮件
		MimeMessage mail = new MimeMessage(session);
		// 2.1 设置发件人（和登录账户一致的）
		mail.setFrom(new InternetAddress("ericxu_12345@sina.com"));
		// 2.2 设置收件人
		/**
		 * 参数一：收件类型（TO: 收件人， CC：抄送人， BCC：密送人）
		 * 
		 */
		mail.setRecipient(RecipientType.TO, new InternetAddress("42912810@qq.com"));
		// 2.3 设置邮件的标题
		mail.setSubject("这是一封带附件测试邮件");

		// 带附件
		// 1.创建MimeBodypart
		MimeBodyPart part1 = new MimeBodyPart();
		part1.attachFile(new File("F:\\图片\\美美.jpg"));
		
		//设置文件名称，并且对文件名称进行编码
		part1.setFileName(MimeUtility.encodeText("这是一张美女图片.jpg"));

		MimeBodyPart part2 = new MimeBodyPart();
		part2.attachFile(new File("F:\\图片\\3.jpg"));

		// 2.创建MimeMultipart
		MimeMultipart mmp = new MimeMultipart();
		mmp.addBodyPart(part1);
		mmp.addBodyPart(part2);

		// 3.把MimeMultipart放入到MimeMessge中
		mail.setContent(mmp);

		// 3.发送邮件
		Transport.send(mail);

	}
}
