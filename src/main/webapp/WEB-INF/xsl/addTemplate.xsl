<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

	<xsl:output method="html" />

	<xsl:template name="addingFormPage">

		<xsl:param name="category" />
		<xsl:param name="subcategory" />

		<xsl:param name="modelError" />
		<xsl:param name="colorError" />
		<xsl:param name="dateOfIssueError" />
		<xsl:param name="priceError" />
		<xsl:param name="producerError" />

		<xsl:param name="model" />
		<xsl:param name="color" />
		<xsl:param name="dateOfIssue" />
		<xsl:param name="price" />
		<xsl:param name="producer" />

		<html>
			<head>
				<link href="css/style.css" rel="stylesheet" />
				<title>Creating product</title>
			</head>
			<body>
				<div class="container">
					<h2>Creating product:</h2>
					<hr />
					<form action="shop" method="post">
						<div class="inner-block">
							<input type="hidden" name="command" value="saveProduct" />
							<div class="input-block">
								<label class="name-label" for="producer">Producer:</label>
								<input id="producer" type="text" name="producer" size="25"
									value="{$producer}" />
								<label class="error-label">
									<xsl:value-of select="$producerError" />
								</label>
							</div>
							<div class="input-block">
								<label class="name-label" for="model">Model:</label>
								<input id="model" type="text" name="model" size="25"
									value="{$model}" />
								<label class="error-label">
									<xsl:value-of select="$modelError" />
								</label>
							</div>
							<div class="input-block">
								<label class="name-label" for="date">Date of issue:</label>
								<input id="date" type="text" name="dateOfIssue" size="25"
									value="{$dateOfIssue}" />
								<label class="error-label">
									<xsl:value-of select="$dateOfIssueError" />
								</label>
							</div>
							<div class="input-block">
								<label class="name-label" for="color">Color:</label>
								<input id="color" type="text" name="color" size="25"
									value="{$color}" />
								<label class="error-label">
									<xsl:value-of select="$colorError" />
								</label>
							</div>
							<div class="input-block">
								<label class="name-label" for="price">Price:</label>
								<input id="price" type="text" name="price" size="25"
									value="{$price}" />
								<label class="error-label">
									<xsl:value-of select="$priceError" />
								</label>
							</div>
							<div style="input-block">
								<label class="name-label" for="notInStock">Not in stock:</label>
								<input id="notInStock" type="checkbox" name="notInStock" />
							</div>
							<div>
								<button class="btn" type="reset">Clear form</button>
								<button class="btn" type="submit" name="save">Save</button>
							</div>
						</div>
					</form>
					<form action="shop" method="post">
						<div class="cancel-btn">
							<input type="hidden" name="command" value="showProducts" />
							<button class="btn" type="submit" name="cancel">Cancel</button>
						</div>
					</form>
				</div>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>