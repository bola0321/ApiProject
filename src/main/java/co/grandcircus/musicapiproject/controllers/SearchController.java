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
<<<<<<< HEAD

	@PostMapping("addToFavorites")
	public String addToFavorites(Model model, @RequestParam String id, @RequestParam String songTitle,
			@RequestParam String artistName) {
=======
	
	@PostMapping("addToFavorites") 
	public String addToFavorites(Model model, @RequestParam String id) {
>>>>>>> 6bee4e34ff0e543c0e852c56d94a7640b1446c2c
		model.addAttribute("id", id);
		Track track = new Track(id);
		favorites.save(track);
	//	model.addAttribute("track", musicService.getSingleTrack(id));

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
<<<<<<< HEAD
		model.addAttribute("year", year);
=======
>>>>>>> 6bee4e34ff0e543c0e852c56d94a7640b1446c2c

		return "searchByDecade";
	}

	@PostMapping("/searchSongsLikeThis")
	public String searchBySimilarities(String bpm, Model model) {
		model.addAttribute("bpm", bpm);
		model.addAttribute("similarTrackList", musicService.getAllTracks(bpm));
		return "searchSongsLikeThis";
<<<<<<< HEAD
	}
}
=======
}
}
	


>>>>>>> 6bee4e34ff0e543c0e852c56d94a7640b1446c2c
