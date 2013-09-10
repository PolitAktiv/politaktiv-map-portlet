var map, layer, namespace, viewmode, toDeleteMarkerId= 0;

function viewSpezifiedInits(){
	if (permission_to_add_marker) {
		setButton("button_fix_marker", "disable", namespace);
	}
	if (permission_to_delete_marker) {
		setButton("button_delete_marker", "disable", namespace);
	}
}

function viewSpezifiedPostInit(){
	setButton("fixPicture", "disable", namespace);
	   thePictureFileUuid = firstFolderFileUuid;
	//layer for adding new picture
	   theOpacity = 1;
	   //set values from first picture as default
	   theGraphicUrl = "";
	   XPos          = pref_saved_lon_center;
	   YPos          = pref_saved_lat_center;
	   var img = new Image();
	   img.src = theGraphicUrl;
	   theWidth      = map.getExtent().getWidth()/6;
	   theHeight     = map.getExtent().getHeight()/6;
	   theXOffset    = 0;
	   theYOffset    = -200;
	   theRotation   = 0;
	   theResolution = 2.5;
	   
	   
	   var context = {
		        getUrl : function(){
		            return theGraphicUrl;
		        },
		        getXO : function(){
		            return theXOffset * theResolution / map.getResolution();
		        },
		        getYO : function(){
		            return theYOffset * theResolution / map.getResolution();
		        },
		        getW : function(){
		            return theWidth * theResolution / map.getResolution();
		        },
		        getH : function(){
		            return theHeight * theResolution / map.getResolution();
		        },
		        getR : function(){
		            return theRotation;
		        }
		    };
	   
	   var template = {
		        externalGraphic: "${getUrl}",
		        graphicXOffset : "${getXO}",
		        graphicYOffset : "${getYO}",
		        graphicWidth   : "${getW}",
		        graphicHeight  : "${getH}",
		        rotation       : "${getR}",
		        strokeWidth    :  2,
		        strokeColor    : 'blue',
		        pointRadius    : 0
		    };
	   
	   var pictureVectorLayerStyleMap = new OpenLayers.Style(template, {context: context});

	   pictureAddVectorLayer = new OpenLayers.Layer.Vector("pictureAdd layer");
	   pictureAddVectorLayer.styleMap = pictureVectorLayerStyleMap;
	   
	   map.addLayer(pictureAddVectorLayer);
	   var newPoint = new OpenLayers.Geometry.Point(pref_saved_lon_center, pref_saved_lat_center);
	   var pointFeature = new OpenLayers.Feature.Vector(newPoint);                             //,null,style_blue);
	   pointFeature.attributes.render = "drawAlways";
	   pictureAddVectorLayer.addFeatures([pointFeature]);
	   pictureAddVectorLayer.setOpacity(theOpacity);
	   pictureAddVectorLayer.setVisibility(false);
	   
	   ctrlDragFeature = new OpenLayers.Control.DragFeature(pictureAddVectorLayer);
	   map.addControl(ctrlDragFeature);
	   ctrlDragFeature.activate();
	   
		// markers layer just for adding a new marker
		addMarkersView = new OpenLayers.Layer.Markers("addMarkersView");
		addMarkersView.id = "addMarkersView";
		map.addLayer(addMarkersView);
		addMarkersView.setZIndex(1005);
		addMarkersView.setVisibility(false);

		// markers from database
		databaseMarkers = new OpenLayers.Layer.Markers("databaseMarkers");
		databaseMarkers.id = "databaseMarkers";
		map.addLayer(databaseMarkers);
		databaseMarkers.setZIndex(1001);
}

function initMap(_namespace, _viewmode) {
	namespace = _namespace;
	viewmode = _viewmode;
	
	if(viewmode=="view"){
		viewSpezifiedInits();
	}

	// der klickhandler
	OpenLayers.Control.Click = OpenLayers
			.Class(
					OpenLayers.Control,
					{
						defaultHandlerOptions : {
							'single' : true,
							'double' : false,
							'pixelTolerance' : 0,
							'stopSingle' : false,
							'stopDouble' : false
						},

						initialize : function(options) {
							this.handlerOptions = OpenLayers.Util.extend({},
									this.defaultHandlerOptions);
							OpenLayers.Control.prototype.initialize.apply(this,
									arguments);
							this.handler = new OpenLayers.Handler.Click(this, {
								'click' : this.trigger
							}, this.handlerOptions);
						},

						trigger : function(e) {

							if (!permission_to_add_marker) {
								return;
							}

							//map.getLayer("addMarkersView").display(true);


							var lon_lat = map.getLonLatFromViewPortPx(e.xy);
							marker_add_lon = lon_lat.lon;
							marker_add_lat = lon_lat.lat;
							var size = new OpenLayers.Size(60, 74);
							var offset = new OpenLayers.Pixel(0, -67);
							var icon = new OpenLayers.Icon(contentPath
									+ '/img/Map_Pin_by_Merlin2525_small.png',
									size, offset);
							var newMarker = new OpenLayers.Marker(
									new OpenLayers.LonLat(lon_lat.lon,
											lon_lat.lat), icon);
							addMarkersView.clearMarkers();
							addMarkersView.addMarker(newMarker);
						}

					});

	// THE MAP itself
	map = new OpenLayers.Map(viewmode+'Map', {
		controls : [ new OpenLayers.Control.Navigation(),
				new OpenLayers.Control.PanZoomBar(),
				new OpenLayers.Control.LayerSwitcher(),
				new OpenLayers.Control.Attribution() ],
		maxExtent : new OpenLayers.Bounds(-20037508.34, -20037508.34,
				20037508.34, 20037508.34),
		maxResolution : 156543.0399,
		numZoomLevels : 19,
		units : 'm'
	});
	// map.addControl(new
	// OpenLayers.Control.LayerSwitcher({'div':OpenLayers.Util.getElement('layerswitcher')}));

	setBackground(backgroundIdToPictureUrlMap[pref_background_id]);

	var click = new OpenLayers.Control.Click();
	map.addControl(click);
	click.activate();

	// zentriert die Karte
	map.setCenter(new OpenLayers.LonLat(pref_saved_lon_center,
			pref_saved_lat_center) // Center of the map
	, pref_saved_zoom_center // Zoom level
	);

	// prevent context menu (right click menu)
	map.div.oncontextmenu = function noContextMenu(e) {
		if (OpenLayers.Event.isRightClick(e)) {
			return false;
		};
	};
	
	if(viewmode=="view"){
		viewSpezifiedPostInit();
	}
	
}

