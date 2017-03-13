package ua.spalah.bank.servlets;

import ua.spalah.bank.dao.impl.ClientDaoHiber;
import ua.spalah.bank.services.AccountService;
import ua.spalah.bank.services.BankReportService;
import ua.spalah.bank.services.ClientService;
import ua.spalah.bank.services.impl.AccountServiceImpl;
import ua.spalah.bank.services.impl.BankReportServiceImpl;
import ua.spalah.bank.services.impl.ClientServiceImpl;
import ua.spalah.bank.dao.AccountDao;
import ua.spalah.bank.dao.ClientDao;
import ua.spalah.bank.dao.impl.AccountDaoImpl;
import ua.spalah.bank.dao.impl.ClientDaoImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;
import java.sql.DriverManager;

public class ServletContextInitializer implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    try {
      Class.forName("org.h2.Driver");
      String url = "jdbc:h2:tcp://localhost/F:\\Проекты\\Spalah\\bank-application\\bank_app";
      Connection connection = DriverManager.getConnection(url, "sa", "");
      connection.setAutoCommit(false);
      ClientDao clientDao = new ClientDaoHiber(connection);
      AccountDao accountDao = new AccountDaoImpl(connection);
      ClientService clientService = new ClientServiceImpl(clientDao, accountDao);
      AccountService accountService = new AccountServiceImpl(clientDao, accountDao);
      BankReportService bankReportService = new BankReportServiceImpl(clientDao,accountDao);
      ServletContext context = servletContextEvent.getServletContext();
      context.setAttribute("clientService",clientService);
      context.setAttribute("accountService",accountService);
      context.setAttribute("bankReportService",bankReportService);
    } catch (Exception e) {
//            throw new RuntimeException("Initialization error", e);
      RuntimeException ex = new RuntimeException("Initialization error");
      ex.initCause(e);
      throw ex;
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {

  }

}
