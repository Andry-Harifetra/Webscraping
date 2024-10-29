// ============================================================================
//
// Copyright (c) 2006-2015, Talend SA
//
// Ce code source a été automatiquement généré par_Talend Open Studio for Data Integration
// / Soumis à la Licence Apache, Version 2.0 (la "Licence") ;
// votre utilisation de ce fichier doit respecter les termes de la Licence.
// Vous pouvez obtenir une copie de la Licence sur
// http://www.apache.org/licenses/LICENSE-2.0
// 
// Sauf lorsqu'explicitement prévu par la loi en vigueur ou accepté par écrit, le logiciel
// distribué sous la Licence est distribué "TEL QUEL",
// SANS GARANTIE OU CONDITION D'AUCUNE SORTE, expresse ou implicite.
// Consultez la Licence pour connaître la terminologie spécifique régissant les autorisations et
// les limites prévues par la Licence.


package eurodata.vente_carburant_0_1;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.FloatComparator;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;
 




	//the import part of tJava_1
	//import java.util.List;

	//the import part of tJava_2
	//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: vente_carburant Purpose: <br>
 * Description:  <br>
 * @author user@talend.com
 * @version 8.0.1.20211109_1610
 * @status 
 */
public class vente_carburant implements TalendJob {

protected static void logIgnoredError(String message, Throwable cause) {
       System.err.println(message);
       if (cause != null) {
               cause.printStackTrace();
       }

}


	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}
	
	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	
	private final static String utf8Charset = "UTF-8";
	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
		}
	
		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}
	
	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();
	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}
	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.
	public ContextProperties getContext() {
		return this.context;
	}
	private final String jobVersion = "0.1";
	private final String jobName = "vente_carburant";
	private final String projectName = "EURODATA";
	public Integer errorCode = null;
	private String currentComponent = "";
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private RunStat runStat = new RunStat();

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
                    dataSources.put(entry.getKey(), entry.getValue());
                    talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}


private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

public String getExceptionStackTrace() {
	if ("failure".equals(this.getStatus())) {
		errorMessagePS.flush();
		return baos.toString();
	}
	return null;
}

private Exception exception;

public Exception getException() {
	if ("failure".equals(this.getStatus())) {
		return this.exception;
	}
	return null;
}

private class TalendException extends Exception {

	private static final long serialVersionUID = 1L;

	private java.util.Map<String, Object> globalMap = null;
	private Exception e = null;
	private String currentComponent = null;
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
        Throwable cause = e;
        String message = null;
        int i = 10;
        while (null != cause && 0 < i--) {
            message = cause.getMessage();
            if (null == message) {
                cause = cause.getCause();
            } else {
                break;          
            }
        }
        if (null == message) {
            message = e.getClass().getName();
        }   
        return message;
    }

	@Override
	public void printStackTrace() {
		if (!(e instanceof TalendException || e instanceof TDieException)) {
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
				vente_carburant.this.exception = e;
			}
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(vente_carburant.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
			}
		} catch (Exception e) {
			this.e.printStackTrace();
		}
		}
	}
}

			public void tPrejob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPrejob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBConnection_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
						try {
							
								if(this.execStat){
									runStat.updateStatOnConnection("OnComponentError1", 0, "error");
								}
							
							
								errorCode = null;
								tDie_1Process(globalMap);
								if (!"failure".equals(status)) {
									status = "end";
								}
								

						} catch (Exception e) {
							e.printStackTrace();
						}
						
					tDBConnection_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDie_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDie_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPostjob_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tPostjob_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBCommit_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tDBCommit_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tJava_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFileInputExcel_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBOutput_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tAdvancedHash_row2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFileInputExcel_2_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tPrejob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBConnection_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDie_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tPostjob_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tDBCommit_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tJava_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFileInputExcel_2_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
	





public void tPrejob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPrejob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPrejob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPrejob_1", false);
		start_Hash.put("tPrejob_1", System.currentTimeMillis());
		
	
	currentComponent="tPrejob_1";

	
		int tos_count_tPrejob_1 = 0;
		

 



/**
 * [tPrejob_1 begin ] stop
 */
	
	/**
	 * [tPrejob_1 main ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 


	tos_count_tPrejob_1++;

/**
 * [tPrejob_1 main ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPrejob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 process_data_end ] stop
 */
	
	/**
	 * [tPrejob_1 end ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 

ok_Hash.put("tPrejob_1", true);
end_Hash.put("tPrejob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
				}
				tDBConnection_1Process(globalMap);



/**
 * [tPrejob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPrejob_1 finally ] start
	 */

	

	
	
	currentComponent="tPrejob_1";

	

 



/**
 * [tPrejob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPrejob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBConnection_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBConnection_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBConnection_1", false);
		start_Hash.put("tDBConnection_1", System.currentTimeMillis());
		
	
	currentComponent="tDBConnection_1";

	
		int tos_count_tDBConnection_1 = 0;
		
	

	
        String properties_tDBConnection_1 = "serverTimezone=UTC";
        if (properties_tDBConnection_1 == null || properties_tDBConnection_1.trim().length() == 0) {
            properties_tDBConnection_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBConnection_1.contains("rewriteBatchedStatements=")) {
                properties_tDBConnection_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBConnection_1.contains("allowLoadLocalInfile=")) {
                properties_tDBConnection_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBConnection_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "eurodata" + "?" + properties_tDBConnection_1;
	String dbUser_tDBConnection_1 = "root";
	
	
		 
	final String decryptedPassword_tDBConnection_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:QtMq1opkjHrsgB183jxGkT7W4/xmLhKoG7uFQoIQ7e4dPUjtr/s=");
		String dbPwd_tDBConnection_1 = decryptedPassword_tDBConnection_1;
	
	
	java.sql.Connection conn_tDBConnection_1 = null;
	
		
			String driverClass_tDBConnection_1 = "com.mysql.cj.jdbc.Driver";
			java.lang.Class jdbcclazz_tDBConnection_1 = java.lang.Class.forName(driverClass_tDBConnection_1);
			globalMap.put("driverClass_tDBConnection_1", driverClass_tDBConnection_1);
		
			conn_tDBConnection_1 = java.sql.DriverManager.getConnection(url_tDBConnection_1,dbUser_tDBConnection_1,dbPwd_tDBConnection_1);

		globalMap.put("conn_tDBConnection_1", conn_tDBConnection_1);
	if (null != conn_tDBConnection_1) {
		
			conn_tDBConnection_1.setAutoCommit(false);
	}

	globalMap.put("db_tDBConnection_1","eurodata");
 



/**
 * [tDBConnection_1 begin ] stop
 */
	
	/**
	 * [tDBConnection_1 main ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 


	tos_count_tDBConnection_1++;

/**
 * [tDBConnection_1 main ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBConnection_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 process_data_end ] stop
 */
	
	/**
	 * [tDBConnection_1 end ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 

ok_Hash.put("tDBConnection_1", true);
end_Hash.put("tDBConnection_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk2", 0, "ok");
				}
				tJava_1Process(globalMap);



/**
 * [tDBConnection_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBConnection_1 finally ] start
	 */

	

	
	
	currentComponent="tDBConnection_1";

	

 



/**
 * [tDBConnection_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBConnection_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_1", false);
		start_Hash.put("tJava_1", System.currentTimeMillis());
		
	
	currentComponent="tJava_1";

	
		int tos_count_tJava_1 = 0;
		


System.out.println("[ok] connection to vente carburant success !");
 



/**
 * [tJava_1 begin ] stop
 */
	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 


	tos_count_tJava_1++;

/**
 * [tJava_1 main ] stop
 */
	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_begin ] stop
 */
	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 process_data_end ] stop
 */
	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());




/**
 * [tJava_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	currentComponent="tJava_1";

	

 



/**
 * [tJava_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_1_SUBPROCESS_STATE", 1);
	}
	

public void tDie_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDie_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tDie_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDie_1", false);
		start_Hash.put("tDie_1", System.currentTimeMillis());
		
	
	currentComponent="tDie_1";

	
		int tos_count_tDie_1 = 0;
		

 



/**
 * [tDie_1 begin ] stop
 */
	
	/**
	 * [tDie_1 main ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

	try {
	globalMap.put("tDie_1_DIE_PRIORITY", 5);
	System.err.println("error on vengte_carburant_sous_job");
	
	globalMap.put("tDie_1_DIE_MESSAGE", "error on vengte_carburant_sous_job");
	globalMap.put("tDie_1_DIE_MESSAGES", "error on vengte_carburant_sous_job");
	
	} catch (Exception | Error e_tDie_1) {
	    globalMap.put("tDie_1_ERROR_MESSAGE",e_tDie_1.getMessage());
		logIgnoredError(String.format("tDie_1 - tDie failed to log message due to internal error: %s", e_tDie_1), e_tDie_1);
	}
	
	currentComponent = "tDie_1";
	status = "failure";
        errorCode = new Integer(4);
        globalMap.put("tDie_1_DIE_CODE", errorCode);        
    
	if(true){	
	    throw new TDieException();
	}

 


	tos_count_tDie_1++;

/**
 * [tDie_1 main ] stop
 */
	
	/**
	 * [tDie_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 process_data_begin ] stop
 */
	
	/**
	 * [tDie_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 process_data_end ] stop
 */
	
	/**
	 * [tDie_1 end ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 

ok_Hash.put("tDie_1", true);
end_Hash.put("tDie_1", System.currentTimeMillis());




/**
 * [tDie_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDie_1 finally ] start
	 */

	

	
	
	currentComponent="tDie_1";

	

 



/**
 * [tDie_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDie_1_SUBPROCESS_STATE", 1);
	}
	

public void tPostjob_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tPostjob_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tPostjob_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tPostjob_1", false);
		start_Hash.put("tPostjob_1", System.currentTimeMillis());
		
	
	currentComponent="tPostjob_1";

	
		int tos_count_tPostjob_1 = 0;
		

 



/**
 * [tPostjob_1 begin ] stop
 */
	
	/**
	 * [tPostjob_1 main ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 


	tos_count_tPostjob_1++;

/**
 * [tPostjob_1 main ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_begin ] stop
 */
	
	/**
	 * [tPostjob_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 process_data_end ] stop
 */
	
	/**
	 * [tPostjob_1 end ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 

ok_Hash.put("tPostjob_1", true);
end_Hash.put("tPostjob_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk3", 0, "ok");
				}
				tDBCommit_1Process(globalMap);



/**
 * [tPostjob_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tPostjob_1 finally ] start
	 */

	

	
	
	currentComponent="tPostjob_1";

	

 



/**
 * [tPostjob_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tPostjob_1_SUBPROCESS_STATE", 1);
	}
	

public void tDBCommit_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		


	
	/**
	 * [tDBCommit_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBCommit_1", false);
		start_Hash.put("tDBCommit_1", System.currentTimeMillis());
		
	
	currentComponent="tDBCommit_1";

	
		int tos_count_tDBCommit_1 = 0;
		

 



/**
 * [tDBCommit_1 begin ] stop
 */
	
	/**
	 * [tDBCommit_1 main ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

	java.sql.Connection conn_tDBCommit_1 = (java.sql.Connection)globalMap.get("conn_tDBConnection_1");

if(conn_tDBCommit_1 != null && !conn_tDBCommit_1.isClosed()) {
	
		try{
	
			
			conn_tDBCommit_1.commit();
			
	
		}finally{
			
			conn_tDBCommit_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_tDBConnection_1"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    }
	
}

 


	tos_count_tDBCommit_1++;

/**
 * [tDBCommit_1 main ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBCommit_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 process_data_end ] stop
 */
	
	/**
	 * [tDBCommit_1 end ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 

ok_Hash.put("tDBCommit_1", true);
end_Hash.put("tDBCommit_1", System.currentTimeMillis());

				if(execStat){   
   	 				runStat.updateStatOnConnection("OnComponentOk4", 0, "ok");
				}
				tJava_2Process(globalMap);



/**
 * [tDBCommit_1 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBCommit_1 finally ] start
	 */

	

	
	
	currentComponent="tDBCommit_1";

	

 



/**
 * [tDBCommit_1 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBCommit_1_SUBPROCESS_STATE", 1);
	}
	

public void tJava_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tJava_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tJava_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tJava_2", false);
		start_Hash.put("tJava_2", System.currentTimeMillis());
		
	
	currentComponent="tJava_2";

	
		int tos_count_tJava_2 = 0;
		


System.out.println("[ok] vente_carburant LOADED");
 



/**
 * [tJava_2 begin ] stop
 */
	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 


	tos_count_tJava_2++;

/**
 * [tJava_2 main ] stop
 */
	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_begin ] stop
 */
	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 process_data_end ] stop
 */
	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());




/**
 * [tJava_2 end ] stop
 */
				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tJava_2 finally ] start
	 */

	

	
	
	currentComponent="tJava_2";

	

 



/**
 * [tJava_2 finally ] stop
 */
				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tJava_2_SUBPROCESS_STATE", 1);
	}
	


