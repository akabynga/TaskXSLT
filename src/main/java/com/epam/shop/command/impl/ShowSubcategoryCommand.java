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
 * The Class ShowSubcategoryCommand. Using for showing all subcategories.
 */
public final class ShowSubcategoryCommand extends AbstractionCommand {

	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(ShowSubcategoryCommand.class);

	/**
	 * Instantiates a new show subcategory command.
	 */
	public ShowSubcategoryCommand() {
		super();
		LOG.info("Creating 'ShowSubcategoryCommand' object.");
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
				Path.XSL_SUBCATEGORY);
		Map<String, Object> paramMap = createParamMap(request);

		try (PrintWriter writer = response.getWriter();) {
			readLock.lock();
			LOG.info("Locking read lock.");
			TransformerManager.transformation(pathXSL, writer, paramMap);
		} catch (TransformerException e) {
			LOG.error("TransformerException", e);
		} finally {
			readLock.unlock();
			LOG.info("Unlocking read lock.");
		}

	}

	/**
	 * Creates the map with param.
	 * 
	 * @param request
	 *            the request
	 * @return the map
	 */
	private Map<String, Object> createParamMap(HttpServletRequest request) {

		String category = getCategoryParam(request);
		Map<String, Object> paramMap = new HashMap<String, Object>();

		LOG.info("Put to param map category:" + category);

		paramMap.put(ShopConstant.PARAM_CATEGORY, category);

		return paramMap;
	}

}
