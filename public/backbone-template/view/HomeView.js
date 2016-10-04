var HomeView = Backbone.View.extend({
	model: StoreModel,
	myCollection: null,
	template: null,
	el: null,
	// bindings: {
	// },
	initialize: function(params){
		console.log("HomeView");
		this.template = params.template; 
		this.myCollection = new StoreCollection();
		var _this = this;
		this.myCollection.fetch({
			success: function (collection, response) {
				// fetch successful, lets iterate and update the values here
				console.log("after load");
				console.log(response);
				_.each(response, function (item) {
					console.log("item");
					console.log(item);
					var todo = new StoreModel(item);
					console.log(item);
					// Add to collection
					collection.add(todo);
					console.log(collection.length());

					// item.set("BookName", item.get("BookName") + "_updated"); // lets update all book names here
					// item.save();
				});
			}, async:false
		});
		// this.myCollection.bind('reset', this.render)
		// this.myCollection.fetch();
		console.log("after fetch");
		console.log("collection");
		console.log(this.myCollection);
		console.log(this.myCollection.toJSON());
		this.render();
		var that = this;
		// $.getScript( "assets/backbone-template/view/TileView.js",
		// 	function( data, textStatus, jqxhr ) {
		// 		that.tile1 = new TileView({
		// 			model: that.model,
		// 			template: getTemplateSync("assets/html-template/tile.ust"),
		// 			el: $("#tile-continer")
		// 		});
		// 		that.tile2 = new TileView({
		// 			model: that.model,
		// 			template: getTemplateSync("assets/html-template/tile.ust"),
		// 			el: $("#tile-continer")
		// 		});
		// 	}
		// );
	},
    render: function() {
		this.$el.html(_.template(this.template)({"storeCollection": this.myCollection.toJSON()}));
		$(document).foundation();
		return this;
	}
});