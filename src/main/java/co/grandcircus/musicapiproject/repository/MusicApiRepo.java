package co.grandcircus.musicapiproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.grandcircus.musicapiproject.models.Track;

public interface MusicApiRepo extends MongoRepository<Track, String>{

	List<Track> findAll();
	Optional<Track> findById(String id);
	
}