public static class insert_vente_carburantStruct implements routines.system.IPersistableRow<insert_vente_carburantStruct> {
    final static byte[] commonByteArrayLock_EURODATA_vente_carburant = new byte[0];
    static byte[] commonByteArray_EURODATA_vente_carburant = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String Site;

				public String getSite () {
					return this.Site;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Carburant;

				public String getCarburant () {
					return this.Carburant;
				}
				
			    public int Pompe;

				public int getPompe () {
					return this.Pompe;
				}
				
			    public int Pistolet;

				public int getPistolet () {
					return this.Pistolet;
				}
				
			    public Float Index_de_debut;

				public Float getIndex_de_debut () {
					return this.Index_de_debut;
				}
				
			    public Float Index_de_fin;

				public Float getIndex_de_fin () {
					return this.Index_de_fin;
				}
				
			    public Float Tests_de_pompe;

				public Float getTests_de_pompe () {
					return this.Tests_de_pompe;
				}
				
			    public Float Quantite;

				public Float getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_unitaire;

				public Float getPrix_unitaire () {
					return this.Prix_unitaire;
				}
				
			    public Float Montant;

				public Float getMontant () {
					return this.Montant;
				}
				
			    public Byte Index_de_debut_modifie;

				public Byte getIndex_de_debut_modifie () {
					return this.Index_de_debut_modifie;
				}
				
			    public java.util.Date last_update;

				public java.util.Date getLast_update () {
					return this.last_update;
				}
				
			    public java.util.Date inserted_date;

				public java.util.Date getInserted_date () {
					return this.inserted_date;
				}
				
			    public String date_str;

				public String getDate_str () {
					return this.date_str;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Site == null) ? 0 : this.Site.hashCode());
					
						result = prime * result + ((this.Date == null) ? 0 : this.Date.hashCode());
					
						result = prime * result + ((this.Carburant == null) ? 0 : this.Carburant.hashCode());
					
							result = prime * result + (int) this.Pompe;
						
							result = prime * result + (int) this.Pistolet;
						
						result = prime * result + ((this.date_str == null) ? 0 : this.date_str.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final insert_vente_carburantStruct other = (insert_vente_carburantStruct) obj;
		
						if (this.Site == null) {
							if (other.Site != null)
								return false;
						
						} else if (!this.Site.equals(other.Site))
						
							return false;
					
						if (this.Date == null) {
							if (other.Date != null)
								return false;
						
						} else if (!this.Date.equals(other.Date))
						
							return false;
					
						if (this.Carburant == null) {
							if (other.Carburant != null)
								return false;
						
						} else if (!this.Carburant.equals(other.Carburant))
						
							return false;
					
						if (this.Pompe != other.Pompe)
							return false;
					
						if (this.Pistolet != other.Pistolet)
							return false;
					
						if (this.date_str == null) {
							if (other.date_str != null)
								return false;
						
						} else if (!this.date_str.equals(other.date_str))
						
							return false;
					

		return true;
    }

	public void copyDataTo(insert_vente_carburantStruct other) {

		other.Site = this.Site;
	            other.Date = this.Date;
	            other.Carburant = this.Carburant;
	            other.Pompe = this.Pompe;
	            other.Pistolet = this.Pistolet;
	            other.Index_de_debut = this.Index_de_debut;
	            other.Index_de_fin = this.Index_de_fin;
	            other.Tests_de_pompe = this.Tests_de_pompe;
	            other.Quantite = this.Quantite;
	            other.Prix_unitaire = this.Prix_unitaire;
	            other.Montant = this.Montant;
	            other.Index_de_debut_modifie = this.Index_de_debut_modifie;
	            other.last_update = this.last_update;
	            other.inserted_date = this.inserted_date;
	            other.date_str = this.date_str;
	            
	}

	public void copyKeysDataTo(insert_vente_carburantStruct other) {

		other.Site = this.Site;
	            	other.Date = this.Date;
	            	other.Carburant = this.Carburant;
	            	other.Pompe = this.Pompe;
	            	other.Pistolet = this.Pistolet;
	            	other.date_str = this.date_str;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
					this.last_update = readDate(dis);
					
					this.inserted_date = readDate(dis);
					
					this.date_str = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
					this.last_update = readDate(dis);
					
					this.inserted_date = readDate(dis);
					
					this.date_str = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
					// java.util.Date
				
						writeDate(this.last_update,dos);
					
					// java.util.Date
				
						writeDate(this.inserted_date,dos);
					
					// String
				
						writeString(this.date_str,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
					// java.util.Date
				
						writeDate(this.last_update,dos);
					
					// java.util.Date
				
						writeDate(this.inserted_date,dos);
					
					// String
				
						writeString(this.date_str,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Site="+Site);
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Carburant="+Carburant);
		sb.append(",Pompe="+String.valueOf(Pompe));
		sb.append(",Pistolet="+String.valueOf(Pistolet));
		sb.append(",Index_de_debut="+String.valueOf(Index_de_debut));
		sb.append(",Index_de_fin="+String.valueOf(Index_de_fin));
		sb.append(",Tests_de_pompe="+String.valueOf(Tests_de_pompe));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_unitaire="+String.valueOf(Prix_unitaire));
		sb.append(",Montant="+String.valueOf(Montant));
		sb.append(",Index_de_debut_modifie="+String.valueOf(Index_de_debut_modifie));
		sb.append(",last_update="+String.valueOf(last_update));
		sb.append(",inserted_date="+String.valueOf(inserted_date));
		sb.append(",date_str="+date_str);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(insert_vente_carburantStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Site, other.Site);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Date, other.Date);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Carburant, other.Carburant);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pompe, other.Pompe);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pistolet, other.Pistolet);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.date_str, other.date_str);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class update_duplicateStruct implements routines.system.IPersistableRow<update_duplicateStruct> {
    final static byte[] commonByteArrayLock_EURODATA_vente_carburant = new byte[0];
    static byte[] commonByteArray_EURODATA_vente_carburant = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String Site;

				public String getSite () {
					return this.Site;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Carburant;

				public String getCarburant () {
					return this.Carburant;
				}
				
			    public int Pompe;

				public int getPompe () {
					return this.Pompe;
				}
				
			    public int Pistolet;

				public int getPistolet () {
					return this.Pistolet;
				}
				
			    public Float Index_de_debut;

				public Float getIndex_de_debut () {
					return this.Index_de_debut;
				}
				
			    public Float Index_de_fin;

				public Float getIndex_de_fin () {
					return this.Index_de_fin;
				}
				
			    public Float Tests_de_pompe;

				public Float getTests_de_pompe () {
					return this.Tests_de_pompe;
				}
				
			    public Float Quantite;

				public Float getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_unitaire;

				public Float getPrix_unitaire () {
					return this.Prix_unitaire;
				}
				
			    public Float Montant;

				public Float getMontant () {
					return this.Montant;
				}
				
			    public Byte Index_de_debut_modifie;

				public Byte getIndex_de_debut_modifie () {
					return this.Index_de_debut_modifie;
				}
				
			    public java.util.Date last_update;

				public java.util.Date getLast_update () {
					return this.last_update;
				}
				
			    public java.util.Date inserted_date;

				public java.util.Date getInserted_date () {
					return this.inserted_date;
				}
				
			    public String date_str;

				public String getDate_str () {
					return this.date_str;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Site == null) ? 0 : this.Site.hashCode());
					
						result = prime * result + ((this.Date == null) ? 0 : this.Date.hashCode());
					
						result = prime * result + ((this.Carburant == null) ? 0 : this.Carburant.hashCode());
					
							result = prime * result + (int) this.Pompe;
						
							result = prime * result + (int) this.Pistolet;
						
						result = prime * result + ((this.date_str == null) ? 0 : this.date_str.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final update_duplicateStruct other = (update_duplicateStruct) obj;
		
						if (this.Site == null) {
							if (other.Site != null)
								return false;
						
						} else if (!this.Site.equals(other.Site))
						
							return false;
					
						if (this.Date == null) {
							if (other.Date != null)
								return false;
						
						} else if (!this.Date.equals(other.Date))
						
							return false;
					
						if (this.Carburant == null) {
							if (other.Carburant != null)
								return false;
						
						} else if (!this.Carburant.equals(other.Carburant))
						
							return false;
					
						if (this.Pompe != other.Pompe)
							return false;
					
						if (this.Pistolet != other.Pistolet)
							return false;
					
						if (this.date_str == null) {
							if (other.date_str != null)
								return false;
						
						} else if (!this.date_str.equals(other.date_str))
						
							return false;
					

		return true;
    }

	public void copyDataTo(update_duplicateStruct other) {

		other.Site = this.Site;
	            other.Date = this.Date;
	            other.Carburant = this.Carburant;
	            other.Pompe = this.Pompe;
	            other.Pistolet = this.Pistolet;
	            other.Index_de_debut = this.Index_de_debut;
	            other.Index_de_fin = this.Index_de_fin;
	            other.Tests_de_pompe = this.Tests_de_pompe;
	            other.Quantite = this.Quantite;
	            other.Prix_unitaire = this.Prix_unitaire;
	            other.Montant = this.Montant;
	            other.Index_de_debut_modifie = this.Index_de_debut_modifie;
	            other.last_update = this.last_update;
	            other.inserted_date = this.inserted_date;
	            other.date_str = this.date_str;
	            
	}

	public void copyKeysDataTo(update_duplicateStruct other) {

		other.Site = this.Site;
	            	other.Date = this.Date;
	            	other.Carburant = this.Carburant;
	            	other.Pompe = this.Pompe;
	            	other.Pistolet = this.Pistolet;
	            	other.date_str = this.date_str;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
					this.last_update = readDate(dis);
					
					this.inserted_date = readDate(dis);
					
					this.date_str = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
					this.last_update = readDate(dis);
					
					this.inserted_date = readDate(dis);
					
					this.date_str = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
					// java.util.Date
				
						writeDate(this.last_update,dos);
					
					// java.util.Date
				
						writeDate(this.inserted_date,dos);
					
					// String
				
						writeString(this.date_str,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
					// java.util.Date
				
						writeDate(this.last_update,dos);
					
					// java.util.Date
				
						writeDate(this.inserted_date,dos);
					
					// String
				
						writeString(this.date_str,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Site="+Site);
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Carburant="+Carburant);
		sb.append(",Pompe="+String.valueOf(Pompe));
		sb.append(",Pistolet="+String.valueOf(Pistolet));
		sb.append(",Index_de_debut="+String.valueOf(Index_de_debut));
		sb.append(",Index_de_fin="+String.valueOf(Index_de_fin));
		sb.append(",Tests_de_pompe="+String.valueOf(Tests_de_pompe));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_unitaire="+String.valueOf(Prix_unitaire));
		sb.append(",Montant="+String.valueOf(Montant));
		sb.append(",Index_de_debut_modifie="+String.valueOf(Index_de_debut_modifie));
		sb.append(",last_update="+String.valueOf(last_update));
		sb.append(",inserted_date="+String.valueOf(inserted_date));
		sb.append(",date_str="+date_str);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(update_duplicateStruct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Site, other.Site);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Date, other.Date);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Carburant, other.Carburant);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pompe, other.Pompe);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pistolet, other.Pistolet);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.date_str, other.date_str);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_EURODATA_vente_carburant = new byte[0];
    static byte[] commonByteArray_EURODATA_vente_carburant = new byte[0];

	
			    public String Site;

				public String getSite () {
					return this.Site;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Carburant;

				public String getCarburant () {
					return this.Carburant;
				}
				
			    public int Pompe;

				public int getPompe () {
					return this.Pompe;
				}
				
			    public int Pistolet;

				public int getPistolet () {
					return this.Pistolet;
				}
				
			    public Float Index_de_debut;

				public Float getIndex_de_debut () {
					return this.Index_de_debut;
				}
				
			    public Float Index_de_fin;

				public Float getIndex_de_fin () {
					return this.Index_de_fin;
				}
				
			    public Float Tests_de_pompe;

				public Float getTests_de_pompe () {
					return this.Tests_de_pompe;
				}
				
			    public Float Quantite;

				public Float getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_unitaire;

				public Float getPrix_unitaire () {
					return this.Prix_unitaire;
				}
				
			    public Float Montant;

				public Float getMontant () {
					return this.Montant;
				}
				
			    public Byte Index_de_debut_modifie;

				public Byte getIndex_de_debut_modifie () {
					return this.Index_de_debut_modifie;
				}
				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Site="+Site);
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Carburant="+Carburant);
		sb.append(",Pompe="+String.valueOf(Pompe));
		sb.append(",Pistolet="+String.valueOf(Pistolet));
		sb.append(",Index_de_debut="+String.valueOf(Index_de_debut));
		sb.append(",Index_de_fin="+String.valueOf(Index_de_fin));
		sb.append(",Tests_de_pompe="+String.valueOf(Tests_de_pompe));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_unitaire="+String.valueOf(Prix_unitaire));
		sb.append(",Montant="+String.valueOf(Montant));
		sb.append(",Index_de_debut_modifie="+String.valueOf(Index_de_debut_modifie));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row1Struct other) {

		int returnValue = -1;
		
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}

