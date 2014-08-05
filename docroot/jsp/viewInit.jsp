<%@ include file="globalInit.jsp"%>

<liferay-ui:error key="illegalDatatype" message="illegal-datatype" />
<liferay-ui:error key="wrongZoomLevel" message="wrong-zoom-level" />
<liferay-ui:error key="wrongLatitude" message="wrong-latitude" />
<liferay-ui:error key="wrongLongitude" message="wrong-longitude" />

<%
    List<Picture> backgroundPictureList = (List<Picture>) request.getAttribute("backgroundPictureList");
    List<Marker> backgroundMarkerList = (List<Marker>) request.getAttribute("backgroundMarkerList");
%>

<aui:script>
  var firstFolderFileUuid = '<%=request.getAttribute("firstFolderFileUuid")%>';
</aui:script>