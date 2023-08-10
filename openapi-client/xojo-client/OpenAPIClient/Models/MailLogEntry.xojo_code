#tag Class
Protected Class MailLogEntry

	#tag Property, Flags = &h0
		#tag Note
			internal db id
		#tag EndNote
		_id As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			mail id
		#tag EndNote
		id As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			from address
		#tag EndNote
		from As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			to address
		#tag EndNote
		Escapedto As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			email subject
		#tag EndNote
		subject As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			creation date
		#tag EndNote
		created As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			creation timestamp
		#tag EndNote
		time As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			user account
		#tag EndNote
		user As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			transaction type
		#tag EndNote
		transtype As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			origin ip
		#tag EndNote
		origin As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			interface name
		#tag EndNote
		Escapedinterface As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			sending zone
		#tag EndNote
		sendingZone As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			email body size in bytes
		#tag EndNote
		bodySize As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			index of email in the to adderess list
		#tag EndNote
		seq As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			to address this email is being sent to
		#tag EndNote
		recipient As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			to address domain
		#tag EndNote
		domain As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			locked status
		#tag EndNote
		locked As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			lock timestamp
		#tag EndNote
		lockTime As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			assigned server
		#tag EndNote
		assigned As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			queued timestamp
		#tag EndNote
		queued As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			mx hostname
		#tag EndNote
		mxHostname As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			mail delivery response
		#tag EndNote
		response As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			message id
		#tag EndNote
		messageId As Xoson.O.OptionalString
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
			Name="_id"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="id"
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
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Escapedto"
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
			Name="created"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="time"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="user"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="transtype"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="origin"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="Escapedinterface"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="sendingZone"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="bodySize"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="seq"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="recipient"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="domain"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="locked"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="lockTime"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="assigned"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="queued"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="mxHostname"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="response"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="messageId"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
	#tag EndViewBehavior
End Class
#tag EndClass


