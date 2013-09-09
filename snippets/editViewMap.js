var editViewMap, globalnamespace;

function editViewMapInit(namespace) {

	globalnamespace = namespace;

	document.getElementById(namespace + "lon_center").value = pref_saved_lon_center;
	document.getElementById(namespace + "lat_center").value = pref_saved_lat_center;
	document.getElementById(namespace + "zoom_center").value = pref_saved_zoom_center;

	// die edit map main object
	editViewMap = new OpenLayers.Map("editViewMap", {
		controls : [ new OpenLayers.Control.Navigation(),
				new OpenLayers.Control.PanZoomBar(),
				new OpenLayers.Control.LayerSwitcher(), // TODO: remove
				new OpenLayers.Control.Attribution() ],
		maxExtent : new OpenLayers.Bounds(-20037508.34, -20037508.34,
				20037508.34, 20037508.34),
		maxResolution : 156543.0399,
		numZoomLevels : 19,
		units : 'm'
	});

	// openstreetmap as default layer
	osmLayer = new OpenLayers.Layer.OSM();
	editViewMap.addLayer(osmLayer);
	
	setEditBackground(backgroundIdToUuidMap[background_id]);

	// zentriert die Karte auf das K28
	editViewMap.setCenter(new OpenLayers.LonLat(pref_saved_lon_center,pref_saved_lat_center) // Center of the map
	, pref_saved_zoom_center // Zoom level
	);

	// set form input after moving the map in any way
	editViewMap.events.register("moveend", null, function(e) {
		var lon_lat = editViewMap.getCenter();
		document.getElementById(namespace + "lon_center").value = lon_lat.lon;
		document.getElementById(namespace + "lat_center").value = lon_lat.lat;
		document.getElementById(namespace + "zoom_center").value = editViewMap
				.getZoom();
	});

}

function setEditBackground(pictureFileUuid) {
	
	edit_removeLayers();

	if (pictureFileUuid == "map") {

		osmLayer = new OpenLayers.Layer.OSM();
		editViewMap.addLayer(osmLayer);
		editViewMap.zoomToMaxExtent();

	} else {

		url = pictureFileUuidToUrl(pictureFileUuid);
		// set new background with image from url
		var backgroundImageLayer = new OpenLayers.Layer.Image(
				url, 
				url,
				new OpenLayers.Bounds(-680, -635, 680, 635),
				new OpenLayers.Size(232, 212), {
					numZoomLevels : 15
				});
		editViewMap.addLayer(backgroundImageLayer);
		editViewMap.zoomToMaxExtent();
	}
}

function edit_removeLayers() {
	
	if(editViewMap != null){
		for ( var i = editViewMap.layers.length - 1; i >= 0; i--) {
			editViewMap.removeLayer(editViewMap.layers[i]);
		}
	}
}
