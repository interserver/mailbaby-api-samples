@isTest
private class OASSendMailAdvToInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailAdvToInner sendMailAdvToInner1 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner2 = sendMailAdvToInner1;
        OASSendMailAdvToInner sendMailAdvToInner3 = new OASSendMailAdvToInner();
        OASSendMailAdvToInner sendMailAdvToInner4 = sendMailAdvToInner3;

        System.assert(sendMailAdvToInner1.equals(sendMailAdvToInner2));
        System.assert(sendMailAdvToInner2.equals(sendMailAdvToInner1));
        System.assert(sendMailAdvToInner1.equals(sendMailAdvToInner1));
        System.assert(sendMailAdvToInner3.equals(sendMailAdvToInner4));
        System.assert(sendMailAdvToInner4.equals(sendMailAdvToInner3));
        System.assert(sendMailAdvToInner3.equals(sendMailAdvToInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailAdvToInner sendMailAdvToInner1 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner2 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner3 = new OASSendMailAdvToInner();
        OASSendMailAdvToInner sendMailAdvToInner4 = new OASSendMailAdvToInner();

        System.assert(sendMailAdvToInner1.equals(sendMailAdvToInner2));
        System.assert(sendMailAdvToInner2.equals(sendMailAdvToInner1));
        System.assert(sendMailAdvToInner3.equals(sendMailAdvToInner4));
        System.assert(sendMailAdvToInner4.equals(sendMailAdvToInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailAdvToInner sendMailAdvToInner1 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner2 = new OASSendMailAdvToInner();

        System.assertEquals(false, sendMailAdvToInner1.equals('foo'));
        System.assertEquals(false, sendMailAdvToInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailAdvToInner sendMailAdvToInner1 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner2 = new OASSendMailAdvToInner();
        OASSendMailAdvToInner sendMailAdvToInner3;

        System.assertEquals(false, sendMailAdvToInner1.equals(sendMailAdvToInner3));
        System.assertEquals(false, sendMailAdvToInner2.equals(sendMailAdvToInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailAdvToInner sendMailAdvToInner1 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner2 = new OASSendMailAdvToInner();

        System.assertEquals(sendMailAdvToInner1.hashCode(), sendMailAdvToInner1.hashCode());
        System.assertEquals(sendMailAdvToInner2.hashCode(), sendMailAdvToInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailAdvToInner sendMailAdvToInner1 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner2 = OASSendMailAdvToInner.getExample();
        OASSendMailAdvToInner sendMailAdvToInner3 = new OASSendMailAdvToInner();
        OASSendMailAdvToInner sendMailAdvToInner4 = new OASSendMailAdvToInner();

        System.assert(sendMailAdvToInner1.equals(sendMailAdvToInner2));
        System.assert(sendMailAdvToInner3.equals(sendMailAdvToInner4));
        System.assertEquals(sendMailAdvToInner1.hashCode(), sendMailAdvToInner2.hashCode());
        System.assertEquals(sendMailAdvToInner3.hashCode(), sendMailAdvToInner4.hashCode());
    }
}
