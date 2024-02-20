#tag Class
Protected Class SendingApi
	#tag Method, Flags = &h0
		Sub SendAdvMail(, subject As String, body As String, from As OpenAPIClient.Models.EmailAddressTypes, Escapedto As OpenAPIClient.Models.EmailAddressesTypes, Optional replyto As OpenAPIClient.Models.EmailAddressesTypes, Optional cc As OpenAPIClient.Models.EmailAddressesTypes, Optional bcc As OpenAPIClient.Models.EmailAddressesTypes, attachments() As OpenAPIClient.Models.MailAttachment, Optional id As Xoson.O.OptionalInt64)
		  // Operation sendAdvMail
		  // Sends an Email with Advanced Options
		  // - 
		  // - parameter subject: (form) The subject or title of the email 
		  // - parameter body: (form) The main email contents. 
		  // - parameter from: (form)  
		  // - parameter Escapedto: (form)  
		  // - parameter replyto: (form)  (optional, default to Nil)
		  // - parameter cc: (form)  (optional, default to Nil)
		  // - parameter bcc: (form)  (optional, default to Nil)
		  // - parameter attachments: (form) (optional) File attachments to include in the email.  The file contents must be base64 encoded! (optional, default to Nil)
		  // - parameter id: (form) (optional)  ID of the Mail order within our system to use as the Mail Account. (optional, default to 0)
		  //
		  // Invokes SendingApiCallbackHandler.SendAdvMailCallback(GenericResponse) on completion. 
		  //
		  // - POST /mail/advsend
		  // - Sends An email through one of your mail orders allowing additional options such as file attachments, cc, bcc, etc.  Here are 9 examples showing the various ways to call the advsend operation showing the different ways you can pass the to, cc, bcc, and replyto information. The first several examples are all for the application/x-www-form-urlencoded content-type while the later ones are for application/json content-types.  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/x-www-form-urlencoded'  --header 'X-API-KEY: YOUR_API_KEY'  --data 'subject=Welcome'  --data 'body=Hello'  --data from=user@domain.com  --data to=support@interserver.net ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/x-www-form-urlencoded'  --header 'X-API-KEY: YOUR_API_KEY'  --data 'subject=Welcome'  --data 'body=Hello'  --data from=user@domain.com  --data "to[0][name]=Joe"  --data "to[0][email]=support@interserver.net" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/x-www-form-urlencoded'  --header 'X-API-KEY: YOUR_API_KEY'  --data 'subject=Welcome'  --data 'body=Hello'  --data from="Joe <user@domain.com>"  --data to="Joe <support@interserver.net>" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/x-www-form-urlencoded'  --header 'X-API-KEY: YOUR_API_KEY'  --data 'subject=Welcome'  --data 'body=Hello'  --data from=user@domain.com  --data "to=support@interserver.net, support@interserver.net" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/x-www-form-urlencoded'  --header 'X-API-KEY: YOUR_API_KEY'  --data 'subject=Welcome'  --data 'body=Hello'  --data from=user@domain.com  --data "to=Joe <support@interserver.net>, Joe <support@interserver.net>" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/x-www-form-urlencoded'  --header 'X-API-KEY: YOUR_API_KEY'  --data 'subject=Welcome'  --data 'body=Hello'  --data from=user@domain.com  --data "to[0][name]=Joe"  --data "to[0][email]=support@interserver.net"  --data "to[1][name]=Joe"  --data "to[1][email]=support@interserver.net" ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/json'  --header 'X-API-KEY: YOUR_API_KEY'  --data '{ "subject": "Welcome", "body": "Hello", "from": "user@domain.com", "to": "support@interserver.net" }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/json'  --header 'X-API-KEY: YOUR_API_KEY'  --data '{ "subject": "Welcome", "body": "Hello", "from": {"name": "Joe", "email": "user@domain.com"}, "to": [{"name": "Joe", "email": "support@interserver.net"}] }' ```  ``` curl -i --request POST --url https://api.mailbaby.net/mail/advsend  --header 'Accept: application/json'  --header 'Content-Type: application/json'  --header 'X-API-KEY: YOUR_API_KEY'  --data '{ "subject": "Welcome", "body": "Hello", "from": "Joe <user@domain.com>", "to": "Joe <support@interserver.net>" }' ``` 
		  // - defaultResponse: Nil
		  //
		  // - API Key:
		  //   - type: apiKey X-API-KEY (HEADER)
		  //   - name: apiKeyAuth
		  //
		  
		  Dim localVarHTTPSocket As New HTTPSecureSocket
		  Me.PrivateFuncPrepareSocket(localVarHTTPSocket)
		  Dim localVarFormParams As New Dictionary
		  localVarFormParams.Value("subject") = subject
