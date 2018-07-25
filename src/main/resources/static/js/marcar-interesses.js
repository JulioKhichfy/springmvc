(function($) {
	$(":checkbox").change(function () 
	 {
		var checkeds = new Array();
		$("input[name='festasMarcadas[]']:checked").each(function ()
		{
		   // valores inteiros usa-se parseInt
		   //checkeds.push(parseInt($(this).val()));
		   // string
		   checkeds.push( $(this).val());
		   
		});
		
		var footerDiv = $("#festasSelecionadas");
		footerDiv.empty();
		footerDiv.append("<h3><p>Festas que possuo interesse</p></h3>")
		for (var data in checkeds) {
			  console.log(data + ' = ' + checkeds[data]);
			  footerDiv.append("<h5><p>"+checkeds[data]+"</p></h5>");
		}
		
	 });
	
})(jQuery);
