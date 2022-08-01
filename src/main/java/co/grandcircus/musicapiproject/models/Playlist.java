package co.grandcircus.musicapiproject.models;

import org.springframework.data.annotation.Id;

public class Playlist {
	@Id
	private String id;
	private String title;
	private TrackList tracks;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public TrackList getTracks() {
		return tracks;
	}
	public void setTracks(TrackList tracks) {
		this.tracks = tracks;
	}
	
	
	

}
