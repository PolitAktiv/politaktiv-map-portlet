<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>

<%@ page import="javax.portlet.WindowState" %>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.ActionRequest"%>
<%@ page import="javax.portlet.ValidatorException" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>

<%@ page import="org.politaktiv.map.infrastructure.model.Marker" %>
<%@ page import="org.politaktiv.map.infrastructure.model.Picture" %>
<%@ page import="org.politaktiv.map.infrastructure.model.Background" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="com.liferay.portal.service.UserLocalServiceUtil" %>

<%@page import="com.liferay.portal.util.PortalUtil" %>

<portlet:resourceURL  var="eventHandlerURL">
</portlet:resourceURL>

<portlet:resourceURL  var="resourceURL">
</portlet:resourceURL>

<portlet:defineObjects /> 
<liferay-theme:defineObjects />

<%
boolean permission_to_add_marker = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.Marker", layout.getGroupId(), "ADD");
boolean permission_to_update_marker = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.Marker", layout.getGroupId(), "UPDATE");
boolean permission_to_delete_marker = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.Marker", layout.getGroupId(), "DELETE");
boolean permission_to_add_picture = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.Picture", layout.getGroupId(), "ADD");
boolean permission_to_update_picture = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.Picture", layout.getGroupId(), "UPDATE");
boolean permission_to_delete_picture = permissionChecker.hasPermission(layout.getGroupId(), "org.politaktiv.map.infrastructure.model.Picture", layout.getGroupId(), "DELETE");
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

<% 
	List<FileEntry> portletFolderFiles = (List<FileEntry>) request.getAttribute("portletFolderFiles");
	List<Background> backgroundList = (List<Background>) request.getAttribute("backgroundList");
	long pictureFilderId = (Long) request.getAttribute("pictureFolderId");
%>
<aui:script>
<!-- use for mapping [ backgroundId -> pictureUrl ] -->
var backgroundIdToPictureUrlMap = {};
<% for(Background background: backgroundList){ %>
	backgroundIdToPictureUrlMap[<%=background.getBackgroundId() %>] = '<%=background.getPictureUrl() %>';
<% } %>

var fileEntryUuidToPictureUrlMap = {};
<% for(FileEntry entry: portletFolderFiles){ %>
			fileEntryUuidToPictureUrlMap['<%=entry.getUuid() %>'] = '<%="/c/document_library/get_file?uuid="+entry.getUuid()+"&groupId=" + themeDisplay.getScopeGroupId() %>';
<% } %>

var portalUrl;
	if(window.location.protocol == 'https:')
		portalUrl = "<%=themeDisplay.getPortalURL().replaceFirst("http:", "https:") %>";
	else
		portalUrl = "<%=themeDisplay.getPortalURL() %>";
	
	var groupId = "<%= themeDisplay.getScopeGroupId() %>";
	
	var pref_saved_lon_center = '<%= portletPreferences.getValue("lon_center", "ERROR_should_not_happend") %>';
	var pref_saved_lat_center = '<%= portletPreferences.getValue("lat_center", "ERROR_should_not_happend") %>';
	var pref_saved_zoom_center = '<%= portletPreferences.getValue("zoom_center", "ERROR_should_not_happend") %>';
	var pref_background_id = '<%= portletPreferences.getValue("background_id", "ERROR_should_not_happend") %>';
	var contentPath = "<%=request.getContextPath()%>";
	
</aui:script> 