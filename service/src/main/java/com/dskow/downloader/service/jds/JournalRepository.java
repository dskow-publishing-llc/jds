package com.dskow.downloader.service.jds;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dskow.downloader.models.mongo.PubmedArticle;

@Repository
public interface JournalRepository extends MongoRepository<PubmedArticle, String> {
	@Query("{'name': ?0 }")
	public List<PubmedArticle> findByName(String name);

	@Query("{'medlineCitation.article.abstractItem.abstractTexts': { $exists: true, $ne: null } }")
	public List<PubmedArticle> findAllAbstracts();
}
