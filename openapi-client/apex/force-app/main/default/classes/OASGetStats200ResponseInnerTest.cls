@isTest
private class OASGetStats200ResponseInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASGetStats200ResponseInner getStats200ResponseInner1 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner2 = getStats200ResponseInner1;
        OASGetStats200ResponseInner getStats200ResponseInner3 = new OASGetStats200ResponseInner();
        OASGetStats200ResponseInner getStats200ResponseInner4 = getStats200ResponseInner3;

        System.assert(getStats200ResponseInner1.equals(getStats200ResponseInner2));
        System.assert(getStats200ResponseInner2.equals(getStats200ResponseInner1));
        System.assert(getStats200ResponseInner1.equals(getStats200ResponseInner1));
        System.assert(getStats200ResponseInner3.equals(getStats200ResponseInner4));
        System.assert(getStats200ResponseInner4.equals(getStats200ResponseInner3));
        System.assert(getStats200ResponseInner3.equals(getStats200ResponseInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASGetStats200ResponseInner getStats200ResponseInner1 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner2 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner3 = new OASGetStats200ResponseInner();
        OASGetStats200ResponseInner getStats200ResponseInner4 = new OASGetStats200ResponseInner();

        System.assert(getStats200ResponseInner1.equals(getStats200ResponseInner2));
        System.assert(getStats200ResponseInner2.equals(getStats200ResponseInner1));
        System.assert(getStats200ResponseInner3.equals(getStats200ResponseInner4));
        System.assert(getStats200ResponseInner4.equals(getStats200ResponseInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASGetStats200ResponseInner getStats200ResponseInner1 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner2 = new OASGetStats200ResponseInner();

        System.assertEquals(false, getStats200ResponseInner1.equals('foo'));
        System.assertEquals(false, getStats200ResponseInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASGetStats200ResponseInner getStats200ResponseInner1 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner2 = new OASGetStats200ResponseInner();
        OASGetStats200ResponseInner getStats200ResponseInner3;

        System.assertEquals(false, getStats200ResponseInner1.equals(getStats200ResponseInner3));
        System.assertEquals(false, getStats200ResponseInner2.equals(getStats200ResponseInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASGetStats200ResponseInner getStats200ResponseInner1 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner2 = new OASGetStats200ResponseInner();

        System.assertEquals(getStats200ResponseInner1.hashCode(), getStats200ResponseInner1.hashCode());
        System.assertEquals(getStats200ResponseInner2.hashCode(), getStats200ResponseInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASGetStats200ResponseInner getStats200ResponseInner1 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner2 = OASGetStats200ResponseInner.getExample();
        OASGetStats200ResponseInner getStats200ResponseInner3 = new OASGetStats200ResponseInner();
        OASGetStats200ResponseInner getStats200ResponseInner4 = new OASGetStats200ResponseInner();

        System.assert(getStats200ResponseInner1.equals(getStats200ResponseInner2));
        System.assert(getStats200ResponseInner3.equals(getStats200ResponseInner4));
        System.assertEquals(getStats200ResponseInner1.hashCode(), getStats200ResponseInner2.hashCode());
        System.assertEquals(getStats200ResponseInner3.hashCode(), getStats200ResponseInner4.hashCode());
    }
}
