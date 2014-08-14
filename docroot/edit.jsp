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

<%@ include file="jsp/editInit.jsp"%>


<aui:button name="button_show_picture_folder" value="Zeige Bilderordner" />
<aui:script use="aui-dialog,liferay-portlet-url"> 
 			var button = A.one('#<portlet:namespace />button_show_picture_folder'); 
 			button.on('click', function() { 
		
			<%
    //TODO: make it more elegant by using var portletURL = new Liferay.PortletURL();
		// descriped in http://www.liferay.com/web/eduardo.lundgren/blog/-/blogs/liferay-portleturl-in-javascript
		// use: portletURL.setSecure(window.location.protocol == 'https:')
%>	
			
			var portletURL = "<%=themeDisplay.getPortalURL()%>"
							+ "/group/control_panel/manage"
							+ "?p_p_id=20"
							+ "&p_p_lifecycle=0"
							+ "&p_p_state=<%=LiferayWindowState.EXCLUSIVE.toString()%>"
							+ "&p_p_mode=view"
							+ "&doAsGroupId=<%=themeDisplay.getLayout().getGroupId()%>"
							+ "&controlPanelCategory=content"
							+ "&_20_struts_action=%2Fdocument_library%2Fview"
							+ "&_20_folderId=<%=pictureFilderId%>";

 			var dialog = new A.Dialog({
 					id: '<portlet:namespace />button_show_picture_folder', 
 		            title: 'Politaktiv Map <%=LanguageUtil.get(pageContext, "images")%>',
 		            centered: true,
 		            draggable: true,
 		            resizable: false,
 		            modal: false
 		        }).plug(A.Plugin.IO, {uri: portletURL.toString()}).render();
 		        dialog.show();
 			});
	</aui:script>

<div id="editMap"></div>
<aui:script>
	initMap('<portlet:namespace />', 'edit');
</aui:script>

1. Neuen Bild für Hintergründe hochladen:
<portlet:actionURL name="fileUpload" var="fileUploadURL" />
<%
    String fileUploadURLString = fileUploadURL.toString();
%>
<aui:form name="fm" action="<%=fileUploadURLString%>" method="post"
	enctype="multipart/form-data">
	<aui:input type="file" name="form_file" label="" size="40" />
	<aui:button type="submit" name="form_upload_button" value="Hochladen" />
</aui:form>

<portlet:actionURL name="createNewBackground"
	var="CreateNewBackgroundURL">
	<portlet:param name="action" value="createNewBackground" />
</portlet:actionURL>

2. Neuen Hintergrund aus Bild definieren:
<aui:select name="background_uuid" label=""
	onchange="javascript:setBackground(fileEntryUuidToPictureUrlMap[this.value]);">
	<aui:option value="map">
		<b>Karte</b>
	</aui:option>

	<%
	    for (FileEntry entry : portletFolderFiles) {
	%>
	<aui:option value='<%=entry.getUuid()%>'>
		<%=entry.getTitle()%>
	</aui:option>
	<%
	    }
	%>
</aui:select>

Name für Hintergrund:
<aui:input type="text" name="background_name" id="background_name"
	label="" />
<aui:button name="button_add_background"
	value="Hintergrund hinzuf&uuml;gen" />
<br />

<aui:script use="aui-oi-request-deprecated">
  A.one('#<portlet:namespace />button_add_background').on('click', function() {
    var form_input_background_uuid = A.one('#<portlet:namespace />background_uuid').get('value');
		var form_input_background_name = A.one('#<portlet:namespace />background_name').get('value');
		A.io.request('<%=eventHandlerURL%>', {
		  method: 'POST',
	      dataType: 'json',
	      data: {
	        <portlet:namespace/>action: 'addBackground',
	        <portlet:namespace/>background_uuid: form_input_background_uuid,
	        <portlet:namespace/>background_name: form_input_background_name
	     },
      on: {
        success: function() {
          var result = this.get('responseData');
          Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
       	}
      }
    });
	});
	
</aui:script>

3. Hintergrund auswählen und eingestellten Kartenausschnitt speichern:
<aui:select name="background_id" label=""
	onchange="javascript:setBackground(backgroundIdToPictureUrlMap[this.value]);">
	<%
	    for (Background background : backgroundList) {
	%>
	<aui:option value='<%=background.getBackgroundId()%>'
		selected='<%=Long.toString(background.getBackgroundId()).equals(
				portletPreferences.getValue("background_id", "map"))%>'>
		<%=background.getName()%>
	</aui:option>
	<%
	    }
	%>
</aui:select>

<aui:button name="button_save_center_and_zoom"
	value="Zentrum und Zoom speichern" />

<aui:script use="aui-oi-request-deprecated">
	A.one('#<portlet:namespace />button_save_center_and_zoom').on('click', function() {
		var form_input_background_id = A.one('#<portlet:namespace />background_id').get('value');
		A.io.request('<%=eventHandlerURL%>', {
			method: 'POST',
	      dataType: 'json',
	      data: {
	     		<portlet:namespace/>action: 'saveCenterAndZoom',
	     		<portlet:namespace/>lon_center: map.getCenter().lon,
	     		<portlet:namespace/>lat_center: map.getCenter().lat,
	     		<portlet:namespace/>zoom_center: map.getZoom(),
	     		<portlet:namespace/>background_id: form_input_background_id
	      },
	      on: {
		     	success: function() {
		     		Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
		     	}
	      }
	   });
	});
	
</aui:script>
<br />
Hintergrund löschen:
<aui:select name="background_id_delete" label=""
	onchange="javascript:setBackground(backgroundIdToPictureUrlMap[this.value]);">
	<%
	    for (Background background : backgroundList) {
	%>
	<aui:option value='<%=background.getBackgroundId()%>'
		selected='<%=Long.toString(background.getBackgroundId()).equals(
				portletPreferences.getValue("background_id", "map"))%>'>
		<%=background.getName()%>
	</aui:option>
	<%
	    }
	%>
</aui:select>

<aui:button name="button_delete_background" value="delete-background" />

<aui:script use="aui-oi-request-deprecated">
	A.one('#<portlet:namespace />button_delete_background').on('click', function() {
		var form_input_background_id_delete = A.one('#<portlet:namespace />background_id_delete').get('value');
		A.io.request('<%=eventHandlerURL%>', {
			method: 'POST',
	      dataType: 'json',
	      data: {
	     		<portlet:namespace/>action: 'deleteBackground',
	     		<portlet:namespace/>background_id_delete: form_input_background_id_delete
	      },
	      on: {
	       	success: function() {
	       		var result = this.get('responseData');
	       		Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
	       	}
	      }
	  });
	});
	
</aui:script>

