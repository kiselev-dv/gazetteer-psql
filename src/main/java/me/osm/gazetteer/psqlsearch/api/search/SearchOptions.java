package me.osm.gazetteer.psqlsearch.api.search;

public class SearchOptions {
	
	private boolean withPrefix = true; 
	private Double lon; 
	private Double lat;
	private boolean noPoi = false;
	
	private boolean fuzzy = true;
	private boolean rangeHouseNumbers = true;
	private boolean verboseAddress;
	
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	public boolean isNoPoi() {
		return noPoi;
	}
	public void setNoPoi(boolean noPoi) {
		this.noPoi = noPoi;
	}
	
	public boolean isWithPrefix() {
		return withPrefix;
	}
	public void setWithPrefix(boolean withPrefix) {
		this.withPrefix = withPrefix;
	}
	
	public boolean isRangeHouseNumbers() {
		return rangeHouseNumbers;
	}
	public void setRangeHouseNumbers(boolean rangeHouseNumbers) {
		this.rangeHouseNumbers = rangeHouseNumbers;
	}
	
	public boolean isFuzzy() {
		return fuzzy;
	}
	public void setFuzzy(boolean fuzzy) {
		this.fuzzy = fuzzy;
	}
	
	public void setVerboseAddress(boolean verboseAddress) {
		this.verboseAddress = verboseAddress;
	}
	public boolean isVerboseAddress() {
		return verboseAddress;
	}
	
}
