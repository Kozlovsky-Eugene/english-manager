package com.kh.em;

import com.kh.em.dao.WordDao;
import com.kh.em.entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HelloController {

	@Autowired
	private WordDao wordDao;

	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		Word word = wordDao.get(1);
		model.addAttribute("message", word.getValue());
		return "hello";
	}
}