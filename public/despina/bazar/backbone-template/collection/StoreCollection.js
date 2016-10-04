var StoreCollection = Backbone.Collection.extend({
    model: StoreModel,
    url: 'http://localhost:9000/stores',

    initialize: function(){
        this.fetch({
            success: this.fetchSuccess,
            error: this.fetchError,
            async:false
        });
    },

    fetchSuccess: function (collection, response) {
        _.each(collection.models, function(i) {
            console.log('Collection models: ', i.toJSON());
        });
    },

    fetchError: function (collection, response) {
        throw new Error("Books fetch error");
    }
});