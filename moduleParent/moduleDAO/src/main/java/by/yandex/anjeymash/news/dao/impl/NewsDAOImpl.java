package by.yandex.anjeymash.news.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import by.yandex.anjeymash.news.bean.News;
import by.yandex.anjeymash.news.dao.NewsDAO;

@Repository
public class NewsDAOImpl implements NewsDAO {

	public NewsDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private SessionFactory sessionFactory;

	public List<News> getNewsList() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// create a query ... sort by date
		// Query<News> theQuery = currentSession.createQuery("from News order by
		// newsId", News.class);
		// execute query and get result list
		// List<News> news = theQuery.getResultList();
		// currentSession.beginTransaction();

		List<News> news = currentSession.createQuery("from News order by newsDate", News.class).getResultList();

		// currentSession.beginTransaction();

		return news;
	}

	public boolean checkExistingNews(News theNews) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		// check if the news is already exist
		@SuppressWarnings("deprecation")
		Criteria criteria = currentSession.createCriteria(News.class);
		criteria.add(Restrictions.eq("newsTitle", theNews.getNewsTitle()));
		criteria.setProjection(Projections.property("newsTitle"));
		return criteria.uniqueResult() != null;
		
		//Projection p1 = Projection.property("proName");
		//Projection p2 = Projection.property("price");
		//crit.setProjection(p1):
		//crit.setProjection(p2):
		
		
	}

	public void save(News theNews) {
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// save/upate the news
		currentSession.saveOrUpdate(theNews);

	}

	public void remove(Long theId) {
		// TODO Auto-generated method stub
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from News where id=:newsId");
		theQuery.setParameter("newsId", theId);

		theQuery.executeUpdate();
	}

	public News fetchById(Long theId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// now retrieve/read from database using the primary key
		News theNews = currentSession.get(News.class, theId);

		return theNews;
	}
}
