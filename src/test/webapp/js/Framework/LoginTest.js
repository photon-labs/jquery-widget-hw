/*global require */

require(  [ "jquery", "Framework/LoginWidget" ], function($, LoginWidget) {

	//var equal = QUnit.equal, expect = QUnit.expect, test = QUnit.test;

	/**
	 * Test that the setMainContent method sets the text in the category-widget
	 */
	module("LoginWidget.js;LoginWidget");
	test("Login widget unite test case.", function() {

		var loginWidget, output1;

		// Setup view and call method under test
		loginWidget = new LoginWidget();

		loginWidget.HelloWorldText = "HelloWorld";

		output1 = loginWidget.setMainContent();

		// Expect that the text was set on the expected element
		equal(output1.html(), "HelloWorld",	"Expected text not set in category-widget");
	});
});