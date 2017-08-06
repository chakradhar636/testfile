
    function scroll_to_class(element_class, removed_height) {
	var scroll_to = $(element_class).offset().top - removed_height;
	if($(window).scrollTop() != scroll_to) {
		$('html, body').stop().animate({scrollTop: scroll_to}, 0);
	}
}

function bar_progress(progress_line_object, direction) {
	var number_of_steps = progress_line_object.data('number-of-steps');
	var now_value = progress_line_object.data('now-value');
	var new_value = 0;
	if(direction == 'right') {
		new_value = now_value + ( 100 / number_of_steps );
	}
	else if(direction == 'left') {
		new_value = now_value - ( 100 / number_of_steps );
	}
	progress_line_object.attr('style', 'width: ' + new_value + '%;').data('now-value', new_value);
}

jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch("assets/img/backgrounds/1.jpg");
    
    $('#top-navbar-1').on('shown.bs.collapse', function(){
    	$.backstretch("resize");
    });
    $('#top-navbar-1').on('hidden.bs.collapse', function(){
    	$.backstretch("resize");
    });

    /*
        Form
    */
    $(function() {
        $("#f1-date").minDate=0;
       });

    $('.f1 fieldset:first').fadeIn('slow');
    
    $('.f1 input[type="text"], .f1 input[type="password"], .f1 textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });

    $('.f1 #f1-date').on('blur',function(){

   // alert($('.f1 #f1-date').val())
    var date= new Date();
    var d=$('.f1 #f1-date').val().split("-");
    if(Number(d[2])>=date.getDate()&&Number(d[1])>=date.getMonth()&&Number(d[0])>=date.getFullYear()){

        $.post("assets/js/getCheck.jsp",{
            date:$('.f1-date').val()
        },function (data) {
            // alert(data.indexOf("false"));
            console.log(data);
            if(data.indexOf("true")>=0){
                console.log("in iff"); //+document.getElementById("btn1").isDisabled);
                //$("#btn1").prop( "disabled", false );
                document.getElementById("btn1").disabled = false;
            }else{
                console.log("in elsee");
                $('#alert').show();
            }
            console.log("in after function")
        });
    }
    else{
        $('#alert').show();

    }

	});

    // // next step
    // $('.f1 #btn1').on('click', function() {
    //
    //     var parent_fieldset = $(this).parents('fieldset');
    // 	var next_step = true;
    // 	// navigation steps / progress steps
    // 	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    // 	var progress_line = $(this).parents('.f1').find('.f1-progress-line');
    //
    // 	parent_fieldset.find('input[type="text"], input[type="password"], textarea').each(function() {
    // 		if( $(this).val() == "" ) {
    // 			$(this).addClass('input-error');
    // 			next_step = false;
    // 		}
    // 		else {
    // 			$(this).removeClass('input-error');
    // 		}
    // 	});
    // 	// fields validation
    //
    // 	if( next_step ) {
    //
    //
    // 		parent_fieldset.fadeOut(400, function() {
    // 			// change icons
    // 			current_active_step.removeClass('active').addClass('activated').next().addClass('active');
    // 			// progress bar
    // 			bar_progress(progress_line, 'right');
    // 			// show next step
	 //    		$(this).next().fadeIn();
	 //    		// scroll window to beginning of the form
    // 			scroll_to_class( $('.f1'), 20 );
	 //    	});
    // 	}
    //
    // });

    $('#pickUp').on('click',function () {
        $('.f1 #addr').show();
        $(".f1 #addr #f1-house-no").val("");
        $(".f1 #addr #f1-street-name").val("");
        $(".f1 #addr #f1-state").val("");
        $(".f1 #addr #f1-pin").val(0);

    });
    $('#driveIn').on('click',function () {
        $('.f1 #addr').show();
		$(".f1 #addr #f1-house-no").val("BuildingNO:12B");
		$(".f1 #addr #f1-street-name").val("RahejaMindSpace");
		$(".f1 #addr #f1-city").val("Hyderabad")
		$(".f1 #addr #f1-state").val("Telangana");
		$(".f1 #addr #f1-pin").val(500081);
    });

    $('.f1 .btn-next').on('click', function() {

        var parent_fieldset = $(this).parents('fieldset');
        var next_step = true;
        // navigation steps / progress steps
        var current_active_step = $(this).parents('.f1').find('.f1-step.active');
        var progress_line = $(this).parents('.f1').find('.f1-progress-line');

        // fields validation
        parent_fieldset.find('input[type="text"], input[type="password"],input[type="number"], textarea').each(function() {
            if( $(this).val() == "" ) {
                $(this).addClass('input-error');
                next_step = false;
            }
            else {
                $(this).removeClass('input-error');
            }
        });
        // fields validation

        if( next_step ) {
            parent_fieldset.fadeOut(400, function() {
                // change icons
                current_active_step.removeClass('active').addClass('activated').next().addClass('active');
                // progress bar
                bar_progress(progress_line, 'right');
                // show next step
                $(this).next().fadeIn();
                // scroll window to beginning of the form
                scroll_to_class( $('.f1'), 20 );
            });
        }

    });


    // previous step
    $('.f1 .btn-previous').on('click', function() {
    	// navigation steps / progress steps
    	var current_active_step = $(this).parents('.f1').find('.f1-step.active');
    	var progress_line = $(this).parents('.f1').find('.f1-progress-line');
    	
    	$(this).parents('fieldset').fadeOut(400, function() {
    		// change icons
    		current_active_step.removeClass('active').prev().removeClass('activated').addClass('active');
    		// progress bar
    		bar_progress(progress_line, 'left');
    		// show previous step
    		$(this).prev().fadeIn();
    		// scroll window to beginning of the form
			scroll_to_class( $('.f1'), 20 );
    	});
    });
    
    // submit
    $('#btn2').on('click', function(e) {
    	var i=0;
    	alert("in click");
        var parent_fieldset = $(this).parents('fieldset');
    	// fields validation
    	parent_fieldset.find('input[type="text"], input[type="number"],input[type="checkbox"]').each(function() {
    	      console.log("hii");
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    		    console.log("in else meaning not empty");
    		    i=1;
    			$(this).removeClass('input-error');
    		}
    	});
    	console.log(i);
    	if(i==1){
    	}
    	// fields validation
    	
    });
    var a="";
    $('#btn3').on('click',function(e) {
        var parent_fieldset = $(this).parents('fieldset');
        // fields validation

        parent_fieldset.find('input[type="checkbox"]').each(function() {
            if($(this). prop("checked") == true){
                a=a+$(this).val();
            }
        });
alert(a);
        });

    $('#btn4').on('click',function(e) {

        $('#nameField').val("Aditya");
        $('#phoneField').val(9999999999);
        $('#f1-date1').val($('.f1-date').val());
        var parent_fieldset = $(this).parents('fieldset');
        // fields validation

        parent_fieldset.find('input[type="checkbox"]').each(function() {
            if($(this). prop("checked") == true){
                a=a+$(this).val();
            }
        });


    });

    $('.f1').on('submit', function(e) {
     console.log("in submit");

        // fields validation
        $(this).find('input[type="text"], input[type="password"], textarea').each(function() {
            if( $(this).val() == "" ) {
                e.preventDefault();
                $(this).addClass('input-error');
            }
            else {
                $(this).removeClass('input-error');
            }
        });
        console.log("before addDetailse.jsp");
        $.post("assets/js/addDetails.jsp",{

            f1houseno:$('#f1-house-no').val(),
            f1streetname:$('#f1-street-name').val(),
            f1city:$('#f1-city').val(),
            f1state:$('#f1-state').val(),
            f1pin:$('#f1-pin').val(),
            f1firstname:$('#f1-first-name').val(),
            f1lastname:$('#f1-last-name').val(),
            f1aboutyourself:$('#f1-about-yourself').val(),
            f1email1:$('#f1-email1').val(),
            f1date:$('#f1-date').val()

        },function (data) {
            console.log("i am back to scripts")
        });
        $.post("assets/js/PushIds.jsp", {
            id: a,
            regno:$('.f1-first-name').val()
        },function (data) {
            console.log("back from pushids");
        });
        $.post("get.jsp",{
            date:$('.f1-date').val()
        },function (data) {
            // alert(data.indexOf("false"));
            console.log(data);
            if(data.indexOf("true")>=0){
                console.log("in iff"); //+document.getElementById("btn1").isDisabled);
                //$("#btn1").prop( "disabled", false );
                document.getElementById("btn1").disabled = false;
            }else{
                console.log("in elsee");
                $('#alert').show();
            }
            console.log("in after function")
        });

    // fields validation

    });
});
