import 'package:jaguar_serializer/jaguar_serializer.dart';


import 'package:openapi/model/mail_attachment.dart';

import 'package:openapi/model/mail_contact.dart';

import 'package:openapi/model/send_mail_adv_from.dart';

part 'send_mail_adv.jser.dart';

class SendMailAdv {
   /* The subject or title of the email */
  @Alias('subject', isNullable: false,  )
  final String subject;
   /* The main email contents. */
  @Alias('body', isNullable: false,  )
  final String body;
   /* The contact whom is the this email is from. */
  @Alias('from', isNullable: false,  )
  final List<SendMailAdvFrom> from;
   /* The Contact whom is the primary recipient of this email. */
  @Alias('to', isNullable: false,  )
  final List<MailContact> to;
   /* The ID of the Mail order within our system to use as the Mail Account. */
  @Alias('id', isNullable: false,  )
  final int id;
   /* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. */
  @Alias('replyto', isNullable: false,  )
  final List<MailContact> replyto;
   /* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. */
  @Alias('cc', isNullable: false,  )
  final List<MailContact> cc;
   /* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. */
  @Alias('bcc', isNullable: false,  )
  final List<MailContact> bcc;
   /* Optional file attachments to include in the email */
  @Alias('attachments', isNullable: false,  )
  final List<MailAttachment> attachments;
  

  SendMailAdv(
      

{
    
     this.subject = null,  
     this.body = null,  
     this.from = const [],  
     this.to = const [],  
     this.id = null,   this.replyto = const [],  
     this.cc = const [],  
     this.bcc = const [],  
     this.attachments = const [] 
    
    }
  );

  @override
  String toString() {
    return 'SendMailAdv[subject=$subject, body=$body, from=$from, to=$to, id=$id, replyto=$replyto, cc=$cc, bcc=$bcc, attachments=$attachments, ]';
  }
}

@GenSerializer(nullableFields: true)
class SendMailAdvSerializer extends Serializer<SendMailAdv> with _$SendMailAdvSerializer {

}

