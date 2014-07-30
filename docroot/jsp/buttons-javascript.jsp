
<!-- Vorläufige Auslagerung der Javascript Funktionen
	bisher ausgelagert: 
		- Hilfe-Button
 		- Show / Hide Control  functions
 		
 -->		
 		
 		
 <!------------------------------ SHOW / HIDE CONTROLS ----------------------------->	
 <!-- Wichtig: Beim debuggen auskommentieren, was im Code auch auskommentiert ist -->	 
 <script>

function hideAllActionControls(){
AUI().use(function(A){

//A.one('#<portlet:namespace />button-do-image').hide();
A.one('#<portlet:namespace />button-do-marker').hide();
//A.one('#<portlet:namespace />picture-controls').hide();
A.one('#<portlet:namespace />marker-controls-set').hide();
A.one('#<portlet:namespace />marker-controls-fix').hide();
//A.one('#<portlet:namespace />marker-controls-delete').hide();
A.one('#<portlet:namespace />marker-controls-end').hide(); <!-- der Zurück-Button -->
});
}


function showMarkerControls(){
	AUI().use(function(A){
	A.one('#<portlet:namespace />button-do-marker').show();
	A.one('#<portlet:namespace />marker-controls-set').show();
	A.one('#<portlet:namespace />marker-controls-fix').show();
	//A.one('#<portlet:namespace />marker-controls-delete').show();
	A.one('#<portlet:namespace />marker-controls-end').show();
	A.one('#<portlet:namespace />button_set_marker').set('value',"setzen");
	});
}

function showPictureControls(){
AUI().use(function(A){
//A.one('#<portlet:namespace />image-controls').show();
});
}
</script> 
 		 
 		 

<!-------------------------------------- BUTTON HELP ----------------------------->
 <portlet:renderURL var="manualRenderURL"
windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
<portlet:param name="mvcPath" 
value="/jsp/mapPortletManual.jsp"/>
<portlet:param name="message" value="Karten-Portlet"/> <!-- TODO param löschen, Überreste von Code-Kopie aus Internet -->
</portlet:renderURL>

<aui:script>
AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',
function(A) {
	A.one('#<portlet:namespace />button_show_map_manual').on('click', function(event){
		var popUpWindow=Liferay.Util.Window.getWindow(
		{
		dialog: {
		width: document.documentElement.clientWidth/2.5,
		height: document.documentElement.clientHeight/2,
		centered: true,
		draggable: true,
		resizable: true,
		modal: false
		}}).plug(A.Plugin.IO,{autoLoad: false}).render();
	popUpWindow.show();
	popUpWindow.titleNode.html("Hilfe für Karte");
	popUpWindow.io.set('uri','<%= manualRenderURL %>');
	popUpWindow.io.start();
});
});
</aui:script>

<!-------------------------------------- BUTTON DO MARKER ----------------------------->
<aui:script use="aui-button">
var button = A.one('#<portlet:namespace />button_do_marker');
button.on('click',function(){
hideAllActionControls();
setButton("button_set_marker", "enable", namespace);
setButton("button_fix_marker", "disable", namespace);
addMarkersView.setVisibility(false);
showMarkerControls(); <!--  hier weiter!!!! -->
map.updateSize();
});
</aui:script>

<!-------------------------------------- BUTTON SET MARKER ----------------------------->
<aui:script use="aui-button">
var button = A.one('#<portlet:namespace />button_set_marker');
button.on('click', function() {

if(button.get('value') == 'setzen'){
setButton("button_fix_marker", "enable", namespace);
setInitAddMarker();
addMarkersView.setVisibility(true);
button.set('value','stop');

} else { 
setButton("button_fix_marker", "disable", namespace);
addMarkersView.setVisibility(false);
button.set('value','setzen');
}

});
</aui:script>

<!-------------------------------------- BUTTON FIX MARKER ----------------------------->
<aui:script use="aui-dialog,liferay-portlet-url">
var button = A.one('#<portlet:namespace />button_fix_marker');
button.on('click', function() {

var portletURL = new Liferay.PortletURL('RENDER_PHASE');
portletURL.setPortletId('<%= portletDisplay.getId() %>');
portletURL.setPortletMode('VIEW');
portletURL.setSecure(window.location.protocol == 'https:');
portletURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
portletURL.setParameter('jspPage','/jsp/addMarker.jsp');
portletURL.setParameter('lon',marker_add_lon);
portletURL.setParameter('lat',marker_add_lat);

var dialog = new A.Dialog({
id: '<portlet:namespace />dialog_add_marker',
            title: 'Marker hinzufügen',
            width: 500,
            centered: true,
            draggable: true,
            resizable: false,
            modal: false
        }).plug(A.Plugin.IO, {uri: portletURL.toString()}).render();
        dialog.show();
});
</aui:script>

<!-------------------------------------- BUTTON END for MARKER ----------------------------->

<aui:script use="aui-button">

var button = A.one('#<portlet:namespace />button_end_marker');

button.on('click', function() {
hideAllActionControls();
A.one('#<portlet:namespace />button-do-marker').show();
A.one('#<portlet:namespace />button-do-image').show();
addMarkersView.setVisibility(false);
setButton("button_fix_marker", "disable", namespace);

     });
</aui:script>


<!-------------------------------------- BUTTON delete MARKER ----------------------------->

