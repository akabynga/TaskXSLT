package com.epam.shop.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.epam.shop.constant.ShopConstant;
import com.epam.shop.dto.ProductDTO;

/**
 * The Class Validator. Validate input fields.
 */
public final class Validator {
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(Validator.class);
	/** The Constant ERROR_EMPTY_FIELD. */
	private static final String ERROR_EMPTY_FIELD = "Empty field";

	/** The Constant ERROR_DATE. */
	private static final String ERROR_DATE = "Write date like a dd-MM-YYYY";

	/** The Constant ERROR_PRICE. */
	private static final String ERROR_PRICE = "Write valide price";

	/** The Constant MATCH_PATTERN_FOR_PRICE. */
	private static final String MATCH_PATTERN_FOR_PRICE = "[0-9]*\\.?[0-9]*";

	/** The Constant MATCH_PATTERN_FOR_DATE. */
	private static final String MATCH_PATTERN_FOR_DATE = "^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$";

	/** The error map. */
	private Map<Object, String> errorMap = new HashMap<Object, String>();

	/**
	 * Instantiates a new validator.
	 */
	public Validator() {
		super();
		LOG.info("Creating 'Validator' object.");
	}

	/**
	 * Validate.
	 * 
	 * @param product
	 *            the product
	 * @return true, if successful
	 */
	public boolean validate(ProductDTO product) {
		boolean priceIsValid = true;
		if (!"true".equals(product.getNotInStock())) {
			priceIsValid = validatePrice(product.getPrice());
		}

		return priceIsValid & validateProducer(product.getProducer())
				& validateColor(product.getColor())
				& validateModel(product.getModel())
				& validateDateOfIssue(product.getDateOfIssue());
	}

	/**
	 * Gets the error map.
	 * 
	 * @return the error map
	 */
	public Map<Object, String> getErrorMap() {
		return errorMap;
	}

	/**
	 * Validate date of issue.
	 * 
	 * @param dateOfIssue
	 *            the date of issue
	 * @return true, if successful
	 */
	private boolean validateDateOfIssue(String dateOfIssue) {
		if (isEmpty(dateOfIssue)) {
			errorMap.put(ShopConstant.VALIDATION_DATE, ERROR_EMPTY_FIELD);
			return false;
		}
		if (!dateOfIssue.matches(MATCH_PATTERN_FOR_DATE)) {
			errorMap.put(ShopConstant.VALIDATION_DATE, ERROR_DATE);
			return false;
		}

		return true;
	}

	/**
	 * Validate model.
	 * 
	 * @param model
	 *            the model
	 * @return true, if successful
	 */
	private boolean validateModel(String model) {
		if (isEmpty(model)) {
			errorMap.put(ShopConstant.VALIDATION_MODEL, ERROR_EMPTY_FIELD);
			return false;
		}
		return true;
	}

	/**
	 * Validate color.
	 * 
	 * @param color
	 *            the color
	 * @return true, if successful
	 */
	private boolean validateColor(String color) {
		if (isEmpty(color)) {
			errorMap.put(ShopConstant.VALIDATION_COLOR, ERROR_EMPTY_FIELD);
			return false;
		}
		return true;
	}

	/**
	 * Validate producer.
	 * 
	 * @param producer
	 *            the producer
	 * @return true, if successful
	 */
	private boolean validateProducer(String producer) {
		if (isEmpty(producer)) {
			errorMap.put(ShopConstant.VALIDATION_PRODUCER, ERROR_EMPTY_FIELD);
			return false;
		}
		return true;
	}

	/**
	 * Validate price.
	 * 
	 * @param price
	 *            the price
	 * @return true, if successful
	 */
	private boolean validatePrice(String price) {
		if (isEmpty(price)) {
			errorMap.put(ShopConstant.VALIDATION_PRICE, ERROR_EMPTY_FIELD);
			return false;
		}
		if (!price.matches(MATCH_PATTERN_FOR_PRICE)) {
			errorMap.put(ShopConstant.VALIDATION_PRICE, ERROR_PRICE);
			return false;
		}
		return true;
	}

	/**
	 * Checks if is empty.
	 * 
	 * @param value
	 *            the value
	 * @return true, if is empty
	 */
	private boolean isEmpty(String value) {
		return value == null || value.length() == 0;
	}

}
