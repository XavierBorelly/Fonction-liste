package com.xb.beenTest;

public class Chaussure {

	private String marque;
	private Integer pointure;

	public Chaussure() {
	}

	/**
	 * @param marque
	 * @param pointure
	 */
	public Chaussure(String marque, Integer pointure) {
		super();
		this.marque = marque;
		this.pointure = pointure;
	}

	/**
	 * @return the marque
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * @param marque
	 *            the marque to set
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 * @return the pointure
	 */
	public Integer getPointure() {
		return pointure;
	}

	/**
	 * @param pointure
	 *            the pointure to set
	 */
	public void setPointure(Integer pointure) {
		this.pointure = pointure;
	}

}
