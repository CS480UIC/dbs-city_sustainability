package country.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Country {
	/*
	 * Correspond to the user table
	 */
	
	private Integer id;
	private String country_name; 
	private Float country_population;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}
	/**
	 * @param country_name the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}
	/**
	 * @return the country_population
	 */
	public Float getCountry_population() {
		return country_population;
	}
	/**
	 * @param country_population the country_population to set
	 */
	public void setCountry_population(Float country_population) {
		this.country_population = country_population;
	}
	
	

}
