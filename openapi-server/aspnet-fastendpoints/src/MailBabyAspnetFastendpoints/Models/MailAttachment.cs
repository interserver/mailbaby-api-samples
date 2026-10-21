namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// A file attachment for use with &#x60;POST /mail/advsend&#x60;.  The file content must be base64-encoded.  The &#x60;filename&#x60; is shown to recipients in their email client.
/// </summary>
public class MailAttachment 
{
    public string Filename { get; set; }
    public byte[] Data { get; set; }
}


