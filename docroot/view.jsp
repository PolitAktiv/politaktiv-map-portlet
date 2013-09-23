<%--
/**
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 *        
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
--%>

<%@ include file="jsp/viewInit.jsp" %>



<% if(permission_to_add_picture || permission_to_add_marker){  %>
<aui:button name="button_show_map_manual" value="help" style="width: 80px;"/> 
<aui:script use="aui-dialog,liferay-portlet-url">
	var button = A.one('#<portlet:namespace />button_show_map_manual');
	button.on('click', function() {
	
	var portletURL = new Liferay.PortletURL('RENDER_PHASE');
	portletURL.setPortletId('<%= portletDisplay.getId() %>');
	portletURL.setPortletMode('VIEW');
	portletURL.setSecure(window.location.protocol == 'https:');
	portletURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
	portletURL.setParameter('jspPage','/jsp/mapPortletManual.jsp');
	
	var dialog = new A.Dialog({
			id: '<portlet:namespace />dialog_show_map_manual',
            title: 'Hilfe für Karte',
            width: document.documentElement.clientWidth/2.5, 
    		height: document.documentElement.clientHeight/2, 
            centered: true,
            draggable: true,
            resizable: true,
            modal: false
        }).plug(A.Plugin.IO, {uri: portletURL.toString()}).render();
        dialog.show();
	});
</aui:script>
<% } %>
<script>

	function hideAllActionControls(){
		AUI().use(function(A){
			
			A.one('#<portlet:namespace />button-do-image').hide();
			A.one('#<portlet:namespace />button-do-marker').hide();
			A.one('#<portlet:namespace />picture-controls').hide();
			A.one('#<portlet:namespace />marker-controls-set').hide();
			A.one('#<portlet:namespace />marker-controls-fix').hide();
			A.one('#<portlet:namespace />marker-controls-delete').hide();
			A.one('#<portlet:namespace />marker-controls-end').hide();
		});
	}
	function showMarkerControls(){
		AUI().use(function(A){
			A.one('#<portlet:namespace />button-do-marker').show();
			A.one('#<portlet:namespace />marker-controls-set').show();
			A.one('#<portlet:namespace />marker-controls-fix').show();
			A.one('#<portlet:namespace />marker-controls-delete').show();
			A.one('#<portlet:namespace />marker-controls-end').show();
			A.one('#<portlet:namespace />button_set_marker').set('value',"setzen");
		});
	}
	
	function showPictureControls(){
		AUI().use(function(A){
			A.one('#<portlet:namespace />image-controls').show();
		});
	}
</script>

<!-------------------------------------- BUTTON DO MARKER ----------------------------->
<div id="<portlet:namespace />button-do-marker" style="display:inline-block;" >
	<aui:button name="button_do_marker" value="Marker" style="width: 80px;"/>
</div>
<aui:script use="aui-button">
	var button = A.one('#<portlet:namespace />button_do_marker');
	button.on('click',function(){
		hideAllActionControls();
		setButton("button_set_marker", "enable", namespace);
		setButton("button_fix_marker", "disable", namespace);
		addMarkersView.setVisibility(false);
		showMarkerControls();
		map.updateSize();
		
	});
</aui:script>

<!-------------------------------------- BUTTON DO IMAGE --------------------------------->
<div id="<portlet:namespace />button-do-image" style="display:inline-block;">
	<aui:button name="button_do_image" value="Overlay" style="width: 80px;"/>
</div>
<aui:script use="aui-button">
	var button = A.one('#<portlet:namespace />button_do_image');
	button.on('click',function(){
		hideAllActionControls();
		A.one('#<portlet:namespace />button-do-image').show();
		A.one('#<portlet:namespace />picture-controls').show();
<!-- 		show layer only if one files exists -->  e
		if(firstFolderFileUuid != "0"){
			pictureAddVectorLayer.setVisibility(true);
		}
	});
</aui:script>

<!-------------------------------------- BUTTON set MARKER ----------------------------->
<br />
<div id="<portlet:namespace />marker-controls-set" style="display:inline-block;"/>
	<!-- TODO: internationalize -->
	<aui:button name="button_set_marker" value="setzen" style="width: 80px;"/>
</div>
<aui:script use="aui-button">
	var button = A.one('#<portlet:namespace />button_set_marker');
	button.on('click', function() {
	
		if(button.get('value') == 'setzen'){
			setButton("button_fix_marker", "enable", namespace);
			setInitAddMarker();
			addMarkersView.setVisibility(true);
			button.set('value','stop');
		
		} else { <!-- if button is stop -->
		setButton("button_fix_marker", "disable", namespace);
			addMarkersView.setVisibility(false);
			button.set('value','setzen');
		}
	
	});
</aui:script>

<!-------------------------------------- BUTTON fix MARKER ----------------------------->
<div id="<portlet:namespace />marker-controls-fix" style="display:inline-block;"/>
	<!-- TODO: internationalize -->
	<aui:button name="button_fix_marker" value="fixieren" style="width: 80px;"/>
</div>
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

<!-------------------------------------- BUTTON delete MARKER ----------------------------->
<div id="<portlet:namespace />marker-controls-delete" style="display:inline-block;">
	<aui:button name="button_delete_marker" value="löschen" style="width: 80px;"/>
</div>
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

<!-------------------------------------- BUTTON END for MARKER ----------------------------->
<div id="<portlet:namespace />marker-controls-end" style="display:inline-block;">
	<aui:button name="button_end_marker" value="&lt;&lt; zur&uuml;ck" style="width: 80px;"/>
</div>
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


<portlet:actionURL name="fileUpload" var="fileUploadURL" />
<%
   	String fileUploadURLString = fileUploadURL.toString();
%>

<div id="<portlet:namespace />picture-controls">

<!-------------------------------------- BUTTON END for PICTURE ----------------------------->
<aui:button name="button_end_picture" value="&lt;&lt; zur&uuml;ck" style="width: 80px;"/>
<aui:script use="aui-button">
	
	var button = A.one('#<portlet:namespace />button_end_picture');

	button.on('click', function() {
			hideAllActionControls();
			A.one('#<portlet:namespace />button-do-marker').show();
			A.one('#<portlet:namespace />button-do-image').show();
			pictureAddVectorLayer.setVisibility(false);
			
     });
</aui:script>
<br />
<!-------------------------------------- FILE upload ----------------------------->
1. <%= LanguageUtil.get(pageContext, "upload-picture-drawing") %>:
<aui:form name="fm" action="<%= fileUploadURLString %>" method="post" enctype="multipart/form-data">
	<aui:input type="file" name="form_file" label="" size="40"/>
	<aui:button type="submit" name="form_upload_button" value="Hochladen"/>
</aui:form>

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


2. <%= LanguageUtil.get(pageContext, "choose-picture-drawing") %>:<aui:form>
	<aui:select name="pictureSelect" label="" onchange="javascript:setPicture(this.value)">
	
	<aui:option value='none'>
					&minus;bitte Ausw&auml;hlen&minus;
	</aui:option>
		
		<% for(FileEntry entry: portletFolderFiles){ %>
				<aui:option value='<%= entry.getUuid() %>'>
					<%= entry.getTitle()  %>
				</aui:option>
		<% } %>
	</aui:select>
</aui:form>

3. <%= LanguageUtil.get(pageContext, "align-overlay") %>:
	<table>
	<tr>
	
	<td><%= LanguageUtil.get(pageContext, "width") %>:</td>
	<td>
	<aui:button name="increasePictureWithBig" value="++" onClick="increasePictureWith(10)" style="width: 30px;"/>
	<aui:button name="increasePictureWith" value="+" onClick="increasePictureWith(1)" style="width: 30px;"/>
	<aui:button name="decreasePictureWith" value="-" onClick="decreasePictureWith(1)" style="width: 30px;"/>
	<aui:button name="decreasePictureWithBig" value="--" onClick="decreasePictureWith(10)" style="width: 30px;"/>
	</tr>
	<tr>
	<td><%= LanguageUtil.get(pageContext, "height") %>:</td>
	<td>
	<aui:button name="increasePictureHeightBig" value="++" onClick="increasePictureHeight(10)" style="width: 30px;"/>
	<aui:button name="increasePictureHeight" value="+" onClick="increasePictureHeight(1)" style="width: 30px;"/>
	<aui:button name="decreasePictureHeight" value="-" onClick="decreasePictureHeight(1)" style="width: 30px;"/>
	<aui:button name="decreasePictureHeightBig" value="--" onClick="decreasePictureHeight(10)" style="width: 30px;"/>
	</td>
	</tr>
	<tr>
	<td><%= LanguageUtil.get(pageContext, "angle") %>:</td>
	<td>
	<aui:button name="rotatePictureLeftBig" value="&lt;&lt;" onClick="rotatePictureToLeft(10)" style="width: 30px;"/>
	<aui:button name="rotatePictureLeft" value="&lt;" onClick="rotatePictureToLeft(1)" style="width: 30px;"/>
	<aui:button name="rotateLictureRight" value="&gt;" onClick="rotatePictureToRight(1)" style="width: 30px;"/>
	<aui:button name="rotateLictureRightBig" value="&gt;&gt;" onClick="rotatePictureToRight(10)" style="width: 30px;"/>
	</td>
	</tr>
	<tr>
	<td><%= LanguageUtil.get(pageContext, "transparency") %>: </td>
	<td>
	<aui:button name="decreaseOpacity" value="+" onClick="decreaseOpacity()" style="width: 30px;"/>
	<aui:button name="increaseOpacity" value="-" onClick="increaseOpacity()" style="width: 30px;"/>
	</td>
	</table>
	4. <%= LanguageUtil.get(pageContext, "position") %>:
	<aui:button name="fixPicture" value="fix-overlay" />
	
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
	
	<br />
	<%= LanguageUtil.get(pageContext, "remove-overlay") %>:
	<br />
	<aui:select name="remove_picture" label="" onchange="">
		<% for(Picture picture: backgroundPictureList){ %>
			<% if(picture.getUserId() == themeDisplay.getUserId()
			|| is_moderator_or_admin) { %>
				<aui:option value='<%= picture.getPictureId() %>'>
					<%= picture.getName()  %>
				</aui:option>
				<% } %>
		<% } %>
	</aui:select>

	<aui:button type="submit" name="button_remove_picture" value="remove" />

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
</div>

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
	
<% if(backgroundPictureList.size() >= 1){ %>

<br />
	<%=LanguageUtil.get(pageContext, "show-overlay") %>:<% for(Picture picture: backgroundPictureList){ %>
		<input style="margin-left: 15px; background-color:#aaa; width:20px; border:6px solid #ddd; display:inline-block;" type="checkbox" checked="checked" name="<%= picture.getName() %>" id="<%= picture.getName() %>" onClick="map.getLayersByName('<%= picture.getName() %>')[0].setVisibility(this.checked);">
		<a href="#" onclick="showPictureDetailPopupWithContent('<%= picture.getName() %>','<%= UserLocalServiceUtil.getUserById(picture.getUserId()).getFullName() %>','<%= picture.getDescription() %>','<%= picture.getReferenceUrl() %>')">
				<%= picture.getName() %>
		</a>
	<% } %>
<% } %>

<div id="viewMap" style="width:100%; height:600px;"></div>
<aui:script>

	hideAllActionControls();
	
	<%if(permission_to_add_marker){  %>
		AUI().use(function(A){A.one('#<portlet:namespace />button-do-marker').show();});
	<% } %>
	<%if(permission_to_add_picture){  %>
		AUI().use(function(A){A.one('#<portlet:namespace />button-do-image').show();});
	<% } %>
	
	
	
	<!-- 	init the map + transfer namespace to javascript -->
	initMap('<portlet:namespace />','view');
	
	<% for(Picture picture: backgroundPictureList){ %>
		addPictureOverlay('<%= picture.getName() %>', 
						'<%= picture.getPictureUrl() %>', 
						'<%= picture.getOcupacy() %>',
						'<%= picture.getRotation() %>',
						'<%= picture.getLongitude() %>', 
						'<%= picture.getLatitude() %>',
						'<%= picture.getWidth() %>',
						'<%= picture.getHeight() %>',
						'<%= picture.getPictureId() %>');
	<% } %>
	
	<% for(Marker marker: backgroundMarkerList){ %>
				addMarkerToDatabaseLayer('<%= marker.getMarkerId() %>',
										'<%= marker.getLongitude() %>',
										'<%= marker.getLatitude() %>',
										'<%= UserLocalServiceUtil.getUserById(marker.getUserId()).getFullName() %> ',
										'<%= themeDisplay.getUserId() == marker.getUserId() %>',
										'<%= marker.toHTMLFormatedString() %>',
										'<portlet:namespace />');
	
	<% } %>

	
	
</aui:script>


