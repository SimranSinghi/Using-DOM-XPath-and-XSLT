<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>

	<xsl:template match="/">
		
		<html>
			<body>
				<center> <xsl:value-of select="collection/description"/> </center>			
					<xsl:for-each select="collection/recipe">					
						<h3><xsl:value-of select="./title"/></h3>
							<xsl:value-of select="./date"/>


							<h3>Ingredients</h3>
                    <ul>
                        <xsl:for-each select="ingredient">
                            <li>
                                <xsl:value-of select="./@name" />, <xsl:value-of select="./@amount" />, <xsl:value-of select="./@unit" />
                                <ul>
                                    <xsl:for-each select="ingredient">
                                        <li>
                                            <xsl:value-of select="./@name" />, <xsl:value-of select="./@amount" /> <xsl:value-of select="./@unit" />
                                            <ul>
                                                <xsl:for-each select="ingredient">
                                                    <li>
                                                        <xsl:value-of select="./@name" /><xsl:value-of select="./@amount" /> <xsl:value-of select="./@unit" />
                                                        <ul>
                                                            <xsl:for-each select="ingredient">
                                                                <li>
                                                                    <xsl:value-of select="./@name" /><xsl:value-of select="./@amount" /><xsl:value-of select="./@unit" />
                                                                </li>
                                                            </xsl:for-each>
                                                        </ul>
                                                        <ol>
                                                            <xsl:for-each select="preparation/step">
                                                                <li>
                                                                    <xsl:value-of select="." />
                                                                </li>
                                                            </xsl:for-each>
                                                        </ol>
                                                    </li>
                                                </xsl:for-each>
                                            </ul>

                                            <ol>
                                                <xsl:for-each select="preparation/step">

                                                    <li>
                                                        <xsl:value-of select="." />
                                                    </li>


                                                </xsl:for-each>
                                            </ol>
                                        </li>
                                    </xsl:for-each>
                                </ul>

                                <ol>
                                   <xsl:for-each select="preparation/step">
                                        <li>
                                            <xsl:value-of select="." />
                                        </li>
                                    </xsl:for-each>
                                </ol>
                            </li>
                        </xsl:for-each>
                    </ul>
						
					    
					    
					    <h3>Preparation: </h3>
					    <ul>
					    <xsl:for-each select="preparation/step">
						    <li> <xsl:value-of select="."/> </li>
					    </xsl:for-each>
					    </ul>
					
						<b>Comment:</b> <xsl:value-of select="comment"/> 
						<xsl:for-each select="nutrition">
							<br/>
						<b>Calories: </b> <xsl:value-of select="@calories"/><br/>					
						<b>Fat: </b><xsl:value-of select="@fat"/>	<br/>
						<b>Carbohydrates: </b><xsl:value-of select="@carbohydrates"/> <br/>
						<b>Protein: </b><xsl:value-of select="@protein"/> <br/>
						</xsl:for-each>	 
						<p>Tip: <xsl:value-of select="related"/></p>						
					</xsl:for-each>

			</body>		
		</html>

	</xsl:template>
</xsl:stylesheet>