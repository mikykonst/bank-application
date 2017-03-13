package ua.spalah.bank.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import ua.spalah.bank.dao.ClientDao;
import ua.spalah.bank.exceptions.ClientNotFoundException;
import ua.spalah.bank.models.Client;

import javax.persistence.*;
import java.sql.Connection;
import java.util.List;

/**
 * Created by user on 11.03.2017.
 */
public class ClientDaoHiber implements ClientDao {
  EntityManagerFactory entityManagerFactory;
  EntityManager entityManager;
  Session session;

  public ClientDaoHiber(Connection connection) {
    this.entityManagerFactory = Persistence.createEntityManagerFactory("bank_application");
    this.entityManager = entityManagerFactory.createEntityManager();
  }

  public ClientDaoHiber() {
  }

  @Override
  public Client save(Client client) {
    entityManager.persist(client);
    return client;
  }

  @Override
  public Client update(Client client) {

    return client;
  }

  @Override
  public Client saveOrUpdate(Client client) {
    if (client.getId() != 0) {
      client = update(client);
    } else {
      client = save(client);
    }
    return client;
  }

  @Override
  public void delete(long clientId) {


  }

  @Override
  public Client find(long id) {

    return null;
  }

  @Override
  public List<Client> findAll() {
    return null;
  }

  @Override
  public Client findByName(String name) throws ClientNotFoundException {
    return null;
  }
}
