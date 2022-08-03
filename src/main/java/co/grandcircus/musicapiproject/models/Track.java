package co.grandcircus.musicapiproject.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document("favorites")
public class Track {
	@Id
	private String id;
	private String title;
	// had to switch List<Artist> to just a property of type Artist
	@JsonProperty("artist")
	private Artist artistInfo;
//	private List<Artist> artistInfo = new ArrayList<>();
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
	public Artist getArtistInfo() {
		return artistInfo;
	}
	public void setArtistInfo(Artist artistInfo) {
		this.artistInfo = artistInfo;
	}
	
	
	
}
