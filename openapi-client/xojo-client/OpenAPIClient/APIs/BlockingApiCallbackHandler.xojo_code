#tag Interface
Protected Interface BlockingApiCallbackHandler
	#tag Method, Flags = &h0
		Sub AddRuleCallback(status As OpenAPIClient.OpenAPIClientException, Optional data As OpenAPIClient.Models.GenericResponse)
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h0
		Sub DeleteRuleCallback(status As OpenAPIClient.OpenAPIClientException, Optional data As OpenAPIClient.Models.GenericResponse)
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h0
		Sub DelistBlockCallback(status As OpenAPIClient.OpenAPIClientException, Optional data As OpenAPIClient.Models.GenericResponse)
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h0
		Sub GetMailBlocksCallback(status As OpenAPIClient.OpenAPIClientException, Optional data As OpenAPIClient.Models.MailBlocks)
		  
		End Sub
	#tag EndMethod

	#tag Method, Flags = &h0
		Sub GetRulesCallback(status As OpenAPIClient.OpenAPIClientException, data() As OpenAPIClient.Models.DenyRuleRecord)
		  
		End Sub
	#tag EndMethod




	#tag ViewBehavior
		#tag ViewProperty
			Name="Name"
			Visible=true
			Group="ID"
			Type="String"
		#tag EndViewProperty
		#tag ViewProperty
			Name="Index"
			Visible=true
			Group="ID"
			InitialValue="-2147483648"
			Type="Integer"
		#tag EndViewProperty
		#tag ViewProperty
			Name="Super"
			Visible=true
			Group="ID"
			Type="String"
		#tag EndViewProperty
		#tag ViewProperty
			Name="Left"
			Visible=true
			Group="Position"
			InitialValue="0"
			Type="Integer"
		#tag EndViewProperty
		#tag ViewProperty
			Name="Top"
			Visible=true
			Group="Position"
			InitialValue="0"
			Type="Integer"
		#tag EndViewProperty
	#tag EndViewBehavior
End Interface
#tag EndInterface
