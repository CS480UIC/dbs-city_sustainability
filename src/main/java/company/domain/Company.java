package company.domain;

/**
 * User object
 * 
 * @author Aayush Makharia
 * 
 */
public class Company {
	/*
	 * Correspond to the user table
	 */
	
	private Integer id;
	private Integer industry_id;
	private String company_name; 
	private Float company_emission;
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
	 * @return the industry_id
	 */
	public Integer getIndustry_id() {
		return industry_id;
	}
	/**
	 * @param industry_id the industry_id to set
	 */
	public void setIndustry_id(Integer industry_id) {
		this.industry_id = industry_id;
	}
	/**
	 * @return the company_name
	 */
	public String getCompany_name() {
		return company_name;
	}
	/**
	 * @param company_name the company_name to set
	 */
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	/**
	 * @return the company_emission
	 */
	public Float getCompany_emission() {
		return company_emission;
	}
	/**
	 * @param company_emission the company_emission to set
	 */
	public void setCompany_emission(Float company_emission) {
		this.company_emission = company_emission;
	}

}
