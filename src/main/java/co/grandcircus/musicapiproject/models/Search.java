package co.grandcircus.musicapiproject.models;

import org.springframework.data.annotation.Id;

public class Search {

	private String id;
	private String title;
	private String link;
	private int duration;
	private String artist;
	private String album;
	
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
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public Search(String id, String title, String link, int duration, String artist, String album) {
		super();
		this.id = id;
		this.title = title;
		this.link = link;
		this.duration = duration;
		this.artist = artist;
		this.album = album;
	}
	
	public Search() {
		
	}
}
