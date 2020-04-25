package selenium.utilities;
import java.util.List;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants; 
import javax.xml.xpath.XPathExpressionException;

import org.odftoolkit.odfdom.doc.OdfSpreadsheetDocument;
import org.odftoolkit.odfdom.doc.table.OdfTable;
import org.odftoolkit.odfdom.doc.table.OdfTableCell;
import org.odftoolkit.odfdom.doc.table.OdfTableRow;
import org.w3c.dom.NodeList;


import org.apache.xml.dtm.ref.DTMNodeList;

public class DataTable 
{
	private OdfSpreadsheetDocument spreadSheet=null;
	private XPath xpath=null;
	private String[] parameterList=null;
	private String[] sheetList=null;
	private int rowCount=0,colCount=0;
	ConfigurationReader conf;
	List <OdfTable > tableList;
	public DataTable() throws Exception
	{
		conf=new ConfigurationReader("ConfigurationFiles/configuration.properties");
		
		spreadSheet=OdfSpreadsheetDocument.loadDocument(conf.getPropertyValue("DataTable"));
		//System.out.println("Debug:DataTable In XML:  "+spreadSheet.getContentDom().toString());
		xpath=this.spreadSheet.getContentDom().getXPath();		
		//System.out.println(xpath.toString());
		List <OdfTable > tableList=spreadSheet.getTableList();
		sheetList=new String[tableList.size()];
		int tableCounter=-1;
		rowCount=0;
		colCount=0;
		for(OdfTable table:tableList)
		{
			
			sheetList[++tableCounter]=table.getTableName();
		}
		
	}
	
	public String [] getSheetNames()
	{
		return this.sheetList;
	}
	public String[] getParameters(String sheetName) throws XPathExpressionException, Exception
	{
		//xpath to reach Nodes of cell in first row
		String xpathStr="//table:table[@table:name='"+sheetName+"']/table:table-row[1]/table:table-cell[@office:value-type='string']";
		DTMNodeList nodeList = (DTMNodeList) xpath.evaluate(xpathStr, spreadSheet.getContentDom(), XPathConstants.NODESET);
		parameterList=new String[nodeList.getLength()];
		for (int nodeCount=0;nodeCount<nodeList.getLength();nodeCount++)
		{
			
			parameterList[nodeCount]=nodeList.item(nodeCount).getTextContent();
		}
		//colCount=nodeList.getLength();
		return this.parameterList;
	}
	public int getColumnCount(String sheetName) throws XPathExpressionException, Exception
	{
		//rest colCount to zero
		colCount=0;
		//xpath to reach Nodes of cell in first row
		String xpathStr="//table:table[@table:name='"+sheetName+"']/table:table-row[1]/table:table-cell";
		DTMNodeList nodeList = (DTMNodeList) xpath.evaluate(xpathStr, spreadSheet.getContentDom(), XPathConstants.NODESET);
		/*System.out.println("Debug:ColumnCount="+nodeList.getLength());
		for(int i=0 ; i<nodeList.getLength();i++)
		{
			System.out.println("Debug:Parameter="+nodeList.item(i).getTextContent());
		}*/
		colCount=nodeList.getLength();
		return colCount;
	}
	public String getParameterValue(String sheetName,String parameterName,int rowIndex) throws Exception
	{
			
		int colIndex=getColumnIndex(sheetName,parameterName);
		System.out.println(spreadSheet.getTableByName(sheetName).getCellByPosition(colIndex, rowIndex).getFormatString());
		return spreadSheet.getTableByName(sheetName).getCellByPosition(colIndex, rowIndex).getDisplayText();
		
	}

	public int getColumnIndex(String sheetName, String parameterName) throws Exception 
	{
		
		int colIndex=-1;
		//xpath to reach Nodes of cell in first row
		String xpathStr="//table:table[@table:name='"+sheetName+"']/table:table-row[1]/table:table-cell";
		DTMNodeList nodeList = (DTMNodeList) xpath.evaluate(xpathStr, spreadSheet.getContentDom(), XPathConstants.NODESET); 

		
		for (int i = 0; i < nodeList.getLength(); i++) 
		{ 
			if (nodeList.item(i).getTextContent().equalsIgnoreCase(parameterName))			{
				colIndex=i;
				break;
			}
			
		}
		return colIndex;
	}
	
	public int getRowCount(String sheetName) throws XPathExpressionException, Exception
	{
		//reset rowCount to zero
		rowCount=0;
		//xpath to reach Nodes of cell in first row
		int parameterCount=getColumnCount(sheetName);
		//System.out.println("Debug:ParameterCount="+parameterCount);
		for (int i=1;i<=parameterCount;i++)
		{
			String xpathStr="//table:table[@table:name='"+sheetName+"']/table:table-row/table:table-cell["+i+"][@office:value-type='string']";
			DTMNodeList nodeList = (DTMNodeList) xpath.evaluate(xpathStr, spreadSheet.getContentDom(), XPathConstants.NODESET);
			//System.out.println("Debug:RowsFoundWithData="+nodeList.getLength());
			System.out.println(nodeList.getLength());
			for(int j=0 ; j<nodeList.getLength();j++)
			{
				System.out.println("Debug:RowValue="+nodeList.item(j).getTextContent());
			}
			if(nodeList.getLength()-1>rowCount)
			{
				rowCount=nodeList.getLength()-1;
			}
		}
		//System.out.println("Debug: rowCount="+rowCount);
		return rowCount;
		
	}
	public int getRowCount(String sheetName, String parameterName) throws XPathExpressionException, Exception
	{
		//reset rowCount to zero
		rowCount=0;
		//xpath to reach Nodes of cell in first row
		int parameterCount=getColumnCount(sheetName);
		//System.out.println("Debug:ParameterCount="+parameterCount);
		for (int i=1;i<=parameterCount;i++)
		{
			String xpathStr="//table:table[@table:name='"+sheetName+"']/table:table-row/table:table-cell["+i+"][@office:value-type='string']";
			DTMNodeList nodeList = (DTMNodeList) xpath.evaluate(xpathStr, spreadSheet.getContentDom(), XPathConstants.NODESET);
			System.out.println(nodeList.getLength());
			//System.out.println("Debug:RowsFoundWithData="+nodeList.getLength());
			/*for(int j=0 ; j<nodeList.getLength();j++)
			{
				System.out.println("Debug:RowValue="+nodeList.item(j).getTextContent());
			}*/
			if(nodeList.item(0).getTextContent().equalsIgnoreCase(parameterName))
			{
				rowCount=nodeList.getLength()-1;
				break;
			}
		}
		//System.out.println("Debug: rowCount="+rowCount);
		return rowCount;
		
	}
	
	public void writeParameter(String sheetName,String ColumnName,String data)throws XPathExpressionException, Exception //Function to write values in Data Table
	{
		int colIndex=getColumnIndex(sheetName,ColumnName);
		int rowIndex=getRowCount(sheetName);
		
		
		rowIndex++;
		OdfTableCell cell=spreadSheet.getTableByName(sheetName).getCellByPosition(colIndex, rowIndex);
		
		cell.setStringValue(data);
		
		
		spreadSheet.save(conf.getPropertyValue("DataTable"));
				
		
		
		
	}
}
