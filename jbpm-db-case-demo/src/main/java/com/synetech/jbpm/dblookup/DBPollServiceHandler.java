package com.synetech.jbpm.dblookup;


import org.kie.api.runtime.process.WorkItem;
import org.kie.api.runtime.process.WorkItemHandler;
import org.kie.api.runtime.process.WorkItemManager;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBPollServiceHandler implements WorkItemHandler
{

    static final long serialVersionUID = 1L;

    public DBPollServiceHandler()
    {
    }

    public void executeWorkItem(WorkItem workItem, WorkItemManager manager)
    {
        Map<String, Object> results = new HashMap<String, Object>();

        String url = (String)workItem.getParameter("url");
        String query = (String)workItem.getParameter("query");
        Map<String, ArrayList<ErrorDetails>> errorDetails = (Map<String, ArrayList<ErrorDetails>> )workItem.getParameter("errorDetails");
        String errorType = (String)workItem.getParameter("errorType");
        
        System.out.println(url);
        //System.out.println(query);

        if(errorDetails!=null){
            ArrayList<ErrorDetails> errors = errorDetails.get(errorType);
            ArrayList<Integer> ids = new ArrayList<>();
            for(ErrorDetails d : errors) {
                ids.add(d.getId());
            }
            String inCondition = ids.toString().replace("[","(").replace("]",")");
            updateErrorDetails(url, query+" "+inCondition, errorType);
        } else {
            errorDetails = getErrorDetails(url, query);
            
            results.put("errorDetails", errorDetails);
            if(errorDetails.get("VALIDATION")!=null){
                results.put("validationErrorsExist", true);
            } 
            if(errorDetails.get("PROCESSING")!=null){
                results.put("processingErrorsExist", true);
            }
            if(errorDetails.get("RUNTIME")!=null){
                 results.put("runtimeErrorsExist", true);
            }
        }
        manager.completeWorkItem(workItem.getId(), results);
    }

    public void abortWorkItem(WorkItem workItem, WorkItemManager manager)
    {
        // Do nothing, notifications cannot be aborted
    }

    private Connection connect(String url)
    {
        Connection conn = null;
        try
        {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection(url);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public Map<String, ArrayList<ErrorDetails>> getErrorDetails(String url, String sql) {
        Map<String, ArrayList<ErrorDetails>> results = new HashMap<String, ArrayList<ErrorDetails>>();
        ArrayList<Integer> ids = new ArrayList<>();
        String updateSql = "UPDATE TRADE_EXCEPTIONS SET STATUS = 'INPROGRESS' WHERE ID IN ";
        try {
            Connection conn = this.connect(url);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // loop through the result set
            int count=0;
            while (rs.next()) {
                count++;
                ErrorDetails details = new ErrorDetails();
                details.setId(rs.getInt("ID"));
                details.setErrorType(rs.getString("ERROR_TYPE"));
                details.setErrorCode(rs.getString("ERROR_CODE"));
                details.setErrorDesc(rs.getString("ERROR_DESC"));
                details.setProcessingStatus(rs.getString("STATUS"));
                
                if (results.get(details.getErrorType()) == null) {
                    ArrayList<ErrorDetails> list = new ArrayList<>();
                    list.add(details);
                    results.put(details.getErrorType(), list);
                } else {
                    results.get(details.getErrorType()).add(details);
                }
               ids.add(details.getId());
            }
            
            if(ids.size() > 0){
                String formattedIds = ids.toString().replace("[","(").replace("]",")");
                Statement updStmt = conn.createStatement();
                updStmt.executeUpdate(updateSql + formattedIds);
            }
            System.out.println("\n\n\n\n");
            System.out.println("----------------------------------------------");
            System.out.println("Found "+count+" unprocessed records from db table.");
            System.out.println("Seggregating records as per error type");
            for(String errorType : results.keySet()){
                ArrayList<ErrorDetails> list = results.get(errorType);
                System.out.println("ErrorType: " +errorType+", Records count: "+list.size());
            }   
            System.out.println("----------------------------------------------");
            System.out.println("\n\n\n\n");    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return results;
    }
    
    public void updateErrorDetails(String url, String sql , String errorType) {
         try {
            System.out.println("\nupdate query :: "+sql);
            Connection conn = this.connect(url);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);

            System.out.println("\n\n\n\n");
            System.out.println("----------------------------------------------");
            System.out.println("Updated "+errorType+" records to COMPLETE");
            System.out.println("----------------------------------------------");
            System.out.println("\n\n\n\n");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
}