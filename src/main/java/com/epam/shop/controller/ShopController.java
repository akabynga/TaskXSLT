package com.epam.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.shop.command.AbstractionCommand;
import com.epam.shop.command.CommandFactory;
import com.epam.shop.constant.Path;
import com.epam.shop.constant.ShopConstant;

/**
 * The Class ShopController.
 */
public final class ShopController extends HttpServlet {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(ShopController.class);

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3426777029644638876L;

	/**
	 * Process request.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	private void processRequest(HttpServletRequest request,
			HttpServletResponse response) {
		String commandName = request.getParameter(ShopConstant.PARAM_COMMAND);
		AbstractionCommand command = CommandFactory.createCommand(commandName);

		try {
			response.setContentType(Path.CONTENT_TYPE);
			command.execute(request, response);
		} catch (IOException e) {
			LOG.error("IOException.", e);
		} catch (ServletException e) {
			LOG.error("ServletException.", e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest
	 * , javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		processRequest(req, resp);
	}

}
