package energy_management.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Energy_management {
	/*
	 * Correspond to the user table
	 */
	
	private Integer em_id;
	private Integer em_city_id; 
	private Float energy_production;
	private Float energy_consumption;
	private Float energy_management;
	/**
	 * @return the em_id
	 */
	public Integer getEm_id() {
		return em_id;
	}
	/**
	 * @param em_id the em_id to set
	 */
	public void setEm_id(Integer em_id) {
		this.em_id = em_id;
	}
	/**
	 * @return the em_city_id
	 */
	public Integer getCity_id() {
		return em_city_id;
	}
	/**
	 * @param em_city_id the em_city_id to set
	 */
	public void setCity_id(Integer em_city_id) {
		this.em_city_id = em_city_id;
	}
	/**
	 * @return the energy_production
	 */
	public Float getEnergy_production() {
		return energy_production;
	}
	/**
	 * @param energy_production the energy_production to set
	 */
	public void setEnergy_production(Float energy_production) {
		this.energy_production = energy_production;
	}
	/**
	 * @return the energy_consumption
	 */
	public Float getEnergy_consumption() {
		return energy_consumption;
	}
	/**
	 * @param energy_consumption the energy_consumption to set
	 */
	public void setEnergy_consumption(Float energy_consumption) {
		this.energy_consumption = energy_consumption;
	}
	/**
	 * @return the energy_management
	 */
	public Float getEnergy_management() {
		return energy_management;
	}
	/**
	 * @param energy_management the energy_management to set
	 */
	public void setEnergy_management(Float energy_management) {
		this.energy_management = energy_management;
	}

}