<aui:script use="aui-dialog">

var button = A.one('#<portlet:namespace />button_delete_marker');

button.on('click', function() {

A.io.request('<%= eventHandlerURL %>', {
method: 'POST',
                        dataType: 'json',
                        data: {
                         action: 'deleteMarker',
                             markerId: toDeleteMarkerId
                        },
                        on: {
                             success: function() {
                             var result = this.get('responseData');
                             if(result == "success"){
                             deleteMarkerWithId(toDeleteMarkerId);
                             } else {
                            
                             alert('Es ist ein Fehler aufgetreten:' + result);
                             }
                             }
                        }
         });
     });
</aui:script>

<!-------------------------------------- BUTTON fix PICTURE ----------------------------->
<aui:script use="aui-oi-request">
A.one('#<portlet:namespace />fixPicture').on('click',function(){
var portletURL = new Liferay.PortletURL('RENDER_PHASE');
portletURL.setPortletId('<%= portletDisplay.getId() %>');
portletURL.setPortletMode('VIEW');
portletURL.setSecure(window.location.protocol == 'https:');
portletURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
portletURL.setParameter('jspPage','/jsp/addPicture.jsp');
portletURL.setParameter('map_picture_width',theWidth);
portletURL.setParameter('map_picture_height',theHeight);
portletURL.setParameter('map_picture_xpos',pictureAddVectorLayer.features[0].geometry.x);
portletURL.setParameter('map_picture_ypos',pictureAddVectorLayer.features[0].geometry.y);
portletURL.setParameter('map_picture_resolution', map.getResolution());
portletURL.setParameter('map_picture_rotation',theRotation);
portletURL.setParameter('map_picture_opacity',theOpacity);
portletURL.setParameter('map_picture_fileuuid',thePictureFileUuid);

var dialog = new A.Dialog({
id: '<portlet:namespace />dialog_add_picture',
title: 'Bild hinzufügen',
width: 500,
centered: true,
draggable: true,
resizable: false,
modal: false
}).plug(A.Plugin.IO, {uri: portletURL.toString()}).render();
dialog.show();
     });
     
</aui:script>

<!-------------------------------------- BUTTON DO IMAGE --------------------------------->

<aui:script use="aui-button">
var button = A.one('#<portlet:namespace />button_do_image');
button.on('click',function(){
hideAllActionControls();
A.one('#<portlet:namespace />button-do-image').show();
A.one('#<portlet:namespace />picture-controls').show();

if(firstFolderFileUuid != "0"){
pictureAddVectorLayer.setVisibility(true);
}
});
</aui:script>


<!-------------------------------------- BUTTON END for PICTURE ----------------------------->

<aui:script use="aui-button">

var button = A.one('#<portlet:namespace />button_end_picture');

button.on('click', function() {
hideAllActionControls();
A.one('#<portlet:namespace />button-do-marker').show();
A.one('#<portlet:namespace />button-do-image').show();
pictureAddVectorLayer.setVisibility(false);

     });
</aui:script>

<!-------------------------------------- FILE UPLOAD BUTTON FORM ----------------------------->

<portlet:actionURL name="fileUpload" var="fileUploadURL" />

<aui:script use="aui-oi-request">
A.one('#<portlet:namespace />form_upload_button').on('click',function(){

var file_path =A.one('#<portlet:namespace />form_file_path').get('value');
A.io.request('<%= fileUploadURL %>', {
method: 'POST',
dataType:'json',
                        contentType:'multipart/form-data',
                        data: {
                         file: form_file,
                        },
                        on: {
                             success: function() {
                             alert('upload successful');
                             }
                        }
                    });
     });
     
</aui:script>


<!-------------------------------------- REMOVE PICTURE ----------------------------->
<aui:script use="aui-oi-request">

var pictureIDtoPictureName = {};
<% for(Picture picture: backgroundPictureList){ %>
pictureIDtoPictureName[<%=picture.getPictureId() %>] = '<%= picture.getName() %>';
<% } %>

A.one('#<portlet:namespace />button_remove_picture').on('click',function(){

var remove_picture_id =A.one('#<portlet:namespace />remove_picture').get('value');
A.io.request('<%= eventHandlerURL %>', {
method: 'POST',
dataType: 'json',
                        data: {
                         action: 'deletePicture',
                         remove_picture_id: remove_picture_id,
                        },
                        on: {
                             success: function() {
                             Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
                             }
                        }
                    });
     });
     
</aui:script>


<!-------------------------------------- FUNKTION BILDDETAILS ----------------------------->
<script>
function showPictureDetailPopupWithContent(name,userName,description,link){
AUI().use('aui-dialog','liferay-portlet-url', function(A){
var portletURL = new Liferay.PortletURL('RENDER_PHASE');
portletURL.setPortletId('<%= portletDisplay.getId() %>');
portletURL.setPortletMode('VIEW');
portletURL.setSecure(window.location.protocol == 'https:');
portletURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
portletURL.setParameter('jspPage','/jsp/pictureDetailsPopup.jsp');
portletURL.setParameter('userName',userName);
portletURL.setParameter('description',description);
portletURL.setParameter('link',link);

var dialog = new A.Dialog({
title: name,
centered: true,
modal: false,
width: 200,
height: 200
}).plug(A.Plugin.IO, {uri: portletURL.toString()}).render();
dialog.show();
});
    }
</script>