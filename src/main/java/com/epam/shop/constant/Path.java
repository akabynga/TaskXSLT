package com.epam.shop.constant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * The Class Path.
 */
public final class Path implements ServletContextListener {

	/**
	 * Instantiates a new path.
	 */
	public Path() {
		super();
	}

	/** The Constant XML_SHOP. */
	public static String XML_SHOP = null;

	/** The Constant XSL_ADD_PRODUCT. */
	public static final String XSL_ADD_PRODUCT = "WEB-INF/XSL/addProduct.xsl";

	/** The Constant XSL_SAVE_PRODUCT. */
	public static final String XSL_SAVE_PRODUCT = "WEB-INF/XSL/saveProduct.xsl";

	/** The Constant XSL_CATEGORY. */
	public static final String XSL_CATEGORY = "WEB-INF/XSL/showCategory.xsl";

	/** The Constant XSL_SUBCATEGORY. */
	public static final String XSL_SUBCATEGORY = "WEB-INF/XSL/showSubcategory.xsl";

	/** The Constant XSL_PRODUCTS. */
	public static final String XSL_PRODUCTS = "WEB-INF/XSL/showProducts.xsl";

	/** The Constant CONTENT_TYPE. */
	public static final String CONTENT_TYPE = "text/html";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent context) {
		// no need to realize

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet
	 * .ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent context) {
		XML_SHOP = context.getServletContext().getRealPath(
				"WEB-INF/xml/shop.xml");
		System.out.println(XML_SHOP);

	}

}
