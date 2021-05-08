@isTest
private class OASSendMailAdvFromTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailAdvFrom sendMailAdvFrom1 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom2 = sendMailAdvFrom1;
        OASSendMailAdvFrom sendMailAdvFrom3 = new OASSendMailAdvFrom();
        OASSendMailAdvFrom sendMailAdvFrom4 = sendMailAdvFrom3;

        System.assert(sendMailAdvFrom1.equals(sendMailAdvFrom2));
        System.assert(sendMailAdvFrom2.equals(sendMailAdvFrom1));
        System.assert(sendMailAdvFrom1.equals(sendMailAdvFrom1));
        System.assert(sendMailAdvFrom3.equals(sendMailAdvFrom4));
        System.assert(sendMailAdvFrom4.equals(sendMailAdvFrom3));
        System.assert(sendMailAdvFrom3.equals(sendMailAdvFrom3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailAdvFrom sendMailAdvFrom1 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom2 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom3 = new OASSendMailAdvFrom();
        OASSendMailAdvFrom sendMailAdvFrom4 = new OASSendMailAdvFrom();

        System.assert(sendMailAdvFrom1.equals(sendMailAdvFrom2));
        System.assert(sendMailAdvFrom2.equals(sendMailAdvFrom1));
        System.assert(sendMailAdvFrom3.equals(sendMailAdvFrom4));
        System.assert(sendMailAdvFrom4.equals(sendMailAdvFrom3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailAdvFrom sendMailAdvFrom1 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom2 = new OASSendMailAdvFrom();

        System.assertEquals(false, sendMailAdvFrom1.equals('foo'));
        System.assertEquals(false, sendMailAdvFrom2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailAdvFrom sendMailAdvFrom1 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom2 = new OASSendMailAdvFrom();
        OASSendMailAdvFrom sendMailAdvFrom3;

        System.assertEquals(false, sendMailAdvFrom1.equals(sendMailAdvFrom3));
        System.assertEquals(false, sendMailAdvFrom2.equals(sendMailAdvFrom3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailAdvFrom sendMailAdvFrom1 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom2 = new OASSendMailAdvFrom();

        System.assertEquals(sendMailAdvFrom1.hashCode(), sendMailAdvFrom1.hashCode());
        System.assertEquals(sendMailAdvFrom2.hashCode(), sendMailAdvFrom2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailAdvFrom sendMailAdvFrom1 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom2 = OASSendMailAdvFrom.getExample();
        OASSendMailAdvFrom sendMailAdvFrom3 = new OASSendMailAdvFrom();
        OASSendMailAdvFrom sendMailAdvFrom4 = new OASSendMailAdvFrom();

        System.assert(sendMailAdvFrom1.equals(sendMailAdvFrom2));
        System.assert(sendMailAdvFrom3.equals(sendMailAdvFrom4));
        System.assertEquals(sendMailAdvFrom1.hashCode(), sendMailAdvFrom2.hashCode());
        System.assertEquals(sendMailAdvFrom3.hashCode(), sendMailAdvFrom4.hashCode());
    }
}
