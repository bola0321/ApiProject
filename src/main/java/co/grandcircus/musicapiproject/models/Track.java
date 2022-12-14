package co.grandcircus.musicapiproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Track {
	
	private String id;
	private String title;
	@JsonProperty("title_short")
	private String titleShort;
	private int rank;
	// had to switch List<Artist> to just a property of type Artist
	@JsonProperty("artist")
	private Artist artistInfo;
//	private List<Artist> artistInfo = new ArrayList<>();
	@JsonProperty("release_date")
	private String releaseDate;
	private Album album;
	private float bpm;

	
	public float getBpm() {
		return bpm;
	}
	public void setBpm(float bpm) {
		this.bpm = bpm;
	}
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

	public Artist getArtistInfo() {
		return artistInfo;
	}
	public void setArtistInfo(Artist artistInfo) {
		this.artistInfo = artistInfo;
	}
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		
		this.rank = rank;
	}
	public Album getAlbum() {
		return album;
	}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public String getTitleShort() {
		return titleShort;
	}
	public void setTitleShort(String titleShort) {
		this.titleShort = titleShort;
	}
	public Track() {
		
	}
	
	public Track(String id) {
		this.id = id;
	}
	
	
}
