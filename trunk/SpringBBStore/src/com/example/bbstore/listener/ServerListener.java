package com.example.bbstore.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



/**
 * Application Lifecycle Listener implementation class srvListener
 *
 */

public class ServerListener implements ServletContextListener {
   // ServletContext sc ;
    /**
     * Default constructor. 
     */
    public ServerListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0) {
      /*  if (sc==null){
            sc =  arg0.getServletContext();   
            ApplicationContext applicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(arg0.getServletContext());
            BookService ps = (BookService)applicationContext.getBean("bookService");
            sc.setAttribute("bookListener", ps);
        }*/
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
