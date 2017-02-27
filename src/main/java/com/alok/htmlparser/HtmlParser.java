package com.alok.htmlparser;

import java.util.Set;

public interface HtmlParser {
	/**
	 * @param baseDomain is the domain for which we are crawling
	 * @return set of external Links i.e. other than the domain we are crawling.
	 */
	public Set<String> getExternalLinks(String baseDomain);
	
	/**
	 * @param baseDomain is the domain for which we are crawling
	 * @return set of internal Links.
	 */
	public Set<String> getInternalLinks(String baseDomain);

	/**
	 * @return MetaTag description about page
	 */
	public String getMetaDescription();
	
	/**
	 * @return MetaTag keywords about page, used to index it to be used for search.
	 */
	public String getMetaKeywords();
	
	/**
	 * @return Title of the page
	 */
	public String getTitle();
	
	/**
	 * @return set if Image urls.
	 */
	public Set<String> getImageLinks();
	
	
	/**
	 * releases document object so hat it can be garbage collected. 
	 */
	public void close();
}
