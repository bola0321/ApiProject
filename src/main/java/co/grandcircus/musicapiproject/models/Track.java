package co.grandcircus.musicapiproject.models;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Track {
	@Id
	private String id;
	private String title;
	//@JsonProperty("artist")
	//private List<Artist> artistInfo;
	@JsonProperty("release_date")
	private String releaseDate;
	
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
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
//	public List<Artist> getArtistInfo() {
//		return artistInfo;
//	}
//	public void setArtistInfo(List<Artist> artistInfo) {
//		this.artistInfo = artistInfo;
//	}
	
	
	
}
