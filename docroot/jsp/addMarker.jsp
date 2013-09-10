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

<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<portlet:defineObjects /> 
<liferay-theme:defineObjects />

<portlet:resourceURL  var="resourceURL">
</portlet:resourceURL>

<aui:form>
	<aui:input name="form_input_lon" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("lon")) %>' />
	<aui:input name="form_input_lat" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("lat")) %>' />
	<aui:input name="form_input_name" type="text" label="Markertitel*" style="width: 100px" />	
	<aui:input name="form_input_description" type="text" label="Beschreibung*" style="width: 450px" />
	<aui:input name="form_input_link" type="text" label="Link*" value="http://" style="width: 450px" />
	<aui:button name="button_add_marker" type="button" value="Speichern" />
</aui:form>


<aui:script use="aui-oi-request">
	A.one('#<portlet:namespace />button_add_marker').on('click',function(){
	
		var input_lon =A.one('#<portlet:namespace />form_input_lon').get('value');
		var input_lat = A.one('#<portlet:namespace />form_input_lat').get('value');
		var input_name = A.one('#<portlet:namespace />form_input_name').get('value');
		var input_description = A.one('#<portlet:namespace />form_input_description').get('value');
		var input_link = A.one('#<portlet:namespace />form_input_link').get('value');
		A.io.request('<%= resourceURL %>', {
						method: 'POST',
                        dataType: 'json',
                        data: {
                        		action: 'addMarker',
                            	lon : input_lon,
                            	lat : input_lat,
                            	name : input_name,
                            	description : input_description,
                            	link : input_link
                        },
                        on: {
                            	success: function() {
                            		var result = this.get('responseData');
                            		if(isNaN(result)){
                            			alert('Falsche Eingabe: ' + result);
                            		} else {
                            			A.DialogMask.hide();
                            			A.one('#<portlet:namespace />dialog_add_marker').hide();
                            			
										var html = 'Von ' + '<%= user.getFullName() %>:' + '<br />'
													+ '<h2>' + input_name + '</h2>' + input_description + '<br />'
													+ '<a href="' + input_link + '" target="_blank">Link</a>';
		
<!--                             								result == markerId -->
                            			addMarkerToDatabaseLayer(result,
											input_lon,
											input_lat,
											'<%= user.getFullName() %>',
											true,
											html,
											'<portlet:namespace />');
											
										hideAllActionControls();
										setButton("button_fix_marker", "disable", namespace);
										A.one('#<portlet:namespace />button-do-marker').show();
										A.one('#<portlet:namespace />button-do-image').show();
										addMarkersView.setVisibility(false);
                            		}
                            	}
                        }
                    });
     });
</aui:script>



