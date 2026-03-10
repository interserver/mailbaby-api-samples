@isTest
private class OASSendMailToTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailTo sendMailTo1 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo2 = sendMailTo1;
        OASSendMailTo sendMailTo3 = new OASSendMailTo();
        OASSendMailTo sendMailTo4 = sendMailTo3;

        System.assert(sendMailTo1.equals(sendMailTo2));
        System.assert(sendMailTo2.equals(sendMailTo1));
        System.assert(sendMailTo1.equals(sendMailTo1));
        System.assert(sendMailTo3.equals(sendMailTo4));
        System.assert(sendMailTo4.equals(sendMailTo3));
        System.assert(sendMailTo3.equals(sendMailTo3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailTo sendMailTo1 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo2 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo3 = new OASSendMailTo();
        OASSendMailTo sendMailTo4 = new OASSendMailTo();

        System.assert(sendMailTo1.equals(sendMailTo2));
        System.assert(sendMailTo2.equals(sendMailTo1));
        System.assert(sendMailTo3.equals(sendMailTo4));
        System.assert(sendMailTo4.equals(sendMailTo3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailTo sendMailTo1 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo2 = new OASSendMailTo();

        System.assertEquals(false, sendMailTo1.equals('foo'));
        System.assertEquals(false, sendMailTo2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailTo sendMailTo1 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo2 = new OASSendMailTo();
        OASSendMailTo sendMailTo3;

        System.assertEquals(false, sendMailTo1.equals(sendMailTo3));
        System.assertEquals(false, sendMailTo2.equals(sendMailTo3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailTo sendMailTo1 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo2 = new OASSendMailTo();

        System.assertEquals(sendMailTo1.hashCode(), sendMailTo1.hashCode());
        System.assertEquals(sendMailTo2.hashCode(), sendMailTo2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailTo sendMailTo1 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo2 = OASSendMailTo.getExample();
        OASSendMailTo sendMailTo3 = new OASSendMailTo();
        OASSendMailTo sendMailTo4 = new OASSendMailTo();

        System.assert(sendMailTo1.equals(sendMailTo2));
        System.assert(sendMailTo3.equals(sendMailTo4));
        System.assertEquals(sendMailTo1.hashCode(), sendMailTo2.hashCode());
        System.assertEquals(sendMailTo3.hashCode(), sendMailTo4.hashCode());
    }
}
