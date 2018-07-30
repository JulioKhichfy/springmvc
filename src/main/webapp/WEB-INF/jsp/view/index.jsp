<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

		<header class="masthead">
		
			<div class="header-content">
			 	<h1>Festas Infantis, 15 anos e datas especiais</h1>
							
				<p style="text-align: left;">Navegue pelos temas</p>
			    
			    <p style="text-align: center;">Selecione um ou mais temas e clique em "enviar interesse".
				    Iremos responder como você desejar:Email, Celular ou Whatsapp.</p>
			</div>
		   	<div class="row justify-content-start">
				<div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2 align-middle">
					<div class="view overlay rounded z-depth-1">
						<a href="#meninas" class="js-scroll-trigger">
							<img src="images/masterhead/meninastemasbtn.jpg" class="img-fluid" alt="Meninas ;)" />
						</a>
					</div>
				</div>
				<div class="col-4 col-sm-4 col-md-4 col-lg-3 col-xl-3 align-middle">
					<div class="view overlay rounded z-depth-1">
						<a href="#meninos" class="js-scroll-trigger">
							<img src="images/masterhead/meninostemabtn.jpg" class="img-fluid"  alt="Meninos ;)" />
						</a>
					</div>
					
				</div>
				<div class="col-4 col-sm-4 col-md-4 col-lg-3 col-xl-3 align-middle">
					<div class="view overlay rounded z-depth-1">
						<a href="#adultos" class="js-scroll-trigger">
							<img src="images/masterhead/adultostemabtn.jpg" class="img-fluid"  alt="adultos" />
						</a>
					</div>
				</div>
				
				<div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2 align-middle" ><a href="#meninas" class="btn btn-primary custom-btn-menina btn-sm js-scroll-trigger">Elas ;)</a></div>
				<div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2 align-middle" ><a href="#meninos" class="btn btn-primary custom-btn-menino btn-sm js-scroll-trigger">Eles ;) </a></div>
				<div class="col-4 col-sm-4 col-md-4 col-lg-2 col-xl-2 align-middle" ><a href="#adultos" class="btn btn-primary custom-btn-outros btn-sm js-scroll-trigger">Outros</a></div>
			</div>
		
		    <p>Caso esteja planejando personalizar seu evento/festa, fale diretamente com a decoradora.</p>
			<a href="#tema-personalizado" class="btn btn-outline-dark btn-sm js-scroll-trigger">Escrever</a>
		</header>
	<c:set var="variavelFestas" value="${festas}" scope="request" />
	
	<section class="apresentacao-temas bg-meninas" id="meninas">
		<div class="container">
			<div class="row">
				<div class="col-12" style="text-align: center;">
					<span class="titleTemaMenina">Temas meninas</span>
				</div>
				<c:forEach var="festagirls" items="${variavelFestas}" varStatus="status">
					<c:if test="${(festagirls.sexo eq 'F' || festagirls.sexo eq 'U')}">
						<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 align-middle" style="padding-bottom: 8px;">
							
								<img class="temas" src="images/festas/${festagirls.nome}/principal.jpg"  alt="${festagirls.nome}"/>
							
							<a href="#${festagirls.nome}" class="js-scroll-trigger btn-primary btn-sm  " role="button" aria-pressed="true">
								<font class="nomeTema">${festagirls.nome}</font>
							</a>
						</div>
					</c:if>
				</c:forEach>
			</div>  
		</div>
	</section>
    
	<section class="apresentacao-temas bg-meninos" id="meninos">
		<div class="container">
			<div class="row">
				<div class="col-12" style="text-align: center;">
					<span class="titleTemaMenino">Temas meninos</span>
				</div>
				<c:forEach var="festaboys" items="${variavelFestas}" varStatus="status">
					<c:if test="${festaboys.sexo eq 'M' || festaboys.sexo eq 'U'}">
					 	<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 align-middle" style="padding-bottom: 8px;">
							<img class="temas" src="images/festas/${festaboys.nome}/principal.jpg"  alt="${festaboys.nome}"/>
							
		                     <a href="#${festagirls.nome}" class="js-scroll-trigger btn-primary btn-sm" role="button" aria-pressed="true">
		                     	<font class="nomeTema">${festaboys.nome}</font>
		                     </a>
		           		</div>
				    </c:if> 
		        </c:forEach>
	        </div>
        </div>  
    </section>
     
     <c:forEach var="festa" items="${variavelFestas}" varStatus="principal">
    	<section class="features" id="${festa.nome}">
   			<div class="container">
				<div class="row">
					<div class="col-12">
						<span class="titleTemaMenina">Festa: ${festa.nome}</span>
					</div>
				</div>
			 	<div class="row">		
			 		<div class="col">
				      1 of 3
			    	</div>
				    <div class="col-5">
				     <input type="checkbox" name="festasMarcadas[]" value="${festa.nome}">
				    </div>
				    <div class="col">
				      3 of 3
				    </div>
				</div>
				<div class="row">
					<c:forEach var="foto" items="${festa.tema.fotos}" varStatus="contador">
						<div class="col-4 col-sm-4 col-md-4 col-lg-4 col-xl-4 text-center" style="padding-bottom: 8px; ">
				            <a href='<spring:url value="/images/festas/${festa.nome}/${foto.nomeFoto}"/>' data-type="image" data-fancybox="image" data-caption="${foto.nomeFoto}" >
								<img class="mosaico-fotos" src="images/festas/${festa.nome}/${foto.nomeFoto}" alt="${festa.nome}" />
							</a>
						</div>
            		</c:forEach>
				</div>
				<div class="row">
					<div class="col-6">
						<p class="text-muted">
							<a href="#meninas" class="center btn  btn-outline btn-md js-scroll-trigger">Voltar!</a>
						</p>
					</div>
				</div>
			</div><!-- <div class="container"> -->
		</section>
	</c:forEach> 
	
	<!--<section class="cta">
		<div class="cta-content">
			<div class="container">
				<h2>
					Stop waiting.<br />Start building.
				</h2>
				<a href="#contact" class="btn btn-outline btn-xl js-scroll-trigger">Let's
					Get Started!</a>
			</div>
		</div>
		<div class="overlay"></div>
	</section>-->

	<!--<section class="contact bg-primary" id="contact">
		<div class="container">
			<h2>
				We <i class="fa fa-heart"></i> new friends!
			</h2>
			<ul class="list-inline list-social">
				<li class="list-inline-item social-twitter"><a href="#"> <i
						class="fa fa-twitter"></i>
				</a></li>
				<li class="list-inline-item social-facebook"><a href="#"> <i
						class="fa fa-facebook"></i>
				</a></li>
				<li class="list-inline-item social-google-plus"><a href="#">
						<i class="fa fa-google-plus"></i>
				</a></li>
			</ul>
		</div>
	</section>-->
