@isTest
private class OASMailStatsVolumeTest {
    @isTest
    private static void equalsSameInstance() {
        OASMailStatsVolume mailStatsVolume1 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume2 = mailStatsVolume1;
        OASMailStatsVolume mailStatsVolume3 = new OASMailStatsVolume();
        OASMailStatsVolume mailStatsVolume4 = mailStatsVolume3;

        System.assert(mailStatsVolume1.equals(mailStatsVolume2));
        System.assert(mailStatsVolume2.equals(mailStatsVolume1));
        System.assert(mailStatsVolume1.equals(mailStatsVolume1));
        System.assert(mailStatsVolume3.equals(mailStatsVolume4));
        System.assert(mailStatsVolume4.equals(mailStatsVolume3));
        System.assert(mailStatsVolume3.equals(mailStatsVolume3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASMailStatsVolume mailStatsVolume1 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume2 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume3 = new OASMailStatsVolume();
        OASMailStatsVolume mailStatsVolume4 = new OASMailStatsVolume();

        System.assert(mailStatsVolume1.equals(mailStatsVolume2));
        System.assert(mailStatsVolume2.equals(mailStatsVolume1));
        System.assert(mailStatsVolume3.equals(mailStatsVolume4));
        System.assert(mailStatsVolume4.equals(mailStatsVolume3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASMailStatsVolume mailStatsVolume1 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume2 = new OASMailStatsVolume();

        System.assertEquals(false, mailStatsVolume1.equals('foo'));
        System.assertEquals(false, mailStatsVolume2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASMailStatsVolume mailStatsVolume1 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume2 = new OASMailStatsVolume();
        OASMailStatsVolume mailStatsVolume3;

        System.assertEquals(false, mailStatsVolume1.equals(mailStatsVolume3));
        System.assertEquals(false, mailStatsVolume2.equals(mailStatsVolume3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASMailStatsVolume mailStatsVolume1 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume2 = new OASMailStatsVolume();

        System.assertEquals(mailStatsVolume1.hashCode(), mailStatsVolume1.hashCode());
        System.assertEquals(mailStatsVolume2.hashCode(), mailStatsVolume2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASMailStatsVolume mailStatsVolume1 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume2 = OASMailStatsVolume.getExample();
        OASMailStatsVolume mailStatsVolume3 = new OASMailStatsVolume();
        OASMailStatsVolume mailStatsVolume4 = new OASMailStatsVolume();

        System.assert(mailStatsVolume1.equals(mailStatsVolume2));
        System.assert(mailStatsVolume3.equals(mailStatsVolume4));
        System.assertEquals(mailStatsVolume1.hashCode(), mailStatsVolume2.hashCode());
        System.assertEquals(mailStatsVolume3.hashCode(), mailStatsVolume4.hashCode());
    }

    @isTest
    private static void maintainRenamedProperties() {
        OASMailStatsVolume mailStatsVolume = new OASMailStatsVolume();
        Map<String, String> x-property-mappings = mailStatsVolume.getx-property-mappings();
        System.assertEquals('r_from', x-property-mappings.get('from'));
    }

    @isTest
    private static void defaultValuesPopulated() {
        OASMailStatsVolume mailStatsVolume = new OASMailStatsVolume();
        System.assertEquals(new Map<String, Integer>(), mailStatsVolume.to);
        System.assertEquals(new Map<String, Integer>(), mailStatsVolume.r_from);
        System.assertEquals(new Map<String, Integer>(), mailStatsVolume.ip);
    }
}
