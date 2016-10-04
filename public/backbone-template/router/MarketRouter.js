var MarketRouter = Backbone.Router.extend({
	parentPage: null,
	homeView: null,
	initialize: function(params) {
		this.model = params.model;
		this.parentPage = params.parentPage;
		this.myCollection = params.myCollection;
		// console.log("this.parentPage");
		// console.log(this.myCollection.toJSON());
	},
	routes: {
		"home": "goHome",
	},
	goHome: function(){
		console.log("MarketRouter home");
		if (this.homeView == null) { 
			var that = this;
			console.log("HomeView is null");
			$.getScript( "assets/backbone-template/view/StoresView.js",
				function( data, textStatus, jqxhr ) {
					that.homeTemplate = data;
					that.homeView = new HomeView({
						el: $("#target"),
						model: that.model,
						myCollection: that.myCollection,
						template: getTemplateSync("assets/html-template/Stores.ust")
					});
				}
			);
		}
		else{
			console.log("HomeView is not null");
			this.homeView.render();
		}
	}
});