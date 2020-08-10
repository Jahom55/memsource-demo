# Memsource project

The project is divided into two parts. 
- The first part is about working with persistence layer for user's setup. (/user-setup)
- The second part is about working with REST api for list of your projects.  (/project.html)

### How to run
First of all, set your username and password to environment variable (ENV section).
Next run `mvn clean compile -U` for creating Q classes.
Finally run project.

### ENV
|Parameter|Value|Description
| :------------- | :-------|:-----------|
|`MEMSOURCE_LOGIN_USERNAME`|`username`| Username for login to Memsource
|`MEMSOURCE_LOGIN_PASSWORD`|`password`| Password for login to Memsource