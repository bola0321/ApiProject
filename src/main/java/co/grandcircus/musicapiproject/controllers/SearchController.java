package co.grandcircus.musicapiproject.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.grandcircus.musicapiproject.models.MongoFavorite;
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

	@PostMapping("/searchByTrack")
	public String showSearchByTrack(String track, Model model) {
		model.addAttribute("track", track);
		model.addAttribute("searchByTrack", musicService.getSingleTrack(track));
		return "searchByTrack";
	}

	@PostMapping("/displayGeographicalSearch")
	public String searchMultipleTracks(String searchTerm, Model model) {
		model.addAttribute("searchTerm", searchTerm);
		model.addAttribute("displayGeographicalSearch", musicService.getMultipleTracks(searchTerm));

		return "displayGeographicalSearch";
	}

	@PostMapping("/addToFavorites")
	public String addToFavorites(Model model, @RequestParam String id) {
		model.addAttribute("id", id);
		Track track = musicService.getIndividualTrack(id);
		MongoFavorite fave = new MongoFavorite(id, track.getArtistInfo().getName(), track.getTitle());
		favorites.save(fave);
		

		return "confirmAddtoFavorites";

	}

	@RequestMapping("/confirmAddtoFavorites")
	public String showConfirmAddtoFavorites() {
		return "confirmAddtoFavorites";

	}

	@PostMapping("/search-by-decade")
	public String searchByDecade(@RequestParam int year, Model model) {
		if (!(year >= 1950 && year < 2022)) {
			// TODO: Throw 400 error if not within range(add a range to the JSP as well)
		}
		model.addAttribute("decadeTrackList", musicService.getTracksforDecade(year));

		model.addAttribute("year", year);

		return "searchByDecade";
	}

	@PostMapping("/searchSongsLikeThis")
	public String searchBySimilarities(String bpm, Model model) {
		model.addAttribute("bpm", bpm);
		model.addAttribute("similarTrackList", musicService.getAllTracks(bpm));
		return "searchSongsLikeThis";

	}

}
