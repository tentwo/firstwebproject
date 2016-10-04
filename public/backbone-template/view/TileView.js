var TileView = Backbone.View.extend({
	model: StoreModel,
	template: null,
	el: null,
	// bindings: {
	// 	"img#picture": "src:picture",
	// 	"p#title": "text:title",
	// 	"span#floor": "text:floor",
	// 	"span#number": "text:number",
	// 	"span#tel": "text:tel",
	// 	"span#mobile": "text:mobile",
	// 	"span#shopkeeper": "text:shopkeeper",
	// },
	initialize: function(params){
		console.log("HomeView");
		this.template = params.template; 
		this.render();
	},
    render: function() {
		console.log("render tile");
		console.log(this.model.toJSON());
		// var tmp = _.template(this.template);
		this.$el.html(_.template(this.template)	(this.model.toJSON()));
		$(document).foundation();
		return this;
	}
});