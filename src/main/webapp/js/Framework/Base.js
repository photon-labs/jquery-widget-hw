/*global $, require */

// When the document is ready:
$().ready(function() {

	require( [ "Framework/LoginWidget" ], function( LoginWidget ) {
		var loginWidget; 

		loginWidget = new LoginWidget();
        loginWidget.HelloWorldText = "HelloWorld";
		loginWidget.setMainContent();
	});
});
