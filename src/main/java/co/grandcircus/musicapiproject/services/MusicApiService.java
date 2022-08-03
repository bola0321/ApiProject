package co.grandcircus.musicapiproject.services;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



@Service
public class MusicApiService {

	private RestTemplate restTemplate = new RestTemplate();


	String url = "https://deezerdevs-deezer.p.rapidapi.com/";


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
	
	
	
//	public List<Track> getMusicByArtist(String artist) {
//		HttpEntity request = formatRequest();
//		String type = "search?q=";
//		//String url = "https://deezerdevs-deezer.p.rapidapi.com/search?q=artist{artist}";
//		ResponseEntity<MusicResponse> response = restTemplate.exchange(url, HttpMethod.GET, request, MusicResponse.class, type, artist);
//		return response.getBody().getData();
//		}
//
//	public List<Track> getTracksforDecade(Integer year) {
//		String url = "https://api.deezer.com/search/playlist?q={year}";
//		PlaylistSearchResponse response = request.getForObject(url, PlaylistSearchResponse.class, year);
//		List<Playlist> bareListOfPlaylists = response.getPlaylistSearchList();
//
//		List<Playlist> everythingPlaylists = new ArrayList<>();
//		for (Playlist barePlaylist : bareListOfPlaylists) {
//			String playlistId = barePlaylist.getId();
//			String getFullPlaylistUrl = "https://api.deezer.com/playlist/{playlistid}";
//
//			Playlist allDataInAParticularPlaylist = request.getForObject(getFullPlaylistUrl, Playlist.class,
//					playlistId);
//			everythingPlaylists.add(allDataInAParticularPlaylist);
//			if (everythingPlaylists.size() >= 3) {
//				break;
//			}
//		}
//
//		List<Track> consolidatedListOfTracks = new ArrayList<>();
//		for (Playlist playlist : everythingPlaylists) {
//			List<Track> trackList = playlist.getTracks().getData();
//			for (Track track : trackList) {
//				consolidatedListOfTracks.add(track);
//			}
//		}
//		List<Track> siftedDecadePlaylist = new ArrayList<>();
//		String yearSubstring = year.toString().substring(0, 2);
//		for (Track track : consolidatedListOfTracks) {
//			String getActualTrackDataUrl = "https://www.deezer.com/track/{trackid}";
//			Track completeTrack = request.getForObject(getActualTrackDataUrl, Track.class, track.getId());
//			String releaseDate = completeTrack.getReleaseDate();
//			String releaseDateSubstring = releaseDate.substring(0, 2);
//			if (releaseDateSubstring.equals(yearSubstring)) {
//				siftedDecadePlaylist.add(completeTrack);
//			}
//
//		}
//		Collections.shuffle(siftedDecadePlaylist);
//		List<Track> completeDecadeList = new ArrayList<>();
//		Set<String> trackingTrackIds = new HashSet<>();
//		for (int i = 0; i < siftedDecadePlaylist.size(); i++) {
//			if (!trackingTrackIds.contains(completeDecadeList.get(i).getId())) {
//				completeDecadeList.add(siftedDecadePlaylist.get(i));
//				trackingTrackIds.add(siftedDecadePlaylist.get(i).getId());
//			}
//			if (completeDecadeList.size() >= 25) {
//				break;
//			}

//		}
//		return completeDecadeList;
//	}

}

