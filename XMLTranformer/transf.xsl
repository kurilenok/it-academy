<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">
	<xsl:output method="html" />
	<xsl:template match="/">
		<HTML>
			<body>
				<table border="1">
					<xsl:apply-templates />
				</table>
			</body>
		</HTML>
	</xsl:template>

	<xsl:template match="/studentList/student">
		<tr>
			<xsl:apply-templates />
		</tr>
	</xsl:template>

	<xsl:template match="/studentList/student/firstName">
		<td><xsl:value-of select="text()" /></td>
	</xsl:template>
	<xsl:template match="/studentList/student/lastName">
		<td><xsl:value-of select="text()" /></td>
	</xsl:template>
	<xsl:template match="/studentList/student/age">
		<td><xsl:value-of select="text()" /></td>
	</xsl:template>
	<xsl:template match="/studentList/student/faculty">
		<td><xsl:value-of select="text()" /></td>
	</xsl:template>

</xsl:stylesheet>