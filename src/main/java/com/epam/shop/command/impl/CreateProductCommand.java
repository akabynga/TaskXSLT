package com.epam.shop.command.impl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerException;

import org.apache.log4j.Logger;

import com.epam.shop.command.AbstractionCommand;
import com.epam.shop.constant.Path;
import com.epam.shop.util.TransformerManager;

/**
 * The Class CreateProductCommand. Using for transition to adding form.
 */
public final class CreateProductCommand extends AbstractionCommand {

	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(CreateProductCommand.class);

	/**
	 * Instantiates a new creates the product command.
	 */
	public CreateProductCommand() {
		super();
		LOG.info("Creating 'CreateProductCommand' object");
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
				Path.XSL_ADD_PRODUCT);

		// no need to put any lock
		try (PrintWriter writer = response.getWriter();) {
			TransformerManager.transformation(pathXSL, writer);
		} catch (TransformerException e) {
			LOG.error("TransformerException.", e);
		}

	}
}
