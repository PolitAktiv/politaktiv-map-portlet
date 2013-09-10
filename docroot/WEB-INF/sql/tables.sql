create table politaktivmap_Background (
	backgroundId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	fileEntryUuid VARCHAR(75) null
);

create table politaktivmap_DbMap (
	mapId LONG not null primary key,
	name VARCHAR(75) null,
	type_ VARCHAR(75) null,
	fileEntryId LONG
);

create table politaktivmap_Marker (
	markerId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	referenceUrl VARCHAR(75) null,
	backgroundId LONG,
	longitude DOUBLE,
	latitude DOUBLE
);

create table politaktivmap_Picture (
	pictureId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	referenceUrl VARCHAR(75) null,
	backgroundId LONG,
	rotation LONG,
	width DOUBLE,
	height DOUBLE,
	resolution DOUBLE,
	ocupacy DOUBLE,
	longitude DOUBLE,
	latitude DOUBLE,
	fileEntryUuid VARCHAR(75) null
);