package com.epam.shop.util;

import java.io.PrintWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.transform.Source;
import javax.xml.transform.Templates;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.log4j.Logger;

import com.epam.shop.constant.Path;

/**
 * The Class TransformerManager.
 */
public final class TransformerManager {

	/** The Constant LOG. */
	private static final Logger LOG = Logger
			.getLogger(TransformerManager.class);

	/** The cache. */
	private static ConcurrentHashMap<String, Templates> cache = new ConcurrentHashMap<String, Templates>();

	/** The transformer factory. */
	private static TransformerFactory transformerFactory = TransformerFactory
			.newInstance();

	/**
	 * Instantiates a new transformer manager.
	 */
	public TransformerManager() {
		super();
		LOG.info("Creating 'TransformManager' object.");
	}

	/**
	 * Transformation.
	 * 
	 * @param xslPath
	 *            the xsl path
	 * @param writer
	 *            the writer
	 * @param paramMap
	 *            the param map
	 * @throws TransformerException
	 *             the transformer exception
	 */
	@SafeVarargs
	public static void transformation(String xslPath, PrintWriter writer,
			Map<String, Object>... paramMap) throws TransformerException {

		Source inputSource = new StreamSource(Path.XML_SHOP);
		cache.putIfAbsent(xslPath,
				transformerFactory.newTemplates(new StreamSource(xslPath)));
		Transformer transformer = cache.get(xslPath).newTransformer();
		if (paramMap.length != 0) {
			getParamFromMap(transformer, paramMap);
		}
		transformer.transform(inputSource, new StreamResult(writer));

		LOG.info("Transformation successful.");
	}

	/**
	 * Gets the param from map.
	 * 
	 * @param transformer
	 *            the transformer
	 * @param paramMap
	 *            the param map
	 * @return the param from map
	 */
	private static void getParamFromMap(Transformer transformer,
			Map<String, Object>[] paramMap) {
		for (String key : paramMap[0].keySet()) {
			transformer.setParameter(key, paramMap[0].get(key));
		}
	}

}
