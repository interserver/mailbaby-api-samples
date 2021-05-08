@isTest
private class OASInlineResponse401Test {
    @isTest
    private static void equalsSameInstance() {
        OASInlineResponse401 inlineResponse4011 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4012 = inlineResponse4011;
        OASInlineResponse401 inlineResponse4013 = new OASInlineResponse401();
        OASInlineResponse401 inlineResponse4014 = inlineResponse4013;

        System.assert(inlineResponse4011.equals(inlineResponse4012));
        System.assert(inlineResponse4012.equals(inlineResponse4011));
        System.assert(inlineResponse4011.equals(inlineResponse4011));
        System.assert(inlineResponse4013.equals(inlineResponse4014));
        System.assert(inlineResponse4014.equals(inlineResponse4013));
        System.assert(inlineResponse4013.equals(inlineResponse4013));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASInlineResponse401 inlineResponse4011 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4012 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4013 = new OASInlineResponse401();
        OASInlineResponse401 inlineResponse4014 = new OASInlineResponse401();

        System.assert(inlineResponse4011.equals(inlineResponse4012));
        System.assert(inlineResponse4012.equals(inlineResponse4011));
        System.assert(inlineResponse4013.equals(inlineResponse4014));
        System.assert(inlineResponse4014.equals(inlineResponse4013));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASInlineResponse401 inlineResponse4011 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4012 = new OASInlineResponse401();

        System.assertEquals(false, inlineResponse4011.equals('foo'));
        System.assertEquals(false, inlineResponse4012.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASInlineResponse401 inlineResponse4011 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4012 = new OASInlineResponse401();
        OASInlineResponse401 inlineResponse4013;

        System.assertEquals(false, inlineResponse4011.equals(inlineResponse4013));
        System.assertEquals(false, inlineResponse4012.equals(inlineResponse4013));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASInlineResponse401 inlineResponse4011 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4012 = new OASInlineResponse401();

        System.assertEquals(inlineResponse4011.hashCode(), inlineResponse4011.hashCode());
        System.assertEquals(inlineResponse4012.hashCode(), inlineResponse4012.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASInlineResponse401 inlineResponse4011 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4012 = OASInlineResponse401.getExample();
        OASInlineResponse401 inlineResponse4013 = new OASInlineResponse401();
        OASInlineResponse401 inlineResponse4014 = new OASInlineResponse401();

        System.assert(inlineResponse4011.equals(inlineResponse4012));
        System.assert(inlineResponse4013.equals(inlineResponse4014));
        System.assertEquals(inlineResponse4011.hashCode(), inlineResponse4012.hashCode());
        System.assertEquals(inlineResponse4013.hashCode(), inlineResponse4014.hashCode());
    }
}
