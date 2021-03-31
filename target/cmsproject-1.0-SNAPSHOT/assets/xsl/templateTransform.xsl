<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <script type='text/javascript' src="src/main/webapp/assets/js/sendTemplateData.js">
                </script>
            </head>
            <body>
                <form>
                    <xsl:for-each select="root/Element">
                        <xsl:if test="type='text'">
                            <label>
                                <xsl:value-of select="name"/> :
                            </label>
                            <br></br>
                            <input type="text" id ="{id}" size="20" />
                            <br></br>
                        </xsl:if>
                        <xsl:if test="type='date'">
                            <label>
                                <xsl:value-of select="name"/> :
                            </label>
                            <br></br>
                            <input type="date" id ="{id}" size="20" />
                            <br></br>
                        </xsl:if>
                    </xsl:for-each>
                </form>
                <input type="Submit" name = "Submit"/>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>