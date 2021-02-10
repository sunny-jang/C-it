package com.cit.member.controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

@WebServlet("/mailServlet.do")
public class MailServlet extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   String uEmail = request.getParameter("email");
      String to =  "";
      if (!uEmail.equals("")) to = uEmail;//change accordingly

      String from = "esunbest@gmail.com";//change accordingly
      final String username = "esunbest@gmail.com";//change accordingly
      final String password = "whrwpql000";//change accordingly

      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      
      String authNum = MakeAuthNum();
      
      
      try {
         Message message = new MimeMessage(session);

         message.setFrom(new InternetAddress(from));

         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

         message.setSubject("Testing Subject");
         
         message.setText("인증번호는"+authNum+"입니다.");

         Transport.send(message);
         JSONObject json = new JSONObject();
         json.put("authNum", authNum);
         response.getWriter().append(json.toJSONString());
         
        request.getSession().setAttribute("authNum", authNum);
        
      } catch (MessagingException e) {
            throw new RuntimeException(e);
      }
      System.out.println("Sent message successfully....");
   }
   
   public String MakeAuthNum() {
	   int randomNum = (int)(Math.random()*999999);
	   return String.valueOf(randomNum);
   }
}