package com.tinysearchengine.crawler;

import java.net.URL;
import java.util.HashSet;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import com.tinysearchengine.crawler.frontier.URLFrontier;
import com.tinysearchengine.database.DatabaseWrapper;

public class CrawlerContext {
	private DatabaseWrapper m_dbWrapper = null;
	private AtomicInteger m_totalDocs = null;
	private URLFrontier m_URLFrontier = null;
	private HashSet<String> m_URLSet = null;
	// private URLFrontier m_URLFrontier;
	
	public CrawlerContext(DatabaseWrapper dbwrapper, URLFrontier frontier) {
		m_dbWrapper = dbwrapper;
		m_totalDocs = new AtomicInteger(0);
		m_URLFrontier = frontier;
		m_URLSet = new HashSet<String>();
	}
	
	public void incDocsCounter() {
		m_totalDocs.incrementAndGet();
	}
	
	public int getDocsCounter() {
		return m_totalDocs.get();
	}
	
//	public Queue<URL> getTaskQueue() {
//		return m_URLFrontier.getCurrentQueue();
//	}
	
	public void putTask(URL url) {
		// TODO: add a new task to URL frontier
	}
}
