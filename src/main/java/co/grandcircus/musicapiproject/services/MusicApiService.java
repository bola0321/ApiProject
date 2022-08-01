package co.grandcircus.musicapiproject.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.musicapiproject.models.Music;
import co.grandcircus.musicapiproject.models.MusicResponse;
import co.grandcircus.musicapiproject.models.Playlist;
import co.grandcircus.musicapiproject.models.PlaylistSearchResponse;
import co.grandcircus.musicapiproject.models.Track;

@Service
public class MusicApiService {

	private RestTemplate request = new RestTemplate();

	public List<Music> getMusic(String artist) {
		String url = "https://api.deezer.com/search?q=artist:\"{artist}\"";
		MusicResponse response = request.getForObject(url, MusicResponse.class, artist);
		return response.getMusic();
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
