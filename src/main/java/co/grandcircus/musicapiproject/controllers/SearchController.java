package co.grandcircus.musicapiproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.musicapiproject.models.Music;
import co.grandcircus.musicapiproject.services.MusicApiService;

@Controller
public class SearchController {

	@Autowired
	private MusicApiService musicService;
	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
	
	@PostMapping("searchByTrack") 
		public String showSearchByTrack(String track, Model model) {
		model.addAttribute("track", track);
		model.addAttribute("searchByTrack", musicService.getSingleTrack(track));
		return "searchByTrack";
		}

	
	@PostMapping("displayGeographicalSearch")
	public String searchMultipleTracks(String searchTerm, Model model) {
		model.addAttribute("searchTerm", searchTerm);
		model.addAttribute("displayGeographicalSearch", musicService.getMultipleTracks(searchTerm));
		
		return "displayGeographicalSearch";
	}
	
	}


