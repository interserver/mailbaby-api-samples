@isTest
private class OASSendMailAdvCcInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailAdvCcInner sendMailAdvCcInner1 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner2 = sendMailAdvCcInner1;
        OASSendMailAdvCcInner sendMailAdvCcInner3 = new OASSendMailAdvCcInner();
        OASSendMailAdvCcInner sendMailAdvCcInner4 = sendMailAdvCcInner3;

        System.assert(sendMailAdvCcInner1.equals(sendMailAdvCcInner2));
        System.assert(sendMailAdvCcInner2.equals(sendMailAdvCcInner1));
        System.assert(sendMailAdvCcInner1.equals(sendMailAdvCcInner1));
        System.assert(sendMailAdvCcInner3.equals(sendMailAdvCcInner4));
        System.assert(sendMailAdvCcInner4.equals(sendMailAdvCcInner3));
        System.assert(sendMailAdvCcInner3.equals(sendMailAdvCcInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailAdvCcInner sendMailAdvCcInner1 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner2 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner3 = new OASSendMailAdvCcInner();
        OASSendMailAdvCcInner sendMailAdvCcInner4 = new OASSendMailAdvCcInner();

        System.assert(sendMailAdvCcInner1.equals(sendMailAdvCcInner2));
        System.assert(sendMailAdvCcInner2.equals(sendMailAdvCcInner1));
        System.assert(sendMailAdvCcInner3.equals(sendMailAdvCcInner4));
        System.assert(sendMailAdvCcInner4.equals(sendMailAdvCcInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailAdvCcInner sendMailAdvCcInner1 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner2 = new OASSendMailAdvCcInner();

        System.assertEquals(false, sendMailAdvCcInner1.equals('foo'));
        System.assertEquals(false, sendMailAdvCcInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailAdvCcInner sendMailAdvCcInner1 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner2 = new OASSendMailAdvCcInner();
        OASSendMailAdvCcInner sendMailAdvCcInner3;

        System.assertEquals(false, sendMailAdvCcInner1.equals(sendMailAdvCcInner3));
        System.assertEquals(false, sendMailAdvCcInner2.equals(sendMailAdvCcInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailAdvCcInner sendMailAdvCcInner1 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner2 = new OASSendMailAdvCcInner();

        System.assertEquals(sendMailAdvCcInner1.hashCode(), sendMailAdvCcInner1.hashCode());
        System.assertEquals(sendMailAdvCcInner2.hashCode(), sendMailAdvCcInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailAdvCcInner sendMailAdvCcInner1 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner2 = OASSendMailAdvCcInner.getExample();
        OASSendMailAdvCcInner sendMailAdvCcInner3 = new OASSendMailAdvCcInner();
        OASSendMailAdvCcInner sendMailAdvCcInner4 = new OASSendMailAdvCcInner();

        System.assert(sendMailAdvCcInner1.equals(sendMailAdvCcInner2));
        System.assert(sendMailAdvCcInner3.equals(sendMailAdvCcInner4));
        System.assertEquals(sendMailAdvCcInner1.hashCode(), sendMailAdvCcInner2.hashCode());
        System.assertEquals(sendMailAdvCcInner3.hashCode(), sendMailAdvCcInner4.hashCode());
    }
}
