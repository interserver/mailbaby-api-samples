@isTest
private class OASBody1Test {
    @isTest
    private static void equalsSameInstance() {
        OASBody1 body11 = OASBody1.getExample();
        OASBody1 body12 = body11;
        OASBody1 body13 = new OASBody1();
        OASBody1 body14 = body13;

        System.assert(body11.equals(body12));
        System.assert(body12.equals(body11));
        System.assert(body11.equals(body11));
        System.assert(body13.equals(body14));
        System.assert(body14.equals(body13));
        System.assert(body13.equals(body13));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASBody1 body11 = OASBody1.getExample();
        OASBody1 body12 = OASBody1.getExample();
        OASBody1 body13 = new OASBody1();
        OASBody1 body14 = new OASBody1();

        System.assert(body11.equals(body12));
        System.assert(body12.equals(body11));
        System.assert(body13.equals(body14));
        System.assert(body14.equals(body13));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASBody1 body11 = OASBody1.getExample();
        OASBody1 body12 = new OASBody1();

        System.assertEquals(false, body11.equals('foo'));
        System.assertEquals(false, body12.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASBody1 body11 = OASBody1.getExample();
        OASBody1 body12 = new OASBody1();
        OASBody1 body13;

        System.assertEquals(false, body11.equals(body13));
        System.assertEquals(false, body12.equals(body13));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASBody1 body11 = OASBody1.getExample();
        OASBody1 body12 = new OASBody1();

        System.assertEquals(body11.hashCode(), body11.hashCode());
        System.assertEquals(body12.hashCode(), body12.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASBody1 body11 = OASBody1.getExample();
        OASBody1 body12 = OASBody1.getExample();
        OASBody1 body13 = new OASBody1();
        OASBody1 body14 = new OASBody1();

        System.assert(body11.equals(body12));
        System.assert(body13.equals(body14));
        System.assertEquals(body11.hashCode(), body12.hashCode());
        System.assertEquals(body13.hashCode(), body14.hashCode());
    }

    @isTest
    private static void maintainRenamedProperties() {
        OASBody1 body1 = new OASBody1();
        Map<String, String> x-property-mappings = body1.getx-property-mappings();
        System.assertEquals('r_from', x-property-mappings.get('from'));
    }
}
