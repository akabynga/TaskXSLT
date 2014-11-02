package com.epam.shop.command.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;

import com.epam.shop.command.AbstractionCommand;
import com.epam.shop.constant.Path;
import com.epam.shop.constant.ShopConstant;
import com.epam.shop.dto.ProductDTO;
import com.epam.shop.util.TransformerManager;
import com.epam.shop.util.Validator;

/**
 * The Class SaveProductCommand. Using for saving new product.
 */
public final class SaveProductCommand extends AbstractionCommand {

	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(SaveProductCommand.class);

	/**
	 * Instantiates a new save product command.
	 */
	public SaveProductCommand() {
		super();
		LOG.info("Creating 'SaveProductCommand' object.");
	}

	/** The Constant PARAM_VALIDATOR. */
	public static final String PARAM_VALIDATOR = "validator";

	/** The Constant PARAM_XML_PATH. */
	public static final String PARAM_XML_PATH = "xmlFile";

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.epam.shop.command.ICommand#execute(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String pathXSL = request.getServletContext().getRealPath(
				Path.XSL_SAVE_PRODUCT);
		Map<String, Object> paramMap = createParamMap(request);

		try (PrintWriter writer = response.getWriter();) {
			writeLock.lock();
			LOG.warn("Locking write lock");
			TransformerManager.transformation(pathXSL, writer, paramMap);
		} catch (TransformerException e) {
			LOG.error("TransformerException.", e);
		} finally {
			writeLock.unlock();
			LOG.warn("Unlocking write lock");
		}

	}

	/**
	 * Creates the param map.
	 * 
	 * @param request
	 *            the request
	 * @return the map
	 */
	private Map<String, Object> createParamMap(HttpServletRequest request) {

		ProductDTO product = creatingProduct(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		String category = getCategoryParam(request);
		String subcategory = getSubcategoryParam(request);
		String pathXML = Path.XML_SHOP;
		Validator validator = new Validator();

		LOG.info("Put to param map product object: " + product);
		LOG.info("Put to param map validator object: " + validator);
		LOG.info("Put to param map pathXML: " + pathXML);
		LOG.info("Put to param map category: " + category);
		LOG.info("Put to param map validator object: " + subcategory);

		paramMap.put(ShopConstant.PARAM_PRODUCT, product);
		paramMap.put(PARAM_VALIDATOR, validator);
		paramMap.put(PARAM_XML_PATH, pathXML);
		paramMap.put(ShopConstant.PARAM_CATEGORY, category);
		paramMap.put(ShopConstant.PARAM_SUBCATEGORY, subcategory);

		return paramMap;
	}

	/**
	 * Creating product.
	 * 
	 * @param request
	 *            the request
	 * @return the product dto
	 */
	private ProductDTO creatingProduct(HttpServletRequest request) {

		ProductDTO product = new ProductDTO();
		product.setProducer(request.getParameter(ShopConstant.PARAM_PRODUCER));
		product.setModel(request.getParameter(ShopConstant.PARAM_MODEL));
		product.setDateOfIssue(request
				.getParameter(ShopConstant.PARAM_DATE_OF_ISSUE));
		product.setColor(request.getParameter(ShopConstant.PARAM_COLOR));

		if (!ShopConstant.PARAM_ON.equals(request.getParameter("notInStock"))) {
			product.setPrice(request.getParameter(ShopConstant.PARAM_PRICE));
		} else {
			product.setNotInStock("true");
		}

		return product;
	}
}
