package co.grandcircus.musicapiproject.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import co.grandcircus.musicapiproject.models.Music;
import co.grandcircus.musicapiproject.models.MusicResponse;

@Service
public class MusicApiService {

	private RestTemplate request = new RestTemplate();
	
	public List<Music> getMusic(String artist) {
		String url = "https://api.deezer.com/search?q=artist:\"{artist}\"";
		MusicResponse response = request.getForObject(url, MusicResponse.class, artist);
		return response.getMusic();
	}
	
}
