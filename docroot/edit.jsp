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

<portlet:defineObjects /> 
<liferay-theme:defineObjects />

<portlet:actionURL name="saveCenterAndBackground" var="saveCenterURL">
	<portlet:param name="action" value="saveCenter" />
</portlet:actionURL>


<%
 	String saveCenterURLString = saveCenterURL.toString();
	List<FileEntry> portletFolderFiles = (List<FileEntry>) request.getAttribute("portletFolderFiles");

%>

<div id="editViewMap" style="width:100%; height:600px;"></div> 
<aui:script>
	var pref_saved_lon_center = '<%= portletPreferences.getValue("lon_center", "") %>';
	var pref_saved_lat_center = '<%= portletPreferences.getValue("lat_center", "") %>';
	var pref_saved_zoom_center = '<%= portletPreferences.getValue("zoom_center", "") %>';
	var pref_background_url = '<%= portletPreferences.getValue("background_url","map") %>';

	editViewMapInit('<portlet:namespace />');
</aui:script>

Hintergrund ändern:
<aui:form name="editfm" action="<%= saveCenterURLString %>" method="post">
	<aui:select name="background_url" label="" onchange="javascript:setEditBackground(this.value);">
			<aui:option value="map"> <b>Karte</b> </aui:option>
		<% for(FileEntry entry: portletFolderFiles){ %>
		<% // TODO: use uuid,groupId as saved parameters instead of full url -> www vs staging vs test %>
			<aui:option value='<%=themeDisplay.getPortalURL()+"/c/document_library/get_file?uuid="+entry.getUuid()+"&groupId="+entry.getGroupId() %>'>
								<%= entry.getTitle()  %>
			</aui:option>
		<% } %>
	</aui:select>
	<aui:input type="hidden" readonly="readonly" name="lon_center" id="lon_center" />
	<aui:input type="hidden" readonly="readonly" name="lat_center" id="lat_center" />
	<aui:input type="hidden" readonly="readonly" name="zoom_center" id="zoom_center" />
	
	<aui:button type="submit" id="set_Center" value="save-new-center-and-background"/>
</aui:form>


Neuen Hintergrund hochladen:
<portlet:actionURL name="fileUpload" var="fileUploadURL" />
<%
   	String fileUploadURLString = fileUploadURL.toString();
%>
<aui:form name="fm" action="<%= fileUploadURLString %>" method="post" enctype="multipart/form-data">
	<aui:input type="file" name="form_file" label="" size="40"/>
	<aui:button type="submit" name="form_upload_button" value="Hochladen" />
</aui:form>

