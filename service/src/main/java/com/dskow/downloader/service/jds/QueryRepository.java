package com.dskow.downloader.service.jds;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.dskow.downloader.models.mongo.QueryInfo;

@Repository
public interface QueryRepository extends MongoRepository<QueryInfo, String> {
	@Query("{'status': ?0 }")
	public List<QueryInfo> findByStatus(String status);
}
