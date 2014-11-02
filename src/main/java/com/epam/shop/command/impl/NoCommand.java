package com.epam.shop.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.epam.shop.command.AbstractionCommand;

/**
 * The Class NoCommand.
 */
public final class NoCommand extends AbstractionCommand {

	/** The Constant LOG. */
	private static final Logger LOG = Logger.getLogger(NoCommand.class);

	/**
	 * Instantiates a new no command.
	 */
	public NoCommand() {
		super();
		LOG.info("Creating 'NoCommand' object.");
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
		// no need to put any lock
	}

}
