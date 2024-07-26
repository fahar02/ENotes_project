package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional.TxType;

import dto.AddNotes;
import dto.User;

public class Database {
	public EntityManager getEntityManager()
	{
		return Persistence.createEntityManagerFactory("project2").createEntityManager();
	}
public boolean saveUser(User user)
{
	EntityManager entityManager=getEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	entityTransaction.begin();
	entityManager.persist(user);
	entityTransaction.commit();
	return true;
}

public List<User> select()
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project2");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	Query query=entityManager.createQuery("select u from User u");
	
	return query.getResultList();
}
public AddNotes saveAddNotes(AddNotes addNotes,int id)
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("project2");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	User userdb=entityManager.find(User.class,id);
	if(userdb!=null)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
	    addNotes.setUser(userdb);
		List<AddNotes> addnotes=userdb.getAddNotes();
		addnotes.add(addNotes);
		entityManager.persist(addNotes);
		entityTransaction.commit();
		return addNotes;
	}
	else
	{
		return null;
	}
}
public List<AddNotes> getnotes(int id)
{
	EntityManager entityManager=getEntityManager();
	User user=entityManager.find(User.class,id);
	List<AddNotes> notes=user.getAddNotes();
	return notes;
}
public AddNotes getAddNotes(int id)
{
	EntityManager entityManager=getEntityManager();
	AddNotes addNotes=entityManager.find(AddNotes.class,id);
	return addNotes;
}
public void editNotes(int id, AddNotes addNotes)
{
	EntityManager entityManager=getEntityManager();
	AddNotes notes=entityManager.find(AddNotes.class,id);
	if(notes!=null)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		addNotes.setId(id);
		addNotes.setUser(notes.getUser());
		entityManager.merge(addNotes);
		entityTransaction.commit();
	}
	
}
public boolean delete(int id)
{
	EntityManager entityManager=getEntityManager();
	AddNotes notes=entityManager.find(AddNotes.class,id);
	if(notes!=null)
	{
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		User user=notes.getUser();
		List <AddNotes> note=user.getAddNotes();
		note.remove(notes);
		user.setAddNotes(note);
		entityManager.remove(notes);
		entityTransaction.commit();
		return true;
	}
	return false;
}


}
