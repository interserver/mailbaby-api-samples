#import <Foundation/Foundation.h>
#import "OAIObject.h"

/**
* Mail Baby API
* This is an API for accesssing the mail services.
*
* The version of the OpenAPI document: 1.0.0
* Contact: detain@interserver.net
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/


#import "OAIMailAttachment.h"
#import "OAIMailContact.h"
@protocol OAIMailAttachment;
@class OAIMailAttachment;
@protocol OAIMailContact;
@class OAIMailContact;



@protocol OAISendMail
@end

@interface OAISendMail : OAIObject

/* The ID of the Mail order within our system to use as the Mail Account. 
 */
@property(nonatomic) NSNumber* _id;

@property(nonatomic) OAIMailContact* from;
/* The Contact whom is the primary recipient of this email. 
 */
@property(nonatomic) NSArray<OAIMailContact>* to;
/* The subject or title of the email 
 */
@property(nonatomic) NSString* subject;
/* The main email contents. 
 */
@property(nonatomic) NSString* body;
/* Optional list of Contacts that specify where replies to the email should be sent instead of the _from_ address. [optional]
 */
@property(nonatomic) NSArray<OAIMailContact>* replyto;
/* Optional list of Contacts that should receive copies of the email.  They are listed on the email and anyone getting the email can see this full list of Contacts who received the email as well. [optional]
 */
@property(nonatomic) NSArray<OAIMailContact>* cc;
/* Optional list of Contacts that should receive copies of the email.  They are hidden on the email and anyone gettitng the email would not see the other people getting the email in this list. [optional]
 */
@property(nonatomic) NSArray<OAIMailContact>* bcc;
/* Optional file attachments to include in the email [optional]
 */
@property(nonatomic) NSArray<OAIMailAttachment>* attachments;

@end