function setInitAddMarker(){
	marker_add_lon = pref_saved_lon_center;
	marker_add_lat = pref_saved_lat_center;
	var size = new OpenLayers.Size(60, 74);
	var offset = new OpenLayers.Pixel(0, -67);
	var icon = new OpenLayers.Icon(contentPath
			+ '/img/Map_Pin_by_Merlin2525_small.png',
			size, offset);
	var newMarker = new OpenLayers.Marker(
			new OpenLayers.LonLat(pref_saved_lon_center,
					pref_saved_lat_center), icon);
	addMarkersView.clearMarkers();
	addMarkersView.addMarker(newMarker);
}

function pictureFileUuidToUrl(pictureFileUuid){
	   if(firstFolderFileUuid == 0)
		   return contentPath+ '/img/ProhibitionSign2.png';
	   
		   return portalUrl + "/c/document_library/get_file?uuid=" + pictureFileUuid+ "&groupId="+ groupId;
		   
	   
	
} 

function addPictureOverlay(name, pictureUrl, opacity, rotation,posLon, posLat, width, height,pictureId){
	
	var theResolution = 2.5;
	var theXOffset    = 0;
	var theYOffset    = -200;
	

	 var context = {
		        getUrl : function(){
		            return pictureUrl;
		        },
		        getXO : function(){
		            return theXOffset * theResolution / map.getResolution();
		        },
		        getYO : function(){
		            return theYOffset * theResolution / map.getResolution();
		        },
		        getW : function(){
		            return width * theResolution / map.getResolution();
		        },
		        getH : function(){
		            return height * theResolution / map.getResolution();
		        },
		        getR : function(){
		            return rotation;
		        }
		    };
	   
	   var template = {
		        externalGraphic: "${getUrl}",
		        graphicXOffset : "${getXO}",
		        graphicYOffset : "${getYO}",
		        graphicWidth   : "${getW}",
		        graphicHeight  : "${getH}",
		        rotation       : "${getR}",
		        strokeWidth    :  2,
		        strokeColor    : 'blue',
		        pointRadius    : 0
		    };
	   
    var vectorLayer = new OpenLayers.Layer.Vector(name, {
		 styleMap:new OpenLayers.StyleMap(
				 {'default':new OpenLayers.Style(template, {context: context})
		 })
	});
    
    vectorLayer.pictureId = pictureId;
	
	var feature = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(posLon, posLat));
	feature.attributes.render = "drawAlways";
	vectorLayer.addFeatures([feature]);
	vectorLayer.drawFeature(feature);
	map.addLayer(vectorLayer);
	vectorLayer.setOpacity(opacity);
	vectorLayer.redraw();
}



function setBackground(url) {
	
	removeLayers();
	
	if (url == "map") {
		osmLayer = new OpenLayers.Layer.OSM();
		map.addLayer(osmLayer);
		map.zoomToMaxExtent();
	} else {

		// set new background with image from url
		var fullUrl = portalUrl + url;
		var backgroundImageLayer = new OpenLayers.Layer.Image(fullUrl, fullUrl,
				new OpenLayers.Bounds(-680, -635, 680, 635),
				new OpenLayers.Size(232, 212), {
					numZoomLevels : 15
				});
		map.addLayer(backgroundImageLayer);
		map.zoomToMaxExtent();
	}
}

function removeLayers() {
	for ( var i = map.layers.length - 1; i >= 0; i--) {
		map.removeLayer(map.layers[i]);
	}
}

