@isTest
private class OASSendMailAdvAttachmentsInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner1 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner2 = sendMailAdvAttachmentsInner1;
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner3 = new OASSendMailAdvAttachmentsInner();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner4 = sendMailAdvAttachmentsInner3;

        System.assert(sendMailAdvAttachmentsInner1.equals(sendMailAdvAttachmentsInner2));
        System.assert(sendMailAdvAttachmentsInner2.equals(sendMailAdvAttachmentsInner1));
        System.assert(sendMailAdvAttachmentsInner1.equals(sendMailAdvAttachmentsInner1));
        System.assert(sendMailAdvAttachmentsInner3.equals(sendMailAdvAttachmentsInner4));
        System.assert(sendMailAdvAttachmentsInner4.equals(sendMailAdvAttachmentsInner3));
        System.assert(sendMailAdvAttachmentsInner3.equals(sendMailAdvAttachmentsInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner1 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner2 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner3 = new OASSendMailAdvAttachmentsInner();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner4 = new OASSendMailAdvAttachmentsInner();

        System.assert(sendMailAdvAttachmentsInner1.equals(sendMailAdvAttachmentsInner2));
        System.assert(sendMailAdvAttachmentsInner2.equals(sendMailAdvAttachmentsInner1));
        System.assert(sendMailAdvAttachmentsInner3.equals(sendMailAdvAttachmentsInner4));
        System.assert(sendMailAdvAttachmentsInner4.equals(sendMailAdvAttachmentsInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner1 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner2 = new OASSendMailAdvAttachmentsInner();

        System.assertEquals(false, sendMailAdvAttachmentsInner1.equals('foo'));
        System.assertEquals(false, sendMailAdvAttachmentsInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner1 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner2 = new OASSendMailAdvAttachmentsInner();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner3;

        System.assertEquals(false, sendMailAdvAttachmentsInner1.equals(sendMailAdvAttachmentsInner3));
        System.assertEquals(false, sendMailAdvAttachmentsInner2.equals(sendMailAdvAttachmentsInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner1 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner2 = new OASSendMailAdvAttachmentsInner();

        System.assertEquals(sendMailAdvAttachmentsInner1.hashCode(), sendMailAdvAttachmentsInner1.hashCode());
        System.assertEquals(sendMailAdvAttachmentsInner2.hashCode(), sendMailAdvAttachmentsInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner1 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner2 = OASSendMailAdvAttachmentsInner.getExample();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner3 = new OASSendMailAdvAttachmentsInner();
        OASSendMailAdvAttachmentsInner sendMailAdvAttachmentsInner4 = new OASSendMailAdvAttachmentsInner();

        System.assert(sendMailAdvAttachmentsInner1.equals(sendMailAdvAttachmentsInner2));
        System.assert(sendMailAdvAttachmentsInner3.equals(sendMailAdvAttachmentsInner4));
        System.assertEquals(sendMailAdvAttachmentsInner1.hashCode(), sendMailAdvAttachmentsInner2.hashCode());
        System.assertEquals(sendMailAdvAttachmentsInner3.hashCode(), sendMailAdvAttachmentsInner4.hashCode());
    }
}
