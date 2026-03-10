#tag Class
Protected Class SendMail

	#tag Property, Flags = &h0
		Escapedto As OpenAPIClient.Models.SendMailTo
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			The sender address.  This is used as both the `From` header and the `Reply-To` header automatically.  Must be a valid email address authorized for your mail order.
		#tag EndNote
		from As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			The subject line of the email.
		#tag EndNote
		subject As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			The email body.  If the string contains any HTML tags the message is automatically sent as `text/html`; otherwise it is sent as `text/plain`.
		#tag EndNote
		body As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			Optional numeric ID of the mail order to send through.  If omitted the first active order on your account is used automatically.  Valid IDs are returned by `GET /mail`.
		#tag EndNote
		id As Xoson.O.OptionalInt64
	#tag EndProperty





	#tag ViewBehavior
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
			Name="Escapedto"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="SendMailTo"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="from"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="subject"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="body"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="id"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Int64"
			EditorType=""
		#tag EndViewProperty
	#tag EndViewBehavior
End Class
#tag EndClass


