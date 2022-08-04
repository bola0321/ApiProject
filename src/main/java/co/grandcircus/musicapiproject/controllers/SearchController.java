package co.grandcircus.musicapiproject.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		List<Track> tracks = musicService.getMultipleTracks(searchTerm).getData();
		List<Track> newTracks = new ArrayList<Track>();
		Collections.sort(tracks, Comparator.comparing(Track::getTitle));	
		// remove duplicates
		for (int i = 1; i < tracks.size(); i++) {
			if ((tracks.get(i).getTitle().equals(tracks.get(i-1).getTitle())) && (tracks.get(i).getArtistInfo().getName().equals(tracks.get(i-1).getArtistInfo().getName()))) {
				// do nothing 
			} else {
				newTracks.add(tracks.get(i));
			}
			}
		// sort by popularity
		Collections.sort(newTracks, Comparator.comparingInt(Track::getRank));
		model.addAttribute("newTracks", newTracks);
	
		return "displayGeographicalSearch";
	}
	
	@RequestMapping("addToFavorites") 
	public String displayAddToFavorites() {
		
		return "confirmAddtoFavorites";
	}
	
	@PostMapping("addToFavorites") 
	public String addToFavorites(Model model, @RequestParam String id) {

		Track newTrack = new Track(id);
		favorites.save(newTrack);
		
		model.addAttribute("tracks", musicService.getSingleTrack(id));
		
		return "confirmAddtoFavorites";
		
	}
	
	@RequestMapping("confirmAddtoFavorites")
	public String showConfirmAddtoFavorites() {
		
		return "confirmAddtoFavorites";
		
	}
	

	
	@PostMapping("/search-by-decade")
	public String searchByDecade(@RequestParam int year, Model model) {
		if (!(year >= 1950 && year < 2022)) {
			// TODO: Throw 400 error if not within range(add a range to the JSP as well)
		}
		model.addAttribute("decadeTrackList", musicService.getTracksforDecade(year));

		return "searchByDecade";
	}
	
	@PostMapping("/searchSongsLikeThis")
	public String searchBySimilarities(String bpm, Model model) {
		model.addAttribute("bpm", bpm);
		model.addAttribute("similarTrackList", musicService.getAllTracks(bpm));
		return "searchSongsLikeThis";
}
}
	


