package co.grandcircus.musicapiproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.grandcircus.musicapiproject.models.Track;

public interface MusicApiRepo extends MongoRepository<Track, String>{

	
	
}
