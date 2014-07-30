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
<%@ include file="jsp/buttons-javascript.jsp" %> <!-- Das Funktionsauslagerungs-File -->
<script type="text/javascript" src="buttons.js"></script>


<!-------------------------------------- BUTTON MAP MANUAL ----------------------------->
<% if(permission_to_add_picture || permission_to_add_marker){ %>
<aui:button name="button_show_map_manual" id="button_show_map_manual" value="help" style="width: 80px;"/>
<% } %>




<!-------------------------------------- BUTTON DO MARKER ----------------------------->
 
<div id="<portlet:namespace />button-do-marker" style="display:inline-block;" >
<aui:button name="button_do_marker" value="Marker" style="width: 80px;"/>
</div>


<!-------------------------------------- BUTTON DO IMAGE --------------------------------->

<div id="<portlet:namespace />button-do-image" style="display:inline-block;">
<aui:button name="button_do_image" value="Overlay" style="width: 80px;"/>
</div>

<!-------------------------------------- BUTTON set MARKER ----------------------------->

<br />
<div id="<portlet:namespace />marker-controls-set" style="display:inline-block;"/>
<aui:button name="button_set_marker" value="setzen" style="width: 80px;"/>
</div>


<!-------------------------------------- BUTTON fix MARKER ----------------------------->

<div id="<portlet:namespace />marker-controls-fix" style="display:inline-block;"/>
<aui:button name="button_fix_marker" value="fixieren" style="width: 80px;"/>
</div>



<!-------------------------------------- BUTTON delete MARKER ----------------------------->

<div id="<portlet:namespace />marker-controls-delete" style="display:inline-block;">
<aui:button name="button_delete_marker" value="löschen" style="width: 80px;"/>
</div>


<!-------------------------------------- BUTTON END for MARKER ----------------------------->

<div id="<portlet:namespace />marker-controls-end" style="display:inline-block;">
<aui:button name="button_end_marker" value="&lt;&lt; zur&uuml;ck" style="width: 80px;"/>
</div>


 

<%
    String fileUploadURLString = fileUploadURL.toString();
%>

<div id="<portlet:namespace />picture-controls">

<!-------------------------------------- BUTTON END for PICTURE ----------------------------->

<aui:button name="button_end_picture" value="&lt;&lt; zur&uuml;ck" style="width: 80px;"/>
<br />

<!-------------------------------------- FILE upload ----------------------------->

1. <%= LanguageUtil.get(pageContext, "upload-picture-drawing") %>:
<aui:form name="fm" action="<%= fileUploadURLString %>" method="post" enctype="multipart/form-data">
<aui:input type="file" name="form_file" label="" size="40"/>
<aui:button type="submit" name="form_upload_button" value="Hochladen"/>
</aui:form>


2. <%= LanguageUtil.get(pageContext, "choose-picture-drawing") %>:<aui:form>
<aui:select name="pictureSelect" label="" onchange="javascript:setPicture(this.value)">

<aui:option value='none'>
&minus;bitte Ausw&auml;hlen&minus;
</aui:option>

<% for(FileEntry entry: portletFolderFiles){ %>
<aui:option value='<%= entry.getUuid() %>'>
<%= entry.getTitle() %>
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


<br />
<%= LanguageUtil.get(pageContext, "remove-overlay") %>:
<br />
<aui:select name="remove_picture" label="" onchange="">
<% for(Picture picture: backgroundPictureList){ %>
<% if(picture.getUserId() == themeDisplay.getUserId()
|| is_moderator_or_admin) { %>
<aui:option value='<%= picture.getPictureId() %>'>
<%= picture.getName() %>
</aui:option>
<% } %>
<% } %>
</aui:select>

<aui:button type="submit" name="button_remove_picture" value="remove" />


</div>



<% if(backgroundPictureList.size() >= 1){ %>

<br />
<%=LanguageUtil.get(pageContext, "show-overlay") %>:<% for(Picture picture: backgroundPictureList){ %>
<input style="margin-left: 15px; background-color:#aaa; width:20px; border:6px solid #ddd; display:inline-block;" type="checkbox" checked="checked" name="<%= picture.getName() %>" id="<%= picture.getName() %>" onClick="map.getLayersByName('<%= picture.getName() %>')[0].setVisibility(this.checked);">
<a href="#" onclick="showPictureDetailPopupWithContent('<%= picture.getName() %>','<%= UserLocalServiceUtil.getUserById(picture.getUserId()).getFullName() %>','<%= picture.getDescription() %>','<%= picture.getReferenceUrl() %>')">
<%= picture.getName() %>
</a>
<% } %>
<% } %>

 
 <!-------------------------------------- VIEW MAP  ----------------------------->
<div id="viewMap" style="width:100%; height:600px;"></div>
<aui:script>

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
