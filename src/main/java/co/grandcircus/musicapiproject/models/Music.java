package co.grandcircus.musicapiproject.models;

import java.util.List;

public class Music {
	
	private Integer id;
	private String title;
	private List<Artist> artist;
	private List<Album> album;
	
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
	public List<Artist> getArtist() {
		return artist;
	}
	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}
	public List<Album> getAlbum() {
		return album;
	}
	public void setAlbum(List<Album> album) {
		this.album = album;
	}
	public Music(Integer id, String title, List<Artist> artist, List<Album> album) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.album = album;
	}
	
	public Music() {
		
	}
}
