package com.epam.shop.beans;

import java.io.Serializable;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * The Class Product.
 */
public class Product implements Cloneable, Serializable {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(Product.class);
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3012778086193695318L;

	/** The id. */
	private int id;

	/** The model. */
	private String model;

	/** The price. */
	private double price;

	/** The producer. */
	private String producer;

	/** The color. */
	private String color;

	/** The date of issue. */
	private Date dateOfIssue; // (dd-MM-YYYY)

	/** The not in stock. */
	private boolean notInStock;

	/**
	 * Instantiates a new product.
	 */
	public Product() {
		super();
		LOG.info("Creating 'Product' object.");
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
	public Product(String model, String color, Date dateOfIssue, double price,
			String producer, boolean notInStock) {
		this.model = model;
		this.producer = producer;
		this.dateOfIssue = dateOfIssue;
		this.notInStock = notInStock;
		this.price = price;
		this.color = color;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(int id) {
		this.id = id;
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
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 * 
	 * @param price
	 *            the new price
	 */
	public void setPrice(double price) {
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
	public Date getDateOfIssue() {
		return dateOfIssue;
	}

	/**
	 * Sets the date of issue.
	 * 
	 * @param dateOfIssue
	 *            the new date of issue
	 */
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}

	/**
	 * Checks if is not in stock.
	 * 
	 * @return true, if is not in stock
	 */
	public boolean isNotInStock() {
		return notInStock;
	}

	/**
	 * Sets the not in stock.
	 * 
	 * @param notInStock
	 *            the new not in stock
	 */
	public void setNotInStock(boolean notInStock) {
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
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (notInStock ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Product other = (Product) obj;
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
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (notInStock != other.notInStock)
			return false;
		if (Double.doubleToLongBits(price) != Double
				.doubleToLongBits(other.price))
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
	public Product clone() throws CloneNotSupportedException {
		Product obj = (Product) super.clone();
		obj.dateOfIssue = (Date) dateOfIssue.clone();
		return obj;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder builder = new StringBuilder().append(getClass()).append(
				"\n");
		builder.append("Product Id: ").append(id).append("\n");
		builder.append("Model: ").append(model).append("\n");
		builder.append("Color: ").append(color).append("\n");
		builder.append("Not in stock: ").append(notInStock).append("\n");
		builder.append("Price: ").append(price).append("\n");
		builder.append("Producer: ").append(producer).append("\n");
		builder.append("Date of issue: ").append(dateOfIssue).append("\n");

		return builder.toString();
	}
}
