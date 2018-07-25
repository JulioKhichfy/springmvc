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
			  footerDiv.append("<input type='hidden' class='dadosForm' value='checkeds[data]'/>");
		}
		
	 });
	
	 /*  Submit form using Ajax */
	   $("#enviarPedido").click(function(e) {
	   
	      //Prevent default submission of form
	      e.preventDefault();
	      
	      //Remove all errors
	      $('input').next().remove();
	      
	      $.post({
	         url : 'pedido',
	         data : $('form[name=pedidoForm]').serialize(),
	         success : function(res) {
	         
	            if(res.validated){
	               //Set response
	               $('#resultContainer pre code').text(JSON.stringify(res.employee));
	               $('#resultContainer').show();
	            
	            }else{
	              //Set error messages
	              $.each(res.errorMessages,function(key,value){
	  	            $('input[name='+key+']').after('<span class="error">'+value+'</span>');
	              });
	            }
	         }
	      })
	   });
	
})(jQuery);
