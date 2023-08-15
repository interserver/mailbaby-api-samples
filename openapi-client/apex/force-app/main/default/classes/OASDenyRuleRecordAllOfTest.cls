@isTest
private class OASDenyRuleRecordAllOfTest {
    @isTest
    private static void equalsSameInstance() {
        OASDenyRuleRecordAllOf denyRuleRecordAllOf1 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf2 = denyRuleRecordAllOf1;
        OASDenyRuleRecordAllOf denyRuleRecordAllOf3 = new OASDenyRuleRecordAllOf();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf4 = denyRuleRecordAllOf3;

        System.assert(denyRuleRecordAllOf1.equals(denyRuleRecordAllOf2));
        System.assert(denyRuleRecordAllOf2.equals(denyRuleRecordAllOf1));
        System.assert(denyRuleRecordAllOf1.equals(denyRuleRecordAllOf1));
        System.assert(denyRuleRecordAllOf3.equals(denyRuleRecordAllOf4));
        System.assert(denyRuleRecordAllOf4.equals(denyRuleRecordAllOf3));
        System.assert(denyRuleRecordAllOf3.equals(denyRuleRecordAllOf3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASDenyRuleRecordAllOf denyRuleRecordAllOf1 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf2 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf3 = new OASDenyRuleRecordAllOf();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf4 = new OASDenyRuleRecordAllOf();

        System.assert(denyRuleRecordAllOf1.equals(denyRuleRecordAllOf2));
        System.assert(denyRuleRecordAllOf2.equals(denyRuleRecordAllOf1));
        System.assert(denyRuleRecordAllOf3.equals(denyRuleRecordAllOf4));
        System.assert(denyRuleRecordAllOf4.equals(denyRuleRecordAllOf3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASDenyRuleRecordAllOf denyRuleRecordAllOf1 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf2 = new OASDenyRuleRecordAllOf();

        System.assertEquals(false, denyRuleRecordAllOf1.equals('foo'));
        System.assertEquals(false, denyRuleRecordAllOf2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASDenyRuleRecordAllOf denyRuleRecordAllOf1 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf2 = new OASDenyRuleRecordAllOf();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf3;

        System.assertEquals(false, denyRuleRecordAllOf1.equals(denyRuleRecordAllOf3));
        System.assertEquals(false, denyRuleRecordAllOf2.equals(denyRuleRecordAllOf3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASDenyRuleRecordAllOf denyRuleRecordAllOf1 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf2 = new OASDenyRuleRecordAllOf();

        System.assertEquals(denyRuleRecordAllOf1.hashCode(), denyRuleRecordAllOf1.hashCode());
        System.assertEquals(denyRuleRecordAllOf2.hashCode(), denyRuleRecordAllOf2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASDenyRuleRecordAllOf denyRuleRecordAllOf1 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf2 = OASDenyRuleRecordAllOf.getExample();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf3 = new OASDenyRuleRecordAllOf();
        OASDenyRuleRecordAllOf denyRuleRecordAllOf4 = new OASDenyRuleRecordAllOf();

        System.assert(denyRuleRecordAllOf1.equals(denyRuleRecordAllOf2));
        System.assert(denyRuleRecordAllOf3.equals(denyRuleRecordAllOf4));
        System.assertEquals(denyRuleRecordAllOf1.hashCode(), denyRuleRecordAllOf2.hashCode());
        System.assertEquals(denyRuleRecordAllOf3.hashCode(), denyRuleRecordAllOf4.hashCode());
    }
}
