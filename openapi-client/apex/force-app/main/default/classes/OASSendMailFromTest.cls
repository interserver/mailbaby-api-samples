@isTest
private class OASSendMailFromTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailFrom sendMailFrom1 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom2 = sendMailFrom1;
        OASSendMailFrom sendMailFrom3 = new OASSendMailFrom();
        OASSendMailFrom sendMailFrom4 = sendMailFrom3;

        System.assert(sendMailFrom1.equals(sendMailFrom2));
        System.assert(sendMailFrom2.equals(sendMailFrom1));
        System.assert(sendMailFrom1.equals(sendMailFrom1));
        System.assert(sendMailFrom3.equals(sendMailFrom4));
        System.assert(sendMailFrom4.equals(sendMailFrom3));
        System.assert(sendMailFrom3.equals(sendMailFrom3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailFrom sendMailFrom1 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom2 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom3 = new OASSendMailFrom();
        OASSendMailFrom sendMailFrom4 = new OASSendMailFrom();

        System.assert(sendMailFrom1.equals(sendMailFrom2));
        System.assert(sendMailFrom2.equals(sendMailFrom1));
        System.assert(sendMailFrom3.equals(sendMailFrom4));
        System.assert(sendMailFrom4.equals(sendMailFrom3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailFrom sendMailFrom1 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom2 = new OASSendMailFrom();

        System.assertEquals(false, sendMailFrom1.equals('foo'));
        System.assertEquals(false, sendMailFrom2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailFrom sendMailFrom1 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom2 = new OASSendMailFrom();
        OASSendMailFrom sendMailFrom3;

        System.assertEquals(false, sendMailFrom1.equals(sendMailFrom3));
        System.assertEquals(false, sendMailFrom2.equals(sendMailFrom3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailFrom sendMailFrom1 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom2 = new OASSendMailFrom();

        System.assertEquals(sendMailFrom1.hashCode(), sendMailFrom1.hashCode());
        System.assertEquals(sendMailFrom2.hashCode(), sendMailFrom2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailFrom sendMailFrom1 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom2 = OASSendMailFrom.getExample();
        OASSendMailFrom sendMailFrom3 = new OASSendMailFrom();
        OASSendMailFrom sendMailFrom4 = new OASSendMailFrom();

        System.assert(sendMailFrom1.equals(sendMailFrom2));
        System.assert(sendMailFrom3.equals(sendMailFrom4));
        System.assertEquals(sendMailFrom1.hashCode(), sendMailFrom2.hashCode());
        System.assertEquals(sendMailFrom3.hashCode(), sendMailFrom4.hashCode());
    }
}
