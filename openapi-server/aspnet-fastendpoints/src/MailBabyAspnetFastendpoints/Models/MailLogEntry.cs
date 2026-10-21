namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// A single email record in the mail log.  Combines data from the message store (envelope metadata), the queue release table (delivery status and response), and the sender delivery table (MX routing details).  Key field relationships with other API calls: - The &#x60;id&#x60; field matches the &#x60;mailid&#x60; query parameter on &#x60;GET /mail/log&#x60; and   the &#x60;text&#x60; field of a successful send response. - The &#x60;from&#x60; address can be passed to &#x60;POST /mail/blocks/delete&#x60; to delist a   flagged sender. - The &#x60;user&#x60; field is the SMTP username (e.g. &#x60;mb5658&#x60;) corresponding to the   &#x60;username&#x60; field in &#x60;GET /mail&#x60; / &#x60;GET /mail/{id}&#x60;.
/// </summary>
public class MailLogEntry 
{
    public int Id2 { get; set; }
    public string Id { get; set; }
    public string From { get; set; }
    public string To { get; set; }
    public string Created { get; set; }
    public int Time { get; set; }
    public string User { get; set; }
    public string Transtype { get; set; }
    public string Origin { get; set; }
    public string Interface { get; set; }
    public string Subject { get; set; }
    public string MessageId { get; set; }
    public string SendingZone { get; set; }
    public int BodySize { get; set; }
    public int Seq { get; set; }
    public int Delivered { get; set; }
    public int Code { get; set; }
    public string Response { get; set; }
    public string Recipient { get; set; }
    public string Domain { get; set; }
    public int Locked { get; set; }
    public string LockTime { get; set; }
    public string Assigned { get; set; }
    public string Queued { get; set; }
    public string MxHostname { get; set; }
}


