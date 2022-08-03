package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


import co.grandcircus.musicapiproject.models.TrackList;

public interface MusicApiRepository extends MongoRepository<TrackList, String> {
	List<TrackList> findAll();
}
