package com.epam.shop.command;

import java.io.IOException;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.shop.constant.ShopConstant;

/**
 * The Class ICommand interface for command.
 */
public abstract class AbstractionCommand {

	/** The Constant reentrant read write lock. */
	public static final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	/** The Constant readLock. */
	public static final ReentrantReadWriteLock.ReadLock readLock = rwl
			.readLock();

	/** The Constant writeLock. */
	public static final ReentrantReadWriteLock.WriteLock writeLock = rwl
			.writeLock();

	/**
	 * Execute.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ServletException
	 *             the servlet exception
	 */
	public abstract void execute(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException;

	/**
	 * Gets the category param.
	 * 
	 * @param request
	 *            the request
	 * @return the category param
	 */
	protected String getCategoryParam(HttpServletRequest request) {
		String category = (String) request
				.getParameter(ShopConstant.PARAM_CATEGORY);

		if (category != null) {
			request.getSession().setAttribute(ShopConstant.PARAM_CATEGORY,
					category);
		} else {
			category = (String) request.getSession().getAttribute(
					ShopConstant.PARAM_CATEGORY);
		}
		return category;
	}

	/**
	 * Gets the subcategory param.
	 * 
	 * @param request
	 *            the request
	 * @return the subcategory param
	 */
	protected String getSubcategoryParam(HttpServletRequest request) {
		String subcategory = (String) request
				.getParameter(ShopConstant.PARAM_SUBCATEGORY);

		if (subcategory != null) {
			request.getSession().setAttribute(ShopConstant.PARAM_SUBCATEGORY,
					subcategory);
		} else {
			subcategory = (String) request.getSession().getAttribute(
					ShopConstant.PARAM_SUBCATEGORY);
		}
		return subcategory;
	}
}
