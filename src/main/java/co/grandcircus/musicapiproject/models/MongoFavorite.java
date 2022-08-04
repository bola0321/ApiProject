package co.grandcircus.musicapiproject.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("favorites")
public class MongoFavorite {
	@Id
	private String trackid;
	private String artist;
	private String trackName;

	private String cover;
	
	public String getTrackid() {
		return trackid;	
	}
	
	
	public MongoFavorite(String trackid, String artist, String trackName, String cover) {
		this.trackid = trackid;
		this.artist = artist;
		this.trackName = trackName;
		this.cover = cover;
		}
	
	
	public MongoFavorite() {
	}


	public void setTrackid(String trackid) {
		this.trackid = trackid;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getTrackName() {
		return trackName;
	}
	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}
	
	public String getCover() {
		return cover;
	}


	public void setCover(String cover) {
		this.cover = cover;
	}

}
