package com.raptor.datasource.neo4j;

import org.apache.log4j.Logger;
import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Config;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;

import com.raptor.datasource.initializer.IDataSourceInitializer;

public class Neo4JDataSourceInitializer implements IDataSourceInitializer {
	
	private static final Logger LOGGER = Logger.getLogger(Neo4JDataSourceInitializer.class);

	private final int port;
	private final String username;
	private final String password;
	private final String hostname;

	public Neo4JDataSourceInitializer() {
		this(7687, "localhost", "neo4j", "admin");
	}

	public Neo4JDataSourceInitializer (int port, String hostname, String username, String password) {
		this.port = port;
		this.username = username;
		this.password = password;
		this.hostname = hostname;
	}

	public Driver getDriver() {
		StringBuilder boltConnectionUrlBuilder = new StringBuilder();
		if (port != 80) {
			boltConnectionUrlBuilder.append("bolt://");
		}
		String bolcConnectionUrl = boltConnectionUrlBuilder.append(hostname).append(":").append(port).toString();
		
		LOGGER.info("Establishing connection to Neo4j instance via : " + bolcConnectionUrl);
		
		Config config = Config.build().withEncryptionLevel(Config.EncryptionLevel.NONE).toConfig();
		Driver driver = GraphDatabase.driver(bolcConnectionUrl, AuthTokens.basic(username, password),  config);
		LOGGER.info("Connection to Neo4j instance via : " + bolcConnectionUrl + " established successfully");

		return driver;
	}

}
