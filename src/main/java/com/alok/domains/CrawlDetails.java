package com.alok.domains;


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CrawlDetails {

	private String url;
	private String title;
	private String parentUrl;
	private String metaDescription;
	private String metaKeywords;
	
	private Set<String> internalLinks = new HashSet<String>();
	private Set<String> externalLinks =  new HashSet<String>();
	private Set<String> imageLinks = new HashSet<String>();
	
	private Set<CrawlDetails> childCrawlDetails = new LinkedHashSet<CrawlDetails>();
	
	
	public void setInternalLinks(Set<String> internalLinks) {
		this.internalLinks = internalLinks;
	}


	public void setExternalLinks(Set<String> externalLinks) {
		this.externalLinks = externalLinks;
	}


	public void setImageLinks(Set<String> imageLinks) {
		this.imageLinks = imageLinks;
	}
	
	
	public CrawlDetails() {
		super();
	}	
	
	
	public void addInternalLink(String link){
		internalLinks.add(link);
	}
	
	public void addExternalLink(String link){
		externalLinks.add(link);
	}
	
	public void addImageLink(String imageLink){
		imageLinks.add(imageLink);
	}
	
	public void addChildCrawlDetails(CrawlDetails cd){
		childCrawlDetails.add(cd);
	}
	
	public Set<CrawlDetails> getChildCrawlDetails() {
		return childCrawlDetails;
	}


	public Set<String> getInternalLinks() {
		return internalLinks;
	}


	public Set<String> getExternalLinks() {
		return externalLinks;
	}

	public Set<String> getImageLinks() {
		return imageLinks;
	}

	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public String getParentUrl() {
		return parentUrl;
	}
	
	public void setParentUrl(String parentUrl) {
		this.parentUrl = parentUrl;
	}
	
	public String getMetaDescription() {
		return metaDescription;
	}
	
	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}
	
	public String getMetaKeywords() {
		return metaKeywords;
	}
	
	public void setMetaKeywords(String metaKeywords) {
		this.metaKeywords = metaKeywords;
	}
	

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrawlDetails other = (CrawlDetails) obj;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("==============================================================================================================================================================================================================");
		sb.append("\n");
		sb.append("url =" + url + "\n");
		sb.append("title= " + title + "\n");
		sb.append("metaDescription = " + metaDescription + "\n");
		sb.append("metaKeywords = "	+ metaKeywords + "\n");
		sb.append("Internal Link ...."+ "\n");
		internalLinks.forEach(i -> sb.append(i.toString() + "\n"));
		sb.append("External Link ...."+ "\n");
		externalLinks.forEach(i -> sb.append(i.toString() + "\n"));
		sb.append("Images Link ...."+ "\n");
		imageLinks.forEach(i -> sb.append(i.toString()+ "\n"));
		return sb.toString();
	}
	
	
	
	
	
}
