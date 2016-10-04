var StoreModel = Backbone.Epoxy.Model.extend({
    defaults:{
        // "id": null,
        // "title": null,
        // "shopCenterTitle": null,
        // "shopCenterId": null,
        // "storeTypeTitle": null,
        // "storeTypeId": null,
        // "floor": null,
        // "number": null,
        // "tel": null,
        // "mobile": null,
        // "shopkeeper": null,
        // "positiveVote": null,
        // "negativeVote": null,
        // "forMen": null,
        // "forWomen": null,
        // "picture": null
    },
    computeds: {
        fullName: function() {
            return this.get("email") +" "+ this.get("pword");
        }
    },
    urlRoot: 'http://localhost:9000/store'
});