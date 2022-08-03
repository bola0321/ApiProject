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
		//model.addAttribute("artist", artist);
//		model.addAttribute("music", musicService.getMusic("Rihanna"));
		return "home";
	}
	
//	@PostMapping("searchByArtist")
//	public String displaySearch(Model model, @RequestParam String artist) {
//	//	model.addAttribute("artist", artist);
//		model.addAttribute("music", musicService.getDataByArtist(artist));
//		
//		return "searchByArtist";
//	}
	
	@PostMapping("/geoSearch")
	public String geographicalSearch(String search, Model model) {
		model.addAttribute("geoSearch", musicService.getGeoData(search));
		return "geoSearch";
	}
	
	@PostMapping("searchByTrack") 
		public String showSearchByTrack(String track, Model model) {
		model.addAttribute("track", track);
		model.addAttribute("searchByTrack", musicService.getSingleTrack(track));
		
		
			return "searchByTrack";
		}
	}


