var StoreCollection = Backbone.Collection.extend({
    model: StoreModel,
    url: 'http://localhost:9000/stores'

    // initialize: function(){
    //     this.fetch({async:false,
    //         success: this.fetchSuccess,
    //         error: this.fetchError
    //     });
    // },
    //
    // fetchSuccess: function (collection, response) {
    //     _.each(response, function(i) {
    //         var todo = new StoreModel(i);
    //         // Add to collection
    //         _this.collection.add(todo);
    //         // Render
    //         // _this.render(todo);
    //     });
    //     console.log('Collection fetch success', response);
    //     console.log('Collection models: ', collection.models);
    // },
    //
    // fetchError: function (collection, response) {
    //     throw new Error("Books fetch error");
    // }
});