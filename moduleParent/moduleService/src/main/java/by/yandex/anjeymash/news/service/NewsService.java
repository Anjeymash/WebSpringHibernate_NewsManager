package by.yandex.anjeymash.news.service;

import java.util.List;

import by.yandex.anjeymash.news.bean.News;
import by.yandex.anjeymash.news.service.exception.ServiceException;



public interface NewsService {

	public List<News> getNewsList();
	public void save(News news) throws ServiceException;
	public void remove(Long id);
	public News fetchById(Long id);

}
