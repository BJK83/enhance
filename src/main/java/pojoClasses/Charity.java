package pojoClasses;
import java.util.HashMap;

import com.sun.tools.javac.util.List;
import com.sun.tools.javac.util.List;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Charity {

	

    @JsonProperty("CharityType")
	private int CharityType; 
    public int getCharityType() {
		return CharityType;
	}
	public void setCharityType(int charityType) {
		this.CharityType = charityType;
	}
	public String getImageSource() {
		return ImageSource;
	}
	public void setImageSource(String imageSource) {
		this.ImageSource = imageSource;
	}
	public String getDarkModeImageSource() {
		return DarkModeImageSource;
	}
	public void setDarkModeImageSource(String darkModeImageSource) {
		this.DarkModeImageSource = darkModeImageSource;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}
	public String getTagline() {
		return Tagline;
	}
	public void setTagline(String tagline) {
		this.Tagline = tagline;
	}
	public Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}
	public void setAdditionalProperties(Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
	@JsonProperty("ImageSource")
    private String ImageSource; 
    @JsonProperty("DarkModeImageSource")
    private String DarkModeImageSource; 
    @JsonProperty("Description")
    private String Description; 
    @JsonProperty("Tagline")
    private String Tagline;
    @JsonProperty("additionalProperties")
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
