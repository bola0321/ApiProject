package co.grandcircus.musicapiproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.grandcircus.musicapiproject.models.MongoFavorite;

public interface MusicApiRepo extends MongoRepository<MongoFavorite, String>{

	
	
}
