package co.grandcircus.musicapiproject.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaylistSearchResponse {

	@JsonProperty("data")
	private List<Playlist> playlistSearchList;

	public List<Playlist> getPlaylistSearchList() {
		return playlistSearchList;
	}

	public void setPlaylistSearchList(List<Playlist> playlistSearchList) {
		this.playlistSearchList = playlistSearchList;
	}

	
	
	
	

}
