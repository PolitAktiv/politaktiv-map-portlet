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

<%@ include file="./init.jsp" %>

<liferay-ui:error key="illegalDatatype" message="illegal-datatype" />
<liferay-ui:error key="wrongZoomLevel" message="wrong-zoom-level" />
<liferay-ui:error key="wrongLatitude" message="wrong-latitude" />
<liferay-ui:error key="wrongLongitude" message="wrong-longitude" />

<% 
	List<MapObject> mapObjectList = (List<MapObject>) request.getAttribute("mapObjectListFromCommunityOnly");
	List<FileEntry> portletUploadFolderFiles = (List<FileEntry>) request.getAttribute("portletUploadFolderFiles");
%>
<% %>

<portlet:defineObjects /> 
<liferay-theme:defineObjects />

<%
boolean permission_to_add_marker = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.DbMarker", layout.getGroupId(), "ADD");
boolean permission_to_update_marker = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.DbMarker", layout.getGroupId(), "UPDATE");
boolean permission_to_delete_marker = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.DbMarker", layout.getGroupId(), "DELETE");
boolean permission_to_add_picture = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.DbPicture", layout.getGroupId(), "ADD");
boolean permission_to_update_picture = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.DbPicture", layout.getGroupId(), "UPDATE");
boolean permission_to_delete_picture = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.DbPicture", layout.getGroupId(), "DELETE");
// == moderator && admin
boolean is_moderator_or_admin = permissionChecker.hasPermission(layout.getGroupId(), "politaktivmap_WAR_politaktivmapportlet", layout.getGroupId(), "CONFIGURATION");


%>

<aui:script>
		var permission_to_add_marker = <%= permission_to_add_marker %>;
		var permission_to_update_marker = <%= permission_to_update_marker %>;
		var permission_to_delete_marker = <%= permission_to_delete_marker %>;
		var permission_to_add_picture = <%= permission_to_add_picture %>;
		var permission_to_update_picture = <%= permission_to_update_picture %>;
		var permission_to_delete_picture = <%= permission_to_delete_picture %>;
		var is_moderator_or_admin = <%= is_moderator_or_admin %>;
</aui:script>
		 

<portlet:resourceURL  var="eventHandlerURL">
</portlet:resourceURL>

<b>Welches Werkzeug wollen Sie benutzen? </b>
<br />

<script>

	function hideAllActionControls(){
		AUI().use(function(A){
			
			A.one('#<portlet:namespace />picture-controls').hide();
			A.one('#<portlet:namespace />marker-controls-add').hide();
			A.one('#<portlet:namespace />marker-controls-delete').hide();
		});
	}
	function showMarkerControls(){
		AUI().use(function(A){
			
			A.one('#<portlet:namespace />marker-controls-add').show();
			A.one('#<portlet:namespace />marker-controls-delete').show();
		});
	}
</script>

<!-------------------------------------- BUTTON DO MARKER ----------------------------->
<aui:button name="button_do_marker" value="Marker" />
<aui:script use="aui-button">
	var button = A.one('#<portlet:namespace />button_do_marker');
	button.on('click',function(){
		hideAllActionControls();
		showMarkerControls();

	});
</aui:script>

<!-------------------------------------- BUTTON DO IMAGE --------------------------------->
<aui:button name="button_do_image" value="Bild einf&uuml;gen" />
<aui:script use="aui-button">
	var button = A.one('#<portlet:namespace />button_do_image');
	button.on('click',function(){
		hideAllActionControls();
		A.one('#<portlet:namespace />picture-controls').show();
	});
</aui:script>

<!-------------------------------------- BUTTON ADD MARKER ----------------------------->
<!-- TODO: remove true -->
<% if(true || permission_to_add_marker){ %>
	<div id="<portlet:namespace />marker-controls-add">
		<!-- TODO: internationalize -->
		<aui:button name="button_add_marker" value="Marker Hinzuf&uuml;gen"/>
	</div>
		<aui:script use="aui-dialog,liferay-portlet-url">
			var button = A.one('#<portlet:namespace />button_add_marker');
			button.on('click', function() {
			var form_input_lon = A.one('#<portlet:namespace />map_marker_lon').get('value');
			var form_input_lat = A.one('#<portlet:namespace />map_marker_lat').get('value');
			
			var portletURL = new Liferay.PortletURL('RENDER_PHASE');
			portletURL.setPortletId('<%= portletDisplay.getId() %>');
			portletURL.setPortletMode('VIEW');
			portletURL.setSecure(window.location.protocol == 'https:');
			portletURL.setWindowState('<%= LiferayWindowState.EXCLUSIVE.toString() %>');
	<!-- 		TODO: make "/jsp/addMarker.jsp" configurable -->
			portletURL.setParameter('jspPage','/jsp/addMarker.jsp');
			portletURL.setParameter('lon',form_input_lon);
			portletURL.setParameter('lat',form_input_lat);
			
			var dialog = new A.Dialog({
					id: '<portlet:namespace />dialog_add_marker',
		            title: 'Marker hinzufügen',
		            centered: true,
		            draggable: true,
		            resizable: false,
		            modal: false
		        }).plug(A.Plugin.IO, {uri: portletURL.toString()}).render();
		        dialog.show();
			});
		</aui:script>

<% } %>

