var PageContainerView = Backbone.Epoxy.View.extend({
	model: StoreModel,
	template: null,
	router: null,
	bindings: {
	},
	events: {
	},
	initialize: function(params){
		this.template = params.template;
		this.myCollection = params.myCollection;
		// console.log("model");
		// console.log(this.model);
		// console.log("myCollection");
		// console.log(this.myCollection.toJSON());
		this.router = new MarketRouter({model: this.model, myCollection: this.myCollection, parentPage: this});
		Backbone.history.start();
		this.router.navigate("home");
		this.render();
	},
	render: function() {
		this.$el.append(this.template);
		$(document).foundation();
	}
});