@isTest
private class OASDateOrTimestampTest {
    @isTest
    private static void equalsSameInstance() {
        OASDateOrTimestamp dateOrTimestamp1 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp2 = dateOrTimestamp1;
        OASDateOrTimestamp dateOrTimestamp3 = new OASDateOrTimestamp();
        OASDateOrTimestamp dateOrTimestamp4 = dateOrTimestamp3;

        System.assert(dateOrTimestamp1.equals(dateOrTimestamp2));
        System.assert(dateOrTimestamp2.equals(dateOrTimestamp1));
        System.assert(dateOrTimestamp1.equals(dateOrTimestamp1));
        System.assert(dateOrTimestamp3.equals(dateOrTimestamp4));
        System.assert(dateOrTimestamp4.equals(dateOrTimestamp3));
        System.assert(dateOrTimestamp3.equals(dateOrTimestamp3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASDateOrTimestamp dateOrTimestamp1 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp2 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp3 = new OASDateOrTimestamp();
        OASDateOrTimestamp dateOrTimestamp4 = new OASDateOrTimestamp();

        System.assert(dateOrTimestamp1.equals(dateOrTimestamp2));
        System.assert(dateOrTimestamp2.equals(dateOrTimestamp1));
        System.assert(dateOrTimestamp3.equals(dateOrTimestamp4));
        System.assert(dateOrTimestamp4.equals(dateOrTimestamp3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASDateOrTimestamp dateOrTimestamp1 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp2 = new OASDateOrTimestamp();

        System.assertEquals(false, dateOrTimestamp1.equals('foo'));
        System.assertEquals(false, dateOrTimestamp2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASDateOrTimestamp dateOrTimestamp1 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp2 = new OASDateOrTimestamp();
        OASDateOrTimestamp dateOrTimestamp3;

        System.assertEquals(false, dateOrTimestamp1.equals(dateOrTimestamp3));
        System.assertEquals(false, dateOrTimestamp2.equals(dateOrTimestamp3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASDateOrTimestamp dateOrTimestamp1 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp2 = new OASDateOrTimestamp();

        System.assertEquals(dateOrTimestamp1.hashCode(), dateOrTimestamp1.hashCode());
        System.assertEquals(dateOrTimestamp2.hashCode(), dateOrTimestamp2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASDateOrTimestamp dateOrTimestamp1 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp2 = OASDateOrTimestamp.getExample();
        OASDateOrTimestamp dateOrTimestamp3 = new OASDateOrTimestamp();
        OASDateOrTimestamp dateOrTimestamp4 = new OASDateOrTimestamp();

        System.assert(dateOrTimestamp1.equals(dateOrTimestamp2));
        System.assert(dateOrTimestamp3.equals(dateOrTimestamp4));
        System.assertEquals(dateOrTimestamp1.hashCode(), dateOrTimestamp2.hashCode());
        System.assertEquals(dateOrTimestamp3.hashCode(), dateOrTimestamp4.hashCode());
    }
}
