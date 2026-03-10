#tag Class
Protected Class MailBlocks

	#tag Property, Flags = &h0
		#tag Note
			Messages flagged by the `LOCAL_BL_RCPT` rspamd rule in the last 5 days. These are messages sent to recipients on a local block list.
		#tag EndNote
		local() As OpenAPIClient.Models.MailBlockClickHouse
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			Messages flagged by the `MBTRAP` rspamd rule in the last 5 days. These triggered MailBaby's honeypot / trap address detection.
		#tag EndNote
		mbtrap() As OpenAPIClient.Models.MailBlockClickHouse
	#tag EndProperty


	#tag Property, Flags = &h0
		#tag Note
			Senders whose messages contained spam-indicative subjects (containing `@`, `smtp`, `socks4`, or `socks5`) with more than 4 occurrences of the same subject in the last 3 days.
		#tag EndNote
		subject() As OpenAPIClient.Models.MailBlockRspamd
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
			Name="local"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="MailBlockClickHouse"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="mbtrap"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="MailBlockClickHouse"
			EditorType=""
		#tag EndViewProperty
		#tag ViewProperty
			Name="subject"
			Visible=false
			Group="Behavior"
			InitialValue=""
			Type="MailBlockRspamd"
			EditorType=""
		#tag EndViewProperty
	#tag EndViewBehavior
End Class
#tag EndClass