public static class after_tFileInputExcel_2Struct implements routines.system.IPersistableRow<after_tFileInputExcel_2Struct> {
    final static byte[] commonByteArrayLock_EURODATA_vente_carburant = new byte[0];
    static byte[] commonByteArray_EURODATA_vente_carburant = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String Site;

				public String getSite () {
					return this.Site;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Carburant;

				public String getCarburant () {
					return this.Carburant;
				}
				
			    public int Pompe;

				public int getPompe () {
					return this.Pompe;
				}
				
			    public int Pistolet;

				public int getPistolet () {
					return this.Pistolet;
				}
				
			    public Float Index_de_debut;

				public Float getIndex_de_debut () {
					return this.Index_de_debut;
				}
				
			    public Float Index_de_fin;

				public Float getIndex_de_fin () {
					return this.Index_de_fin;
				}
				
			    public Float Tests_de_pompe;

				public Float getTests_de_pompe () {
					return this.Tests_de_pompe;
				}
				
			    public Float Quantite;

				public Float getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_unitaire;

				public Float getPrix_unitaire () {
					return this.Prix_unitaire;
				}
				
			    public Float Montant;

				public Float getMontant () {
					return this.Montant;
				}
				
			    public Byte Index_de_debut_modifie;

				public Byte getIndex_de_debut_modifie () {
					return this.Index_de_debut_modifie;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Site == null) ? 0 : this.Site.hashCode());
					
						result = prime * result + ((this.Date == null) ? 0 : this.Date.hashCode());
					
						result = prime * result + ((this.Carburant == null) ? 0 : this.Carburant.hashCode());
					
							result = prime * result + (int) this.Pompe;
						
							result = prime * result + (int) this.Pistolet;
						
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final after_tFileInputExcel_2Struct other = (after_tFileInputExcel_2Struct) obj;
		
						if (this.Site == null) {
							if (other.Site != null)
								return false;
						
						} else if (!this.Site.equals(other.Site))
						
							return false;
					
						if (this.Date == null) {
							if (other.Date != null)
								return false;
						
						} else if (!this.Date.equals(other.Date))
						
							return false;
					
						if (this.Carburant == null) {
							if (other.Carburant != null)
								return false;
						
						} else if (!this.Carburant.equals(other.Carburant))
						
							return false;
					
						if (this.Pompe != other.Pompe)
							return false;
					
						if (this.Pistolet != other.Pistolet)
							return false;
					

		return true;
    }

	public void copyDataTo(after_tFileInputExcel_2Struct other) {

		other.Site = this.Site;
	            other.Date = this.Date;
	            other.Carburant = this.Carburant;
	            other.Pompe = this.Pompe;
	            other.Pistolet = this.Pistolet;
	            other.Index_de_debut = this.Index_de_debut;
	            other.Index_de_fin = this.Index_de_fin;
	            other.Tests_de_pompe = this.Tests_de_pompe;
	            other.Quantite = this.Quantite;
	            other.Prix_unitaire = this.Prix_unitaire;
	            other.Montant = this.Montant;
	            other.Index_de_debut_modifie = this.Index_de_debut_modifie;
	            
	}

	public void copyKeysDataTo(after_tFileInputExcel_2Struct other) {

		other.Site = this.Site;
	            	other.Date = this.Date;
	            	other.Carburant = this.Carburant;
	            	other.Pompe = this.Pompe;
	            	other.Pistolet = this.Pistolet;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(ObjectInputStream dis) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		java.util.Date dateReturn = null;
        int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

    private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
    }
    
    private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Date = readDate(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// java.util.Date
				
						writeDate(this.Date,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// Float
				
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
					// Float
				
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
					// Float
				
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
					// Float
				
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
					// Float
				
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
					// Float
				
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
					// Byte
				
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Site="+Site);
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Carburant="+Carburant);
		sb.append(",Pompe="+String.valueOf(Pompe));
		sb.append(",Pistolet="+String.valueOf(Pistolet));
		sb.append(",Index_de_debut="+String.valueOf(Index_de_debut));
		sb.append(",Index_de_fin="+String.valueOf(Index_de_fin));
		sb.append(",Tests_de_pompe="+String.valueOf(Tests_de_pompe));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_unitaire="+String.valueOf(Prix_unitaire));
		sb.append(",Montant="+String.valueOf(Montant));
		sb.append(",Index_de_debut_modifie="+String.valueOf(Index_de_debut_modifie));
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(after_tFileInputExcel_2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Site, other.Site);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Date, other.Date);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Carburant, other.Carburant);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pompe, other.Pompe);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pistolet, other.Pistolet);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tFileInputExcel_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;


		tDBInput_1Process(globalMap);

		row1Struct row1 = new row1Struct();
insert_vente_carburantStruct insert_vente_carburant = new insert_vente_carburantStruct();
update_duplicateStruct update_duplicate = new update_duplicateStruct();





	
	/**
	 * [tDBOutput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_1", false);
		start_Hash.put("tDBOutput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"insert_vente_carburant");
					}
				
		int tos_count_tDBOutput_1 = 0;
		






int nb_line_tDBOutput_1 = 0;
int nb_line_update_tDBOutput_1 = 0;
int nb_line_inserted_tDBOutput_1 = 0;
int nb_line_deleted_tDBOutput_1 = 0;
int nb_line_rejected_tDBOutput_1 = 0;

int deletedCount_tDBOutput_1=0;
int updatedCount_tDBOutput_1=0;
int insertedCount_tDBOutput_1=0;
int rowsToCommitCount_tDBOutput_1=0;
int rejectedCount_tDBOutput_1=0;

String tableName_tDBOutput_1 = "vente_carburant";
boolean whetherReject_tDBOutput_1 = false;

java.util.Calendar calendar_tDBOutput_1 = java.util.Calendar.getInstance();
calendar_tDBOutput_1.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
calendar_tDBOutput_1.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_1 = calendar_tDBOutput_1.getTime().getTime();
long date_tDBOutput_1;

java.sql.Connection conn_tDBOutput_1 = null;
		
        String properties_tDBOutput_1 = "serverTimezone=UTC";
        if (properties_tDBOutput_1 == null || properties_tDBOutput_1.trim().length() == 0) {
            properties_tDBOutput_1 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_1.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_1 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_1.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_1 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "eurodata" + "?" + properties_tDBOutput_1;
		
		String driverClass_tDBOutput_1 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_1 = "root";
		

		 
	final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:g76ald+bBQyGJ23ceE4ybDfHJMZ9Jtkbnjm3V43WQDtKPSwjqQM=");

		String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;
		java.lang.Class.forName(driverClass_tDBOutput_1);
		
		conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1, dbPwd_tDBOutput_1);
		
	
	resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
        conn_tDBOutput_1.setAutoCommit(false);
        int commitEvery_tDBOutput_1 = 10000;
        int commitCounter_tDBOutput_1 = 0;

int count_tDBOutput_1=0;
    	

				String insert_tDBOutput_1 = "INSERT INTO `" + "vente_carburant" + "` (`Site`,`Date`,`Carburant`,`Pompe`,`Pistolet`,`Index_de_debut`,`Index_de_fin`,`Tests de pompe`,`Quantite`,`Prix_unitaire`,`Montant`,`Index_de_debut_modifie`,`last_update`,`inserted_date`,`date_str`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		        int batchSize_tDBOutput_1 = 100;
	   			int batchSizeCounter_tDBOutput_1=0;
		            
		        java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
		        resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);


 



/**
 * [tDBOutput_1 begin ] stop
 */




	
	/**
	 * [tDBOutput_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBOutput_2", false);
		start_Hash.put("tDBOutput_2", System.currentTimeMillis());
		
	
	currentComponent="tDBOutput_2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"update_duplicate");
					}
				
		int tos_count_tDBOutput_2 = 0;
		






int nb_line_tDBOutput_2 = 0;
int nb_line_update_tDBOutput_2 = 0;
int nb_line_inserted_tDBOutput_2 = 0;
int nb_line_deleted_tDBOutput_2 = 0;
int nb_line_rejected_tDBOutput_2 = 0;

int deletedCount_tDBOutput_2=0;
int updatedCount_tDBOutput_2=0;
int insertedCount_tDBOutput_2=0;
int rowsToCommitCount_tDBOutput_2=0;
int rejectedCount_tDBOutput_2=0;

String tableName_tDBOutput_2 = "vente_carburant";
boolean whetherReject_tDBOutput_2 = false;

java.util.Calendar calendar_tDBOutput_2 = java.util.Calendar.getInstance();
calendar_tDBOutput_2.set(1, 0, 1, 0, 0, 0);
long year1_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
calendar_tDBOutput_2.set(10000, 0, 1, 0, 0, 0);
long year10000_tDBOutput_2 = calendar_tDBOutput_2.getTime().getTime();
long date_tDBOutput_2;

java.sql.Connection conn_tDBOutput_2 = null;
		
        String properties_tDBOutput_2 = "serverTimezone=UTC";
        if (properties_tDBOutput_2 == null || properties_tDBOutput_2.trim().length() == 0) {
            properties_tDBOutput_2 = "rewriteBatchedStatements=true&allowLoadLocalInfile=true";
        }else {
            if (!properties_tDBOutput_2.contains("rewriteBatchedStatements=")) {
                properties_tDBOutput_2 += "&rewriteBatchedStatements=true";
            }

            if (!properties_tDBOutput_2.contains("allowLoadLocalInfile=")) {
                properties_tDBOutput_2 += "&allowLoadLocalInfile=true";
            }
        }

        String url_tDBOutput_2 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "eurodata" + "?" + properties_tDBOutput_2;
		
		String driverClass_tDBOutput_2 = "com.mysql.cj.jdbc.Driver";
		
		String dbUser_tDBOutput_2 = "root";
		

		 
	final String decryptedPassword_tDBOutput_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:wk+ziYloZYwSV8EgAgnrcbFt5w3GkTqe+rNdteOINFLTs2LRTU8=");

		String dbPwd_tDBOutput_2 = decryptedPassword_tDBOutput_2;
		java.lang.Class.forName(driverClass_tDBOutput_2);
		
		conn_tDBOutput_2 = java.sql.DriverManager.getConnection(url_tDBOutput_2, dbUser_tDBOutput_2, dbPwd_tDBOutput_2);
		
	
	resourceMap.put("conn_tDBOutput_2", conn_tDBOutput_2);
        conn_tDBOutput_2.setAutoCommit(false);
        int commitEvery_tDBOutput_2 = 10000;
        int commitCounter_tDBOutput_2 = 0;

int count_tDBOutput_2=0;
    	
	    String replace_tDBOutput_2 = "REPLACE INTO `" + "vente_carburant" + "` (`Site`,`Date`,`Carburant`,`Pompe`,`Pistolet`,`Index_de_debut`,`Index_de_fin`,`Tests de pompe`,`Quantite`,`Prix_unitaire`,`Montant`,`Index_de_debut_modifie`,`last_update`,`inserted_date`,`date_str`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    java.sql.PreparedStatement pstmt_tDBOutput_2 = conn_tDBOutput_2.prepareStatement(replace_tDBOutput_2);
	    resourceMap.put("pstmt_tDBOutput_2", pstmt_tDBOutput_2);
	    

 



/**
 * [tDBOutput_2 begin ] stop
 */



	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tMap_1", false);
		start_Hash.put("tMap_1", System.currentTimeMillis());
		
	
	currentComponent="tMap_1";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tMap_1 = 0;
		




