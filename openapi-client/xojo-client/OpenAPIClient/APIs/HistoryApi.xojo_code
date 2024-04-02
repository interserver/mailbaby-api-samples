#tag Class
Protected Class HistoryApi
	#tag Method, Flags = &h0
		Sub GetStats()
		  // Operation getStats
		  // Account usage statistics.
		  // - 
		  //
		  // Invokes HistoryApiCallbackHandler.GetStatsCallback(GetStats200ResponseInner) on completion. 
		  //
		  // - GET /mail/stats
		  // - Returns information about the usage on your mail accounts.
		  // - defaultResponse: Nil
		  //
		  // - API Key:
		  //   - type: apiKey X-API-KEY (HEADER)
		  //   - name: apiKeyAuth
		  //
		  
		  Dim localVarHTTPSocket As New HTTPSecureSocket
		  Me.PrivateFuncPrepareSocket(localVarHTTPSocket)
		  
		  
		  If me.ApiKeyapiKeyAuth = "" Then Raise New OpenAPIClient.OpenAPIClientException(kErrorCannotAuthenticate, "API key is unset. Please assign a value to `HistoryApi.ApiKeyapiKeyAuth` before invoking `HistoryApi.GetStats()`.")
		  
		  localVarHTTPSocket.SetRequestHeader(EncodeURLComponent("X-API-KEY"), EncodeURLComponent(me.ApiKeyapiKeyAuth))
		  


		  Dim localVarPath As String = "/mail/stats"
		  
		  
		  
		  AddHandler localVarHTTPSocket.PageReceived, addressof me.GetStats_handler
		  AddHandler localVarHTTPSocket.Error, addressof Me.GetStats_error
		  
		  
		  localVarHTTPSocket.SendRequest("GET", Me.BasePath + localVarPath)
		  if localVarHTTPSocket.LastErrorCode <> 0 then
		    Dim localVarException As New OpenAPIClient.OpenAPIClientException(localVarHTTPSocket.LastErrorCode)
			Raise localVarException
		  end if
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Function GetStatsPrivateFuncDeserializeResponse(HTTPStatus As Integer, Headers As InternetHeaders, error As OpenAPIClient.OpenAPIClientException, Content As String, outData() As OpenAPIClient.Models.GetStats200ResponseInner) As Boolean
		  Dim contentType As String = Headers.Value("Content-Type")
		  Dim contentEncoding As TextEncoding = OpenAPIClient.EncodingFromContentType(contentType)
		  Content = DefineEncoding(Content, contentEncoding)
		  
		  If HTTPStatus > 199 and HTTPStatus < 300 then
		    If contentType.LeftB(16) = "application/json" then
		      
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
		Private Sub GetStats_error(sender As HTTPSecureSocket, Code As Integer)
		  If sender <> nil Then sender.Close()

		  Dim error As New OpenAPIClient.OpenAPIClientException(Code)
		  Dim data() As OpenAPIClient.Models.GetStats200ResponseInner
		  CallbackHandler.GetStatsCallback(error, data)
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub GetStats_handler(sender As HTTPSecureSocket, URL As String, HTTPStatus As Integer, Headers As InternetHeaders, Content As String)
		  #Pragma Unused URL
		  

		  If sender <> nil Then sender.Close()
		  
		  Dim error As New OpenAPIClient.OpenAPIClientException(HTTPStatus, "", Content)
		  
		  Dim data() As OpenAPIClient.Models.GetStats200ResponseInner
		  Call GetStatsPrivateFuncDeserializeResponse(HTTPStatus, Headers, error, Content, data)
		  
		  CallbackHandler.GetStatsCallback(error, data)
		End Sub
	#tag EndMethod




	#tag Method, Flags = &h0
		Sub ViewMailLog(, Optional id As Xoson.O.OptionalInt64, Optional origin As Xoson.O.OptionalString, Optional mx As Xoson.O.OptionalString, Optional from As Xoson.O.OptionalString, Optional Escapedto As Xoson.O.OptionalString, Optional subject As Xoson.O.OptionalString, Optional mailid As Xoson.O.OptionalString, Optional skip As Xoson.O.OptionalInteger, Optional limit As Xoson.O.OptionalInteger, Optional startDate As Xoson.O.OptionalInt64, Optional endDate As Xoson.O.OptionalInt64, Optional replyto As Xoson.O.OptionalString, Optional headerfrom As Xoson.O.OptionalString)
		  // Operation viewMailLog
		  // displays the mail log
		  // - 
		  // - parameter id: (query) The ID of your mail order this will be sent through. (optional, default to 0)
		  // - parameter origin: (query) originating ip address sending mail (optional, default to Sample)
		  // - parameter mx: (query) mx record mail was sent to (optional, default to Sample)
		  // - parameter from: (query) from email address (optional, default to Sample)
		  // - parameter Escapedto: (query) to/destination email address (optional, default to Sample)
		  // - parameter subject: (query) subject containing this string (optional, default to Sample)
		  // - parameter mailid: (query) mail id (optional, default to Sample)
		  // - parameter skip: (query) number of records to skip for pagination (optional, default to 0)
		  // - parameter limit: (query) maximum number of records to return (optional, default to 100)
		  // - parameter startDate: (query) earliest date to get emails in unix timestamp format (optional, default to 0)
		  // - parameter endDate: (query) earliest date to get emails in unix timestamp format (optional, default to 0)
		  // - parameter replyto: (query) Reply-To Email Address (optional, default to Sample)
		  // - parameter headerfrom: (query) Header From Email Address (optional, default to Sample)
		  //
		  // Invokes HistoryApiCallbackHandler.ViewMailLogCallback(MailLog) on completion. 
		  //
		  // - GET /mail/log
		  // - Get a listing of the emails sent through this system 
		  // - defaultResponse: Nil
		  //
		  // - API Key:
		  //   - type: apiKey X-API-KEY (HEADER)
		  //   - name: apiKeyAuth
		  //
		  
		  Dim localVarHTTPSocket As New HTTPSecureSocket
		  Me.PrivateFuncPrepareSocket(localVarHTTPSocket)
		  
		  Dim localVarQueryParams As String = "?"
		  If id <> nil Then localVarQueryParams = localVarQueryParams + EncodeURLComponent("id") + "=" + EncodeURLComponent(id.ToString)
		  
		  If origin <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("origin") + "=" + EncodeURLComponent(origin)
		  
		  If mx <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("mx") + "=" + EncodeURLComponent(mx)
		  
		  If from <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("from") + "=" + EncodeURLComponent(from)
		  
		  If Escapedto <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("to") + "=" + EncodeURLComponent(Escapedto)
		  
		  If subject <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("subject") + "=" + EncodeURLComponent(subject)
		  
		  If mailid <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("mailid") + "=" + EncodeURLComponent(mailid)
		  
		  If skip <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("skip") + "=" + EncodeURLComponent(skip.ToString)
		  
		  If limit <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("limit") + "=" + EncodeURLComponent(limit.ToString)
		  
		  If startDate <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("startDate") + "=" + EncodeURLComponent(startDate.ToString)
		  
		  If endDate <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("endDate") + "=" + EncodeURLComponent(endDate.ToString)
		  
		  If replyto <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("replyto") + "=" + EncodeURLComponent(replyto)
		  
		  If headerfrom <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("headerfrom") + "=" + EncodeURLComponent(headerfrom)
		  

		  If me.ApiKeyapiKeyAuth = "" Then Raise New OpenAPIClient.OpenAPIClientException(kErrorCannotAuthenticate, "API key is unset. Please assign a value to `HistoryApi.ApiKeyapiKeyAuth` before invoking `HistoryApi.ViewMailLog()`.")
		  
		  localVarHTTPSocket.SetRequestHeader(EncodeURLComponent("X-API-KEY"), EncodeURLComponent(me.ApiKeyapiKeyAuth))
		  


		  Dim localVarPath As String = "/mail/log"
		  
		  
		  
		  AddHandler localVarHTTPSocket.PageReceived, addressof me.ViewMailLog_handler
		  AddHandler localVarHTTPSocket.Error, addressof Me.ViewMailLog_error
		  
		  
		  localVarHTTPSocket.SendRequest("GET", Me.BasePath + localVarPath + localVarQueryParams)
		  if localVarHTTPSocket.LastErrorCode <> 0 then
		    Dim localVarException As New OpenAPIClient.OpenAPIClientException(localVarHTTPSocket.LastErrorCode)
			Raise localVarException
		  end if
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Function ViewMailLogPrivateFuncDeserializeResponse(HTTPStatus As Integer, Headers As InternetHeaders, error As OpenAPIClient.OpenAPIClientException, Content As String, ByRef outData As OpenAPIClient.Models.MailLog) As Boolean
		  Dim contentType As String = Headers.Value("Content-Type")
		  Dim contentEncoding As TextEncoding = OpenAPIClient.EncodingFromContentType(contentType)
		  Content = DefineEncoding(Content, contentEncoding)
		  
		  If HTTPStatus > 199 and HTTPStatus < 300 then
		    If contentType.LeftB(16) = "application/json" then
		      
			  outData = New OpenAPIClient.Models.MailLog
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
		Private Sub ViewMailLog_error(sender As HTTPSecureSocket, Code As Integer)
		  If sender <> nil Then sender.Close()

		  Dim error As New OpenAPIClient.OpenAPIClientException(Code)
		  Dim data As OpenAPIClient.Models.MailLog
		  CallbackHandler.ViewMailLogCallback(error, data)
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub ViewMailLog_handler(sender As HTTPSecureSocket, URL As String, HTTPStatus As Integer, Headers As InternetHeaders, Content As String)
		  #Pragma Unused URL
		  

		  If sender <> nil Then sender.Close()
		  
		  Dim error As New OpenAPIClient.OpenAPIClientException(HTTPStatus, "", Content)
		  
		  Dim data As OpenAPIClient.Models.MailLog
		  Call ViewMailLogPrivateFuncDeserializeResponse(HTTPStatus, Headers, error, Content, data)
		  
		  CallbackHandler.ViewMailLogCallback(error, data)
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
		CallbackHandler As OpenAPIClient.APIs.HistoryApiCallbackHandler
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
