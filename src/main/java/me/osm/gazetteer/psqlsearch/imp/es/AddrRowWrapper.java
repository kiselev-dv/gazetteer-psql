package me.osm.gazetteer.psqlsearch.imp.es;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;

import me.osm.gazetteer.psqlsearch.query.IndexAnalyzer.Token;

public class AddrRowWrapper {

	private String id;
	private String type;
	private String featureId;
	
	private long osmId;
	private String osmType;
	
	private String fullText;
	private List<Token> name;
	private List<Token> nameOpt;
	private List<Token> nameAlt;
	private int hn;
	private String hnExact;
	private Collection<String> hnVariants;
	private double lon;
	private double lat;
	private List<Token> street;
	private List<Token> streetOpt;
	private List<Token> locality;
	private List<Token> localityOpt;
	private List<Token> neighbourhood;
	private String localityType;
	private String addrSchema;
	private double scoreBase;
	private Timestamp timestamp;
	private JSONObject source;
	private List<String> poiClasses;
	private String hnMatch;
	private List<String> poiKeywords;
	private Map<String, String> refs;

	public void setId(String id) {
		this.id = id;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}

	public void setOSMId(long osmId) {
		this.osmId = osmId;
	}

	public void setOSMType(String osm_type) {
		this.osmType = osm_type;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}
	
	public void setName(List<Token> tokens) {
		this.name = tokens;
	}

	public void setNameOpt(List<Token> tokens) {
		this.nameOpt = tokens;
	}

	public void setNameAlt(List<Token> tokens) {
		this.nameAlt = tokens;
	}

	public void setHN(int hn) {
		this.hn = hn;
	}

	public void setHNExact(String hnExact) {
		this.hnExact = hnExact;
	}

	public void setHNVariants(Collection<String> hnVariants) {
		this.hnVariants = hnVariants;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}

	public void setStreet(List<Token> tokens) {
		this.street = tokens;
	}

	public void setStreetOpt(List<Token> tokens) {
		this.streetOpt = tokens;
	}

	public void setLocality(List<Token> tokens) {
		this.locality = tokens;
	}
	
	public void setLocalityOpt(List<Token> tokens) {
		this.localityOpt = tokens;
	}

	public void setNeighbourhood(List<Token> tokens) {
		this.neighbourhood = tokens;
	}

	public void setLocalityType(String localityType) {
		this.localityType = localityType;
	}

	public void setAddrSchema(String schema) {
		this.addrSchema = schema;
	}

	public void setScoreBase(double score) {
		this.scoreBase = score;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public void setSource(JSONObject jsonObject) {
		this.source = jsonObject;
	}

	public void setPoiClasses(List<String> classes) {
		this.poiClasses = classes;
	}

	public void setHNMatch(String match) {
		this.hnMatch = match;
	}

	public void setPoiKeywords(List<String> keywords) {
		this.poiKeywords = keywords;
	}

	public void setRefs(Map<String, String> refsMap) {
		this.refs = refsMap;
	}

	public String getType() {
		return this.type;
	}

	public List<Token> getName() {
		return this.name;
	}

	public List<Token> getLocality() {
		return this.locality;
	}

	public String getId() {
		return id;
	}

	public String getFeatureId() {
		return featureId;
	}

	public long getOsmId() {
		return osmId;
	}

	public String getOsmType() {
		return osmType;
	}

	public String getFullText() {
		return fullText;
	}

	public List<Token> getNameOpt() {
		return nameOpt;
	}

	public List<Token> getNameAlt() {
		return nameAlt;
	}

	public int getHn() {
		return hn;
	}

	public String getHnExact() {
		return hnExact;
	}

	public Collection<String> getHnVariants() {
		return hnVariants;
	}

	public double getLon() {
		return lon;
	}

	public double getLat() {
		return lat;
	}

	public List<Token> getStreet() {
		return street;
	}

	public List<Token> getStreetOpt() {
		return streetOpt;
	}

	public List<Token> getLocalityOpt() {
		return localityOpt;
	}

	public List<Token> getNeighbourhood() {
		return neighbourhood;
	}

	public String getLocalityType() {
		return localityType;
	}

	public String getAddrSchema() {
		return addrSchema;
	}

	public double getScoreBase() {
		return scoreBase;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public JSONObject getSource() {
		return source;
	}

	public List<String> getPoiClasses() {
		return poiClasses;
	}

	public String getHnMatch() {
		return hnMatch;
	}

	public List<String> getPoiKeywords() {
		return poiKeywords;
	}

	public Map<String, String> getRefs() {
		return refs;
	}

	public JSONObject getJsonForIndex() {
		JSONObject obj = new JSONObject();
		
		obj.put("id", id);
		obj.put("type", type);
		obj.put("feature_id", featureId);
		
		obj.put("osm_id", "" + osmType.charAt(0) + osmId);

		obj.put("full_text", fullText);
		
		obj.put("name", asStringList(name));
		obj.put("name_opt", asStringList(nameOpt));
		obj.put("name_alt", asStringList(nameAlt));
		
		if (hn > 0) {
			obj.put("housenumber_number", hn);
		}
		obj.put("housenumber_exact", hnExact);
		obj.put("housenumber_array", hnVariants);
		
		obj.put("centroid", getCentroidJSON());
		
		obj.put("street", asStringList(street));
		obj.put("street_opt", asStringList(streetOpt));
		//obj.put("street_type", streetType);

		obj.put("locality", asStringList(locality));
		obj.put("locality_opt", asStringList(localityOpt));
		obj.put("locality_type", localityType);

		obj.put("neighbourhood", asStringList(neighbourhood));
		
		obj.put("addr_schema", addrSchema);

		obj.put("refs", new JSONObject(refs));
		
		obj.put("poi_classes", poiClasses);
		obj.put("poi_keywords", poiKeywords);
		obj.put("hm_match", hnMatch);
		
		obj.put("created", timestamp.getTime());
		
		obj.put("base_score", scoreBase);
		obj.put("json", source);
		
		return obj;
	}

	private JSONObject getCentroidJSON() {
		JSONObject centroid = new JSONObject();
		centroid.put("lon", lon);
		centroid.put("lat", lat);
		return centroid;
	}

	private Collection<String> asStringList(List<Token> tokens) {
		List<String> result = new ArrayList<>();
		if(tokens != null) {
			for(Token t : tokens) {
				if (StringUtils.stripToNull(t.token) != null) {
					result.add(t.token);
				}
			}
		}
		
		return result;
	}
	
}
