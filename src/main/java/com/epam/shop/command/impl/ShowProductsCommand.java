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
import com.epam.shop.util.TransformerManager;

/**
 * The Class ShowProductsCommand. Using for showing all products selected
 * category.
 */
public final class ShowProductsCommand extends AbstractionCommand {

	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(ShowProductsCommand.class);

	/**
	 * Instantiates a new show products command.
	 */
	public ShowProductsCommand() {
		super();
		LOG.info("Creating 'ShowProductsCommand' object.");
	}

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
				Path.XSL_PRODUCTS);
		Map<String, Object> paramMap = createParamMap(request);

		try (PrintWriter writer = response.getWriter();) {
			readLock.lock();
			LOG.warn("Locking read lock.");
			TransformerManager.transformation(pathXSL, writer, paramMap);
		} catch (TransformerException e) {
			LOG.error("TransformerException.", e);
		} finally {
			readLock.unlock();
			LOG.warn("Unlocking read lock.");
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

		Map<String, Object> paramMap = new HashMap<String, Object>();
		String category = getCategoryParam(request);
		String subcategory = getSubcategoryParam(request);

		LOG.info("Put to param map category: " + category);
		LOG.info("Put to param map subcategory: " + subcategory);

		paramMap.put(ShopConstant.PARAM_SUBCATEGORY, subcategory);
		paramMap.put(ShopConstant.PARAM_CATEGORY, category);

		return paramMap;
	}
}
