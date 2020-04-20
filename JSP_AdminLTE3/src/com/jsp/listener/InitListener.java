package com.jsp.listener;

import java.lang.reflect.Method;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.ibatis.session.SqlSessionFactory;

import com.jsp.dao.BoardDAO;
import com.jsp.dao.MemberDAO;
import com.jsp.service.BoardServiceImpl;
import com.jsp.service.MemberServiceImpl;

@WebListener
public class InitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent ctxEvent)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent ctxEvent)  { 
         String sqlSessionFactoryType = 
        		 ctxEvent.getServletContext().getInitParameter("sqlSessionFactory");
         String memberDAOType = ctxEvent.getServletContext().getInitParameter("memberDAO");
         String boardDAOType = ctxEvent.getServletContext().getInitParameter("boardDAO");
         
         try {
        	 
	         SqlSessionFactory sqlSessionFactory = 
	        		 (SqlSessionFactory)Class.forName(sqlSessionFactoryType).newInstance();
	         
	         
	         Class<?> memDao = Class.forName(memberDAOType);     
	         Class<?> borDao = Class.forName(boardDAOType);     
	         
	         Method setSqlSessionFactory1
	         	= memDao.getMethod("setSessionFactory", SqlSessionFactory.class);
	         Method setSqlSessionFactory2
	         = borDao.getMethod("setSessionFactory", SqlSessionFactory.class);
	         
	         Object obj1 = memDao.newInstance();
	         Object obj2 = borDao.newInstance();
	         setSqlSessionFactory1.invoke(obj1, sqlSessionFactory);
	         setSqlSessionFactory2.invoke(obj2, sqlSessionFactory);
	         
	         MemberDAO memberDAO = (MemberDAO)obj1;
	         BoardDAO boardDAO = (BoardDAO)obj2;
	         
	         MemberServiceImpl.getInstance().setMemberDAO(memberDAO);
	         BoardServiceImpl.getInstance().setBoardDAO(boardDAO);
	         
         }catch(Exception e) {
        	 e.printStackTrace();
         }
                        
    }
	
}
