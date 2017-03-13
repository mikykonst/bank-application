package ua.spalah.bank.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import ua.spalah.bank.dao.AccountDao;
import ua.spalah.bank.models.accounts.Account;
import ua.spalah.bank.models.accounts.CheckingAccount;
import ua.spalah.bank.models.accounts.SavingAccount;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 11.03.2017.
 */
public class AccountDaoHiber implements AccountDao{

  EntityManagerFactory factory;
  EntityManager manager;
  Session session;

  public AccountDaoHiber(Session session) {
    this.factory = Persistence.createEntityManagerFactory("bank_application");
    this.manager = factory.createEntityManager();
  }

  @Override
  public Account save(long clientId, Account account) {
    return null;
  }

  @Override
  public Account update(long clientId, Account account) {
    return null;
  }

  @Override
  public Account saveOrUpdate(long clientId, Account account) {
    return null;
  }

  @Override
  public void delete(long id) {

  }

  @Override
  public Account find(long id) {
    return null;
  }

  @Override
  public List<Account> findAll() {
    return null;
  }

  @Override
  public List<Account> findByClientId(long clientId) {
    List<Account> accountListByClientId = new ArrayList<Account>();
    Criteria criteria = session.createCriteria(Account.class).add(Restrictions.like("ID", clientId)).addOrder(Order.asc("ID"));
    try {
      accountListByClientId = addToListMethod(accountListByClientId, criteria);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  private static List<Account> addToListMethod(List<Account> accountListByClientId, Criteria criteria) throws SQLException {
    return accountListByClientId;
  }

  @Override
  public Account findActiveAccountByClientName(String clientName) {
    return null;
  }

  @Override
  public Account setActiveAccount(long clientId, long id) {
    return null;
  }

  @Override
  public void deleteByClientId(long clientId) {

  }

  @Override
  public Account findActiveAccountByClientId(long clientId) {
    return null;
  }
}
