Liferay.Service.register("Liferay.Service.politaktivmap", "org.politaktiv.map.infrastructure.service", "politaktiv-map-portlet");

Liferay.Service.registerClass(
	Liferay.Service.politaktivmap, "Background",
	{
		findBycompanyIdAndGroupId: true,
		addBackground: true,
		deleteBackground: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.politaktivmap, "Marker",
	{
		addMarker: true,
		findMarkerByBackgroundId: true,
		deleteMarker: true
	}
);

Liferay.Service.registerClass(
	Liferay.Service.politaktivmap, "Picture",
	{
		addPicture: true,
		findByBackgroundId: true,
		deletePicture: true
	}
);