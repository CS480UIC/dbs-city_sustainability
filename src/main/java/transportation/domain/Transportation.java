package transportation.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Transportation {
	/*
	 * Correspond to the user table
	 */
	
	private Integer idtransportation_id;
	private Integer target_id;
	private Float car_population;
	private Float car_emission;
	private Float public_usage;
	private Float public_emission;
	/**
	 * @return the idtransportation_id
	 */
	public Integer getIdtransportation_id() {
		return idtransportation_id;
	}
	/**
	 * @param idtransportation_id the idtransportation_id to set
	 */
	public void setIdtransportation_id(Integer idtransportation_id) {
		this.idtransportation_id = idtransportation_id;
	}
	/**
	 * @return the target_id
	 */
	public Integer getTarget_id() {
		return target_id;
	}
	/**
	 * @param target_id the target_id to set
	 */
	public void setTarget_id(Integer target_id) {
		this.target_id = target_id;
	}
	/**
	 * @return the car_population
	 */
	public Float getCar_population() {
		return car_population;
	}
	/**
	 * @param car_population the car_population to set
	 */
	public void setCar_population(Float car_population) {
		this.car_population = car_population;
	}
	/**
	 * @return the car_emission
	 */
	public Float getCar_emission() {
		return car_emission;
	}
	/**
	 * @param car_emission the car_emission to set
	 */
	public void setCar_emission(Float car_emission) {
		this.car_emission = car_emission;
	}
	/**
	 * @return the public_usage
	 */
	public Float getPublic_usage() {
		return public_usage;
	}
	/**
	 * @param public_usage the public_usage to set
	 */
	public void setPublic_usage(Float public_usage) {
		this.public_usage = public_usage;
	}
	/**
	 * @return the public_emission
	 */
	public Float getPublic_emission() {
		return public_emission;
	}
	/**
	 * @param public_emission the public_emission to set
	 */
	public void setPublic_emission(Float public_emission) {
		this.public_emission = public_emission;
	}
	
}
