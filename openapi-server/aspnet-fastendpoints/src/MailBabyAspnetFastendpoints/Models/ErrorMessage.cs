namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// The response body returned when an error occurs.
/// </summary>
public class ErrorMessage 
{
    public int Code { get; set; }
    public string Message { get; set; }
}


