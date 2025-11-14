#tag Class
Protected Class MailLog

	#tag Property, Flags = &h0
		#tag Note
			total number of mail log entries
		#tag EndNote
		total As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			number of emails skipped in listing
		#tag EndNote
		skip As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			number of emails to return
		#tag EndNote
		limit As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		emails() As OpenAPIClient.Models.MailLogEntry
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
			Name="total"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="skip"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="limit"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="emails"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="MailLogEntry"
			EditorType=""
		#tag EndViewProperty
	#tag EndViewBehavior
End Class
#tag EndClass


