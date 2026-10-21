namespace MailBabyAspnetFastendpoints.Models;


/// <summary>
/// Top-500 breakdown of message counts within the selected time window, grouped by originating IP, destination address, and sender address.
/// </summary>
public class MailStatsVolume 
{
    public Dictionary<string, int> To { get; set; }
    public Dictionary<string, int> From { get; set; }
    public Dictionary<string, int> Ip { get; set; }
}