<!-------------------------------------- BUTTON delete MARKER ----------------------------->
<!-- TODO: remove true -->
<% if(true || permission_to_delete_marker){ %>
	<div id="<portlet:namespace />marker-controls-delete">
		<br />
		<aui:button name="button_delete_marker" value="Marker Entfernen"/>
		<br />
	</div>
	<aui:script use="aui-dialog">
		
		var button = A.one('#<portlet:namespace />button_delete_marker');
		
		button.on('click', function() {
		
			var form_input_id = A.one('#<portlet:namespace />map_marker_id').get('value');
			A.io.request('<%= eventHandlerURL %>', {
							method: 'POST',
	                        dataType: 'json',
	                        data: {
	                        		action: 'delete',
	                        		type: 'marker',
	                            	mapObjectId: form_input_id
	                        },
	                        on: {
	                            	success: function() {
	                            		var result = this.get('responseData');
	                            		if(result == "success"){
	                            			deleteMarkerWithId(form_input_id);
	                            		} else {
	                            			
	                            			alert('Es ist ein Fehler aufgetreten:' + result);
	                            		}
	                            	}
	                        }
	         });
	     });
	</aui:script>
<% } %>


<portlet:actionURL name="fileUpload" var="fileUploadURL" />
<%
   	String fileUploadURLString = fileUploadURL.toString();
%>

<div id="<portlet:namespace />picture-controls">

Vorhandenes Bild:

<aui:form>
	<aui:select name="pictureSelect" label="" onchange="javascript:setPicture(this.value);">
		<% for(FileEntry entry: portletUploadFolderFiles){ %>
			<aui:option value='<%=themeDisplay.getPortalURL()+"/c/document_library/get_file?uuid="+entry.getUuid()+"&groupId="+entry.getGroupId() %>'>
								<%= entry.getTitle()  %>
			</aui:option>
		<% } %>
	</aui:select>
</aui:form>
		


<aui:form name="fm" action="<%= fileUploadURLString %>" method="post" enctype="multipart/form-data">
	<aui:input type="file" name="form_file" label="" size="40"/>
	<aui:button type="submit" name="form_upload_button" value="Hochladen" />
</aui:form>

<aui:script use="aui-oi-request">
	A.one('#<portlet:namespace />form_upload_button').on('click',function(){
	
		var file_path =A.one('#<portlet:namespace />form_file_path').get('value');
		alert('upload button pressed');
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
     
     A.one('#<portlet:namespace />button_add_marker');
</aui:script>


	<br />
	Drehen:
	<aui:button name="rotatePictureLeft" value="links" onClick="rotatePictureToLeft()"/>
	<aui:button name="rotateLictureRight" value="rechts" onClick="rotatePictureToRight()"/>
	Breite:
	<aui:button name="increasePictureWith" value="+" onClick="increasePictureWith()"/>
	<aui:button name="decreasePictureWith" value="-" onClick="decreasePictureWith()"/>
	H&ouml;he:
	<aui:button name="increasePictureHeight" value="+" onClick="increasePictureHeight()"/>
	<aui:button name="decreasePictureHeight" value="-" onClick="decreasePictureHeight()"/>
	Durchsichtigkeit:
	<aui:button name="decreaseOpacity" value="+" onClick="decreaseOpacity()"/>
	<aui:button name="increaseOpacity" value="-" onClick="increaseOpacity()"/>
	<br />
	Position speichern:
	<aui:button name="fixPicture" value="Bild fixieren" onClick="fixPicture()"/>

</div>
<!---------------------------------------------  THE MAP ---------------------------->

<div id="map" style="width:100%; height:600px;"></div>


<aui:script>

	hideAllActionControls();
	var pref_saved_lon_center = '<%= portletPreferences.getValue("lon_center", "3689105.376514") %>';
	var pref_saved_lat_center = '<%= portletPreferences.getValue("lat_center", "4501123.3974313") %>';
	var pref_saved_zoom_center = '<%= portletPreferences.getValue("zoom_center", "0") %>';
<!-- 																				TODO: remove testtesttest -->
	var pref_background_url = '<%= portletPreferences.getValue("background_url", "map") %>';
	
	<!-- 	get path for images -->
	var contentPath = "<%=request.getContextPath()%>";
	<!-- 	init the map + transfer namespace to javascript -->
	init('<portlet:namespace />');
	
	<% for(MapObject mapObject: mapObjectList){
			if(mapObject.isMarker()) {%>
				addMarkerToDatabaseLayer('<%=  mapObject.getMapObjectId() %>',
										'<%= ((Marker) mapObject.getGraphicObject()).getLongitude() %>',
										'<%= ((Marker) mapObject.getGraphicObject()).getLatitude() %>',
										'<%= UserLocalServiceUtil.getUserById(mapObject.getUserId()).getFullName() %> ',
										'<%= UserLocalServiceUtil.getUserById(mapObject.getUserId()).getUserId() == mapObject.getUserId() %>',
										'<%= HtmlUtil.escape(mapObject.getName())%>',
										'<%= HtmlUtil.escape(mapObject.getDescription()) %>',
										'<%= HtmlUtil.escapeJS(mapObject.getReferenceUrl())%>',
										'<portlet:namespace />');
	
	<% 		}
	} %>
	

</aui:script>

<aui:input name="map_marker_lon" type="hidden" />
<aui:input name="map_marker_lat" type="hidden" />
<aui:input name="map_marker_id" type="hidden" />



