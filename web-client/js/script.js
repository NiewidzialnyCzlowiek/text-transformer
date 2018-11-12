function alert(alerttype, message) {
  $('#alert-placeholder').html('<div id="alertdiv" class="alert ' +  alerttype + '"><span>'+message+'</span></div>')
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

      $("#mainFormSubmit").prop('disabled', false);
      $.ajax({
             type: "POST",
            url: "http://localhost:8080/transform",
            contentType: "application/json",
            dataType: "json",
             data: JSON.stringify(req),
             success: function(data)
             {
               var alertText = '<p>A result was returned: </p><figure class="highlight"><pre><code>' + data.text + '</code></pre></figure>';
               alert('alert-success', alertText)
               $("#mainFormSubmit").prop('disabled', false);
             }
           }).fail(function($xhr) {
             var data = $xhr.responseJSON;
             var text = 'An error occured: ' + data.error;
             alert('alert-danger', text);
             $("#mainFormSubmit").prop('disabled', false);
           });

      e.preventDefault();
  });
});

function dataTransformationRemove(el) {
  $(el).parent().remove();
}
