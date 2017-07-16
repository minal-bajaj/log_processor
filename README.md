# log_processor
This log processor reads log files from logs directory and allows user to view recent changes in log file.

This solution provides two APIs to user. First API provides list of log files available whereas other one is web socket which allows user to get real-time updates on any log file.

1. GET /log_processor/rest/logs/
This API returns list of log file names available in system.

2. WS /log_processor/logs/tailf/
This API returns updates on mentioned log file. First message from client should be log file-name.

These APIs list all the log files available in logs directory. Logs directory is configurable and can be configured in app.path.properties file.
