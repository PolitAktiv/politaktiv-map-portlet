
var map, layer;
//mode can be view, set, edit and remove
var mode = "view";

function init(namespace){
	
	if(permission_to_add_marker){
		setButton("button_add_marker", "disable", namespace);
	}
	if(permission_to_delete_marker){
		setButton("button_delete_marker","disable",namespace);
	}
	
	//der klickhandler
	OpenLayers.Control.Click = OpenLayers.Class(OpenLayers.Control, {                
        defaultHandlerOptions: {
            'single': true,
            'double': false,
            'pixelTolerance': 0,
            'stopSingle': false,
            'stopDouble': false
        },

        initialize: function(options) {
            this.handlerOptions = OpenLayers.Util.extend(
                {}, this.defaultHandlerOptions
            );
            OpenLayers.Control.prototype.initialize.apply(
                this, arguments
            ); 
            this.handler = new OpenLayers.Handler.Click(
                this, {
                    'click': this.trigger
                }, this.handlerOptions
            );
        }, 

        trigger: function(e) {
    			
        		if(!permission_to_add_marker){
        			return;
        		}
        		
        		map.getLayer("addMarkersView").display(true);
        		
        		//show new marker button  	
            	setButton("button_add_marker", "enable", namespace);
            	
            	var lon_lat = map.getLonLatFromViewPortPx(e.xy);
            	document.getElementById(namespace+"map_marker_lon").value = lon_lat.lon;
            	document.getElementById(namespace+"map_marker_lat").value = lon_lat.lat;
            	var size = new OpenLayers.Size(60,74);
            	var offset = new OpenLayers.Pixel(0,-67);
            	var icon = new OpenLayers.Icon(contentPath + '/img/Map_Pin_by_Merlin2525_small.png', size, offset);
            	var newMarker = new OpenLayers.Marker(new OpenLayers.LonLat(lon_lat.lon,lon_lat.lat),icon);
            	addMarkersView.clearMarkers();
            	addMarkersView.addMarker(newMarker);
        }
        	

    });
	
	//THE MAP itself
	map = new OpenLayers.Map ("map", {
		controls:[
			new OpenLayers.Control.Navigation(),
			new OpenLayers.Control.PanZoomBar(),
			new OpenLayers.Control.LayerSwitcher(),
			new OpenLayers.Control.Attribution()],
		maxExtent: new OpenLayers.Bounds(-20037508.34,-20037508.34,20037508.34,20037508.34),
		maxResolution: 156543.0399,
		numZoomLevels: 19,
		units: 'm'
	} );
	
	
	setViewBackground(pref_background_url);
	
	    
	var click = new OpenLayers.Control.Click();
    map.addControl(click);
    click.activate();
    
    //markers layer just for adding a new marker
    addMarkersView = new OpenLayers.Layer.Markers( "addMarkersView" );
    addMarkersView.id = "addMarkersView";
    map.addLayer(addMarkersView);
    
    //markers from database
    databaseMarkers = new OpenLayers.Layer.Markers( "databaseMarkers" );
    databaseMarkers.id = "databaseMarkers";
    map.addLayer(databaseMarkers);
    
	//zentriert die Karte auf das K28
	map.setCenter(new OpenLayers.LonLat(pref_saved_lon_center,pref_saved_lat_center) // Center of the map
		, pref_saved_zoom_center // Zoom level
	);
	
	//prevent context menu (right click menu)
	map.div.oncontextmenu = function noContextMenu(e) {
        if (OpenLayers.Event.isRightClick(e)){
        	return false;
        };
    };
    
   //first picture
    pictureList = new Array();
    pictureList[0] = new Object();
    pictureList[0]["name"] = "House Plan";
    pictureList[0]["imageUrl"] = contentPath + '/img/plan_europaplatz.jpeg';
    pictureList[0]["xPos"] = pref_saved_lon_center;
    pictureList[0]["yPos"] = pref_saved_lat_center;
    pictureList[0]["width"] = map.getSize().w/3;
    pictureList[0]["height"] = map.getSize().h/3;
    pictureList[0]["xOffset"] = 0;
    pictureList[0]["yOffset"] = -200;
    pictureList[0]["rotation"] = 0;
    pictureList[0]["resolution"] = 2.388657133483887;


   theOpacity = 1;
   //set values from first picture as default
   theGraphicUrl = pictureList[0]["imageUrl"];
   XPos          = pictureList[0]["xPos"];
   YPos          = pictureList[0]["yPos"];
   theWidth      = pictureList[0]["width"];
   theHeight     = pictureList[0]["height"];
   theXOffset    = pictureList[0]["xOffset"];
   theYOffset    = pictureList[0]["yOffset"];
   theRotation   = pictureList[0]["rotation"];
   theResolution = pictureList[0]["resolution"];
   
   
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

   pictureVectorLayer = new OpenLayers.Layer.Vector("picture layer");
   pictureVectorLayer.styleMap = pictureVectorLayerStyleMap;
   
   map.addLayer(pictureVectorLayer);
   var newPoint = new OpenLayers.Geometry.Point(pref_saved_lon_center, pref_saved_lat_center);
   var pointFeature = new OpenLayers.Feature.Vector(newPoint);                             //,null,style_blue);
   pointFeature.attributes.render = "drawAlways";
   pictureVectorLayer.addFeatures([pointFeature]);
   pictureVectorLayer.setOpacity(theOpacity);
   
   ctrlDragFeature = new OpenLayers.Control.DragFeature(pictureVectorLayer);
   map.addControl(ctrlDragFeature);
   ctrlDragFeature.activate();
}

