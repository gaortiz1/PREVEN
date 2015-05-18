<div class="container"   >
	    <div ng-controller="gesso-user-login as ctrlUsrLog">
	    
	    
	    
	        <div id="loginbox" style="margin-top:50px;" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	            <div class="panel panel-info" >
	                <div class="panel-heading">
	                    <div class="panel-title">Ingresar</div>
	                    <div style="float:right; font-size: 80%; position: relative; top:-10px"><a href="#"></a></div>
	                </div>
	
	                <div style="padding-top:30px" class="panel-body" >
	
	                    <div style="display:none" id="login-alert" class="alert alert-danger col-sm-12"></div>
	
	                    <form id="loginform" class="form-horizontal" role="form">
	
	                        <div style="margin-bottom: 25px" class="input-group">
	                            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	                            <input type="text" id="login-username" class="form-control" placeholder="Usuario" required="required" ng-model="ctrlUsrLog.userDto.nickName"/>
	                        </div>
	
	
	                        <div style="margin-bottom: 25px" class="input-group">
	                            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	                            <input type="password" id="login-password" ng-model="ctrlUsrLog.userDto.password" class="form-control" placeholder="Clave" required="required"/>
	                        </div>
	
	
	
	                        <div class="input-group">
	                            <div class="checkbox">
	                                <label>
	                                   
	                                </label>
	                            </div>
	                        </div>
	
	
	                        <div style="margin-top:10px" class="form-group">
	                            <!-- Button -->
	
	                            <div class="col-sm-12 controls">
	                                <input type="button" class="btn btn-success" ng-click="ctrlUsrLog.loginUser();" value="Ingresar"></input>
	                            </div>
	                        </div>
	
	
	                        <div class="form-group">
	                            <div class="col-md-12 control">
	                                <div>
	                                    No tiene una cuenta!
	                                    <a ng-click="ctrlUsrLog.openRecordUserModal()">
	                                        Crear usuario
	                                    </a>
	                                </div>
	                            </div>
	                        </div>
	                    </form>
	
	
	
	                </div>
	            </div>
	        </div>
	        <div id="signupbox" style="display:none; margin-top:50px" class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
	            <div class="panel panel-info">
	                <div class="panel-heading">
	                    <div class="panel-title">Crear usuario</div>
	                    <div style="float:right; font-size: 85%; position: relative; top:-10px"><a id="signinlink" href="#/login" onclick="$('#signupbox').hide(); $('#loginbox').show()">Login</a></div>
	                </div>
	                <div class="panel-body" >
	                    <form id="signupform" class="form-horizontal" role="form" action="signUp">
	
	                        <div id="signupalert" style="display:none" class="alert alert-danger">
	                            <p>Error:</p>
	                            <span></span>
	                        </div>
	
	                        <div class="form-group">
	                            <label for="firstName" class="col-md-3 control-label"><spring:message code="page.label.email"/></label>
	                            <div class="col-md-9">
	                                <input type="text" ng-model="ctrlUsrLog.personDto.userDto.nickName" class="form-control" placeholder="Nombre de usuario" required="required"/>
	                            </div>
	                        </div>
	
	                        <div class="form-group">
	                            <label for="firstname" class="col-md-3 control-label"><spring:message code="page.label.firstName"/></label>
	                            <div class="col-md-9">
	                                <input type="text" ng-model="ctrlUsrLog.personDto.firstName" class="form-control" placeholder="Nombre" required="required"/>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label for="lastname" class="col-md-3 control-label"><spring:message code="page.label.lastName"/></label>
	                            <div class="col-md-9">
	                                <input ng-model="ctrlUsrLog.personDto.lastName" class="form-control" placeholder="Apellido" required="required"/>
	                            </div>
	                        </div>
	                        <div class="form-group">
	                            <label for="password" class="col-md-3 control-label"><spring:message code="page.label.password"/></label>
	                            <div class="col-md-9">
	                                <input type="password" ng-model="ctrlUsrLog.personDto.userDto.password" class="form-control" placeholder="Clave" required="required"/>
	                            </div>
	                        </div>
	
	                        <div class="form-group">
	                            <!-- Button -->
	                            <div class="col-md-offset-3 col-md-9">
	                                <input  type="button" class="btn btn-info" value="Registrar" ng-click="ctrlUsrLog.recordUser();"><i class="icon-hand-right"></i></input>
	                            </div>
	                        </div>
	                    </form>
	                </div>
	            </div>
	        </div>
	    </div>
	</div>