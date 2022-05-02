package carbon_emission_target.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Carbon_emission_target {
	/*
	 * Correspond to the user table
	 */
	
	private Integer cet_id;
	private Integer city_id;
	private Integer base_year; 
	private Float base_emission;
	private Integer target_year;
	private Float target_emission;
	/**
	 * @return the cet_id
	 */
	public Integer getCet_id() {
		return cet_id;
	}
	/**
	 * @param cet_id the cet_id to set
	 */
	public void setCet_id(Integer cet_id) {
		this.cet_id = cet_id;
	}
	/**
	 * @return the cet_city_id
	 */
	public Integer getCity_id() {
		return city_id;
	}
	/**
	 * @param cet_city_id the cet_city_id to set
	 */
	public void setCity_id(Integer city_id) {
		this.city_id = city_id;
	}
	/**
	 * @return the base_year
	 */
	public Integer getBase_year() {
		return base_year;
	}
	/**
	 * @param base_year the base_year to set
	 */
	public void setBase_year(Integer base_year) {
		this.base_year = base_year;
	}
	/**
	 * @return the base_emission
	 */
	public Float getBase_emission() {
		return base_emission;
	}
	/**
	 * @param base_emission the base_emission to set
	 */
	public void setBase_emission(Float base_emission) {
		this.base_emission = base_emission;
	}
	/**
	 * @return the target_year
	 */
	public Integer getTarget_year() {
		return target_year;
	}
	/**
	 * @param target_year the target_year to set
	 */
	public void setTarget_year(Integer target_year) {
		this.target_year = target_year;
	}
	/**
	 * @return the target_emission
	 */
	public Float getTarget_emission() {
		return target_emission;
	}
	/**
	 * @param target_emission the target_emission to set
	 */
	public void setTarget_emission(Float target_emission) {
		this.target_emission = target_emission;
	}
}