// ###############################
// # Lookup's keys initialization
	
		org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 = (org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
				((org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct>) 
					globalMap.get( "tHash_Lookup_row2" ))
					;					
					
	

row2Struct row2HashKey = new row2Struct();
row2Struct row2Default = new row2Struct();
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
insert_vente_carburantStruct insert_vente_carburant_tmp = new insert_vente_carburantStruct();
update_duplicateStruct update_duplicate_tmp = new update_duplicateStruct();
// ###############################

        
        



        









 



/**
 * [tMap_1 begin ] stop
 */



	
	/**
	 * [tFileInputExcel_2 begin ] start
	 */

	

	
		
		ok_Hash.put("tFileInputExcel_2", false);
		start_Hash.put("tFileInputExcel_2", System.currentTimeMillis());
		
	
	currentComponent="tFileInputExcel_2";

	
		int tos_count_tFileInputExcel_2 = 0;
		

 
	final String decryptedPassword_tFileInputExcel_2 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:R4VgPLjKe2OEHrhYNJpEC49qOQjQtYzfZTWNaA==");
        String password_tFileInputExcel_2 = decryptedPassword_tFileInputExcel_2;
        if (password_tFileInputExcel_2.isEmpty()){
            password_tFileInputExcel_2 = null;
        }
			class RegexUtil_tFileInputExcel_2 {

		    	public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, String oneSheetName, boolean useRegex) {

			        java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();

			        if(useRegex){//this part process the regex issue

				        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(oneSheetName);
				        for (org.apache.poi.ss.usermodel.Sheet sheet : workbook) {
				            String sheetName = sheet.getSheetName();
				            java.util.regex.Matcher matcher = pattern.matcher(sheetName);
				            if (matcher.matches()) {
				            	if(sheet != null){
				                	list.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet);
				                }
				            }
				        }

			        }else{
			        	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheet(oneSheetName);
		            	if(sheet != null){
		                	list.add(sheet);
		                }

			        }

			        return list;
			    }

			    public java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> getSheets(org.apache.poi.xssf.usermodel.XSSFWorkbook workbook, int index, boolean useRegex) {
			    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> list =  new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
			    	org.apache.poi.xssf.usermodel.XSSFSheet sheet = (org.apache.poi.xssf.usermodel.XSSFSheet) workbook.getSheetAt(index);
	            	if(sheet != null){
	                	list.add(sheet);
	                }
			    	return list;
			    }

			}
		RegexUtil_tFileInputExcel_2 regexUtil_tFileInputExcel_2 = new RegexUtil_tFileInputExcel_2();

		Object source_tFileInputExcel_2 = "C:/Users/datamanager1/0_dev_eurodata/B_data_processing/INPUT/vente_carburant.xlsx";
		org.apache.poi.xssf.usermodel.XSSFWorkbook workbook_tFileInputExcel_2 = null;

		if(source_tFileInputExcel_2 instanceof String){
			workbook_tFileInputExcel_2 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create(new java.io.File((String)source_tFileInputExcel_2), password_tFileInputExcel_2, true);
		} else if(source_tFileInputExcel_2 instanceof java.io.InputStream) {
     		workbook_tFileInputExcel_2 = (org.apache.poi.xssf.usermodel.XSSFWorkbook) org.apache.poi.ss.usermodel.WorkbookFactory.create((java.io.InputStream)source_tFileInputExcel_2, password_tFileInputExcel_2);
		} else{
			workbook_tFileInputExcel_2 = null;
			throw new java.lang.Exception("The data source should be specified as Inputstream or File Path!");
		}
		try {

    	java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_tFileInputExcel_2 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
    	for(org.apache.poi.ss.usermodel.Sheet sheet_tFileInputExcel_2 : workbook_tFileInputExcel_2){
   			sheetList_tFileInputExcel_2.add((org.apache.poi.xssf.usermodel.XSSFSheet) sheet_tFileInputExcel_2);
    	}
    	if(sheetList_tFileInputExcel_2.size() <= 0){
            throw new RuntimeException("Special sheets not exist!");
        }

		java.util.List<org.apache.poi.xssf.usermodel.XSSFSheet> sheetList_FilterNull_tFileInputExcel_2 = new java.util.ArrayList<org.apache.poi.xssf.usermodel.XSSFSheet>();
		for (org.apache.poi.xssf.usermodel.XSSFSheet sheet_FilterNull_tFileInputExcel_2 : sheetList_tFileInputExcel_2) {
			if(sheet_FilterNull_tFileInputExcel_2!=null && sheetList_FilterNull_tFileInputExcel_2.iterator()!=null && sheet_FilterNull_tFileInputExcel_2.iterator().hasNext()){
				sheetList_FilterNull_tFileInputExcel_2.add(sheet_FilterNull_tFileInputExcel_2);
			}
		}
		sheetList_tFileInputExcel_2 = sheetList_FilterNull_tFileInputExcel_2;
	if(sheetList_tFileInputExcel_2.size()>0){
		int nb_line_tFileInputExcel_2 = 0;

        int begin_line_tFileInputExcel_2 = 1;

        int footer_input_tFileInputExcel_2 = 0;

        int end_line_tFileInputExcel_2=0;
        for(org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_2:sheetList_tFileInputExcel_2){
			end_line_tFileInputExcel_2+=(sheet_tFileInputExcel_2.getLastRowNum()+1);
        }
        end_line_tFileInputExcel_2 -= footer_input_tFileInputExcel_2;
        int limit_tFileInputExcel_2 = -1;
        int start_column_tFileInputExcel_2 = 1-1;
        int end_column_tFileInputExcel_2 = -1;

        org.apache.poi.xssf.usermodel.XSSFRow row_tFileInputExcel_2 = null;
        org.apache.poi.xssf.usermodel.XSSFSheet sheet_tFileInputExcel_2 = sheetList_tFileInputExcel_2.get(0);
        int rowCount_tFileInputExcel_2 = 0;
        int sheetIndex_tFileInputExcel_2 = 0;
        int currentRows_tFileInputExcel_2 = (sheetList_tFileInputExcel_2.get(0).getLastRowNum()+1);

		//for the number format
        java.text.DecimalFormat df_tFileInputExcel_2 = new java.text.DecimalFormat("#.####################################");
        char decimalChar_tFileInputExcel_2 = df_tFileInputExcel_2.getDecimalFormatSymbols().getDecimalSeparator();
		
        for(int i_tFileInputExcel_2 = begin_line_tFileInputExcel_2; i_tFileInputExcel_2 < end_line_tFileInputExcel_2; i_tFileInputExcel_2++){

        	int emptyColumnCount_tFileInputExcel_2 = 0;

        	if (limit_tFileInputExcel_2 != -1 && nb_line_tFileInputExcel_2 >= limit_tFileInputExcel_2) {
        		break;
        	}

            while (i_tFileInputExcel_2 >= rowCount_tFileInputExcel_2 + currentRows_tFileInputExcel_2) {
                rowCount_tFileInputExcel_2 += currentRows_tFileInputExcel_2;
                sheet_tFileInputExcel_2 = sheetList_tFileInputExcel_2.get(++sheetIndex_tFileInputExcel_2);
                currentRows_tFileInputExcel_2 = (sheet_tFileInputExcel_2.getLastRowNum()+1);
            }
            globalMap.put("tFileInputExcel_2_CURRENT_SHEET",sheet_tFileInputExcel_2.getSheetName());
            if (rowCount_tFileInputExcel_2 <= i_tFileInputExcel_2) {
                row_tFileInputExcel_2 = sheet_tFileInputExcel_2.getRow(i_tFileInputExcel_2 - rowCount_tFileInputExcel_2);
            }
		    row1 = null;
					int tempRowLength_tFileInputExcel_2 = 12;
				
				int columnIndex_tFileInputExcel_2 = 0;
			
			String[] temp_row_tFileInputExcel_2 = new String[tempRowLength_tFileInputExcel_2];
			int excel_end_column_tFileInputExcel_2;
			if(row_tFileInputExcel_2==null){
				excel_end_column_tFileInputExcel_2=0;
			}else{
				excel_end_column_tFileInputExcel_2=row_tFileInputExcel_2.getLastCellNum();
			}
			int actual_end_column_tFileInputExcel_2;
			if(end_column_tFileInputExcel_2 == -1){
				actual_end_column_tFileInputExcel_2 = excel_end_column_tFileInputExcel_2;
			}
			else{
				actual_end_column_tFileInputExcel_2 = end_column_tFileInputExcel_2 >	excel_end_column_tFileInputExcel_2 ? excel_end_column_tFileInputExcel_2 : end_column_tFileInputExcel_2;
			}
			org.apache.poi.ss.formula.eval.NumberEval ne_tFileInputExcel_2 = null;
			for(int i=0;i<tempRowLength_tFileInputExcel_2;i++){
				if(i + start_column_tFileInputExcel_2 < actual_end_column_tFileInputExcel_2){
					org.apache.poi.ss.usermodel.Cell cell_tFileInputExcel_2 = row_tFileInputExcel_2.getCell(i + start_column_tFileInputExcel_2);
					if(cell_tFileInputExcel_2!=null){
					switch (cell_tFileInputExcel_2.getCellType()) {
                        case STRING:
                            temp_row_tFileInputExcel_2[i] = cell_tFileInputExcel_2.getRichStringCellValue().getString();
                            break;
                        case NUMERIC:
                            if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_2)) {
									temp_row_tFileInputExcel_2[i] =cell_tFileInputExcel_2.getDateCellValue().toString();
                            } else {
                                temp_row_tFileInputExcel_2[i] = df_tFileInputExcel_2.format(cell_tFileInputExcel_2.getNumericCellValue());
                            }
                            break;
                        case BOOLEAN:
                            temp_row_tFileInputExcel_2[i] =String.valueOf(cell_tFileInputExcel_2.getBooleanCellValue());
                            break;
                        case FORMULA:
        					switch (cell_tFileInputExcel_2.getCachedFormulaResultType()) {
                                case STRING:
                                    temp_row_tFileInputExcel_2[i] = cell_tFileInputExcel_2.getRichStringCellValue().getString();
                                    break;
                                case NUMERIC:
                                    if (org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(cell_tFileInputExcel_2)) {
											temp_row_tFileInputExcel_2[i] =cell_tFileInputExcel_2.getDateCellValue().toString();
                                    } else {
	                                    ne_tFileInputExcel_2 = new org.apache.poi.ss.formula.eval.NumberEval(cell_tFileInputExcel_2.getNumericCellValue());
										temp_row_tFileInputExcel_2[i] = ne_tFileInputExcel_2.getStringValue();
                                    }
                                    break;
                                case BOOLEAN:
                                    temp_row_tFileInputExcel_2[i] =String.valueOf(cell_tFileInputExcel_2.getBooleanCellValue());
                                    break;
                                default:
                            		temp_row_tFileInputExcel_2[i] = "";
                            }
                            break;
                        default:
                            temp_row_tFileInputExcel_2[i] = "";
                        }
                	}
                	else{
                		temp_row_tFileInputExcel_2[i]="";
                	}

				}else{
					temp_row_tFileInputExcel_2[i]="";
				}
			}
			boolean whetherReject_tFileInputExcel_2 = false;
			row1 = new row1Struct();
			int curColNum_tFileInputExcel_2 = -1;
			String curColName_tFileInputExcel_2 = "";
			try{
							columnIndex_tFileInputExcel_2 = 0;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Site";

				row1.Site = temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2];
			}else{
				row1.Site = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 1;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Date";

				if(1<actual_end_column_tFileInputExcel_2){
					try{
						if(row_tFileInputExcel_2.getCell(columnIndex_tFileInputExcel_2+ start_column_tFileInputExcel_2).getCellType() == org.apache.poi.ss.usermodel.CellType.NUMERIC && org.apache.poi.ss.usermodel.DateUtil.isCellDateFormatted(row_tFileInputExcel_2.getCell(columnIndex_tFileInputExcel_2+ start_column_tFileInputExcel_2))){
							row1.Date = row_tFileInputExcel_2.getCell(columnIndex_tFileInputExcel_2+ start_column_tFileInputExcel_2).getDateCellValue();
						}
						else{
                            java.util.Date tempDate_tFileInputExcel_2 = ParserUtils.parseTo_Date(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], "dd-MM-yyyy");
                            if(tempDate_tFileInputExcel_2.after((new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS")).parse("9999/12/31 23:59:59.999"))||tempDate_tFileInputExcel_2.before((new SimpleDateFormat("yyyy/MM/dd")).parse("1900/01/01"))){
                                throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_2+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_2 + " )");
                            }else{
                                row1.Date = tempDate_tFileInputExcel_2;
                            }
						}
					}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_2_ERROR_MESSAGE",e.getMessage());
						
						throw new RuntimeException("The cell format is not Date in ( Row. "+(nb_line_tFileInputExcel_2+1)+ " and ColumnNum. " + curColNum_tFileInputExcel_2 + " )");
					}
				}

			}else{
				row1.Date = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 2;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Carburant";

				row1.Carburant = temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2];
			}else{
				row1.Carburant = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 3;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Pompe";

				row1.Pompe = ParserUtils.parseTo_int(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Pompe = 0;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 4;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Pistolet";

				row1.Pistolet = ParserUtils.parseTo_int(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Pistolet = 0;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 5;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Index_de_debut";

				row1.Index_de_debut = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Index_de_debut = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 6;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Index_de_fin";

				row1.Index_de_fin = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Index_de_fin = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 7;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Tests_de_pompe";

				row1.Tests_de_pompe = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Tests_de_pompe = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 8;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Quantite";

				row1.Quantite = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Quantite = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 9;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Prix_unitaire";

				row1.Prix_unitaire = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Prix_unitaire = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 10;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Montant";

				row1.Montant = ParserUtils.parseTo_Float(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Montant = null;
				emptyColumnCount_tFileInputExcel_2++;
			}
							columnIndex_tFileInputExcel_2 = 11;
						
			if( temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2].length() > 0) {
				curColNum_tFileInputExcel_2=columnIndex_tFileInputExcel_2 + start_column_tFileInputExcel_2 + 1;
				curColName_tFileInputExcel_2 = "Index_de_debut_modifie";

				row1.Index_de_debut_modifie = ParserUtils.parseTo_Byte(ParserUtils.parseTo_Number(temp_row_tFileInputExcel_2[columnIndex_tFileInputExcel_2], null, '.'==decimalChar_tFileInputExcel_2 ? null : decimalChar_tFileInputExcel_2));
			}else{
				row1.Index_de_debut_modifie = null;
				emptyColumnCount_tFileInputExcel_2++;
			}

				nb_line_tFileInputExcel_2++;
				
			}catch(java.lang.Exception e){
globalMap.put("tFileInputExcel_2_ERROR_MESSAGE",e.getMessage());
			whetherReject_tFileInputExcel_2 = true;
					 System.err.println(e.getMessage());
					 row1 = null;
			}


		



 



/**
 * [tFileInputExcel_2 begin ] stop
 */
	
	/**
	 * [tFileInputExcel_2 main ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 


	tos_count_tFileInputExcel_2++;

/**
 * [tFileInputExcel_2 main ] stop
 */
	
	/**
	 * [tFileInputExcel_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 process_data_begin ] stop
 */
// Start of branch "row1"
if(row1 != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	currentComponent="tMap_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row1"
						
						);
					}
					

		
		
		boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;
		

        // ###############################
        // # Input tables (lookups)
		  boolean rejectedInnerJoin_tMap_1 = false;
		  boolean mainRowRejected_tMap_1 = false;
            				    								  
		

				///////////////////////////////////////////////
				// Starting Lookup Table "row2" 
				///////////////////////////////////////////////


				
				
                            
 					    boolean forceLooprow2 = false;
       		  	    	
       		  	    	
 							row2Struct row2ObjectFromLookup = null;
                          
		           		  	if(!rejectedInnerJoin_tMap_1) { // G_TM_M_020

								
								hasCasePrimitiveKeyWithNull_tMap_1 = false;
								
                        		    		    row2HashKey.Site = row1.Site ;
                        		    		
                        		    		    row2HashKey.Carburant = row1.Carburant ;
                        		    		
	                        		    	Object exprKeyValue_row2__Pompe = row1.Pompe ;
	                        		    	if(exprKeyValue_row2__Pompe == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row2HashKey.Pompe = (int)(Integer) exprKeyValue_row2__Pompe;
                        		    		}
                        		    		
	                        		    	Object exprKeyValue_row2__Pistolet = row1.Pistolet ;
	                        		    	if(exprKeyValue_row2__Pistolet == null) {
	                        		    		hasCasePrimitiveKeyWithNull_tMap_1 = true;
	                        		    	} else {
                        		    			row2HashKey.Pistolet = (int)(Integer) exprKeyValue_row2__Pistolet;
                        		    		}
                        		    		
                        		    		    row2HashKey.date_str = TalendDate.formatDate("yyyyMMdd",row1.Date) ;
                        		    		

								
		                        	row2HashKey.hashCodeDirty = true;
                        		
	  					
	  							
	
		  							if(!hasCasePrimitiveKeyWithNull_tMap_1) { // G_TM_M_091
		  							
			  					
			  					
			  					
	  					
		  							tHash_Lookup_row2.lookup( row2HashKey );

	  							

	  							

			  						} // G_TM_M_091
			  						
			  					

 								
								  
								  if(hasCasePrimitiveKeyWithNull_tMap_1 || !tHash_Lookup_row2.hasNext()) { // G_TM_M_090

  								
		  				
	  								
			  							rejectedInnerJoin_tMap_1 = true;
	  								
						
									
  									  		
 								
								  
								  } // G_TM_M_090

  								



							} // G_TM_M_020
			           		  	  
							
				           		if(tHash_Lookup_row2 != null && tHash_Lookup_row2.getCount(row2HashKey) > 1) { // G 071
			  							
			  						
									 		
									//System.out.println("WARNING: UNIQUE MATCH is configured for the lookup 'row2' and it contains more one result from keys :  row2.Site = '" + row2HashKey.Site + "', row2.Carburant = '" + row2HashKey.Carburant + "', row2.Pompe = '" + row2HashKey.Pompe + "', row2.Pistolet = '" + row2HashKey.Pistolet + "', row2.date_str = '" + row2HashKey.date_str + "'");
								} // G 071
							

							row2Struct row2 = null;
                    		  	 
							   
                    		  	 
	       		  	    	row2Struct fromLookup_row2 = null;
							row2 = row2Default;
										 
							
								 
							
							
								if (tHash_Lookup_row2 !=null && tHash_Lookup_row2.hasNext()) { // G 099
								
							
								
								fromLookup_row2 = tHash_Lookup_row2.next();

							
							
								} // G 099
							
							

							if(fromLookup_row2 != null) {
								row2 = fromLookup_row2;
							}
							
							
							
			  							
								
	                    		  	
		                    
	            	
	            	
	            // ###############################
        { // start of Var scope
        
	        // ###############################
        	// # Vars tables
        
Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
        // ###############################
        // # Output tables

update_duplicate = null;
insert_vente_carburant = null;

if(!rejectedInnerJoin_tMap_1 ) {

// # Output table : 'update_duplicate'
// # Filter conditions 
if( 

Float.compare(row1.Quantite , row2.Quantite ) != 0  
|| Float.compare(row1.Prix_unitaire , row2.Prix_unitaire ) != 0
|| Float.compare(row1.Montant , row2.Montant) != 0

 ) {
update_duplicate_tmp.Site = row1.Site ;
update_duplicate_tmp.Date = row1.Date ;
update_duplicate_tmp.Carburant = row1.Carburant ;
update_duplicate_tmp.Pompe = row1.Pompe ;
update_duplicate_tmp.Pistolet = row1.Pistolet ;
update_duplicate_tmp.Index_de_debut = row1.Index_de_debut ;
update_duplicate_tmp.Index_de_fin = row1.Index_de_fin ;
update_duplicate_tmp.Tests_de_pompe = row1.Tests_de_pompe ;
update_duplicate_tmp.Quantite = row1.Quantite ;
update_duplicate_tmp.Prix_unitaire = row1.Prix_unitaire ;
update_duplicate_tmp.Montant = row1.Montant ;
update_duplicate_tmp.Index_de_debut_modifie = row1.Index_de_debut_modifie ;
update_duplicate_tmp.last_update = TalendDate.getCurrentDate() ;
update_duplicate_tmp.inserted_date = row2.inserted_date ;
update_duplicate_tmp.date_str = TalendDate.formatDate("yyyyMMdd",row1.Date) ;
update_duplicate = update_duplicate_tmp;
} // closing filter/reject
} // closing inner join bracket (1)
// ###### START REJECTS ##### 

// # Output reject table : 'insert_vente_carburant'
// # Filter conditions 
if( rejectedInnerJoin_tMap_1 ) {
insert_vente_carburant_tmp.Site = row1.Site ;
insert_vente_carburant_tmp.Date = row1.Date ;
insert_vente_carburant_tmp.Carburant = row1.Carburant ;
insert_vente_carburant_tmp.Pompe = row1.Pompe ;
insert_vente_carburant_tmp.Pistolet = row1.Pistolet ;
insert_vente_carburant_tmp.Index_de_debut = row1.Index_de_debut ;
insert_vente_carburant_tmp.Index_de_fin = row1.Index_de_fin ;
insert_vente_carburant_tmp.Tests_de_pompe = row1.Tests_de_pompe ;
insert_vente_carburant_tmp.Quantite = row1.Quantite ;
insert_vente_carburant_tmp.Prix_unitaire = row1.Prix_unitaire ;
insert_vente_carburant_tmp.Montant = row1.Montant ;
insert_vente_carburant_tmp.Index_de_debut_modifie = row1.Index_de_debut_modifie ;
insert_vente_carburant_tmp.last_update = row2.last_update  ;
insert_vente_carburant_tmp.inserted_date = TalendDate.getCurrentDate() ;
insert_vente_carburant_tmp.date_str = TalendDate.formatDate("yyyyMMdd",row1.Date) ;
insert_vente_carburant = insert_vente_carburant_tmp;
} // closing filter/reject
// ###############################

} // end of Var scope

