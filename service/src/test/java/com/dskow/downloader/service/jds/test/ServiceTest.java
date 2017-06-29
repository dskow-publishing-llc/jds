package com.dskow.downloader.service.jds.test;

import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.BDDMockito.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.MongoClient;
import com.dskow.downloader.service.jds.JournalDocDownloaderService;
import com.dskow.downloader.service.jds.JournalRepository;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ServiceTest {

	// Define a static logger variable so that it references the
	// Logger instance named "ServiceTest".
	private static final Logger LOGGER = LogManager.getLogger(ServiceTest.class);

	@MockBean
	private JournalDocDownloaderService controller;

	// Mock these beans from SemanticAligner.java for contexLoads test
	@MockBean
	private JournalRepository journalRepo;

	@MockBean
	private MongoAutoConfiguration mongo;

	@MockBean
	MongoClient mongoClient;

	@Test
	@Ignore
	public void contexLoads() throws Exception {
		LOGGER.debug("Context load test");
		// given(this.api.ping()).willReturn(Long.toString(new
		// Date().getTime()));
		assertThat(controller).isNotNull();
	}
}