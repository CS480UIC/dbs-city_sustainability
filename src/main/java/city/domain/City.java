package city.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class City {
	/*
	 * Correspond to the user table
	 */
	
	private Integer id;
	private Integer country_id;
	private String city_name; 
	private Float city_population;
	private Float city_density;
	
	/**
	 * @return the country_id
	 */
	public Integer getCountry_id() {
		return country_id;
	}
	/**
	 * @param country_id the country_id to set
	 */
	public void setCountry_id(Integer country_id) {
		this.country_id = country_id;
	}

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
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}
	/**
	 * @param city_name the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
	/**
	 * @return the city_population
	 */
	public Float getCity_population() {
		return city_population;
	}
	/**
	 * @param city_population the city_population to set
	 */
	public void setCity_population(Float city_population) {
		this.city_population = city_population;
	}
	/**
	 * @return the city_density
	 */
	public Float getCity_density() {
		return city_density;
	}
	/**
	 * @param city_density the city_density to set
	 */
	public void setCity_density(Float city_density) {
		this.city_density = city_density;
	}

}
