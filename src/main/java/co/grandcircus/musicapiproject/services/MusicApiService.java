package co.grandcircus.musicapiproject.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import co.grandcircus.musicapiproject.models.MusicResponse;
import co.grandcircus.musicapiproject.models.Track;
import co.grandcircus.musicapiproject.models.TrackList;


import co.grandcircus.musicapiproject.models.Playlist;
import co.grandcircus.musicapiproject.models.PlaylistFromSearch;
import co.grandcircus.musicapiproject.models.PlaylistSearchResponse;
import co.grandcircus.musicapiproject.models.Track;
import co.grandcircus.musicapiproject.models.TrackFromPlaylist;

@Service
public class MusicApiService {

	private RestTemplate restTemplate = new RestTemplate();

	String url = "https://deezerdevs-deezer.p.rapidapi.com";

	private static HttpEntity formatRequest() {
	

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

		header.set("X-RapidAPI-Key", "4a88914586mshcb65904c49f7ed4p18e303jsnfd5efee90df3");
		header.set("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com");

		HttpEntity request = new HttpEntity<>(header);
		
	  
		return request;
	}
	// this one is wrong but not completely wrong - mismatch on type asked for and type received.
	public MusicResponse getGeoData(String search) {
		HttpEntity request = formatRequest();
		
		Map<String, String> params = new HashMap<>();
		params.put("search", search);

		
		ResponseEntity<MusicResponse> response = restTemplate.exchange(url + "/search?q={search}", HttpMethod.GET, request, MusicResponse.class, params);	
		return response.getBody();
	
	}

//	public Track getSingleTrack(String track) {
//		Map<String, String> params = new HashMap<>();
//		params.put("track", track);
//		Track response = restTemplate.exchange(url + "/search?q=track:{track}", HttpMethod.GET, formatRequest(), Track.class, params).getBody();
//		
//		return response;
//		
//	}
	
	public TrackList getSingleTrack(String track) {
		Map<String, String> params = new HashMap<>();
		params.put("track", track);
		TrackList response = restTemplate.exchange(url + "/search?q=track:{track}", HttpMethod.GET, formatRequest(), TrackList.class, params).getBody();
		
		return response;
		
	}
	public TrackList getMultipleTracks(String searchTerm) {
		Map<String, String> params = new HashMap<>();
		params.put("searchTerm", searchTerm);
		TrackList response = restTemplate.exchange(url + "/search?q={searchTerm}", HttpMethod.GET, formatRequest(), TrackList.class, params).getBody();
		
		return response;
		
	}
	
	
	


	private PlaylistSearchResponse searchByPlaylist(Integer year) {
		Map<String, String> params = new HashMap<>();
		params.put("year", year.toString());

		PlaylistSearchResponse response = restTemplate.exchange(url + "/search/playlist?q={year}", HttpMethod.GET,
				formatRequest(), PlaylistSearchResponse.class, params).getBody();
		return response;
	}

	private Playlist getIndividualPlaylist(String playlistid) {
		Map<String, String> params = new HashMap<>();
		params.put("playlistid", playlistid);

		Playlist response = restTemplate
				.exchange(url + "/playlist/{playlistid}", HttpMethod.GET, formatRequest(), Playlist.class, params)
				.getBody();
		return response;
	}

//It looks like I'm getting a track back from a track, but I'm actually starting with a track inside of the playlist class and converting
	// it into a pure track type ( a pure track type has the fields I need, whereas
	// a track within playlist is missing those fields
	private Track getIndividualTrack(TrackFromPlaylist track) {
		Map<String, String> params = new HashMap<>();
		params.put("trackid", track.getId());

		Track response = restTemplate
				.exchange(url + "/track/{trackid}", HttpMethod.GET, formatRequest(), Track.class, params).getBody();
		return response;
	}

	public List<Track> getTracksforDecade(Integer year) {

		List<PlaylistFromSearch> bareListOfPlaylists = searchByPlaylist(year).getPlaylistSearchList();

		List<Playlist> everythingPlaylists = new ArrayList<>();
		for (PlaylistFromSearch barePlaylist : bareListOfPlaylists) {
			if (!barePlaylist.getTitle().contains(year.toString().substring(2))) {
				continue;
			}
			String playlistId = barePlaylist.getId();

			Playlist allDataInAParticularPlaylist = getIndividualPlaylist(playlistId);
			everythingPlaylists.add(allDataInAParticularPlaylist);
			if (everythingPlaylists.size() >= 3) {
				break;
			}
		}

		List<TrackFromPlaylist> consolidatedListOfTracks = new ArrayList<>();
		for (Playlist playlist : everythingPlaylists) {
			List<TrackFromPlaylist> trackList = playlist.getTracks().getData();
			int counter = 0;
			for (TrackFromPlaylist track : trackList) {
				consolidatedListOfTracks.add(track);
				counter++;
				if (counter>=50) {
					break;
				}
			}
		}
		List<Track> siftedDecadePlaylist = new ArrayList<>();
		String yearSubstring = year.toString().substring(0, 2);
		for (TrackFromPlaylist track : consolidatedListOfTracks) {
			Track completeTrack = getIndividualTrack(track);
			String releaseDate = completeTrack.getReleaseDate();
			String releaseDateSubstring = releaseDate.substring(0, 2);
			if (releaseDateSubstring.equals(yearSubstring)) {
				siftedDecadePlaylist.add(completeTrack);
			}

		}
		Collections.shuffle(siftedDecadePlaylist);
		List<Track> completeDecadeList = new ArrayList<>();
		Set<String> trackingTrackIds = new HashSet<>();
		for (int i = 0; i < siftedDecadePlaylist.size(); i++) {
			if (!trackingTrackIds.contains(siftedDecadePlaylist.get(i).getId())) {
				completeDecadeList.add(siftedDecadePlaylist.get(i));
				trackingTrackIds.add(siftedDecadePlaylist.get(i).getId());
			}
			if (completeDecadeList.size() >= 25) {
				break;
			}

		}
		return completeDecadeList;
	}

}
