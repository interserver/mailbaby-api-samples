@isTest
private class OASGetMailOrders401ResponseTest {
    @isTest
    private static void equalsSameInstance() {
        OASGetMailOrders401Response getMailOrders401Response1 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response2 = getMailOrders401Response1;
        OASGetMailOrders401Response getMailOrders401Response3 = new OASGetMailOrders401Response();
        OASGetMailOrders401Response getMailOrders401Response4 = getMailOrders401Response3;

        System.assert(getMailOrders401Response1.equals(getMailOrders401Response2));
        System.assert(getMailOrders401Response2.equals(getMailOrders401Response1));
        System.assert(getMailOrders401Response1.equals(getMailOrders401Response1));
        System.assert(getMailOrders401Response3.equals(getMailOrders401Response4));
        System.assert(getMailOrders401Response4.equals(getMailOrders401Response3));
        System.assert(getMailOrders401Response3.equals(getMailOrders401Response3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASGetMailOrders401Response getMailOrders401Response1 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response2 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response3 = new OASGetMailOrders401Response();
        OASGetMailOrders401Response getMailOrders401Response4 = new OASGetMailOrders401Response();

        System.assert(getMailOrders401Response1.equals(getMailOrders401Response2));
        System.assert(getMailOrders401Response2.equals(getMailOrders401Response1));
        System.assert(getMailOrders401Response3.equals(getMailOrders401Response4));
        System.assert(getMailOrders401Response4.equals(getMailOrders401Response3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASGetMailOrders401Response getMailOrders401Response1 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response2 = new OASGetMailOrders401Response();

        System.assertEquals(false, getMailOrders401Response1.equals('foo'));
        System.assertEquals(false, getMailOrders401Response2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASGetMailOrders401Response getMailOrders401Response1 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response2 = new OASGetMailOrders401Response();
        OASGetMailOrders401Response getMailOrders401Response3;

        System.assertEquals(false, getMailOrders401Response1.equals(getMailOrders401Response3));
        System.assertEquals(false, getMailOrders401Response2.equals(getMailOrders401Response3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASGetMailOrders401Response getMailOrders401Response1 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response2 = new OASGetMailOrders401Response();

        System.assertEquals(getMailOrders401Response1.hashCode(), getMailOrders401Response1.hashCode());
        System.assertEquals(getMailOrders401Response2.hashCode(), getMailOrders401Response2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASGetMailOrders401Response getMailOrders401Response1 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response2 = OASGetMailOrders401Response.getExample();
        OASGetMailOrders401Response getMailOrders401Response3 = new OASGetMailOrders401Response();
        OASGetMailOrders401Response getMailOrders401Response4 = new OASGetMailOrders401Response();

        System.assert(getMailOrders401Response1.equals(getMailOrders401Response2));
        System.assert(getMailOrders401Response3.equals(getMailOrders401Response4));
        System.assertEquals(getMailOrders401Response1.hashCode(), getMailOrders401Response2.hashCode());
        System.assertEquals(getMailOrders401Response3.hashCode(), getMailOrders401Response4.hashCode());
    }
}
