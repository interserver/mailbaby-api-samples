namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Request body for &#x60;POST /mail/rawsend&#x60;.  Accepts a complete RFC 822 message (all headers and body) as a verbatim string.  The relay injects it without modification, preserving any existing &#x60;DKIM-Signature&#x60; header intact.  The &#x60;From&#x60;, &#x60;To&#x60;, &#x60;Cc&#x60;, and &#x60;Bcc&#x60; addresses are extracted from the message headers automatically — you do not need to specify them separately.
/// </summary>
public class SendMailRaw 
{
    public string RawEmail { get; set; }
    public long Id { get; set; }
}


