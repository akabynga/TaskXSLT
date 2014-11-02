<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:java="http://xml.apache.org/xalan/java"
	xmlns:validatorHandler="xalan://com.epam.shop.util.ValidatorHandler"
	xmlns:product="xalan://com.epam.shop.dto.ProductDTO" xmlns:redirect="http://xml.apache.org/xalan/redirect"
	exclude-result-prefixes="product validatorHandler java"
	extension-element-prefixes="redirect">

	<xsl:import href="addTemplate.xsl" />

	<xsl:output method="html" />
	<xsl:param name="category" />
	<xsl:param name="subcategory" />
	<xsl:param name="validator" />
	<xsl:param name="product" />
	<xsl:param name="xmlFile" />

	<xsl:template match="/*">

		<xsl:choose>
			<xsl:when test="validatorHandler:validate($validator,$product)">
				<redirect:write file="{$xmlFile}">
					<xsl:copy>
						<xsl:call-template name="save" />
					</xsl:copy>
				</redirect:write>
				<xsl:call-template name="redirectToProducts" />
			</xsl:when>
			<xsl:otherwise>
				<xsl:call-template name="addingFormPage">

					<xsl:with-param name="category" select="$category" />
					<xsl:with-param name="subcategory" select="$subcategory" />

					<xsl:with-param name="model" select="product:getModel($product)" />
					<xsl:with-param name="price" select="product:getPrice($product)" />
					<xsl:with-param name="producer" select="product:getProducer($product)" />
					<xsl:with-param name="color" select="product:getColor($product)" />

					<xsl:with-param name="dateOfIssue"
						select="product:getDateOfIssue($product)" />
					<xsl:with-param name="modelError"
						select="validatorHandler:getModelError($validator)" />
					<xsl:with-param name="priceError"
						select="validatorHandler:getPriceError($validator)" />
					<xsl:with-param name="producerError"
						select="validatorHandler:getProducerError($validator)" />
					<xsl:with-param name="colorError"
						select="validatorHandler:getColorError($validator)" />
					<xsl:with-param name="dateOfIssueError"
						select="validatorHandler:getDateOfIssueError($validator)" />

				</xsl:call-template>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>

	<xsl:template match="product">
		<product>
			<producer>
				<xsl:value-of select="producer" />
			</producer>
			<model>
				<xsl:value-of select="model" />
			</model>
			<dateOfIssue>
				<xsl:value-of select="dateOfIssue" />
			</dateOfIssue>
			<color>
				<xsl:value-of select="color" />
			</color>
			<xsl:if test="notInStock">
				<notInStock>true</notInStock>
			</xsl:if>
			<xsl:if test="price">
				<price>
					<xsl:value-of select="price" />
				</price>
			</xsl:if>
		</product>
	</xsl:template>

	<xsl:template name="save">
		<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="shop/category">
		<category>
			<xsl:attribute name="name">
                <xsl:value-of select="@name" />
            </xsl:attribute>
			<xsl:apply-templates />
		</category>
	</xsl:template>

	<xsl:template match="subcategory">
		<subcategory>
			<xsl:attribute name="name">
                <xsl:value-of select="@name" />
            </xsl:attribute>
			<xsl:apply-templates />
		</subcategory>
	</xsl:template>

	<xsl:template name="addProduct"
		match="shop/category[@name=$category]/subcategory[@name=$subcategory]">
		<xsl:element name="subcategory">
			<xsl:attribute name="name">
				<xsl:value-of select="$subcategory" />
			</xsl:attribute>
			<xsl:apply-templates />
			<xsl:element name="product">
				<xsl:element name="producer">
					<xsl:value-of select="product:getProducer($product)" />
				</xsl:element>
				<xsl:element name="model">
					<xsl:value-of select="product:getModel($product)" />
				</xsl:element>
				<xsl:element name="dateOfIssue">
					<xsl:value-of select="product:getDateOfIssue($product)" />
				</xsl:element>
				<xsl:element name="color">
					<xsl:value-of select="product:getColor($product)" />
				</xsl:element>
				<xsl:choose>
					<xsl:when test="not(product:getNotInStock($product))">
						<xsl:element name="price">
							<xsl:value-of select="product:getPrice($product)" />
						</xsl:element>
					</xsl:when>
					<xsl:otherwise>
						<notInStock>true</notInStock>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:element>
		</xsl:element>
	</xsl:template>


	<xsl:template name="redirectToProducts">
		<html>
			<head>
				<meta http-equiv="refresh" content="0; url=/shop/shop?command=showProducts"></meta>
			</head>
			<body></body>
		</html>
	</xsl:template>

</xsl:stylesheet>