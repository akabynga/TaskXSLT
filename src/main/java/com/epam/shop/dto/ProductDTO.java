package com.epam.shop.dto;

import java.io.Serializable;

import org.apache.log4j.Logger;

/**
 * The Class Product data transfer object.
 */
public class ProductDTO implements Cloneable, Serializable {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ProductDTO.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3012778086193695318L;

	/** The model. */
	private String model;

	/** The price. */
	private String price;

	/** The producer. */
	private String producer;

	/** The color. */
	private String color;

	/** The date of issue. */
	private String dateOfIssue; // (dd-MM-YYYY)

	/** The not in stock. */
	private String notInStock;

	/**
	 * Instantiates a new product.
	 */
	public ProductDTO() {
		super();
		LOG.info("Create 'ProductDTO' object.");
	}

	/**
	 * Instantiates a new product.
	 * 
	 * @param model
	 *            the model
	 * @param color
	 *            the color
	 * @param dateOfIssue
	 *            the date of issue
	 * @param price
	 *            the price
	 * @param producer
	 *            the producer
	 * @param notInStock
	 *            the not in stock
	 */
	public ProductDTO(String model, String color, String dateOfIssue,
			String price, String producer, String notInStock) {
		this.model = model;
		this.producer = producer;
		this.dateOfIssue = dateOfIssue;
		this.notInStock = notInStock;
		this.price = price;
		this.color = color;
	}

	/**
	 * Gets the model.
	 * 
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Sets the model.
	 * 
	 * @param model
	 *            the new model
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * Gets the price.
	 * 
	 * @return the price
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(String price) {
		this.price = price;
	}

	/**
	 * Gets the producer.
	 * 
	 * @return the producer
	 */
	public String getProducer() {
		return producer;
	}

	/**
	 * Sets the producer.
	 * 
	 * @param producer
	 *            the new producer
	 */
	public void setProducer(String producer) {
		this.producer = producer;
	}

	/**
	 * Gets the color.
	 * 
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the color.
	 * 
	 * @param color
	 *            the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Gets the date of issue.
	 * 
	 * @return the date of issue
	 */
	public String getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * Sets the date of issue.
	 * 
	 * @param dateOfIssue
	 *            the new date of issue
	 */
	public void setDateOfIssue(String dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	/**
	 * Checks if is not in stock.
	 * 
	 * @return true, if is not in stock
	 */
	public String getNotInStock() {
		return notInStock;
	}

	/**
	 * Sets the not in stock.
	 * 
	 * @param notInStock
	 *            the new not in stock
	 */
	public void setNotInStock(String notInStock) {
		this.notInStock = notInStock;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result
				+ ((dateOfIssue == null) ? 0 : dateOfIssue.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result
				+ ((notInStock == null) ? 0 : notInStock.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((producer == null) ? 0 : producer.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (dateOfIssue == null) {
			if (other.dateOfIssue != null)
				return false;
		} else if (!dateOfIssue.equals(other.dateOfIssue))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (notInStock == null) {
			if (other.notInStock != null)
				return false;
		} else if (!notInStock.equals(other.notInStock))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (producer == null) {
			if (other.producer != null)
				return false;
		} else if (!producer.equals(other.producer))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#clone()
	 */
	public ProductDTO clone() throws CloneNotSupportedException {
		return (ProductDTO) super.clone();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder().append(getClass()).append(
				"\n");
		builder.append("Model: ").append(model).append("\n");
		builder.append("Color: ").append(color).append("\n");
		builder.append("Not in stock: ").append(notInStock).append("\n");
		builder.append("Price: ").append(price).append("\n");
		builder.append("Producer: ").append(producer).append("\n");
		builder.append("Date of issue: ").append(dateOfIssue).append("\n");

		return builder.toString();
	}
}
