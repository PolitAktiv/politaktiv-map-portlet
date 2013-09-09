create table politaktivmap_MapObject (
	mapObjectId LONG not null primary key,
	companyId LONG,
	groupId LONG,
	userId LONG,
	name VARCHAR(75) null,
	description VARCHAR(75) null,
	referenceUrl VARCHAR(75) null,
	type_ VARCHAR(75) null,
	occupancy LONG,
	mapId LONG,
	graphicObjectId LONG
);

create table politaktivmap_Marker (
	markerId LONG not null primary key,
	markerImageName VARCHAR(75) null,
	pointId LONG
);

create table politaktivmap_Picture (
	pictureId LONG not null primary key,
	rotation LONG,
	width LONG,
	height LONG,
	resolution DOUBLE,
	pointId LONG
);

create table politaktivmap_Point (
	pointId LONG not null primary key,
	longitude DOUBLE,
	latitude DOUBLE
);