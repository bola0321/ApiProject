package co.grandcircus.musicapiproject.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Album {
	
	private String title;
	@JsonProperty("cover_big")
	private String coverBig;
	@JsonProperty("cover_small")
	private String coverSmall;

	public String getCoverSmall() {
		return coverSmall;
	}

	public void setCoverSmall(String coverSmall) {
		this.coverSmall = coverSmall;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getCoverBig() {
		return coverBig;
	}

	public void setCoverBig(String coverBig) {
		this.coverBig = coverBig;
		
	
	}

	public Album() {
		
	}
}
