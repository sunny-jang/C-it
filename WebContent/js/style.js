//join
$(document).ready(function() {
	$('#msg').css('display', 'none');
	$('#id').change(function() {
		var value = $('#id').val().trim();
		var reg = /^[A-za-z0-9]{6,16}$/g;
		if (reg.test(value)) {
			$('#msg').html("O 6자 이상의 영문 혹은 영문+숫자 조합");
			$('#msg').css({
				'display' : 'block',
				'color' : 'green',
				'width' : '300px',
				'height' : '40px',
				'text-align' : 'center',
				'font-weight' : '700'
			});
		} else {
			$('#msg').html("X 6자 이상의 영문 혹은 영문+숫자 조합");
			$('#msg').css({
				'display' : 'block',
				'color' : 'red',
				'width' : '300px',
				'height' : '40px',
				'text-align' : 'center',
				'font-weight' : '700'
			});
		}
	});

	// notice_list_admin
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

	//메뉴모바일
	const toggleBtn = document.querySelector('.mobil_menu_icon');
	const menu = document.querySelector('#header_01');
	const mymenu = document.querySelector('#header_02');
	const header = document.querySelector('.header-wrap')

	toggleBtn.addEventListener('click', () => {
		menu.classList.toggle('active');
		mymenu.classList.toggle('active');
		header.classList.toggle('active');
	});
	
	//뉴스카테고리
	const category = $(".news_cate");
	
	category.on("click", function() {
		category.removeClass("active");
		$(this).addClass("active");
	});
})
