package by.yandex.anjeymash.news.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.yandex.anjeymash.news.bean.News;
import by.yandex.anjeymash.news.dao.NewsDAO;
import by.yandex.anjeymash.news.service.NewsService;
import by.yandex.anjeymash.news.service.exception.ServiceException;
import by.yandex.anjeymash.news.service.validation.ValidationData;

@Service
public class NewsServiceImpl implements NewsService {

	public NewsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	@Qualifier("newsDAOImpl")
	public NewsDAO newsDAO;

	@Transactional
	public List<News> getNewsList() {
		return newsDAO.getNewsList();}
	
	@Transactional
	public void save(News news) throws ServiceException {
		if (!ValidationData.validNews(news.getNewsTitle(), news.getNewsBrief(), news.getNewsDate(), news.getNewsMes())) {
			throw new ServiceException("Incorrect news date ");
		}
		if((newsDAO.checkExistingNews(news))&&(news.getNewsId()==null))
			throw new ServiceException("Such a News Title is already exist");
		newsDAO.save(news);

	}
	@Transactional
	public void remove(Long id) {
		newsDAO.remove(id);

	}
	@Transactional
	public News fetchById(Long id) {

		return newsDAO.fetchById(id);
	}

}
