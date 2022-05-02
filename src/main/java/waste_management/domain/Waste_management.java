package waste_management.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Waste_management {
	/*
	 * Correspond to the user table
	 */
	
	private Integer wm_id;
	private Integer wm_city_id; 
	private Float pollution_rate;
	private Float recycle_rate;
	/**
	 * @return the wm_id
	 */
	public Integer getWm_id() {
		return wm_id;
	}
	/**
	 * @param wm_id the wm_id to set
	 */
	public void setWm_id(Integer wm_id) {
		this.wm_id = wm_id;
	}
	/**
	 * @return the wm_city_id
	 */
	public Integer getCity_id() {
		return wm_city_id;
	}
	/**
	 * @param wm_city_id the wm_city_id to set
	 */
	public void setCity_id(Integer wm_city_id) {
		this.wm_city_id = wm_city_id;
	}
	/**
	 * @return the pollution_rate
	 */
	public Float getPollution_rate() {
		return pollution_rate;
	}
	/**
	 * @param pollution_rate the pollution_rate to set
	 */
	public void setPollution_rate(Float pollution_rate) {
		this.pollution_rate = pollution_rate;
	}
	/**
	 * @return the recycle_rate
	 */
	public Float getRecycle_rate() {
		return recycle_rate;
	}
	/**
	 * @param recycle_rate the recycle_rate to set
	 */
	public void setRecycle_rate(Float recycle_rate) {
		this.recycle_rate = recycle_rate;
	}
}
