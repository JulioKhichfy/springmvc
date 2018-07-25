(function($) {
	$(":checkbox").change(function () 
	 {
		var checkeds = new Array();
		$("input[name='festasMarcadas[]']").each(function ()
		{
		   // valores inteiros usa-se parseInt
		   //checkeds.push(parseInt($(this).val()));
		   // string
			var sessao = $(this).val();
			if ($(this).is(':checked')) {
				checkeds.push( $(this).val());
				 
				$("#"+sessao).addClass("marcadoVerde");
			}else{
				
				$("#"+sessao).removeClass("marcadoVerde");
			}
		});
		
		
		var footerDiv = $("#festasSelecionadas");
		
		footerDiv.empty();
		
		footerDiv.append("<h3><p>Festas que possuo interesse</p></h3>")
		
		for (var data in checkeds) {
		  footerDiv.append("<h5><p>"+checkeds[data]+"</p></h5>");
		  footerDiv.append("<input type='hidden' class='dadosForm' name='festas' value="+checkeds[data] +"/>" );
		}
		
		footerDiv.append("<input type='text' placeholder='Email' name='email' />");
		footerDiv.append("<input type='text' placeholder='Nome' name='nome' />");
		footerDiv.append("<input type='text' placeholder='Cel' name='cel' />");
	 });
	
	 /*  Submit form using Ajax */
	   $("#enviarPedido").click(function(e) {
	   
	      //Prevent default submission of form
	      e.preventDefault();
	      
	      //Remove all errors
	      //$('input').next().remove();
	      
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
