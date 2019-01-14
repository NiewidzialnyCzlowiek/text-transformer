var mainForm = $("#mainForm");

function alert(alerttype, message) {
  $('#alert-placeholder').html('<div id="alertdiv" class="alert ' +  alerttype + '"><span>'+message+'</span></div>')
}

function submitForm(form) {
  var form = $(form);
  var url = form.attr('action');

  var req = {};

  var trans = $('#alert-dimmer');

  trans.addClass('active');

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
            trans.removeClass('active');
            if (data.text) {
              var alertText = '<p>A result was returned: </p><figure class="highlight"><pre><code id="output">' + data.text + '</code></pre></figure><p>It took: ' + data.time_nanos + ' nanoseconds.</p><a id="clipbtn" class="btn btn-success" onclick="copyToClipboard();">Copy to clipboard</a>';
              alert('alert-success', alertText)
            } else {
              alert('alert-danger', "Server is not responding.");
            }
            $("#mainFormSubmit").prop('disabled', false);

        },
        beforeSend: function(){
          $('.loader').show();
        },
        complete: function(){
          $('.loader').hide();
        }
        }).fail(function($xhr) {
          trans.removeClass('active');
          if ($xhr.responseJSON) {
            var data = $xhr.responseJSON;
            var text = 'An error occured: ' + data.error;
            alert('alert-danger', text);
          } else {
            alert('alert-danger', "Server is not responding.");
          } 
          $("#mainFormSubmit").prop('disabled', false);
        });
}

var transformationFullNames = {"upper": "Uppercase", "lower": "Lowercase", "capitalize": "Capitalize", "inverse": "Inverse", "pokemonize": "Pokemonize", "toCode": "To Code", "wordReverse": "Word Reverse"}

$( document ).ready(function() {
    $("ul#transformations").sortable({onDrop: function($item, container, _super) {submitForm(mainForm);_super($item, container);}});

    $( "li.new-tf a" ).each(function(index) {
      if ($(this).attr('id') == "random") {
        $(this).on("click", function(){
          var keys = Object.keys(transformationFullNames)
          var newEl = "<li>" + transformationFullNames[keys[ keys.length * Math.random() << 0]] + "<a class='data-transformation-remove btn btn-danger btn-sm' onclick='dataTransformationRemove(this);'><span class='glyphicon glyphicon-remove'></span></a></li>";
          $( "ul#transformations").append(newEl);
          submitForm(mainForm);
        });
      } else {
        $(this).on("click", function(){
          var newEl = "<li>" + transformationFullNames[$(this).attr("data-transformation")] + "<a class='data-transformation-remove btn btn-danger btn-sm' onclick='dataTransformationRemove(this);'><span class='glyphicon glyphicon-remove'></span></a></li>";
          $( "ul#transformations").append(newEl);
          submitForm(mainForm);
        });
      }
    });

    $( "#text" ).keyup(function () {
      $( "#char-count" ).html(this.value.length);
      submitForm(mainForm);
    });

    mainForm.submit(function(e) {
      submitForm(mainForm);
      e.preventDefault();
  });

  mainForm.change(function() {
    submitForm(this);
  })
});

function dataTransformationRemove(el) {
  $(el).parent().remove();
}


function getStarted() {
  $('#intro').fadeOut();
  setTimeout(function() {
    $('#mainForm').addClass('animate-fadeIn');
  }, 200);
}

function copyToClipboard() {
  var range = document.createRange();
  range.selectNode(document.getElementById("output"));
  window.getSelection().removeAllRanges();
  window.getSelection().addRange(range);
  document.execCommand("copy");
  var btn = $('#clipbtn');
  btn.html('Copied.');
  btn.attr("disabled", true);
}