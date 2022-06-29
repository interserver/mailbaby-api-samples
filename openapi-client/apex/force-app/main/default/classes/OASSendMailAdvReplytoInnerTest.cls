@isTest
private class OASSendMailAdvReplytoInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner1 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner2 = sendMailAdvReplytoInner1;
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner3 = new OASSendMailAdvReplytoInner();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner4 = sendMailAdvReplytoInner3;

        System.assert(sendMailAdvReplytoInner1.equals(sendMailAdvReplytoInner2));
        System.assert(sendMailAdvReplytoInner2.equals(sendMailAdvReplytoInner1));
        System.assert(sendMailAdvReplytoInner1.equals(sendMailAdvReplytoInner1));
        System.assert(sendMailAdvReplytoInner3.equals(sendMailAdvReplytoInner4));
        System.assert(sendMailAdvReplytoInner4.equals(sendMailAdvReplytoInner3));
        System.assert(sendMailAdvReplytoInner3.equals(sendMailAdvReplytoInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner1 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner2 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner3 = new OASSendMailAdvReplytoInner();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner4 = new OASSendMailAdvReplytoInner();

        System.assert(sendMailAdvReplytoInner1.equals(sendMailAdvReplytoInner2));
        System.assert(sendMailAdvReplytoInner2.equals(sendMailAdvReplytoInner1));
        System.assert(sendMailAdvReplytoInner3.equals(sendMailAdvReplytoInner4));
        System.assert(sendMailAdvReplytoInner4.equals(sendMailAdvReplytoInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner1 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner2 = new OASSendMailAdvReplytoInner();

        System.assertEquals(false, sendMailAdvReplytoInner1.equals('foo'));
        System.assertEquals(false, sendMailAdvReplytoInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner1 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner2 = new OASSendMailAdvReplytoInner();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner3;

        System.assertEquals(false, sendMailAdvReplytoInner1.equals(sendMailAdvReplytoInner3));
        System.assertEquals(false, sendMailAdvReplytoInner2.equals(sendMailAdvReplytoInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner1 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner2 = new OASSendMailAdvReplytoInner();

        System.assertEquals(sendMailAdvReplytoInner1.hashCode(), sendMailAdvReplytoInner1.hashCode());
        System.assertEquals(sendMailAdvReplytoInner2.hashCode(), sendMailAdvReplytoInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner1 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner2 = OASSendMailAdvReplytoInner.getExample();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner3 = new OASSendMailAdvReplytoInner();
        OASSendMailAdvReplytoInner sendMailAdvReplytoInner4 = new OASSendMailAdvReplytoInner();

        System.assert(sendMailAdvReplytoInner1.equals(sendMailAdvReplytoInner2));
        System.assert(sendMailAdvReplytoInner3.equals(sendMailAdvReplytoInner4));
        System.assertEquals(sendMailAdvReplytoInner1.hashCode(), sendMailAdvReplytoInner2.hashCode());
        System.assertEquals(sendMailAdvReplytoInner3.hashCode(), sendMailAdvReplytoInner4.hashCode());
    }
}
