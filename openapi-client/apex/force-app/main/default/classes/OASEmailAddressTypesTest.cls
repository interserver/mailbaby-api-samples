@isTest
private class OASEmailAddressTypesTest {
    @isTest
    private static void equalsSameInstance() {
        OASEmailAddressTypes emailAddressTypes1 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes2 = emailAddressTypes1;
        OASEmailAddressTypes emailAddressTypes3 = new OASEmailAddressTypes();
        OASEmailAddressTypes emailAddressTypes4 = emailAddressTypes3;

        System.assert(emailAddressTypes1.equals(emailAddressTypes2));
        System.assert(emailAddressTypes2.equals(emailAddressTypes1));
        System.assert(emailAddressTypes1.equals(emailAddressTypes1));
        System.assert(emailAddressTypes3.equals(emailAddressTypes4));
        System.assert(emailAddressTypes4.equals(emailAddressTypes3));
        System.assert(emailAddressTypes3.equals(emailAddressTypes3));
    }

    @isTest
    private static void equalsIdenticalInstance() {
        OASEmailAddressTypes emailAddressTypes1 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes2 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes3 = new OASEmailAddressTypes();
        OASEmailAddressTypes emailAddressTypes4 = new OASEmailAddressTypes();

        System.assert(emailAddressTypes1.equals(emailAddressTypes2));
        System.assert(emailAddressTypes2.equals(emailAddressTypes1));
        System.assert(emailAddressTypes3.equals(emailAddressTypes4));
        System.assert(emailAddressTypes4.equals(emailAddressTypes3));
    }

    @isTest
    private static void notEqualsDifferentType() {
        OASEmailAddressTypes emailAddressTypes1 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes2 = new OASEmailAddressTypes();

        System.assertEquals(false, emailAddressTypes1.equals('foo'));
        System.assertEquals(false, emailAddressTypes2.equals('foo'));
    }

    @isTest
    private static void notEqualsNull() {
        OASEmailAddressTypes emailAddressTypes1 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes2 = new OASEmailAddressTypes();
        OASEmailAddressTypes emailAddressTypes3;

        System.assertEquals(false, emailAddressTypes1.equals(emailAddressTypes3));
        System.assertEquals(false, emailAddressTypes2.equals(emailAddressTypes3));
    }

    @isTest
    private static void consistentHashCodeValue() {
        OASEmailAddressTypes emailAddressTypes1 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes2 = new OASEmailAddressTypes();

        System.assertEquals(emailAddressTypes1.hashCode(), emailAddressTypes1.hashCode());
        System.assertEquals(emailAddressTypes2.hashCode(), emailAddressTypes2.hashCode());
    }

    @isTest
    private static void equalInstancesHaveSameHashCode() {
        OASEmailAddressTypes emailAddressTypes1 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes2 = OASEmailAddressTypes.getExample();
        OASEmailAddressTypes emailAddressTypes3 = new OASEmailAddressTypes();
        OASEmailAddressTypes emailAddressTypes4 = new OASEmailAddressTypes();

        System.assert(emailAddressTypes1.equals(emailAddressTypes2));
        System.assert(emailAddressTypes3.equals(emailAddressTypes4));
        System.assertEquals(emailAddressTypes1.hashCode(), emailAddressTypes2.hashCode());
        System.assertEquals(emailAddressTypes3.hashCode(), emailAddressTypes4.hashCode());
    }
}
