@isTest
private class OASGetMailOrders200ResponseInnerTest {
    @isTest
    private static void equalsSameInstance() {
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner1 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner2 = getMailOrders200ResponseInner1;
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner3 = new OASGetMailOrders200ResponseInner();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner4 = getMailOrders200ResponseInner3;

        System.assert(getMailOrders200ResponseInner1.equals(getMailOrders200ResponseInner2));
        System.assert(getMailOrders200ResponseInner2.equals(getMailOrders200ResponseInner1));
        System.assert(getMailOrders200ResponseInner1.equals(getMailOrders200ResponseInner1));
        System.assert(getMailOrders200ResponseInner3.equals(getMailOrders200ResponseInner4));
        System.assert(getMailOrders200ResponseInner4.equals(getMailOrders200ResponseInner3));
        System.assert(getMailOrders200ResponseInner3.equals(getMailOrders200ResponseInner3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner1 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner2 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner3 = new OASGetMailOrders200ResponseInner();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner4 = new OASGetMailOrders200ResponseInner();

        System.assert(getMailOrders200ResponseInner1.equals(getMailOrders200ResponseInner2));
        System.assert(getMailOrders200ResponseInner2.equals(getMailOrders200ResponseInner1));
        System.assert(getMailOrders200ResponseInner3.equals(getMailOrders200ResponseInner4));
        System.assert(getMailOrders200ResponseInner4.equals(getMailOrders200ResponseInner3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner1 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner2 = new OASGetMailOrders200ResponseInner();

        System.assertEquals(false, getMailOrders200ResponseInner1.equals('foo'));
        System.assertEquals(false, getMailOrders200ResponseInner2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner1 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner2 = new OASGetMailOrders200ResponseInner();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner3;

        System.assertEquals(false, getMailOrders200ResponseInner1.equals(getMailOrders200ResponseInner3));
        System.assertEquals(false, getMailOrders200ResponseInner2.equals(getMailOrders200ResponseInner3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner1 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner2 = new OASGetMailOrders200ResponseInner();

        System.assertEquals(getMailOrders200ResponseInner1.hashCode(), getMailOrders200ResponseInner1.hashCode());
        System.assertEquals(getMailOrders200ResponseInner2.hashCode(), getMailOrders200ResponseInner2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner1 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner2 = OASGetMailOrders200ResponseInner.getExample();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner3 = new OASGetMailOrders200ResponseInner();
        OASGetMailOrders200ResponseInner getMailOrders200ResponseInner4 = new OASGetMailOrders200ResponseInner();

        System.assert(getMailOrders200ResponseInner1.equals(getMailOrders200ResponseInner2));
        System.assert(getMailOrders200ResponseInner3.equals(getMailOrders200ResponseInner4));
        System.assertEquals(getMailOrders200ResponseInner1.hashCode(), getMailOrders200ResponseInner2.hashCode());
        System.assertEquals(getMailOrders200ResponseInner3.hashCode(), getMailOrders200ResponseInner4.hashCode());
    }
}
