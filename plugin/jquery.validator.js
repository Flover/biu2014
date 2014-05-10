(function($) {

	var methods = {
		init : function() {
			console.log("init: ");
		},
		regexp: function(options){
		//	console.log("regexp");

			return this.each(function (){

				var isCorrect = true;
				var val = $(this).val();
				var pat;

				if(options.patt){
					pat = new RegExp(options.patt);
					console.log("only patt");
					}
					if(!pat.test(val)){
						isCorrect = false;
					}
				
				if(isCorrect){
					options.correct(this);
				} else {
					options.uncorrect(this);
				}
			});
		},


		textExpression : function(options) {
			
				var isCorrect = true;

				var settings = $.extend({
					"patt": "[A-Za-z]\\w+"}, options);
			return methods.regexp.call(this, settings)
		},
		emailExpression: function(options) {
			//console.log("emailExpression: " + options);
			var isCorrect = true;

			var settings = $.extend({
				"patt": "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." +
				"[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@" +
		        "(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+" +
		        "[a-z0-9](?:[a-z0-9-]*[a-z0-9])?"}, options);

			return methods.regexp.call(this, settings);

		},

		passwdExpression: function(options){

		}

	};

	$.fn.myProValidation = function(method) {
		
		// Method calling logic
		if (methods[method]) {
			return methods[method].apply(this, Array.prototype.slice.call(
					arguments, 1));
		} 
		 else if (typeof method === 'object' || !method) {
			return methods.init.apply(this, arguments);
		} 
		else {
			$.error('Method ' + method + ' does not exist on jQuery.myProValidation');
		}

	};

})(jQuery);