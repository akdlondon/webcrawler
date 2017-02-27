package com.alok.htmlparser;

import java.io.IOException;
import java.net.URI;
import java.util.LinkedHashSet;
import java.util.ListIterator;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JSoupHtmlParserImpl implements HtmlParser{

	Document doc;
	
	
	
	
	public JSoupHtmlParserImpl(String pageUrl) throws IOException {
		super();
		this.doc = Jsoup.connect(pageUrl).get();
	}

	@Override
	public Set<String> getExternalLinks(String baseDomain) {
		URI uri;
		Set<String> externalLink = new LinkedHashSet<String>();
		ListIterator<Element> elementsItarator = doc.select("a").listIterator();
		while (elementsItarator.hasNext()) {
			Element a = elementsItarator.next();
			try {
				String uriWithNoAnchor = "";
				if (a.attr("abs:href").indexOf('#') > 0) {
					uriWithNoAnchor = a.attr("abs:href").substring(0, a.attr("abs:href").indexOf('#'));
				} else {
					uriWithNoAnchor = a.attr("abs:href");
				}
				uri = new URI(uriWithNoAnchor);
				String domain = uri.getHost().startsWith("www.") ? uri.getHost().substring(4) : uri.getHost();
				// System.out.println(domain);
				if (!baseDomain.equals(domain)) {
					externalLink.add(uriWithNoAnchor);
				}
			} catch (Exception e) {
				//@ToDo Implement logging properly.
			}
		}
		return externalLink;

	}

	@Override
	public Set<String> getInternalLinks(String baseDomain) {
		URI uri;
		Set<String> internalLink = new LinkedHashSet<String>();
		ListIterator<Element> elementsItarator = doc.select("a").listIterator();
		while (elementsItarator.hasNext()) {
			Element a = elementsItarator.next();
			try {
				String uriWithNoAnchor = "";
				if (a.attr("abs:href").indexOf('#') > 0) {
					uriWithNoAnchor = a.attr("abs:href").substring(0, a.attr("abs:href").indexOf('#'));
				} else {
					uriWithNoAnchor = a.attr("abs:href");
				}
				uri = new URI(uriWithNoAnchor);
				String domain = uri.getHost().startsWith("www.") ? uri.getHost().substring(4) : uri.getHost();

				if (baseDomain.equals(domain)) {
					internalLink.add(uriWithNoAnchor);
				}
			} catch (Exception e) {
				//@ToDo Implement logging properly.
			}
		}
		return internalLink;
	}
	

	@Override
	public String getMetaDescription() {
		return doc.select("meta[name$=description]").toString();
	}

	@Override
	public String getMetaKeywords() {
		return doc.select("meta[name$=keywords]").toString();
	}

	@Override
	public String getTitle() {
		return doc.select("title").text();
	}

	@Override
	public Set<String> getImageLinks() {
		return doc.select("img").stream().map(i -> i.attr("src")).collect(Collectors.toSet());
	}
	
	public void close (){
		doc = null;
	}
	

}