rejectedInnerJoin_tMap_1 = false;










 


	tos_count_tMap_1++;

/**
 * [tMap_1 main ] stop
 */
	
	/**
	 * [tMap_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_begin ] stop
 */
// Start of branch "insert_vente_carburant"
if(insert_vente_carburant != null) { 



	
	/**
	 * [tDBOutput_1 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"insert_vente_carburant"
						
						);
					}
					



        whetherReject_tDBOutput_1 = false;
                            if(insert_vente_carburant.Site == null) {
pstmt_tDBOutput_1.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(1, insert_vente_carburant.Site);
}

                            if(insert_vente_carburant.Date != null) {
date_tDBOutput_1 = insert_vente_carburant.Date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(2, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(2, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(2, java.sql.Types.DATE);
}

                            if(insert_vente_carburant.Carburant == null) {
pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(3, insert_vente_carburant.Carburant);
}

                            pstmt_tDBOutput_1.setInt(4, insert_vente_carburant.Pompe);

                            pstmt_tDBOutput_1.setInt(5, insert_vente_carburant.Pistolet);

                            if(insert_vente_carburant.Index_de_debut == null) {
pstmt_tDBOutput_1.setNull(6, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(6, insert_vente_carburant.Index_de_debut);
}

                            if(insert_vente_carburant.Index_de_fin == null) {
pstmt_tDBOutput_1.setNull(7, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(7, insert_vente_carburant.Index_de_fin);
}

                            if(insert_vente_carburant.Tests_de_pompe == null) {
pstmt_tDBOutput_1.setNull(8, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(8, insert_vente_carburant.Tests_de_pompe);
}

                            if(insert_vente_carburant.Quantite == null) {
pstmt_tDBOutput_1.setNull(9, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(9, insert_vente_carburant.Quantite);
}

                            if(insert_vente_carburant.Prix_unitaire == null) {
pstmt_tDBOutput_1.setNull(10, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(10, insert_vente_carburant.Prix_unitaire);
}

                            if(insert_vente_carburant.Montant == null) {
pstmt_tDBOutput_1.setNull(11, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_1.setFloat(11, insert_vente_carburant.Montant);
}

                            if(insert_vente_carburant.Index_de_debut_modifie == null) {
pstmt_tDBOutput_1.setNull(12, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_1.setByte(12, insert_vente_carburant.Index_de_debut_modifie);
}

                            if(insert_vente_carburant.last_update != null) {
date_tDBOutput_1 = insert_vente_carburant.last_update.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(13, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(13, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(13, java.sql.Types.DATE);
}

                            if(insert_vente_carburant.inserted_date != null) {
date_tDBOutput_1 = insert_vente_carburant.inserted_date.getTime();
if(date_tDBOutput_1 < year1_tDBOutput_1 || date_tDBOutput_1 >= year10000_tDBOutput_1) {
pstmt_tDBOutput_1.setString(14, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_1.setTimestamp(14, new java.sql.Timestamp(date_tDBOutput_1));
}
} else {
pstmt_tDBOutput_1.setNull(14, java.sql.Types.DATE);
}

                            if(insert_vente_carburant.date_str == null) {
pstmt_tDBOutput_1.setNull(15, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_1.setString(15, insert_vente_carburant.date_str);
}

                    pstmt_tDBOutput_1.addBatch();
                    nb_line_tDBOutput_1++;

						
                      batchSizeCounter_tDBOutput_1++;
                if ( batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1) {
                try {
                        int countSum_tDBOutput_1 = 0;
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                        insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_1 = 0;
                    for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                        countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                    }
                    rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                    System.err.println(e.getMessage());
                }

                batchSizeCounter_tDBOutput_1 = 0;
            }
                commitCounter_tDBOutput_1++;

                if(commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {

                try {
                        int countSum_tDBOutput_1 = 0;
                        for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
                            countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : 1);
                        }
                        rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                        insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                }catch (java.sql.BatchUpdateException e){
globalMap.put("tDBOutput_1_ERROR_MESSAGE",e.getMessage());
                    int countSum_tDBOutput_1 = 0;
                    for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
                        countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
                    }
                    rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
                    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
                    System.err.println(e.getMessage());

                }
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                    }
                    conn_tDBOutput_1.commit();
                    if(rowsToCommitCount_tDBOutput_1 != 0){
                        rowsToCommitCount_tDBOutput_1 = 0;
                    }
                    commitCounter_tDBOutput_1=0;

                }


 


	tos_count_tDBOutput_1++;

/**
 * [tDBOutput_1 main ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	

 



/**
 * [tDBOutput_1 process_data_end ] stop
 */

} // End of branch "insert_vente_carburant"




