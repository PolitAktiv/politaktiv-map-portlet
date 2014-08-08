<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>

<portlet:defineObjects /> 
<liferay-theme:defineObjects />

<portlet:resourceURL  var="eventHandlerURL">
</portlet:resourceURL>

		
<aui:form>
	<aui:input name="map_picture_width" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_width")) %>' />
	<aui:input name="map_picture_height" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_height")) %>' />
	<aui:input name="map_picture_xpos" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_xpos")) %>' />
	<aui:input name="map_picture_ypos" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_ypos")) %>' />
	<aui:input name="map_picture_rotation" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_rotation")) %>' />
	<aui:input name="map_picture_resolution" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_resolution")) %>' />
	<aui:input name="map_picture_opacity" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_opacity")) %>' />
	<aui:input name="map_picture_fileuuid" type="hidden" value='<%= HtmlUtil.escape(request.getParameter("map_picture_fileuuid")) %>' />
	
	<aui:input name="form_input_name" type="text" label="Bildertitel*" style="width: 100px" />
	<aui:input name="form_input_description" type="text" label="Beschreibung*" style="width: 450px" />
	<aui:input name="form_input_link" type="text" label="Link*" value="http://" style="width: 450px" />
	<aui:button name="button_add_picture" type="button" value="Speichern" />
</aui:form>


	


<aui:script use="aui-oi-request-deprecated">
	A.one('#<portlet:namespace />button_add_picture').on('click',function(){
	
		var map_picture_width = A.one('#<portlet:namespace />map_picture_width').get('value');
		var map_picture_height = A.one('#<portlet:namespace />map_picture_height').get('value');
		var map_picture_xpos = A.one('#<portlet:namespace />map_picture_xpos').get('value');
		var map_picture_ypos = A.one('#<portlet:namespace />map_picture_ypos').get('value');
		var map_picture_resolution = A.one('#<portlet:namespace />map_picture_resolution').get('value');
		var map_picture_rotation = A.one('#<portlet:namespace />map_picture_rotation').get('value');
		var map_picture_opacity = A.one('#<portlet:namespace />map_picture_opacity').get('value');
		var map_picture_fileuuid = A.one('#<portlet:namespace />map_picture_fileuuid').get('value');
		
		var input_name = A.one('#<portlet:namespace />form_input_name').get('value');
		var input_description = A.one('#<portlet:namespace />form_input_description').get('value');
		var input_link = A.one('#<portlet:namespace />form_input_link').get('value');
		A.io.request('<%= eventHandlerURL %>', {
      method: 'POST',
        dataType: 'json',
        data: {
          <portlet:namespace/>action: 'addPicture',
          <portlet:namespace/>map_picture_width : map_picture_width,
          <portlet:namespace/>map_picture_height : map_picture_height,
          <portlet:namespace/>map_picture_xpos : map_picture_ypos,
          <portlet:namespace/>map_picture_ypos : map_picture_xpos,
          <portlet:namespace/>map_picture_resolution : 5.5,
          <portlet:namespace/>map_picture_rotation : map_picture_rotation,
          <portlet:namespace/>map_picture_opacity : map_picture_opacity,
          <portlet:namespace/>map_picture_fileuuid : map_picture_fileuuid,
          <portlet:namespace/>map_picture_name : input_name,
          <portlet:namespace/>map_picture_description : input_description,
          <portlet:namespace/>map_picture_link : input_link
        },
        on: {
          success: function() {
            var result = this.get('responseData');
            if(isNaN(result)){
              alert('Falsche Eingabe: ' + result);
            } else {
              A.one('#<portlet:namespace />dialog_add_picture').hide();
              Liferay.Portlet.refresh('#p_p_id<portlet:namespace />');
            }
          }
        }
      });
   });
</aui:script>



