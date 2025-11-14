@isTest
private class OASRawMailTest {
    @isTest
    private static void equalsSameInstance() {
        OASRawMail rawMail1 = OASRawMail.getExample();
        OASRawMail rawMail2 = rawMail1;
        OASRawMail rawMail3 = new OASRawMail();
        OASRawMail rawMail4 = rawMail3;

        System.assert(rawMail1.equals(rawMail2));
        System.assert(rawMail2.equals(rawMail1));
        System.assert(rawMail1.equals(rawMail1));
        System.assert(rawMail3.equals(rawMail4));
        System.assert(rawMail4.equals(rawMail3));
        System.assert(rawMail3.equals(rawMail3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASRawMail rawMail1 = OASRawMail.getExample();
        OASRawMail rawMail2 = OASRawMail.getExample();
        OASRawMail rawMail3 = new OASRawMail();
        OASRawMail rawMail4 = new OASRawMail();

        System.assert(rawMail1.equals(rawMail2));
        System.assert(rawMail2.equals(rawMail1));
        System.assert(rawMail3.equals(rawMail4));
        System.assert(rawMail4.equals(rawMail3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASRawMail rawMail1 = OASRawMail.getExample();
        OASRawMail rawMail2 = new OASRawMail();

        System.assertEquals(false, rawMail1.equals('foo'));
        System.assertEquals(false, rawMail2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASRawMail rawMail1 = OASRawMail.getExample();
        OASRawMail rawMail2 = new OASRawMail();
        OASRawMail rawMail3;

        System.assertEquals(false, rawMail1.equals(rawMail3));
        System.assertEquals(false, rawMail2.equals(rawMail3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASRawMail rawMail1 = OASRawMail.getExample();
        OASRawMail rawMail2 = new OASRawMail();

        System.assertEquals(rawMail1.hashCode(), rawMail1.hashCode());
        System.assertEquals(rawMail2.hashCode(), rawMail2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASRawMail rawMail1 = OASRawMail.getExample();
        OASRawMail rawMail2 = OASRawMail.getExample();
        OASRawMail rawMail3 = new OASRawMail();
        OASRawMail rawMail4 = new OASRawMail();

        System.assert(rawMail1.equals(rawMail2));
        System.assert(rawMail3.equals(rawMail4));
        System.assertEquals(rawMail1.hashCode(), rawMail2.hashCode());
        System.assertEquals(rawMail3.hashCode(), rawMail4.hashCode());
    }

    @isTest
    private static void maintainRenamedProperties() {
        OASRawMail rawMail = new OASRawMail();
        Map<String, String> x-property-mappings = rawMail.getx-property-mappings();
        System.assertEquals('rawEmail', x-property-mappings.get('raw_email'));
    }
}
