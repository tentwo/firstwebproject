var StoresView = Backbone.View.extend({
	myCollection: null,
	template: null,
	el: null,
	bindings: {
	},
	initialize: function(params){
		console.log("StoreView");
		this.template = params.template; 
		this.myCollection = new StoreCollection();
		var _this = this;
		// this.myCollection.bind('reset', this.render)
		this.render();
	},
    render: function() {
		this.$el.html(_.template(this.template)({"storeCollection": this.myCollection.toJSON()}));
		$(document).foundation();
		return this;
	}
});