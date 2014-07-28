
<!-- Vorläufige Auslagerung der Javascript Funktionen
	bisher ausgelagert: 
		- Hilfe-Button
 		 -->

<!-------------------------------------- BUTTON HELP ----------------------------->
 <portlet:renderURL var="manualRenderURL"
windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
<portlet:param name="mvcPath" 
value="/jsp/mapPortletManual.jsp"/>
<portlet:param name="message" value="Karten-Portlet"/> <!-- TODO param löschen, Überreste von Code-Kopie aus Internet -->
</portlet:renderURL>

<aui:script>
AUI().use('aui-base',
'aui-io-plugin-deprecated',
'liferay-util-window',
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
}}).plug(A.Plugin.IO,{autoLoad: false}).render();
popUpWindow.show();
popUpWindow.titleNode.html("Hilfe für Karte");
popUpWindow.io.set('uri','<%= manualRenderURL %>');
popUpWindow.io.start();

});
});
</aui:script>

