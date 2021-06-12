package pojoClasses;

import java.util.HashMap;
import java.util.Map;

@javax.annotation.processing.Generated("jsonschema2pojo")
public class Example {

	private long charityType;
	private String imageSource;
	private String darkModeImageSource;
	private String description;
	private String tagline;
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Example() {
	}

	/**
	 *
	 * @param darkModeImageSource
	 * @param imageSource
	 * @param description
	 * @param tagline
	 * @param charityType
	 */
	public Example(long charityType, String imageSource, String darkModeImageSource, String description,
			String tagline) {
		super();
		this.charityType = charityType;
		this.imageSource = imageSource;
		this.darkModeImageSource = darkModeImageSource;
		this.description = description;
		this.tagline = tagline;
	}

	public long getCharityType() {
		return charityType;
	}

	public void setCharityType(long charityType) {
		this.charityType = charityType;
	}

	public Example withCharityType(long charityType) {
		this.charityType = charityType;
		return this;
	}

	public String getImageSource() {
		return imageSource;
	}

	public void setImageSource(String imageSource) {
		this.imageSource = imageSource;
	}

	public Example withImageSource(String imageSource) {
		this.imageSource = imageSource;
		return this;
	}

	public String getDarkModeImageSource() {
		return darkModeImageSource;
	}

	public void setDarkModeImageSource(String darkModeImageSource) {
		this.darkModeImageSource = darkModeImageSource;
	}

	public Example withDarkModeImageSource(String darkModeImageSource) {
		this.darkModeImageSource = darkModeImageSource;
		return this;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Example withDescription(String description) {
		this.description = description;
		return this;
	}

	public String getTagline() {
		return tagline;
	}

	public void setTagline(String tagline) {
		this.tagline = tagline;
	}

	public Example withTagline(String tagline) {
		this.tagline = tagline;
		return this;
	}

	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Example withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

}