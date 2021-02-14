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
  
  