package industry.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Industry {
	/*
	 * Correspond to the user table
	 */
	
	private Integer id;
	private Integer country_id;
	private String industry_type; 
	private Float industry_emission;
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
	 * @return the industry_type
	 */
	public String getIndustry_type() {
		return industry_type;
	}
	/**
	 * @param industry_type the industry_type to set
	 */
	public void setIndustry_type(String industry_type) {
		this.industry_type = industry_type;
	}
	/**
	 * @return the industry_emission
	 */
	public Float getIndustry_emission() {
		return industry_emission;
	}
	/**
	 * @param industry_emission the industry_emission to set
	 */
	public void setIndustry_emission(Float industry_emission) {
		this.industry_emission = industry_emission;
	}
	

}
