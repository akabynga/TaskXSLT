package com.epam.shop.util;

import org.apache.log4j.Logger;

import com.epam.shop.constant.ShopConstant;
import com.epam.shop.dto.ProductDTO;

/**
 * The Class ValidatorHandler.
 */
public final class ValidatorHandler {
	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ValidatorHandler.class);

	/**
	 * Instantiates a new validator handler.
	 */
	public ValidatorHandler() {
		super();
		LOG.info("Creating 'ValidatorHandler' object.");
	}

	/**
	 * Validate.
	 * 
	 * @param validator
	 *            the validator
	 * @param product
	 *            the product
	 * @return true, if successful
	 */
	public boolean validate(Object validator, Object product) {

		boolean result = ((Validator) validator).validate((ProductDTO) product);
		LOG.info("Result validation: " + result);

		return result;
	}

	/**
	 * Gets the producer error.
	 * 
	 * @param validator
	 *            the validator
	 * @return the producer error
	 */
	public String getProducerError(Object validator) {
		return ((Validator) validator).getErrorMap().get(
				ShopConstant.VALIDATION_PRODUCER);
	}

	/**
	 * Gets the model error.
	 * 
	 * @param validator
	 *            the validator
	 * @return the model error
	 */
	public String getModelError(Object validator) {
		return ((Validator) validator).getErrorMap().get(
				ShopConstant.VALIDATION_MODEL);
	}

	/**
	 * Gets the date of issue error.
	 * 
	 * @param validator
	 *            the validator
	 * @return the date of issue error
	 */
	public String getDateOfIssueError(Object validator) {
		return ((Validator) validator).getErrorMap().get(
				ShopConstant.VALIDATION_DATE);
	}

	/**
	 * Gets the color error.
	 * 
	 * @param validator
	 *            the validator
	 * @return the color error
	 */
	public String getColorError(Object validator) {
		return ((Validator) validator).getErrorMap().get(
				ShopConstant.VALIDATION_COLOR);
	}

	/**
	 * Gets the price error.
	 * 
	 * @param validator
	 *            the validator
	 * @return the price error
	 */
	public String getPriceError(Object validator) {
		return ((Validator) validator).getErrorMap().get(
				ShopConstant.VALIDATION_PRICE);
	}

	/**
	 * Gets the errors.
	 * 
	 * @param validator
	 *            the validator
	 * @return the errors
	 */
	public boolean getErrors(Validator validator) {
		return validator.getErrorMap().isEmpty();
	}
}
