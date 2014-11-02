<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:import href="addTemplate.xsl" />
	<xsl:output method="html" />



	<xsl:param name="category" />
	<xsl:param name="subcategory" />
	<xsl:param name="producer" />
	<xsl:param name="model" />
	<xsl:param name="color" />
	<xsl:param name="dateOfIssue" />
	<xsl:param name="price" />
	<xsl:param name="notInStock" />

	<xsl:template match="/">
		<xsl:call-template name="addingFormPage" />
	</xsl:template>

</xsl:stylesheet>