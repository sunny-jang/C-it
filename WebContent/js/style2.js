//join
$(document).ready(function(){
  $('#checkIdDup').css('display', 'none');
$('#id').change(function(){
  var value=$('#id').val().trim();
  var reg= /^[A-za-z0-9]{6,16}$/g;
  if(reg.test(value)){
    $('#checkIdDup').html("O 6자 이상의 영문 혹은 영문+숫자 조합");    
     $('#checkIdDup').css({'display': 'block', 'color': 'green', 'width':'300px', 'height':'40px',
  'text-align':'center', 'font-weight':'700'});
  }else {          
    $('#checkIdDup').html("X 6자 이상의 영문 혹은 영문+숫자 조합");
    $('#checkIdDup').css({'display': 'block', 'color': 'red', 'width':'300px', 'height':'40px',
  'text-align':'center', 'font-weight':'700'});
  }
  });  
})

// notice_list_admin
$(document).ready(function() {
    $(".accordion_head").click(function() {
        let icon = $(this).children('#plus');
        let body = $(this).next(".accordion_body");
        let minusClass = 'fa-minus-square';
        let plusClass = 'fa-plus-square';
        
        icon.removeClass(minusClass);
        icon.removeClass(plusClass);
  
      if (body.is(':visible')) {
        body.slideUp(300);
        icon.addClass(plusClass);
      } else {
        body.slideDown(300);
        icon.addClass(minusClass);
      }
    });
  }); 
  
