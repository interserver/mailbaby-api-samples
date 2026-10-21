with Servlet.Server.Web;
with MailBabyAdaServer.Server;
procedure MailBabyAdaServer_AWS is
   Container : Servlet.Server.Web.AWS_Container;
begin
   MailBabyAdaServer.Server (Container);
end MailBabyAdaServer_AWS;
