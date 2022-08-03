package co.grandcircus.musicapiproject.models;

import java.util.ArrayList;
import java.util.List;

public class TrackList {
	
	List<Track> data = new ArrayList<Track>();

	public List<Track> getData() {
		return data;
	}

	public void setData(List<Track> data) {
		this.data = data;
	}

}
