package co.grandcircus.musicapiproject.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaylistSearchResponse {

	@JsonProperty("data")
	private List<PlaylistFromSearch> playlistSearchList;

	public List<PlaylistFromSearch> getPlaylistSearchList() {
		return playlistSearchList;
	}

	public void setPlaylistSearchList(List<PlaylistFromSearch> playlistSearchList) {
		this.playlistSearchList = playlistSearchList;
	}

	
	
	
	

}
