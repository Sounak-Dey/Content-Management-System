<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <table>
            <xsl:for-each select="root/element">
                <tr>
                    <xsl:if test="type='TEXT'">
                        <td>
                            <xsl:value-of select="label"/>
                        </td>
                        <td>
                            <xsl:value-of select="value"/>
                        </td>
                    </xsl:if>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>