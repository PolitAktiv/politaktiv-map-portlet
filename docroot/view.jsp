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

<%@ include file="jsp/viewInit.jsp"%>

<!-------------------------------------- BUTTON DO HELP ----------------------------->


 <portlet:renderURL var="manualRenderURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="mvcPath" value="/jsp/mapPortletManual.jsp"/> <!-- Do not change the name! -->
	<portlet:param name="message" value="Karten-Portlet"/> <!-- TODO param löschen, Überreste von Code-Kopie aus Internet -->
</portlet:renderURL>

<%if(permission_to_add_picture || permission_to_add_marker){%>
	<aui:button name="button_show_map_manual" value="help"
		style="width: 90px; float: left;" />
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
								}
							}).plug(A.Plugin.IO,{autoLoad: false}).render();
						popUpWindow.show();
						popUpWindow.titleNode.html("Hilfe f&uuml;r Karte");
						popUpWindow.io.set('uri','<%= manualRenderURL %>');
						popUpWindow.io.start();
					}
				);
			}
		);
</aui:script>
<%}%>

<script>
	function hideAllActionControls(){
		AUI().use('aui-base', function(A){
			
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
		AUI().use('aui-base', function(A){
			A.one('#<portlet:namespace />button-do-marker').show();
			A.one('#<portlet:namespace />marker-controls-set').show();
			A.one('#<portlet:namespace />marker-controls-fix').show();
			A.one('#<portlet:namespace />marker-controls-delete').show();
			A.one('#<portlet:namespace />marker-controls-end').show();
			A.one('#<portlet:namespace />button_set_marker').set('value',"setzen");
		});
	}
	
	function showPictureControls(){
		AUI().use('aui-base', function(A){
			A.one('#<portlet:namespace />image-controls').show();
		});
	}
</script>

<!-------------------------------------- BUTTON DO MARKER ----------------------------->
<div id="<portlet:namespace />button-do-marker" style="float: left;">
	<aui:button name="button_do_marker" value="Marker" style="width: 90px;" />
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
<div id="<portlet:namespace />button-do-image">
	<aui:button name="button_do_image" value="Overlay" style="width: 90px; float:left;" />
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
<br />
<div id="<portlet:namespace />marker-controls-set"
	style="display: inline-block;" />
<!-- TODO: internationalize -->
<aui:button name="button_set_marker" value="setzen" style="width: 90px; float: left;" />
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
<div id="<portlet:namespace />marker-controls-fix"
	style="display: inline-block; float:left;" />
<!-- TODO: internationalize -->
<!-- TODO (Review 13.08.2014/mje): Selbst bei einem dirty hack hättest du hier über css klassen und externe styles nachdenken können - oder?
Ich sag nur:copy - past "style=width: 90px;" -->
<aui:button name="button_fix_marker" value="fixieren"
	style="width: 90px;" />
</div>
<aui:script use="aui-base,liferay-portlet-url,aui-io-plugin-deprecated,liferay-util-window">
	var button = A.one('#<portlet:namespace />button_fix_marker');
	button.on('click', function() {
		var portletURL = new Liferay.PortletURL('RENDER_PHASE');
		portletURL.setPortletId('<%=portletDisplay.getId()%>');
		portletURL.setPortletMode('VIEW');
		portletURL.setSecure(window.location.protocol == 'https:');
		portletURL.setWindowState('<%=LiferayWindowState.EXCLUSIVE.toString()%>');
		portletURL.setParameter('jspPage','/jsp/addMarker.jsp');
		portletURL.setParameter('lon',marker_add_lon);
		portletURL.setParameter('lat',marker_add_lat);
	        
    var popUpWindow=Liferay.Util.Window.getWindow({
        dialog: {          
          width: 500,
          centered: true,
          draggable: true,
          resizable: true,
          modal: false
        },
        id: '<portlet:namespace />dialog_add_marker',
        title: 'Marker hinzuf&uuml;gen'
      }).plug(A.Plugin.IO, {autoLoad: false}).render();
	    popUpWindow.show();	    
	    popUpWindow.io.set('uri', portletURL.toString());
	    popUpWindow.io.start();
  });
</aui:script>

<!-------------------------------------- BUTTON delete MARKER ----------------------------->
<div id="<portlet:namespace />marker-controls-delete"
	style="display: inline-block;">
	<aui:button name="button_delete_marker" value="löschen"
		style="width: 90px; float:left" />
</div>
<aui:script use="aui-io-request-deprecated">	
	var button = A.one('#<portlet:namespace />button_delete_marker');	
	button.on('click', function() {	
    A.io.request('<%=eventHandlerURL%>', {
      method: 'POST',
      dataType: 'json',
      data: {
        <portlet:namespace/>action: 'deleteMarker',
        <portlet:namespace/>markerId: toDeleteMarkerId
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
<div id="<portlet:namespace />marker-controls-end"
	style="display: inline-block;">
	<aui:button name="button_end_marker" value="&lt;&lt; zur&uuml;ck" style="width: 90px;" />
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
	<aui:button name="button_end_picture" value="&lt;&lt; zur&uuml;ck" style="width: 90px;" />
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
	<br />
		
	<div id="left-picture-controls">
		<!-------------------------------------- FILE upload ----------------------------->
		<span  class="boldInstructions">
			1.
			<%=LanguageUtil.get(pageContext, "upload-picture-drawing")%>:
		</span>
		<aui:form name="fm" action="<%=fileUploadURLString%>" method="post"
			enctype="multipart/form-data">
			<aui:input type="file" name="form_file" label="" size="40" />
			<aui:button type="submit" name="form_upload_button" value="Hochladen" />
		</aui:form>
	
		<aui:script use="aui-io-request-deprecated">
			A.one('#<portlet:namespace />form_upload_button').on('click',function(){
				
					var file_path =A.one('#<portlet:namespace />form_file_path').get('value');
					A.io.request('<%=fileUploadURL%>', {
						method: 'POST',
						dataType:'json',
				      contentType:'multipart/form-data',
				      data: {
				       <portlet:namespace/>file: form_file,
				      },
				      on: {
				       	success: function() {
				       		alert('upload successful');
				       	}
				      }
				  });
			  });     
		</aui:script>
	
		<span  class="boldInstructions">
			2.
			<%=LanguageUtil.get(pageContext, "choose-picture-drawing")%>:
		</span>
		<aui:form>
			<aui:select name="pictureSelect" label=""
				onchange="javascript:setPicture(this.value)">
	
				<aui:option value='none'>
						&minus;bitte Ausw&auml;hlen&minus;
		</aui:option>
	
				<%
				    for(FileEntry entry: portletFolderFiles){
				%>
				<aui:option value='<%=entry.getUuid()%>'>
					<%=entry.getTitle()%>
				</aui:option>
				<%
				    }
				%>
			</aui:select>
		</aui:form>
	</div>
	<div id="right-picture-controls">
	
		<span class="boldInstructions">
			3.
			<%=LanguageUtil.get(pageContext, "align-overlay")%>:
		</span>
		<table>
			<tr>
	
				<td><%=LanguageUtil.get(pageContext, "width")%>:</td>
				<td><aui:button name="increasePictureWithBig" value="++"
						onClick="increasePictureWith(10)" style="width: 30px;" /> <aui:button
						name="increasePictureWith" value="+"
						onClick="increasePictureWith(1)" style="width: 30px;" /> <aui:button
						name="decreasePictureWith" value="-"
						onClick="decreasePictureWith(1)" style="width: 30px;" /> <aui:button
						name="decreasePictureWithBig" value="--"
						onClick="decreasePictureWith(10)" style="width: 30px;" />
			</tr>
			<tr>
				<td><%=LanguageUtil.get(pageContext, "height")%>:</td>
				<td><aui:button name="increasePictureHeightBig" value="++"
						onClick="increasePictureHeight(10)" style="width: 30px;" /> <aui:button
						name="increasePictureHeight" value="+"
						onClick="increasePictureHeight(1)" style="width: 30px;" /> <aui:button
						name="decreasePictureHeight" value="-"
						onClick="decreasePictureHeight(1)" style="width: 30px;" /> <aui:button
						name="decreasePictureHeightBig" value="--"
						onClick="decreasePictureHeight(10)" style="width: 30px;" /></td>
			</tr>
			<tr>
				<td><%=LanguageUtil.get(pageContext, "angle")%>:</td>
				<td><aui:button name="rotatePictureLeftBig" value="&lt;&lt;"
						onClick="rotatePictureToLeft(10)" style="width: 30px;" /> <aui:button
						name="rotatePictureLeft" value="&lt;"
						onClick="rotatePictureToLeft(1)" style="width: 30px;" /> <aui:button
						name="rotateLictureRight" value="&gt;"
						onClick="rotatePictureToRight(1)" style="width: 30px;" /> <aui:button
						name="rotateLictureRightBig" value="&gt;&gt;"
						onClick="rotatePictureToRight(10)" style="width: 30px;" /></td>
			</tr>
			<tr>
				<td><%=LanguageUtil.get(pageContext, "transparency")%>:</td>
				<td><aui:button name="decreaseOpacity" value="+"
						onClick="decreaseOpacity()" style="width: 30px;" /> <aui:button
						name="increaseOpacity" value="-" onClick="increaseOpacity()"
						style="width: 30px;" /></td>
		</table>
		<span class="boldInstructions">
			4.
			<%=LanguageUtil.get(pageContext, "position")%>:
		</span>
		<aui:button name="fixPicture" value="fix-overlay" />
	
		<aui:script use="aui-oi-request">
	     
	     A.one('#<portlet:namespace />fixPicture').on('click', function(event){
	     
	     	var portletURL = new Liferay.PortletURL('RENDER_PHASE');
			portletURL.setPortletId('<%=portletDisplay.getId()%>');
			portletURL.setPortletMode('VIEW');
			portletURL.setSecure(window.location.protocol == 'https:');
			portletURL.setWindowState('<%=LiferayWindowState.EXCLUSIVE.toString()%>');
			portletURL.setParameter('jspPage','/jsp/addPicture.jsp');
			portletURL.setParameter('map_picture_width',theWidth);
			portletURL.setParameter('map_picture_height',theHeight);
			portletURL.setParameter('map_picture_xpos',pictureAddVectorLayer.features[0].geometry.x);
			portletURL.setParameter('map_picture_ypos',pictureAddVectorLayer.features[0].geometry.y);
			portletURL.setParameter('map_picture_resolution', map.getResolution());
			portletURL.setParameter('map_picture_rotation',theRotation);
			portletURL.setParameter('map_picture_opacity',theOpacity);
			portletURL.setParameter('map_picture_fileuuid',thePictureFileUuid);
			
			var popUpWindow=Liferay.Util.Window.getWindow(
				{
					dialog: {
						width: 500,
			            centered: true,
			            draggable: true,
			            resizable: false,
			            modal: false
					},
					id: '<portlet:namespace />dialog_add_picture',
					title: 'Bild hinzuf&uuml;gen'
				}).plug(A.Plugin.IO,{autoLoad: false}).render();
			popUpWindow.show();
			popUpWindow.io.set('uri',portletURL.toString());
			popUpWindow.io.start();
		});
	     
		
		</aui:script>
	</div>
	<br />
	<br/>
	<span class="boldInstructions">
		<%=LanguageUtil.get(pageContext, "remove-overlay")%>:
	</span> <br />
	<div id="remove-picture-container">
		<aui:select name="remove_picture" label="" onchange="" >
			<%
			    for(Picture picture: backgroundPictureList){
			%>
			<%
			    if(picture.getUserId() == themeDisplay.getUserId()
						|| is_moderator_or_admin) {
			%>
			<aui:option value='<%=picture.getPictureId()%>'>
				<%=picture.getName()%>
			</aui:option>
			<%
			    }
			%>
			<%
			    }
			%>
		</aui:select>
	</div>

	<aui:button type="submit" name="button_remove_picture" value="remove" />

	<aui:script use="aui-io-request-deprecated">
	
	var pictureIDtoPictureName = {};
	<%
	    for(Picture picture: backgroundPictureList){
	%>
		pictureIDtoPictureName[<%=picture.getPictureId()%>] = '<%=picture.getName()%>';
	<%
	    }
	%>

	A.one('#<portlet:namespace />button_remove_picture').on('click',function(){
	
		var remove_picture_id =A.one('#<portlet:namespace />remove_picture').get('value');
		A.io.request('<%=eventHandlerURL%>', {
			method: 'POST',
      dataType: 'json',
      data: {
    		<portlet:namespace/>action: 'deletePicture',
    		<portlet:namespace/>remove_picture_id: remove_picture_id,
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

<!-- TODO (Review 13.08.2014/mje): Warum nutzt du hier aui-io-plugin-deprecated und weiter oben aui-io-plugin? Bitte vereinheitlichen -->
<script>
	function showPictureDetailPopupWithContent(name,userName,description,link){
		
		AUI().use('aui-base','aui-io-plugin-deprecated','liferay-util-window',
				function(A) {
						
						var portletURL = new Liferay.PortletURL('RENDER_PHASE');
						portletURL.setPortletId('<%=portletDisplay.getId()%>');
						portletURL.setPortletMode('VIEW');
						portletURL.setSecure(window.location.protocol == 'https:');
						portletURL.setWindowState('<%=LiferayWindowState.EXCLUSIVE.toString()%>');
						portletURL.setParameter('jspPage', '/jsp/pictureDetailsPopup.jsp');
						portletURL.setParameter('userName', userName);
						portletURL.setParameter('description', description);
						portletURL.setParameter('link', link);
						var popUpWindow=Liferay.Util.Window.getWindow(
								{
									dialog: {
										centered : true,
										modal : false,
										width : 200,
										height : 200
									}
								}).plug(A.Plugin.IO,{autoLoad: false}).render();
							popUpWindow.show();
							// TODO (Review 13.08.2014/mje): Warum setzt du den Titel hier anders (vgl. oben)?
							popUpWindow.titleNode.html(name);
							popUpWindow.io.set('uri',portletURL.toString());
							popUpWindow.io.start();
						}
			);
	}
</script>

<%
    if (backgroundPictureList.size() >= 1) {
%>

<br />
<br />
<%=LanguageUtil.get(pageContext, "show-overlay")%>:<%
    for (Picture picture : backgroundPictureList) {
%>
<input
	style="margin-left: 15px; background-color: #aaa; width: 20px; border: 6px solid #ddd; display: inline-block;"
	type="checkbox" checked="checked" name="<%=picture.getName()%>"
	id="<%=picture.getName()%>"
	onClick="map.getLayersByName('<%=picture.getName()%>')[0].setVisibility(this.checked);">
<a href="#"
	onclick="showPictureDetailPopupWithContent('<%=picture.getName()%>','<%=UserLocalServiceUtil.getUserById(picture.getUserId()).getFullName()%>','<%=picture.getDescription()%>','<%=picture.getReferenceUrl()%>')">
	<%=picture.getName()%>
</a>
<%
    }
%>
<%
    }
%>
</br>
</br>
<div id="viewMap" style="width: 100%; height: 600px;"></div>
<aui:script use="aui-base">

	hideAllActionControls();
	
	<%if (permission_to_add_marker) {%>
		AUI().use(function(A){A.one('#<portlet:namespace />button-do-marker').show();});
	<%}%>
	<%if (permission_to_add_picture) {%>
		AUI().use(function(A){A.one('#<portlet:namespace />button-do-image').show();});
	<%}%>

	<!-- 	init the map + transfer namespace to javascript -->
	initMap('<portlet:namespace />','view');
	
	<%for (Picture picture : backgroundPictureList) {%>
		addPictureOverlay('<%=picture.getName()%>', 
						'<%=picture.getPictureUrl()%>', 
						'<%=picture.getOcupacy()%>',
						'<%=picture.getRotation()%>',
						'<%=picture.getLongitude()%>', 
						'<%=picture.getLatitude()%>',
						'<%=picture.getWidth()%>',
						'<%=picture.getHeight()%>',
						'<%=picture.getPictureId()%>');
	<%}%>

	<%for (Marker marker : backgroundMarkerList) {%>
				addMarkerToDatabaseLayer('<%=marker.getMarkerId()%>',
										'<%=marker.getLongitude()%>',
										'<%=marker.getLatitude()%>',
										'<%=UserLocalServiceUtil.getUserById(marker.getUserId()).getFullName()%> ',
										'<%=themeDisplay.getUserId() == marker.getUserId()%>',
										'<%=marker.toHTMLFormatedString()%>',
										'<portlet:namespace />');
	
	<%}%>



</aui:script>


