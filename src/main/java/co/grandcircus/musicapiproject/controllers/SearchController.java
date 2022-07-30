package co.grandcircus.musicapiproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.musicapiproject.services.MusicApiService;

@Controller
public class SearchController {

	@Autowired
	private MusicApiService musicService;
	
	@RequestMapping("/")
	public String showHome() {
//		model.addAttribute("music", musicService.getMusic("Rihanna"));
		return "home";
	}
	
	@PostMapping("searchByArtist")
	public String displaySearch(Model model, @RequestParam String artist) {
		model.addAttribute("music", musicService.getMusic(artist));
		
		return "searchByArtist";
	}
	
	
	
}
