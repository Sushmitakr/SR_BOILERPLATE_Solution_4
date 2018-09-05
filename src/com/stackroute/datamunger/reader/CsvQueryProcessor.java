package com.stackroute.datamunger.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.stackroute.datamunger.query.DataTypeDefinitions;
import com.stackroute.datamunger.query.Header;

public class CsvQueryProcessor extends QueryProcessingEngine {

	

	/*
	 * parameterized constructor to initialize filename. As you are trying to
	 * perform file reading, hence you need to be ready to handle the IO Exceptions.
	 */
	String fileName;
	public CsvQueryProcessor(String fileName) throws FileNotFoundException {
	
		this.fileName = fileName;
		File file = new File(fileName);
		if(!file.exists()) {
			throw new FileNotFoundException();
		}
	}

	/*
	 * implementation of getHeader() method. We will have to extract the headers
	 * from the first line of the file.
	 */
	@Override
	public Header getHeader() throws IOException {
		BufferedReader br = new BufferedReader( new FileReader(fileName));
	    String strLine = "";
		// read the first line
	    strLine = br.readLine();
	  //  System.out.println(strLine);
		// populate the header object with the String array containing the header names
	    String[] strArray = strLine.split(",");
	    Header head = new Header();
	    head.setHeaders(strArray);
		return head;
	}
	

	/**
	 * This method will be used in the upcoming assignments
	 */
	@Override
	public void getDataRow() {

	}

	/*
	 * implementation of getColumnType() method. To find out the data types, we will
	 * read the first line from the file and extract the field values from it. In
	 * the previous assignment, we have tried to convert a specific field value to
	 * Integer or Double. However, in this assignment, we are going to use Regular
	 * Expression to find the appropriate data type of a field. Integers: should
	 * contain only digits without decimal point Double: should contain digits as
	 * well as decimal point Date: Dates can be written in many formats in the CSV
	 * file. However, in this assignment,we will test for the following date
	 * formats('dd/mm/yyyy',
	 * 'mm/dd/yyyy','dd-mon-yy','dd-mon-yyyy','dd-month-yy','dd-month-yyyy','yyyy-mm-dd')
	 */
	@Override
	public DataTypeDefinitions getColumnType() throws IOException {
		// TODO Auto-generated method stub
		 
		// checking for floating point numbers
				
		// checking for date format dd/mm/yyyy
		
		// checking for date format mm/dd/yyyy
		
		// checking for date format dd-mon-yy
		
		// checking for date format dd-mon-yyyy
		
		// checking for date format dd-month-yy
		
		// checking for date format dd-month-yyyy
		
		// checking for date format yyyy-mm-dd
		BufferedReader br = new BufferedReader(new FileReader(fileName));
        String header=br.readLine();
        int L=header.split(",").length;
        String[] dataType=new String[L];
        /*for(String a:dataType)
        {
            a="java.lang.String";
        }*/
        String row=br.readLine();
        System.out.println(row.length());
           
        String[] column = row.split(",");
            System.out.println(column.length);
      int l=0;
       for(int i=0;i<column.length;i++)
       {
          if(column[i].matches("[0-9]*"))
          {
             dataType[l]="java.lang.Integer";
          }
          else if (column[i].matches("^[a-zA-z\\\\s].*$"))
          {
              dataType[l]="java.lang.String";
          }
          else if (column[i].matches("^(19|20)\\d\\d[- /.](0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])$"))
          {
              dataType[l]="java.util.Date";
          }
          else {
              dataType[l]="java.lang.Object";
          }
          System.out.println(dataType[l]);
          l++;
       }
       dataType[l]="java.lang.Object";
       System.out.println(dataType.length);
        //return columns;
         // read the first line
        DataTypeDefinitions datatype= new DataTypeDefinitions();
         datatype.setDataTypes(dataType);
         System.out.println(dataType);
         br.close();
             return datatype;
     }
	}
	
	

	
	


