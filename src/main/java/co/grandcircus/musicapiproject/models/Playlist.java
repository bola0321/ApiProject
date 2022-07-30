package co.grandcircus.musicapiproject.models;


import java.util.List;

import org.springframework.data.annotation.Id;

public class Playlist {
	@Id
	private Integer id;
	private String title;
	private Data<List<Track>> tracks;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Data<List<Track>> getTracks() {
		return tracks;
	}
	public void Data(Data<List<Track>> tracks) {
		this.tracks = tracks;
	}
	
	
	

}
