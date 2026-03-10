#tag Class
Protected Class HistoryApi
	#tag Method, Flags = &h0
		Sub GetStats(, time As TimeEnum_GetStats)
		  // Operation getStats
		  // Account usage statistics
		  // - 
		  // - parameter time: (query) The time window to scope &#x60;received&#x60;, &#x60;sent&#x60;, and &#x60;volume&#x60; statistics. Does not affect &#x60;usage&#x60; or &#x60;cost&#x60;, which are always calculated over the current billing cycle.  Defaults to &#x60;1h&#x60;. (optional, default to 1h)
		  //
		  // Invokes HistoryApiCallbackHandler.GetStatsCallback(MailStatsType) on completion. 
		  //
		  // - GET /mail/stats
		  // - Returns aggregate sending statistics for your mail account(s) across a selectable time window.  Useful for dashboards, billing reviews, and detecting unusual traffic patterns.  The response includes: - **`usage`** — total messages accepted by the relay during the current billing   cycle (used for cost calculation). - **`cost`** — estimated cost for the billing cycle based on the base plan price   plus per-email charges. - **`received`** / **`sent`** — count of messages accepted by the relay /   successfully delivered to the destination MX within the selected `time` window. - **`volume`** — top-500 breakdown of message counts grouped by source IP (`ip`),   destination address (`to`), and sender address (`from`) within the selected window.   **Time windows** (controlled by the `time` parameter): | Value | Window | |-------|--------| | `1h` | Last 1 hour (default) | | `24h` | Last 24 hours | | `7d` | Last 7 days | | `month` | Current calendar month (1st to now) | | `day` | Today (midnight to now) | | `billing` | Current billing cycle (last invoice date to next invoice date) | | `all` | All time | 
		  // - defaultResponse: Nil
		  //
		  // - API Key:
		  //   - type: apiKey X-API-KEY (HEADER)
		  //   - name: apiKeyAuth
		  //
		  
		  Dim localVarHTTPSocket As New HTTPSecureSocket
		  Me.PrivateFuncPrepareSocket(localVarHTTPSocket)
		  
		  Dim localVarQueryParams As String = "?"
		  localVarQueryParams = localVarQueryParams + EncodeURLComponent("time") + "=" + EncodeURLComponent(TimeEnum_GetStatsToString(time))
		  

		  If me.ApiKeyapiKeyAuth = "" Then Raise New OpenAPIClient.OpenAPIClientException(kErrorCannotAuthenticate, "API key is unset. Please assign a value to `HistoryApi.ApiKeyapiKeyAuth` before invoking `HistoryApi.GetStats()`.")
		  
		  localVarHTTPSocket.SetRequestHeader(EncodeURLComponent("X-API-KEY"), EncodeURLComponent(me.ApiKeyapiKeyAuth))
		  


		  Dim localVarPath As String = "/mail/stats"
		  
		  
		  
		  AddHandler localVarHTTPSocket.PageReceived, addressof me.GetStats_handler
		  AddHandler localVarHTTPSocket.Error, addressof Me.GetStats_error
		  
		  
		  localVarHTTPSocket.SendRequest("GET", Me.BasePath + localVarPath + localVarQueryParams)
		  if localVarHTTPSocket.LastErrorCode <> 0 then
		    Dim localVarException As New OpenAPIClient.OpenAPIClientException(localVarHTTPSocket.LastErrorCode)
			Raise localVarException
		  end if
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Function GetStatsPrivateFuncDeserializeResponse(HTTPStatus As Integer, Headers As InternetHeaders, error As OpenAPIClient.OpenAPIClientException, Content As String, ByRef outData As OpenAPIClient.Models.MailStatsType) As Boolean
		  Dim contentType As String = Headers.Value("Content-Type")
		  Dim contentEncoding As TextEncoding = OpenAPIClient.EncodingFromContentType(contentType)
		  Content = DefineEncoding(Content, contentEncoding)
		  
		  If HTTPStatus > 199 and HTTPStatus < 300 then
		    If contentType.LeftB(16) = "application/json" then
		      
			  outData = New OpenAPIClient.Models.MailStatsType
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
		  Dim data As OpenAPIClient.Models.MailStatsType
		  CallbackHandler.GetStatsCallback(error, data)
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h21
		Private Sub GetStats_handler(sender As HTTPSecureSocket, URL As String, HTTPStatus As Integer, Headers As InternetHeaders, Content As String)
		  #Pragma Unused URL
		  

		  If sender <> nil Then sender.Close()
		  
		  Dim error As New OpenAPIClient.OpenAPIClientException(HTTPStatus, "", Content)
		  
		  Dim data As OpenAPIClient.Models.MailStatsType
		  Call GetStatsPrivateFuncDeserializeResponse(HTTPStatus, Headers, error, Content, data)
		  
		  CallbackHandler.GetStatsCallback(error, data)
		End Sub
	#tag EndMethod



	#tag Method, Flags = &h21
		Private Function TimeEnum_GetStatsToString(value As TimeEnum_GetStats) As String
		  Select Case value
		    
		    Case TimeEnum_GetStats.All
		      Return "all"
		    Case TimeEnum_GetStats.Billing
		      Return "billing"
		    Case TimeEnum_GetStats.Month
		      Return "month"
		    Case TimeEnum_GetStats.Escaped7d
		      Return "7d"
		    Case TimeEnum_GetStats.Escaped24h
		      Return "24h"
		    Case TimeEnum_GetStats.Day
		      Return "day"
		    Case TimeEnum_GetStats.Escaped1h
		      Return "1h"
		    
		  End Select
		  Return ""
		End Function
	#tag EndMethod

	#tag Method, Flags = &h0
		Sub ViewMailLog(, Optional id As Xoson.O.OptionalInt64, Optional origin As Xoson.O.OptionalString, Optional mx As Xoson.O.OptionalString, Optional from As Xoson.O.OptionalString, Optional Escapedto As Xoson.O.OptionalString, Optional subject As Xoson.O.OptionalString, Optional mailid As Xoson.O.OptionalString, Optional messageId As Xoson.O.OptionalString, Optional replyto As Xoson.O.OptionalString, Optional headerfrom As Xoson.O.OptionalString, delivered As DeliveredEnum_ViewMailLog, Optional skip As Xoson.O.OptionalInteger, Optional limit As Xoson.O.OptionalInteger, Optional startDate As Xoson.O.OptionalInt64, Optional endDate As Xoson.O.OptionalInt64)
		  // Operation viewMailLog
		  // Displays the mail log
		  // - 
		  // - parameter id: (query) The numeric ID of the mail order to filter by.  When omitted, logs from the first active mail order are returned.  Obtain valid IDs from &#x60;GET /mail&#x60; or &#x60;GET /mail/{id}&#x60;. (optional, default to 0)
		  // - parameter origin: (query) Filter by the originating IP address from which the message was submitted to the relay.  Must be a valid IPv4 or IPv6 address. (optional, default to Sample)
		  // - parameter mx: (query) Filter by the MX hostname the relay attempted delivery to.  For example &#x60;mx.google.com&#x60; would return messages destined for Gmail recipients. Maps to &#x60;mxHostname&#x60; in the &#x60;MailLogEntry&#x60; response. (optional, default to Sample)
		  // - parameter from: (query) Filter by SMTP envelope &#x60;MAIL FROM&#x60; address (exact match).  This is the address the relay used for bounce handling and may differ from the &#x60;From:&#x60; message header.  For header-level filtering use &#x60;headerfrom&#x60;. (optional, default to Sample)
		  // - parameter Escapedto: (query) Filter by SMTP envelope &#x60;RCPT TO&#x60; address (exact match).  This is the delivery address used by the relay and may differ from the &#x60;To:&#x60; header when BCC recipients are involved. (optional, default to Sample)
		  // - parameter subject: (query) Filter by email &#x60;Subject&#x60; header (exact match).  To search for a substring, include it in the full subject text. (optional, default to Sample)
		  // - parameter mailid: (query) Filter by the relay-assigned mail ID string (exact match).  This corresponds to the &#x60;id&#x60; field in &#x60;MailLogEntry&#x60; and to the &#x60;text&#x60; value returned by the sending endpoints on success.  Format is an 18–19 character hexadecimal string such as &#x60;185997065c60008840&#x60;. (optional, default to Sample)
		  // - parameter messageId: (query) Filter by the &#x60;Message-ID&#x60; email header using a substring (case-insensitive) match.  The &#x60;Message-ID&#x60; is assigned by the sending mail client and is visible in the &#x60;messageId&#x60; field of &#x60;MailLogEntry&#x60;.  Useful when you know the message ID generated by your application but not the relay &#x60;mailid&#x60;. (optional, default to Sample)
		  // - parameter replyto: (query) Filter by the &#x60;Reply-To&#x60; message header address (exact match).  Only returns messages where this header was explicitly set. (optional, default to Sample)
		  // - parameter headerfrom: (query) Filter by the &#x60;From&#x60; message header address (exact match).  This is the human-visible sender address and may differ from the SMTP envelope &#x60;from&#x60; parameter when sending on behalf of another address. (optional, default to Sample)
		  // - parameter delivered: (query) Filter by delivery status.  &#x60;1&#x60; returns only messages that were successfully delivered to the destination MX.  &#x60;0&#x60; returns messages that are still queued, deferred, or failed.  Omit to return all messages regardless of delivery status. (optional, default to 0)
		  // - parameter skip: (query) Number of records to skip for pagination.  Use in combination with &#x60;limit&#x60; to page through large result sets.  Defaults to &#x60;0&#x60; (no skip). (optional, default to 0)
		  // - parameter limit: (query) Maximum number of records to return per page.  Defaults to &#x60;100&#x60;. Maximum allowed value is &#x60;10000&#x60;.  The response also includes a &#x60;total&#x60; field with the full matched count so you can calculate the number of pages. (optional, default to 100)
		  // - parameter startDate: (query) Earliest date to include, as a Unix timestamp (seconds since epoch). Messages with a &#x60;time&#x60; value **greater than or equal to** this value will be included. (optional, default to 0)
		  // - parameter endDate: (query) Latest date to include, as a Unix timestamp (seconds since epoch). Messages with a &#x60;time&#x60; value **less than or equal to** this value will be included. (optional, default to 0)
		  //
		  // Invokes HistoryApiCallbackHandler.ViewMailLogCallback(MailLog) on completion. 
		  //
		  // - GET /mail/log
		  // - Returns a paginated list of every email message accepted by the relay for your mail account(s).  All filter parameters are optional and combinable.  **Pagination** is controlled by `skip` and `limit`.  The response includes a `total` count so clients can determine how many pages exist.  **Date filtering** uses Unix timestamps (`startDate` / `endDate`).  For example, to retrieve emails sent in January 2024: `startDate=1704067200&endDate=1706745599`.  **Delivery status** can be filtered with the `delivered` parameter: `delivered=1` returns only successfully delivered messages; `delivered=0` returns messages still in queue or that failed.  **Address filtering** distinguishes between the SMTP envelope address (`from`, `to`) and message headers (`headerfrom` for the `From:` header, `replyto` for `Reply-To:`). These may differ when a message is sent on behalf of another address.  The `mailid` parameter corresponds to the `id` field in the returned `MailLogEntry` objects, **not** the `_id` field.  It also matches the transaction ID returned in the `text` field of a successful send response from `/mail/send`, `/mail/advsend`, or `/mail/rawsend`.  The `messageId` parameter searches the `Message-ID` email header (case-insensitive substring match). 
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
		  
		  If messageId <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("messageId") + "=" + EncodeURLComponent(messageId)
		  
		  If replyto <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("replyto") + "=" + EncodeURLComponent(replyto)
		  
		  If headerfrom <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("headerfrom") + "=" + EncodeURLComponent(headerfrom)
		  
		  localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("delivered") + "=" + EncodeURLComponent(DeliveredEnum_ViewMailLogToString(delivered))
		  
		  If skip <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("skip") + "=" + EncodeURLComponent(skip.ToString)
		  
		  If limit <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("limit") + "=" + EncodeURLComponent(limit.ToString)
		  
		  If startDate <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("startDate") + "=" + EncodeURLComponent(startDate.ToString)
		  
		  If endDate <> nil Then localVarQueryParams = localVarQueryParams + "&" + EncodeURLComponent("endDate") + "=" + EncodeURLComponent(endDate.ToString)
		  

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

	#tag Enum, Name = TimeEnum_GetStats, Type = Integer, Flags = &h0
		
        All
        Billing
        Month
        Escaped7d
        Escaped24h
        Day
        Escaped1h
		
	#tag EndEnum

	#tag Enum, Name = DeliveredEnum_ViewMailLog, Type = Integer, Flags = &h0
		
        NotDelivered = "0"
        Delivered = "1"
		
	#tag EndEnum


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
