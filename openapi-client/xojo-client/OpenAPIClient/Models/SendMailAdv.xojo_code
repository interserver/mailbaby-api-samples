#tag Class
Protected Class SendMailAdv

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
		from As OpenAPIClient.Models.EmailAddressTypes
	#tag EndProperty


	#tag Property, Flags = &h0
		Escapedto As OpenAPIClient.Models.EmailAddressesTypes
	#tag EndProperty


	#tag Property, Flags = &h0
		replyto As OpenAPIClient.Models.EmailAddressesTypes
	#tag EndProperty


	#tag Property, Flags = &h0
		cc As OpenAPIClient.Models.EmailAddressesTypes
	#tag EndProperty


	#tag Property, Flags = &h0
		bcc As OpenAPIClient.Models.EmailAddressesTypes
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			Optional list of file attachments.  Each file must be base64-encoded. Include `filename` so recipients see a meaningful attachment name.
		#tag EndNote
		attachments() As OpenAPIClient.Models.MailAttachment
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
			Name="from"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="EmailAddressTypes"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Escapedto"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="EmailAddressesTypes"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="replyto"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="EmailAddressesTypes"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="cc"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="EmailAddressesTypes"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="bcc"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="EmailAddressesTypes"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="attachments"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="MailAttachment"
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


