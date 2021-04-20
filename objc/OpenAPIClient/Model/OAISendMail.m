#import "OAISendMail.h"

@implementation OAISendMail

- (instancetype)init {
  self = [super init];
  if (self) {
    // initialize property's default value, if any
    
  }
  return self;
}


/**
 * Maps json key to property name.
 * This method is used by `JSONModel`.
 */
+ (JSONKeyMapper *)keyMapper {
  return [[JSONKeyMapper alloc] initWithModelToJSONDictionary:@{ @"_id": @"id", @"from": @"from", @"to": @"to", @"subject": @"subject", @"body": @"body", @"replyto": @"replyto", @"cc": @"cc", @"bcc": @"bcc", @"attachments": @"attachments" }];
}

/**
 * Indicates whether the property with the given name is optional.
 * If `propertyName` is optional, then return `YES`, otherwise return `NO`.
 * This method is used by `JSONModel`.
 */
+ (BOOL)propertyIsOptional:(NSString *)propertyName {

  NSArray *optionalProperties = @[@"replyto", @"cc", @"bcc", @"attachments"];
  return [optionalProperties containsObject:propertyName];
}

@end
