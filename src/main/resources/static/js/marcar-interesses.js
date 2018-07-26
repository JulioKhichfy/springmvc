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
		var contadorDiv = $("#contador-interesses");
		var formDiv = $("#campos-form-interesses");
		var botaoDiv = $("#botao-enviar-interesses");
		
		footerDiv.empty();
		contadorDiv.empty();
		formDiv.empty();
		botaoDiv.empty();
		
		for (var data in checkeds) {
		  /*footerDiv.append("<h5><p>"+checkeds[data]+"</p></h5>");*/
			
			footerDiv.append("<input type='hidden' class='dadosForm' name='festas' value="+checkeds[data] +"/>" );
		}
		contadorDiv.append("<h1>"+checkeds.length+"</h1>");
		formDiv.append("<input type='text' placeholder='Email' name='email' />");
		formDiv.append("<input type='text' placeholder='Nome' name='nome' />");
		formDiv.append("<input type='text' placeholder='Cel' name='cel' />");
		
		if(checkeds.length == 1){
			botaoDiv.append("<button type='submit' id='enviarPedido'>Enviar Interesse</button>");
		}else{
			botaoDiv.append("<button type='submit' id='enviarPedido'>Enviar Interesses</button>");
		}
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
