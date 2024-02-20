#tag Class
Protected Class SendMailAdv

	#tag Property, Flags = &h0
		#tag Note
			The subject or title of the email
		#tag EndNote
		subject As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			The main email contents.
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
			(optional) File attachments to include in the email.  The file contents must be base64 encoded!
		#tag EndNote
		attachments() As OpenAPIClient.Models.MailAttachment
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			(optional)  ID of the Mail order within our system to use as the Mail Account.
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


