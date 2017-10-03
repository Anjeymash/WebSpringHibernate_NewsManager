package by.yandex.anjeymash.news.dao;

import java.util.List;

import by.yandex.anjeymash.news.bean.News;



public interface NewsDAO {

public List<News> getNewsList();
public void save(News news);
public void remove(Long id);
public News fetchById(Long id);
public boolean checkExistingNews(News news);


}