function setViewBackground(url){
	
	view_removeLayers();
	
	if(url == "map"){
		
		osmLayer = new OpenLayers.Layer.OSM();
		map.addLayer(osmLayer);
		map.zoomToMaxExtent();
		
	} else {
		
		// set new background with image from url
		var backgroundImageLayer = new OpenLayers.Layer.Image(
	            url,
	            url,
	            new OpenLayers.Bounds(-680, -635, 680, 635),
	    		new OpenLayers.Size(232, 212),
	            {numZoomLevels: 15}
	        );
		map.addLayer(backgroundImageLayer);
		map.zoomToMaxExtent();
	}
}

function view_removeLayers(){
	for (var i = map.layers.length - 1; i >= 0; i--) {
		map.removeLayer(map.layers[i]);
	}
}

function setPicture(url){
	theGraphicUrl = url;
	pictureVectorLayer.redraw();
}

function rotatePictureToRight(){
	theRotation = theRotation + 1;
	pictureVectorLayer.redraw();
}

function rotatePictureToLeft(){
	theRotation = theRotation - 1;
	pictureVectorLayer.redraw();
}	

function increasePictureWith(){
	theWidth = theWidth + 1;
	pictureVectorLayer.redraw();
}

function decreasePictureWith(){
	theWidth = theWidth - 1;
	pictureVectorLayer.redraw();
}

function increasePictureHeight(){
	theHeight = theHeight + 1;
	pictureVectorLayer.redraw();
}

function decreasePictureHeight(){
	theHeight = theHeight - 1;
	pictureVectorLayer.redraw();
}

function increaseOpacity(){
	if(theOpacity < 1){
		theOpacity = theOpacity + 0.1;
		pictureVectorLayer.setOpacity(theOpacity);
	} else theOpacity = 1; // just reset for value safety
}

function decreaseOpacity(){
	if(theOpacity > 0){
		theOpacity = theOpacity - 0.1;
		pictureVectorLayer.setOpacity(theOpacity);
	} else theOpacity = 0; // just reset for value safety
}

function fixPicture(){
	alert("Wenn ich mal ein erwachsener Script bin, sag ich dem Server folgendes:\n"
			+ "\n width: " + theWidth
			+ "\n heigt: " + theHeight
			+ "\n xPos: " + pictureVectorLayer.features[0].geometry.x
			+ "\n yPos: " + pictureVectorLayer.features[0].geometry.y
			+ "\n rotation: " + theRotation
			+ "\n opacity: " + theOpacity);
}

