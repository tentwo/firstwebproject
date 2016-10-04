var BazarRouter = Backbone.Router.extend({
	storesView: null,
	initialize: function() {
	},
	routes: {
		"stores": "goStores",
	},
	goStores: function(){
		console.log("BazarRouter store");
		if (this.storesView == null) {
			var that = this;
			$.getScript( "assets/despina/bazar/backbone-template/view/StoresView.js",
				function( data, textStatus, jqxhr ) {
					that.storesView = new StoresView({
						el: $("#body"),
						template: getTemplateSync("assets/despina/bazar/html-template/Stores.ust")
					});
				}
			);
		}
		else{
			this.homeView.render();
		}
	}
});