var i,j,k;
$('.btn').attr("disabled", true);
$('#exampleInputText1').keyup(function (){
	
	$('#exampleInputText1').myProValidation("textExpression",{
		// "regex": "^[A-Z]\\w+",
		"correct": function (that) {
			i=1;
			$(that).parent().addClass("has-success");
			$(that).parent().removeClass("has-error");
			if(i+j+k === 3){
				$('.btn').attr("disabled", false);
				$('.btn').addClass("btn-success");
				$('.btn').removeClass("btn-danger");
			} else {
				$('.btn').attr("disabled", true);
				$('.btn').addClass("btn-danger");
				$('.btn').removeClass("btn-success");
			}
		},
		"uncorrect": function (that){
			i=0;
			$(that).parent().addClass("has-error");
			if(i+j+k === 3){
				$('.btn').attr("disabled", false);
				$('.btn').addClass("btn-success");
				$('.btn').removeClass("btn-danger");
			} else {
				$('.btn').attr("disabled", true);
				$('.btn').addClass("btn-danger");
				$('.btn').removeClass("btn-success");
			}
		}
	});

});

$('#exampleInputEmail1').keyup(function (){

	$('#exampleInputEmail1').myProValidation("emailExpression",{
         "correct": function (that) {
         	j=1;
         	$(that).parent().addClass("has-success");
			$(that).parent().removeClass("has-error");
			if(i+j+k === 3){
				$('.btn').attr("disabled", false);
				$('.btn').addClass("btn-success");
				$('.btn').removeClass("btn-danger");
			} else {
				$('.btn').attr("disabled", true);
				$('.btn').addClass("btn-danger");
				$('.btn').removeClass("btn-success");

			}
		},
		"uncorrect": function (that){
			j=0;
			$(that).parent().addClass("has-error");
			if(i+j+k === 3){
				$('.btn').attr("disabled", false);
				$('.btn').addClass("btn-success");
				$('.btn').removeClass("btn-danger");
			} else {
				$('.btn').attr("disabled", true);
				$('.btn').addClass("btn-danger");
				$('.btn').removeClass("btn-success");
			}
		}
	});

});

$('#exampleInputPassword1').keyup(function (){

	$('#exampleInputPassword1').myProValidation("passwdExpression",{
		"small": true,
		"big": true,
		"digit": true,
		"correct": function (that) {
			k=1;
			$(that).parent().removeClass("has-error");
			$(that).parent().addClass("has-success");
			if(i+j+k === 3){
				$('.btn').attr("disabled", false);
				$('.btn').addClass("btn-success");
				$('.btn').removeClass("btn-danger");
			} else {
				$('.btn').attr("disabled", true);
				$('.btn').addClass("btn-danger");
				$('.btn').removeClass("btn-success");
			}
		},
		"uncorrect": function (that){
			k=0;
			$(that).parent().addClass("has-error");
			if(i+j+k === 3){
				$('.btn').attr("disabled", false);
				$('.btn').addClass("btn-success");
				$('.btn').removeClass("btn-danger");
			} else {
				$('.btn').attr("disabled", true);
				$('.btn').addClass("btn-danger");
				$('.btn').removeClass("btn-success");
			}
		}
	});
});