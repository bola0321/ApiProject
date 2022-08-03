package co.grandcircus.musicapiproject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.musicapiproject.models.Track;
import co.grandcircus.musicapiproject.repository.MusicApiRepo;
import co.grandcircus.musicapiproject.services.MusicApiService;

@Controller
public class SearchController {

	@Autowired
	private MusicApiService musicService;
	
	@Autowired
	private MusicApiRepo favorites;
	
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
	
	@PostMapping("addToFavorites") 
	public String addToFavorites(Model model, @RequestParam String id, @RequestParam String songTitle, @RequestParam String artistName) {
		model.addAttribute("id", id);
		model.addAttribute("songTitle", songTitle);
		model.addAttribute("artistName", artistName);
		Track track = new Track(id);
		favorites.save(track);
		model.addAttribute("track", track);

		return "confirmAddtoFavorites";
		
	}
	@RequestMapping("confirmAddtoFavorites")
	public String showConfirmAddtoFavorites() {
		return "confirmAddtoFavorites";
	}
	
	}


