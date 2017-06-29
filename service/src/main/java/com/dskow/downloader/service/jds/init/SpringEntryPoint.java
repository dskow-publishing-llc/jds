package com.dskow.downloader.service.jds.init;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.dskow.downloader.jdd.client.api.JDDApi;
import com.dskow.downloader.models.xml.Abstract;
import com.dskow.downloader.models.xml.AffiliationInfo;
import com.dskow.downloader.models.xml.Article;
import com.dskow.downloader.models.xml.ArticleDate;
import com.dskow.downloader.models.xml.ArticleId;
import com.dskow.downloader.models.xml.ArticleIdList;
import com.dskow.downloader.models.xml.Author;
import com.dskow.downloader.models.xml.AuthorList;
import com.dskow.downloader.models.xml.DateCreated;
import com.dskow.downloader.models.xml.DateRevised;
import com.dskow.downloader.models.xml.ELocationID;
import com.dskow.downloader.models.xml.History;
import com.dskow.downloader.models.xml.ISSN;
import com.dskow.downloader.models.xml.Journal;
import com.dskow.downloader.models.xml.JournalIssue;
import com.dskow.downloader.models.xml.MedlineCitation;
import com.dskow.downloader.models.xml.MedlineJournalInfo;
import com.dskow.downloader.models.xml.PMID;
import com.dskow.downloader.models.xml.PubDate;
import com.dskow.downloader.models.xml.PubMedPubDate;
import com.dskow.downloader.models.xml.PublicationType;
import com.dskow.downloader.models.xml.PublicationTypeList;
import com.dskow.downloader.models.xml.PubmedArticle;
import com.dskow.downloader.models.xml.PubmedArticleSet;
import com.dskow.downloader.models.xml.PubmedData;

/**
 * This is the spring entry point for the application.
 * 
 * @author dskowronski
 *
 */
@Configuration
@ComponentScan({ "com.dskow.downloader.service.jds" })
@EnableMongoRepositories(basePackages = { "com.dskow.downloader.service.jds" })
@EnableAutoConfiguration
public class SpringEntryPoint {
	// Define a static logger variable so that it references the
	// Logger instance named "SpringEntryPoint".
	// private static final Logger LOGGER =
	// LogManager.getLogger(SpringEntryPoint.class);

	public static class ApplicationContextGetter implements ApplicationContextAware {
		public static volatile ApplicationContext c;

		@Override
		public void setApplicationContext(ApplicationContext c) throws BeansException {
			ApplicationContextGetter.c = c;
		}
	}

	@Bean
	public ApplicationContextAware getApplicationContext() {
		try {
			return new ApplicationContextGetter();
		} catch (Throwable t) {
			System.err.println("SpringEntryPoint.getApplicationContext() failed due to: " + t.getMessage());
			throw t;
		}
	}

	@Bean
	public FilterRegistrationBean corsFilter() {
		try {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true);
			config.addAllowedOrigin("*"); // TODO: Narrow allowed origins for
											// production environment
			config.addAllowedHeader("*");
			config.addAllowedMethod("GET");
			config.addAllowedMethod("POST");
			source.registerCorsConfiguration("/**", config);

			final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
			bean.setOrder(0);
			return bean;
		} catch (Throwable t) {
			System.err.println("SpringEntryPoint.corsFilter() failed due to: " + t.getMessage());
			throw t;
		}
	}

	@Bean
	public JDDApi getJddClient() {
		return new JDDApi();
	}

	// for Marshalling XML using O/X Mappers
	// see
	// https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/oxm.html
	// @Bean
	// MessageConverter messageConverter() {
	// MarshallingMessageConverter converter = new
	// MarshallingMessageConverter();
	// converter.marshaller = marshaller();
	// converter.unmarshaller = marshaller();
	// // set this converter on the implicit Spring JMS template
	// jmsTemplate.messageConverter = converter;
	// }

	@Bean
	Jaxb2Marshaller getMarshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setClassesToBeBound(Abstract.class, AffiliationInfo.class, Article.class, ArticleDate.class,
				ArticleId.class, ArticleIdList.class, Author.class, AuthorList.class, DateCreated.class,
				DateRevised.class, ELocationID.class, History.class, ISSN.class, Journal.class, JournalIssue.class,
				MedlineCitation.class, MedlineJournalInfo.class, PMID.class, PubDate.class, PublicationType.class,
				PublicationTypeList.class, PubmedArticle.class, PubmedArticleSet.class, PubmedData.class,
				PubMedPubDate.class);
		return marshaller;
	}
}
