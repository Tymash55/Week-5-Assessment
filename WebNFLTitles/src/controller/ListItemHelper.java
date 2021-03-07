package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConsoleNFLTitles");

	public void insertItem(ListItem li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<ListItem>showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		
		List<ListItem>	allItems = em.createQuery("SELECT i FROM ListItem i").getResultList();
		return allItems;
	}
	
	public void deleteItem(ListItem toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery(
				"select li from ListItem li where li.team = :selectedTeam and li.titles = :selectedTitles",
				ListItem.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedTeam", toDelete.getTeamName());
		typedQuery.setParameter("selectedTitles", toDelete.getTitles());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		ListItem result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}
	
	public ListItem searchForTeamById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		ListItem found = em.find(ListItem.class, idToEdit);
		em.close();
		return found;
	}

	public void updateTeam(ListItem toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<ListItem> searchForTitlesByTeam(String teamName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.team = :selectedTeam", ListItem.class);
		typedQuery.setParameter("selectedTeam", teamName);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}

	public List<ListItem> searchForTitlesByTitles(int titles) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<ListItem> typedQuery = em.createQuery("select li from ListItem li where li.titles = :selectedTitles", ListItem.class);
		typedQuery.setParameter("selectedTitles", titles);

		List<ListItem> foundItems = typedQuery.getResultList();
		em.close();
		return foundItems;
	}
	
	public void cleanUp(){
		emfactory.close();
	}

}

