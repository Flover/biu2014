(function($) {

	$.fn.inputText = function(options) {
		
		return this.each(function() {
			var settings = $.extend({
				text : "Podaj wartość"
			}, options);

			var defaultText = settings.text;
			$(this).val(defaultText);
			$(this).focus(function() {
				if ($(this).val() === defaultText) {
					$(this).val("");
				}
			});
			$(this).blur(function() {
				if ($(this).val() === "") {
					$(this).val(defaultText);
				}
			});
		});
	};

})(jQuery);