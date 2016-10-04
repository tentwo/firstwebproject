function getTemplateSync(myUrl) {
    return $.get({
        url:myUrl,
        dataType:"text",
        success: function(data){
        },
        async:false
    }).responseText;
}

function getTemplateAsync(myUrl) {
    return $.get({
        url:myUrl,
        dataType:"text",
        success: function(data){
        },
        async:true
    }).responseText;
}