localVarFormParams.Value("body") = body
localVarFormParams.Value("from") = Xoson.toJSON(from)
localVarFormParams.Value("to") = Xoson.toJSON(Escapedto)
If replyto <> nil Then localVarFormParams.Value("replyto") = Xoson.toJSON(replyto)
If cc <> nil Then localVarFormParams.Value("cc") = Xoson.toJSON(cc)
If bcc <> nil Then localVarFormParams.Value("bcc") = Xoson.toJSON(bcc)
If attachments <> nil Then localVarFormParams.Value("attachments") = Xoson.toJSON(attachments)
If id <> nil Then localVarFormParams.Value("id") = id.ToString
		  If localVarFormParams.Count > 0 Then localVarHTTPSocket.SetFormData(localVarFormParams)
		  
		  
		  If me.ApiKeyapiKeyAuth = "" Then Raise New OpenAPIClient.OpenAPIClientException(kErrorCannotAuthenticate, "API key is unset. Please assign a value to `SendingApi.ApiKeyapiKeyAuth` before invoking `SendingApi.SendAdvMail()`.")
		  
		  localVarHTTPSocket.SetRequestHeader(EncodeURLComponent("X-API-KEY"), EncodeURLComponent(me.ApiKeyapiKeyAuth))
		  


		  Dim localVarPath As String = "/mail/advsend"
		  
		  
		  
		  AddHandler localVarHTTPSocket.PageReceived, addressof me.SendAdvMail_handler
		  AddHandler localVarHTTPSocket.Error, addressof Me.SendAdvMail_error
		  
		  
		  localVarHTTPSocket.SendRequest("POST", Me.BasePath + localVarPath)
		  if localVarHTTPSocket.LastErrorCode <> 0 then
		    Dim localVarException As New OpenAPIClient.OpenAPIClientException(localVarHTTPSocket.LastErrorCode)
			Raise localVarException
		  end if
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Function SendAdvMailPrivateFuncDeserializeResponse(HTTPStatus As Integer, Headers As InternetHeaders, error As OpenAPIClient.OpenAPIClientException, Content As String, ByRef outData As OpenAPIClient.Models.GenericResponse) As Boolean
		  Dim contentType As String = Headers.Value("Content-Type")
		  Dim contentEncoding As TextEncoding = OpenAPIClient.EncodingFromContentType(contentType)
		  Content = DefineEncoding(Content, contentEncoding)
		  
		  If HTTPStatus > 199 and HTTPStatus < 300 then
		    If contentType.LeftB(16) = "application/json" then
		      
			  outData = New OpenAPIClient.Models.GenericResponse
			  Try
		        Xoson.fromJSON(outData, Content.toText())

		      Catch e As JSONException
		        error.Message = error.Message + " with JSON parse exception: " + e.Message
		        error.ErrorNumber = kErrorInvalidJSON
		        Return False
		        
		      Catch e As Xojo.Data.InvalidJSONException
		        error.Message = error.Message + " with Xojo.Data.JSON parse exception: " + e.Message
		        error.ErrorNumber = kErrorInvalidJSON
		        Return False
		        
		      Catch e As Xoson.XosonException
		        error.Message = error.Message + " with Xoson parse exception: " + e.Message
		        error.ErrorNumber = kErrorXosonProblem
		        Return False

		      End Try
		      
		      
		    ElseIf contentType.LeftB(19) = "multipart/form-data" then
		      error.Message = "Unsupported media type: " + contentType
		      error.ErrorNumber = kErrorUnsupportedMediaType
		      Return False

		    ElseIf contentType.LeftB(33) = "application/x-www-form-urlencoded" then
		      error.Message = "Unsupported media type: " + contentType
		      error.ErrorNumber = kErrorUnsupportedMediaType
		      Return False

		    Else
		      error.Message = "Unsupported media type: " + contentType
		      error.ErrorNumber = kErrorUnsupportedMediaType
		      Return False

		    End If
		  Else
		    error.Message = error.Message + ". " + Content
			error.ErrorNumber = kErrorHTTPFail
		    Return False
		  End If
		  
		  Return True
		End Function
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub SendAdvMail_error(sender As HTTPSecureSocket, Code As Integer)
		  If sender <> nil Then sender.Close()

		  Dim error As New OpenAPIClient.OpenAPIClientException(Code)
		  Dim data As OpenAPIClient.Models.GenericResponse
		  CallbackHandler.SendAdvMailCallback(error, data)
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub SendAdvMail_handler(sender As HTTPSecureSocket, URL As String, HTTPStatus As Integer, Headers As InternetHeaders, Content As String)
		  #Pragma Unused URL
		  

		  If sender <> nil Then sender.Close()
		  
		  Dim error As New OpenAPIClient.OpenAPIClientException(HTTPStatus, "", Content)
		  
		  Dim data As OpenAPIClient.Models.GenericResponse
		  Call SendAdvMailPrivateFuncDeserializeResponse(HTTPStatus, Headers, error, Content, data)
		  
		  CallbackHandler.SendAdvMailCallback(error, data)
		End Sub
	#tag EndMethod




	#tag Method, Flags = &h0
		Sub SendMail(, Escapedto As String, from As String, subject As String, body As String)
		  // Operation sendMail
		  // Sends an Email
		  // - 
		  // - parameter Escapedto: (form) The Contact whom is the primary recipient of this email. 
		  // - parameter from: (form) The contact whom is the this email is from. 
		  // - parameter subject: (form) The subject or title of the email 
		  // - parameter body: (form) The main email contents. 
		  //
		  // Invokes SendingApiCallbackHandler.SendMailCallback(GenericResponse) on completion. 
		  //
		  // - POST /mail/send
		  // - Sends an email through one of your mail orders.  *Note*: If you want to send to multiple recipients or use file attachments use the advsend (Advanced Send) call instead. 
		  // - defaultResponse: Nil
		  //
		  // - API Key:
		  //   - type: apiKey X-API-KEY (HEADER)
		  //   - name: apiKeyAuth
		  //
		  
		  Dim localVarHTTPSocket As New HTTPSecureSocket
		  Me.PrivateFuncPrepareSocket(localVarHTTPSocket)
		  Dim localVarFormParams As New Dictionary
		  localVarFormParams.Value("to") = Escapedto
