package co.grandcircus.musicapiproject.services;

import java.util.ArrayList;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import co.grandcircus.musicapiproject.models.Music;
import co.grandcircus.musicapiproject.models.MusicResponse;
import co.grandcircus.musicapiproject.models.Playlist;
import co.grandcircus.musicapiproject.models.PlaylistSearchResponse;
import co.grandcircus.musicapiproject.models.Track;

@Service
public class MusicApiService {

	private RestTemplate request = new RestTemplate();
	  private HttpHeaders headers = new HttpHeaders();
	  public MusicResponse SearchQuery(String searchTerm) {
	        String url = "https://deezerdevs-deezer.p.rapidapi.com/search?q={0}";
	        headers.set("X-RapidAPI-Key", "dc132e6a50mshfe6a15e27d35c7ep168bb0jsn9125e9d1d89d");
	        headers.set("X-RapidAPI-Host", "deezerdevs-deezer.p.rapidapi.com");
	        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);
	        ResponseEntity<MusicResponse> response = request.exchange(url, HttpMethod.GET,
	                requestEntity, MusicResponse.class, searchTerm);
	        // System.out.println(response.getBody().getTotal());
	        // // // System.out.println(response.getBody().getData());
	        // System.out.println(response.getBody().getNext());
	        // // System.out.println(response.getBody().getClass());
	        return response.getBody(); 
	
	  }
	public List<Music> getMusicByArtist(String artist) {
		String url = "https://www.deezer.com/artist" + artist;
		MusicResponse response = request.getForObject(url, MusicResponse.class);
		return response.getData();
	}

	public List<Track> getTracksforDecade(Integer year) {
		String url = "https://api.deezer.com/search/playlist?q={year}";
		PlaylistSearchResponse response = request.getForObject(url, PlaylistSearchResponse.class, year);
		List<Playlist> bareListOfPlaylists = response.getPlaylistSearchList();

		List<Playlist> everythingPlaylists = new ArrayList<>();
		for (Playlist barePlaylist : bareListOfPlaylists) {
			String playlistId = barePlaylist.getId();
			String getFullPlaylistUrl = "https://api.deezer.com/playlist/{playlistid}";

			Playlist allDataInAParticularPlaylist = request.getForObject(getFullPlaylistUrl, Playlist.class,
					playlistId);
			everythingPlaylists.add(allDataInAParticularPlaylist);
			if (everythingPlaylists.size() >= 3) {
				break;
			}
		}

		List<Track> consolidatedListOfTracks = new ArrayList<>();
		for (Playlist playlist : everythingPlaylists) {
			List<Track> trackList = playlist.getTracks().getData();
			for (Track track : trackList) {
				consolidatedListOfTracks.add(track);
			}
		}
		List<Track> siftedDecadePlaylist = new ArrayList<>();
		String yearSubstring = year.toString().substring(0, 2);
		for (Track track : consolidatedListOfTracks) {
			String getActualTrackDataUrl = "https://www.deezer.com/track/{trackid}";
			Track completeTrack = request.getForObject(getActualTrackDataUrl, Track.class, track.getId());
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
			if (!trackingTrackIds.contains(completeDecadeList.get(i).getId())) {
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
