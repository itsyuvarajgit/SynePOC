Repository Init Content
=======================

To demonstrate use of case management.

Assume trade exception data is in a db table.
1. Trigger case via REST calls ( Use postman to invoke a POST request to url similar to http://localhost:8080/kie-server/services/rest/server/containers/db-case_1.0.0-SNAPSHOT/cases/db-case/instances ) This will create new case instance and execute flow.
2. Check in case management tab of business central if the flow has been triggered.
3. DB component to poll records which are in PENDING state and segregate records as per error type.
4. Each error type will trigger respective milestone which in turn simply lists the records picked up.


Using sqlite db. File is at location - src/test/resources/sql/exceptions.db
Download sqlite client from https://sqlitebrowser.org/dl/ to interact with exceptions.db outside the jbpm project.
SQL files at src/test/resources/sql/TRADE_EXCEPTION_SQL.txt
