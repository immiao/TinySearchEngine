package com.tinysearchengine.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import java.lang.Math;

@DynamoDBTable(tableName = "WordIdf")
public class DdbIdfScore {
	final double k_IDF_FIX = Math.log10((double) 351121.0 / 1251461);

	private String d_word;
	private double d_idfScore;
	
	@DynamoDBHashKey(attributeName = "word")
	public String getWord() {
		return d_word;
	}
	public void setWord(String w) {
		d_word = w;
	}
	
	@DynamoDBAttribute(attributeName = "idf")
	public double getIdf() {
		return k_IDF_FIX + d_idfScore;
	}
	public void setIdf(double score) {
		d_idfScore = score;
	}
}