@isTest
private class OASSendMailAdvBccInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailAdvBccInner sendMailAdvBccInner1 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner2 = sendMailAdvBccInner1;
        OASSendMailAdvBccInner sendMailAdvBccInner3 = new OASSendMailAdvBccInner();
        OASSendMailAdvBccInner sendMailAdvBccInner4 = sendMailAdvBccInner3;

        System.assert(sendMailAdvBccInner1.equals(sendMailAdvBccInner2));
        System.assert(sendMailAdvBccInner2.equals(sendMailAdvBccInner1));
        System.assert(sendMailAdvBccInner1.equals(sendMailAdvBccInner1));
        System.assert(sendMailAdvBccInner3.equals(sendMailAdvBccInner4));
        System.assert(sendMailAdvBccInner4.equals(sendMailAdvBccInner3));
        System.assert(sendMailAdvBccInner3.equals(sendMailAdvBccInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailAdvBccInner sendMailAdvBccInner1 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner2 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner3 = new OASSendMailAdvBccInner();
        OASSendMailAdvBccInner sendMailAdvBccInner4 = new OASSendMailAdvBccInner();

        System.assert(sendMailAdvBccInner1.equals(sendMailAdvBccInner2));
        System.assert(sendMailAdvBccInner2.equals(sendMailAdvBccInner1));
        System.assert(sendMailAdvBccInner3.equals(sendMailAdvBccInner4));
        System.assert(sendMailAdvBccInner4.equals(sendMailAdvBccInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailAdvBccInner sendMailAdvBccInner1 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner2 = new OASSendMailAdvBccInner();

        System.assertEquals(false, sendMailAdvBccInner1.equals('foo'));
        System.assertEquals(false, sendMailAdvBccInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailAdvBccInner sendMailAdvBccInner1 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner2 = new OASSendMailAdvBccInner();
        OASSendMailAdvBccInner sendMailAdvBccInner3;

        System.assertEquals(false, sendMailAdvBccInner1.equals(sendMailAdvBccInner3));
        System.assertEquals(false, sendMailAdvBccInner2.equals(sendMailAdvBccInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailAdvBccInner sendMailAdvBccInner1 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner2 = new OASSendMailAdvBccInner();

        System.assertEquals(sendMailAdvBccInner1.hashCode(), sendMailAdvBccInner1.hashCode());
        System.assertEquals(sendMailAdvBccInner2.hashCode(), sendMailAdvBccInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailAdvBccInner sendMailAdvBccInner1 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner2 = OASSendMailAdvBccInner.getExample();
        OASSendMailAdvBccInner sendMailAdvBccInner3 = new OASSendMailAdvBccInner();
        OASSendMailAdvBccInner sendMailAdvBccInner4 = new OASSendMailAdvBccInner();

        System.assert(sendMailAdvBccInner1.equals(sendMailAdvBccInner2));
        System.assert(sendMailAdvBccInner3.equals(sendMailAdvBccInner4));
        System.assertEquals(sendMailAdvBccInner1.hashCode(), sendMailAdvBccInner2.hashCode());
        System.assertEquals(sendMailAdvBccInner3.hashCode(), sendMailAdvBccInner4.hashCode());
    }
}