localVarFormParams.Value("from") = from
localVarFormParams.Value("subject") = subject
localVarFormParams.Value("body") = body
		  If localVarFormParams.Count > 0 Then localVarHTTPSocket.SetFormData(localVarFormParams)
		  
		  
		  If me.ApiKeyapiKeyAuth = "" Then Raise New OpenAPIClient.OpenAPIClientException(kErrorCannotAuthenticate, "API key is unset. Please assign a value to `SendingApi.ApiKeyapiKeyAuth` before invoking `SendingApi.SendMail()`.")
		  
		  localVarHTTPSocket.SetRequestHeader(EncodeURLComponent("X-API-KEY"), EncodeURLComponent(me.ApiKeyapiKeyAuth))
		  


		  Dim localVarPath As String = "/mail/send"
		  
		  
		  
		  AddHandler localVarHTTPSocket.PageReceived, addressof me.SendMail_handler
		  AddHandler localVarHTTPSocket.Error, addressof Me.SendMail_error
		  
		  
		  localVarHTTPSocket.SendRequest("POST", Me.BasePath + localVarPath)
		  if localVarHTTPSocket.LastErrorCode <> 0 then
		    Dim localVarException As New OpenAPIClient.OpenAPIClientException(localVarHTTPSocket.LastErrorCode)
			Raise localVarException
		  end if
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Function SendMailPrivateFuncDeserializeResponse(HTTPStatus As Integer, Headers As InternetHeaders, error As OpenAPIClient.OpenAPIClientException, Content As String, ByRef outData As OpenAPIClient.Models.GenericResponse) As Boolean
		  Dim contentType As String = Headers.Value("Content-Type")
		  Dim contentEncoding As TextEncoding = OpenAPIClient.EncodingFromContentType(contentType)
		  Content = DefineEncoding(Content, contentEncoding)
		  
		  If HTTPStatus > 199 and HTTPStatus < 300 then
		    If contentType.LeftB(16) = "application/json" then
		      
			  outData = New OpenAPIClient.Models.GenericResponse
			  Try
		        Xoson.fromJSON(outData, Content.toText())

		      Catch e As JSONException
		        error.Message = error.Message + " with JSON parse exception: " + e.Message
		        error.ErrorNumber = kErrorInvalidJSON
		        Return False
		        
		      Catch e As Xojo.Data.InvalidJSONException
		        error.Message = error.Message + " with Xojo.Data.JSON parse exception: " + e.Message
		        error.ErrorNumber = kErrorInvalidJSON
		        Return False
		        
		      Catch e As Xoson.XosonException
		        error.Message = error.Message + " with Xoson parse exception: " + e.Message
		        error.ErrorNumber = kErrorXosonProblem
		        Return False

		      End Try
		      
		      
		    ElseIf contentType.LeftB(19) = "multipart/form-data" then
		      error.Message = "Unsupported media type: " + contentType
		      error.ErrorNumber = kErrorUnsupportedMediaType
		      Return False

		    ElseIf contentType.LeftB(33) = "application/x-www-form-urlencoded" then
		      error.Message = "Unsupported media type: " + contentType
		      error.ErrorNumber = kErrorUnsupportedMediaType
		      Return False

		    Else
		      error.Message = "Unsupported media type: " + contentType
		      error.ErrorNumber = kErrorUnsupportedMediaType
		      Return False

		    End If
		  Else
		    error.Message = error.Message + ". " + Content
			error.ErrorNumber = kErrorHTTPFail
		    Return False
		  End If
		  
		  Return True
		End Function
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub SendMail_error(sender As HTTPSecureSocket, Code As Integer)
		  If sender <> nil Then sender.Close()

		  Dim error As New OpenAPIClient.OpenAPIClientException(Code)
		  Dim data As OpenAPIClient.Models.GenericResponse
		  CallbackHandler.SendMailCallback(error, data)
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub SendMail_handler(sender As HTTPSecureSocket, URL As String, HTTPStatus As Integer, Headers As InternetHeaders, Content As String)
		  #Pragma Unused URL
		  

		  If sender <> nil Then sender.Close()
		  
		  Dim error As New OpenAPIClient.OpenAPIClientException(HTTPStatus, "", Content)
		  
		  Dim data As OpenAPIClient.Models.GenericResponse
		  Call SendMailPrivateFuncDeserializeResponse(HTTPStatus, Headers, error, Content, data)
		  
		  CallbackHandler.SendMailCallback(error, data)
		End Sub
	#tag EndMethod






	#tag Method, Flags = &h21
		Private Function AuthenticationRequired(Realm As String, Headers As InternetHeaders, ByRef Name As String, ByRef Password As String) As Boolean
		  #Pragma Unused Realm
		  #Pragma Unused Headers
		  Name = Me.BasicAuthUser
		  Password = Me.BasicAuthPassword
		  Return True
		End Function
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub PrivateFuncPrepareSocket(socket As HTTPSecureSocket)
		  socket.Secure = Me.useHTTPS
		  socket.ConnectionType = SSLSocket.TLSv12
		  socket.Port = Me.Port
		  socket.RequestHeaders.Delete("Accept")
		  socket.RequestHeaders.AppendHeader("Accept", "text/plain")
		  socket.RequestHeaders.AppendHeader("Accept", "application/json")
		  socket.RequestHeaders.AppendHeader("Content-Type", "application/json")

		  If Me.AdditionalHeaders <> Nil Then
		    For Each HeaderName As Variant In Me.AdditionalHeaders.Keys
		      Dim headerValueS As Variant = additionalHeaders.Value(HeaderName)
		      If headerValueS.IsArray Then
		        If headerValueS.ArrayElementType = Variant.TypeString Then
		          Dim values() As String = headerValueS
		          For Each value As String In values
		            socket.RequestHeaders.AppendHeader(HeaderName, value)
		          Next
		        Else
		          Raise New OpenAPIClient.OpenAPIClientException(kErrorInternal, "AdditionalHeaders only support Strings and String arrays as values.")
		        End If
		      Else
		        socket.RequestHeaders.AppendHeader(HeaderName, headerValueS.StringValue)
		      End If
		    Next
		  End If
		End Sub
	#tag EndMethod



	#tag Property, Flags = &h0
		AdditionalHeaders As Dictionary
	#tag EndProperty

	#tag Property, Flags = &h0
		ApiKeyapiKeyAuth As String
	#tag EndProperty

	#tag Property, Flags = &h0
		BasePath As String = "https://api.mailbaby.net"
	#tag EndProperty

	#tag Property, Flags = &h0
		BasicAuthPassword As String
	#tag EndProperty

	#tag Property, Flags = &h0
		BasicAuthUser As String
	#tag EndProperty

	#tag Property, Flags = &h0
		CallbackHandler As OpenAPIClient.APIs.SendingApiCallbackHandler
	#tag EndProperty

	#tag Property, Flags = &h0
		Host As String = ""
	#tag EndProperty

	#tag Property, Flags = &h0
		Port As Integer
	#tag EndProperty

	#tag Property, Flags = &h0
		UseHTTPS As Boolean = true
	#tag EndProperty


	#tag ViewBehavior
		#tag ViewProperty
			Name="Name"
			Visible=true
			Group="ID"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Index"
			Visible=true
			Group="ID"
			InitialValue="-2147483648"
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Super"
			Visible=true
			Group="ID"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Left"
			Visible=true
			Group="Position"
			InitialValue="0"
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Top"
			Visible=true
			Group="Position"
			InitialValue="0"
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="BasePath"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType="MultiLineEditor"
		#tag EndViewProperty
		#tag ViewProperty
			Name="BasicAuthUser"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType="MultiLineEditor"
		#tag EndViewProperty
		#tag ViewProperty
			Name="BasicAuthPassword"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType="MultiLineEditor"
		#tag EndViewProperty
		#tag ViewProperty
			Name="UseHTTPS"
			Visible=false
			Group="Behavior"
			InitialValue="true"
			Type="Boolean"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Port"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Host"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType="MultiLineEditor"
		#tag EndViewProperty
	#tag EndViewBehavior
End Class
#tag EndClass
