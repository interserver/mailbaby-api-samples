@isTest
private class OASMailOrderDetailTest {
    @isTest
    private static void equalsSameInstance() {
        OASMailOrderDetail mailOrderDetail1 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail2 = mailOrderDetail1;
        OASMailOrderDetail mailOrderDetail3 = new OASMailOrderDetail();
        OASMailOrderDetail mailOrderDetail4 = mailOrderDetail3;

        System.assert(mailOrderDetail1.equals(mailOrderDetail2));
        System.assert(mailOrderDetail2.equals(mailOrderDetail1));
        System.assert(mailOrderDetail1.equals(mailOrderDetail1));
        System.assert(mailOrderDetail3.equals(mailOrderDetail4));
        System.assert(mailOrderDetail4.equals(mailOrderDetail3));
        System.assert(mailOrderDetail3.equals(mailOrderDetail3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASMailOrderDetail mailOrderDetail1 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail2 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail3 = new OASMailOrderDetail();
        OASMailOrderDetail mailOrderDetail4 = new OASMailOrderDetail();

        System.assert(mailOrderDetail1.equals(mailOrderDetail2));
        System.assert(mailOrderDetail2.equals(mailOrderDetail1));
        System.assert(mailOrderDetail3.equals(mailOrderDetail4));
        System.assert(mailOrderDetail4.equals(mailOrderDetail3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASMailOrderDetail mailOrderDetail1 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail2 = new OASMailOrderDetail();

        System.assertEquals(false, mailOrderDetail1.equals('foo'));
        System.assertEquals(false, mailOrderDetail2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASMailOrderDetail mailOrderDetail1 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail2 = new OASMailOrderDetail();
        OASMailOrderDetail mailOrderDetail3;

        System.assertEquals(false, mailOrderDetail1.equals(mailOrderDetail3));
        System.assertEquals(false, mailOrderDetail2.equals(mailOrderDetail3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASMailOrderDetail mailOrderDetail1 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail2 = new OASMailOrderDetail();

        System.assertEquals(mailOrderDetail1.hashCode(), mailOrderDetail1.hashCode());
        System.assertEquals(mailOrderDetail2.hashCode(), mailOrderDetail2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASMailOrderDetail mailOrderDetail1 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail2 = OASMailOrderDetail.getExample();
        OASMailOrderDetail mailOrderDetail3 = new OASMailOrderDetail();
        OASMailOrderDetail mailOrderDetail4 = new OASMailOrderDetail();

        System.assert(mailOrderDetail1.equals(mailOrderDetail2));
        System.assert(mailOrderDetail3.equals(mailOrderDetail4));
        System.assertEquals(mailOrderDetail1.hashCode(), mailOrderDetail2.hashCode());
        System.assertEquals(mailOrderDetail3.hashCode(), mailOrderDetail4.hashCode());
    }
}
