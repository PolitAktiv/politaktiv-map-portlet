 //------------------------------ SHOW / HIDE CONTROLS ----------------------------- 
function hideAllActionControls(){
  AUI().use(function(A){
    //A.one('#<portlet:namespace />button-do-image').hide();
    A.one('#<portlet:namespace />button-do-marker').hide();
    //A.one('#<portlet:namespace />picture-controls').hide();
    A.one('#<portlet:namespace />marker-controls-set').hide();
    A.one('#<portlet:namespace />marker-controls-fix').hide();
    //A.one('#<portlet:namespace />marker-controls-delete').hide();
    A.one('#<portlet:namespace />marker-controls-end').hide(); 
    //-- der Zurück-Button --
  });
}

function showMarkerControls(){
  AUI().use(function(A){
    A.one('#<portlet:namespace />button-do-marker').show();
    A.one('#<portlet:namespace />marker-controls-set').show();
    A.one('#<portlet:namespace />marker-controls-fix').show();
    //A.one('#<portlet:namespace />marker-controls-delete').show();
    A.one('#<portlet:namespace />marker-controls-end').show();
    A.one('#<portlet:namespace />button_set_marker').set('value',"setzen");
  });
}

function showPictureControls(){
  AUI().use(function(A){
    //A.one('#<portlet:namespace />image-controls').show();
  });
}