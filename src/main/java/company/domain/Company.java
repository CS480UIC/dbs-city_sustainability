package company.domain;

/**
 * Company object
 * 
 * @author Bryan Zbojna
 * 
 */
public class Company {
	/*
	 * Correspond to the Company table
	 */
	
	private Integer companyID;
	private Integer industryID; 
	private String companyName;
	private Float companyEmission;
	
	
	/**
	 * @return the companyID
	 */
	public Integer getCompanyID() {
		return companyID;
	}
	/**
	 * @param companyID the companyID to set
	 */
	public void setCompanyID(Integer companyID) {
		this.companyID = companyID;
	}
	/**
	 * @return the industryID
	 */
	public Integer getIndustryID() {
		return industryID;
	}
	/**
	 * @param industryID the industryID to set
	 */
	public void setIndustryID(Integer industryID) {
		this.industryID = industryID;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the companyEmission
	 */
	public Float getCompanyEmission() {
		return companyEmission;
	}
	/**
	 * @param companyEmission the companyEmission to set
	 */
	public void setCompanyEmission(Float companyEmission) {
		this.companyEmission = companyEmission;
	}
}