function setPicture(pictureFileUuid) {
	
	if(pictureFileUuid != "none"){
		setButton("fixPicture", "enable", namespace);
		thePictureFileUuid = pictureFileUuid;
		theGraphicUrl = pictureFileUuidToUrl(pictureFileUuid);
		pictureAddVectorLayer.redraw();
	} else {
		theGraphicUrl = "";
		setButton("fixPicture", "disable", namespace);
		pictureAddVectorLayer.redraw();
	}
}


function rotatePictureToRight(x) {
	theRotation = theRotation + x;
	pictureAddVectorLayer.redraw();
}

function rotatePictureToLeft(x) {
	theRotation = theRotation - x;
	pictureAddVectorLayer.redraw();
}

function increasePictureWith(x) {
	theWidth = theWidth + x*map.getExtent().getWidth()/1000;
	pictureAddVectorLayer.redraw();
}

function decreasePictureWith(x) {
	theWidth = theWidth - x*map.getExtent().getWidth()/1000;
	pictureAddVectorLayer.redraw();
}

function increasePictureHeight(x) {
	theHeight = theHeight + x*map.getExtent().getWidth()/1000;
	pictureAddVectorLayer.redraw();
}

function decreasePictureHeight(x) {
	theHeight = theHeight - x*map.getExtent().getWidth()/1000;
	pictureAddVectorLayer.redraw();
}

function increaseOpacity() {
	if (theOpacity < 1) {
		theOpacity = theOpacity + 0.1;
		pictureAddVectorLayer.setOpacity(theOpacity);
	} else {
		theOpacity = 1;
	} // just reset for value safety
}

function decreaseOpacity() {
	if (theOpacity > 0) {
		theOpacity = theOpacity - 0.1;
		pictureAddVectorLayer.setOpacity(theOpacity);
	} else {
		theOpacity = 0; // just reset for value safety
	}
}


function resetMarkerIcons() {
	if (databaseMarkers.markers == null)
		return;

	for ( var i = 0; i < databaseMarkers.markers.length; i++) {
		databaseMarkers.markers[i].setUrl(contentPath
				+ '/img/Map_Pin_by_Merlin2525_small_yellow.png');
	}
}

function resetMarkerPopups() {
	if (databaseMarkers.markers == null)
		return;

	for ( var i = 0; i < databaseMarkers.markers.length; i++) {
		if (!(databaseMarkers.markers[i].feature.popup == null)) {
			map.removePopup(databaseMarkers.markers[i].feature.popup);
			databaseMarkers.markers[i].feature.popup = null;
		}
	}
}

function setButton(name, what, namespace) {

	AUI().use(function(A) {

		var button = A.one('#' + namespace + name);

		if (what == "enable") {
			button.set('disabled', false);
			button.ancestor('.aui-button').removeClass('aui-button-disabled');
		}

		if (what == "disable") {
			button.set('disabled', true);
			button.ancestor('.aui-button').addClass('aui-button-disabled');
		}
	});

}

function deleteMarkerWithId(markerId) {
	for ( var i = 0; i < databaseMarkers.markers.length; i++) {
		if (databaseMarkers.markers[i].markerId == markerId) {
			resetMarkerPopups();
			var remMarker = databaseMarkers.markers[i];
			databaseMarkers.removeMarker(remMarker);
			return;
		}
	}
}

function addMarkerToDatabaseLayer(markerId, lon, lat, username, isOwner,
		htmlFormattedInformation, namespace) {

	var lonLatMarker = new OpenLayers.LonLat(lon, lat);
	var feature = new OpenLayers.Feature(databaseMarkers, lonLatMarker);
	feature.closeBox = true;
	feature.popupClass = OpenLayers.Class(OpenLayers.Popup.FramedCloud, {
		minSize : new OpenLayers.Size(100, 100),
		autoSize : true
	});
	feature.data.popupContentHTML = htmlFormattedInformation;

	var icon = new OpenLayers.Icon(contentPath
			+ '/img/Map_Pin_by_Merlin2525_small_yellow.png',
			new OpenLayers.Size(40, 47), new OpenLayers.Pixel(0, -40));
	var marker = new OpenLayers.Marker(lonLatMarker, icon);
	marker.feature = feature;
	marker.markerId = markerId;
	marker.isOwner = isOwner;

	var markerClickMarker = function(evt) {

		if (this.feature.popup == null) {
			resetMarkerPopups();
			this.feature.popup = this.feature
					.createPopup(this.feature.closeBox);
			map.addPopup(this.feature.popup, true);
			resetMarkerIcons();
			this.setUrl(contentPath
					+ '/img/Map_Pin_by_Merlin2525_small_blue.png');
			if (permission_to_delete_marker
					&& (this.isOwner || is_moderator_or_admin)) {
				toDeleteMarkerId = this.markerId;
				setButton("button_delete_marker", "enable", namespace);
			}

		} else {

			this.feature.popup.hide();
			map.removePopup(this.feature.popup);
			resetMarkerIcons();
			resetMarkerPopups();
			if (permission_to_delete_marker) {
				setButton("button_delete_marker", "disable", namespace);
				toDeleteMarkerId = 0;
			}

		}
	};

	marker.events.register("mousedown", marker, markerClickMarker);

	databaseMarkers.addMarker(marker);
}
