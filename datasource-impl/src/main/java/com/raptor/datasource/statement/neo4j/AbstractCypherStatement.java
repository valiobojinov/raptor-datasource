package com.raptor.datasource.statement.neo4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;

import com.raptor.datasource.query.QueryCriteria;
import com.raptor.datasource.statement.IStatement;

public abstract class AbstractCypherStatement  implements IStatement{
	private final Session session;
	
	protected final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
	
	public AbstractCypherStatement(Session session) {
		this.session = session;
	}
	
	protected StatementResult run(String statement) {
		return session.run(statement);
	}
	
	protected abstract String prepareStatement(QueryCriteria criteria);
	
	protected XMLGregorianCalendar toXmlCalendar(String effectiveDate) throws ParseException, DatatypeConfigurationException {		
		GregorianCalendar effectiveDateCalendar = new GregorianCalendar();	
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
		Date date = dateFormat.parse(effectiveDate);
		effectiveDateCalendar.setTime(date);
		return DatatypeFactory.newInstance().newXMLGregorianCalendar(effectiveDateCalendar);
		
	}
}
