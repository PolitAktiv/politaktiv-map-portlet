Liferay.Service.register("Liferay.Service.politaktivmap", "org.politaktiv.map.infrastructure.service", "politaktiv-map-portlet");

Liferay.Service.registerClass(
	Liferay.Service.politaktivmap, "DbMapObject",
	{
		getAllDbMapObjectsFromCompanyIdAndGroupId: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.politaktivmap, "DbMarker",
	{
		addDbMarker: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.politaktivmap, "DbPicture",
	{
		addDbPicture: true
	}
);