// Start of branch "update_duplicate"
if(update_duplicate != null) { 



	
	/**
	 * [tDBOutput_2 main ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"update_duplicate"
						
						);
					}
					



        whetherReject_tDBOutput_2 = false;
                    if(update_duplicate.Site == null) {
pstmt_tDBOutput_2.setNull(1, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(1, update_duplicate.Site);
}

                    if(update_duplicate.Date != null) {
date_tDBOutput_2 = update_duplicate.Date.getTime();
if(date_tDBOutput_2 < year1_tDBOutput_2 || date_tDBOutput_2 >= year10000_tDBOutput_2) {
pstmt_tDBOutput_2.setString(2, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_2.setTimestamp(2, new java.sql.Timestamp(date_tDBOutput_2));
}
} else {
pstmt_tDBOutput_2.setNull(2, java.sql.Types.DATE);
}

                    if(update_duplicate.Carburant == null) {
pstmt_tDBOutput_2.setNull(3, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(3, update_duplicate.Carburant);
}

                    pstmt_tDBOutput_2.setInt(4, update_duplicate.Pompe);

                    pstmt_tDBOutput_2.setInt(5, update_duplicate.Pistolet);

                    if(update_duplicate.Index_de_debut == null) {
pstmt_tDBOutput_2.setNull(6, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_2.setFloat(6, update_duplicate.Index_de_debut);
}

                    if(update_duplicate.Index_de_fin == null) {
pstmt_tDBOutput_2.setNull(7, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_2.setFloat(7, update_duplicate.Index_de_fin);
}

                    if(update_duplicate.Tests_de_pompe == null) {
pstmt_tDBOutput_2.setNull(8, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_2.setFloat(8, update_duplicate.Tests_de_pompe);
}

                    if(update_duplicate.Quantite == null) {
pstmt_tDBOutput_2.setNull(9, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_2.setFloat(9, update_duplicate.Quantite);
}

                    if(update_duplicate.Prix_unitaire == null) {
pstmt_tDBOutput_2.setNull(10, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_2.setFloat(10, update_duplicate.Prix_unitaire);
}

                    if(update_duplicate.Montant == null) {
pstmt_tDBOutput_2.setNull(11, java.sql.Types.FLOAT);
} else {pstmt_tDBOutput_2.setFloat(11, update_duplicate.Montant);
}

                    if(update_duplicate.Index_de_debut_modifie == null) {
pstmt_tDBOutput_2.setNull(12, java.sql.Types.INTEGER);
} else {pstmt_tDBOutput_2.setByte(12, update_duplicate.Index_de_debut_modifie);
}

                    if(update_duplicate.last_update != null) {
date_tDBOutput_2 = update_duplicate.last_update.getTime();
if(date_tDBOutput_2 < year1_tDBOutput_2 || date_tDBOutput_2 >= year10000_tDBOutput_2) {
pstmt_tDBOutput_2.setString(13, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_2.setTimestamp(13, new java.sql.Timestamp(date_tDBOutput_2));
}
} else {
pstmt_tDBOutput_2.setNull(13, java.sql.Types.DATE);
}

                    if(update_duplicate.inserted_date != null) {
date_tDBOutput_2 = update_duplicate.inserted_date.getTime();
if(date_tDBOutput_2 < year1_tDBOutput_2 || date_tDBOutput_2 >= year10000_tDBOutput_2) {
pstmt_tDBOutput_2.setString(14, "0000-00-00 00:00:00");
} else {pstmt_tDBOutput_2.setTimestamp(14, new java.sql.Timestamp(date_tDBOutput_2));
}
} else {
pstmt_tDBOutput_2.setNull(14, java.sql.Types.DATE);
}

                    if(update_duplicate.date_str == null) {
pstmt_tDBOutput_2.setNull(15, java.sql.Types.VARCHAR);
} else {pstmt_tDBOutput_2.setString(15, update_duplicate.date_str);
}

            int replaceCount_tDBOutput_2 = 0;
            try {
                int processedCount_tDBOutput_2 = pstmt_tDBOutput_2.executeUpdate();
                replaceCount_tDBOutput_2 += processedCount_tDBOutput_2;
                rowsToCommitCount_tDBOutput_2 += processedCount_tDBOutput_2;
            } catch(java.lang.Exception e) {
globalMap.put("tDBOutput_2_ERROR_MESSAGE",e.getMessage());
                whetherReject_tDBOutput_2 = true;
                        System.err.print(e.getMessage());
            }
            if(replaceCount_tDBOutput_2 == 1) {
                insertedCount_tDBOutput_2 += replaceCount_tDBOutput_2;
            } else {
                insertedCount_tDBOutput_2 += 1;
                deletedCount_tDBOutput_2 += replaceCount_tDBOutput_2 - 1;
            }
                commitCounter_tDBOutput_2++;

                if(commitEvery_tDBOutput_2 <= commitCounter_tDBOutput_2) {

                    if(rowsToCommitCount_tDBOutput_2 != 0){
                    }
                    conn_tDBOutput_2.commit();
                    if(rowsToCommitCount_tDBOutput_2 != 0){
                        rowsToCommitCount_tDBOutput_2 = 0;
                    }
                    commitCounter_tDBOutput_2=0;

                }


 


	tos_count_tDBOutput_2++;

/**
 * [tDBOutput_2 main ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_begin ] stop
 */
	
	/**
	 * [tDBOutput_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	

 



/**
 * [tDBOutput_2 process_data_end ] stop
 */

} // End of branch "update_duplicate"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 process_data_end ] stop
 */

} // End of branch "row1"




	
	/**
	 * [tFileInputExcel_2 process_data_end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 process_data_end ] stop
 */
	
	/**
	 * [tFileInputExcel_2 end ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

			}
			
			
			
			globalMap.put("tFileInputExcel_2_NB_LINE",nb_line_tFileInputExcel_2);
			
				}
			
		} finally { 
				
  				if(!(source_tFileInputExcel_2 instanceof java.io.InputStream)){
  					workbook_tFileInputExcel_2.getPackage().revert();
  				}
				
		}	
		

 

ok_Hash.put("tFileInputExcel_2", true);
end_Hash.put("tFileInputExcel_2", System.currentTimeMillis());




/**
 * [tFileInputExcel_2 end ] stop
 */

	
	/**
	 * [tMap_1 end ] start
	 */

	

	
	
	currentComponent="tMap_1";

	


// ###############################
// # Lookup hashes releasing
					if(tHash_Lookup_row2 != null) {
						tHash_Lookup_row2.endGet();
					}
					globalMap.remove( "tHash_Lookup_row2" );

					
					
				
// ###############################      





				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row1");
			  	}
			  	
 

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




/**
 * [tMap_1 end ] stop
 */

	
	/**
	 * [tDBOutput_1 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



                try {
                		if (batchSizeCounter_tDBOutput_1 != 0) {
							int countSum_tDBOutput_1 = 0;
							
							for(int countEach_tDBOutput_1: pstmt_tDBOutput_1.executeBatch()) {
								countSum_tDBOutput_1 += (countEach_tDBOutput_1 == java.sql.Statement.EXECUTE_FAILED ? 0 : 1);
							}
							rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
							
	            	    	
	            	    		insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	            	    	
            	    	}

                }catch (java.sql.BatchUpdateException e){
                    globalMap.put(currentComponent+"_ERROR_MESSAGE",e.getMessage());
                	
                	int countSum_tDBOutput_1 = 0;
					for(int countEach_tDBOutput_1: e.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;
					
            	    insertedCount_tDBOutput_1 += countSum_tDBOutput_1;
	    	    	
                	System.err.println(e.getMessage());
                	
                }
                batchSizeCounter_tDBOutput_1 = 0;
    		
	

        if(pstmt_tDBOutput_1 != null) {
			
				pstmt_tDBOutput_1.close();
				resourceMap.remove("pstmt_tDBOutput_1");
			
        }
    resourceMap.put("statementClosed_tDBOutput_1", true);
    	if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
    		
    	}
    	conn_tDBOutput_1.commit();
    	if (commitCounter_tDBOutput_1 > 0 && rowsToCommitCount_tDBOutput_1 != 0) {
    		
			rowsToCommitCount_tDBOutput_1 = 0;
    	}
		commitCounter_tDBOutput_1 = 0;
    	
		
    	conn_tDBOutput_1 .close();
    	
    	resourceMap.put("finish_tDBOutput_1", true);
    	

	nb_line_deleted_tDBOutput_1=nb_line_deleted_tDBOutput_1+ deletedCount_tDBOutput_1;
	nb_line_update_tDBOutput_1=nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
	nb_line_inserted_tDBOutput_1=nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
	nb_line_rejected_tDBOutput_1=nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;
	
        globalMap.put("tDBOutput_1_NB_LINE",nb_line_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_UPDATED",nb_line_update_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_DELETED",nb_line_deleted_tDBOutput_1);
        globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"insert_vente_carburant");
			  	}
			  	
 

ok_Hash.put("tDBOutput_1", true);
end_Hash.put("tDBOutput_1", System.currentTimeMillis());




/**
 * [tDBOutput_1 end ] stop
 */




	
	/**
	 * [tDBOutput_2 end ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



	

        if(pstmt_tDBOutput_2 != null) {
			
				pstmt_tDBOutput_2.close();
				resourceMap.remove("pstmt_tDBOutput_2");
			
        }
    resourceMap.put("statementClosed_tDBOutput_2", true);
    	if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
    		
    	}
    	conn_tDBOutput_2.commit();
    	if (commitCounter_tDBOutput_2 > 0 && rowsToCommitCount_tDBOutput_2 != 0) {
    		
			rowsToCommitCount_tDBOutput_2 = 0;
    	}
		commitCounter_tDBOutput_2 = 0;
    	
		
    	conn_tDBOutput_2 .close();
    	
    	resourceMap.put("finish_tDBOutput_2", true);
    	

	nb_line_deleted_tDBOutput_2=nb_line_deleted_tDBOutput_2+ deletedCount_tDBOutput_2;
	nb_line_update_tDBOutput_2=nb_line_update_tDBOutput_2 + updatedCount_tDBOutput_2;
	nb_line_inserted_tDBOutput_2=nb_line_inserted_tDBOutput_2 + insertedCount_tDBOutput_2;
	nb_line_rejected_tDBOutput_2=nb_line_rejected_tDBOutput_2 + rejectedCount_tDBOutput_2;
	
        globalMap.put("tDBOutput_2_NB_LINE",nb_line_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_UPDATED",nb_line_update_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_INSERTED",nb_line_inserted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_DELETED",nb_line_deleted_tDBOutput_2);
        globalMap.put("tDBOutput_2_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_2);
    

	

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"update_duplicate");
			  	}
			  	
 

ok_Hash.put("tDBOutput_2", true);
end_Hash.put("tDBOutput_2", System.currentTimeMillis());




/**
 * [tDBOutput_2 end ] stop
 */






				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
					     			//free memory for "tMap_1"
					     			globalMap.remove("tHash_Lookup_row2"); 
				     			
				try{
					
	
	/**
	 * [tFileInputExcel_2 finally ] start
	 */

	

	
	
	currentComponent="tFileInputExcel_2";

	

 



/**
 * [tFileInputExcel_2 finally ] stop
 */

	
	/**
	 * [tMap_1 finally ] start
	 */

	

	
	
	currentComponent="tMap_1";

	

 



/**
 * [tMap_1 finally ] stop
 */

	
	/**
	 * [tDBOutput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_1";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
                if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_1")) != null) {
                    pstmtToClose_tDBOutput_1.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_1") == null){
            java.sql.Connection ctn_tDBOutput_1 = null;
            if((ctn_tDBOutput_1 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_1")) != null){
                try {
                    ctn_tDBOutput_1.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_1) {
                    String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :" + sqlEx_tDBOutput_1.getMessage();
                    System.err.println(errorMessage_tDBOutput_1);
                }
            }
        }
    }
 



/**
 * [tDBOutput_1 finally ] stop
 */




	
	/**
	 * [tDBOutput_2 finally ] start
	 */

	

	
	
	currentComponent="tDBOutput_2";

	



    try {
    if (resourceMap.get("statementClosed_tDBOutput_2") == null) {
                java.sql.PreparedStatement pstmtToClose_tDBOutput_2 = null;
                if ((pstmtToClose_tDBOutput_2 = (java.sql.PreparedStatement) resourceMap.remove("pstmt_tDBOutput_2")) != null) {
                    pstmtToClose_tDBOutput_2.close();
                }
    }
    } finally {
        if(resourceMap.get("finish_tDBOutput_2") == null){
            java.sql.Connection ctn_tDBOutput_2 = null;
            if((ctn_tDBOutput_2 = (java.sql.Connection)resourceMap.get("conn_tDBOutput_2")) != null){
                try {
                    ctn_tDBOutput_2.close();
                } catch (java.sql.SQLException sqlEx_tDBOutput_2) {
                    String errorMessage_tDBOutput_2 = "failed to close the connection in tDBOutput_2 :" + sqlEx_tDBOutput_2.getMessage();
                    System.err.println(errorMessage_tDBOutput_2);
                }
            }
        }
    }
 



/**
 * [tDBOutput_2 finally ] stop
 */






				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", 1);
	}
	


public static class row2Struct implements routines.system.IPersistableComparableLookupRow<row2Struct> {
    final static byte[] commonByteArrayLock_EURODATA_vente_carburant = new byte[0];
    static byte[] commonByteArray_EURODATA_vente_carburant = new byte[0];
	protected static final int DEFAULT_HASHCODE = 1;
    protected static final int PRIME = 31;
    protected int hashCode = DEFAULT_HASHCODE;
    public boolean hashCodeDirty = true;

    public String loopKey;



	
			    public String Site;

				public String getSite () {
					return this.Site;
				}
				
			    public java.util.Date Date;

				public java.util.Date getDate () {
					return this.Date;
				}
				
			    public String Carburant;

				public String getCarburant () {
					return this.Carburant;
				}
				
			    public int Pompe;

				public int getPompe () {
					return this.Pompe;
				}
				
			    public int Pistolet;

				public int getPistolet () {
					return this.Pistolet;
				}
				
			    public Float Index_de_debut;

				public Float getIndex_de_debut () {
					return this.Index_de_debut;
				}
				
