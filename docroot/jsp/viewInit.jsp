<%--
   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 --%>
 
 <%@ include file="globalInit.jsp" %>

<liferay-ui:error key="illegalDatatype" message="illegal-datatype" />
<liferay-ui:error key="wrongZoomLevel" message="wrong-zoom-level" />
<liferay-ui:error key="wrongLatitude" message="wrong-latitude" />
<liferay-ui:error key="wrongLongitude" message="wrong-longitude" />

<%
	List<Picture> backgroundPictureList = (List<Picture>) request.getAttribute("backgroundPictureList");
	List<Marker> backgroundMarkerList = (List<Marker>) request.getAttribute("backgroundMarkerList");
%>

<aui:script>
<%--  var firstFolderFileUuid = '<%=portletFolderFiles.get(0).getUuid() %>'; --%>
var firstFolderFileUuid = '<%= request.getAttribute("firstFolderFileUuid") %>';

</aui:script>