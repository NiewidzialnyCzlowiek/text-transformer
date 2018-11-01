function alert(alerttype, message) {
  $('#alert-placeholder').html('<div id="alertdiv" class="alert ' +  alerttype + '"><a class="close" data-dismiss="alert">×</a><span>'+message+'</span></div>')
}


$( document ).ready(function() {
    $("ul#transformations").sortable();

    $( "li.new-tf a" ).each(function(index) {
        $(this).on("click", function(){
            var newEl = "<li>" + $(this).attr("data-transformation") + "<a class='data-transformation-remove btn btn-danger btn-sm' onclick='dataTransformationRemove(this);'><span class='glyphicon glyphicon-remove'></span></a></li>";
            $( "ul#transformations").append(newEl);
        });
    });

    $( "#text" ).keyup(function () {
      $( "#char-count" ).html(this.value.length);
    });

    $("#mainForm").submit(function(e) {

      var form = $(this);
      var url = form.attr('action');

      var req = {};

      req.text = $( "#text" ).val();
      if ($("#repetition_del").prop('checked')) {
        req.repetition_del = true;
      }
      if ($("#num_to_text").prop('checked')) {
        req.num_to_text = true;
      }
      if ($("#expand").prop('checked')) {
        req.expand = true;
      }
      if ($("#shrink").prop('checked')) {
        req.shrink = true;
      }
      if ($("#latex").prop('checked')) {
        req.latex = true;
      }

      req.transformations = [];

      $( "ul#transformations li" ).each(function( index ) {
        req.transformations.push($(this).text());
      });

      console.log(req);
      $("#mainFormSubmit").prop('disabled', true);
      alert('alert-info', 'Awaiting server response...');
      /*$.ajax({
             type: "POST",
             url: url,
             data: JSON.stringify(req),
             success: function(data)
             {
                 alert(data); //TODO
             }
           });*/


      e.preventDefault(); // avoid to execute the actual submit of the form.
  });
});

function dataTransformationRemove(el) {
  $(el).parent().remove();
}
