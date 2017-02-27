package com.alok.webcrawler;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.alok.domains.CrawlDetails;
import com.alok.htmlparser.HtmlParser;
import com.alok.htmlparser.JSoupHtmlParserImpl;



public class WebCrawler {
	Set<String> visitedUrls = new LinkedHashSet<String>();
	static String baseDomain;
	
	
	public static void main(String[] args) {

		URI uri;
		try {
			uri = new URI(args[0]);
			baseDomain = uri.getHost().startsWith("www.") ? uri.getHost().substring(4) : uri.getHost();
			System.out.println("Its Crawling " + args[0]);
			System.out.println("Will take around few seconds to few minutes depending up on size of the site........ " );
			System.out.println("http://wiprodigital.com takes around 20 seconds ....." );
			CrawlDetails cd = new WebCrawler().crawl(args[0]);
			System.out.println(cd.toString());
			printCrawlDetails(cd);
		} catch (URISyntaxException e) {
			System.out.println("Please enter a valid URL");
		}
	}



	private CrawlDetails crawl(String url) {
		CrawlDetails cd = populateCrawlDetails(url);
		cd.getInternalLinks().forEach(i -> crawl(i, cd));
		return cd;
	}

	private void crawl(String url, CrawlDetails parent) {
		CrawlDetails cd = populateCrawlDetails(url);
		parent.addChildCrawlDetails(cd);
		cd.getInternalLinks().forEach(i -> crawl(i, cd));
	}

	private CrawlDetails populateCrawlDetails(String url) {

		CrawlDetails cd = new CrawlDetails();
		try {

			HtmlParser htmlParser = new JSoupHtmlParserImpl(url); 
			
			visitedUrls.add(url);
			visitedUrls.add(url + "/");

			cd.setUrl(url);
			cd.setTitle(htmlParser.getTitle());
			cd.setMetaDescription(htmlParser.getMetaDescription());
			cd.setMetaKeywords(htmlParser.getMetaKeywords());
			cd.setImageLinks(htmlParser.getImageLinks());
			Set<String> internalLinks = htmlParser.getInternalLinks(baseDomain);
			internalLinks.removeAll(visitedUrls);
			internalLinks.forEach(i -> {
				visitedUrls.add(i);
				visitedUrls.add(i + "/");
			});
			cd.setInternalLinks(internalLinks);
			Set<String> externalLink = htmlParser.getExternalLinks(baseDomain);
			cd.setExternalLinks(externalLink);
			
			htmlParser.close();
		} catch (Exception e) {
			//@ToDo Implement logging properly. 
		}
		return cd;
	}

	
	static private void printCrawlDetails(CrawlDetails cd) {
		cd.getChildCrawlDetails().forEach(i -> {
			System.out.println(i.toString());
			printCrawlDetails(i);
		});
	}
	

}