function resetMarkerIcons(){
	if(databaseMarkers.markers == null)
		return;
	
	for (var i = 0; i < databaseMarkers.markers.length; i++) {
		databaseMarkers.markers[i].setUrl(contentPath + '/img/Map_Pin_by_Merlin2525_small_yellow.png');
	  }
}

function resetMarkerPopups(){
	if(databaseMarkers.markers == null)
		return;
	
	for (var i = 0; i < databaseMarkers.markers.length; i++) {
		if(!(databaseMarkers.markers[i].feature.popup == null)){
			map.removePopup(databaseMarkers.markers[i].feature.popup);
			databaseMarkers.markers[i].feature.popup = null;
		}
	 }
}

function setButton(name, what, namespace){
	
	AUI().use(function(A){

		var button = A.one('#'+namespace+name);
		
		if(what == "enable"){  
			button.set('disabled', false);
			button.ancestor('.aui-button').removeClass('aui-button-disabled');
		}
		
		if(what == "disable"){
			button.set('disabled',true);
			button.ancestor('.aui-button').addClass('aui-button-disabled');
		}
	});
	
}

function deleteMarkerWithId(mapObjectId){
	for (var i = 0; i < databaseMarkers.markers.length; i++) {
		if(databaseMarkers.markers[i].mapObjectId == mapObjectId){
			resetMarkerPopups();
			var remMarker = databaseMarkers.markers[i];
			databaseMarkers.removeMarker(remMarker);
			return;
		}
	  }
}

function addMarkerToDatabaseLayer(mapObjectId, lon, lat, username, isOwner, titel, description, link,namespace){

	var lonLatMarker = new OpenLayers.LonLat(lon, lat);
	var feature = new OpenLayers.Feature(databaseMarkers, lonLatMarker);
    feature.closeBox = true;
    feature.popupClass = OpenLayers.Class(OpenLayers.Popup.FramedCloud, {minSize: new OpenLayers.Size(100, 100),
    																		autoSize: true});
    
    
    if(link == "http://" || link == ""){	//if link is not set
    	// dont show rendered link
	    feature.data.popupContentHTML = "Von " + username +"<br/>"
	    								+"<h2>" + titel + "</h2> "
	    								+ description + "<br/>";
    } else {	//if link is set
    	//show rendered link
    	feature.data.popupContentHTML = "Von " + username +"<br/>"
		+"<h2>" + titel + "</h2> "
		+ description + "<br/>"
		+ "<a href=\"" + link + "\" target=\"_blank\"> Link</a>";
    }
    feature.data.overflow = "hidden";

    var icon = new OpenLayers.Icon(contentPath + '/img/Map_Pin_by_Merlin2525_small_yellow.png', new OpenLayers.Size(40,47), new OpenLayers.Pixel(0,-40));
    var marker = new OpenLayers.Marker(lonLatMarker, icon);
    marker.feature = feature;
    marker.mapObjectId = mapObjectId;
    marker.isOwner = isOwner;
    
    var markerClickMarker = function(evt){
    	
    	
    	if (this.feature.popup == null) {
    		resetMarkerPopups();
    		this.feature.popup = this.feature.createPopup(this.feature.closeBox);
    		map.addPopup(this.feature.popup, true);
    		resetMarkerIcons();
    		this.setUrl(contentPath + '/img/Map_Pin_by_Merlin2525_small_blue.png');
    		if(permission_to_delete_marker && (this.isOwner || is_moderator_or_admin)){
    			document.getElementById(namespace+"map_marker_id").value = this.mapObjectId;
    			setButton("button_delete_marker","enable",namespace);
  			}
  			
    		
    	} else {
    		
    		this.feature.popup.hide();
    		map.removePopup(this.feature.popup);
    		resetMarkerIcons();
    		resetMarkerPopups();
    		if(permission_to_delete_marker){
    			setButton("button_delete_marker","disable",namespace);
    			document.getElementById(namespace+"map_marker_id").value = "";
  			}
    		
    	}
    };
    
    marker.events.register("mousedown", marker, markerClickMarker);

    databaseMarkers.addMarker(marker);
}
