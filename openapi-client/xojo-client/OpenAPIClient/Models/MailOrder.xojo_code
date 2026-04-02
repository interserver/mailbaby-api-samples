#tag Class
Protected Class MailOrder

	#tag Property, Flags = &h0
		#tag Note
			The unique numeric ID of the mail order.  Used as the `id` parameter on sending calls, log queries, and stats queries.
		#tag EndNote
		id As Integer
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			The current order status.  Only `active` orders can be used for sending. `canceled` orders are retained for history but cannot send.
		#tag EndNote
		status As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			The SMTP AUTH username for this order, always in the format `mb<id>`. Use together with the password from `GET /mail/{id}` to authenticate directly against `relay.mailbaby.net:25` if needed.
		#tag EndNote
		username As String
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			Optional human-readable note associated with the order.  Only present in the response when the order has a non-empty comment.
		#tag EndNote
		comment As Xoson.O.OptionalString
	#tag EndProperty


    #tag Enum, Name = StatusEnum, Type = Integer, Flags = &h0
        
        Active
        Canceled
        
    #tag EndEnum


	#tag Method, Flags = &h0
		Shared Function StatusEnumToString(value As StatusEnum) As String
		  Select Case value
		    
		    Case StatusEnum.Active
		      Return "active"
		    Case StatusEnum.Canceled
		      Return "canceled"
		    
		  End Select
		  Return ""
		End Function
	#tag EndMethod


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
			Name="id"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="Integer"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="username"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="comment"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="String"
			EditorType=""
		#tag EndViewProperty
	#tag EndViewBehavior
End Class
#tag EndClass


