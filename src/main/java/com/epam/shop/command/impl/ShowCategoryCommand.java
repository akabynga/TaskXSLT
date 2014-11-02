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
 * The Class ShowCategoryCommand. Using for showing all categories.
 */
public final class ShowCategoryCommand extends AbstractionCommand {

	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(ShowCategoryCommand.class);

	/**
	 * Instantiates a new show category command.
	 */
	public ShowCategoryCommand() {
		super();
		LOG.info("Creating'ShowCategoryCommand' object.");
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
				Path.XSL_CATEGORY);

		try (PrintWriter writer = response.getWriter();) {
			readLock.lock();// add read lock
			LOG.warn("Locking read lock.");
			TransformerManager.transformation(pathXSL, writer);
		} catch (TransformerException e) {
			LOG.error("TransformerException.", e);
		} finally {
			readLock.unlock();
			LOG.warn("Unlocking write lock");
		}

	}
}
