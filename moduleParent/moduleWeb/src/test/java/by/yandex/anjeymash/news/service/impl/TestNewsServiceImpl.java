package by.yandex.anjeymash.news.service.impl;

import java.util.Date;

import org.junit.Test;
import by.yandex.anjeymash.news.bean.News;
import by.yandex.anjeymash.news.service.NewsService;
import by.yandex.anjeymash.news.service.exception.ServiceException;

public class TestNewsServiceImpl {

	public NewsService newsService = new NewsServiceImpl();

	@SuppressWarnings("deprecation")
	@Test(expected = ServiceException.class)
	public void addNews() throws ServiceException {
		News news = new News();
		news.setNewsTitle("TestTitle");
		news.setNewsBrief("TestBrief");
		news.setNewsMes("TestMes");
		news.setNewsId((long) 100);
		news.setNewsDate(new Date(2030, 01, 01));
		// System.out.println(news.getNewsId()+"---"+ news.getNewsTitle()+"---"+
		// news.getNewsBrief()+"---"+news.getNewsMes()+"---"+news.getNewsDate());
		newsService.save(news);

	}
}
