package co.grandcircus.musicapiproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.grandcircus.musicapiproject.models.MongoFavorite;

public interface MusicApiRepo extends MongoRepository<MongoFavorite, String>{

	List<MongoFavorite> findAll();
	Optional<MongoFavorite> findById(String id);
	
}