			    public Float Index_de_fin;

				public Float getIndex_de_fin () {
					return this.Index_de_fin;
				}
				
			    public Float Tests_de_pompe;

				public Float getTests_de_pompe () {
					return this.Tests_de_pompe;
				}
				
			    public Float Quantite;

				public Float getQuantite () {
					return this.Quantite;
				}
				
			    public Float Prix_unitaire;

				public Float getPrix_unitaire () {
					return this.Prix_unitaire;
				}
				
			    public Float Montant;

				public Float getMontant () {
					return this.Montant;
				}
				
			    public Byte Index_de_debut_modifie;

				public Byte getIndex_de_debut_modifie () {
					return this.Index_de_debut_modifie;
				}
				
			    public java.util.Date last_update;

				public java.util.Date getLast_update () {
					return this.last_update;
				}
				
			    public java.util.Date inserted_date;

				public java.util.Date getInserted_date () {
					return this.inserted_date;
				}
				
			    public String date_str;

				public String getDate_str () {
					return this.date_str;
				}
				


	@Override
	public int hashCode() {
		if (this.hashCodeDirty) {
			final int prime = PRIME;
			int result = DEFAULT_HASHCODE;
	
						result = prime * result + ((this.Site == null) ? 0 : this.Site.hashCode());
					
						result = prime * result + ((this.Carburant == null) ? 0 : this.Carburant.hashCode());
					
							result = prime * result + (int) this.Pompe;
						
							result = prime * result + (int) this.Pistolet;
						
						result = prime * result + ((this.date_str == null) ? 0 : this.date_str.hashCode());
					
    		this.hashCode = result;
    		this.hashCodeDirty = false;
		}
		return this.hashCode;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final row2Struct other = (row2Struct) obj;
		
						if (this.Site == null) {
							if (other.Site != null)
								return false;
						
						} else if (!this.Site.equals(other.Site))
						
							return false;
					
						if (this.Carburant == null) {
							if (other.Carburant != null)
								return false;
						
						} else if (!this.Carburant.equals(other.Carburant))
						
							return false;
					
						if (this.Pompe != other.Pompe)
							return false;
					
						if (this.Pistolet != other.Pistolet)
							return false;
					
						if (this.date_str == null) {
							if (other.date_str != null)
								return false;
						
						} else if (!this.date_str.equals(other.date_str))
						
							return false;
					

		return true;
    }

	public void copyDataTo(row2Struct other) {

		other.Site = this.Site;
	            other.Date = this.Date;
	            other.Carburant = this.Carburant;
	            other.Pompe = this.Pompe;
	            other.Pistolet = this.Pistolet;
	            other.Index_de_debut = this.Index_de_debut;
	            other.Index_de_fin = this.Index_de_fin;
	            other.Tests_de_pompe = this.Tests_de_pompe;
	            other.Quantite = this.Quantite;
	            other.Prix_unitaire = this.Prix_unitaire;
	            other.Montant = this.Montant;
	            other.Index_de_debut_modifie = this.Index_de_debut_modifie;
	            other.last_update = this.last_update;
	            other.inserted_date = this.inserted_date;
	            other.date_str = this.date_str;
	            
	}

