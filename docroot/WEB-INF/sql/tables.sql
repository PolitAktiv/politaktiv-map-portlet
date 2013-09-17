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

create table politaktivmap_DbMapObject (
	mapObjectId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	referenceUrl VARCHAR(75) null,
	occupancy LONG,
	mapId LONG,
	type_ VARCHAR(75) null,
	graphicObjectId LONG
);

create table politaktivmap_DbMarker (
	markerId LONG not null primary key,
	markerImageName VARCHAR(75) null,
	pointId LONG
);

create table politaktivmap_DbPicture (
	pictureId LONG not null primary key,
	rotation LONG,
	width LONG,
	height LONG,
	resolution DOUBLE,
	pointId LONG
);

create table politaktivmap_DbPoint (
	pointId LONG not null primary key,
	longitude DOUBLE,
	latitude DOUBLE
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