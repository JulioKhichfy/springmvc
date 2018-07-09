<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
	<header class="masthead container-fluid" style="padding-right: 15px;height: 858px;">
		<div class="container h-100">
			<div class="row h-100  pt-0">
				<div class="col-lg-7">
					<div class="row">
						<img class="center" height="200" src="images/arabesco5.jpg" />
					</div>
					<div class="row">
						<div class="col-8 col-md-8 mx-auto" style="text-align:center">
							<font size="19" face="CAC Champagne" class="cyan-text text-darken-2">Pequenos Detalhes Eventos</font>
						</div>
					</div>
					<br />
	
					<!--Carousel Wrapper-->
					<div id="carousel-example-2" class="carousel slide carousel-fade" data-ride="carousel">
						<!--Indicators-->
						<ol class="carousel-indicators">
							<li data-target="#carousel-example-2" data-slide-to="0" class="active"></li>
							<li data-target="#carousel-example-2" data-slide-to="1"></li>
							<li data-target="#carousel-example-2" data-slide-to="2"></li>
						</ol>
						<!--/.Indicators-->
						<!--Slides-->
						<div class="carousel-inner" role="listbox">
							<div class="carousel-item active">
								<div class="view">
									<img class="d-block w-100" src="images/carroucel-bootstrap/neon1.jpg" alt="First slide" />
									<div class="mask rgba-black-light"></div>
								</div>
								<div class="carousel-caption">
									<h3 class="h3-responsive"></h3>
									<p></p>
								</div>
							</div>
							<div class="carousel-item">
								<!--Mask color-->
								<div class="view">
									<img class="d-block w-100" src="images/carroucel-bootstrap/unicorniocarroucel.jpg" alt="Second slide" />
									<div class="mask rgba-black-strong"></div>
								</div>
								<div class="carousel-caption">
									<h3 class="h3-responsive"></h3>
									<p></p>
								</div>
							</div>
							<div class="carousel-item">
								<!--Mask color-->
								<div class="view">
									<img class="d-block w-100" src="https://mdbootstrap.com/img/Photos/Slides/img%20(9).jpg" alt="Third slide" />
									<div class="mask rgba-black-slight"></div>
								</div>
								<div class="carousel-caption">
									<h3 class="h3-responsive">Slight mask</h3>
									<p>Third text</p>
								</div>
							</div>
						</div>
						<a class="carousel-control-prev" href="#carousel-example-2" role="button" data-slide="prev"> 
							<span class="carousel-control-prev-icon" aria-hidden="true"></span> 
							<span class="sr-only">Previous</span>
						</a> 
						<a class="carousel-control-next" href="#carousel-example-2" role="button" data-slide="next">
							<span class="carousel-control-next-icon" aria-hidden="true"></span> 
							<span class="sr-only">Next</span>
						</a>
					</div>
					<!--/.Carousel Wrapper-->
	
					<br />
	
					<div class="row text-center">
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="view overlay rounded z-depth-1">
								<a href="#meninas" class="js-scroll-trigger"><img src="images/masterhead/meninastemasbtn.jpg" class="img-fluid" alt="Sample project image" /></a>
							</div>
							<hr/>
							<a href="#meninas" class="btn btn-primary js-scroll-trigger">Temas para elas ;)</a>
						</div>
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="view overlay rounded z-depth-1">
								<a href="#meninos" class="js-scroll-trigger"><img src="images/masterhead/meninostemabtn.jpg" class="img-fluid" alt="Sample project image" /></a>
							</div>
							<hr/>
							<a href="#meninos" class="btn  btn-primary js-scroll-trigger">Temas para eles ;) </a>
						</div>
						<div class="col-lg-4 col-md-6 mb-4">
							<div class="view overlay rounded z-depth-1">
								<a href="#adultos" class="js-scroll-trigger"><img src="images/masterhead/adultostemabtn.jpg" class="img-fluid" alt="Sample project image" /></a>
							</div>
							<hr/>
							<a href="#adultos" class="btn  btn-primary js-scroll-trigger">Datas Especiais</a>
						
						</div>
					</div>
	
				</div>
				<div class="col-lg-5 my-auto">
				
					<form action="/index" method="post">
						<div class="panel-body">
							
							<label for="usuario"></label>
							<input id="usuario" name="usuario" class="form-control" required>
					
							<label for="senha"></label>
							<input type="password" id="senha" name="senha" class="form-control" required>
						</div>
						<input type="submit" class="btn btn-primary" value="Login"/>
					</form>
				</div>
			</div>
			
		</div>
	</header>
	
	<section class="download bg-meninas" id="meninas">
		<div class="container">
			<div class="row">
				<h2 class="section-heading">Temas para as meninas</h2>
				<div class="row container-fluid">
					<c:forEach var="festagirls" items="${festas}" varStatus="status">
						<c:if test="${(festagirls.sexo eq 'F' || festagirls.sexo eq 'U')}">
							<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
					            <div class="card border-primary" style="width: 200px;"">
									<img class="card-img-top center " style="height: 200px; width: 200px;" src="images/festas/${festagirls.nome}/principal.jpg"  alt="${festagirls.nome}"/>
					                <div class="card-footer-meninas" style="text-align:center">
					                     <a href="#${festagirls.nome}" class="btn btn-outline-info btn-sm js-scroll-trigger" role="button" aria-pressed="true">${festagirls.nome}</a>
					                </div>
					            </div>
					        </div>
					   </c:if>
				   </c:forEach>
		        </div> 
	        </div>  
	    </div>
    </section>
	<section class="download bg-meninos" id="meninos">
		<div class="container">
			<div class="row">
				<h2 class="section-heading">Temas para os meninos.</h2>
				<div class="row container">
					<c:forEach var="festaboys" items="${festas}" varStatus="status" >
						<c:if test="${festaboys.sexo eq 'M' || festaboys.sexo eq 'U'}">
							<div class="col-sm-6 col-md-4 col-lg-3 mt-4">
					            <div class="card border-primary" style="width: 200px;" >
									<img class="card-img-top center "  style="height: 200px; width: 200px;" src="images/festas/${festaboys.nome}/principal.jpg"  alt="${festaboys.nome}"/>
					                <div class="card-footer-meninos"  style="text-align:center">
					                     <a href="#${festaboys.nome}" class="btn btn-outline-info btn-sm js-scroll-trigger" role="button" aria-pressed="true">${festaboys.nome}</a>
					                </div>
					            </div>
					        </div>
					    </c:if> 
						
			        </c:forEach>
		        </div>
	        </div>  
	    </div>
    </section>
    
    <c:forEach var="festa" items="${festas}" varStatus="principal">
		<section class="features py-0 mt-5" id="${festa.nome}">
			<div class="container-fluid">
				<div class="section-heading text-center mt-0">
					<h2> Festa: ${festa.nome} </h2>
					
					<!-- Button to Open the Modal -->
					  <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" data-whatever="${festa.nome}">
					    Enviar Interesse :) 
					</button>
				</div> 
				<br/>
				<div class="container">
					<div class="row  justify-content-center">
						<div class="motrar-carousel-para-celular">
							<!--Carousel Wrapper-->
							<div id="carousel-celular${festa.nome}" class="carousel slide carousel-fade" data-ride="carousel">
								<!--Indicators-->
								<ol class="carousel-indicators">
						     		<c:forEach items="${festa.tema.fotos}" varStatus="statusAuxOne">
							        	<c:if test="${statusAuxOne.index eq 0}">
							        		<li data-target="#carousel-celular${festa.nome}" data-slide-to="0" class="active"></li>
							        	</c:if>
							        	<c:if test="${statusAuxOne.index ne 0}">
							        		<li data-target="#carousel-celular${festa.nome}" data-slide-to="${statusAuxOne.index}"></li>
							        	</c:if>
						        	</c:forEach>
							    </ol>
								<!--/.Indicators-->
								<!--Slides-->
							 	<div class="carousel-inner" role="listbox">
									<c:forEach  var="foto" items="${festa.tema.fotos}" varStatus="statusfoto">
							    		<c:if test="${statusfoto.index eq 0}">
									        <div class="carousel-item active">
									            <div class="view">
									                <img src="images/festas/${festa.nome}/${foto.nomeFoto}" class="d-block w-100" alt="${festa.nome}"/>
									                <div class="mask rgba-black-light"></div>
									            </div>
									            <div class="carousel-caption">
									                <h3 class="h3-responsive"></h3>
									                <p></p>
									            </div>
									        </div>
								       </c:if>
								        <c:if test="${statusfoto.index ne 0}">
									        <div class="carousel-item">
									            <div class="view">
									                 <img src="images/festas/${festa.nome}/${foto.nomeFoto}" class="d-block w-100" alt="${festa.nome}"/>
									                <div class="mask rgba-black-strong"></div>
									            </div>
									            <div class="carousel-caption">
									                <h3 class="h3-responsive"></h3>
									                <p></p>
									            </div>
									        </div>
								       </c:if>
								     
							       	</c:forEach>
							    </div>
					     		<a class="carousel-control-prev" href="#carousel-celular${festa.nome}" role="button" data-slide="prev">
							        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
							        <span class="sr-only">Previous</span>
							    </a>
							    <a class="carousel-control-next" href="#carousel-celular${festa.nome}" role="button" data-slide="next">
							        <span class="carousel-control-next-icon" aria-hidden="true"></span>
							        <span class="sr-only">Next</span>
							    </a>
							</div>
							<!--/.Carousel Wrapper-->
						</div>
						
						<div class="esconder col-md-12 bg-espaco-fotos-festas para-festas pt-3 py-3">
							<div class="row">
								<c:forEach var="foto" items="${festa.tema.fotos}" varStatus="statusFotoAux">
									<a href='<spring:url value="/images/festas/${festa.nome}/${foto.nomeFoto}"/>' class="col-xs-6 col-sm-6 col-md-2  pt-3 py-3" data-lightbox="example-set" data-title="Click the right half of the image to move forward.">
									<img  src="images/festas/${festa.nome}/${foto.nomeFoto}" class="img-fluid"  style="height: 150px; width: 1500px;"/>
									</a>
      							</c:forEach>
							</div>
							
						</div>
						<p class="text-muted">
							<a href="#meninas" class="center btn  btn-outline btn-md js-scroll-trigger">Voltar</a>
						</p>
					</div>
					
				</div> <!-- <div class="container"> -->
				
			</div> <!-- <div class="container-fluid"> --> 
		</section>
	</c:forEach>
	
	<section class="cta">
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
	</section>

	<section class="contact bg-primary" id="contact">
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
	</section>
