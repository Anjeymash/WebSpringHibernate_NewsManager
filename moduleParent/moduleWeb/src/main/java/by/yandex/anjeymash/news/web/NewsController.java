package by.yandex.anjeymash.news.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import by.yandex.anjeymash.news.bean.News;
import by.yandex.anjeymash.news.service.NewsService;
import by.yandex.anjeymash.news.service.exception.ServiceException;

@Controller
@RequestMapping("/news")
public class NewsController {

	// need to inject our news service
	@Autowired
	// @Qualifier("NewsServiceImpl")
	private NewsService newsService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	

	@RequestMapping("/list")
	public String listNews(Model theModel) {
		List<Long> selNewsId = new ArrayList<Long>();
		// get news from the service
		List<News> listNews = newsService.getNewsList();
		// add the news to the model
		theModel.addAttribute("newslist", listNews);
		theModel.addAttribute("selectedNewsId", selNewsId);

		return "list-news";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		News news = new News();

		theModel.addAttribute("news", news);

		return "news-form";
	}

	@PostMapping("/saveNews")
	public String saveNews(@Valid@ModelAttribute("news") News theNews, BindingResult theBindingResult, Model theModel) {
		//checking the binding result
		if (theBindingResult.hasErrors()) {
			return "news-form";
		} else {
			// save the news using our service
			try {
				newsService.save(theNews);
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				theModel.addAttribute("dateErrorMes", e.getMessage());
				return "news-form";
			}
			return "redirect:/news/list";
		}
					
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("newsId") long theId, Model theModel) {

		// get the news from our service
		News theNews = newsService.fetchById(theId);

		newsService.fetchById(theId);

		// set news as a model attribute to pre-populate the form
		theModel.addAttribute("news", theNews);

		// send over to our form
		return "news-form";
	}

	//@GetMapping("/deleteSelected")

	///public String deleteSelectedNews(@RequestParam("selectedNewsId") List<Long> selectedIds, long theId) {

		// delete the customer //newsService.remove(theId);

	//	return "redirect:/news/list";
	//}

	@GetMapping("/delete")
	public String deleteNews(@RequestParam("newsId") long theId) {

		// delete the customer
		newsService.remove(theId);

		return "redirect:/news/list";
	}

	@GetMapping("/showForm")
	public String showNews(@RequestParam("newsId") long theId, Model theModel) {
		News theNews = newsService.fetchById(theId);
		theModel.addAttribute("news", theNews);
		theModel.addAttribute("newsId", theId);

		return "show-form";
	}
}
