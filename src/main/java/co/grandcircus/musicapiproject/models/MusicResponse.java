package co.grandcircus.musicapiproject.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MusicResponse {
	
	private List<Music> data;
	
	@JsonProperty("data")
	private List<Search> searchData;
	
	public List<Music> getData() {
		return data;
	}
	public void setData(List<Music> data) {
		this.data = data;
	}
	public List<Search> getSearchData() {
		return searchData;
	}
	public void setSearchData(List<Search> searchData) {
		this.searchData = searchData;
	}

	
	
}
