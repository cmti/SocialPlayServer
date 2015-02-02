drop keyspace newrcs-db;

create keyspace newrcs-db WITH replication = {'class':'SimpleStrategy', 'replication_factor':1};

use newrcs-db;

create table account ( identityStr varchar, identityType int, accountId long, primary key (identityStr, identityType, accountId) );
create talbe group ( groupId long, accountId bigint, primary key ( groupId, accountId) );
create table groupFeed ( groupId bigint, senderId bigint, timestamp timestamp, sequenceNumber int, msgBody varchar, thumbnail blob, feedType int, fileName varchar, primary key ( groupId, senderId, sequenceNumber) ) WITH COMPACT STORAGE;
create table cloudAccess ( accountId bigint, cloudType int, accessToken varchar, primary key ( accountId ) ) WITH COMPACT STORAGE;
create table activationRecord ( accountId bigint, verificationCode bigint, regType int, activated boolean, primary key (accountId) ) WITH COMPACT STORAGE;
