package ua.spalah.bank;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.internal.SessionImpl;
import ua.spalah.bank.models.Client;
import ua.spalah.bank.models.accounts.Account;
import ua.spalah.bank.models.accounts.CheckingAccount;
import ua.spalah.bank.models.accounts.SavingAccount;
import ua.spalah.bank.models.type.Gender;
import ua.spalah.bank.services.ClientService;
import ua.spalah.bank.services.impl.ClientServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by user on 12.03.2017.
 */
public class main {
  public static void main(String[] args) {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("bank_application");
    EntityManager entityManager = factory.createEntityManager();



    Client client = new Client("Petya", Gender.MALE, "email", "telephone", "Dnepr");
    Account account = new SavingAccount(600);
//    entityManager.persist(account);
    client.setActiveAccount(account);
    client.getAccounts().add(account);
    entityManager.persist(client);

    entityManager.getTransaction().commit();
    entityManager.close();
    factory.close();
  }
}
