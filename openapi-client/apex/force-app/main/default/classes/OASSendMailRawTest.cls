@isTest
private class OASSendMailRawTest {
    @isTest
    private static void equalsSameInstance() {
        OASSendMailRaw sendMailRaw1 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw2 = sendMailRaw1;
        OASSendMailRaw sendMailRaw3 = new OASSendMailRaw();
        OASSendMailRaw sendMailRaw4 = sendMailRaw3;

        System.assert(sendMailRaw1.equals(sendMailRaw2));
        System.assert(sendMailRaw2.equals(sendMailRaw1));
        System.assert(sendMailRaw1.equals(sendMailRaw1));
        System.assert(sendMailRaw3.equals(sendMailRaw4));
        System.assert(sendMailRaw4.equals(sendMailRaw3));
        System.assert(sendMailRaw3.equals(sendMailRaw3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASSendMailRaw sendMailRaw1 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw2 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw3 = new OASSendMailRaw();
        OASSendMailRaw sendMailRaw4 = new OASSendMailRaw();

        System.assert(sendMailRaw1.equals(sendMailRaw2));
        System.assert(sendMailRaw2.equals(sendMailRaw1));
        System.assert(sendMailRaw3.equals(sendMailRaw4));
        System.assert(sendMailRaw4.equals(sendMailRaw3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASSendMailRaw sendMailRaw1 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw2 = new OASSendMailRaw();

        System.assertEquals(false, sendMailRaw1.equals('foo'));
        System.assertEquals(false, sendMailRaw2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASSendMailRaw sendMailRaw1 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw2 = new OASSendMailRaw();
        OASSendMailRaw sendMailRaw3;

        System.assertEquals(false, sendMailRaw1.equals(sendMailRaw3));
        System.assertEquals(false, sendMailRaw2.equals(sendMailRaw3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASSendMailRaw sendMailRaw1 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw2 = new OASSendMailRaw();

        System.assertEquals(sendMailRaw1.hashCode(), sendMailRaw1.hashCode());
        System.assertEquals(sendMailRaw2.hashCode(), sendMailRaw2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASSendMailRaw sendMailRaw1 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw2 = OASSendMailRaw.getExample();
        OASSendMailRaw sendMailRaw3 = new OASSendMailRaw();
        OASSendMailRaw sendMailRaw4 = new OASSendMailRaw();

        System.assert(sendMailRaw1.equals(sendMailRaw2));
        System.assert(sendMailRaw3.equals(sendMailRaw4));
        System.assertEquals(sendMailRaw1.hashCode(), sendMailRaw2.hashCode());
        System.assertEquals(sendMailRaw3.hashCode(), sendMailRaw4.hashCode());
    }

    @isTest
    private static void maintainRenamedProperties() {
        OASSendMailRaw sendMailRaw = new OASSendMailRaw();
        Map<String, String> x-property-mappings = sendMailRaw.getx-property-mappings();
        System.assertEquals('rawEmail', x-property-mappings.get('raw_email'));
    }
}