	public void copyKeysDataTo(row2Struct other) {

		other.Site = this.Site;
	            	other.Carburant = this.Carburant;
	            	other.Pompe = this.Pompe;
	            	other.Pistolet = this.Pistolet;
	            	other.date_str = this.date_str;
	            	
	}




	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_EURODATA_vente_carburant.length) {
				if(length < 1024 && commonByteArray_EURODATA_vente_carburant.length == 0) {
   					commonByteArray_EURODATA_vente_carburant = new byte[1024];
				} else {
   					commonByteArray_EURODATA_vente_carburant = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_EURODATA_vente_carburant, 0, length);
			strReturn = new String(commonByteArray_EURODATA_vente_carburant, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

	private java.util.Date readDate(DataInputStream dis, ObjectInputStream ois) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = dis.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(dis.readLong());
		}
		return dateReturn;
	}
	
	private java.util.Date readDate(DataInputStream dis, org.jboss.marshalling.Unmarshaller unmarshaller ) throws IOException{
		java.util.Date dateReturn = null;
		int length = 0;
        length = unmarshaller.readByte();
		if (length == -1) {
			dateReturn = null;
		} else {
	    	dateReturn = new Date(unmarshaller.readLong());
		}
		return dateReturn;
	}

	private void writeDate(java.util.Date date1, DataOutputStream dos, ObjectOutputStream oos) throws IOException{
		if(date1 == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeLong(date1.getTime());
    	}
	}
	
	private void writeDate(java.util.Date date1, DataOutputStream dos, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(date1 == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeLong(date1.getTime());
    	}
	}

    public void readKeysData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
					this.date_str = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readKeysData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_EURODATA_vente_carburant) {

        	try {

        		int length = 0;
		
					this.Site = readString(dis);
					
					this.Carburant = readString(dis);
					
			        this.Pompe = dis.readInt();
					
			        this.Pistolet = dis.readInt();
					
					this.date_str = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeKeysData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// String
				
						writeString(this.date_str,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeKeysData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.Site,dos);
					
					// String
				
						writeString(this.Carburant,dos);
					
					// int
				
		            	dos.writeInt(this.Pompe);
					
					// int
				
		            	dos.writeInt(this.Pistolet);
					
					// String
				
						writeString(this.date_str,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }



    /**
     * Fill Values data by reading ObjectInputStream.
     */
    public void readValuesData(DataInputStream dis, ObjectInputStream ois) {
        try {

			int length = 0;
		
						this.Date = readDate(dis,ois);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = dis.readFloat();
           				}
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = dis.readByte();
           				}
					
						this.last_update = readDate(dis,ois);
					
						this.inserted_date = readDate(dis,ois);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }
    
    public void readValuesData(DataInputStream dis, org.jboss.marshalling.Unmarshaller objectIn) {
        try {
			int length = 0;
		
						this.Date = readDate(dis,objectIn);
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut = null;
           				} else {
           			    	this.Index_de_debut = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Index_de_fin = null;
           				} else {
           			    	this.Index_de_fin = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Tests_de_pompe = null;
           				} else {
           			    	this.Tests_de_pompe = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Quantite = null;
           				} else {
           			    	this.Quantite = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Prix_unitaire = null;
           				} else {
           			    	this.Prix_unitaire = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Montant = null;
           				} else {
           			    	this.Montant = objectIn.readFloat();
           				}
					
			            length = objectIn.readByte();
           				if (length == -1) {
           	    			this.Index_de_debut_modifie = null;
           				} else {
           			    	this.Index_de_debut_modifie = objectIn.readByte();
           				}
					
						this.last_update = readDate(dis,objectIn);
					
						this.inserted_date = readDate(dis,objectIn);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

    }

    /**
     * Return a byte array which represents Values data.
     */
    public void writeValuesData(DataOutputStream dos, ObjectOutputStream oos) {
        try {

		
						writeDate(this.Date, dos, oos);
					
						if(this.Index_de_debut == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_debut);
		            	}
					
						if(this.Index_de_fin == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Index_de_fin);
		            	}
					
						if(this.Tests_de_pompe == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Tests_de_pompe);
		            	}
					
						if(this.Quantite == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Quantite);
		            	}
					
						if(this.Prix_unitaire == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Prix_unitaire);
		            	}
					
						if(this.Montant == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeFloat(this.Montant);
		            	}
					
						if(this.Index_de_debut_modifie == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeByte(this.Index_de_debut_modifie);
		            	}
					
						writeDate(this.last_update, dos, oos);
					
						writeDate(this.inserted_date, dos, oos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}

    }
    
    public void writeValuesData(DataOutputStream dos, org.jboss.marshalling.Marshaller objectOut){
                try {

		
						writeDate(this.Date, dos, objectOut);
					
						if(this.Index_de_debut == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Index_de_debut);
		            	}
					
						if(this.Index_de_fin == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Index_de_fin);
		            	}
					
						if(this.Tests_de_pompe == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Tests_de_pompe);
		            	}
					
						if(this.Quantite == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Quantite);
		            	}
					
						if(this.Prix_unitaire == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Prix_unitaire);
		            	}
					
						if(this.Montant == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeFloat(this.Montant);
		            	}
					
						if(this.Index_de_debut_modifie == null) {
							objectOut.writeByte(-1);
						} else {
							objectOut.writeByte(0);
							objectOut.writeByte(this.Index_de_debut_modifie);
		            	}
					
						writeDate(this.last_update, dos, objectOut);
					
						writeDate(this.inserted_date, dos, objectOut);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        	}
    }


    
    public boolean supportMarshaller(){
        return true;
    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Site="+Site);
		sb.append(",Date="+String.valueOf(Date));
		sb.append(",Carburant="+Carburant);
		sb.append(",Pompe="+String.valueOf(Pompe));
		sb.append(",Pistolet="+String.valueOf(Pistolet));
		sb.append(",Index_de_debut="+String.valueOf(Index_de_debut));
		sb.append(",Index_de_fin="+String.valueOf(Index_de_fin));
		sb.append(",Tests_de_pompe="+String.valueOf(Tests_de_pompe));
		sb.append(",Quantite="+String.valueOf(Quantite));
		sb.append(",Prix_unitaire="+String.valueOf(Prix_unitaire));
		sb.append(",Montant="+String.valueOf(Montant));
		sb.append(",Index_de_debut_modifie="+String.valueOf(Index_de_debut_modifie));
		sb.append(",last_update="+String.valueOf(last_update));
		sb.append(",inserted_date="+String.valueOf(inserted_date));
		sb.append(",date_str="+date_str);
	    sb.append("]");

	    return sb.toString();
    }

    /**
     * Compare keys
     */
    public int compareTo(row2Struct other) {

		int returnValue = -1;
		
						returnValue = checkNullsAndCompare(this.Site, other.Site);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Carburant, other.Carburant);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pompe, other.Pompe);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.Pistolet, other.Pistolet);
						if(returnValue != 0) {
							return returnValue;
						}

					
						returnValue = checkNullsAndCompare(this.date_str, other.date_str);
						if(returnValue != 0) {
							return returnValue;
						}

					
	    return returnValue;
    }


    private int checkNullsAndCompare(Object object1, Object object2) {
        int returnValue = 0;
		if (object1 instanceof Comparable && object2 instanceof Comparable) {
            returnValue = ((Comparable) object1).compareTo(object2);
        } else if (object1 != null && object2 != null) {
            returnValue = compareStrings(object1.toString(), object2.toString());
        } else if (object1 == null && object2 != null) {
            returnValue = 1;
        } else if (object1 != null && object2 == null) {
            returnValue = -1;
        } else {
            returnValue = 0;
        }

        return returnValue;
    }

    private int compareStrings(String string1, String string2) {
        return string1.compareTo(string2);
    }


}
public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

 final boolean execStat = this.execStat;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		row2Struct row2 = new row2Struct();




	
	/**
	 * [tAdvancedHash_row2 begin ] start
	 */

	

	
		
		ok_Hash.put("tAdvancedHash_row2", false);
		start_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());
		
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat) {
						runStat.updateStatOnConnection(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tAdvancedHash_row2 = 0;
		

			   		// connection name:row2
			   		// source node:tDBInput_1 - inputs:(after_tFileInputExcel_2) outputs:(row2,row2) | target node:tAdvancedHash_row2 - inputs:(row2) outputs:()
			   		// linked node: tMap_1 - inputs:(row1,row2) outputs:(insert_vente_carburant,update_duplicate)
			   
			   		org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE matchingModeEnum_row2 = 
			   			org.talend.designer.components.lookup.common.ICommonLookup.MATCHING_MODE.UNIQUE_MATCH;
			   			
			   
	   			org.talend.designer.components.lookup.memory.AdvancedMemoryLookup<row2Struct> tHash_Lookup_row2 =org.talend.designer.components.lookup.memory.AdvancedMemoryLookup.
	   						<row2Struct>getLookup(matchingModeEnum_row2);
	   						   
		   	   	   globalMap.put("tHash_Lookup_row2", tHash_Lookup_row2);
		   	   	   
				
           

 



/**
 * [tAdvancedHash_row2 begin ] stop
 */



	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		ok_Hash.put("tDBInput_1", false);
		start_Hash.put("tDBInput_1", System.currentTimeMillis());
		
	
	currentComponent="tDBInput_1";

	
		int tos_count_tDBInput_1 = 0;
		
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "root";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:o9HsYZzbIjAHgNOMhDsOmtGYWt8LrUNDLe2nRub9mwbS0OLY98E=");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = "serverTimezone=UTC";
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "eurodata" + "?" + properties_tDBInput_1;
				
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();
				if(stmt_tDBInput_1 instanceof com.mysql.cj.jdbc.StatementImpl){
				    ((com.mysql.cj.jdbc.StatementImpl)stmt_tDBInput_1).enableStreamingResults();
				}else if(stmt_tDBInput_1 instanceof com.mysql.cj.jdbc.StatementWrapper){
				    ((com.mysql.cj.jdbc.StatementWrapper)stmt_tDBInput_1).enableStreamingResults();
				}

		    String dbquery_tDBInput_1 = "SELECT \n  `vente_carburant`.`Site`, \n  `vente_carburant`.`Date`, \n  `vente_carburant`.`Carburant`, \n  `vente_carburant`"
+".`Pompe`, \n  `vente_carburant`.`Pistolet`, \n  `vente_carburant`.`Index_de_debut`, \n  `vente_carburant`.`Index_de_fin`, \n"
+"  `vente_carburant`.`Tests de pompe`, \n  `vente_carburant`.`Quantite`, \n  `vente_carburant`.`Prix_unitaire`, \n  `vente_c"
+"arburant`.`Montant`, \n  `vente_carburant`.`Index_de_debut_modifie`, \n  `vente_carburant`.`last_update`, \n  `vente_carbur"
+"ant`.`inserted_date`, \n  `vente_carburant`.`date_str`\nFROM `vente_carburant`";
		    

            	globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);
		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row2.Site = null;
							} else {
	                         		
        	row2.Site = routines.system.JDBCUtil.getString(rs_tDBInput_1, 1, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row2.Date = null;
							} else {
										
				if(rs_tDBInput_1.getString(2) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(2);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row2.Date = rs_tDBInput_1.getTimestamp(2);
					} else {
						row2.Date = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row2.Date =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row2.Carburant = null;
							} else {
	                         		
        	row2.Carburant = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row2.Pompe = 0;
							} else {
		                          
            row2.Pompe = rs_tDBInput_1.getInt(4);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row2.Pistolet = 0;
							} else {
		                          
            row2.Pistolet = rs_tDBInput_1.getInt(5);
            if(rs_tDBInput_1.wasNull()){
                    throw new RuntimeException("Null value in non-Nullable column");
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row2.Index_de_debut = null;
							} else {
		                          
            row2.Index_de_debut = rs_tDBInput_1.getFloat(6);
            if(rs_tDBInput_1.wasNull()){
                    row2.Index_de_debut = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row2.Index_de_fin = null;
							} else {
		                          
            row2.Index_de_fin = rs_tDBInput_1.getFloat(7);
            if(rs_tDBInput_1.wasNull()){
                    row2.Index_de_fin = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row2.Tests_de_pompe = null;
							} else {
		                          
            row2.Tests_de_pompe = rs_tDBInput_1.getFloat(8);
            if(rs_tDBInput_1.wasNull()){
                    row2.Tests_de_pompe = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row2.Quantite = null;
							} else {
		                          
            row2.Quantite = rs_tDBInput_1.getFloat(9);
            if(rs_tDBInput_1.wasNull()){
                    row2.Quantite = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row2.Prix_unitaire = null;
							} else {
		                          
            row2.Prix_unitaire = rs_tDBInput_1.getFloat(10);
            if(rs_tDBInput_1.wasNull()){
                    row2.Prix_unitaire = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 11) {
								row2.Montant = null;
							} else {
		                          
            row2.Montant = rs_tDBInput_1.getFloat(11);
            if(rs_tDBInput_1.wasNull()){
                    row2.Montant = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 12) {
								row2.Index_de_debut_modifie = null;
							} else {
		                          
            row2.Index_de_debut_modifie = rs_tDBInput_1.getByte(12);
            if(rs_tDBInput_1.wasNull()){
                    row2.Index_de_debut_modifie = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 13) {
								row2.last_update = null;
							} else {
										
				if(rs_tDBInput_1.getString(13) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(13);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row2.last_update = rs_tDBInput_1.getTimestamp(13);
					} else {
						row2.last_update = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row2.last_update =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_1 < 14) {
								row2.inserted_date = null;
							} else {
										
				if(rs_tDBInput_1.getString(14) != null) {
					String dateString_tDBInput_1 = rs_tDBInput_1.getString(14);
					if (!("0000-00-00").equals(dateString_tDBInput_1) && !("0000-00-00 00:00:00").equals(dateString_tDBInput_1)) {
						row2.inserted_date = rs_tDBInput_1.getTimestamp(14);
					} else {
						row2.inserted_date = (java.util.Date) year0_tDBInput_1.clone();
					}
				} else {
					row2.inserted_date =  null;
				}
		                    }
							if(colQtyInRs_tDBInput_1 < 15) {
								row2.date_str = null;
							} else {
	                         		
        	row2.date_str = routines.system.JDBCUtil.getString(rs_tDBInput_1, 15, false);
		                    }
					

 



/**
 * [tDBInput_1 begin ] stop
 */
	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 


	tos_count_tDBInput_1++;

/**
 * [tDBInput_1 main ] stop
 */
	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_begin ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 main ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	
					if(execStat){
						runStat.updateStatOnConnection(iterateId,1,1
						
							,"row2"
						
						);
					}
					


			   
			   

					row2Struct row2_HashRow = new row2Struct();
		   	   	   
				
				row2_HashRow.Site = row2.Site;
				
				row2_HashRow.Date = row2.Date;
				
				row2_HashRow.Carburant = row2.Carburant;
				
				row2_HashRow.Pompe = row2.Pompe;
				
				row2_HashRow.Pistolet = row2.Pistolet;
				
				row2_HashRow.Index_de_debut = row2.Index_de_debut;
				
				row2_HashRow.Index_de_fin = row2.Index_de_fin;
				
				row2_HashRow.Tests_de_pompe = row2.Tests_de_pompe;
				
				row2_HashRow.Quantite = row2.Quantite;
				
				row2_HashRow.Prix_unitaire = row2.Prix_unitaire;
				
				row2_HashRow.Montant = row2.Montant;
				
				row2_HashRow.Index_de_debut_modifie = row2.Index_de_debut_modifie;
				
				row2_HashRow.last_update = row2.last_update;
				
				row2_HashRow.inserted_date = row2.inserted_date;
				
				row2_HashRow.date_str = row2.date_str;
				
			tHash_Lookup_row2.put(row2_HashRow);
			
            




 


	tos_count_tAdvancedHash_row2++;

/**
 * [tAdvancedHash_row2 main ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_begin ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_begin ] stop
 */
	
	/**
	 * [tAdvancedHash_row2 process_data_end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 process_data_end ] stop
 */



	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 process_data_end ] stop
 */
	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
		}
		
}

		   globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
		


 

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




/**
 * [tDBInput_1 end ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 end ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

tHash_Lookup_row2.endPut();

				if(execStat){
			  		runStat.updateStat(resourceMap,iterateId,2,0,"row2");
			  	}
			  	
 

ok_Hash.put("tAdvancedHash_row2", true);
end_Hash.put("tAdvancedHash_row2", System.currentTimeMillis());




/**
 * [tAdvancedHash_row2 end ] stop
 */



				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				TalendException te = new TalendException(e, currentComponent, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
					runStat.stopThreadStat();
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	currentComponent="tDBInput_1";

	

 



/**
 * [tDBInput_1 finally ] stop
 */

	
	/**
	 * [tAdvancedHash_row2 finally ] start
	 */

	

	
	
	currentComponent="tAdvancedHash_row2";

	

 



/**
 * [tAdvancedHash_row2 finally ] stop
 */



				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}
	
    public String resuming_logs_dir_path = null;
    public String resuming_checkpoint_path = null;
    public String parent_part_launcher = null;
    private String resumeEntryMethodName = null;
    private boolean globalResumeTicket = false;

    public boolean watch = false;
    // portStats is null, it means don't execute the statistics
    public Integer portStats = null;
    public int portTraces = 4334;
    public String clientHost;
    public String defaultClientHost = "localhost";
    public String contextStr = "Default";
    public boolean isDefaultContext = true;
    public String pid = "0";
    public String rootPid = null;
    public String fatherPid = null;
    public String fatherNode = null;
    public long startTime = 0;
    public boolean isChildJob = false;
    public String log4jLevel = "";
    
    private boolean enableLogStash;

    private boolean execStat = true;

    private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
        protected java.util.Map<String, String> initialValue() {
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    

    public static void main(String[] args){
        final vente_carburant vente_carburantClass = new vente_carburant();

        int exitCode = vente_carburantClass.runJobInTOS(args);

        System.exit(exitCode);
    }


    public String[][] runJob(String[] args) {

        int exitCode = runJobInTOS(args);
        String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

        return bufferValue;
    }

    public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;
    	
        return hastBufferOutput;
    }

    public int runJobInTOS(String[] args) {
	   	// reset status
	   	status = "";
	   	
        String lastStr = "";
        for (String arg : args) {
            if (arg.equalsIgnoreCase("--context_param")) {
                lastStr = arg;
            } else if (lastStr.equals("")) {
                evalParam(arg);
            } else {
                evalParam(lastStr + " " + arg);
                lastStr = "";
            }
        }
        enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

    	
    	

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

        if (rootPid==null) {
            rootPid = pid;
        }
        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }

        if (portStats != null) {
            // portStats = -1; //for testing
            if (portStats < 0 || portStats > 65535) {
                // issue:10869, the portStats is invalid, so this client socket can't open
                System.err.println("The statistics socket port " + portStats + " is invalid.");
                execStat = false;
            }
        } else {
            execStat = false;
        }
        boolean inOSGi = routines.system.BundleUtils.inOSGi();

        if (inOSGi) {
            java.util.Dictionary<String, Object> jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

            if (jobProperties != null && jobProperties.get("context") != null) {
                contextStr = (String)jobProperties.get("context");
            }
        }

        try {
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = vente_carburant.class.getClassLoader().getResourceAsStream("eurodata/vente_carburant_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = vente_carburant.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
	                defaultProps.load(inContext);
	                context = new ContextProperties(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }

            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,parametersToEncrypt));

if(execStat) {
    try {
        runStat.openSocket(!isChildJob);
        runStat.setAllPID(rootPid, fatherPid, pid, jobName);
        runStat.startThreadStat(clientHost, portStats);
        runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
    } catch (java.io.IOException ioException) {
        ioException.printStackTrace();
    }
}



	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob

try {
errorCode = null;tPrejob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPrejob_1) {
globalMap.put("tPrejob_1_SUBPROCESS_STATE", -1);

e_tPrejob_1.printStackTrace();

}




this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tFileInputExcel_2Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tFileInputExcel_2) {
globalMap.put("tFileInputExcel_2_SUBPROCESS_STATE", -1);

e_tFileInputExcel_2.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob

try {
errorCode = null;tPostjob_1Process(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tPostjob_1) {
globalMap.put("tPostjob_1_SUBPROCESS_STATE", -1);

e_tPostjob_1.printStackTrace();

}



        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : vente_carburant");
        }



if (execStat) {
    runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
    runStat.stopThreadStat();
}
    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");

    return returnCode;

  }

    // only for OSGi env
    public void destroy() {
    closeSqlDbConnections();


    }



    private void closeSqlDbConnections() {
        try {
            Object obj_conn;
            obj_conn = globalMap.remove("conn_tDBConnection_1");
            if (null != obj_conn) {
                ((java.sql.Connection) obj_conn).close();
            }
        } catch (java.lang.Exception e) {
        }
    }











    private java.util.Map<String, Object> getSharedConnections4REST() {
        java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();
            connections.put("conn_tDBConnection_1", globalMap.get("conn_tDBConnection_1"));






        return connections;
    }

    private void evalParam(String arg) {
        if (arg.startsWith("--resuming_logs_dir_path")) {
            resuming_logs_dir_path = arg.substring(25);
        } else if (arg.startsWith("--resuming_checkpoint_path")) {
            resuming_checkpoint_path = arg.substring(27);
        } else if (arg.startsWith("--parent_part_launcher")) {
            parent_part_launcher = arg.substring(23);
        } else if (arg.startsWith("--watch")) {
            watch = true;
        } else if (arg.startsWith("--stat_port=")) {
            String portStatsStr = arg.substring(12);
            if (portStatsStr != null && !portStatsStr.equals("null")) {
                portStats = Integer.parseInt(portStatsStr);
            }
        } else if (arg.startsWith("--trace_port=")) {
            portTraces = Integer.parseInt(arg.substring(13));
        } else if (arg.startsWith("--client_host=")) {
            clientHost = arg.substring(14);
        } else if (arg.startsWith("--context=")) {
            contextStr = arg.substring(10);
            isDefaultContext = false;
        } else if (arg.startsWith("--father_pid=")) {
            fatherPid = arg.substring(13);
        } else if (arg.startsWith("--root_pid=")) {
            rootPid = arg.substring(11);
        } else if (arg.startsWith("--father_node=")) {
            fatherNode = arg.substring(14);
        } else if (arg.startsWith("--pid=")) {
            pid = arg.substring(6);
        } else if (arg.startsWith("--context_type")) {
            String keyValue = arg.substring(15);
			int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }
            }
        } else if (arg.startsWith("--log4jLevel=")) {
            log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
    }

    public Integer getErrorCode() {
        return errorCode;
    }


    public String getStatus() {
        return status;
    }

    ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 *     223979 characters generated by Talend Open Studio for Data Integration 
 *     on the 12 octobre 2023 à 15:32:22 EAT
 ************************************************************************************************/