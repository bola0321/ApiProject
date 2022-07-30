package co.grandcircus.musicapiproject.models;

import java.util.List;

public class MusicResponse {
	
	private List<Music> data;

	public List<Music> getMusic() {
		return data;
	}

	public void setMusic(List<Music> data) {
		this.data = data;
	}
	
	
}
